package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class Effect6Procedure {
   public static void execute(LevelAccessor world, Entity entityiterator) {
      if (entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         Entity entity_a = null;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123783_, x_pos, y_pos, z_pos, 20, (double)0.25F, (double)0.5F, (double)0.25F, 0.05);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 10, (double)0.25F, (double)0.5F, (double)0.25F, 0.05);
         }

      }
   }
}
