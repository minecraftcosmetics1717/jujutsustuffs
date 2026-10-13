package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIInumakiTogeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean tick = false;
         double rnd = (double)0.0F;
         double time = (double)0.0F;
         double distance = (double)0.0F;
         if (entity.m_6084_()) {
            label154: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label154;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            label149: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label149;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
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
               if (entity.getPersistentData().m_128459_("cnt_target") > (double)10.0F) {
                  ItemStack var40;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var40 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var40 = ItemStack.f_41583_;
                  }

                  if (var40.m_41720_() == JujutsucraftModItems.UNIFORM_NORMAL_HELMET.get()) {
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

               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  if (LogicStartProcedure.execute(entity)) {
                     distance = GetDistanceProcedure.execute(entity);

                     for(int index0 = 0; index0 < 128; ++index0) {
                        rnd = (double)5.0F + Math.floor(Math.random() * (double)5.0F);
                        if (rnd == (double)5.0F) {
                           time = (double)200.0F;
                           if (!(Math.random() < 0.4)) {
                              break;
                           }
                        } else {
                           if (rnd == (double)6.0F) {
                              time = (double)125.0F;
                              break;
                           }

                           if (rnd == (double)7.0F) {
                              time = (double)250.0F;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              label130: {
                                 LivingEntity var20 = var10000;
                                 if (var20 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var20;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var42 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label130;
                                    }
                                 }

                                 var42 = 0;
                              }

                              int var10001;
                              label125: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label125;
                                    }
                                 }

                                 var10001 = 0;
                              }

                              if (var42 > var10001 && !(Math.random() < 0.9)) {
                                 break;
                              }
                           } else {
                              if (rnd == (double)8.0F) {
                                 time = (double)75.0F;
                                 break;
                              }

                              if (rnd == (double)9.0F) {
                                 time = (double)150.0F;
                                 if (!(Math.random() < 0.3)) {
                                    break;
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (rnd > (double)0.0F) {
                     ResetCounterProcedure.execute(entity);
                     time = rnd == (double)5.0F ? (double)20.0F : (double)150.0F;
                     entity.getPersistentData().m_128347_("skill", (double)Math.round((double)300.0F + rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)time, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               if (entity.getPersistentData().m_128459_("cnt_target") < (double)5.0F) {
                  ItemStack var43;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var43 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var43 = ItemStack.f_41583_;
                  }

                  if (var43.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_HELMET.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_HELMET.get()));
                     }
                  }
               }
            }
         }

      }
   }
}
