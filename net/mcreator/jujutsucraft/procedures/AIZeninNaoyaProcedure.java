package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ZeninNaobitoEntity;
import net.mcreator.jujutsucraft.entity.ZeninNaoyaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIZeninNaoyaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double distance = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            label89: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("cnt_special", entity.getPersistentData().m_128459_("cnt_special") + (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label89;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, entity instanceof ZeninNaobitoEntity ? 12 : 11, false, false));
                  }
               }
            }

            label84: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label84;
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)7.0F) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") == (double)5.0F && entity.getPersistentData().m_128459_("cnt_special") > (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_special", (double)-40.0F);
                  EntityUseProjectionSorceryProcedure.execute(entity);
               }

               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  if (LogicStartProcedure.execute(entity)) {
                     distance = GetDistanceProcedure.execute(entity);
                     if (distance > (double)0.0F && Math.random() < (double)1.0F) {
                        rnd = (double)1915.0F;
                        tick = (double)300.0F;
                     }

                     if (entity instanceof ZeninNaoyaEntity && distance < (double)48.0F && Math.random() < (double)0.25F) {
                        rnd = (double)1907.0F;
                        tick = (double)150.0F;
                     }
                  }

                  if (rnd > (double)0.0F) {
                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("skill", rnd);
                     if (entity instanceof LivingEntity) {
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
