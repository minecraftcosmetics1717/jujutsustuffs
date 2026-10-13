package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.FushiguroMegumiEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIFushiguroMegumiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean flagMahorage = false;
         boolean reChange = false;
         boolean young = false;
         boolean domain = false;
         boolean StrongEnemy = false;
         boolean sukuna = false;
         boolean failed = false;
         boolean awaked = false;
         double NUM2 = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double NUM1 = (double)0.0F;
         double count_a = (double)0.0F;
         double level_strength = (double)0.0F;
         double level_resistance = (double)0.0F;
         double level_physical_gifted = (double)0.0F;
         if (entity.m_6084_()) {
            young = entity instanceof FushiguroMegumiEntity;
            sukuna = entity instanceof SukunaFushiguroEntity;
            if (!sukuna) {
               label508: {
                  AIActiveProcedure.execute(world, x, y, z, entity);
                  if (!entity.getPersistentData().m_128471_("flag_start")) {
                     entity.getPersistentData().m_128379_("flag_start", true);
                     entity.getPersistentData().m_128379_("HasWeapon1", true);
                     rnd = (double)4.0F;

                     for(int index0 = 0; index0 < 5; ++index0) {
                        entity.getPersistentData().m_128347_("TenShadowsTechnique" + Math.round(rnd), (double)1.0F);
                        ++rnd;
                     }

                     if (!young) {
                        entity.getPersistentData().m_128347_("TenShadowsTechnique1", (double)-2.0F);
                        entity.getPersistentData().m_128347_("TenShadowsTechnique5", (double)-2.0F);
                     }
                  }

                  if (young) {
                     NUM1 = (double)7.0F;
                     NUM2 = (double)2.0F;
                  } else {
                     NUM1 = (double)10.0F;
                     NUM2 = (double)3.0F;
                  }

                  label468: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.m_21023_(MobEffects.f_19600_)) {
                           break label468;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)NUM1, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_(MobEffects.f_19606_)) {
                        break label508;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)NUM2, false, false));
                     }
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt_rest", (double)0.0F);
                  if (entity.getPersistentData().m_128459_("TenShadowsTechnique14") < (double)(sukuna ? 1 : 0)) {
                     flagMahorage = false;
                  } else {
                     label449: {
                        flagMahorage = entity.getPersistentData().m_128471_("flag_mahoraga");
                        if (!flagMahorage) {
                           label446: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var74 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label446;
                                 }
                              }

                              var74 = 0;
                           }

                           int var75 = var74 * 2;
                           LivingEntity var10001;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10001 = _mobEnt.m_5448_();
                           } else {
                              var10001 = null;
                           }

                           label440: {
                              LivingEntity var36 = var10001;
                              if (var36 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var36;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var88 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label440;
                                 }
                              }

                              var88 = 0;
                           }

                           if (var75 > var88) {
                              var76 = false;
                              break label449;
                           }
                        }

                        var76 = true;
                     }

                     label522: {
                        flagMahorage = var76;
                        if (!flagMahorage) {
                           label512: {
                              if (young) {
                                 float var77;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var77 = _livEnt.m_21223_();
                                 } else {
                                    var77 = -1.0F;
                                 }

                                 double var78 = (double)var77;
                                 float var89;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var89 = _livEnt.m_21233_();
                                 } else {
                                    var89 = -1.0F;
                                 }

                                 if (var78 < (double)var89 * (double)0.25F) {
                                    break label512;
                                 }
                              }

                              var79 = false;
                              break label522;
                           }
                        }

                        var79 = true;
                     }

                     label523: {
                        flagMahorage = var79;
                        if (!flagMahorage) {
                           label513: {
                              if (sukuna) {
                                 float var80;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var80 = _livEnt.m_21223_();
                                 } else {
                                    var80 = -1.0F;
                                 }

                                 double var81 = (double)var80;
                                 float var90;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var90 = _livEnt.m_21233_();
                                 } else {
                                    var90 = -1.0F;
                                 }

                                 if (var81 < (double)var90 * (double)0.75F) {
                                    break label513;
                                 }
                              }

                              var82 = false;
                              break label523;
                           }
                        }

                        var82 = true;
                     }

                     flagMahorage = var82;
                  }

                  if (!sukuna) {
                     label409: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var83 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label409;
                           }
                        }

                        var83 = 0;
                     }

                     int var84 = var83 - 10;
                     LivingEntity var91;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var91 = _mobEnt.m_5448_();
                     } else {
                        var91 = null;
                     }

                     label403: {
                        LivingEntity var71 = var91;
                        if (var71 instanceof LivingEntity) {
                           LivingEntity _livEnt = var71;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var92 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label403;
                           }
                        }

                        var92 = 0;
                     }

                     StrongEnemy = var84 < var92;
                     CompoundTag var85 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21223_();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var93 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.m_21233_();
                     } else {
                        var10003 = -1.0F;
                     }

                     var85.m_128379_("flag_domain", var93 < (double)var10003 * (double)0.5F && StrongEnemy);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && !young && !sukuna;
                  }

                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
                     ResetCounterProcedure.execute(entity);
                     if ((!LogicStartProcedure.execute(entity) || (entity.getPersistentData().m_128459_("NUM_TenShadowsTechnique") != (double)0.0F && (entity.getPersistentData().m_128459_("NUM_TenShadowsTechnique") != (double)1.0F || !(Math.random() > (double)0.75F)) && (!(entity.getPersistentData().m_128459_("NUM_TenShadowsTechnique") > (double)1.0F) || !(Math.random() > 0.95)) || !StrongEnemy) && !flagMahorage && !sukuna) && !domain) {
                        CalculateAttackProcedure.execute(world, entity);
                        if (!sukuna) {
                           ItemStack var86;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var86 = _livEnt.m_21205_();
                           } else {
                              var86 = ItemStack.f_41583_;
                           }

                           if (!(var86.m_41720_() instanceof SwordItem) && entity.getPersistentData().m_128471_("HasWeapon1")) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (young ? new ItemStack((ItemLike)JujutsucraftModItems.SWORD_BLACK.get()) : new ItemStack(Items.f_42383_)).m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }

                              entity.getPersistentData().m_128379_("HasWeapon1", false);
                           }
                        }
                     } else {
                        if (domain) {
                           rnd = (double)20.0F;
                           tick = (double)20.0F;
                           entity.getPersistentData().m_128379_("flag_domain", false);
                        } else {
                           for(int index1 = 0; index1 < 256; ++index1) {
                              rnd = (double)4.0F + Math.ceil(Math.random() * (double)16.0F);
                              ++count_a;
                              if (count_a > (double)128.0F) {
                                 failed = true;
                                 break;
                              }

                              if (flagMahorage) {
                                 if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= (double)(sukuna ? 1 : 0))) {
                                    flagMahorage = false;
                                    continue;
                                 }

                                 rnd = (double)18.0F;
                              } else if (entity.getPersistentData().m_128471_("flag_agito")) {
                                 if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique13") >= (double)0.0F)) {
                                    entity.getPersistentData().m_128379_("flag_agito", false);
                                    continue;
                                 }

                                 rnd = (double)17.0F;
                              } else if (entity.getPersistentData().m_128459_("TenShadowsTechnique" + Math.round(rnd - (double)4.0F)) <= (double)0.0F && rnd != (double)7.0F && rnd != (double)17.0F) {
                                 continue;
                              }

                              if ((!(entity.getPersistentData().m_128459_("TenShadowsTechnique3") < (double)0.0F) || rnd != (double)5.0F && rnd != (double)6.0F) && (!(entity.getPersistentData().m_128459_("TenShadowsTechnique13") < (double)0.0F) || rnd != (double)8.0F && rnd != (double)9.0F && rnd != (double)13.0F && rnd != (double)15.0F)) {
                                 if (rnd != (double)5.0F && rnd != (double)6.0F) {
                                    if (rnd == (double)7.0F) {
                                       tick = (double)20.0F;
                                       if (entity.getPersistentData().m_128459_("TenShadowsTechnique1") <= (double)-2.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique2") >= (double)0.0F || entity.getPersistentData().m_128459_("TenShadowsTechnique1") >= (double)0.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique2") <= (double)-2.0F) {
                                          break;
                                       }
                                    } else {
                                       if (rnd == (double)8.0F) {
                                          tick = (double)20.0F;
                                          break;
                                       }

                                       if (rnd == (double)9.0F) {
                                          tick = (double)20.0F;
                                          break;
                                       }

                                       if (rnd == (double)10.0F) {
                                          tick = (double)20.0F;
                                          if (!sukuna) {
                                             break;
                                          }
                                       } else if (rnd == (double)11.0F) {
                                          tick = (double)20.0F;
                                          if (!(Math.random() < (double)0.5F)) {
                                             break;
                                          }
                                       } else if (rnd == (double)12.0F) {
                                          tick = (double)20.0F;
                                          if (!(Math.random() < 0.8)) {
                                             break;
                                          }
                                       } else {
                                          if (rnd == (double)13.0F) {
                                             tick = (double)20.0F;
                                             break;
                                          }

                                          if (rnd == (double)14.0F) {
                                             tick = (double)20.0F;
                                             break;
                                          }

                                          if (rnd == (double)15.0F) {
                                             tick = (double)20.0F;
                                             break;
                                          }

                                          if (rnd == (double)17.0F) {
                                             tick = (double)20.0F;
                                             if (entity.getPersistentData().m_128459_("TenShadowsTechnique4") > (double)0.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique5") <= (double)-2.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique9") <= (double)-2.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique11") <= (double)-2.0F) {
                                                break;
                                             }
                                          } else if (rnd == (double)18.0F) {
                                             tick = (double)20.0F;
                                             if (flagMahorage || !sukuna) {
                                                break;
                                             }
                                          } else if (rnd == (double)20.0F) {
                                             tick = (double)20.0F;
                                             if (!AIDomainLogicProcedure.execute(world, x, y, z, entity) && !young && !sukuna) {
                                                break;
                                             }
                                          }
                                       }
                                    }
                                 } else {
                                    tick = (double)20.0F;
                                    if (young) {
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        if (failed) {
                           CalculateAttackProcedure.execute(world, entity);
                        } else {
                           entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                           ItemStack var87;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var87 = _livEnt.m_21205_();
                           } else {
                              var87 = ItemStack.f_41583_;
                           }

                           if (var87.m_41720_() == (young ? (Item)JujutsucraftModItems.SWORD_BLACK.get() : Items.f_42383_)) {
                              entity.getPersistentData().m_128379_("HasWeapon1", true);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }

                           entity.getPersistentData().m_128347_("skill", (double)(600L + Math.round(rnd)));
                           if (entity instanceof LivingEntity) {
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
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_rest", entity.getPersistentData().m_128459_("cnt_rest") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_rest") > (double)120.0F) {
                  entity.getPersistentData().m_128347_("cnt_rest", (double)0.0F);
                  entity.getPersistentData().m_128347_("skill", (double)1.0F);
                  ReturnShadowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

      }
   }
}
