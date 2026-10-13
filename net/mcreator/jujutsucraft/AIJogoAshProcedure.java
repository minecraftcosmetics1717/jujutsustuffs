package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AIJogoAshProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123783_, x, y + (double)1.0F, z, 4, (double)0.25F, (double)0.5F, (double)0.25F, (double)0.0F);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123755_, x, y + (double)1.0F, z, 1, (double)0.25F, (double)0.5F, (double)0.25F, (double)0.0F);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19607_, 60, 1, false, false));
            }
         }

      }
   }
}
