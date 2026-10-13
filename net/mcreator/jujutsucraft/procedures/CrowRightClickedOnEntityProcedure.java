package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CrowRightClickedOnEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)11.0F || ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)11.0F) {
            if (sourceentity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               sourceentity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            entity.getPersistentData().m_128347_("friend_num", sourceentity.getPersistentData().m_128459_("friend_num"));
            if (entity instanceof TamableAnimal) {
               TamableAnimal _toTame = (TamableAnimal)entity;
               if (sourceentity instanceof Player) {
                  Player _owner = (Player)sourceentity;
                  _toTame.m_21828_(_owner);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123750_, x, y, z, 1, (double)0.0F, (double)0.0F, (double)0.0F, 0.1);
            }
         }

      }
   }
}
