package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class FloatInWaterProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.getPersistentData().m_128459_("skill") != (double)705.0F;
      }
   }
}
