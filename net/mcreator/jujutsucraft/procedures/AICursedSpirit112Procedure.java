package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit112Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logicStart = false;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double level = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double pitch_cal = (double)0.0F;
         double yaw = (double)0.0F;
         double yaw_cal = (double)0.0F;
         if (entity.m_6084_()) {
            label131: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label131;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            label126: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label126;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
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
                  distance = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  logicStart = LogicStartProcedure.execute(entity);
                  if (!LogicCooldownCombatProcedure.execute(entity) && Math.random() < (double)0.5F && distance < (double)32.0F) {
                     level = (double)1.0F;
                     rnd = (double)4705.0F;
                     tick = (double)50.0F;
                  }

                  if (logicStart) {
                     if (Math.random() < (double)0.75F && distance > (double)8.0F && distance < (double)32.0F) {
                        level = (double)0.0F;
                        rnd = (double)4706.0F;
                        tick = (double)25.0F;
                     }

                     if (Math.random() < (double)0.5F && distance > (double)4.0F && distance < (double)32.0F) {
                        level = (double)0.0F;
                        rnd = (double)4707.0F;
                        tick = (double)50.0F;
                     }

                     if (Math.random() < (double)0.25F && distance < (double)32.0F) {
                        level = (double)0.0F;
                        rnd = (double)4708.0F;
                        tick = (double)200.0F;
                     }

                     if (Math.random() < 0.3 && distance < (double)32.0F) {
                        level = (double)0.0F;
                        rnd = (double)4709.0F;
                        tick = (double)150.0F;
                     }

                     if (Math.random() < 0.3 && distance < (double)12.0F) {
                        level = (double)0.0F;
                        rnd = (double)4710.0F;
                        tick = (double)50.0F;
                     }

                     float var37;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var37 = _livEnt.m_21223_();
                     } else {
                        var37 = -1.0F;
                     }

                     double var38 = (double)var37;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var38 <= (double)var10001 * (double)0.25F) {
                        if (!entity.getPersistentData().m_128471_("flag1")) {
                           entity.getPersistentData().m_128379_("flag1", true);
                           level = (double)0.0F;
                           rnd = (double)4715.0F;
                           tick = (double)250.0F;
                        }
                     } else {
                        entity.getPersistentData().m_128379_("flag1", false);
                     }
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(rnd));
                     if (level > (double)0.0F) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), Integer.MAX_VALUE, 0, false, false));
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
