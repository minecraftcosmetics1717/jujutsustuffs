package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade05Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade12Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BuildGraveyard2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
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
      boolean boss_flag = false;
      boolean SUCCESS = false;
      boolean superBoss = false;
      if (world.m_6443_(CursedSpiritGrade12Entity.class, AABB.m_165882_(new Vec3(x, y, z), (double)64.0F, (double)64.0F, (double)64.0F), (e) -> true).isEmpty() && world.m_6443_(CursedSpiritGrade05Entity.class, AABB.m_165882_(new Vec3(x, y, z), (double)64.0F, (double)64.0F, (double)64.0F), (e) -> true).isEmpty()) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123746_, x, y, z, 25, (double)0.25F, (double)0.25F, (double)0.25F, 0.1);
         }

         boss_flag = false;

         for(int index0 = 0; index0 < 4; ++index0) {
            SUCCESS = false;

            for(int index1 = 0; index1 < 256; ++index1) {
               if (!boss_flag) {
                  entity_height = (double)6.0F;
                  entity_width = (double)6.0F;
                  x_pos = x;
                  y_pos = y + (double)16.0F;
                  z_pos = z;
                  break;
               }

               entity_height = (double)2.0F;
               entity_width = (double)2.0F;
               x_pos = x + (Math.random() - (double)0.5F) * (double)34.0F * 0.8;
               y_pos = y - (double)8.0F;
               z_pos = z + (Math.random() - (double)0.5F) * (double)34.0F * 0.8;

               for(int index2 = 0; index2 < 25; ++index2) {
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

            if (boss_flag) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_25.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  }
               }
            } else {
               boss_flag = true;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_12.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  }
               }

               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
                  if (entityiterator instanceof CursedSpiritGrade12Entity && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "data merge entity @s {PersistenceRequired:1b}");
                  }
               }

               y_pos = y + (double)2.0F;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_05.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  }
               }

               _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
                  if (entityiterator instanceof CursedSpiritGrade05Entity && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "data merge entity @s {PersistenceRequired:1b}");
                  }
               }
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air");
         }
      }

   }
}
