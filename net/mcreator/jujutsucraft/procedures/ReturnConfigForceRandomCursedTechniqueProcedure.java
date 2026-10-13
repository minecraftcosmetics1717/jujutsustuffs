package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.JujutsucraftConfig;

public class ReturnConfigForceRandomCursedTechniqueProcedure {
   public static boolean execute() {
      try {
         try {
            return (Boolean)JujutsucraftConfig.forceRandomCursedTechnique.get();
         } catch (NullPointerException var1) {
            return false;
         }
      } catch (IllegalStateException var2) {
         return false;
      }
   }
}
