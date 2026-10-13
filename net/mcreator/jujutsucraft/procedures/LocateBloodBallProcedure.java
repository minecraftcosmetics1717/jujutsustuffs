package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BloodBallEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LocateBloodBallProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         boolean pitch = false;
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double HP = (double)0.0F;
         logic_a = false;
         if (entity.getPersistentData().m_128459_("NameRanged") != (double)0.0F) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)25.0F), (e) -> true)) {
               if (entity != entityiterator && entityiterator instanceof BloodBallEntity && entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged")) {
                  logic_a = true;
                  break;
               }
            }
         }

         return logic_a;
      }
   }
}
