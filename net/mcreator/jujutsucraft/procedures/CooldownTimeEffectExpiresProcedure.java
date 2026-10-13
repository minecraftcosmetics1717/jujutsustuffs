package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class CooldownTimeEffectExpiresProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double StartTimer = (double)0.0F;
         CooldownTimeEffectStartedappliedProcedure.execute(entity);
      }
   }
}
