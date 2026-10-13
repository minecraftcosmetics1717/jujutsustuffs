package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TsukumoDomainExpansionActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double rad;
         double z_center;
         double range;
         double y_center;
         double x_center;
         int var10000;
         label96: {
            boolean logic_a = false;
            z_center = (double)0.0F;
            range = (double)0.0F;
            double x_pos = (double)0.0F;
            y_center = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double dis = (double)0.0F;
            double x_knockback = (double)0.0F;
            x_center = (double)0.0F;
            rad = (double)0.0F;
            double rad_now = (double)0.0F;
            double z_knockback = (double)0.0F;
            double y_pos = (double)0.0F;
            double y_knockback = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            x_center = entity.getPersistentData().m_128459_("x_pos_doma");
            y_center = entity.getPersistentData().m_128459_("y_pos_doma");
            z_center = entity.getPersistentData().m_128459_("z_pos_doma");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label96;
               }
            }

            var10000 = 0;
         }

         if (var10000 % 5 == 0 && !entity.getPersistentData().m_128471_("Failed")) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get(), 10, 11, true, true));
               }
            }

            Vec3 _center = new Vec3(x_center, y_center, z_center);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 6, false, false));
                     }
                  }

                  double var46 = entityiterator.m_20185_() - entityiterator.m_20185_();
                  double var55 = entityiterator.m_20186_() - (double)5.0F - entityiterator.m_20186_();
                  double var51 = entityiterator.m_20189_() - entityiterator.m_20189_();
                  double var44 = Math.sqrt(Math.pow(var46, (double)2.0F) + Math.pow(var55, (double)2.0F) + Math.pow(var51, (double)2.0F));
                  var46 = var46 / var44 * (double)3.0F;
                  var55 = var55 / var44 * (double)3.0F;
                  var51 = var51 / var44 * (double)3.0F;
                  if (!(var46 * 1.1 < entityiterator.m_20184_().m_7096_()) && !(var46 * 0.9 > entityiterator.m_20184_().m_7096_())) {
                     var46 = entityiterator.m_20184_().m_7096_();
                  } else {
                     var46 = entityiterator.m_20184_().m_7096_() + var46 * 0.1;
                  }

                  if (!(var55 * 1.1 < entityiterator.m_20184_().m_7098_()) && !(var55 * 0.9 > entityiterator.m_20184_().m_7098_())) {
                     var55 = entityiterator.m_20184_().m_7098_();
                  } else {
                     var55 = entityiterator.m_20184_().m_7098_() + var55 * 0.1;
                  }

                  if (!(var51 * 1.1 < entityiterator.m_20184_().m_7094_()) && !(var51 * 0.9 > entityiterator.m_20184_().m_7094_())) {
                     var51 = entityiterator.m_20184_().m_7094_();
                  } else {
                     var51 = entityiterator.m_20184_().m_7094_() + var51 * 0.1;
                  }

                  entityiterator.m_20256_(new Vec3(var46, var55, var51));
               }
            }
         }

         double var45 = range * (double)0.5F - (double)4.0F;
         double var43 = Math.toRadians(Math.random() * (double)360.0F);
         double var50 = Math.toRadians((Math.random() - (double)0.5F) * (double)180.0F);
         boolean var37 = Math.random() < (double)0.5F;

         for(int index0 = 0; index0 < 72; ++index0) {
            if (Math.random() < (double)0.5F) {
               double var40;
               double var42;
               double var54;
               if (var37) {
                  var40 = x_center + Math.cos(rad) * (Math.cos(var50) + Math.abs(Math.sin(var43) * Math.sin(var50))) * var45;
                  var54 = y_center + Math.sin(rad) * Math.sin(var50) * (double)-1.0F * var45;
                  var42 = z_center + Math.sin(rad) * (Math.cos(var50) + Math.abs(Math.cos(var43) * Math.sin(var50))) * var45;
               } else {
                  var40 = x_center + Math.cos(rad) * Math.cos(var50) * var45;
                  var54 = y_center + Math.sin(rad) * var45;
                  var42 = z_center + Math.cos(rad) * Math.sin(var50) * var45;
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123760_, var40, var54, var42, 1, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.0F);
               }
            }

            rad += Math.toRadians((double)10.0F * Math.random());
         }

      }
   }
}
