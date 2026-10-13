package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class KnockbackProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_knockback = (double)0.0F;
         double z_knockback = (double)0.0F;
         double y_knockback = (double)0.0F;
         double knockback = (double)0.0F;
         double distance = (double)0.0F;
         double H_original = (double)0.0F;
         double M_original = (double)0.0F;
         double Y_limit = (double)0.0F;
         double effect = (double)0.0F;
         if (!world.m_5776_()) {
            effect = entity.getPersistentData().m_128459_("effect");
            Y_limit = (double)1.5F;
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entityiterator;
                     if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                        continue;
                     }
                  }

                  if (!(entityiterator instanceof LivingEntity) || LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     if (effect == (double)1.0F) {
                        x_knockback = entityiterator.m_20185_() - x;
                        y_knockback = entityiterator.m_20186_() - y;
                        z_knockback = entityiterator.m_20189_() - z;
                     } else {
                        x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                        y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                        z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                     }

                     if (x_knockback == (double)0.0F && z_knockback == (double)0.0F) {
                        x_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * (double)-1.0F, y_knockback);
                        z_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * (double)-1.0F, y_knockback);
                     }

                     distance = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                     if (distance != (double)0.0F) {
                        knockback = entity.getPersistentData().m_128459_("knockback") * (double)3.0F;
                        x_knockback = x_knockback / distance * knockback;
                        y_knockback = y_knockback / distance * knockback;
                        z_knockback = z_knockback / distance * knockback;
                        if (y_knockback > Y_limit) {
                           M_original = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                           H_original = Math.sqrt(x_knockback * x_knockback + z_knockback * z_knockback);
                           knockback = Math.sqrt(M_original * M_original - Y_limit * Y_limit);
                           knockback /= H_original != (double)0.0F ? H_original : (double)1.0F;
                           x_knockback *= knockback;
                           y_knockback = Y_limit;
                           z_knockback *= knockback;
                        }
                     }

                     x_knockback += entity.getPersistentData().m_128459_("x_knockback");
                     y_knockback += entity.getPersistentData().m_128459_("y_knockback");
                     z_knockback += entity.getPersistentData().m_128459_("z_knockback");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity21 = (LivingEntity)entity;
                        if (_livingEntity21.m_21204_().m_22171_(Attributes.f_22278_)) {
                           double var10000;
                           label56: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livingEntity22 = (LivingEntity)entityiterator;
                                 if (_livingEntity22.m_21204_().m_22171_(Attributes.f_22278_)) {
                                    var10000 = _livingEntity22.m_21051_(Attributes.f_22278_).m_22115_();
                                    break label56;
                                 }
                              }

                              var10000 = (double)0.0F;
                           }

                           knockback = Math.sqrt(Math.max(var10000, (double)0.0F) + (double)1.0F);
                           x_knockback /= knockback;
                           y_knockback /= knockback;
                           z_knockback /= knockback;
                        }
                     }

                     EntityVectorProcedure.execute(entityiterator, x_knockback, y_knockback, z_knockback);
                  }
               }
            }

            entity.getPersistentData().m_128347_("effect", (double)0.0F);
         }
      }
   }
}
