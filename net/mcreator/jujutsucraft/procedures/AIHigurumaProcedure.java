package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIHigurumaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double lv_st = (double)0.0F;
         double lv_df = (double)0.0F;
         double tick = (double)0.0F;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         ItemStack item_mainHand = ItemStack.f_41583_;
         boolean domain = false;
         boolean have_gavel = false;
         Entity target_entity = null;
         if (entity.m_6084_()) {
            label313: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               lv_st = (double)10.0F;
               lv_df = (double)3.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label313;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)lv_st, false, false));
                  }
               }
            }

            label308: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label308;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)lv_df, false, false));
                  }
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            item_mainHand = var10000.m_41777_();
            have_gavel = item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get() || item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get() || item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get();
            LivingEntity var59;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var59 = _mobEnt.m_5448_();
            } else {
               var59 = null;
            }

            Entity var44 = var59;
            if (var44 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               label320: {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt_x4", entity.getPersistentData().m_128459_("cnt_x4") + (double)1.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt16 = (LivingEntity)entity;
                     if (_livEnt16.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        label287: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                 var60 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                 break label287;
                              }
                           }

                           var60 = 0;
                        }

                        if (var60 > 0) {
                           entity.getPersistentData().m_128347_("cnt_x3", entity.getPersistentData().m_128459_("cnt_x3") + (double)1.0F);
                           if (entity.getPersistentData().m_128459_("cnt_x3") > (double)200.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                              rnd = (double)2719.0F;
                              level = (double)1.0F;
                              tick = (double)20.0F;
                           }
                           break label320;
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
                     entity.getPersistentData().m_128347_("cnt_x3", (double)(var44 instanceof Player ? -400 : 0));
                     distance = GetDistanceProcedure.execute(entity);
                     if (item_mainHand.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                        label321: {
                           if (var44 instanceof LivingEntity) {
                              LivingEntity _livEnt29 = var44;
                              if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                 break label321;
                              }
                           }

                           label275: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var61 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label275;
                                 }
                              }

                              var61 = 0;
                           }

                           int var10001;
                           label270: {
                              var62 = (double)var61 * 0.8;
                              if (var44 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var44;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label270;
                                 }
                              }

                              var10001 = 0;
                           }

                           if (var62 <= (double)var10001) {
                              label322: {
                                 float var63;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var63 = _livEnt.m_21223_();
                                 } else {
                                    var63 = -1.0F;
                                 }

                                 double var64 = (double)var63;
                                 float var68;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var68 = _livEnt.m_21233_();
                                 } else {
                                    var68 = -1.0F;
                                 }

                                 if (!(var64 <= (double)var68 * 0.7) && !(entity.getPersistentData().m_128459_("cnt_target") > (double)900.0F)) {
                                    label260: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var65 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label260;
                                          }
                                       }

                                       var65 = 0;
                                    }

                                    label255: {
                                       var66 = var65 * 2;
                                       if (var44 instanceof LivingEntity) {
                                          LivingEntity _livEnt = var44;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var69 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label255;
                                          }
                                       }

                                       var69 = 0;
                                    }

                                    if (var66 > var69) {
                                       break label322;
                                    }
                                 }

                                 entity.getPersistentData().m_128379_("flag_domain", true);
                              }
                           }
                        }
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     ResetCounterProcedure.execute(entity);
                     if (domain) {
                        rnd = (double)2720.0F;
                        level = (double)0.0F;
                        tick = (double)20.0F;
                     }

                     if (rnd == (double)0.0F && item_mainHand.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get() && !LogicCooldownCombatProcedure.execute(entity)) {
                        if (distance > (double)6.0F && distance < (double)24.0F && Math.random() < (double)0.5F) {
                           rnd = (double)2707.0F;
                           level = (double)1.0F;
                           tick = (double)25.0F;
                        }

                        if (distance < (double)24.0F && Math.random() < (double)0.5F) {
                           rnd = (double)2708.0F;
                           level = (double)1.0F;
                           tick = (double)50.0F;
                        }

                        if (distance < (double)16.0F && Math.random() < (double)0.25F) {
                           if (Math.random() < (double)0.5F) {
                              rnd = (double)2710.0F;
                              level = (double)1.0F;
                              tick = (double)50.0F;
                           } else {
                              rnd = (double)2711.0F;
                              level = (double)1.0F;
                              tick = (double)100.0F;
                           }
                        }
                     }

                     if (rnd == (double)0.0F) {
                        old_skill = entity.getPersistentData().m_128459_("skill");
                        if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                           label244: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt41 = (LivingEntity)entity;
                                 if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label244;
                                 }
                              }

                              if (item_mainHand.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get() && !have_gavel) {
                                 GetGavelProcedure.execute(world, x, y, z, entity);
                              }
                           }
                        }

                        CalculateAttackProcedure.execute(world, entity);
                        if (entity.getPersistentData().m_128459_("skill") == (double)4203.0F) {
                           entity.getPersistentData().m_128347_("skill", (double)2706.0F);
                        } else {
                           if (have_gavel && item_mainHand.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get() && entity.getPersistentData().m_128459_("skill") != old_skill) {
                              rnd = Math.ceil(Math.random() * (double)6.0F);

                              for(int index0 = 0; index0 < 5; ++index0) {
                                 ItemStack var67;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var67 = _livEnt.m_21205_();
                                 } else {
                                    var67 = ItemStack.f_41583_;
                                 }

                                 item_mainHand = var67.m_41777_();
                                 if (rnd != (double)1.0F && rnd != (double)2.0F && rnd != (double)3.0F) {
                                    if (rnd != (double)4.0F && rnd != (double)5.0F) {
                                       if (rnd == (double)6.0F && item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
                                          break;
                                       }
                                    } else if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
                                       break;
                                    }
                                 } else if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                                    break;
                                 }

                                 GavelRightClicked2Procedure.execute(world, x, y, z, entity);
                              }
                           }

                           rnd = (double)0.0F;
                        }
                     }
                  }
               }

               if (rnd > (double)0.0F) {
                  entity.getPersistentData().m_128347_("skill", rnd);
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

                  if (rnd == (double)2720.0F) {
                     entity.getPersistentData().m_128347_("cnt_x3", (double)(var44 instanceof Player ? -400 : 0));
                     entity.getPersistentData().m_128379_("flag_domain", false);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 80, 1, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 80, 1, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x2") % (double)200.0F == (double)60.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
               }
            }
         }

      }
   }
}
