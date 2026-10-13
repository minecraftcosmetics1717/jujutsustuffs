package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DagonFish1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         boolean target = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double damage = (double)0.0F;
         double HP = (double)0.0F;
         double CNT6 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         if (entity.getPersistentData().m_128459_("cnt2") <= (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
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
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceProcedure.execute(entity) > (double)8.0F) {
                  label242: {
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
                              break label242;
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
               entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)0.0F));
               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)1.0F);
            } else {
               ChargeParticleProcedure.execute(world, entity, (double)0.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") >= (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
               }
            }

            int var10001;
            label210: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label210;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(10 + var10001 * 2);
            LivingEntity var76;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var76 = _mobEnt.m_5448_();
            } else {
               var76 = null;
            }

            target = var76 instanceof LivingEntity;
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var76 = _mobEnt.m_5448_();
            } else {
               var76 = null;
            }

            if (var76 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var76 = _mobEnt.m_5448_();
               } else {
                  var76 = null;
               }

               x_pos = ((Entity)var76).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var76 = _mobEnt.m_5448_();
               } else {
                  var76 = null;
               }

               double var80 = ((Entity)var76).m_20186_();
               LivingEntity var86;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var86 = _mobEnt.m_5448_();
               } else {
                  var86 = null;
               }

               y_pos = var80 + (double)((Entity)var86).m_20206_() * (double)0.5F;
               LivingEntity var81;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var81 = _mobEnt.m_5448_();
               } else {
                  var81 = null;
               }

               z_pos = ((Entity)var81).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            if (target) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceProcedure.execute(entity) > (double)8.0F) {
                  label253: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var76 = _mobEnt.m_5448_();
                     } else {
                        var76 = null;
                     }

                     if (((Entity)var76).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label247: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var76 = _mobEnt.m_5448_();
                           } else {
                              var76 = null;
                           }

                           if (((Entity)var76).getPersistentData().m_128459_("skill") != (double)0.0F) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var76 = _mobEnt.m_5448_();
                              } else {
                                 var76 = null;
                              }

                              if (((Entity)var76).getPersistentData().m_128471_("attack")) {
                                 break label247;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var76 = _mobEnt.m_5448_();
                           } else {
                              var76 = null;
                           }

                           if (((Entity)var76).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label253;
                           }
                        }
                     }

                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            for(int index0 = 0; index0 < 4; ++index0) {
               entity.m_146922_((float)(yaw + ((double)67.5F + Math.random() * (double)45.0F) * (double)(Math.random() < (double)0.5F ? -1 : 1)));
               entity.m_146926_((float)((double)0.0F - Math.random() * (double)67.5F));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               x_pos = entity.m_20185_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * (double)(1.0F + entity.m_20205_());
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(Math.toRadians((double)entity.m_146909_())) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
               z_pos = entity.m_20189_() + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * (double)(1.0F + entity.m_20205_());
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.SEA_SERPENT_MINI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
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
                        LivingEntity _livingEntity88 = (LivingEntity)entityinstance;
                        if (_livingEntity88.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity88.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128347_("movement", (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("cnt1", (double)Math.round(Math.random() * (double)-30.0F));
                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cn1") * 0.05);
                     entityinstance.m_20256_(new Vec3(entityinstance.getPersistentData().m_128459_("x_power"), entityinstance.getPersistentData().m_128459_("y_power"), entityinstance.getPersistentData().m_128459_("z_power")));
                     entityinstance.getPersistentData().m_128347_("speed", (double)1.0F);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            entity.m_146922_((float)yaw);
            entity.m_146926_((float)picth);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)6.0F * CNT6) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }

            entity.getPersistentData().m_128347_("Damage", 0.1);
         }

      }
   }
}
