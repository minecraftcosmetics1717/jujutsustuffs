package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIYorozuProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double NUM2 = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                  AIActiveFlyingProcedure.execute(world, entity);
               }
            }

            label126: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label126;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 19, false, false));
                  }
               }
            }

            label121: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label121;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  rnd = (double)0.0F;
                  level = (double)0.0F;
                  tick = (double)0.0F;
                  if (LogicStartProcedure.execute(entity)) {
                     label110: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt13 = (LivingEntity)entity;
                           if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                              break label110;
                           }
                        }

                        if (entity.getPersistentData().m_128459_("cnt_target") > (double)200.0F) {
                           level = (double)0.0F;
                           rnd = (double)14.0F;
                           tick = (double)20.0F;
                        }
                     }

                     if (!LocateTrueSphereProcedure.execute(world, entity)) {
                        float var34;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var34 = _livEnt.m_21223_();
                        } else {
                           var34 = -1.0F;
                        }

                        double var35 = (double)var34;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var35 < (double)var10001 * (double)0.5F && Math.random() < (double)0.5F) {
                           level = (double)0.0F;
                           rnd = (double)15.0F;
                           tick = (double)20.0F;
                        }
                     }

                     if (Math.random() < (double)0.25F) {
                        if (!LocateLiquidMetalProcedure.execute(world, entity)) {
                           level = (double)0.0F;
                           rnd = (double)12.0F;
                           tick = (double)20.0F;
                        } else if (distance > (double)6.0F) {
                           if (Math.random() < (double)0.5F) {
                              level = (double)0.0F;
                              rnd = (double)8.0F;
                              tick = (double)10.0F;
                           } else {
                              level = (double)0.0F;
                              rnd = (double)9.0F;
                              tick = (double)25.0F;
                           }
                        }
                     }
                  }

                  if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity) || !AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() < 0.1) {
                     level = (double)0.0F;
                     rnd = (double)20.0F;
                     tick = (double)20.0F;
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)3900.0F + rnd);
                     if (level > (double)0.0F) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
