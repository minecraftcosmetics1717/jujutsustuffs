package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.entity.PurpleEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class AISukunaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_head = ItemStack.f_41583_;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         double distance = (double)0.0F;
         boolean domain = false;
         boolean infinity = false;
         boolean fushiguro_body = false;
         boolean mahoraga_exist = false;
         boolean vsMahoraga = false;
         boolean flag_megumiTechnique = false;
         Entity target_entity = null;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var41 = var10000;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            fushiguro_body = entity instanceof SukunaFushiguroEntity;
            ItemStack var97;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var97 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var97 = ItemStack.f_41583_;
            }

            item_head = var97.m_41777_();
            if (fushiguro_body && !entity.getPersistentData().m_128471_("flag_start")) {
               entity.getPersistentData().m_128379_("flag_start", true);
               rnd = (double)4.0F;

               for(int index0 = 0; index0 < 7; ++index0) {
                  entity.getPersistentData().m_128347_("TenShadowsTechnique" + Math.round(rnd), (double)1.0F);
                  ++rnd;
               }

               entity.getPersistentData().m_128347_("TenShadowsTechnique1", (double)-2.0F);
               entity.getPersistentData().m_128347_("TenShadowsTechnique5", (double)-2.0F);
               entity.getPersistentData().m_128347_("TenShadowsTechnique14", (double)1.0F);
            }

            label740: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.m_21023_(MobEffects.f_19600_)) {
                     break label740;
                  }
               }

               label789: {
                  if (!(entity instanceof SukunaPerfectEntity)) {
                     label762: {
                        if (entity instanceof SukunaFushiguroEntity) {
                           SukunaFushiguroEntity _datEntL12 = (SukunaFushiguroEntity)entity;
                           if ((Boolean)_datEntL12.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                              break label762;
                           }
                        }

                        if (fushiguro_body) {
                           rnd = (double)30.0F;
                        } else {
                           rnd = (double)25.0F;
                        }
                        break label789;
                     }
                  }

                  rnd = (double)35.0F;
                  entity.getPersistentData().m_128347_("KnockbackFix", (double)1.0F);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)Math.round(rnd), false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), Integer.MAX_VALUE, (int)Math.round(Math.min(Math.max(rnd - (double)11.0F, (double)0.0F), (double)19.0F)), false, false));
                  }
               }
            }

            label703: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt16 = (LivingEntity)entity;
                  if (_livEnt16.m_21023_(MobEffects.f_19606_)) {
                     break label703;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            if (entity instanceof SukunaEntity && var41 instanceof JogoEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               if (((Entity)var41).getPersistentData().m_128459_("skill") == (double)415.0F) {
                  if (!entity.getPersistentData().m_128471_("flag2")) {
                     entity.getPersistentData().m_128379_("flag2", true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                     }
                  }
               } else if (entity.getPersistentData().m_128471_("flag2")) {
                  distance = GetDistanceProcedure.execute(entity);
                  if (distance < (double)32.0F) {
                     if (distance < (double)6.0F && entity.m_20096_()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19597_);
                        }

                        entity.getPersistentData().m_128379_("PRESS_S", true);
                        WhenBackStepProcedure.execute(world, entity);
                        entity.getPersistentData().m_128379_("PRESS_S", false);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19596_);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                        }
                     }

                     if (var41 instanceof LivingEntity) {
                        LivingEntity _entity = var41;
                        _entity.m_21195_(MobEffects.f_19596_);
                     }

                     if (var41 instanceof LivingEntity) {
                        LivingEntity _entity = var41;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                        }
                     }

                     if (var41 instanceof LivingEntity) {
                        LivingEntity _entity = var41;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                        }
                     }

                     if (((Entity)var41).m_20096_()) {
                        label684: {
                           if (var41 instanceof LivingEntity) {
                              LivingEntity _livEnt = var41;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                 var98 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                 break label684;
                              }
                           }

                           var98 = 0;
                        }

                        if (var98 < 200 && var41 instanceof LivingEntity) {
                           LivingEntity _entity = var41;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                        }
                     }
                  }
               }
            }

            if (var41 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               if (fushiguro_body) {
                  label770: {
                     if (entity instanceof SukunaFushiguroEntity) {
                        SukunaFushiguroEntity _datEntL42 = (SukunaFushiguroEntity)entity;
                        if ((Boolean)_datEntL42.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                           break label770;
                        }
                     }

                     if (!(var41 instanceof GojoSatoruEntity) && !(var41 instanceof PurpleEntity)) {
                        float var99;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var99 = _livEnt.m_21223_();
                        } else {
                           var99 = -1.0F;
                        }

                        double var100 = (double)var99;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var100 <= (double)var10001 * 0.3) {
                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity;
                              _datEntSetL.m_20088_().m_135381_(SukunaFushiguroEntity.DATA_perfect_mode, true);
                           }

                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity animatable = (SukunaFushiguroEntity)entity;
                              animatable.setTexture("sukuna_perfect");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19601_, 10, 10, false, false));
                              }
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.offhand with jujutsucraft:supreme_martial_solution");
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.chest with jujutsucraft:sukuna_body_chestplate");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21195_(MobEffects.f_19600_);
                           }

                           entity.getPersistentData().m_128347_("cnt_reverse_lim", (double)0.0F);
                           entity.getPersistentData().m_128347_("skill", (double)1.0F);
                           ReturnShadowProcedure.execute(world, x, y, z, entity);
                           entity.getPersistentData().m_128347_("skill", (double)0.0F);
                           if (item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
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
                     }
                  }
               }

               label656: {
                  if (var41 instanceof LivingEntity) {
                     LivingEntity _livEnt59 = var41;
                     if (_livEnt59.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                        var101 = true;
                        break label656;
                     }
                  }

                  var101 = false;
               }

               infinity = var101;
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               entity.getPersistentData().m_128347_("cnt_rest", (double)0.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  label800: {
                     mahoraga_exist = entity.getPersistentData().m_128459_("TenShadowsTechnique14") == (double)-1.0F;
                     vsMahoraga = var41 instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
                     distance = GetDistanceProcedure.execute(entity);
                     if (vsMahoraga && entity.getPersistentData().m_128459_("cnt_target") >= (double)2400.0F && entity.getPersistentData().m_128459_("cnt_target") <= (double)3600.0F) {
                        entity.getPersistentData().m_128379_("flag_domain", true);
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && !mahoraga_exist;
                     ResetCounterProcedure.execute(entity);
                     if (fushiguro_body) {
                        label643: {
                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity _datEntL70 = (SukunaFushiguroEntity)entity;
                              if ((Boolean)_datEntL70.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                 break label643;
                              }
                           }

                           if (entity.getPersistentData().m_128459_("cnt_target") > (double)200.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= (double)1.0F && item_head.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                 _player.m_150109_().m_6596_();
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _living = (LivingEntity)entity;
                                 _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                              }
                           }
                        }
                     }

                     label638: {
                        label637: {
                           if (!entity.getPersistentData().m_128471_("flag1") && entity instanceof LivingEntity) {
                              LivingEntity _livEnt76 = (LivingEntity)entity;
                              if (_livEnt76.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break label637;
                              }
                           }

                           if (!entity.getPersistentData().m_128471_("flag2")) {
                              break label638;
                           }
                        }

                        if (distance < (double)48.0F && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19612_, 20, 0, false, false));
                           }
                        }
                     }

                     label791: {
                        if (fushiguro_body) {
                           label806: {
                              if (entity instanceof SukunaFushiguroEntity) {
                                 SukunaFushiguroEntity _datEntL79 = (SukunaFushiguroEntity)entity;
                                 if ((Boolean)_datEntL79.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                    break label806;
                                 }
                              }

                              boolean var113;
                              label618: {
                                 entity.getPersistentData().m_128379_("flag_mahoraga", entity.getPersistentData().m_128459_("TenShadowsTechnique14") > (double)0.0F);
                                 var102 = entity.getPersistentData();
                                 if (entity.getPersistentData().m_128471_("flag_mahoraga")) {
                                    float var10002;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10002 = _livEnt.m_21223_();
                                    } else {
                                       var10002 = -1.0F;
                                    }

                                    double var112 = (double)var10002;
                                    float var10003;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10003 = _livEnt.m_21233_();
                                    } else {
                                       var10003 = -1.0F;
                                    }

                                    if (var112 < (double)var10003 * 0.6 || item_head.m_41784_().m_128459_("skill205") >= (double)100.0F && infinity) {
                                       var113 = true;
                                       break label618;
                                    }
                                 }

                                 var113 = false;
                              }

                              var102.m_128379_("flag_mahoraga", var113);
                              float var103;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var103 = _livEnt.m_21223_();
                              } else {
                                 var103 = -1.0F;
                              }

                              double var104 = (double)var103;
                              float var111;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var111 = _livEnt.m_21233_();
                              } else {
                                 var111 = -1.0F;
                              }

                              if (var104 > (double)var111 * 0.6) {
                                 LivingEntity var105;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var105 = _mobEnt.m_5448_();
                                 } else {
                                    var105 = null;
                                 }

                                 if (var105 instanceof GojoSatoruEntity) {
                                    label604: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                             var106 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                                             break label604;
                                          }
                                       }

                                       var106 = 0;
                                    }

                                    if (var106 < 1) {
                                       entity.getPersistentData().m_128379_("flag_mahoraga", false);
                                    }
                                 }
                              }
                              break label791;
                           }
                        }

                        entity.getPersistentData().m_128379_("flag_mahoraga", false);
                     }

                     label792: {
                        if (fushiguro_body) {
                           label778: {
                              if (entity instanceof SukunaFushiguroEntity) {
                                 SukunaFushiguroEntity _datEntL94 = (SukunaFushiguroEntity)entity;
                                 if ((Boolean)_datEntL94.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                    break label778;
                                 }
                              }

                              label803: {
                                 if (entity.getPersistentData().m_128471_("flag_mahoraga") || Math.random() < 0.2 && !infinity) {
                                    label802: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt96 = (LivingEntity)entity;
                                          if (_livEnt96.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                             break label802;
                                          }
                                       }

                                       if (!domain && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= (double)1.0F) {
                                          break label803;
                                       }
                                    }
                                 }

                                 if (!entity.getPersistentData().m_128471_("flag_agito") || !(entity.getPersistentData().m_128459_("TenShadowsTechnique13") >= (double)0.0F)) {
                                    var107 = false;
                                    break label792;
                                 }
                              }

                              var107 = true;
                              break label792;
                           }
                        }

                        var107 = false;
                     }

                     label571: {
                        flag_megumiTechnique = var107;
                        if (LogicStartProcedure.execute(entity)) {
                           if (Math.random() > (infinity ? (double)0.75F : (double)0.0F) && distance < (double)48.0F) {
                              break label571;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt100 = (LivingEntity)entity;
                              if (_livEnt100.m_21023_(MobEffects.f_19612_)) {
                                 break label571;
                              }
                           }

                           if (flag_megumiTechnique) {
                              break label571;
                           }
                        }

                        if (!domain) {
                           entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                           rnd = (double)0.0F;
                           tick = (double)0.0F;
                           if (!LogicCooldownCombatProcedure.execute(entity) && !infinity) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                              }

                              if (LogicStartPassiveProcedure.execute(entity)) {
                                 if (distance < (double)16.0F && Math.random() < (double)0.5F) {
                                    rnd = (double)111.0F;
                                    tick = (double)50.0F;
                                 }

                                 if (distance < (double)10.0F && Math.random() < (double)0.75F) {
                                    rnd = (double)112.0F;
                                    tick = (double)50.0F;
                                 }

                                 if (distance < (double)48.0F && Math.random() < (double)0.25F) {
                                    rnd = (double)113.0F;
                                    tick = (double)50.0F;
                                 }
                              }
                           }

                           if (rnd != (double)0.0F) {
                              entity.getPersistentData().m_128347_("skill", rnd);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
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
                           break label800;
                        }
                     }

                     if (flag_megumiTechnique) {
                        AIFushiguroMegumiProcedure.execute(world, x, y, z, entity);
                     } else {
                        entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                        if (domain) {
                           rnd = (double)20.0F;
                           tick = (double)20.0F;
                        } else if (entity.getPersistentData().m_128471_("flag2")) {
                           label489: {
                              if (var41 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var41;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var108 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                    break label489;
                                 }
                              }

                              var108 = 0;
                           }

                           if (var108 <= 20) {
                              label483: {
                                 if (var41 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var41;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var109 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19557_();
                                       break label483;
                                    }
                                 }

                                 var109 = 0;
                              }

                              if (var109 <= 20) {
                                 entity.getPersistentData().m_128379_("flag2", false);
                                 rnd = (double)7.0F;
                                 tick = (double)250.0F;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get());
                                 }
                              }
                           }
                        } else {
                           label807: {
                              if (!entity.getPersistentData().m_128471_("flag1") && (!(var41 instanceof GojoSatoruEntity) || !(entity instanceof SukunaFushiguroEntity)) && entity instanceof LivingEntity) {
                                 LivingEntity _livEnt111 = (LivingEntity)entity;
                                 if (_livEnt111.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed") && entity.getPersistentData().m_128459_("dust_amount") > (double)100.0F) {
                                    label549: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                             var110 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                             break label549;
                                          }
                                       }

                                       var110 = 0;
                                    }

                                    if (var110 < 1200 || vsMahoraga) {
                                       entity.getPersistentData().m_128379_("flag1", true);
                                       rnd = (double)7.0F;
                                       tick = (double)250.0F;
                                       break label807;
                                    }
                                 }
                              }

                              if (infinity) {
                                 label527: {
                                    if (entity instanceof SukunaFushiguroEntity) {
                                       SukunaFushiguroEntity _datEntL116 = (SukunaFushiguroEntity)entity;
                                       if ((Boolean)_datEntL116.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_world_cut)) {
                                          break label527;
                                       }
                                    }

                                    if (!(entity instanceof SukunaPerfectEntity)) {
                                       rnd = (double)0.0F;
                                       break label807;
                                    }
                                 }
                              }

                              for(int index1 = 0; index1 < 256; ++index1) {
                                 rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 5, 8);
                                 if (rnd == (double)5.0F) {
                                    tick = (double)50.0F;
                                    break;
                                 }

                                 if (rnd == (double)6.0F) {
                                    rnd = (double)0.0F;
                                    tick = (double)100.0F;
                                    if (!infinity && !vsMahoraga && !(var41 instanceof GojoSatoruEntity) && !(distance > (double)5.0F)) {
                                       rnd = (double)6.0F;
                                       break;
                                    }
                                 } else if (rnd == (double)7.0F) {
                                    rnd = (double)0.0F;
                                    tick = (double)250.0F;
                                    if (!infinity && (!(entity instanceof SukunaFushiguroEntity) || !(var41 instanceof GojoSatoruEntity)) && !(var41 instanceof JogoEntity) && !(entity.getPersistentData().m_128459_("cnt_target") <= (double)1200.0F) && (!vsMahoraga || entity.getPersistentData().m_128471_("flag1")) && !(Math.random() < 0.95) && !(distance < (double)8.0F)) {
                                       rnd = (double)7.0F;
                                       break;
                                    }
                                 } else if (rnd == (double)20.0F) {
                                    rnd = (double)0.0F;
                                    tick = (double)20.0F;
                                    if (!mahoraga_exist && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                       rnd = (double)20.0F;
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        if (!(rnd > (double)0.0F)) {
                           CalculateAttackProcedure.execute(world, entity);
                        } else {
                           if (rnd == (double)20.0F) {
                              label476: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt125 = (LivingEntity)entity;
                                    if (_livEnt125.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                       break label476;
                                    }
                                 }

                                 entity.getPersistentData().m_128347_("skill", (double)1.0F);
                                 ReturnShadowProcedure.execute(world, x, y, z, entity);
                              }
                           }

                           if (mahoraga_exist && rnd == (double)7.0F) {
                              tick = (double)100.0F;
                              entity.getPersistentData().m_128347_("skill", (double)1007.0F);
                           } else {
                              entity.getPersistentData().m_128347_("skill", (double)100.0F + rnd);
                           }

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

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt136 = (LivingEntity)entity;
                  if (_livEnt136.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt137 = (LivingEntity)entity;
                        if (_livEnt137.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           return;
                        }
                     }

                     entity.getPersistentData().m_128379_("flag1", false);
                  }
               }
            } else {
               entity.getPersistentData().m_128379_("flag2", false);
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
