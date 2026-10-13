package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetoSuguruEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.m_6084_() && !entity.getPersistentData().m_128471_("use_uzumaki")) {
            for(int index0 = 0; index0 < 20; ++index0) {
               entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               entity.getPersistentData().m_128347_("num_grade0", (double)0.0F);
               entity.getPersistentData().m_128347_("num_grade1", (double)0.0F);
               GetoSpawnCurseRandomProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
