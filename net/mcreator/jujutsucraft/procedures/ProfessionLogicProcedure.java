package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class ProfessionLogicProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         double CT1 = (double)0.0F;
         double CT2 = (double)0.0F;
         CT1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         CT2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
         if (CT1 != (double)-1.0F && CT2 != (double)-1.0F) {
            return CT1 != (double)29.0F && CT2 != (double)29.0F;
         } else {
            return false;
         }
      }
   }
}
