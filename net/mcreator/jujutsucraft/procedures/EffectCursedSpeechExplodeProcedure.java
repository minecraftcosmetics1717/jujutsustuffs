package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class EffectCursedSpeechExplodeProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double range = (double)0.0F;
         EffectCursedSpeech1Procedure.execute(entity, entityiterator);
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         range = ReturnEntitySizeProcedure.execute(entityiterator);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)20.0F * range), (double)1.0F * range, (double)1.0F * range, (double)1.0F * range, (double)0.25F);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)20.0F * range), (double)0.25F * range, (double)0.25F * range, (double)0.25F * range, (double)0.5F);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123755_, x_pos, y_pos, z_pos, (int)((double)20.0F * range), (double)0.25F * range, (double)0.25F * range, (double)0.25F * range, (double)0.5F);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, (int)((double)4.0F * range), (double)0.25F * range, (double)0.25F * range, (double)0.25F * range, (double)0.5F);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 2.0F, ExplosionInteraction.NONE);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 5, false, false));
            }
         }

         entityiterator.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         if (!(entityiterator instanceof Player) && !entityiterator.m_6084_() && !entityiterator.m_9236_().m_5776_()) {
            entityiterator.m_146870_();
         }

      }
   }
}
