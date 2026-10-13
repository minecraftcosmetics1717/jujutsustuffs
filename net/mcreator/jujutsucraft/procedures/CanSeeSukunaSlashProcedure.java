package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CanSeeSukunaSlashProcedure {
   public static boolean execute(LevelAccessor world, Entity entity, Entity player) {
      if (entity != null && player != null) {
         if (GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID")) == player) {
            return true;
         } else {
            ItemStack var10000;
            if (player instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)player;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            label57: {
               if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                  if (player instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)player;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                     break label57;
                  }
               }

               if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)16.0F || ((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)16.0F) {
                  if (player instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)player;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128459_("skill105") >= (double)100.0F) {
                     return true;
                  }
               }
            }

            if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)1.0F && ((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)1.0F) {
               return ((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX == (double)0.0F;
            } else {
               return true;
            }
         }
      } else {
         return false;
      }
   }
}
