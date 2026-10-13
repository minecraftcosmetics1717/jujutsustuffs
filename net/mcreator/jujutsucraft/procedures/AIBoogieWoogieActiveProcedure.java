package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIBoogieWoogieActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double velocity = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity.m_6084_()) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (LogicStartPassiveProcedure.execute(entity)) {
                  entity.getPersistentData().m_128347_("cnt_boogie_woogie", entity.getPersistentData().m_128459_("cnt_boogie_woogie") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_boogie_woogie") > (double)10.0F) {
                     entity.getPersistentData().m_128347_("cnt_boogie_woogie", (double)0.0F);
                     SkillBoogieWoogieProcedure.execute(world, x, y, z, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_boogie_woogie", (double)0.0F);
            }
         }

      }
   }
}
