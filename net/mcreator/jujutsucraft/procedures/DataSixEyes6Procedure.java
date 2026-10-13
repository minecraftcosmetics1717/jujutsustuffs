package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class DataSixEyes6Procedure {
   public static String execute(Entity entity) {
      return entity == null ? "" : entity.getPersistentData().m_128461_("DataSixEyes6");
   }
}
