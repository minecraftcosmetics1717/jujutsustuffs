package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class GetPowerForwardProcedure {
   public static void execute(double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = (double)0.0F;
         entity.getPersistentData().m_128347_("x_power", x - entity.m_20185_());
         entity.getPersistentData().m_128347_("y_power", y - (entity.m_20186_() + (double)entity.m_20206_() * 0.9));
         entity.getPersistentData().m_128347_("z_power", z - entity.m_20189_());
         dis = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
         if (dis != (double)0.0F) {
            entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") / dis * (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") / dis * (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") / dis * (double)3.0F);
         } else {
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
         }

         if (entity.getPersistentData().m_128471_("free")) {
            entity.getPersistentData().m_128379_("free", false);
         } else {
            GetPowerFixProcedure.execute(entity);
         }

      }
   }
}
