package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AITakakoUroProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (LogicStartPassiveProcedure.execute(entity)) {
               AIActiveFlyingProcedure.execute(world, entity);
            }

            label111: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label111;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 15, false, false));
                  }
               }
            }

            label106: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label106;
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  rnd = (double)0.0F;
                  level = (double)0.0F;
                  tick = (double)0.0F;
                  if (LogicStartProcedure.execute(entity)) {
                     label122: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt13 = (LivingEntity)entity;
                           if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label122;
                           }
                        }

                        if (Math.random() < 0.1) {
                           level = (double)0.0F;
                           rnd = (double)10.0F;
                           tick = (double)100.0F;
                        }
                     }
                  }

                  if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity) || !AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() < 0.025) {
                     level = (double)0.0F;
                     rnd = (double)20.0F;
                     tick = (double)20.0F;
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)3800.0F + rnd);
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
               rnd = (double)0.0F;
               if (LogicStartPassiveProcedure.execute(entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 5, 0, false, false));
                     }
                  }

                  if (GetHeightFromGroundProcedure.execute(world, entity) < (double)12.0F && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19620_, 5, 0, false, false));
                     }
                  }
               }
            }
         }

      }
   }
}
