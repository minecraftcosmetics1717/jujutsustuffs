package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class Effect2Procedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         Entity entity_a = null;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)(entityiterator.m_20206_() * 0.0F);
         z_pos = entityiterator.m_20189_();
         Effect4Procedure.execute(world, entity, entityiterator);
         entity.getPersistentData().m_128347_("BlockRange", (double)4.0F);
         entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F);
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
      }
   }
}
