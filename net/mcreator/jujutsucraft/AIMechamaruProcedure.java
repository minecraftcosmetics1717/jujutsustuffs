package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIMechamaruProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double lv = (double)0.0F;
         double level = (double)0.0F;
         double setItem = (double)0.0F;
         if (entity.m_6084_()) {
            label61: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label61;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 8, false, false));
                  }
               }
            }

            label56: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label56;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)1.0F) {
               SkillEnergyWave2Procedure.execute(world, x, y, z, entity);
            } else {
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
                     if (LogicStartProcedure.execute(entity) && distance > (double)5.0F && Math.random() < 0.2) {
                        tick = (double)75.0F;
                        entity.getPersistentData().m_128347_("skill", (double)1.0F);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
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
}
