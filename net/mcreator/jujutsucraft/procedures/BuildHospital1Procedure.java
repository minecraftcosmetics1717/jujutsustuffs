package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BuildHospital1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean boss_flag = false;
      boolean SUCCESS = false;
      double x_pos = (double)0.0F;
      double y_pos = (double)0.0F;
      double z_pos = (double)0.0F;
      double grade = (double)0.0F;
      double kind = (double)0.0F;
      double entity_height = (double)0.0F;
      double entity_width = (double)0.0F;
      double sx = (double)0.0F;
      double sy = (double)0.0F;
      double sz = (double)0.0F;
      if (world instanceof Level _level) {
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F);
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.m_8767_(ParticleTypes.f_123746_, x, y, z, 25, (double)0.25F, (double)0.25F, (double)0.25F, 0.1);
      }

      boss_flag = false;

      for(int index0 = 0; index0 < 20; ++index0) {
         SUCCESS = false;

         for(int index1 = 0; index1 < 256; ++index1) {
            entity_height = (double)2.0F;
            entity_width = (double)2.0F;
            x_pos = x + (Math.random() - (double)0.5F) * (double)48.0F * 0.8;
            y_pos = y - (double)20.0F;
            z_pos = z + (Math.random() - (double)0.5F) * (double)48.0F * 0.8;

            for(int index2 = 0; index2 < 24; ++index2) {
               if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos)) && !world.m_46859_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos)) && Math.random() < (double)0.5F) {
                  SUCCESS = true;
                  sx = x_pos - entity_width * (double)0.5F;

                  for(int index3 = 0; index3 < (int)Math.round(entity_width); ++index3) {
                     sz = z_pos - entity_width * (double)0.5F;

                     for(int index4 = 0; index4 < (int)Math.round(entity_width); ++index4) {
                        sy = y_pos;

                        for(int index5 = 0; index5 < (int)Math.round(entity_height); ++index5) {
                           if (world.m_8055_(BlockPos.m_274561_(sx, sy, sz)).m_60815_()) {
                              SUCCESS = false;
                              break;
                           }

                           ++sy;
                        }

                        if (!SUCCESS) {
                           break;
                        }

                        ++sz;
                     }

                     if (!SUCCESS) {
                        break;
                     }

                     ++sx;
                  }

                  if (SUCCESS) {
                     break;
                  }
               }

               ++y_pos;
            }

            if (SUCCESS) {
               break;
            }
         }

         grade = (double)3.0F;

         for(int index6 = 0; index6 < 256; ++index6) {
            kind = (double)Math.round(Math.random() * (double)19.0F);
            if (kind != (double)7.0F) {
               break;
            }
         }

         if (world instanceof ServerLevel _level) {
            Commands var10000 = _level.m_7654_().m_129892_();
            CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
            long var10002 = Math.round(grade);
            var10000.m_230957_(var10001, "summon jujutsucraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air");
      }

   }
}
