package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SummonCrowProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double loop_num = (double)0.0F;
         double HP = (double)0.0F;
         if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         loop_num = (double)(3L + Math.round(Math.random() * (double)3.0F));

         for(int index0 = 0; index0 < (int)loop_num; ++index0) {
            for(int index1 = 0; index1 < 64; ++index1) {
               x_pos = x + (Math.random() - (double)0.5F) * (double)20.0F;
               y_pos = y + (double)8.0F + Math.random() * (double)12.0F;
               z_pos = z + (Math.random() - (double)0.5F) * (double)20.0F;
               if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.CROW.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        if (entityinstance instanceof TamableAnimal) {
                           TamableAnimal _toTame = (TamableAnimal)entityinstance;
                           if (entity instanceof Player) {
                              Player _owner = (Player)entity;
                              _toTame.m_21828_(_owner);
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
                  break;
               }
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.crow1").getString()), false);
            }
         }

         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound ui.button.click master @s");
         }

      }
   }
}
