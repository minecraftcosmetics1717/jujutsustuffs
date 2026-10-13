package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.LiquidMetalEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TechniqueLiquidArrowProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean strong = false;
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double CNT6 = (double)0.0F;
         double strength = (double)0.0F;
         double x_target = (double)0.0F;
         double degree = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double dis = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double height = (double)0.0F;
         if (LocateLiquidMetalProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("LIQUID_METAL_UUID"));
            if (entity_a instanceof LiquidMetalEntity && entity.getPersistentData().m_128459_("NameRanged") == entity_a.getPersistentData().m_128459_("NameRanged_ranged")) {
               entity_a.getPersistentData().m_128347_("move", (double)1.0F);
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               dis = (double)5.0F;
               height = (double)1.0F;
               x_target = entity.m_20185_() + Math.cos(Math.toRadians(yaw + (double)90.0F + degree)) * dis;
               y_target = entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F + height;
               z_target = entity.m_20189_() + Math.sin(Math.toRadians(yaw + (double)90.0F + degree)) * dis;
               entity_a.m_6021_(x_target, y_target, z_target);
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.f_8906_.m_9774_(x_target, y_target, z_target, entity_a.m_146908_(), entity_a.m_146909_());
               }
            }
         }

         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
