package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.SlotEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IdleDeathGambleActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double num1;
         double num2;
         double range;
         label284: {
            double z_center = (double)0.0F;
            range = (double)0.0F;
            double x_pos = (double)0.0F;
            double tick = (double)0.0F;
            double y_center = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double num_reserve = (double)0.0F;
            double x_center = (double)0.0F;
            num1 = (double)0.0F;
            double pitch = (double)0.0F;
            double y_pos = (double)0.0F;
            double num3 = (double)0.0F;
            num2 = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  double var77 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label284;
               }
            }

            double var10000 = (double)0.0F;
         }

         if (!entity.getPersistentData().m_128471_("Failed")) {
            if (entity.getPersistentData().m_128459_("Reserve") != (double)0.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               if (!(entity.getPersistentData().m_128459_("Reserve") > (double)0.0F)) {
                  num1 = (double)0.0F;

                  for(int index1 = 0; index1 < 3; ++index1) {
                     ++num1;
                     if (!(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("SLOT" + Math.round(num1))) instanceof LivingEntity)) {
                        num2 = (double)0.0F;
                        entity.getPersistentData().m_128347_("Reserve", (double)0.0F);

                        for(int index2 = 0; index2 < 3; ++index2) {
                           ++num2;
                           entity.getPersistentData().m_128359_("SLOT" + Math.round(num1), "");
                        }
                        break;
                     }
                  }
               } else {
                  if (entity.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("NameRanged", Math.random());
                  }

                  double var42 = (double)entity.m_146908_();
                  double var47 = (double)entity.m_146909_();
                  double var44 = entity.getPersistentData().m_128459_("x_pos_doma");
                  double var39 = entity.getPersistentData().m_128459_("y_pos_doma");
                  double var35 = entity.getPersistentData().m_128459_("z_pos_doma");
                  RotateEntityProcedure.execute(var44, var39, var35, entity);
                  double var48 = var39 + (double)2.0F;
                  double var43 = entity.getPersistentData().m_128459_("Reserve");
                  if (var43 < (double)5.0F && Math.random() < var43 * 0.05) {
                     var43 = (double)13.0F;
                  }

                  for(int index0 = 0; index0 < 3; ++index0) {
                     ++num1;
                     if (num1 == (double)1.0F) {
                        num2 = (double)0.0F;
                     } else if (num1 == (double)2.0F) {
                        num2 = (double)90.0F;
                     } else if (num1 == (double)3.0F) {
                        num2 = (double)-90.0F;
                     }

                     double var37 = var44 + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * (range * (double)0.5F - (double)8.0F) + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F) + num2)) * Math.min((double)4.5F, Math.abs(num2));
                     double var40 = var35 + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * (range * (double)0.5F - (double)8.0F) + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F) + num2)) * Math.min((double)4.5F, Math.abs(num2));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var37, var48, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.m_7785_(var37, var48, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.SLOT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var37, var48, var40), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                              entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                           }

                           entityinstance.m_146922_(entity.m_146908_() + 180.0F);
                           entityinstance.m_146926_(0.0F);
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           if (entityinstance instanceof SlotEntity) {
                              SlotEntity _datEntSetI = (SlotEntity)entityinstance;
                              _datEntSetI.m_20088_().m_135381_(SlotEntity.DATA_SLOT_MODE, (int)((double)4.0F - num1));
                           }

                           entity.getPersistentData().m_128359_("SLOT" + Math.round((double)4.0F - num1), entityinstance.m_20149_());
                           double var50 = (double)0.0F;
                           if (!(var43 < (double)10.0F)) {
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19590_, Integer.MAX_VALUE, 10, false, false));
                                 }
                              }
                           } else {
                              if (var43 > (double)0.0F && var43 < (double)5.0F) {
                                 var50 = (var43 - (double)1.0F) * (double)2.0F;
                                 if (entity.getPersistentData().m_128459_("mode_hakari") == (double)1.0F || entity.getPersistentData().m_128459_("mode_hakari") == (double)2.0F) {
                                    var50 += (double)4.0F;
                                 }

                                 var50 = Math.min(var50, (double)9.0F);
                              } else if (var43 >= (double)5.0F) {
                                 var50 = (double)10.0F;
                              }

                              if (var50 > (double)0.0F && entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance(MobEffects.f_19621_, Integer.MAX_VALUE, (int)(var50 - (double)1.0F), false, false));
                                 }
                              }
                           }

                           if ((entity.getPersistentData().m_128459_("mode_hakari") == (double)1.0F || entity.getPersistentData().m_128459_("mode_hakari") >= (double)10.0F) && entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, Integer.MAX_VALUE, 4, false, false));
                              }
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  }

                  entity.m_146922_((float)var42);
                  entity.m_146926_((float)var47);
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity.getPersistentData().m_128347_("Reserve", entity.getPersistentData().m_128459_("Reserve") * (double)-1.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt49 = (LivingEntity)entity;
                     if (_livEnt49.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var10001;
                           MobEffect var10003;
                           int var10005;
                           label241: {
                              var10001 = new MobEffectInstance;
                              var10003 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                    break label241;
                                 }
                              }

                              var10005 = 0;
                           }

                           var10001.<init>(var10003, 100, var10005, false, false);
                           _entity.m_7292_(var10001);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("mode_hakari") == (double)2.0F) {
               if (Math.random() < 0.025) {
                  num1 = Math.toRadians(Math.random() * (double)360.0F);
                  num2 = range / (double)2.0F - (double)4.0F;
                  double var38 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * num2;
                  double var49 = entity.getPersistentData().m_128459_("y_pos_doma") + (double)5.0F;
                  double var41 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * num2;
                  if (Math.random() < (double)0.25F) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var78 = _level.m_7654_().m_129892_();
                        CommandSourceStack var82 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(var38, var49, var41), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                        double var10002 = Math.random();
                        var78.m_230957_(var82, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var10002 * (double)4.0F) + ",Flicker:0b,Trail:0b,Colors:[I;16711680],FadeColors:[I;16711680]}]}}}}");
                     }
                  } else if (Math.random() < (double)0.25F) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var79 = _level.m_7654_().m_129892_();
                        CommandSourceStack var83 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(var38, var49, var41), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                        double var86 = Math.random();
                        var79.m_230957_(var83, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var86 * (double)4.0F) + ",Flicker:0b,Trail:0b,Colors:[I;16774912],FadeColors:[I;16774912]}]}}}}");
                     }
                  } else if (Math.random() < (double)0.25F) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var80 = _level.m_7654_().m_129892_();
                        CommandSourceStack var84 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(var38, var49, var41), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                        double var87 = Math.random();
                        var80.m_230957_(var84, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var87 * (double)4.0F) + ",Flicker:0b,Trail:0b,Colors:[I;43775],FadeColors:[I;43775]}]}}}}");
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var81 = _level.m_7654_().m_129892_();
                     CommandSourceStack var85 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(var38, var49, var41), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     double var88 = Math.random();
                     var81.m_230957_(var85, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var88 * (double)4.0F) + ",Flicker:0b,Trail:0b,Colors:[I;65442],FadeColors:[I;65442]}]}}}}");
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123767_, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), 10, range * (double)0.25F, range * (double)0.25F, range * (double)0.25F, 0.1);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_175830_, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), 10, range * (double)0.25F, range * (double)0.25F, range * (double)0.25F, 0.1);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_175827_, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), 10, range * (double)0.25F, range * (double)0.25F, range * (double)0.25F, 0.1);
               }
            }

            if (entity.getPersistentData().m_128471_("StartDomainAttack")) {
               entity.getPersistentData().m_128379_("StartDomainAttack", false);
               Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.technique.hakari1").getString() + "\"}");
                  }

                  if (entity.getPersistentData().m_128459_("mode_hakari") == (double)0.0F) {
                     if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s subtitle {\"text\":\"" + Component.m_237115_("jujutsu.technique.hakari2").getString() + "\"}");
                     }
                  } else if (entity.getPersistentData().m_128459_("mode_hakari") == (double)2.0F) {
                     if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s subtitle {\"text\":\"" + Component.m_237115_("jujutsu.technique.hakari3").getString() + "\"}");
                     }
                  } else if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s subtitle {\"text\":\"" + Component.m_237115_("jujutsu.technique.hakari4").getString() + "\"}");
                  }
               }
            }
         }

      }
   }
}
