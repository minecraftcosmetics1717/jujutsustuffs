package net.mcreator.jujutsucraft.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class LogicAttackTargetProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean target_reset = false;
         Entity target = null;
         double friend_num = (double)0.0F;
         if (!entity.m_6084_()) {
            return false;
         } else {
            if (entity instanceof Mob) {
               Mob mob = (Mob)entity;
               Entity var7 = mob.m_5448_();
               CompoundTag data = mob.getPersistentData();
               if (data.m_128459_("skill") <= (double)-999.0F) {
                  return false;
               }

               if (data.m_128459_("cnt_target") <= (double)6.0F) {
                  return false;
               }

               if (var7 instanceof LivingEntity) {
                  friend_num = data.m_128459_("friend_num");
                  if (friend_num != (double)0.0F && friend_num == ((Entity)var7).getPersistentData().m_128459_("friend_num")) {
                     target_reset = true;
                  }

                  if (mob.m_7307_(var7)) {
                     target_reset = true;
                  }

                  if (target_reset) {
                     data.m_128359_("TARGET_UUID", "");
                     data.m_128347_("cnt_target", (double)0.0F);
                     mob.m_6710_((LivingEntity)null);
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }
}
