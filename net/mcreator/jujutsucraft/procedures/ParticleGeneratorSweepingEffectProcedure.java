package net.mcreator.jujutsucraft.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class ParticleGeneratorSweepingEffectProcedure {
   public static void execute(LevelAccessor world, double count, double inaccuracyDegree, double pitch, double radius1, double radius2, double rollDegree, double speed, double x1, double x2, double y1, double y2, double yaw, double z1, double z2, String id) {
      if (id != null) {
         double up_z = (double)0.0F;
         double up_x = (double)0.0F;
         double cosTheta = (double)0.0F;
         double pitch_rad = (double)0.0F;
         double up_y = (double)0.0F;
         double normal_z = (double)0.0F;
         double normal_y = (double)0.0F;
         double x_pos = (double)0.0F;
         double normal_x = (double)0.0F;
         double z_pos = (double)0.0F;
         double roll_rad = (double)0.0F;
         double look_dir_x = (double)0.0F;
         double look_dir_y = (double)0.0F;
         double yaw_rad = (double)0.0F;
         double rad = (double)0.0F;
         double y_pos = (double)0.0F;
         double look_dir_z = (double)0.0F;
         double sinTheta = (double)0.0F;
         yaw_rad = Math.toRadians(yaw + (double)90.0F);
         pitch_rad = Math.toRadians(pitch * (double)-1.0F - (double)90.0F);
         roll_rad = Math.toRadians(rollDegree);
         normal_x = Math.cos(Math.toRadians(yaw));
         normal_y = (double)0.0F;
         normal_z = Math.sin(Math.toRadians(yaw));
         look_dir_x = Math.cos(yaw_rad) * Math.cos(pitch_rad);
         look_dir_y = Math.sin(pitch_rad);
         look_dir_z = Math.sin(yaw_rad) * Math.cos(pitch_rad);
         up_x = look_dir_y * normal_z - look_dir_z * normal_y;
         up_y = look_dir_z * normal_x - look_dir_x * normal_z;
         up_z = look_dir_x * normal_y - look_dir_y * normal_x;

         for(int index0 = 0; index0 < (int)Math.max(count, (double)1.0F); ++index0) {
            rad = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F) * inaccuracyDegree);
            cosTheta = Math.cos(rad);
            sinTheta = Math.sin(rad);
            x_pos = cosTheta * up_x + sinTheta * normal_x;
            y_pos = cosTheta * up_y + sinTheta * normal_y;
            z_pos = cosTheta * up_z + sinTheta * normal_z;
            ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, speed, x1 + x_pos * radius1, x2 + x_pos * radius2, y1 + y_pos * radius1, y2 + y_pos * radius2, z1 + z_pos * radius1, z2 + z_pos * radius2, id);
         }

      }
   }
}
