package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade19Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit19Procedure {
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
            label78: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label78;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            label73: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label73;
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
               entity.getPersistentData().m_128347_("cnt_x2", Math.max(entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F, (double)0.0F));
               if (entity.getPersistentData().m_128459_("cnt_x2") % (double)60.0F == (double)40.0F && entity instanceof CursedSpiritGrade19Entity) {
                  CursedSpiritGrade19Entity animatable = (CursedSpiritGrade19Entity)entity;
                  animatable.setTexture("cursedspirit1_9_2");
               }

               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)1.0F);
                  ResetCounterProcedure.execute(entity);
                  logicStart = LogicStartProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  if (logicStart && distance > (double)3.0F && Math.random() < (double)0.25F) {
                     level = (double)0.0F;
                     tick = (double)100.0F;
                     entity.getPersistentData().m_128347_("skill", (double)153.0F);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, (int)level, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_x2", Math.min(entity.getPersistentData().m_128459_("cnt_x2") - (double)1.0F, (double)0.0F));
               if (Math.abs(entity.getPersistentData().m_128459_("cnt_x2")) % (double)60.0F == (double)40.0F && entity instanceof CursedSpiritGrade19Entity) {
                  CursedSpiritGrade19Entity animatable = (CursedSpiritGrade19Entity)entity;
                  animatable.setTexture("cursedspirit1_9");
               }
            }
         }

      }
   }
}
