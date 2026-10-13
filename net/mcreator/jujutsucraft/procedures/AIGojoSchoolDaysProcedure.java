package net.mcreator.jujutsucraft.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIGojoSchoolDaysProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean adult = false;
         boolean defense = false;
         boolean domain = false;
         boolean simple = false;
         boolean purple = false;
         boolean red = false;
         boolean target_sukuna = false;
         Entity target_entity = null;
         double rnd = (double)0.0F;
         double strlv = (double)0.0F;
         double tick = (double)0.0F;
         double health = (double)0.0F;
         double z_pos = (double)0.0F;
         double num1 = (double)0.0F;
         double distance = (double)0.0F;
         if (entity.m_6084_()) {
            if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
               GojoSatoruSchoolDaysEntity _datEntL2 = (GojoSatoruSchoolDaysEntity)entity;
               if ((Boolean)_datEntL2.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_dying)) {
                  entity.getPersistentData().m_128347_("cnt_target", (double)0.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 99, false, false));
                     }
                  }

                  if (!((GojoSatoruSchoolDaysEntity)entity).getSyncedAnimation().equals("death") && entity instanceof GojoSatoruSchoolDaysEntity) {
                     PlayAnimationEntity2Procedure.execute(entity, "death");
                  }

                  entity.getPersistentData().m_128347_("cnt_dying", entity.getPersistentData().m_128459_("cnt_dying") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_dying") > (double)200.0F) {
                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                        _datEntSetL.m_20088_().m_135381_(GojoSatoruSchoolDaysEntity.DATA_awaking, true);
                     }

                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                        _datEntSetL.m_20088_().m_135381_(GojoSatoruSchoolDaysEntity.DATA_dying, false);
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Invulnerable:0b}");
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19600_);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        float var115;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var115 = _livEnt.m_21233_();
                        } else {
                           var115 = -1.0F;
                        }

                        _entity.m_21153_(var115);
                     }

                     AnimationResetProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     ResetCounterProcedure.execute(entity);
                  }

                  return;
               }
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128379_("infinity", true);
            WhenPlayerActiveTickInfinityProcedure.execute(entity);
            if (entity.getPersistentData().m_128471_("GojoNoUseInfinity")) {
               if (entity.getPersistentData().m_128459_("cnt_target") > (double)50.0F) {
                  entity.getPersistentData().m_128379_("GojoNoUseInfinity", false);
               } else if (entity.getPersistentData().m_128459_("cnt_target") > (double)3.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                     }
                  }
               } else {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (!(var10000 instanceof LivingEntity) && !world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)256.0F, (double)256.0F, (double)256.0F), (e) -> true).isEmpty()) {
                     target_entity = (Entity)world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)256.0F, (double)256.0F, (double)256.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                        }
                     })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
                     if (entity instanceof Mob) {
                        Mob _entity = (Mob)entity;
                        if (target_entity instanceof LivingEntity) {
                           LivingEntity _ent = (LivingEntity)target_entity;
                           _entity.m_6710_(_ent);
                        }
                     }
                  }
               }
            }

            LivingEntity var103;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var103 = _mobEnt.m_5448_();
            } else {
               var103 = null;
            }

            label632: {
               var43 = var103;
               adult = entity instanceof GojoSatoruEntity;
               target_sukuna = var43 instanceof SukunaFushiguroEntity;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt33 = (LivingEntity)entity;
                  if (_livEnt33.m_21023_(MobEffects.f_19600_)) {
                     break label632;
                  }
               }

               if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
                  GojoSatoruSchoolDaysEntity _datEntL35 = (GojoSatoruSchoolDaysEntity)entity;
                  if ((Boolean)_datEntL35.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 26, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, Integer.MAX_VALUE, 26, false, false));
                        }
                     }
                     break label632;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, adult ? 29 : 20, false, false));
                  }
               }
            }

            label606: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt39 = (LivingEntity)entity;
                  if (_livEnt39.m_21023_(MobEffects.f_19606_)) {
                     break label606;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            label601: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt41 = (LivingEntity)entity;
                  if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                     break label601;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get(), Integer.MAX_VALUE, 4, false, false));
                  }
               }
            }

            if (entity instanceof GojoSatoruEntity) {
               GojoSatoruEntity _datEntL43 = (GojoSatoruEntity)entity;
               if ((Boolean)_datEntL43.m_20088_().m_135370_(GojoSatoruEntity.DATA_ghost)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 60, 1, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt45 = (LivingEntity)entity;
                     if (_livEnt45.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                     }
                  }
               }
            }

            if (var43 instanceof LivingEntity) {
               if (entity.getPersistentData().m_128459_("cnt_target") > (double)150.0F && target_sukuna) {
                  if (var43 instanceof Mob) {
                     Mob _mobEnt = (Mob)var43;
                     var103 = _mobEnt.m_5448_();
                  } else {
                     var103 = null;
                  }

                  if (!(var103 instanceof LivingEntity) && var43 instanceof Mob) {
                     Mob _entity = (Mob)var43;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _ent = (LivingEntity)entity;
                        _entity.m_6710_(_ent);
                     }
                  }
               }

               ItemStack var105;
               if (var43 instanceof LivingEntity) {
                  LivingEntity _livEnt = var43;
                  var105 = _livEnt.m_21205_();
               } else {
                  var105 = ItemStack.f_41583_;
               }

               label591: {
                  if (var105.m_41720_() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                     if (var43 instanceof LivingEntity) {
                        LivingEntity _livEnt = var43;
                        var105 = _livEnt.m_21205_();
                     } else {
                        var105 = ItemStack.f_41583_;
                     }

                     if (var105.m_41720_() != JujutsucraftModItems.BLACK_ROPE.get()) {
                        var107 = false;
                        break label591;
                     }
                  }

                  var107 = true;
               }

               defense = var107;
               domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && adult;
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  if (!entity.getPersistentData().m_128471_("GojoNoUseInfinity") && target_sukuna) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var105 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                     } else {
                        var105 = ItemStack.f_41583_;
                     }

                     if (var105.m_41720_() == JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                        }
                     }
                  }

                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  float var109;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var109 = _livEnt.m_21223_();
                  } else {
                     var109 = -1.0F;
                  }

                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21233_();
                  } else {
                     var10001 = -1.0F;
                  }

                  label670: {
                     health = (double)(var109 / var10001);
                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                           break label670;
                        }

                        GojoSatoruSchoolDaysEntity _datEntL71 = (GojoSatoruSchoolDaysEntity)entity;
                        if (!(Boolean)_datEntL71.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                           break label670;
                        }
                     }

                     purple = entity.getPersistentData().m_128471_("GojoNoUseInfinity") && distance > (double)32.0F;
                     if (!entity.getPersistentData().m_128471_("flag1") && health < 0.3 && (!adult || distance < (double)32.0F)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19612_, 20, 0, false, false));
                           }
                        }

                        purple = true;
                     }
                  }

                  if (!domain) {
                     label652: {
                        if (entity instanceof GojoSatoruSchoolDaysEntity) {
                           if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                              break label652;
                           }

                           GojoSatoruSchoolDaysEntity _datEntL76 = (GojoSatoruSchoolDaysEntity)entity;
                           if (!(Boolean)_datEntL76.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                              break label652;
                           }
                        }

                        if (distance < (double)24.0F && var43 instanceof LivingEntity) {
                           LivingEntity _livEnt77 = var43;
                           if (_livEnt77.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              label655: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt78 = (LivingEntity)entity;
                                    if (_livEnt78.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label655;
                                    }
                                 }

                                 label551: {
                                    if (var43 instanceof LivingEntity) {
                                       LivingEntity _livEnt = var43;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var110 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                          break label551;
                                       }
                                    }

                                    var110 = 0;
                                 }

                                 if (var110 <= 600) {
                                    red = true;
                                 }
                              }
                           }
                        }
                     }
                  }

                  label638: {
                     label532: {
                        if (LogicStartProcedure.execute(entity)) {
                           if (Math.random() > (defense ? 0.3 : (double)0.5F)) {
                              break label532;
                           }

                           if (purple || red) {
                              if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                 break label532;
                              }

                              if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                 GojoSatoruSchoolDaysEntity _datEntL81 = (GojoSatoruSchoolDaysEntity)entity;
                                 if ((Boolean)_datEntL81.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                    break label532;
                                 }
                              }
                           }
                        }

                        if (!domain) {
                           CalculateAttackProcedure.execute(world, entity);
                           break label638;
                        }
                     }

                     if (domain) {
                        rnd = (double)20.0F;
                        tick = (double)20.0F;
                     } else {
                        label516: {
                           label640: {
                              if (!entity.getPersistentData().m_128471_("flag2")) {
                                 if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                    if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                       GojoSatoruSchoolDaysEntity _datEntL84 = (GojoSatoruSchoolDaysEntity)entity;
                                       if ((Boolean)_datEntL84.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                          break label640;
                                       }
                                    }
                                 } else if (health < (double)0.5F && distance < (double)16.0F) {
                                    break label640;
                                 }
                              }

                              label641: {
                                 if (!entity.getPersistentData().m_128471_("flag1")) {
                                    if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                       if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                          GojoSatoruSchoolDaysEntity _datEntL88 = (GojoSatoruSchoolDaysEntity)entity;
                                          if ((Boolean)_datEntL88.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking) && health < (double)0.5F) {
                                             break label641;
                                          }
                                       }
                                    } else if (health < 0.3 && distance < (double)40.0F) {
                                       break label641;
                                    }
                                 }

                                 label642: {
                                    if (red) {
                                       if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                          break label642;
                                       }

                                       if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                          GojoSatoruSchoolDaysEntity _datEntL91 = (GojoSatoruSchoolDaysEntity)entity;
                                          if ((Boolean)_datEntL91.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                             break label642;
                                          }
                                       }
                                    }

                                    label643: {
                                       if (purple) {
                                          if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                             break label643;
                                          }

                                          if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                             GojoSatoruSchoolDaysEntity _datEntL93 = (GojoSatoruSchoolDaysEntity)entity;
                                             if ((Boolean)_datEntL93.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                break label643;
                                             }
                                          }
                                       }

                                       num1 = (double)0.0F;
                                       int index0 = 0;

                                       while(true) {
                                          if (index0 >= 128) {
                                             break label516;
                                          }

                                          ++num1;
                                          if (num1 > (double)96.0F) {
                                             rnd = (double)0.0F;
                                             break label516;
                                          }

                                          label473: {
                                             rnd = (double)Math.round((double)4.0F + Math.random() * (double)16.0F);
                                             if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                label645: {
                                                   if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                      GojoSatoruSchoolDaysEntity _datEntL96 = (GojoSatoruSchoolDaysEntity)entity;
                                                      if ((Boolean)_datEntL96.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                         break label645;
                                                      }
                                                   }

                                                   if (rnd == (double)7.0F || rnd == (double)15.0F) {
                                                      break label473;
                                                   }
                                                }
                                             }

                                             if (rnd == (double)6.0F) {
                                                label439: {
                                                   tick = (double)100.0F;
                                                   if (entity instanceof LivingEntity) {
                                                      LivingEntity _livEnt = (LivingEntity)entity;
                                                      if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                         var111 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                         break label439;
                                                      }
                                                   }

                                                   var111 = 0;
                                                }

                                                if (var111 <= 0) {
                                                   break label516;
                                                }
                                             } else if (rnd == (double)7.0F) {
                                                tick = (double)250.0F;
                                                if (!(Math.random() > (double)0.5F) && !(distance > (double)16.0F)) {
                                                   label444: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                            var112 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                            break label444;
                                                         }
                                                      }

                                                      var112 = 0;
                                                   }

                                                   if (var112 <= 0) {
                                                      if (!(entity instanceof LivingEntity)) {
                                                         break label516;
                                                      }

                                                      LivingEntity _livEnt99 = (LivingEntity)entity;
                                                      if (!_livEnt99.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                         break label516;
                                                      }
                                                   }
                                                }
                                             } else if (rnd == (double)8.0F) {
                                                label451: {
                                                   tick = (double)100.0F;
                                                   if (entity instanceof LivingEntity) {
                                                      LivingEntity _livEnt = (LivingEntity)entity;
                                                      if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                         var113 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                         break label451;
                                                      }
                                                   }

                                                   var113 = 0;
                                                }

                                                if (var113 <= 0) {
                                                   break label516;
                                                }
                                             } else if (rnd == (double)15.0F) {
                                                tick = (double)500.0F;
                                                if (!target_sukuna && !(distance < (double)8.0F)) {
                                                   label456: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                            var114 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                            break label456;
                                                         }
                                                      }

                                                      var114 = 0;
                                                   }

                                                   if (var114 <= 0 && !(Math.random() > 0.1)) {
                                                      if (!(entity instanceof LivingEntity)) {
                                                         break label516;
                                                      }

                                                      LivingEntity _livEnt102 = (LivingEntity)entity;
                                                      if (!_livEnt102.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                         break label516;
                                                      }
                                                   }
                                                }
                                             } else if (rnd == (double)20.0F) {
                                                tick = (double)20.0F;
                                                if (adult && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                   if (!(var43 instanceof LivingEntity)) {
                                                      break label516;
                                                   }

                                                   LivingEntity _livEnt103 = var43;
                                                   if (!_livEnt103.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                                                      break label516;
                                                   }
                                                }
                                             }
                                          }

                                          ++index0;
                                       }
                                    }

                                    entity.getPersistentData().m_128379_("GojoNoUseInfinity", false);
                                    rnd = (double)15.0F;
                                    tick = (double)500.0F;
                                    break label516;
                                 }

                                 rnd = (double)7.0F;
                                 tick = (double)250.0F;
                                 break label516;
                              }

                              entity.getPersistentData().m_128379_("flag1", true);
                              rnd = (double)15.0F;
                              tick = (double)500.0F;
                              break label516;
                           }

                           entity.getPersistentData().m_128379_("flag2", true);
                           rnd = (double)7.0F;
                           tick = (double)250.0F;
                        }
                     }

                     if (rnd > (double)0.0F) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round((double)200.0F + rnd));
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
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }

                  if (rnd == (double)20.0F) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               if (health >= (double)0.5F) {
                  entity.getPersistentData().m_128379_("flag2", false);
               }

               if (health >= 0.3) {
                  entity.getPersistentData().m_128379_("flag1", false);
               }
            }
         }

      }
   }
}
