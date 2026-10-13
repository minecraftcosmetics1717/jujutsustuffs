package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class KeyStartTechniqueOnKeyReleasedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("PRESS_Z", false);
      }
   }
}