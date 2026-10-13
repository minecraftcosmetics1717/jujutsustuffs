package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetHeightFromGroundProcedure {
   public static double execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         dis = (double)0.0F;

         for(int index0 = 0; index0 < 255 && world.m_46859_(BlockPos.m_274561_(x_pos, y_pos - dis, z_pos)); ++index0) {
            ++dis;
         }

         return dis;
      }
   }
}
