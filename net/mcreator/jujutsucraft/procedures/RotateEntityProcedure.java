package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class RotateEntityProcedure {
   public static void execute(double x, double y, double z, Entity entity) {
      if (entity != null) {
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double distance = (double)0.0F;
         double dx = (double)0.0F;
         double dy = (double)0.0F;
         double dz = (double)0.0F;
         double atan2_result = (double)0.0F;
         double distanceXZ = (double)0.0F;
         double ratio = (double)0.0F;
         dx = x - entity.m_20185_();
         dy = y - (entity.m_20186_() + (double)entity.m_20206_() * 0.9);
         dz = z - entity.m_20189_();
         yaw = Math.toDegrees(Math.atan2(dx, dz));
         Math.sqrt(dx * dx + dz * dz);
         distance = Math.sqrt(dx * dx + dz * dz + dy * dy);
         ratio = distance == (double)0.0F ? (double)0.0F : dy / distance;
         ratio = Math.max((double)-1.0F, Math.min((double)1.0F, ratio));
         pitch = Math.toDegrees((double)-1.0F * Math.asin(ratio));
         entity.m_146922_((float)((double)-1.0F * yaw));
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

      }
   }
}
