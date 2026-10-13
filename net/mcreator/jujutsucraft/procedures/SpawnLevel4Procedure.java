package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel4Procedure {
   public static boolean execute(LevelAccessor world) {
      double NUM1 = (double)0.0F;
      NUM1 = JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER;
      if (NUM1 <= (double)1.0F) {
         NUM1 = 0.01;
      } else if (NUM1 <= (double)2.0F) {
         NUM1 = 0.01;
      } else if (NUM1 <= (double)4.0F) {
         NUM1 = 0.01;
      } else if (NUM1 <= (double)7.0F) {
         NUM1 = 0.01;
      } else if (NUM1 <= (double)9.0F) {
         NUM1 = 0.025;
      } else if (NUM1 <= (double)11.0F) {
         NUM1 = 0.15;
      } else if (NUM1 <= (double)13.0F) {
         NUM1 = (double)0.25F;
      } else {
         NUM1 = (double)0.25F;
      }

      return Math.random() < NUM1 && SpawnLevel3Procedure.execute(world);
   }
}
