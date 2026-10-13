package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class JackpotEffectStartedappliedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         label28: {
            double level = (double)0.0F;
            double tick = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  double var9 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).m_19564_();
                  break label28;
               }
            }

            double var10000 = (double)0.0F;
         }

         label23: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  double var11 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).m_19557_();
                  break label23;
               }
            }

            double var10 = (double)0.0F;
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 40, (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.5F);
         }

      }
   }
}
