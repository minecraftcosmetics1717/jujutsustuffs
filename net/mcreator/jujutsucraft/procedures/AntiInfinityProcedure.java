package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
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

public class AntiInfinityProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         ItemStack item_mainHand = ItemStack.f_41583_;
         ItemStack item_head = ItemStack.f_41583_;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
               return true;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt1 = (LivingEntity)entity;
            if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
               return true;
            }
         }

         if (entity.getPersistentData().m_128459_("effectConfirm") != (double)3.0F && entity.getPersistentData().m_128459_("effectConfirm") != (double)4.0F) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            item_mainHand = var10000.m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            item_head = var10000.m_41777_();
            if (item_mainHand.m_41720_() == ItemStack.f_41583_.m_41720_() || item_mainHand.m_41720_() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() && item_mainHand.m_41720_() != JujutsucraftModItems.BLACK_ROPE.get()) {
               if (entity instanceof Player && entity instanceof Player) {
                  Player _plrCldCheck11 = (Player)entity;
                  if (_plrCldCheck11.m_36335_().m_41519_(item_head.m_41720_())) {
                     return false;
                  }
               }

               if (item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  if (entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)16.0F && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)16.0F) {
                        return false;
                     }
                  } else if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof CursedSpiritGrade010Entity)) {
                     return false;
                  }

                  if (item_head.m_41784_().m_128459_("skill205") >= (double)100.0F) {
                     return true;
                  }
               }

               return false;
            } else {
               return true;
            }
         } else {
            return true;
         }
      }
   }
}
