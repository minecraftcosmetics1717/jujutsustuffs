package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CurseUserEntity;
import net.mcreator.jujutsucraft.entity.JujutsuSorcererEntity;
import net.mcreator.jujutsucraft.entity.KukuruEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIMobProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double level = (double)0.0F;
         double level_power = (double)0.0F;
         double level_resistance = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof JujutsuSorcererEntity) {
               double var10000;
               if (entity instanceof JujutsuSorcererEntity) {
                  JujutsuSorcererEntity _datEntI = (JujutsuSorcererEntity)entity;
                  var10000 = (double)(Integer)_datEntI.m_20088_().m_135370_(JujutsuSorcererEntity.DATA_power);
               } else {
                  var10000 = (double)0.0F;
               }

               level = var10000;
            } else if (entity instanceof CurseUserEntity) {
               double var28;
               if (entity instanceof CurseUserEntity) {
                  CurseUserEntity _datEntI = (CurseUserEntity)entity;
                  var28 = (double)(Integer)_datEntI.m_20088_().m_135370_(CurseUserEntity.DATA_power);
               } else {
                  var28 = (double)0.0F;
               }

               level = var28;
            } else {
               level = entity instanceof KukuruEntity ? (double)3.0F : (double)0.0F;
            }

            label76: {
               level_power = level < (double)3.0F ? Math.min(level, (double)1.0F) : level;
               level_resistance = (double)Math.round(level < (double)3.0F ? (double)0.0F : Math.min(level / (double)4.0F, (double)3.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                     break label76;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)level_power, false, false));
                  }
               }
            }

            label71: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                     break label71;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)level_resistance, false, false));
                  }
               }
            }

            LivingEntity var29;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var29 = _mobEnt.m_5448_();
            } else {
               var29 = null;
            }

            if (var29 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
