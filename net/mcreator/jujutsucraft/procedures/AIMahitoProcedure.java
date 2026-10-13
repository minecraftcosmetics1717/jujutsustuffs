package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class AIMahitoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double level = (double)0.0F;
         double distance = (double)0.0F;
         boolean infinity = false;
         boolean domain = false;
         boolean success = false;
         boolean phase2 = false;
         boolean Sukuna = false;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            boolean var10000;
            label349: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                     var10000 = true;
                     break label349;
                  }
               }

               var10000 = false;
            }

            label344: {
               phase2 = var10000;
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label344;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 16, false, false));
                  }
               }
            }

            label339: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label339;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            LivingEntity var79;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var79 = _mobEnt.m_5448_();
            } else {
               var79 = null;
            }

            if (var79 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var79 = _mobEnt.m_5448_();
               } else {
                  var79 = null;
               }

               if (((Entity)var79).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:humans")))) {
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
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var79 = _mobEnt.m_5448_();
                     } else {
                        var79 = null;
                     }

                     label373: {
                        Entity var36 = var79;
                        if (ReturnInsideItemProcedure.execute(var36).m_41720_() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                           label367: {
                              if (var36 instanceof LivingEntity) {
                                 LivingEntity _livEnt20 = var36;
                                 if (_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label367;
                                 }
                              }

                              var82 = false;
                              break label373;
                           }
                        }

                        var82 = true;
                     }

                     Sukuna = var82;
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if ((!(Math.random() > 0.7) || !LogicStartProcedure.execute(entity) || phase2) && !domain) {
                        tick = (double)0.0F;
                        if (phase2) {
                           if (tick == (double)0.0F) {
                              label306: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt39 = (LivingEntity)entity;
                                    if (_livEnt39.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       break label306;
                                    }
                                 }

                                 if (distance < (double)10.0F && Math.random() < (double)0.5F) {
                                    entity.getPersistentData().m_128347_("skill", (double)Math.round(1516.0F));
                                    level = (double)1.0F;
                                    tick = (double)100.0F;
                                 }
                              }

                              if (LogicStartProcedure.execute(entity) && distance < (double)4.0F && !Sukuna) {
                                 entity.getPersistentData().m_128347_("skill", (double)Math.round(1505.0F));
                                 level = (double)0.0F;
                                 tick = (double)50.0F;
                              }
                           }

                           if (tick > (double)0.0F) {
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
                           }
                        }

                        if (tick == (double)0.0F) {
                           CalculateAttackProcedure.execute(world, entity);
                           if (LogicStartPassiveProcedure.execute(entity) && !phase2) {
                              if (entity.getPersistentData().m_128459_("skill") % (double)100.0F == (double)2.0F) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    ItemStack _setstack = (Math.random() < (double)0.5F ? ItemStack.f_41583_ : new ItemStack((ItemLike)JujutsucraftModItems.MAHITO_HAND_1.get())).m_41777_();
                                    _setstack.m_41764_(1);
                                    _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                    if (_entity instanceof Player) {
                                       Player _player = (Player)_entity;
                                       _player.m_150109_().m_6596_();
                                    }
                                 }
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (Math.random() < (double)0.5F ? ItemStack.f_41583_ : new ItemStack((ItemLike)JujutsucraftModItems.MAHITO_HAND_2.get())).m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                           } else if (entity instanceof LivingEntity) {
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

                        if (phase2) {
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
                        }
                     } else {
                        if (domain) {
                           rnd = (double)20.0F;
                           tick = (double)5.0F;
                        } else {
                           label370: {
                              label362: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt22 = (LivingEntity)entity;
                                    if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       if (!(entity instanceof LivingEntity)) {
                                          break label362;
                                       }

                                       LivingEntity _livEnt23 = (LivingEntity)entity;
                                       if (!_livEnt23.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label362;
                                       }
                                    }
                                 }

                                 float var83;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var83 = _livEnt.m_21223_();
                                 } else {
                                    var83 = -1.0F;
                                 }

                                 double var84 = (double)var83;
                                 float var10001;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.m_21233_();
                                 } else {
                                    var10001 = -1.0F;
                                 }

                                 if (!(var84 < (double)var10001 * (double)0.5F)) {
                                    int index0 = 0;

                                    while(true) {
                                       if (index0 >= 256) {
                                          break label370;
                                       }

                                       rnd = (double)3.0F + Math.ceil((double)Math.round(Math.random() * (double)17.0F));
                                       if (rnd == (double)4.0F) {
                                          tick = (double)50.0F;
                                          if (!(Math.random() > (double)0.5F)) {
                                             break label370;
                                          }
                                       } else if (rnd == (double)5.0F) {
                                          tick = (double)50.0F;
                                          if (!Sukuna && !(distance > (double)6.0F)) {
                                             break label370;
                                          }
                                       } else if (rnd == (double)6.0F) {
                                          tick = (double)50.0F;
                                          if (!(distance > (double)12.0F)) {
                                             break label370;
                                          }
                                       } else if (rnd == (double)7.0F) {
                                          tick = (double)12.0F;
                                          if (!(distance < (double)6.0F)) {
                                             break label370;
                                          }
                                       } else if (rnd == (double)8.0F) {
                                          tick = (double)75.0F;
                                          if (!(distance < (double)2.0F)) {
                                             break label370;
                                          }
                                       } else if (rnd == (double)9.0F) {
                                          tick = (double)150.0F;
                                          if (!(Math.random() > (double)0.75F) && !(distance < (double)6.0F)) {
                                             break label370;
                                          }
                                       } else if (rnd == (double)10.0F) {
                                          tick = (double)100.0F;
                                          if (!(Math.random() > (double)0.75F) && !(distance < (double)6.0F)) {
                                             break label370;
                                          }
                                       } else if (rnd == (double)15.0F) {
                                          label364: {
                                             tick = (double)250.0F;
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt26 = (LivingEntity)entity;
                                                if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   break label364;
                                                }
                                             }

                                             float var85;
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                var85 = _livEnt.m_21223_();
                                             } else {
                                                var85 = -1.0F;
                                             }

                                             double var86 = (double)var85;
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                var10001 = _livEnt.m_21233_();
                                             } else {
                                                var10001 = -1.0F;
                                             }

                                             if (!(var86 >= (double)var10001 * (double)0.5F)) {
                                                break label370;
                                             }
                                          }
                                       } else if (rnd == (double)20.0F) {
                                          tick = (double)20.0F;
                                          if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                             break label370;
                                          }
                                       }

                                       ++index0;
                                    }
                                 }
                              }

                              rnd = (double)15.0F;
                              tick = (double)250.0F;
                           }
                        }

                        if (rnd >= (double)5.0F) {
                           entity.getPersistentData().m_128347_("skill", (double)Math.round((double)1500.0F + rnd));
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
                        } else {
                           for(int index1 = 0; index1 < 3; ++index1) {
                              SummonHumansProcedure.execute(world, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_(), entity);
                           }
                        }

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
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
