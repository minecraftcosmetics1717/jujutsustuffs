package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIHouseProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double rad = (double)0.0F;
         double pitch = (double)0.0F;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double width = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double height = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         height = (double)entity.m_20206_();
         width = (double)entity.m_20205_();
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         x_power = entity.m_20184_().m_7096_();
         y_power = entity.m_20184_().m_7098_();
         z_power = entity.m_20184_().m_7094_();
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (dis > (double)0.25F) {
            entity.getPersistentData().m_128347_("cnt4", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt5", dis);
            if (dis != (double)0.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)24.0F * CNT6 * Math.min(dis, (double)2.0F));
               entity.getPersistentData().m_128347_("Range", (double)(4.0F + 1.0F * entity.m_20205_()));
               entity.getPersistentData().m_128347_("knockback", (double)0.25F * Math.min(dis, (double)2.0F));
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

               for(int index0 = 0; index0 < (int)(dis + (double)1.0F); ++index0) {
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
                  if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                     for(int index1 = 0; index1 < 6; ++index1) {
                        entity.getPersistentData().m_128347_("BlockDamage", (double)100.0F);
                        entity.getPersistentData().m_128347_("BlockRange", (double)4.0F + (double)0.5F * (double)entity.m_20205_());
                        entity.getPersistentData().m_128379_("noParticle", true);
                        entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos + x_power, y_pos + y_power, z_pos + z_power, entity);
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                           break;
                        }
                     }

                     if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                        break;
                     }
                  }
               }

               if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                  dis = (double)0.0F;
                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }
               }
            }
         }

         if (dis < (double)0.25F && (entity.getPersistentData().m_128459_("cnt4") > (double)0.0F || entity.getPersistentData().m_128459_("cnt5") > (double)0.0F)) {
            entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
            if (entity.getPersistentData().m_128459_("cnt4") <= Math.max(range * (double)4.0F, (double)1.0F)) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * (double)2.0F), 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * (double)2.0F), 0.5F, false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("BlockRange", (double)4.0F + (double)0.75F * (double)entity.m_20205_());
                  entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt4") % (double)5.0F == (double)1.0F) {
                  entity.getPersistentData().m_128347_("Damage", (double)30.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)4.0F + (double)1.25F * (double)entity.m_20205_());
                  entity.getPersistentData().m_128347_("knockback", (double)2.5F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("Range", (double)4.0F + (double)1.25F * (double)entity.m_20205_());
                  entity.getPersistentData().m_128347_("knockback", (double)1.25F);
                  KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt4") < Math.max(range * (double)6.0F, (double)1.0F)) {
               ParticleGeneratorCircleProcedure.execute(world, (double)4.0F * range, (double)90.0F, (double)0.0F * range, (double)4.0F * range, (double)2.0F, x_pos, x_pos, entity.m_20186_(), entity.m_20186_() + range * (double)1.0F * Math.random(), (double)0.0F, z_pos, z_pos, "jujutsucraft:particle_big_smoke");
            }
         }

         if ((entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F || !entity.m_6084_()) && (entity.getPersistentData().m_128459_("cnt4") > range * (double)6.0F + (double)20.0F || !entity.m_6084_())) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_big_smoke ~ ~ ~ " + range * (double)2.0F + " " + range * (double)2.0F + " " + range * (double)2.0F + " 2 " + Math.round((double)25.0F * range) + " force");
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
