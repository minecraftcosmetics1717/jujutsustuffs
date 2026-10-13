package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class StarRageEffectStartedappliedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         OgiZeninPassiveSkillProcedure.execute(entity);
      }
   }
}
