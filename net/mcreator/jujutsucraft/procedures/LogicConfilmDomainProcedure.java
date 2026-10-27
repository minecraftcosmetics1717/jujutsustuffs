package net.mcreator.jujutsucraft.procedures;

import java.util.Iterator;
import java.util.List;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LogicConfilmDomainProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean use = false;
         Entity targetEntity = null;
         
         // Get the target of the mob, if the entity is a mob
         if (entity instanceof Mob mobEntity) {
            targetEntity = mobEntity.getTarget();
         }

         int domainExpansionAmplifier = 0;
         int neutralizationAmplifier = 0;
         int brainDamageAmplifier = 0;

         // Check Sukuna effect conditions between entity and targetEntity
         boolean hasSukunaEntity = entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
         boolean targetIsGojo = targetEntity instanceof GojoSatoruEntity;
         boolean targetHasSukuna = targetEntity instanceof LivingEntity livingTarget && livingTarget.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
         boolean entityIsGojo = entity instanceof GojoSatoruEntity;

         boolean sukunaGojoCheck = (hasSukunaEntity && targetIsGojo) || (targetHasSukuna && entityIsGojo);

         if (targetEntity instanceof LivingEntity livingTargetEntity) {
            // Check timers / counters stored in persistent data (NBT tags)
            double entityCntTarget = entity.getPersistentData().getDouble("cnt_target");
            double targetCntTarget = targetEntity.getPersistentData().getDouble("cnt_target");

            if (sukunaGojoCheck || (entityCntTarget > 600.0 || targetCntTarget > 600.0)) {
               boolean entityUnstable = entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get());
               boolean targetUnstable = livingTargetEntity.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get());

               if (!entityUnstable && !targetUnstable) {
                  double entitySkill = entity.getPersistentData().getDouble("skill");
                  double targetSkill = targetEntity.getPersistentData().getDouble("skill");

                  if (entitySkill == 0.0 && targetSkill == 0.0) {
                     if (livingTargetEntity.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        domainExpansionAmplifier = livingTargetEntity.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                     } else {
                        domainExpansionAmplifier = 0;
                     }

                     if (domainExpansionAmplifier <= 1000) {
                        use = true;
                     }
                  }
               }
            }
         }

         // Check Neutralization effect on the main entity
         if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
            neutralizationAmplifier = livingEntity.getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getDuration(); // or amplifier depending on mapping context
         } else {
            neutralizationAmplifier = 0;
         }

         if (neutralizationAmplifier > 0) {
            use = true;
         }

         if (!use && targetEntity instanceof LivingEntity livingTargetEntity) {
            int targetDomainAmplifier = 0;
            if (livingTargetEntity.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
               targetDomainAmplifier = livingTargetEntity.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
            }

            if (targetDomainAmplifier > 1000 || targetEntity.getPersistentData().getDouble("select") != 0.0 || targetEntity.getPersistentData().getDouble("skill") % 100.0 == 20.0) {
               use = true;
            }

            if (entity.getPersistentData().getBoolean("flag_domain")) {
               use = true;
            }
         }

         // Validation checks if use is true
         if (use) {
            if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
               brainDamageAmplifier = livingEntity.getEffect(JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getDuration();
            } else {
               brainDamageAmplifier = 0;
            }

            if (brainDamageAmplifier >= 2) {
               use = false;
            }

            boolean hasDomainEffect = entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
            boolean hasUnstableEffect = entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get());

            if (hasDomainEffect || hasUnstableEffect) {
               use = false;
            }
         }

         // Check distance against Domain Expansion radius config/variables
         if (use && GetDistanceProcedure.execute(entity) > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 4.0) {
            use = false;
         }

         // Check friendly fire / ally numbers in the area
         if (use && entity.getPersistentData().getDouble("friend_num") != 0.0) {
            Vec3 center = new Vec3(x, y, z);
            double domainRadius = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            List<Entity> entityList = world.getEntitiesOfClass(Entity.class, (new AABB(center, center)).inflate(domainRadius * 2.0 / 2.0), e -> true);
            
            for (Entity entityIterator : entityList) {
               if (entity != entityIterator && entity.getPersistentData().getDouble("friend_num") == entityIterator.getPersistentData().getDouble("friend_num")) {
                  if (entityIterator instanceof LivingEntity livingIterator && livingIterator.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     use = false;
                     break;
                  }

                  if (entityIterator.getPersistentData().getDouble("skill") != 0.0 && 
                     (entityIterator.getPersistentData().getDouble("select") != 0.0 || entityIterator.getPersistentData().getDouble("skill") % 100.0 == 20.0)) {
                     use = false;
                     break;
                  }
               }
            }
         }

         if (use) {
            entity.getPersistentData().putBoolean("flag_domain", false);
         }

         return use;
      }
   }
}