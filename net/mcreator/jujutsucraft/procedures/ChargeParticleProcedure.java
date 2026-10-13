package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ChargeParticleProcedure {
   public static void execute(LevelAccessor world, Entity entity, double mode) {
      if (entity != null) {
         double entity_size = (double)0.0F;
         double select_color = (double)0.0F;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (mode == (double)0.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
            }
         } else if (mode == (double)1.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123808_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
            }
         } else if (mode == (double)10.0F) {
            select_color = ReturnEnergyColorProcedure.execute(entity);
            if (select_color == (double)1.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)1.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
               }
            } else if (select_color == (double)2.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)1.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
               }
            } else if (select_color == (double)3.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)1.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
               }
            } else if (select_color == (double)4.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)1.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
               }
            } else if (select_color == (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_PURPLE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)1.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123808_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
            }
         }

      }
   }
}
