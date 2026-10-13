package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIKugisakiNobaraProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean weapon = false;
         double rnd = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            label95: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label95;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 4, false, false));
                  }
               }
            }

            label90: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label90;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
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
                  label81: {
                     entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt12 = (LivingEntity)entity;
                        if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label81;
                        }
                     }

                     if (distance > (double)3.0F && distance < (double)24.0F && entity.getPersistentData().m_128459_("cnt_nail") < (double)5.0F && Math.random() < (double)0.5F) {
                        rnd = (double)5.0F;
                        level = (double)1.0F;
                        tick = (double)3.0F;
                     }
                  }

                  if (LogicStartProcedure.execute(entity) && Math.pow((double)0.75F, entity.getPersistentData().m_128459_("cnt_nail")) < Math.random()) {
                     rnd = (double)6.0F;
                     level = (double)0.0F;
                     tick = (double)50.0F;
                  }

                  if (rnd > (double)0.0F) {
                     if (rnd == (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), (double)6.0F));
                        entity.getPersistentData().m_128347_("cnt_nail", entity.getPersistentData().m_128459_("cnt_nail") + (double)1.0F);
                     } else if (rnd == (double)6.0F) {
                        entity.getPersistentData().m_128347_("cnt_nail", Math.max(entity.getPersistentData().m_128459_("cnt_nail") - (double)10.0F, (double)0.0F));
                     }

                     entity.getPersistentData().m_128347_("skill", (double)3400.0F + rnd);
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
