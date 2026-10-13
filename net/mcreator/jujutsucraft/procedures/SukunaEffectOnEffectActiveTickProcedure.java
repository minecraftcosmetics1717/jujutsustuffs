package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SukunaEffectOnEffectActiveTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.m_6084_()) {
               if (livingEntity.f_19797_ % 10 == 0 && entity.m_20096_()) {
                  MobEffectInstance doubleJump = livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
                  int currentAmp = doubleJump != null ? doubleJump.m_19564_() : -1;
                  if (currentAmp < 4) {
                     livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, currentAmp + 1, false, false));
                  } else if (doubleJump.m_19557_() < 20) {
                     livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, 4, false, false));
                  }
               }

               return;
            }
         }

      }
   }
}
