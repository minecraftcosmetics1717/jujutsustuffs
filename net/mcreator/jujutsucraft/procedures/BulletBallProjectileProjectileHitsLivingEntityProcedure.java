package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletBallProjectileProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
      if (sourceentity != null) {
         BulletBallProjectileProjectileHitsBlockProcedure.execute(world, x, y, z, sourceentity);
      }
   }
}
