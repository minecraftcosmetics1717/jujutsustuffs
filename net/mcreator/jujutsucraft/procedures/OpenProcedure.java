package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class OpenProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double CNT6 = (double)0.0F;
         double distance = (double)0.0F;
         double rad1 = (double)0.0F;
         double width = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double speed = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            double var88 = ((Entity)var10000).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var99 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var99 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var88, var99, ((Entity)var10002).m_20189_(), entity);
         }

         entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
         entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
         entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         entity.getPersistentData().m_128347_("x_pos", x_pos);
         entity.getPersistentData().m_128347_("y_pos", y_pos);
         entity.getPersistentData().m_128347_("z_pos", z_pos);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)31.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, (int)(10.0F * entity.m_20205_()), 0.1 * (double)entity.m_20205_(), 0.1 * (double)entity.m_20205_(), 0.1 * (double)entity.m_20205_(), 0.05);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  int var101;
                  label264: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var101 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label264;
                        }
                     }

                     var101 = 0;
                  }

                  HP = (double)(200 + var101 * 20);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.FLAME_ARROW.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                        }

                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(entity.m_146909_());
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity53 = (LivingEntity)entityinstance;
                           if (_livingEntity53.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity53.m_21051_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }
            } else {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)8.0F) {
                     label316: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label317: {
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
                                    break label317;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label316;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof JogoEntity && entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") == (double)405.0F) {
                        label318: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (!(((Entity)var10000).getPersistentData().m_128459_("cnt6") >= (double)5.0F)) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128471_("PRESS_Z")) {
                                 break label318;
                              }
                           }

                           entity.getPersistentData().m_128379_("PRESS_Z", false);
                        }
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity && entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)30.0F));
                  if (entity.getPersistentData().m_128459_("cnt1") >= (double)30.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)31.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)31.0F) {
               CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
               entity.getPersistentData().m_128347_("Damage", (double)17.5F * CNT6);
               entity.getPersistentData().m_128347_("Range", (double)12.0F * CNT6);
               entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.5F);
               entity.getPersistentData().m_128347_("effect", (double)3.0F);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)45.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)31.0F) {
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
            distance = Math.min(entity.getPersistentData().m_128459_("cnt1") * (double)0.5F, (double)4.0F) * CNT6;
            if (Math.random() < (double)1.0F) {
               for(int index0 = 0; index0 < 4; ++index0) {
                  entity.getPersistentData().m_128347_("BlockRange", distance);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)5.0F * CNT6);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + distance - (double)0.5F, z_pos, entity);
                  rad1 = Math.toRadians((double)720.0F * Math.random());
                  width = distance * (Math.random() * (double)0.5F + (double)0.5F);
                  x_pos = entity.m_20185_() + Math.cos(rad1) * width;
                  z_pos = entity.m_20189_() + Math.sin(rad1) * width;
                  entity.getPersistentData().m_128379_("noEffect", true);
               }

               entity.getPersistentData().m_128379_("noEffect", false);
            }

            y_pos = entity.m_20186_();

            for(int index1 = 0; index1 < 36; ++index1) {
               rad1 += Math.toRadians((double)20.0F * Math.random());
               x_pos = entity.m_20185_() + Math.cos(rad1) * distance;
               z_pos = entity.m_20189_() + Math.sin(rad1) * distance;
               if (Math.random() < 0.1 * CNT6) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
                  }

                  if (Math.random() < 0.1 && entity.getPersistentData().m_128459_("cnt6") > (double)2.5F && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, 1, distance * (double)0.5F, distance * 0.05, distance * (double)0.5F, 0.05);
                  }
               }

               if (Math.random() < 0.005 * CNT6 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
               }

               if (Math.random() < 0.05 * CNT6 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
               }
            }

            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            x_power = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (0.9 + (double)entity.m_20205_()) - x_pos;
            y_power = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (0.9 + (double)entity.m_20205_()) - y_pos;
            z_power = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (0.9 + (double)entity.m_20205_()) - z_pos;
            distance = (double)0.0F;

            for(int index2 = 0; index2 < Math.round((1.0F + entity.m_20205_()) * 3.0F * 10.0F); ++index2) {
               if (Math.random() < 0.05 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 1, distance, distance, distance, distance);
               }

               if (Math.random() < 0.0025 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x_pos, y_pos, z_pos, 1, distance, distance, distance, distance);
               }

               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               distance += 0.001;
            }
         }

      }
   }
}
