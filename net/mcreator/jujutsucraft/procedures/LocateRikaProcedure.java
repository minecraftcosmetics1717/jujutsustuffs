package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LocateRikaProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         Entity entity_rika = null;
         logic_a = false;
         if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
            entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("RIKA_UUID"));
            if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().m_128459_("friend_num") == entity_rika.getPersistentData().m_128459_("friend_num")) {
               logic_a = true;
            }
         }

         return logic_a;
      }
   }
}
