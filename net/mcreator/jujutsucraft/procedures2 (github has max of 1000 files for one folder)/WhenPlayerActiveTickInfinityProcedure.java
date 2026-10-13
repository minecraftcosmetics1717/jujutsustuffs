package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class WhenPlayerActiveTickInfinityProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double strength = (double)0.0F;
         double infinity_level = (double)0.0F;
         if (entity.getPersistentData().m_128471_("infinity") && ActiveTickConditionProcedure.execute(entity) && LogicStartPassiveProcedure.execute(entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  return;
               }
            }

            int var10000;
            label82: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                     break label82;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 0) {
               strength = (double)0.0F;
               infinity_level = (double)-1.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     label74: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label74;
                           }
                        }

                        var10000 = 0;
                     }

                     strength = (double)(var10000 + 1);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     label63: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                              var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19564_();
                              break label63;
                           }
                        }

                        var10000 = 0;
                     }

                     infinity_level = (double)(var10000 + 0);
                  }
               }

               label54: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19557_();
                        break label54;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 < 15) {
                  if (infinity_level < strength) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), 18, (int)Math.round(infinity_level + (double)1.0F)));
                        }
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), 18, (int)infinity_level));
                     }
                  }
               }
            }
         }

      }
   }
}
