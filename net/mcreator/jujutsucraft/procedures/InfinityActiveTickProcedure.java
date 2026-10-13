package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InfinityActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         int var10000;
         label149: {
            boolean isRangedAmmo = false;
            boolean isProjectile = false;
            boolean logic_infinity = false;
            double dx = (double)0.0F;
            double myNameRangedRanged = (double)0.0F;
            double dy = (double)0.0F;
            double dz = (double)0.0F;
            double myNameRanged = (double)0.0F;
            double velocity = (double)0.0F;
            double T1 = (double)0.0F;
            double T2 = (double)0.0F;
            double infinity_radius = (double)0.0F;
            double distance = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19557_();
                  break label149;
               }
            }

            var10000 = 0;
         }

         label163: {
            if (var10000 % 10 == 5) {
               if (!ActiveTickConditionProcedure.execute(entity) || !LogicStartPassiveProcedure.execute(entity)) {
                  break label163;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     break label163;
                  }
               }

               label140: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                        break label140;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 > 0) {
                  break label163;
               }

               if (entity instanceof Player) {
                  label125: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                           break label125;
                        }
                     }

                     JujutsucraftModVariables.PlayerVariables pVars = null;
                     pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
                     pVars.PlayerCursePowerChange -= (double)5.0F;
                     if (pVars.PlayerCursePower + pVars.PlayerCursePowerChange <= (double)0.0F) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }

                        return;
                     }
                  }
               }
            }

            double var38 = entity.getPersistentData().m_128459_("NameRanged");
            double var35 = entity.getPersistentData().m_128459_("NameRanged_ranged");
            double var40 = (double)(8.0F + Math.max(entity.m_20205_() * 2.0F, entity.m_20206_() * 2.0F) * 2.0F);
            Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(var40 / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator) {
                  boolean var33 = false;
                  boolean var32 = entityiterator instanceof Projectile;
                  boolean var31 = entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entityiterator.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F;
                  Vec3 vel = entityiterator.m_20184_();
                  if (var32) {
                     Entity var52;
                     if (entityiterator instanceof TraceableEntity) {
                        TraceableEntity _traceableEntity = (TraceableEntity)entityiterator;
                        var52 = _traceableEntity.m_19749_();
                     } else {
                        var52 = null;
                     }

                     if (var52 != entity) {
                        double var34 = entity.m_20185_() - entityiterator.m_20185_();
                        double var36 = _center.f_82480_ - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                        double var37 = entity.m_20189_() - entityiterator.m_20189_();
                        double var39 = vel.m_82556_();
                        if (var34 * vel.f_82479_ + var36 * vel.f_82480_ + var37 * vel.f_82481_ > (double)0.0F || entityiterator.getPersistentData().m_128471_("Stop")) {
                           double var41 = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           if (var41 < var40 * (double)0.25F) {
                              var33 = true;
                           } else if (var41 > (double)0.0F && var39 > var41 * var41) {
                              entityiterator.m_20256_(new Vec3(vel.f_82479_ / var41 * var40 * (double)0.25F, vel.f_82480_ / var41 * var40 * (double)0.25F, vel.f_82481_ / var41 * var40 * (double)0.25F));
                           }
                        }
                     }
                  }

                  if (var31) {
                     var33 = true;
                     if (var35 != (double)0.0F && (var35 == entityiterator.getPersistentData().m_128459_("NameRanged") || var35 == entityiterator.getPersistentData().m_128459_("NameRanged_ranged")) || var38 != (double)0.0F && (var38 == entityiterator.getPersistentData().m_128459_("NameRanged_ranged") || var38 == entityiterator.getPersistentData().m_128459_("NameRanged"))) {
                        continue;
                     }

                     double var42 = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                     if (var42 > var40 * (double)0.25F) {
                        continue;
                     }
                  }

                  if (var33) {
                     if (!entityiterator.getPersistentData().m_128471_("Stop")) {
                        entityiterator.getPersistentData().m_128379_("Stop", true);
                     }

                     if (var32) {
                        entityiterator.m_146926_(entityiterator.m_146909_());
                        entityiterator.m_146922_(entityiterator.m_146908_());
                        entityiterator.m_20256_(new Vec3(entityiterator.m_20154_().f_82479_ * 1.0E-5, entityiterator.m_20154_().f_82480_ * 1.0E-5, entityiterator.m_20154_().f_82481_ * 1.0E-5));
                        entityiterator.f_19789_ = 0.0F;
                        if (entityiterator instanceof Arrow || entityiterator instanceof SpectralArrow) {
                           entityiterator.f_19812_ = true;
                           entityiterator.f_19864_ = true;
                        }
                     } else {
                        entityiterator.m_20256_(Vec3.f_82478_);
                     }
                  }
               }
            }

            return;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
         }

      }
   }
}
