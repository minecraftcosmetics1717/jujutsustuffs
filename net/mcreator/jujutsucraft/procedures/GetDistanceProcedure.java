package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class GetDistanceProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0D;
      } else {
         Entity target_entity = null;
         double y_distance = 0.0D;
         double widthTotal = 0.0D;
         double z_distance = 0.0D;
         double x_distance = 0.0D;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (!(target_entity instanceof LivingEntity)) {
            return 999.0D;
         } else {
            if (target_entity.getY() > entity.getY()) {
               y_distance = Math.max(target_entity.getY() - (entity.getY() + (double)entity.getBbHeight()), 0.0D);
            } else {
               y_distance = Math.max(entity.getY() - (target_entity.getY() + (double)target_entity.getBbHeight()), 0.0D);
            }

            widthTotal = (double)entity.getBbWidth() * 0.5D + (double)target_entity.getBbWidth() * 0.5D;
            x_distance = Math.max(Math.abs(entity.getX() - target_entity.getX()) - widthTotal, 0.0D);
            z_distance = Math.max(Math.abs(entity.getZ() - target_entity.getZ()) - widthTotal, 0.0D);
            return Math.sqrt(x_distance * x_distance + y_distance * y_distance + z_distance * z_distance);
         }
      }
   }
}