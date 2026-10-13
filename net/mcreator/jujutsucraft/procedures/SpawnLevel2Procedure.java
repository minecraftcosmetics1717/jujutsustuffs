package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel2Procedure {
   public static boolean execute(LevelAccessor world) {
      double NUM1 = (double)0.0F;
      NUM1 = JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER;
      if (NUM1 <= (double)1.0F) {
         NUM1 = 0.04;
      } else if (NUM1 <= (double)2.0F) {
         NUM1 = 0.04;
      } else if (NUM1 <= (double)4.0F) {
         NUM1 = 0.15;
      } else if (NUM1 <= (double)7.0F) {
         NUM1 = 0.3;
      } else if (NUM1 <= (double)9.0F) {
         NUM1 = (double)0.5F;
      } else if (NUM1 <= (double)11.0F) {
         NUM1 = (double)0.75F;
      } else {
         NUM1 = (double)1.0F;
      }

      return Math.random() < NUM1 && SpawnLevel1Procedure.execute();
   }
}
