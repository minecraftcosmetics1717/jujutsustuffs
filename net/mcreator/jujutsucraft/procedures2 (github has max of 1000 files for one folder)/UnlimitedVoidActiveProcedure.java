package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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

public class UnlimitedVoidActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double rad;
         double range;
         double var10000;
         label145: {
            boolean logic_a = false;
            double distance = (double)0.0F;
            double ticks = (double)0.0F;
            range = (double)0.0F;
            double rad1 = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double dis = (double)0.0F;
            rad = (double)0.0F;
            double rad_now = (double)0.0F;
            double num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            double num2 = (double)0.0F;
            double x_center = (double)0.0F;
            double y_center = (double)0.0F;
            double z_center = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            double x_power = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label145;
               }
            }

            var10000 = (double)0.0F;
         }

         double var48 = var10000;
         double var66 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var67 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var68 = entity.getPersistentData().m_128459_("z_pos_doma");
         if ((var48 % (double)5.0F == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) && !entity.getPersistentData().m_128471_("Failed")) {
            entity.getPersistentData().m_128379_("StartDomainAttack", false);
            entity.getPersistentData().m_128379_("onlyLiving", true);
            Vec3 _center = new Vec3(var66, var67, var68);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  double var60;
                  if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                     var60 = (double)150.0F;
                  } else {
                     var60 = (double)350.0F;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 4, false, false));
                        }
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)var60, 99, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, (int)var60, 99, false, false));
                     }
                  }

                  if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ranged_ammo")))) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, (int)var60, 99, false, false));
                        }
                     }

                     if (entityiterator.getPersistentData().m_128459_("skill") != (double)-999.0F && entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }

                     entityiterator.getPersistentData().m_128347_("skill", (double)-999.0F);
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (int)var60, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)var60, 0, false, false));
                        }
                     }

                     entityiterator.getPersistentData().m_128347_("skill", (double)-999.0F);
                  }
               }
            }

            entity.getPersistentData().m_128379_("onlyLiving", false);
            if (Math.random() < 0.1) {
               double var61 = Math.toRadians(Math.random() * (double)360.0F);
               double var65 = range * (double)0.5F - (double)6.0F;
               double var51 = var66 + Math.sin(var61) * var65;
               double var62 = var67 + (double)2.0F;
               double var54 = var68 + Math.cos(var61) * var65;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID.get(), var51, var62, var54, 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.0F);
               }
            }
         }

         double var58 = range * (double)0.5F - (double)8.0F;
         double var57 = Math.toRadians(Math.random() * (double)360.0F);
         double var59 = Math.toRadians((Math.random() - (double)0.5F) * (double)180.0F);
         boolean var46 = Math.random() < (double)0.5F;

         for(int index0 = 0; index0 < 72; ++index0) {
            if (Math.random() < (double)0.25F) {
               double var52;
               double var55;
               double var63;
               if (var46) {
                  var52 = var66 + Math.cos(rad) * (Math.cos(var59) + Math.abs(Math.sin(var57) * Math.sin(var59))) * var58;
                  var63 = var67 + Math.abs(Math.sin(rad) * Math.sin(var59) * (double)-1.0F * var58);
                  var55 = var68 + Math.sin(rad) * (Math.cos(var59) + Math.abs(Math.cos(var57) * Math.sin(var59))) * var58;
               } else {
                  var52 = var66 + Math.cos(rad) * Math.cos(var59) * var58;
                  var63 = var67 + Math.abs(Math.sin(rad) * var58);
                  var55 = var68 + Math.cos(rad) * Math.sin(var59) * var58;
               }

               if (!entity.getPersistentData().m_128471_("Failed") && var48 % (double)40.0F == (double)0.0F && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID.get(), var52, var63, var55, 1, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.0F);
               }

               if (Math.random() < (double)0.5F && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123810_, var52, var63, var55, 1, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.0F);
               }
            }

            rad += Math.toRadians((double)10.0F * Math.random());
         }

         double var50 = Math.toRadians((double)90.0F * (var48 % (double)4.0F));
         double var47 = (double)4.0F * var48 % (range * (double)0.5F - (double)5.0F);

         for(int index1 = 0; index1 < 5; ++index1) {
            for(int index2 = 0; index2 < 72; ++index2) {
               var50 += Math.toRadians((double)10.0F * Math.random());
               if (Math.random() < 0.025) {
                  double var53 = var66 + Math.cos(var50) * var47;
                  double var64 = var67 + (double)0.25F;
                  double var56 = var68 + Math.sin(var50) * var47;
                  ParticleGeneratorProcedure.execute(world, (double)0.5F, (double)1.0F, (double)0.0F, (double)1.0F * ((double)1.0F - var47 / (range * (double)0.5F - (double)5.0F)), var53, var66 + Math.cos(var50) * (var47 + (double)1.0F), var64, var67 + (double)0.25F + Math.random() * (double)0.25F * (double)1.0F * (var47 / (range * (double)0.5F - (double)5.0F)), var56, var68 + Math.sin(var50) * (var47 + (double)1.0F), "minecraft:end_rod");
               }
            }

            ++var47;
         }

      }
   }
}
