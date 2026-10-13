package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AttackContinueHigurumaProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean sword = false;
         boolean attack = false;
         boolean keep = false;
         double old_cnt1 = (double)0.0F;
         double old_skill = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
         sword = LogicSwordProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)4.0F);
            DamageFixProcedure.execute(entity);
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
            old_skill = entity.getPersistentData().m_128459_("skill");
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F;
            z_pos = entity.m_20189_();
            if (entity.getPersistentData().m_128459_("cnt5") <= (double)100.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
                  if (entity.getPersistentData().m_128459_("cnt5") > (double)40.0F) {
                     keep = false;
                  } else {
                     keep = true;
                  }

                  if (!keep) {
                     entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), (double)100.0F));
                  }
               }

               attack = entity.getPersistentData().m_128459_("cnt5") % (double)2.0F == (double)1.0F;
               if (attack || entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F) {
                  if (entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F) {
                     entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)2.5F));
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", -0.1 + entity.getPersistentData().m_128459_("cnt5") * 0.01);
                  }

                  if (entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F) {
                     AttackStrongProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  } else {
                     AttackWeakProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", old_cnt1);
               entity.getPersistentData().m_128347_("skill", old_skill);
            } else if (entity.getPersistentData().m_128459_("cnt5") > (double)110.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
