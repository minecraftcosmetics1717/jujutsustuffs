package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBlackFlashProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rad = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double soundPitch = (double)0.0F;
         double rad_now = (double)0.0F;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         double num3 = (double)0.0F;
         double pitch = (double)0.0F;
         double loop_num = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               soundPitch = (double)0.75F;

               for(int index0 = 0; index0 < 3; ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                     }
                  }

                  soundPitch += (double)0.25F;
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123747_, x, y + (double)1.0F, z, 10, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.0F);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x, y + (double)1.0F, z, 3, (double)0.5F, (double)1.0F, (double)0.5F, (double)0.0F);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)17.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
               soundPitch = (double)0.75F;

               for(int index1 = 0; index1 < 3; ++index1) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                     }
                  }

                  soundPitch += (double)0.25F;
               }

               entity.getPersistentData().m_128347_("BlockRange", (double)8.0F);
               entity.getPersistentData().m_128347_("BlockDamage", (double)0.25F);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            }

            loop_num = (double)5.0F + entity.getPersistentData().m_128459_("cnt1") * (double)2.0F;

            for(int index2 = 0; index2 < 2; ++index2) {
               rad_now = Math.toRadians(Math.random() * (double)360.0F);
               pitch = Math.toRadians((double)0.0F);
               num1 = (Math.random() - (double)0.5F) * 1.6;
               num2 = (Math.random() - (double)0.5F) * 1.6;
               num3 = (Math.random() - (double)0.5F) * 1.6;
               entity.getPersistentData().m_128347_("x_pos", x);
               entity.getPersistentData().m_128347_("y_pos", y + (double)1.0F);
               entity.getPersistentData().m_128347_("z_pos", z);
               entity.getPersistentData().m_128347_("cnt2", (double)0.0F);

               for(int index3 = 0; index3 < (int)loop_num; ++index3) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad_now) * (Math.cos(pitch) + Math.abs(Math.sin(rad_now) * Math.sin(pitch))) * (entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  y_pos = entity.getPersistentData().m_128459_("y_pos") + Math.sin(pitch) * (entity.getPersistentData().m_128459_("cnt2") + (double)1.0F) * (double)-1.0F;
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad_now) * (Math.cos(pitch) + Math.abs(Math.cos(rad_now) * Math.sin(pitch))) * (entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                  }

                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     if (!world.m_8055_(BlockPos.m_274561_(x_pos + (double)1.0F, y_pos + (double)0.0F, z_pos + (double)0.0F)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + (double)-1.0F, y_pos + (double)0.0F, z_pos + (double)0.0F)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + (double)0.0F, y_pos + (double)1.0F, z_pos + (double)0.0F)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + (double)0.0F, y_pos + (double)-1.0F, z_pos + (double)0.0F)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + (double)0.0F, y_pos + (double)0.0F, z_pos + (double)1.0F)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + (double)0.0F, y_pos + (double)0.0F, z_pos + (double)-1.0F)).m_60815_()) {
                        world.m_46796_(2001, BlockPos.m_274561_(x_pos, y_pos, z_pos), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 5, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.0F);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)0.25F);
                  if (entity.getPersistentData().m_128459_("cnt2") % (double)4.0F < (double)2.0F) {
                     entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + num1);
                     entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + num2);
                     entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + num3);
                  } else {
                     entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") - num1);
                     entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - num2);
                     entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") - num3);
                  }
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
            x_pos = x + Math.random() * (double)16.0F - (double)8.0F;
            z_pos = z + Math.random() * (double)16.0F - (double)8.0F;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y, z_pos, 40, 0.1, (double)2.0F, 0.1, 0.1);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.25F, 1.25F);
               } else {
                  _level.m_7785_(x_pos, y, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
