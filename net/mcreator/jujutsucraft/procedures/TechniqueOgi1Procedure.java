package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         double dis = (double)0.0F;
         double rad = (double)0.0F;
         double tsuki7_mode = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double rad_now = (double)0.0F;
         double yaw_now = (double)0.0F;
         double x_center = (double)0.0F;
         double y_center = (double)0.0F;
         double z_center = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + entity.getPersistentData().m_128459_("cnt10"));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 8, 4, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)9.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > (double)12.0F) {
                     label253: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label243: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                    break label243;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label253;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)9.0F));
               }

               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.m_20186_(), z_pos, 5, (double)0.25F, 0.1, (double)0.25F, (double)0.5F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.m_20186_(), z_pos, 2, (double)0.25F, 0.1, (double)0.25F, (double)0.5F);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.m_20186_(), z_pos, 5, (double)0.25F, (double)0.25F, (double)0.25F, CNT6 * 0.1);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)10.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19597_);
               }

               if (OnGroundProcedure.execute(world, entity)) {
                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                  LivingEntity var95;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var95 = _mobEnt.m_5448_();
                  } else {
                     var95 = null;
                  }

                  if (var95 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var95 = _mobEnt.m_5448_();
                     } else {
                        var95 = null;
                     }

                     x_pos = ((Entity)var95).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var95 = _mobEnt.m_5448_();
                     } else {
                        var95 = null;
                     }

                     double var98 = ((Entity)var95).m_20186_();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var98 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                     LivingEntity var99;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var99 = _mobEnt.m_5448_();
                     } else {
                        var99 = null;
                     }

                     z_pos = ((Entity)var99).m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
                  GetPowerFixProcedure.execute(entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, (int)(CNT6 * (double)10.0F), 0.1, 0.1, 0.1, CNT6 * (double)0.25F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)2.5F) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, (int)(CNT6 * (double)10.0F), 0.1, 0.1, 0.1, CNT6 * (double)0.25F);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)(CNT6 * (double)10.0F), 0.1, 0.1, 0.1, CNT6 * (double)0.25F);
                     }
                  }

                  entity.getPersistentData().m_128347_("x_pos", x);
                  entity.getPersistentData().m_128347_("y_pos", y + 0.1);
                  entity.getPersistentData().m_128347_("z_pos", z);
                  entity.getPersistentData().m_128347_("old_x", x);
                  entity.getPersistentData().m_128347_("old_y", y + (double)entity.m_20206_() * (double)0.5F);
                  entity.getPersistentData().m_128347_("old_z", z);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity81 = (LivingEntity)entity;
                     if (_livingEntity81.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity81.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               } else if (entity.getPersistentData().m_128459_("cnt1") >= (double)120.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") >= (double)6.0F) {
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)10.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)4.0F) {
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 1.2 * CNT6, entity.getPersistentData().m_128459_("y_power") * 1.2 * CNT6, entity.getPersistentData().m_128459_("z_power") * 1.2 * CNT6));
            }

            rad_now = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            x_pos = x - entity.getPersistentData().m_128459_("old_x");
            y_pos = y + (double)entity.m_20206_() * (double)0.5F - entity.getPersistentData().m_128459_("old_y");
            z_pos = z - entity.getPersistentData().m_128459_("old_z");
            dis = Math.sqrt(x_pos * x_pos + y_pos * y_pos + z_pos * z_pos);
            if (dis != (double)0.0F) {
               entity.getPersistentData().m_128347_("x_pos", x_pos / (dis * (double)5.0F));
               entity.getPersistentData().m_128347_("y_pos", y_pos / (dis * (double)5.0F));
               entity.getPersistentData().m_128347_("z_pos", z_pos / (dis * (double)5.0F));
            }

            x_pos = x;
            y_pos = y + (double)entity.m_20206_() * (double)0.5F;
            z_pos = z;

            for(int index0 = 0; index0 < (int)Math.max(Math.round(dis), 1L); ++index0) {
               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               entity.getPersistentData().m_128347_("Range", (double)3.0F * range);
               entity.getPersistentData().m_128347_("knockback", 0.6);
               entity.getPersistentData().m_128347_("effect", (double)5.0F);
               entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
               entity.getPersistentData().m_128379_("swing", true);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);

               for(int index1 = 0; index1 < 5; ++index1) {
                  rad = Math.toRadians(entity.getPersistentData().m_128459_("cnt2"));

                  for(int index2 = 0; index2 < 2; ++index2) {
                     x_pos2 = x_pos + (Math.cos(rad_now) - Math.sin(rad) * Math.sin(rad_now)) * (double)1.25F * range;
                     z_pos2 = z_pos + (Math.sin(rad_now) + Math.sin(rad) * Math.cos(rad_now)) * (double)1.25F * range;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos2, y_pos, z_pos2, 1, 0.1 * range, 0.1 * range, 0.1 * range, 0.1 * range);
                     }

                     rad += Math.toRadians((double)180.0F);
                  }

                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)5.0F);
                  x_pos += entity.getPersistentData().m_128459_("x_pos");
                  y_pos += entity.getPersistentData().m_128459_("y_pos");
                  z_pos += entity.getPersistentData().m_128459_("z_pos");
               }
            }

            entity.getPersistentData().m_128347_("old_x", x);
            entity.getPersistentData().m_128347_("old_y", y + (double)entity.m_20206_() * (double)0.5F);
            entity.getPersistentData().m_128347_("old_z", z);
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
