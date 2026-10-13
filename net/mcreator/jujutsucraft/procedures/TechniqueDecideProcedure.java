package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TechniqueDecideProcedure {
   private static final double STAR_RAGE_BASE_COST_INCREASE = (double)10.0F;
   private static final double STAR_RAGE_AMPLIFIER_COST_MULTIPLIER = (double)9.0F;
   private static final double SUKUNA_COST_MULTIPLIER = (double)0.5F;
   private static final double SIX_EYES_COST_REDUCTION_BASE = 0.1;

   public static void execute(Entity entity, boolean passive, boolean physical, double cost, double playerCT, double playerSelect, String name) {
      if (entity != null && name != null) {
         double finalCost = cost;
         JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
         LivingEntity livingEntity = null;
         if (entity instanceof LivingEntity) {
            livingEntity = (LivingEntity)entity;
         }

         if (livingEntity != null && livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()) && playerVars.PhysicalAttack && (!livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().m_128471_("Failed"))) {
            int starRageAmplifier = livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
            finalCost = (double)Math.round(cost + (double)10.0F + (double)9.0F * (double)(starRageAmplifier + 1));
         }

         if (livingEntity != null && livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
            finalCost = (double)Math.round(finalCost * (double)0.5F);
         }

         if (livingEntity != null && livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
            int sixEyesAmplifier = livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get()).m_19564_();
            finalCost = (double)Math.round(finalCost * Math.pow(0.1, (double)(sixEyesAmplifier + 1)));
         }

         if (livingEntity != null && livingEntity.m_21205_().m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get() && !livingEntity.m_21205_().m_41784_().m_128471_("Used")) {
            finalCost = (double)0.0F;
         }

         playerVars.PlayerSelectCurseTechnique = playerSelect;
         playerVars.PlayerSelectCurseTechniqueCost = finalCost;
         playerVars.PlayerSelectCurseTechniqueCostOrgin = cost;
         playerVars.PhysicalAttack = physical;
         playerVars.PassiveTechnique = passive;
         playerVars.noChangeTechnique = false;
         playerVars.PlayerSelectCurseTechniqueName = name;
         playerVars.OverlayCost = Component.m_237115_("jujutsu.overlay.cost").getString();
         playerVars.OverlayCursePower = Component.m_237115_("jujutsu.overlay.curse_power").getString();
         playerVars.syncPlayerVariables(entity);
      }
   }
}
