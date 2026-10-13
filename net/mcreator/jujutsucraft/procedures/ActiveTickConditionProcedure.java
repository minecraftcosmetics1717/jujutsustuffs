package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ActiveTickConditionProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else if (entity.getPersistentData().m_128459_("skill") <= (double)-999.0F) {
         return false;
      } else {
         return entity instanceof Player ? (Boolean)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).map((variables) -> variables.PlayerCursePower + variables.PlayerCursePowerChange > (double)0.0F).orElse(false) : true;
      }
   }
}
