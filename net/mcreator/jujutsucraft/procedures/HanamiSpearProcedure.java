package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class HanamiSpearProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double num1 = (double)0.0F;
         double range = (double)0.0F;
         double num2 = (double)0.0F;
         double mode = (double)0.0F;
         if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               mode = Math.random() < (double)0.5F ? (double)2.0F : (double)1.0F;
            } else {
               mode = entity.m_6144_() ? (double)2.0F : (double)1.0F;
            }

            entity.getPersistentData().m_128347_("cnt7", (double)Math.round(mode));
         }

         if (entity.getPersistentData().m_128459_("cnt7") == (double)1.0F) {
            HanamiSpear1Procedure.execute(world, entity);
         } else {
            HanamiSpear2Procedure.execute(world, entity);
         }

      }
   }
}
