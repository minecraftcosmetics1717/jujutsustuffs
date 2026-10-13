package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class ButtonMakiProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return !entity.getPersistentData().m_128471_("CursedSpirit");
      }
   }
}
