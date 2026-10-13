package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.HigurumaHiromiEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class GavelRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_mainHand = ItemStack.f_41583_;
         ItemStack item_offHand = ItemStack.f_41583_;
         ItemStack item_target = ItemStack.f_41583_;
         double ticks = (double)0.0F;
         double cnt1 = (double)0.0F;
         double skill = (double)0.0F;
         double CT2 = (double)0.0F;
         double CT1 = (double)0.0F;
         CT1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         CT2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
         if (entity instanceof HigurumaHiromiEntity || CT1 == (double)27.0F || CT2 == (double)27.0F) {
            GavelRightClicked2Procedure.execute(world, x, y, z, entity);
         }

      }
   }
}
