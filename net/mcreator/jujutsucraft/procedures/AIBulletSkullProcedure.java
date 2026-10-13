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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBulletSkullProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_b = false;
         Entity entity_a = null;
         double d = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double range_fix = (double)0.0F;
         double speed = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double speed2 = (double)0.0F;
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * (double)1.0F);
         entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range_fix = (double)1.0F;
         RotateEntityProcedure.execute(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * (double)50.0F, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.getPersistentData().m_128459_("y_power") * (double)50.0F, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * (double)50.0F, entity);
         if (entity.getPersistentData().m_128471_("Stop")) {
            entity.getPersistentData().m_128379_("Stop", false);
            speed = (double)0.0F;
            speed2 = (double)0.0F;
         } else {
            speed = (double)1.25F;
            speed2 = (double)0.25F;
            BulletDomainHit2Procedure.execute(world, entity);
         }

         x_power = entity.getPersistentData().m_128459_("x_power") * speed;
         y_power = entity.getPersistentData().m_128459_("y_power") * speed;
         z_power = entity.getPersistentData().m_128459_("z_power") * speed;
         entity.m_20256_(new Vec3(x_power, y_power, z_power));
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > (double)1.0F) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         } else {
            dis = (double)1.0F;
         }

         for(int index0 = 0; index0 < (int)dis; ++index0) {
            range = ReturnEntitySizeProcedure.execute(entity);
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            entity.getPersistentData().m_128347_("Damage", (double)15.0F);
            if (entity.getPersistentData().m_128459_("cnt_life") > (double)0.0F) {
               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.pow(0.99, Math.min(entity.getPersistentData().m_128459_("cnt_life"), (double)25.0F)));
            }

            entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)3.0F * range_fix);
            entity.getPersistentData().m_128347_("knockback", (double)0.5F);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  logic_b = true;
                  break;
               }
            }

            d = Math.sqrt((double)1.0F + entity.getPersistentData().m_128459_("Damage"));
            if (logic_b || entity.m_5830_() || !entity.m_6084_()) {
               entity.getPersistentData().m_128379_("Stop", true);
               range = d * (double)0.25F + (double)3.0F * range_fix;
               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               entity.getPersistentData().m_128347_("Range", range * (double)2.0F);
               entity.getPersistentData().m_128347_("knockback", (double)1.0F);
               entity.getPersistentData().m_128347_("effect", (double)0.0F);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("BlockDamage", d * (double)1.0F);
               entity.getPersistentData().m_128347_("BlockRange", range);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * (double)0.5F), 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * (double)0.5F), 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle soul ~ ~ ~ " + range * (double)0.25F + " " + range * (double)0.25F + " " + range * (double)0.25F + " 1 " + Math.round((double)5.0F * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle squid_ink ~ ~ ~ " + range * (double)0.25F + " " + range * (double)0.25F + " " + range * (double)0.25F + " 1 " + Math.round((double)5.0F * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle explosion ~ ~ ~ " + range * (double)0.75F + " " + range * (double)0.75F + " " + range * (double)0.75F + " 1 " + Math.round((double)10.0F * range) + " force");
               }

               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") - (double)1.0F);
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               break;
            }

            entity.m_6021_(entity.m_20185_() + x_power * (double)1.0F, entity.m_20186_() + y_power * (double)1.0F, entity.m_20189_() + z_power * (double)1.0F);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power * (double)1.0F, entity.m_20186_() + y_power * (double)1.0F, entity.m_20189_() + z_power * (double)1.0F, entity.m_146908_(), entity.m_146909_());
            }
         }

         if ((entity.getPersistentData().m_128459_("cnt1") > (double)15.0F || entity.getPersistentData().m_128459_("cnt2") > (double)10.0F * CNT6) && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt_life") > (double)1.0F) {
            x_pos = entity.getPersistentData().m_128459_("old_x");
            y_pos = entity.getPersistentData().m_128459_("old_y");
            z_pos = entity.getPersistentData().m_128459_("old_z");
            x_power = entity.m_20185_() - x_pos;
            y_power = entity.m_20186_() - y_pos;
            z_power = entity.m_20189_() - z_pos;
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis > (double)1.0F) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            }

            range = ReturnEntitySizeProcedure.execute(entity);

            for(int index1 = 0; index1 < (int)Math.max(dis * (double)4.0F, (double)1.0F); ++index1) {
               ParticleGeneratorProcedure.execute(world, range * (double)1.0F, (double)2.0F * range, (double)22.5F, (double)4.0F, x_pos, x_pos - x_power, y_pos, y_pos - y_power, z_pos, z_pos - z_power, "minecraft:squid_ink");
               x_pos += x_power * (double)0.25F;
               y_pos += y_power * (double)0.25F;
               z_pos += z_power * (double)0.25F;
            }
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_());
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_());
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_());
      }
   }
}
