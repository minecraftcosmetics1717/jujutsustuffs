package net.mcreator.jujutsucraft.procedures;

import java.util.Iterator;
import java.util.List;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIDomainLogicProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean cancel = false;
         Entity target_entity = null;
         double var10000 = Math.random();
         float var10002;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10002 = _livEnt.m_21223_();
         } else {
            var10002 = -1.0F;
         }

         var10002 = Math.max(var10002, 1.0F);
         float var10003;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10003 = _livEnt.m_21233_();
         } else {
            var10003 = -1.0F;
         }

         if (var10000 > (double)(1.0F - var10002 / Math.max(var10003, 1.0F)) * (double)0.75F) {
            cancel = true;
            LivingEntity var25;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var25 = _mobEnt.m_5448_();
            } else {
               var25 = null;
            }

            label126: {
               label136: {
                  var15 = var25;
                  if (var15 instanceof LivingEntity) {
                     LivingEntity _livEnt3 = var15;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label136;
                     }
                  }

                  if (!(var15 instanceof LivingEntity)) {
                     break label126;
                  }

                  LivingEntity _livEnt4 = var15;
                  if (!_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     break label126;
                  }
               }

               cancel = false;
            }

            if (((Entity)var15).getPersistentData().m_128459_("skill") % (double)100.0F == (double)20.0F) {
               cancel = false;
            }

            label115: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var26 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                     break label115;
                  }
               }

               var26 = 0;
            }

            if (var26 > 0) {
               cancel = false;
            }
         }

         if (!cancel) {
            label137: {
               if (entity.getPersistentData().m_128459_("cnt_target") < (double)200.0F) {
                  cancel = true;
               }

               label107: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                        var27 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                        break label107;
                     }
                  }

                  var27 = 0;
               }

               if (var27 >= 2) {
                  cancel = true;
               }

               label138: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt9 = (LivingEntity)entity;
                     if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label138;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label137;
                  }

                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (!_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label137;
                  }
               }

               cancel = true;
            }
         }

         if (!cancel && GetDistanceProcedure.execute(entity) > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
            cancel = true;
         }

         if (!cancel && entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F / (double)2.0F), (e) -> true);
            Iterator var23 = _entfound.iterator();

            while(true) {
               if (!var23.hasNext()) {
                  return cancel;
               }

               Entity entityiterator = (Entity)var23.next();
               if (entity != entityiterator && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt15 = (LivingEntity)entityiterator;
                     if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break;
                     }
                  }

                  if (entityiterator.getPersistentData().m_128459_("select") != (double)0.0F || entityiterator.getPersistentData().m_128459_("skill") % (double)100.0F == (double)20.0F) {
                     break;
                  }
               }
            }

            cancel = true;
         }

         return cancel;
      }
   }
}
