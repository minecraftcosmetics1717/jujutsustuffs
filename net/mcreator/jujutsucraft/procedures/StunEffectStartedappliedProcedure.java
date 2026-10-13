package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class StunEffectStartedappliedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         double e_level = (double)0.0F;
         double skill = (double)0.0F;
         if (amplifier > (double)0.0F) {
            label48: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
               }

               entity.getPersistentData().m_128347_("skill", (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }
                     break label48;
                  }
               }

               CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
            }
         }

         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)0.0F || skill <= (double)-900.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity5.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-2.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity6.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

      }
   }
}
