package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.minecraft.world.entity.Entity;

public class LogicAIProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         if (entity instanceof CrowEntity) {
            logic_a = entity.getPersistentData().m_128459_("NameRanged_ranged") == (double)0.0F;
         } else {
            logic_a = entity.getPersistentData().m_128459_("friend_num") == (double)0.0F;
         }

         return logic_a;
      }
   }
}
