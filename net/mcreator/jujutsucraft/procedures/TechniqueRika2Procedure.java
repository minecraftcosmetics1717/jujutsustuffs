package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TechniqueRika2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         Entity entity_rika = null;
         String STR1 = "";
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double HP = (double)0.0F;
         double power = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (!(entity instanceof Player)) {
            entity.getPersistentData().m_128379_("PRESS_Z", true);
         }

         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            power = (double)Math.round(((double)20.0F - entity.getPersistentData().m_128459_("cnt1")) * (double)0.25F);
            STR1 = Component.m_237115_("jujutsu.message.long_press").getString();

            for(int index0 = 0; index0 < (int)power; ++index0) {
               STR1 = "■" + STR1 + "■";
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(STR1), true);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(""), true);
                  }
               }

               entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("RIKA_UUID"));
               if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().m_128459_("friend_num") == entity_rika.getPersistentData().m_128459_("friend_num")) {
                  entity_rika.getPersistentData().m_128347_("despawn_flag", (double)2.0F);
               }

               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(""), true);
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
