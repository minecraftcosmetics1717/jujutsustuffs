package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class SkillConsecutiveEffectsProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean SUCCESS = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double rnd = (double)0.0F;
         double dis = (double)0.0F;
         double old_rnd = (double)0.0F;
         double NUM1 = (double)0.0F;
         entity.getPersistentData().m_128347_("Reserve", (double)13.0F);
         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
