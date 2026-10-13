package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.JudgemanEntity;
import net.mcreator.jujutsucraft.entity.TakadaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class TakadaOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double num1 = (double)0.0F;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            label51: {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity_a;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     break label51;
                  }
               }

               if (entity_a.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  if (entity instanceof TakadaEntity) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123810_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(10.0F + entity.m_20205_() * entity.m_20205_() * entity.m_20206_() * 1.0F), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)0.0F);
                     }
                  } else if (entity instanceof JudgemanEntity && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(10.0F + entity.m_20205_() * entity.m_20205_() * entity.m_20206_() * 1.0F), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)0.0F);
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

                  return;
               }
            }

            if (entity instanceof JudgemanEntity && entity_a.getPersistentData().m_128459_("skill") == (double)2719.0F && entity_a.getPersistentData().m_128459_("cnt3") >= (double)20.0F && entity_a.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
               if (entity_a.getPersistentData().m_128459_("cnt2") >= (double)1.0F) {
                  if (entity instanceof JudgemanEntity) {
                     PlayAnimationEntity2Procedure.execute(entity, "judgement");
                  }
               } else if (entity instanceof JudgemanEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "judgement_light");
               }
            }
         } else if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
