package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ReturnShadowProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM1 = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt4", (double)100.0F);
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
         }

         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
