package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class GetDistanceProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         Entity target_entity = null;
         double y_distance = (double)0.0F;
         double widthTotal = (double)0.0F;
         double z_distance = (double)0.0F;
         double x_distance = (double)0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (!(target_entity instanceof LivingEntity)) {
            return (double)999.0F;
         } else {
            if (target_entity.m_20186_() > entity.m_20186_()) {
               y_distance = Math.max(target_entity.m_20186_() - (entity.m_20186_() + (double)entity.m_20206_()), (double)0.0F);
            } else {
               y_distance = Math.max(entity.m_20186_() - (target_entity.m_20186_() + (double)target_entity.m_20206_()), (double)0.0F);
            }

            widthTotal = (double)entity.m_20205_() * (double)0.5F + (double)target_entity.m_20205_() * (double)0.5F;
            x_distance = Math.max(Math.abs(entity.m_20185_() - target_entity.m_20185_()) - widthTotal, (double)0.0F);
            z_distance = Math.max(Math.abs(entity.m_20189_() - target_entity.m_20189_()) - widthTotal, (double)0.0F);
            return Math.sqrt(x_distance * x_distance + y_distance * y_distance + z_distance * z_distance);
         }
      }
   }
}
