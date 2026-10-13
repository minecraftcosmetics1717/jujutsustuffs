package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.RedEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIRedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double z_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double distance = (double)0.0F;
         double CNT6 = (double)0.0F;
         double power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         AIBlueRedProcedure.execute(world, entity);
         if (entity instanceof RedEntity) {
            RedEntity _datEntL0 = (RedEntity)entity;
            if ((Boolean)_datEntL0.m_20088_().m_135370_(RedEntity.DATA_flag_start)) {
               CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
                  BulletDomainHit2Procedure.execute(world, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.75F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.75F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
                     }
                  }

                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
               }

               for(int index0 = 0; index0 < 8; ++index0) {
                  entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power") * (double)0.25F);
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power") * (double)0.25F);
                  entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power") * (double)0.25F);
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128347_("Damage", (double)40.0F);
                  entity.getPersistentData().m_128347_("Damage", Math.max(entity.getPersistentData().m_128459_("Damage") * Math.pow(0.99, entity.getPersistentData().m_128459_("cnt_life")), (double)28.0F));
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)10.0F * CNT6);
                  entity.getPersistentData().m_128347_("knockback", (double)2.0F * CNT6);
                  entity.getPersistentData().m_128347_("effect", (double)0.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("BlockRange", (double)6.0F * CNT6);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)10.0F * CNT6);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128379_("noEffect", true);
               }

               entity.getPersistentData().m_128379_("noEffect", false);
               entity.getPersistentData().m_128347_("BlockRange", (double)12.0F);
               entity.getPersistentData().m_128347_("BlockDamage", 0.33);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
                  entity.getPersistentData().m_128347_("BlockRange", (double)24.0F * CNT6);
                  entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               range = ReturnEntitySizeProcedure.execute(entity);
               ParticleGeneratorProcedure.execute(world, range * 0.1, (double)40.0F * range, (double)30.0F, (double)8.0F, entity.m_20185_(), entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"), "minecraft:cloud");
               if (entity.getPersistentData().m_128459_("cnt1") < (double)6.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123747_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)30.0F * CNT6), (double)4.0F, (double)4.0F, (double)4.0F, (double)1.0F);
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)40.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)16.0F * CNT6);
                  entity.getPersistentData().m_128347_("knockback", (double)4.0F * CNT6);
                  entity.getPersistentData().m_128347_("effect", (double)0.0F);
                  entity.getPersistentData().m_128347_("y_knockback", 0.65);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() - (double)1.5F, entity.m_20189_(), entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)8.0F * CNT6 && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
