package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIHakariProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double lv_st = (double)0.0F;
         double lv_df = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt_break", (double)0.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
                  }
               }
            }

            label225: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label225;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 11, false, false));
                  }
               }
            }

            label220: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label220;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            label215: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19621_)) {
                     break label215;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19621_, Integer.MAX_VALUE, 1, false, false));
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
                  if (entity.getPersistentData().m_128459_("cnt_target") > (double)600.0F) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(2, ItemStack.f_41583_);
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.CHEST, ItemStack.f_41583_);
                     }
                  }

                  ResetCounterProcedure.execute(entity);
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  if (LogicStartProcedure.execute(entity)) {
                     label246: {
                        if ((!(Math.random() < 0.1) || AIDomainLogicProcedure.execute(world, x, y, z, entity)) && !(entity.getPersistentData().m_128459_("cnt_target") > (double)600.0F)) {
                           float var49;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var49 = _livEnt.m_21223_();
                           } else {
                              var49 = -1.0F;
                           }

                           double var50 = (double)var49;
                           float var10001;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21233_();
                           } else {
                              var10001 = -1.0F;
                           }

                           if (!(var50 <= (double)var10001 * (double)0.75F)) {
                              LivingEntity var51;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var51 = _mobEnt.m_5448_();
                              } else {
                                 var51 = null;
                              }

                              label194: {
                                 LivingEntity var27 = var51;
                                 if (var27 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var27;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var52 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label194;
                                    }
                                 }

                                 var52 = 0;
                              }

                              label189: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var55 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label189;
                                    }
                                 }

                                 var55 = 0;
                              }

                              if (var52 < var55 + 5) {
                                 break label246;
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt26 = (LivingEntity)entity;
                           if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                              break label246;
                           }
                        }

                        entity.getPersistentData().m_128379_("flag_domain", true);
                     }
                  }

                  distance = GetDistanceProcedure.execute(entity);
                  rnd = (double)0.0F;
                  if (LogicStartProcedure.execute(entity)) {
                     label243: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt28 = (LivingEntity)entity;
                           if (_livEnt28.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                              if (entity.getPersistentData().m_128459_("Reserve") != (double)0.0F) {
                                 break label243;
                              }

                              float var53;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var53 = _livEnt.m_21223_();
                              } else {
                                 var53 = -1.0F;
                              }

                              double var54 = (double)var53;
                              float var56;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var56 = _livEnt.m_21233_();
                              } else {
                                 var56 = -1.0F;
                              }

                              if (var54 <= (double)var56 * (double)0.75F && entity.getPersistentData().m_128459_("mode_hakari") == (double)2.0F) {
                                 level = (double)0.0F;
                                 rnd = (double)7.0F;
                                 tick = (double)0.0F;
                                 break label243;
                              }

                              level = (double)0.0F;
                              rnd = (double)6.0F;
                              tick = (double)37.0F;
                              break label243;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt34 = (LivingEntity)entity;
                           if (_livEnt34.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                              break label243;
                           }
                        }

                        if (distance > (double)6.0F && distance < (double)12.0F && Math.random() < 0.2) {
                           level = (double)0.0F;
                           rnd = (double)6.0F;
                           tick = (double)37.0F;
                        }
                     }
                  }

                  label161: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt35 = (LivingEntity)entity;
                        if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label161;
                        }
                     }

                     if (distance > (double)6.0F && distance < (double)15.0F && Math.random() < 0.1) {
                        level = (double)1.0F;
                        rnd = (double)4.0F;
                        tick = (double)50.0F;
                     }
                  }

                  if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                     label244: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt36 = (LivingEntity)entity;
                           if (_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                              break label244;
                           }
                        }

                        level = (double)0.0F;
                        rnd = (double)20.0F;
                        tick = (double)20.0F;
                     }
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)2900.0F + rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

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

                     if (rnd == (double)20.0F) {
                        entity.getPersistentData().m_128379_("flag_domain", false);
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
