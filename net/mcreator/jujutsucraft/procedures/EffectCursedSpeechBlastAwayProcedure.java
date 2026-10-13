package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EffectCursedSpeechBlastAwayProcedure {
   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double theta = (double)0.0F;
         double distance = (double)0.0F;
         EffectCursedSpeech1Procedure.execute(entity, entityiterator);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 10, false, false));
            }
         }

      }
   }
}
