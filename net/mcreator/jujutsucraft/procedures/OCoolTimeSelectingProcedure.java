package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class OCoolTimeSelectingProcedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         double t1 = (double)0.0F;
         return ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PhysicalAttack ? OCoolTimeCombatProcedure.execute(entity) : OCoolTimeProcedure.execute(entity);
      }
   }
}
