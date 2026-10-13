package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class MeteorDisplayConditionProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.getPersistentData().m_128459_("cnt5") > (double)600.0F;
      }
   }
}
