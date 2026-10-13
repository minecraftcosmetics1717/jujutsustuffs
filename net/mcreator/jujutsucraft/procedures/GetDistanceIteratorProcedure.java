package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class GetDistanceIteratorProcedure {
   public static double execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double distance = (double)0.0F;
         double y_distance = (double)0.0F;
         double widthTotal = (double)0.0F;
         double z_distance = (double)0.0F;
         double x_distance = (double)0.0F;
         if (entityiterator.m_20186_() > entity.m_20186_()) {
            y_distance = Math.max(entityiterator.m_20186_() - (entity.m_20186_() + (double)entity.m_20206_()), (double)0.0F);
         } else {
            y_distance = Math.max(entity.m_20186_() - (entityiterator.m_20186_() + (double)entityiterator.m_20206_()), (double)0.0F);
         }

         widthTotal = (double)entity.m_20205_() * (double)0.5F + (double)entityiterator.m_20205_() * (double)0.5F;
         x_distance = Math.max(Math.abs(entity.m_20185_() - entityiterator.m_20185_()) - widthTotal, (double)0.0F);
         z_distance = Math.max(Math.abs(entity.m_20189_() - entityiterator.m_20189_()) - widthTotal, (double)0.0F);
         return Math.sqrt(x_distance * x_distance + y_distance * y_distance + z_distance * z_distance);
      } else {
         return (double)0.0F;
      }
   }
}
