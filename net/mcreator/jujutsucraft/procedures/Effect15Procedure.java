package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Effect15Procedure {
   public static void execute(Entity entityiterator) {
      if (entityiterator != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         double CNT6 = (double)0.0F;
         double picth = (double)0.0F;
         double num1 = (double)0.0F;
         double range = (double)0.0F;
         double yaw = (double)0.0F;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 4, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 40, 4, false, false));
            }
         }

         if (entityiterator.getPersistentData().m_128459_("skill") != (double)0.0F && entityiterator.getPersistentData().m_128471_("attack")) {
            entityiterator.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
