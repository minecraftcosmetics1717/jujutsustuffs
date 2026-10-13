package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletKitchenKnifeWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double repeat_num = (double)0.0F;
         double damage = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double old_skill = (double)0.0F;
         double x_power = (double)0.0F;
         double old_cooldown = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == (double)1.0F) {
            immediatesourceentity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediatesourceentity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().m_128347_("old_x", x - immediatesourceentity.m_20184_().m_7096_());
            immediatesourceentity.getPersistentData().m_128347_("old_y", y - immediatesourceentity.m_20184_().m_7098_());
            immediatesourceentity.getPersistentData().m_128347_("old_z", z - immediatesourceentity.m_20184_().m_7094_());
            immediatesourceentity.getPersistentData().m_128347_("speed", Math.sqrt(immediatesourceentity.m_20184_().m_7096_() * immediatesourceentity.m_20184_().m_7096_() + immediatesourceentity.m_20184_().m_7098_() * immediatesourceentity.m_20184_().m_7098_() + immediatesourceentity.m_20184_().m_7094_() * immediatesourceentity.m_20184_().m_7094_()));
            immediatesourceentity.getPersistentData().m_128347_("Damage", (double)13.0F * ((double)1.0F + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1));
         }

         x_pos = immediatesourceentity.getPersistentData().m_128459_("old_x");
         y_pos = immediatesourceentity.getPersistentData().m_128459_("old_y");
         z_pos = immediatesourceentity.getPersistentData().m_128459_("old_z");
         x_power = x - x_pos;
         y_power = y - y_pos;
         z_power = z - z_pos;
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > 0.1) {
            old_skill = entity.getPersistentData().m_128459_("skill");
            old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            entity.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
            repeat_num = (double)Math.round(Math.max(dis * (double)5.0F, (double)1.0F));
            damage = immediatesourceentity.getPersistentData().m_128459_("Damage");

            for(int index0 = 0; index0 < (int)repeat_num; ++index0) {
               ++dis;
               if (dis > (double)0.0F) {
                  dis = (double)-5.0F;
                  entity.getPersistentData().m_128347_("Damage", damage);
                  entity.getPersistentData().m_128347_("Range", (double)2.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)0.25F);
                  entity.getPersistentData().m_128347_("effect", (double)1.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               x_pos += x_power * 0.2;
               y_pos += y_power * 0.2;
               z_pos += z_power * 0.2;
            }

            entity.getPersistentData().m_128347_("skill", old_skill);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
         }

         immediatesourceentity.getPersistentData().m_128347_("old_x", x);
         immediatesourceentity.getPersistentData().m_128347_("old_y", y);
         immediatesourceentity.getPersistentData().m_128347_("old_z", z);
         immediatesourceentity.getPersistentData().m_128347_("Damage", Math.max(immediatesourceentity.getPersistentData().m_128459_("Damage") * 0.99, (double)10.0F));
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > (double)(immediatesourceentity.getPersistentData().m_128459_("skill") == (double)4405.0F ? 30 : 200) && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
