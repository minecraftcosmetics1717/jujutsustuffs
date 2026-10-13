package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AIMahoragaDogFrogProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:0b}");
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
            entity.m_6021_(x, y - (double)0.5F, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(x, y - (double)0.5F, z, entity.m_146908_(), entity.m_146909_());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 10, (double)0.25F, (double)0.5F, (double)0.25F, (double)0.0F);
            }

            if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y + (double)1.0F, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y + (double)2.0F, z)).m_60815_()) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 20, (double)0.25F, (double)0.5F, (double)0.25F, (double)0.0F);
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)110.0F && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
