package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.Vec3;

public class DetectEnemyProjectileProcedure {
   public static boolean execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double dx = (double)0.0F;
         double dy = (double)0.0F;
         double dz = (double)0.0F;
         double move_x = (double)0.0F;
         double move_y = (double)0.0F;
         double move_z = (double)0.0F;
         if (!(entityiterator instanceof Projectile)) {
            return false;
         } else {
            Entity var10000;
            if (entityiterator instanceof TraceableEntity) {
               TraceableEntity _traceableEntity = (TraceableEntity)entityiterator;
               var10000 = _traceableEntity.m_19749_();
            } else {
               var10000 = null;
            }

            if (var10000 == entity) {
               return false;
            } else {
               Vec3 vel = entityiterator.m_20184_();
               dx = entity.m_20185_() - entityiterator.m_20185_();
               dy = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
               dz = entity.m_20189_() - entityiterator.m_20189_();
               if (dx * vel.f_82479_ + dy * vel.f_82480_ + dz * vel.f_82481_ <= (double)0.0F) {
                  return false;
               } else {
                  move_x = entityiterator.m_20184_().m_7096_();
                  move_y = entityiterator.m_20184_().m_7098_();
                  move_z = entityiterator.m_20184_().m_7094_();
                  return !(move_x * move_x + move_y * move_y + move_z * move_z < 0.02);
               }
            }
         }
      } else {
         return false;
      }
   }
}
