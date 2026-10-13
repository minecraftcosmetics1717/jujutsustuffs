package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class BulletNailProjectileHitsLivingEntityProcedure {
   public static void execute(Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         entity.getPersistentData().m_128347_("Nail", entity.getPersistentData().m_128459_("Nail") + (double)1.0F);
         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
