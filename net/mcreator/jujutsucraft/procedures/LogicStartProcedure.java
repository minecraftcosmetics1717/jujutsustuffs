package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.IshigoriRyuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class LogicStartProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         double CT1 = (double)0.0F;
         double CT2 = (double)0.0F;
         double selectCT = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
               return false;
            }
         }

         if (entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            CT1 = pVars.PlayerCurseTechnique;
            CT2 = pVars.PlayerCurseTechnique2;
            selectCT = pVars.PlayerSelectCurseTechnique;
            if (CT1 == (double)0.0F) {
               return false;
            }

            if (selectCT == (double)20.0F) {
               boolean var25;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     var25 = true;
                     return !var25;
                  }
               }

               var25 = false;
               return !var25;
            }

            if (selectCT == (double)21.0F) {
               return true;
            }

            if (pVars.PhysicalAttack) {
               if (selectCT % (double)100.0F >= (double)0.0F && selectCT % (double)100.0F <= (double)2.0F) {
                  boolean var24;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                        label105: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 var24 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                                 break label105;
                              }
                           }

                           var24 = 0;
                        }

                        if (var24 != 0) {
                           var24 = 0;
                           return var24;
                        }
                     }
                  }

                  var24 = 1;
                  return (boolean)var24;
               }

               if ((CT1 == (double)27.0F || CT2 == (double)27.0F) && selectCT == (double)19.0F) {
                  return true;
               }

               boolean var22;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     var22 = true;
                     return !var22;
                  }
               }

               var22 = false;
               return !var22;
            }

            if (pVars.PassiveTechnique && LogicStartPassiveProcedure.execute(entity)) {
               return true;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt6 = (LivingEntity)entity;
               if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                  return false;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt7 = (LivingEntity)entity;
               if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return false;
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)entity;
            if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
               return false;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt9 = (LivingEntity)entity;
            if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
               if (entity instanceof Player) {
                  if (CT1 != (double)12.0F) {
                     return false;
                  }
               } else if (!(entity instanceof IshigoriRyuEntity)) {
                  return false;
               }
            }
         }

         int var10000;
         label127: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                  break label127;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0) {
            ItemStack var21;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var21 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var21 = ItemStack.f_41583_;
            }

            if (var21.m_41720_() != JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
               return false;
            }
         }

         return true;
      }
   }
}
