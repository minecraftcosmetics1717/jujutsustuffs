package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class DivergentFistProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6;
         int var10000;
         label77: {
            CNT6 = (double)0.0F;
            double strength = (double)0.0F;
            double old_skill = (double)0.0F;
            double old_cooldownticks = (double)0.0F;
            double old_level = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double pitch = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double old_tick = (double)0.0F;
            double yaw = (double)0.0F;
            double weapon_size = (double)0.0F;
            double loop_num = (double)0.0F;
            double attack_reach = (double)0.0F;
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label77;
               }
            }

            var10000 = 0;
         }

         double var42 = (double)Math.min(var10000, 50) * CNT6;
         double var45 = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
            double var44 = entity.getPersistentData().m_128459_("skill");
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity4.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-7.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity5.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            AttackWeakProcedure.execute(world, x, y, z, entity);
            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity7.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity8 = (LivingEntity)entity;
               if (_livingEntity8.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity8.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               entity.getPersistentData().m_128347_("skill", var44);
               entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               entity.getPersistentData().m_128379_("attack", false);
               double var51 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var48 = Math.toRadians((double)entity.m_146909_());
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var51) * Math.cos(var48) * (double)0.0F);
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(var48) * (double)-1.0F * (double)0.0F);
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var51) * Math.cos(var48) * (double)0.0F);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)0.5F * var45);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)0.5F * var45);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)0.5F * var45);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt31 = (LivingEntity)entity;
               if (_livEnt31.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  return;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
               label65: {
                  CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label65;
                     }
                  }

                  var10000 = 0;
               }

               var42 = (double)Math.min(var10000, 50) * CNT6;
               var45 = Math.pow(ReturnEntitySizeProcedure.execute(entity), (double)2.0F);
               double var52 = (double)11.0F;

               for(int index0 = 0; index0 < (int)var52; ++index0) {
                  entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"));
                  double var47 = entity.getPersistentData().m_128459_("x_pos");
                  double var49 = entity.getPersistentData().m_128459_("y_pos");
                  double var50 = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128347_("Damage", (double)12.0F * CNT6);
                  entity.getPersistentData().m_128347_("knockback", (double)0.25F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)4.0F * var45);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  RangeAttackProcedure.execute(world, var47, var49, var50, entity);
               }

               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
