package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectKurourushiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double _setval = (double)23.0F;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, new ItemStack((ItemLike)JujutsucraftModItems.KUROURUSHI_BODY_CHESTPLATE.get()), ItemStack.f_41583_, new ItemStack((ItemLike)JujutsucraftModItems.KUROURUSHI_BODY_HELMET.get()), new ItemStack((ItemLike)JujutsucraftModItems.KUROURUSHI_BODY_LEGGINGS.get()), ItemStack.f_41583_, ItemStack.f_41583_, new ItemStack((ItemLike)JujutsucraftModItems.FESTER_LIFE_BLADE.get()), ItemStack.f_41583_);
      }
   }
}
