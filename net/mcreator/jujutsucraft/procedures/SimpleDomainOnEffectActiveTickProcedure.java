package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SimpleDomainOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10000;
         label128: {
            boolean logic_infinity = false;
            double z_pos = (double)0.0F;
            double num3 = (double)0.0F;
            double strength = (double)0.0F;
            double num1 = (double)0.0F;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double pitch = (double)0.0F;
            double yaw = (double)0.0F;
            double num2 = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                  break label128;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0 && LogicSimpleDomainProcedure.execute()) {
            label120: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label120;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 5 == 1) {
               SimpleDomainEffectStartedappliedProcedure.execute(world, x, y, z, entity);
            }

            if (!ActiveTickConditionProcedure.execute(entity)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               return;
            }

            label112: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label112;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 2 == 1) {
               label136: {
                  double var34 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                  double var39 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                  if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_hollow_wicker_basket")))) {
                     label134: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt5 = (LivingEntity)entity;
                           if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label134;
                           }
                        }

                        if (!(entity instanceof Player) || var34 != (double)1.0F && var39 != (double)1.0F && var34 != (double)7.0F && var39 != (double)7.0F && var34 != (double)12.0F && var39 != (double)12.0F && var34 != (double)24.0F && var39 != (double)24.0F && var34 != (double)44.0F && var39 != (double)44.0F && var34 != (double)45.0F && var39 != (double)45.0F) {
                           break label136;
                        }
                     }
                  }

                  double var38 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double var37 = Math.toRadians((double)entity.m_146909_());
                  double var35 = entity.m_20185_() + Math.cos(var38) * Math.cos(var37) * (double)(-1.0F - entity.m_20205_());
                  double var36 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
                  double var33 = entity.m_20189_() + Math.sin(var38) * Math.cos(var37) * (double)(-1.0F - entity.m_20205_());
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_HOLLOW_WICKER_BASKET.get(), var35, var36, var33, 0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
                  }
               }
            }

            int var10002;
            label83: {
               var50 = (double)entity.m_20205_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label83;
                  }
               }

               var10002 = 0;
            }

            double var40 = var50 + 0.025 * (double)var10002;
            var40 = Math.min(var40, entity.getPersistentData().m_128459_("skill") == (double)3105.0F ? (double)16.0F : (double)4.0F);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(var40 * (double)2.0F / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && entity.m_20186_() + (double)entity.m_20206_() >= entityiterator.m_20186_() && entity.m_20186_() <= entityiterator.m_20186_() + (double)entityiterator.m_20206_()) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 5, 0, true, true));
                     }
                  }
                  break;
               }
            }
         }

      }
   }
}
