package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class EffectCursedSpeechProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double effect = (double)0.0F;
         double power = (double)0.0F;
         effect = entity.getPersistentData().m_128459_("effect");
         if (effect == (double)305.0F) {
            EffectCursedSpeechExplodeProcedure.execute(world, entity, entityiterator);
            power = (double)1.5F;
         } else if (effect == (double)306.0F) {
            EffectCursedSpeechGetCrushedProcedure.execute(world, entity, entityiterator);
            power = 1.2;
         } else if (effect == (double)307.0F) {
            EffectCursedSpeechCrumbleAwayProcedure.execute(world, entity, entityiterator);
            power = (double)2.0F;
         } else if (effect == (double)308.0F) {
            EffectCursedSpeechDontMoveProcedure.execute(entity, entityiterator);
            power = (double)1.0F;
         } else if (effect == (double)309.0F) {
            EffectCursedSpeechBlastAwayProcedure.execute(entity, entityiterator);
            power = 1.3;
         } else {
            EffectCursedSpeech1Procedure.execute(entity, entityiterator);
            power = (double)1.0F;
         }

         int var10000;
         label31: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label31;
               }
            }

            var10000 = 0;
         }

         power = (double)Math.max(var10000 - 4, 0) * power;
         entity.getPersistentData().m_128347_("cnt10", Math.max(Math.max(entity.getPersistentData().m_128459_("cnt10"), power), (double)1.0F));
      }
   }
}
