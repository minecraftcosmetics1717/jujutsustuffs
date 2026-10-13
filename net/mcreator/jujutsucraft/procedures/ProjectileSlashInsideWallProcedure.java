package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ProjectileSlashInsideWallProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, boolean vertical) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         double x_center = (double)0.0F;
         double distance = (double)0.0F;
         double z_center = (double)0.0F;
         double x_pos = (double)0.0F;
         double range_fix = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_center = (double)0.0F;
         double yaw = (double)0.0F;
         range_fix = Math.max(ReturnEntitySizeProcedure.execute(entity), (double)1.0F);
         x_pos = x;
         y_pos = y;
         z_pos = z;
         if (!logic_a) {
            if (vertical) {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)(entity.m_146909_() + 90.0F));
            } else {
               yaw = Math.toRadians((double)(entity.m_146908_() + 0.0F));
               pitch = Math.toRadians((double)0.0F);
            }

            distance = (double)0.0F;

            for(int index0 = 0; index0 < (int)Math.max(Math.round((double)6.0F * range_fix), 2L); ++index0) {
               distance += (double)0.5F;
               x_center = x_pos + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_center = y_pos + Math.sin(pitch) * (double)-1.0F * distance;
               z_center = z_pos + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (!world.m_46859_(BlockPos.m_274561_(x_center, y_center, z_center))) {
                  logic_a = true;
                  break;
               }
            }
         }

         if (!logic_a) {
            if (vertical) {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)(entity.m_146909_() - 90.0F));
            } else {
               yaw = Math.toRadians((double)(entity.m_146908_() + 180.0F));
               pitch = Math.toRadians((double)0.0F);
            }

            distance = (double)0.0F;

            for(int index1 = 0; index1 < (int)Math.max(Math.round((double)6.0F * range_fix), 2L); ++index1) {
               distance += (double)0.5F;
               x_center = x_pos + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_center = y_pos + Math.sin(pitch) * (double)-1.0F * distance;
               z_center = z_pos + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (!world.m_46859_(BlockPos.m_274561_(x_center, y_center, z_center))) {
                  logic_a = true;
                  break;
               }
            }
         }

         return logic_a;
      }
   }
}
