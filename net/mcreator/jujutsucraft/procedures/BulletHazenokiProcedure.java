package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BulletEyeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletHazenokiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double power = (double)0.0F;
         double repeat_num = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double old_skill = (double)0.0F;
         double old_cooldown = (double)0.0F;
         double damage = (double)0.0F;
         double num = (double)0.0F;
         BulletDomainHitProcedure.execute(world, entity, immediatesourceentity);
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == (double)1.0F) {
            immediatesourceentity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)(immediatesourceentity instanceof BulletEyeEntity ? 5 : 0));
            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediatesourceentity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().m_128347_("old_x", x - immediatesourceentity.m_20184_().m_7096_());
            immediatesourceentity.getPersistentData().m_128347_("old_y", y - immediatesourceentity.m_20184_().m_7098_());
            immediatesourceentity.getPersistentData().m_128347_("old_z", z - immediatesourceentity.m_20184_().m_7094_());
            immediatesourceentity.getPersistentData().m_128347_("speed", Math.sqrt(immediatesourceentity.m_20184_().m_7096_() * immediatesourceentity.m_20184_().m_7096_() + immediatesourceentity.m_20184_().m_7098_() * immediatesourceentity.m_20184_().m_7098_() + immediatesourceentity.m_20184_().m_7094_() * immediatesourceentity.m_20184_().m_7094_()));
            immediatesourceentity.getPersistentData().m_128347_("Damage", (double)15.0F * ((double)1.0F + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1));
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > (double)20.0F) {
            BulletHazenokiHitProcedure.execute(world, x, y, z, entity, immediatesourceentity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}
