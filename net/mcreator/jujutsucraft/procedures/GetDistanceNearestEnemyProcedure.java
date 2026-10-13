package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GetDistanceNearestEnemyProcedure {
   public static double execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double distance = (double)0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         distance = var10000 instanceof LivingEntity ? GetDistanceProcedure.execute(entity) : (double)999.0F;
         Vec3 _center = new Vec3(entity.m_20185_() + entity.m_20154_().f_82479_ * (double)16.0F, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.m_20154_().f_82480_ * (double)16.0F, entity.m_20189_() + entity.m_20154_().f_82481_ * (double)16.0F);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true)) {
            if (entity != entityiterator && !(entityiterator instanceof Projectile)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     label69: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt12 = (LivingEntity)entity;
                           if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label69;
                           }
                        }

                        if (!AntiInfinityProcedure.execute(entityiterator)) {
                           continue;
                        }
                     }
                  }
               }

               if (entityiterator instanceof Player) {
                  if (entityiterator instanceof Player) {
                     Player _plr = (Player)entityiterator;
                     if (_plr.m_150110_().f_35937_) {
                        continue;
                     }
                  }

                  if (((<undefinedtype>)(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                        } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                           return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                        } else {
                           return false;
                        }
                     }
                  })).checkGamemode(entityiterator)) {
                     continue;
                  }
               } else {
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if ((!(var10000 instanceof LivingEntity) || !(entityiterator.getPersistentData().m_128459_("cnt_target") > (double)6.0F)) && !(entityiterator.getPersistentData().m_128459_("Damage") > (double)0.0F) && !(entityiterator.getPersistentData().m_128459_("skill") > (double)0.0F)) {
                     continue;
                  }
               }

               if (LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator.m_6084_()) {
                  distance = Math.min(distance, GetDistanceIteratorProcedure.execute(entity, entityiterator));
               }
            }
         }

         return distance;
      }
   }
}
