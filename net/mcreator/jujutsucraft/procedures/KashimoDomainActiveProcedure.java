package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class KashimoDomainActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_target;
         double y_target;
         double z_target;
         double dis;
         double num1;
         double power;
         double num3;
         double num2;
         double range;
         double var10000;
         label243: {
            boolean logic_attack = false;
            boolean logic_a = false;
            double repeat_num = (double)0.0F;
            double y_pos_test = (double)0.0F;
            x_target = (double)0.0F;
            double old_skill = (double)0.0F;
            range = (double)0.0F;
            double x_pos = (double)0.0F;
            y_target = (double)0.0F;
            z_target = (double)0.0F;
            dis = (double)0.0F;
            double x_pos_test = (double)0.0F;
            double x_power = (double)0.0F;
            num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            power = (double)0.0F;
            double num4 = (double)0.0F;
            num3 = (double)0.0F;
            double energy = (double)0.0F;
            num2 = (double)0.0F;
            double z_pos_test = (double)0.0F;
            double tick = (double)0.0F;
            double z_pos = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            double repeat_num_now = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label243;
               }
            }

            var10000 = (double)0.0F;
         }

         double var88 = var10000;
         double var61 = entity.getPersistentData().m_128459_("skill");
         if (!entity.getPersistentData().m_128471_("Failed")) {
            double var63 = entity.getPersistentData().m_128459_("x_pos_doma");
            double var77 = entity.getPersistentData().m_128459_("y_pos_doma");
            double var89 = entity.getPersistentData().m_128459_("z_pos_doma");
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), var63, var77 - (double)0.75F, var89, 15, range * 0.175, 0.1, range * 0.175, 0.05);
            }

            if (var88 % (double)20.0F == (double)0.0F) {
               boolean var56 = false;
               entity.getPersistentData().m_128347_("skill", (double)705.0F);
               Vec3 _center = new Vec3(var63, var77, var89);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator.getPersistentData().m_128459_("Thunder") >= (double)6.0F) {
                     boolean var58 = true;
                     var56 = true;
                     power = Math.min(entityiterator.getPersistentData().m_128459_("Thunder"), (double)16.0F) - (double)6.0F;
                     dis = Math.sqrt(Math.pow(entityiterator.m_20185_() - var63, (double)2.0F) + Math.pow(entityiterator.m_20186_() - (var77 + range * (double)0.5F - (double)2.0F), (double)2.0F) + Math.pow(entityiterator.m_20189_() - var89, (double)2.0F));
                     x_target = entityiterator.m_20185_();
                     y_target = entityiterator.m_20186_();
                     z_target = entityiterator.m_20189_();
                     entityiterator.getPersistentData().m_128347_("Thunder", (double)0.0F);
                     break;
                  }
               }

               if (var56) {
                  var77 = var77 + range * (double)0.5F - (double)2.0F;
                  double var84 = (double)1.0F + power * 0.05;
                  double var59 = (double)Math.round(dis * (double)4.0F + (double)4.0F);
                  double var102 = (double)0.0F;

                  for(int index0 = 0; index0 < (int)var59; ++index0) {
                     var102 = (double)Math.round(var102 + (double)1.0F);
                     double var70 = x_target - var63;
                     double var94 = y_target - var77;
                     double var98 = z_target - var89;
                     dis = Math.sqrt(Math.pow(var70, (double)2.0F) + Math.pow(var94, (double)2.0F) + Math.pow(var98, (double)2.0F));
                     if (dis != (double)0.0F) {
                        var70 /= dis * (double)4.0F;
                        var94 /= dis * (double)4.0F;
                        var98 /= dis * (double)4.0F;
                        if (var102 < var59) {
                           if (var102 % (double)4.0F == (double)1.0F || world.m_8055_(BlockPos.m_274561_(var63 + var70 * (double)2.0F, var77 + var94 * (double)2.0F, var89 + var98 * (double)2.0F)).m_60815_()) {
                              for(int index1 = 0; index1 < 32; ++index1) {
                                 var70 = (Math.random() - (double)0.5F) * dis * (double)3.0F;
                                 var94 = (Math.random() - (double)0.5F) * dis * (double)3.0F;
                                 var98 = (Math.random() - (double)0.5F) * dis * (double)3.0F;
                                 var70 = x_target + var70;
                                 var94 = y_target + var94;
                                 var98 = z_target + var98;
                                 num1 = var70 - var63;
                                 num2 = var94 - var77;
                                 num3 = var98 - var89;
                                 double var83 = Math.sqrt(Math.pow(num1, (double)2.0F) + Math.pow(num2, (double)2.0F) + Math.pow(num3, (double)2.0F));
                                 if (var83 != (double)0.0F) {
                                    num1 /= var83 * (double)4.0F;
                                    num2 /= var83 * (double)4.0F;
                                    num3 /= var83 * (double)4.0F;
                                 }

                                 var70 = num1;
                                 var94 = num2;
                                 var98 = num3;
                                 double var69 = var63;
                                 double var60 = var77;
                                 double var87 = var89;
                                 var56 = true;

                                 for(int index2 = 0; index2 < 2; ++index2) {
                                    if (world.m_8055_(BlockPos.m_274561_(var69, var60, var87)).m_60815_()) {
                                       var56 = false;
                                       break;
                                    }

                                    var69 += var70;
                                    var60 += var94;
                                    var87 += var98;
                                 }

                                 if (var56) {
                                    break;
                                 }
                              }
                           }

                           var70 = num1;
                           var94 = num2;
                           var98 = num3;
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var63, var77, var89), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.973 0.220 1.000 1 ~ ~ ~ 0 0 0 1 1 force");
                     }

                     if (var102 % (double)2.0F == (double)0.0F) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var63, var77, var89, 1, 0.1, 0.1, 0.1, (double)0.0F);
                        }

                        if (var102 % (double)4.0F == (double)0.0F) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123747_, var63, var77, var89, 1, 0.1, 0.1, 0.1, (double)0.0F);
                           }

                           entity.getPersistentData().m_128347_("Damage", (double)30.0F * var84);
                           entity.getPersistentData().m_128347_("Range", (double)5.0F);
                           entity.getPersistentData().m_128347_("knockback", 0.1);
                           entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                           entity.getPersistentData().m_128347_("effect", (double)1.0F);
                           RangeAttackProcedure.execute(world, var63, var77, var89, entity);
                           if (world.m_8055_(BlockPos.m_274561_(var63, var77, var89)).m_60815_()) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var63, var77, var89, (int)((double)4.0F * var84), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F * var84);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123813_, var63, var77, var89, (int)((double)4.0F * var84), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F * var84);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123796_, var63, var77, var89, (int)((double)4.0F * var84), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F * var84);
                              }
                           }
                        }
                     }

                     if (var102 + (double)1.0F >= var59) {
                        if (dis > (double)1.5F) {
                           var59 = (double)Math.round(var59 + (double)1.0F);
                        } else if (var102 >= var59) {
                           if (dis < 0.3) {
                              break;
                           }

                           var59 = (double)Math.round(var59 + (double)1.0F);
                        }
                     }

                     var63 += var70;
                     var77 += var94;
                     var89 += var98;
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)var84, 1.5F);
                     } else {
                        _level.m_7785_(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)var84, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 1.0F);
                     } else {
                        _level.m_7785_(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 0.5F);
                     } else {
                        _level.m_7785_(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var84, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 1.0F);
                     } else {
                        _level.m_7785_(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(var63, var77, var89), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 0.5F);
                     } else {
                        _level.m_7785_(var63, var77, var89, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var84, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var63, var77, var89, (int)((double)50.0F * var84), (double)0.5F, (double)0.5F, (double)0.5F, (double)1.0F * var84);
                  }
               }
            }
         }

         double var64 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var79 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var90 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), var64, var79 + range / (double)2.0F * 0.7, var90, 5, range * (double)0.125F, 0.1, range * (double)0.125F, 0.05);
         }

         if (var88 % (double)10.0F == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
            if (Math.random() < (double)0.5F) {
               num1 = Math.toRadians(Math.random() * (double)360.0F);
               num2 = Math.random() * range - range / (double)2.0F;
               var64 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * num2;
               var79 = entity.getPersistentData().m_128459_("y_pos_doma");
               var90 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * num2;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var64, var79, var90, 10, (double)0.25F, (double)4.0F, (double)0.25F, (double)0.0F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var64, var79, var90), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.1F, 1.0F);
                  } else {
                     _level.m_7785_(var64, var79, var90, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.1F, 1.0F, false);
                  }
               }
            }

            if (var88 % (double)30.0F == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
               entity.getPersistentData().m_128379_("StartDomainAttack", false);
               entity.getPersistentData().m_128347_("skill", (double)1.0F);
               entity.getPersistentData().m_128347_("Damage", (double)1.0F);
               entity.getPersistentData().m_128347_("Range", range);
               entity.getPersistentData().m_128347_("knockback", 0.1);
               entity.getPersistentData().m_128379_("swing", false);
               entity.getPersistentData().m_128379_("attack", true);
               entity.getPersistentData().m_128379_("DomainAttack", true);
               RangeAttackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
            }
         }

         if (var88 % (double)10.0F == (double)0.0F) {
            num1 = Math.toRadians(Math.random() * (double)720.0F);
            var64 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * (range / (double)2.0F - (double)5.0F);
            var79 = entity.getPersistentData().m_128459_("y_pos_doma");
            var90 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * (range / (double)2.0F - (double)5.0F);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var64, var79, var90, 10, 0.1, (double)4.0F, 0.1, 0.1);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2_forDomain") > (double)20.0F) {
            entity.getPersistentData().m_128347_("cnt1_forDomain", Math.toRadians((Math.random() - (double)0.5F) * (double)360.0F));
            entity.getPersistentData().m_128347_("cnt2_forDomain", (double)0.0F);
         }

         num1 = entity.getPersistentData().m_128459_("cnt1_forDomain");
         num2 = entity.getPersistentData().m_128459_("cnt2_forDomain");

         for(int index3 = 0; index3 < 40; ++index3) {
            var64 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * num2;
            var79 = entity.getPersistentData().m_128459_("y_pos_doma") + range * (double)0.5F - num2;
            var90 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * num2;
            if (Math.random() < (double)0.25F + num2 / (range * (double)0.5F)) {
               if (Math.random() < 0.3 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), var64, var79, var90, 1, (double)0.0F, 0.05, (double)0.0F, (double)0.0F);
               }

               if (Math.random() < 0.1 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123747_, var64, var79, var90, 1, (double)0.0F, 0.05, (double)0.0F, (double)0.0F);
               }
            }

            num1 += Math.toRadians((Math.random() - (double)0.5F) * (double)10.0F);
            num2 += 0.1;
            if (num2 > range * (double)0.5F - (double)4.0F) {
               num1 = Math.toRadians(Math.random() * (double)720.0F);
               num2 = (double)0.0F;
            }
         }

         entity.getPersistentData().m_128347_("cnt1_forDomain", num1);
         entity.getPersistentData().m_128347_("cnt2_forDomain", num2);
         entity.getPersistentData().m_128347_("skill", var61);
      }
   }
}
