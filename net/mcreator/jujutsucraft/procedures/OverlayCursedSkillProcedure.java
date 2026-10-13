package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class OverlayCursedSkillProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return !OverlayDefaultSkillProcedure.execute(entity) && !OverlayPhysicalSkillProcedure.execute(entity) && !OverlayDomainSkillProcedure.execute(entity);
      }
   }
}
