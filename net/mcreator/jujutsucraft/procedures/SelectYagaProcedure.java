package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectYagaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double _setval = (double)33.0F;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_, new ItemStack((ItemLike)JujutsucraftModItems.ITEM_DOLL.get()), new ItemStack((ItemLike)JujutsucraftModItems.ITEM_DOLL.get()), ItemStack.f_41583_, ItemStack.f_41583_);
      }
   }
}
