package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EmberInsectEntity;
import net.mcreator.jujutsucraft.entity.FoxFireEntity;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class Effect7Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double amount = (double)0.0F;
         double speed = (double)0.0F;
         speed = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         amount = 0.1 * speed;
         if (entity instanceof FoxFireEntity) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123745_, x, y, z, 20, 0.1, 0.1, 0.1, (double)0.25F * speed);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         } else {
            if (entity instanceof EmberInsectEntity) {
               amount = (double)1.0F;
               entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F);
               entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x, y, z, 25, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.25F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)((double)20.0F * amount), (double)0.5F, (double)0.5F, (double)0.5F, (double)0.25F * speed);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123755_, x, y, z, (int)((double)20.0F * amount), (double)0.5F, (double)0.5F, (double)0.5F, (double)0.25F * speed);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123756_, x, y, z, (int)((double)30.0F * amount), (double)0.5F, (double)0.5F, (double)0.5F, (double)0.25F * speed);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x, y, z, (int)((double)60.0F * amount), (double)0.5F, (double)0.5F, (double)0.5F, (double)0.25F * speed);
            }
         }

      }
   }
}
