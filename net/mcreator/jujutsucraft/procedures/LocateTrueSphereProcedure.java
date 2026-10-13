package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.TrueSphereEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LocateTrueSphereProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
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
         Entity entity_rika = null;
         logic_a = false;
         if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
            entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("TRUE_SPHERE_UUID"));
            if (entity_rika instanceof TrueSphereEntity && entity.getPersistentData().m_128459_("friend_num") == entity_rika.getPersistentData().m_128459_("friend_num")) {
               logic_a = true;
            }
         }

         return logic_a;
      }
   }
}
