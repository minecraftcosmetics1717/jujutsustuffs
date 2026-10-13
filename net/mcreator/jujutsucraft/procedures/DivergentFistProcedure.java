package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class DivergentFistProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double cnt6;
         int amplifier;
         
         label77: {
            cnt6 = 0.0D;
            double strength = 0.0D;
            double old_skill = 0.0D;
            double old_cooldownticks = 0.0D;
            double old_level = 0.0D;
            double range = 0.0D;
            double x_pos = 0.0D;
            double pitch = 0.0D;
            double y_pos = 0.0D;
            double z_pos = 0.0D;
            double old_tick = 0.0D;
            double yaw = 0.0D;
            double weapon_size = 0.0D;
            double loop_num = 0.0D;
            double attack_reach = 0.0D;
            
            CompoundTag nbtData = entity.getPersistentData();
            cnt6 = 1.0D + nbtData.getDouble("cnt6") * 0.1D;
            
            if (entity instanceof LivingEntity livingEntity) {
               if (livingEntity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  MobEffectInstance effect = livingEntity.getEffect(MobEffects.DAMAGE_BOOST);
                  amplifier = effect != null ? effect.getAmplifier() : 0;
                  break label77;
               }
            }

            amplifier = 0;
         }

         double strengthBonus = (double)Math.min(amplifier, 50) * cnt6;
         double entitySize = ReturnEntitySizeProcedure.execute(entity);
         CompoundTag persistentData = entity.getPersistentData();

         if (persistentData.getDouble("cnt7") == 0.0D) {
            double currentSkill = persistentData.getDouble("skill");
            
            if (entity instanceof LivingEntity livingEntity) {
               Attribute animation1Attr = (Attribute)JujutsucraftModAttributes.ANIMATION_1.get();
               if (livingEntity.getAttributes().hasAttribute(animation1Attr)) {
                  AttributeInstance instance = livingEntity.getAttribute(animation1Attr);
                  if (instance != null) {
                     instance.setBaseValue(-7.0D);
                  }
               }
            }

            if (entity instanceof LivingEntity livingEntity) {
               Attribute animation2Attr = (Attribute)JujutsucraftModAttributes.ANIMATION_2.get();
               if (livingEntity.getAttributes().hasAttribute(animation2Attr)) {
                  AttributeInstance instance = livingEntity.getAttribute(animation2Attr);
                  if (instance != null) {
                     instance.setBaseValue(0.0D);
                  }
               }
            }

            AttackWeakProcedure.execute(world, x, y, z, entity);
            
            if (persistentData.getDouble("cnt2") == 1.0D) {
               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof LivingEntity livingEntity) {
               Attribute animation1Attr = (Attribute)JujutsucraftModAttributes.ANIMATION_1.get();
               if (livingEntity.getAttributes().hasAttribute(animation1Attr)) {
                  AttributeInstance instance = livingEntity.getAttribute(animation1Attr);
                  if (instance != null) {
                     instance.setBaseValue(0.0D);
                  }
               }
            }

            if (entity instanceof LivingEntity livingEntity) {
               Attribute animation2Attr = (Attribute)JujutsucraftModAttributes.ANIMATION_2.get();
               if (livingEntity.getAttributes().hasAttribute(animation2Attr)) {
                  AttributeInstance instance = livingEntity.getAttribute(animation2Attr);
                  if (instance != null) {
                     instance.setBaseValue(0.0D);
                  }
               }
            }

            if (persistentData.getDouble("skill") == 0.0D) {
               persistentData.putDouble("skill", currentSkill);
               persistentData.putDouble("cnt7", 1.0D);
               persistentData.putDouble("cnt1", 0.0D);
               persistentData.putBoolean("attack", false);
               
               double yawRad = Math.toRadians((double)(entity.getYRot() + 90.0F));
               double pitchRad = Math.toRadians((double)entity.getXRot());
               
               persistentData.putDouble("x_pos", entity.getX() + Math.cos(yawRad) * Math.cos(pitchRad) * 0.0D);
               persistentData.putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75D + Math.sin(pitchRad) * -1.0D * 0.0D);
               persistentData.putDouble("z_pos", entity.getZ() + Math.sin(yawRad) * Math.cos(pitchRad) * 0.0D);
               
               Vec3 lookVec = entity.getLookAngle();
               persistentData.putDouble("x_power", lookVec.x * 0.5D * entitySize);
               persistentData.putDouble("y_power", lookVec.y * 0.5D * entitySize);
               persistentData.putDouble("z_power", lookVec.z * 0.5D * entitySize);
            }
         } else {
            persistentData.putDouble("cnt1", persistentData.getDouble("cnt1") + 1.0D);
            
            if (entity instanceof LivingEntity livingEntity) {
               if (livingEntity.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  persistentData.putDouble("skill", 0.0D);
                  return;
               }
            }

            if (persistentData.getDouble("cnt1") > 0.0D) {
               label65: {
                  cnt6 = 1.0D + persistentData.getDouble("cnt6") * 0.2D;
                  if (entity instanceof LivingEntity livingEntity) {
                     if (livingEntity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        MobEffectInstance effect = livingEntity.getEffect(MobEffects.DAMAGE_BOOST);
                        amplifier = effect != null ? effect.getAmplifier() : 0;
                        break label65;
                     }
                  }

                  amplifier = 0;
               }

               strengthBonus = (double)Math.min(amplifier, 50) * cnt6;
               double sizeSquared = Math.pow(ReturnEntitySizeProcedure.execute(entity), 2.0D);
               double steps = 11.0D;

               for (int index0 = 0; index0 < (int)steps; ++index0) {
                  persistentData.putDouble("x_pos", persistentData.getDouble("x_pos") + persistentData.getDouble("x_power"));
                  persistentData.putDouble("y_pos", persistentData.getDouble("y_pos") + persistentData.getDouble("y_power"));
                  persistentData.putDouble("z_pos", persistentData.getDouble("z_pos") + persistentData.getDouble("z_power"));
                  
                  double currentX = persistentData.getDouble("x_pos");
                  double currentY = persistentData.getDouble("y_pos");
                  double currentZ = persistentData.getDouble("z_pos");
                  
                  persistentData.putDouble("Damage", 12.0D * cnt6);
                  persistentData.putDouble("knockback", 0.25D * cnt6);
                  persistentData.putDouble("Range", 4.0D * sizeSquared);
                  persistentData.putDouble("projectile_type", 1.0D);
                  
                  RangeAttackProcedure.execute(world, currentX, currentY, currentZ, entity);
               }

               persistentData.putDouble("skill", 0.0D);
            }
         }
      }
   }
}