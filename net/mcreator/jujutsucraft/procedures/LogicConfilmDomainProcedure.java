package net.mcreator.jujutsucraft.procedures;

import java.util.Iterator;
import java.util.List;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LogicConfilmDomainProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean use = false;
         Entity target_entity = null;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         label197: {
            label190: {
               label198: {
                  var16 = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt1 = (LivingEntity)entity;
                     if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) && var16 instanceof GojoSatoruEntity) {
                        break label198;
                     }
                  }

                  if (!(var16 instanceof LivingEntity)) {
                     break label190;
                  }

                  LivingEntity _livEnt3 = var16;
                  if (!_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || !(entity instanceof GojoSatoruEntity)) {
                     break label190;
                  }
               }

               if (var16 instanceof LivingEntity && (entity.getPersistentData().m_128459_("cnt_target") > (double)600.0F || ((Entity)var16).getPersistentData().m_128459_("cnt_target") > (double)600.0F)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label197;
                     }
                  }

                  if (var16 instanceof LivingEntity) {
                     LivingEntity _livEnt9 = var16;
                     if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label197;
                     }
                  }

                  if (entity.getPersistentData().m_128459_("skill") == (double)0.0F && ((Entity)var16).getPersistentData().m_128459_("skill") == (double)0.0F) {
                     if (var16 instanceof LivingEntity) {
                        LivingEntity _livEnt12 = var16;
                        if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           label158: {
                              if (var16 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var16;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var29 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                    break label158;
                                 }
                              }

                              var29 = 0;
                           }

                           if (var29 <= 1000) {
                              break label197;
                           }
                        }
                     }

                     use = true;
                  }
               }
               break label197;
            }

            label151: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var28 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                     break label151;
                  }
               }

               var28 = 0;
            }

            if (var28 > 0) {
               use = true;
            }
         }

         if (!use) {
            if (var16 instanceof LivingEntity) {
               label142: {
                  if (var16 instanceof LivingEntity) {
                     LivingEntity _livEnt = var16;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var30 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                        break label142;
                     }
                  }

                  var30 = 0;
               }

               if (var30 > 1000 || ((Entity)var16).getPersistentData().m_128459_("select") != (double)0.0F || ((Entity)var16).getPersistentData().m_128459_("skill") % (double)100.0F == (double)20.0F) {
                  use = true;
               }
            }

            if (entity.getPersistentData().m_128471_("flag_domain")) {
               use = true;
            }
         }

         if (use) {
            label201: {
               label129: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                        var31 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                        break label129;
                     }
                  }

                  var31 = 0;
               }

               if (var31 >= 2) {
                  use = false;
               }

               label202: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt21 = (LivingEntity)entity;
                     if (_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label202;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label201;
                  }

                  LivingEntity _livEnt22 = (LivingEntity)entity;
                  if (!_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label201;
                  }
               }

               use = false;
            }
         }

         if (use && GetDistanceProcedure.execute(entity) > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - (double)4.0F) {
            use = false;
         }

         if (use && entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
            label203: {
               Vec3 _center = new Vec3(x, y, z);
               List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F / (double)2.0F), (e) -> true);
               Iterator var25 = _entfound.iterator();

               while(true) {
                  if (!var25.hasNext()) {
                     break label203;
                  }

                  Entity entityiterator = (Entity)var25.next();
                  if (entity != entityiterator && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt27 = (LivingEntity)entityiterator;
                        if (_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break;
                        }
                     }

                     if (entityiterator.getPersistentData().m_128459_("skill") != (double)0.0F && (entityiterator.getPersistentData().m_128459_("select") != (double)0.0F || entityiterator.getPersistentData().m_128459_("skill") % (double)100.0F == (double)20.0F)) {
                        break;
                     }
                  }
               }

               use = false;
            }
         }

         if (use) {
            entity.getPersistentData().m_128379_("flag_domain", false);
         }

         return use;
      }
   }
}
