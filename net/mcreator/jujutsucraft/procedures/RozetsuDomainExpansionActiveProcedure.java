package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RozetsuDomainExpansionActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label78: {
            double distance = (double)0.0F;
            double ticks = (double)0.0F;
            double num1 = (double)0.0F;
            range = (double)0.0F;
            double rad1 = (double)0.0F;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double x_center = (double)0.0F;
            double z_center = (double)0.0F;
            double y_center = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label78;
               }
            }

            var10000 = (double)0.0F;
         }

         double var30 = var10000;
         double var37 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var39 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var38 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (var30 % (double)10.0F == (double)0.0F) {
            entity.getPersistentData().m_128379_("onlyLiving", true);
            Vec3 _center = new Vec3(var37, var39, var38);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ranged_ammo")))) {
                  double var31 = (double)20.0F;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)var31, 0, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), (int)var31, 0, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)var31, 1, false, false));
                     }
                  }
               }
            }

            entity.getPersistentData().m_128379_("onlyLiving", false);
         }

         if (!entity.getPersistentData().m_128471_("Failed")) {
            double var33 = Math.toRadians((double)90.0F * (var30 % (double)4.0F));
            double var29 = (double)4.0F * var30 % (range * (double)0.5F - (double)5.0F);

            for(int index0 = 0; index0 < 4; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.95)) {
                     var33 += Math.toRadians((double)10.0F * Math.random());
                     double var34 = var37 + Math.cos(var33) * var29;
                     double var35 = var39 + 0.1;
                     double var36 = var38 + Math.sin(var33) * var29;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123784_, var34, var35, var36, 1, (double)1.0F, (double)1.0F, (double)1.0F, 0.05);
                     }
                  }
               }

               ++var29;
            }
         }

      }
   }
}
