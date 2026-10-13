package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class KeySpaceOnKeyReleasedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("PRESS_SPACE", false);
      }
   }
}
