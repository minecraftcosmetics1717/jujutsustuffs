package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;

public class InsideSolidCalculateProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, double height, double width) {
      AABB testAABB = new AABB(x - width * (double)0.5F, y, z - width * (double)0.5F, x + width * (double)0.5F, y + height, z + width * (double)0.5F);
      return !world.m_45756_((Entity)null, testAABB);
   }
}
