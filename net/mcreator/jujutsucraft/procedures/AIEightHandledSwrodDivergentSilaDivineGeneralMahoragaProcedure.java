package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIEightHandledSwrodDivergentSilaDivineGeneralMahoragaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double NUM2 = (double)0.0F;
         double NUM1 = (double)0.0F;
         double tick = (double)0.0F;
         double setItem = (double)0.0F;
         double level = (double)0.0F;
         double distance = (double)0.0F;
         boolean StrongEnemy = false;
         boolean cut_the_world = false;
         if (entity.m_6084_()) {
            label243: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("KnockbackFix", (double)2.0F);
               NUM1 = (double)(23L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.25F));
               NUM2 = Math.min(Math.floor(NUM1 / (double)4.0F), (double)3.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label243;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)NUM1, false, false));
                  }
               }
            }

            label238: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                     break label238;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)NUM2, false, false));
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
                  label267: {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt14 = (LivingEntity)entity;
                        if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label267;
                        }
                     }

                     if (distance < (double)24.0F && Math.random() < (double)0.5F) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1601.0F));
                        level = (double)1.0F;
                        tick = (double)20.0F;
                     }

                     if (distance < (double)48.0F && Math.random() < (double)0.25F) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1607.0F));
                        level = (double)1.0F;
                        tick = (double)125.0F;
                     } else if (distance > (double)8.0F && Math.random() < (double)0.25F) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1608.0F));
                        level = (double)1.0F;
                        tick = (double)75.0F;
                     }

                     label220: {
                        if (entity.m_20069_()) {
                           if (!(Math.random() < (double)0.75F)) {
                              break label220;
                           }
                        } else if (!(Math.random() < 0.15)) {
                           break label220;
                        }

                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1609.0F));
                        level = (double)1.0F;
                        tick = (double)150.0F;
                     }

                     if (distance < (double)24.0F && Math.random() < 0.1) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1615.0F));
                        level = (double)1.0F;
                        tick = (double)150.0F;
                     }
                  }

                  if (LogicStartProcedure.execute(entity)) {
                     cut_the_world = false;
                     ItemStack var54;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var54 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var54 = ItemStack.f_41583_;
                     }

                     label253: {
                        if (var54.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var54 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var54 = ItemStack.f_41583_;
                           }

                           if (var54.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                              break label253;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var54 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var54 = ItemStack.f_41583_;
                        }

                        if (var54.m_41784_().m_128459_("skill205") >= (double)1000.0F) {
                           cut_the_world = true;
                        }
                     }

                     if (cut_the_world && distance < (double)40.0F) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1619.0F));
                        level = (double)0.0F;
                        tick = (double)250.0F;
                     }
                  }

                  label265: {
                     if (entity.getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label258: {
                           if (level > (double)0.0F) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt29 = (LivingEntity)entity;
                                 if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label258;
                                 }
                              }
                           } else if (!LogicStartProcedure.execute(entity)) {
                              break label258;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                              }
                           }

                           if (level > (double)0.0F) {
                              setItem = (double)1.0F;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                                 }
                              }
                           } else {
                              setItem = (double)2.0F;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                                 }
                              }
                           }
                           break label265;
                        }
                     }

                     CalculateAttackProcedure.execute(world, entity);
                     if (entity.getPersistentData().m_128459_("skill") != (double)0.0F) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128471_("CursedSpirit")) {
                           setItem = (double)2.0F;
                        } else {
                           setItem = Math.random() < (double)0.5F ? (double)2.0F : (double)1.0F;
                        }
                     }
                  }

                  if (setItem == (double)1.0F) {
                     ItemStack var58;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var58 = _livEnt.m_21205_();
                     } else {
                        var58 = ItemStack.f_41583_;
                     }

                     if (var58.m_41720_() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }
                  } else if (setItem == (double)2.0F) {
                     ItemStack var59;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var59 = _livEnt.m_21205_();
                     } else {
                        var59 = ItemStack.f_41583_;
                     }

                     if (var59.m_41720_() != JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OF_EXTERMINATION.get())).m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("skill") != entity.getPersistentData().m_128459_("old_skill")) {
            if (entity.getPersistentData().m_128459_("skill") == (double)1609.0F && entity instanceof LivingEntity) {
               LivingEntity _livingEntity48 = (LivingEntity)entity;
               if (_livingEntity48.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  AttributeInstance var60;
                  double var10001;
                  label186: {
                     var60 = _livingEntity48.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity47 = (LivingEntity)entity;
                        if (_livingEntity47.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity47.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label186;
                        }
                     }

                     var10001 = (double)0.0F;
                  }

                  var60.m_22100_(var10001 + (double)2.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("old_skill") == (double)1609.0F && entity instanceof LivingEntity) {
               LivingEntity _livingEntity51 = (LivingEntity)entity;
               if (_livingEntity51.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  AttributeInstance var61;
                  double var62;
                  label172: {
                     var61 = _livingEntity51.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity50 = (LivingEntity)entity;
                        if (_livingEntity50.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var62 = _livingEntity50.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label172;
                        }
                     }

                     var62 = (double)0.0F;
                  }

                  var61.m_22100_(var62 - (double)2.0F);
               }
            }
         }

         entity.getPersistentData().m_128347_("old_skill", entity.getPersistentData().m_128459_("skill"));
      }
   }
}
