package net.mcreator.jujutsucraft.procedures;

import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetEntityFromUUIDProcedure {
   public static Entity execute(LevelAccessor world, String uuid) {
      if (uuid != null && !uuid.isBlank()) {
         if (world instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)world;

            try {
               return serverLevel.m_8791_(UUID.fromString(uuid));
            } catch (IllegalArgumentException var4) {
               return null;
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }
}
