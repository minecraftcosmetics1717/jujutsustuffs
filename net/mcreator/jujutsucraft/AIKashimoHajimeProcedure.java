package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.HakariKinjiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIKashimoHajimeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean vsSukuna = false;
         boolean MythicalBeastAmber = false;
         Entity target_entity = null;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var30 = var10000;
         if (entity.m_6084_()) {
            label204: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label204;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 19, false, false));
                  }
               }
            }

            label199: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label199;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            if (var30 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  label191: {
                     entity.getPersistentData().m_128347_("cnt_x", (double)5.0F);
                     ResetCounterProcedure.execute(entity);
                     if (var30 instanceof LivingEntity) {
                        LivingEntity _livEnt12 = var30;
                        if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           var42 = true;
                           break label191;
                        }
                     }

                     var42 = false;
                  }

                  label186: {
                     vsSukuna = var42;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           var43 = true;
                           break label186;
                        }
                     }

                     var43 = false;
                  }

                  MythicalBeastAmber = var43;
                  distance = GetDistanceProcedure.execute(entity);
                  if (MythicalBeastAmber && LogicStartProcedure.execute(entity)) {
                     if (distance < (double)16.0F && Math.random() < (double)0.25F) {
                        rnd = (double)16.0F;
                        level = (double)0.0F;
                        tick = (double)50.0F;
                     }

                     if (distance > (double)6.0F && Math.random() < (double)0.25F) {
                        rnd = (double)17.0F;
                        level = (double)0.0F;
                        tick = (double)125.0F;
                     }
                  }

                  if (rnd == (double)0.0F) {
                     label221: {
                        if (distance < (double)16.0F && Math.random() < 0.1) {
                           rnd = (double)3.0F;
                           level = (double)1.0F;
                           tick = (double)25.0F;
                        }

                        label224: {
                           if (!MythicalBeastAmber) {
                              if (vsSukuna) {
                                 break label224;
                              }

                              label175: {
                                 if (var30 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var30;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var44 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label175;
                                    }
                                 }

                                 var44 = 0;
                              }

                              int var10001;
                              label170: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label170;
                                    }
                                 }

                                 var10001 = 0;
                              }

                              if (var44 >= var10001 * 2) {
                                 break label224;
                              }
                           }

                           label227: {
                              label218: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt16 = (LivingEntity)entity;
                                    if (_livEnt16.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       break label218;
                                    }
                                 }

                                 float var45;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var45 = _livEnt.m_21223_();
                                 } else {
                                    var45 = -1.0F;
                                 }

                                 double var46 = (double)var45;
                                 float var47;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var47 = _livEnt.m_21233_();
                                 } else {
                                    var47 = -1.0F;
                                 }

                                 if (var46 < (double)var47 * (double)0.5F) {
                                    break label227;
                                 }

                                 if (var30 instanceof LivingEntity) {
                                    LivingEntity _livEnt19 = var30;
                                    if (_livEnt19.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       if (!(var30 instanceof LivingEntity)) {
                                          break label227;
                                       }

                                       LivingEntity _livEnt20 = var30;
                                       if (!_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label227;
                                       }
                                    }
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt21 = (LivingEntity)entity;
                                 if (_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label221;
                                 }
                              }

                              if ((!(((Entity)var30).getPersistentData().m_128459_("Thunder") >= (double)5.0F) && !entity.m_20069_() || !(Math.random() > (double)0.5F) && !(distance > (double)6.0F)) && !(((Entity)var30).getPersistentData().m_128459_("Thunder") >= (double)15.0F)) {
                                 break label221;
                              }

                              if (var30 instanceof HakariKinjiEntity && var30 instanceof LivingEntity) {
                                 LivingEntity _livEnt26 = var30;
                                 if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    break label221;
                                 }
                              }

                              rnd = (double)5.0F;
                              level = (double)1.0F;
                              tick = (double)10.0F;
                              break label221;
                           }

                           rnd = (double)10.0F;
                           level = (double)1.0F;
                           tick = (double)10.0F;
                           break label221;
                        }

                        rnd = (double)15.0F;
                        level = (double)1.0F;
                        tick = (double)10.0F;
                     }
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)700.0F + rnd);
                     if (level > (double)0.0F) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
