package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class ProfessionCursedSpiritProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double _setval = (double)-1.0F;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerProfession = _setval;
            capability.syncPlayerVariables(entity);
         });
         PlayerSetProfessionProcedure.execute(entity);
         ProfessionDecidedProcedure.execute(entity);
      }
   }
}
