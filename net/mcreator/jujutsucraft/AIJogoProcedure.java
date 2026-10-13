package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIJogoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double health = (double)0.0F;
         double distance = (double)0.0F;
         boolean infinity = false;
         boolean domain = false;
         boolean flame_battle = false;
         if (entity.m_6084_()) {
            label332: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label332;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 18, false, false));
                  }
               }
            }

            label327: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label327;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
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
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  LivingEntity _livEnt = var10000;
                  if (_livEnt instanceof LivingEntity) {
                     LivingEntity _livEnt13 = _livEnt;
                     if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") == (double)107.0F) {
                           label315: {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var60 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                    break label315;
                                 }
                              }

                              var60 = 0;
                           }

                           if (var60 <= 30) {
                              label309: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var61 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19557_();
                                       break label309;
                                    }
                                 }

                                 var61 = 0;
                              }

                              if (var61 <= 30) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 9, false, false));
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 15, 0, false, false));
                                    }
                                 }

                                 flame_battle = true;
                              }
                           }
                        }
                     }
                  }

                  if ((!LogicStartProcedure.execute(entity) || !(Math.random() > 0.1) && !entity.getPersistentData().m_128471_("UseCursedTechnique") && !flame_battle) && !domain) {
                     CalculateAttackProcedure.execute(world, entity);
                  } else {
                     if (domain) {
                        tick = (double)20.0F;
                        rnd = (double)20.0F;
                     } else {
                        float var62;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var62 = _livEnt.m_21223_();
                        } else {
                           var62 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        health = (double)(var62 / var10001);
                        if (health >= 0.66) {
                           entity.getPersistentData().m_128379_("flag1", false);
                        }

                        if (health >= 0.33) {
                           entity.getPersistentData().m_128379_("flag2", false);
                        }

                        distance = GetDistanceProcedure.execute(entity);
                        if (flame_battle) {
                           rnd = (double)5.0F;
                           tick = (double)90.0F;
                        } else if (!entity.getPersistentData().m_128471_("flag1") && health < 0.66 && distance > (double)16.0F) {
                           entity.getPersistentData().m_128379_("flag1", true);
                           rnd = (double)9.0F;
                           tick = (double)250.0F;
                        } else {
                           label359: {
                              label344: {
                                 if (!entity.getPersistentData().m_128471_("flag2") && health < 0.33 && distance < (double)16.0F) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label344;
                                    }

                                    LivingEntity _livEnt28 = (LivingEntity)entity;
                                    if (!_livEnt28.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label344;
                                    }
                                 }

                                 int index0 = 0;

                                 while(true) {
                                    if (index0 >= 256) {
                                       break label359;
                                    }

                                    rnd = (double)(4L + Math.round(Math.random() * (double)16.0F));
                                    if (rnd == (double)5.0F) {
                                       tick = (double)90.0F;
                                       break label359;
                                    }

                                    if (rnd == (double)6.0F) {
                                       tick = (double)60.0F;
                                       if (!(distance < (double)6.0F) && !(distance > (double)12.0F)) {
                                          break label359;
                                       }
                                    } else {
                                       if (rnd == (double)7.0F) {
                                          tick = (double)75.0F;
                                          break label359;
                                       }

                                       if (rnd == (double)8.0F) {
                                          tick = (double)75.0F;
                                          break label359;
                                       }

                                       if (rnd == (double)9.0F) {
                                          tick = (double)250.0F;
                                          if (!(Math.random() > 0.15) && !(distance < (double)16.0F)) {
                                             break label359;
                                          }
                                       } else if (rnd != (double)10.0F) {
                                          if (rnd == (double)15.0F) {
                                             tick = (double)625.0F;
                                             if (!(entity.getPersistentData().m_128459_("cnt_target") < (double)600.0F)) {
                                                if (entity instanceof LivingEntity) {
                                                   LivingEntity _livEnt = (LivingEntity)entity;
                                                   var62 = _livEnt.m_21223_();
                                                } else {
                                                   var62 = -1.0F;
                                                }

                                                if (entity instanceof LivingEntity) {
                                                   _livEnt = (LivingEntity)entity;
                                                   var10001 = _livEnt.m_21233_();
                                                } else {
                                                   var10001 = -1.0F;
                                                }

                                                if (!((double)(var62 / var10001) > 0.33) && !(Math.random() > 0.075)) {
                                                   if (!(entity instanceof LivingEntity)) {
                                                      break label359;
                                                   }

                                                   LivingEntity _livEnt39 = (LivingEntity)entity;
                                                   if (!_livEnt39.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                      break label359;
                                                   }
                                                }
                                             }
                                          } else if (rnd == (double)20.0F) {
                                             label348: {
                                                tick = (double)20.0F;
                                                LivingEntity var64;
                                                if (entity instanceof Mob) {
                                                   Mob _mobEnt = (Mob)entity;
                                                   var64 = _mobEnt.m_5448_();
                                                } else {
                                                   var64 = null;
                                                }

                                                LivingEntity var27 = var64;
                                                if (var27 instanceof LivingEntity) {
                                                   _livEnt = var27;
                                                   if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                      if (entity instanceof Mob) {
                                                         Mob _mobEnt = (Mob)entity;
                                                         var64 = _mobEnt.m_5448_();
                                                      } else {
                                                         var64 = null;
                                                      }

                                                      label249: {
                                                         var27 = var64;
                                                         if (var27 instanceof LivingEntity) {
                                                            LivingEntity _livEnt = var27;
                                                            if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                               var66 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                               break label249;
                                                            }
                                                         }

                                                         var66 = 0;
                                                      }

                                                      label244: {
                                                         if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                            if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                               var71 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                               break label244;
                                                            }
                                                         }

                                                         var71 = 0;
                                                      }

                                                      if (var66 > var71) {
                                                         break label348;
                                                      }
                                                   }
                                                }

                                                if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                   break label359;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++index0;
                                 }
                              }

                              entity.getPersistentData().m_128379_("flag2", true);
                              LivingEntity var67;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var67 = _mobEnt.m_5448_();
                              } else {
                                 var67 = null;
                              }

                              label233: {
                                 LivingEntity var55 = var67;
                                 if (var55 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var55;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var68 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label233;
                                    }
                                 }

                                 var68 = 0;
                              }

                              label228: {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var72 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label228;
                                    }
                                 }

                                 var72 = 0;
                              }

                              label223: {
                                 if (var68 >= var72 + 5) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var67 = _mobEnt.m_5448_();
                                    } else {
                                       var67 = null;
                                    }

                                    LivingEntity var56 = var67;
                                    if (!(var56 instanceof LivingEntity)) {
                                       break label223;
                                    }

                                    LivingEntity _livEnt34 = var56;
                                    if (!_livEnt34.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       break label223;
                                    }
                                 }

                                 entity.getPersistentData().m_128379_("flag_domain", true);
                                 if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                                    tick = (double)20.0F;
                                    rnd = (double)20.0F;
                                 }
                                 break label359;
                              }

                              rnd = (double)15.0F;
                              tick = (double)625.0F;
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", (double)Math.round((double)400.0F + rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     entity.getPersistentData().m_128379_("UseCursedTechnique", false);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
