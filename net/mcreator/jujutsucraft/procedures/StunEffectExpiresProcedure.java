package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class StunEffectExpiresProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                  return;
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F || entity.getPersistentData().m_128459_("skill") == (double)-1000.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity5 = (LivingEntity)entity;
                  if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity5.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-49.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity6.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               AnimationResetProcedure.execute(entity);
            }
         }

      }
   }
}
