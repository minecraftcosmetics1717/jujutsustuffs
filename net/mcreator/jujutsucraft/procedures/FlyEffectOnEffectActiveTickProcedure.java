package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class FlyEffectOnEffectActiveTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.f_19789_ = 0.0F;
      }
   }
}
