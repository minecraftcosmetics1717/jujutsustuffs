package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class AIWoodenBallProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_target = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw_cal = (double)0.0F;
         double pitch_cal = (double)0.0F;
         double move_power = (double)0.0F;
         double tick = (double)0.0F;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("move") == (double)0.0F) {
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     if (entity.getPersistentData().m_128459_("position_pitch") == (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), (double)2.0F));
                     }

                     if (entity.getPersistentData().m_128459_("cnt_x") == (double)0.0F) {
                        if (entity_a.getPersistentData().m_128459_("skill") != (double)0.0F && entity_a.getPersistentData().m_128471_("attack")) {
                           entity.getPersistentData().m_128347_("cnt_x", (double)1.0F);
                        }
                     } else if (entity.getPersistentData().m_128459_("cnt_x") == (double)1.0F) {
                        if (entity_a.getPersistentData().m_128459_("skill") == (double)0.0F) {
                           entity.getPersistentData().m_128347_("cnt_x", (double)2.0F);
                        }
                     } else {
                        entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                        if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F) {
                           ResetCounterProcedure.execute(entity);
                           entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                           entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
                           entity.getPersistentData().m_128347_("move", entity.getPersistentData().m_128459_("cnt_x2"));
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:1b}");
                           }
                        }
                     }

                     logic_a = true;
                     yaw = (double)entity_a.m_146908_();
                     pitch = (double)entity_a.m_146909_();
                     x_power = entity.m_20185_();
                     y_power = entity.m_20186_();
                     z_power = entity.m_20189_();
                     x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + (double)90.0F + entity.getPersistentData().m_128459_("position_yaw"))) * (double)5.0F;
                     y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F + entity.getPersistentData().m_128459_("position_pitch");
                     z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + (double)90.0F + entity.getPersistentData().m_128459_("position_yaw"))) * (double)5.0F;
                     if (Math.abs(x_target - x_power) > (double)0.5F) {
                        x_target = x_power + (x_power > x_target ? (double)-0.5F : (double)0.5F);
                     }

                     if (Math.abs(y_target - y_power) > (double)0.5F) {
                        y_target = y_power + (y_power > y_target ? (double)-0.5F : (double)0.5F);
                     }

                     if (Math.abs(z_target - z_power) > (double)0.5F) {
                        z_target = z_power + (z_power > z_target ? (double)-0.5F : (double)0.5F);
                     }

                     entity.m_6021_(x_target, y_target, z_target);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(x_target, y_target, z_target, entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? (double)0.0F : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                     entity.m_146922_(entity_a.m_146908_());
                     entity.m_146926_(entity_a.m_146909_());
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  }
               }

               if (!logic_a && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (entity.getPersistentData().m_128459_("move") < (double)5.0F) {
               AIWoodenBall1Procedure.execute(world, entity);
            } else {
               AIWoodenBall1Procedure.execute(world, entity);
               if (entity.getPersistentData().m_128459_("move") == (double)0.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }
         } else {
            world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * (double)0.5F, z), Block.m_49956_(Blocks.f_49999_.m_49966_()));
            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
