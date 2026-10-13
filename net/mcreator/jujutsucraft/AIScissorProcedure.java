package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIScissorProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") < (double)40.0F) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("TARGET"));
               if (entity_a instanceof LivingEntity) {
                  entity.m_6021_(entity_a.m_20185_() + entity.getPersistentData().m_128459_("x_pos"), entity_a.m_20186_() + entity.getPersistentData().m_128459_("y_pos"), entity_a.m_20189_() + entity.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + entity.getPersistentData().m_128459_("x_pos"), entity_a.m_20186_() + entity.getPersistentData().m_128459_("y_pos"), entity_a.m_20189_() + entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)40.0F) {
               entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)10.0F);
               BulletDomainHit2Procedure.execute(world, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               x_power = entity.m_20154_().f_82479_;
               y_power = entity.m_20154_().f_82480_;
               z_power = entity.m_20154_().f_82481_;

               for(int index0 = 0; index0 < (int)(1.0F + entity.m_20205_()); ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.25F, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.25F, 1.5F, false);
                     }
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)18.0F);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F);
                  entity.getPersistentData().m_128347_("effect", (double)1.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F);
                  entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
