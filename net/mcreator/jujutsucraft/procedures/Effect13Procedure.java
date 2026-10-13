package net.mcreator.jujutsucraft.procedures;

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

public class Effect13Procedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         speed = (double)2.0F;
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.5F);
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)15.0F * speed), (double)1.0F, (double)3.0F, (double)1.0F, (double)0.25F * speed);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)15.0F * speed), (double)1.0F, (double)1.5F, (double)1.0F, (double)0.25F * speed);
         }

         Effect1Procedure.execute(world, entity, entityiterator);
         entity.getPersistentData().m_128347_("BlockRange", (double)5.0F);
         entity.getPersistentData().m_128347_("BlockDamage", (double)15.0F);
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, entityiterator.m_20186_() + (double)(entityiterator.m_20206_() * 0.0F), z_pos, entity);
      }
   }
}
