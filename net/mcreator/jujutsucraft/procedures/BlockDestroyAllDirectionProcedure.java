package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BlackHoleEntity;
import net.mcreator.jujutsucraft.entity.FlameArrowEntity;
import net.mcreator.jujutsucraft.entity.Gravestone1Entity;
import net.mcreator.jujutsucraft.entity.Gravestone2Entity;
import net.mcreator.jujutsucraft.entity.Gravestone3Entity;
import net.mcreator.jujutsucraft.entity.Gravestone4Entity;
import net.mcreator.jujutsucraft.entity.MeteorEntity;
import net.mcreator.jujutsucraft.entity.ProjectileSlashEntity;
import net.mcreator.jujutsucraft.entity.PureLoveCannonEntity;
import net.mcreator.jujutsucraft.entity.PurpleEntity;
import net.mcreator.jujutsucraft.entity.RockFragmentEntity;
import net.mcreator.jujutsucraft.entity.UzumakiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockDestroyAllDirectionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState block_a = Blocks.f_50016_.m_49966_();
         boolean insideBarrier = false;
         boolean type_flame = false;
         boolean logic_success = false;
         boolean rock = false;
         boolean wood = false;
         boolean logic_water = false;
         boolean glass = false;
         boolean logic_a = false;
         boolean water = false;
         Entity entity_a = null;
         double x_dis = (double)0.0F;
         double damage = (double)0.0F;
         double distance = (double)0.0F;
         double cnt_x = (double)0.0F;
         double x_pos = (double)0.0F;
         double knockback = (double)0.0F;
         double speed = (double)0.0F;
         double num1 = (double)0.0F;
         double y_pos = (double)0.0F;
         double y_dis = (double)0.0F;
         double z_dis = (double)0.0F;
         double z_pos = (double)0.0F;
         double hardness = (double)0.0F;
         double RANGE = (double)0.0F;
         String destroy_type = "";
         String old_block = "";
         if (!world.m_5776_()) {
            if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_)) {
               if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46136_)) {
                  logic_a = true;
                  ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(false, world.m_7654_());
               }

               logic_water = true;
               if (entity instanceof Gravestone1Entity || entity instanceof Gravestone2Entity || entity instanceof Gravestone3Entity || entity instanceof Gravestone4Entity) {
                  logic_water = false;
               }

               if (entity instanceof RockFragmentEntity) {
                  logic_water = false;
               }

               if (entity.getPersistentData().m_128459_("effect") == (double)3.0F) {
                  type_flame = true;
               }

               label421: {
                  label441: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt10 = (LivingEntity)entity;
                        if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break label441;
                        }
                     }

                     int var10000;
                     label415: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                              break label415;
                           }
                        }

                        var10000 = 0;
                     }

                     if (var10000 < 10) {
                        break label421;
                     }
                  }

                  insideBarrier = true;
               }

               if (!insideBarrier) {
                  label458: {
                     if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     }

                     if (!(entity_a instanceof LivingEntity)) {
                        entity_a = entity;
                     }

                     label443: {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt17 = (LivingEntity)entity_a;
                           if (_livEnt17.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              break label443;
                           }
                        }

                        int var98;
                        label398: {
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity_a;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                 var98 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                 break label398;
                              }
                           }

                           var98 = 0;
                        }

                        if (var98 < 10) {
                           break label458;
                        }
                     }

                     insideBarrier = true;
                  }
               }

               if (insideBarrier) {
                  label388: {
                     if (!(entity instanceof PurpleEntity) && !(entity instanceof FlameArrowEntity)) {
                        label385: {
                           if (entity instanceof ProjectileSlashEntity) {
                              int var99;
                              if (entity instanceof ProjectileSlashEntity) {
                                 ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                                 var99 = (Integer)_datEntI.m_20088_().m_135370_(ProjectileSlashEntity.DATA_mode);
                              } else {
                                 var99 = 0;
                              }

                              if (var99 == 1) {
                                 break label385;
                              }
                           }

                           if (!(entity instanceof PureLoveCannonEntity) && !(entity instanceof UzumakiEntity) && !(entity instanceof MeteorEntity)) {
                              break label388;
                           }
                        }
                     }

                     insideBarrier = false;
                  }

                  if (entity instanceof BlackHoleEntity) {
                     insideBarrier = false;
                  }
               }

               knockback = entity.getPersistentData().m_128459_("knockback");
               damage = entity.getPersistentData().m_128459_("BlockDamage");
               RANGE = entity.getPersistentData().m_128459_("BlockRange");
               RANGE = (double)Math.round(RANGE >= (double)1.0F ? RANGE * (double)2.0F : (double)1.0F);
               if (!entity.getPersistentData().m_128471_("noParticle") && !(RANGE >= (double)6.0F)) {
                  String var101 = "destroy";
               } else {
                  String var100 = "replace";
               }

               x_pos = (double)Math.round(x - RANGE * (double)0.5F);

               for(int index0 = 0; index0 < (int)RANGE; ++index0) {
                  x_dis = x_pos - x;
                  x_dis *= x_dis;
                  y_pos = (double)Math.round(y - RANGE * (double)0.5F);

                  for(int index1 = 0; index1 < (int)RANGE; ++index1) {
                     y_dis = y_pos - y;
                     y_dis *= y_dis;
                     z_pos = (double)Math.round(z - RANGE * (double)0.5F);

                     for(int index2 = 0; index2 < (int)RANGE; ++index2) {
                        BlockPos currentPos = BlockPos.m_274561_(x_pos, y_pos, z_pos);
                        if (!world.m_46859_(currentPos)) {
                           block_a = world.m_8055_(currentPos);
                           hardness = (double)block_a.m_60800_(world, currentPos);
                           z_dis = z_pos - z;
                           z_dis *= z_dis;
                           distance = x_dis + y_dis + z_dis;
                           if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:logs"))) || block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:planks")))) {
                              hardness *= (double)0.5F;
                           }

                           label350: {
                              logic_success = false;
                              if (!(block_a.m_60734_() instanceof LiquidBlock)) {
                                 Property var55 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                                 if (!(var55 instanceof BooleanProperty)) {
                                    break label350;
                                 }

                                 BooleanProperty _getbp34 = (BooleanProperty)var55;
                                 if (!(Boolean)block_a.m_61143_(_getbp34)) {
                                    break label350;
                                 }
                              }

                              logic_success = true;
                           }

                           if (hardness >= (double)0.0F && hardness < damage) {
                              logic_success = true;
                           }

                           if (block_a.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                              if (insideBarrier) {
                                 logic_success = false;
                              } else if (damage >= (double)1.5F) {
                                 logic_success = true;
                              }
                           }

                           if (logic_success && distance <= Math.max(RANGE * (double)0.5F * RANGE * (double)0.5F, (double)1.0F)) {
                              distance = Math.sqrt(distance);
                              cnt_x = (double)0.0F;
                              if (world.m_8055_(currentPos.m_122029_()).m_60815_() || world.m_8055_(currentPos.m_122029_()).m_60819_().m_76170_()) {
                                 cnt_x += (double)2.0F;
                              }

                              if (world.m_8055_(currentPos.m_122024_()).m_60815_() || world.m_8055_(currentPos.m_122024_()).m_60819_().m_76170_()) {
                                 cnt_x += (double)2.0F;
                              }

                              if (world.m_8055_(currentPos.m_122019_()).m_60815_() || world.m_8055_(currentPos.m_122019_()).m_60819_().m_76170_()) {
                                 cnt_x += (double)2.0F;
                              }

                              if (world.m_8055_(currentPos.m_122012_()).m_60815_() || world.m_8055_(currentPos.m_122012_()).m_60819_().m_76170_()) {
                                 cnt_x += (double)2.0F;
                              }

                              if (!block_a.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                                 if (world.m_8055_(currentPos.m_7494_()).m_60815_() || world.m_8055_(currentPos.m_7494_()).m_60819_().m_76170_()) {
                                    ++cnt_x;
                                 }

                                 if (world.m_8055_(currentPos.m_7495_()).m_60815_() || world.m_8055_(currentPos.m_7495_()).m_60819_().m_76170_()) {
                                    ++cnt_x;
                                 }
                              }

                              if (block_a.m_60734_() == Blocks.f_49990_ && cnt_x < (double)10.0F) {
                                 if (knockback >= (double)0.0F) {
                                    ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)4.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)5.0F) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + Math.abs(y_pos - y), z_pos, z_pos + z_pos - z, "jujutsucraft:particle_water");
                                 } else if (knockback < (double)0.0F) {
                                    ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)4.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.05, (double)0.5F) * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_water");
                                 }

                                 if (knockback >= (double)1.0F) {
                                    water = true;
                                 }
                              }

                              if (cnt_x < (double)8.0F) {
                                 label465: {
                                    if (!(block_a.m_60734_() instanceof LiquidBlock)) {
                                       label466: {
                                          Property var95 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                                          if (var95 instanceof BooleanProperty) {
                                             BooleanProperty _getbp40 = (BooleanProperty)var95;
                                             if ((Boolean)block_a.m_61143_(_getbp40)) {
                                                break label466;
                                             }
                                          }

                                          if (!block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:impermeable"))) && type_flame) {
                                             if (knockback >= (double)0.0F) {
                                                ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)1.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)5.0F) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + y_pos - y, z_pos, z_pos + z_pos - z, "jujutsucraft:particle_magma");
                                             } else if (knockback < (double)0.0F) {
                                                ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)1.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.2, (double)2.0F) * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_magma");
                                             }
                                          }

                                          if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))) {
                                             if (knockback >= (double)0.0F) {
                                                ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)1.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.1, (double)1.0F) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + y_pos - y, z_pos, z_pos + z_pos - z, "jujutsucraft:particle_big_smoke");
                                             } else if (knockback < (double)0.0F) {
                                                ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)1.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.01, 0.1) * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_big_smoke");
                                             }

                                             rock = true;
                                          } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:mineable/axe"))) && hardness > (double)0.0F) {
                                             wood = true;
                                          } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:impermeable"))) || block_a.m_60734_() == JujutsucraftModBlocks.JUJUTSU_BARRIER.get()) {
                                             if (knockback >= (double)0.0F) {
                                                ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)4.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.2, (double)2.0F) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + y_pos - y, z_pos, z_pos + z_pos - z, "jujutsucraft:particle_broken_glass_small");
                                             } else if (knockback < (double)0.0F) {
                                                ParticleGeneratorProcedure.execute(world, (double)1.0F, (double)4.0F, (double)10.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.025, (double)0.25F) * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_broken_glass_small");
                                             }

                                             glass = true;
                                          }

                                          if (block_a.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                                             if (!world.m_5776_()) {
                                                BlockEntity be = world.m_7702_(currentPos);
                                                old_block = be != null ? be.getPersistentData().m_128461_("old_block") : "";
                                                world.m_7731_(currentPos, ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("jujutsucraft:domain_hole"))).m_49966_(), 3);
                                                BlockEntity newBe = world.m_7702_(currentPos);
                                                if (newBe != null) {
                                                   newBe.getPersistentData().m_128359_("old_block", old_block);
                                                   newBe.getPersistentData().m_128359_("old_barrier", ("" + String.valueOf(block_a)).replace("}", "").replace("Block{", ""));
                                                   newBe.getPersistentData().m_128347_("delay_time", distance);
                                                }
                                             }
                                          } else if (!world.m_5776_()) {
                                             world.m_7731_(currentPos, Blocks.f_50016_.m_49966_(), 3);
                                          }

                                          if (!entity.getPersistentData().m_128471_("ExtinctionBlock")) {
                                             double spawnChance = (double)0.0F;
                                             if (type_flame && Math.random() < 0.1 + spawnChance) {
                                                block_a = Blocks.f_50083_.m_49966_();
                                             } else if (!block_a.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && Math.random() < 0.1 + spawnChance) {
                                                block_a = block_a;
                                             } else {
                                                block_a = Blocks.f_50016_.m_49966_();
                                             }

                                             if (!block_a.m_60795_() && !block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:impermeable")))) {
                                                speed = Mth.m_216263_(RandomSource.m_216327_(), 0.1, (double)1.0F) * Math.min(knockback * (double)1.0F, (double)3.0F);
                                                if (world instanceof ServerLevel) {
                                                   ServerLevel _serverLevel = (ServerLevel)world;
                                                   Entity entityinstance = EntityType.f_20450_.m_20615_(_serverLevel);
                                                   if (entityinstance != null) {
                                                      CompoundTag _compoundTag = entityinstance.m_20240_(new CompoundTag());
                                                      _compoundTag.m_128365_("BlockState", NbtUtils.m_129202_(block_a));
                                                      entityinstance.m_20258_(_compoundTag);
                                                      entityinstance.m_6034_((double)Math.round(x_pos) + (double)0.5F, (double)Math.round(y_pos), (double)Math.round(z_pos) + (double)0.5F);
                                                      if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                                                         entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Time:560,DropItem:0b,HurtEntities:0b}");
                                                      }

                                                      if (distance != (double)0.0F) {
                                                         entityinstance.m_20256_(new Vec3((x_pos - x) / distance * speed + entity.getPersistentData().m_128459_("x_knockback"), (y_pos - y) / distance * speed + entity.getPersistentData().m_128459_("y_knockback"), (z_pos - z) / distance * speed + entity.getPersistentData().m_128459_("z_knockback")));
                                                      }

                                                      _serverLevel.m_7967_(entityinstance);
                                                   }
                                                }
                                             }
                                          }
                                          break label465;
                                       }
                                    }

                                    if (logic_water) {
                                       if (!world.m_5776_()) {
                                          world.m_7731_(currentPos, Blocks.f_50016_.m_49966_(), 3);
                                       }

                                       water = true;
                                    }
                                 }
                              }
                           }
                        }

                        ++z_pos;
                     }

                     ++y_pos;
                  }

                  ++x_pos;
               }

               if (!entity.getPersistentData().m_128471_("noEffect")) {
                  float pitch = (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1);
                  if (rock && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 1.0F, pitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                     }
                  }

                  if (wood && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, pitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                     }
                  }

                  if (glass && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, pitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                     }
                  }

                  if (water && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:water_splash")), SoundSource.NEUTRAL, 1.0F, pitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:water_splash")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                     }
                  }
               }

               if (logic_a) {
                  ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(true, world.m_7654_());
               }
            }

            entity.getPersistentData().m_128347_("BlockRange", (double)0.0F);
            entity.getPersistentData().m_128347_("BlockDamage", (double)0.0F);
            entity.getPersistentData().m_128347_("effect", (double)0.0F);
            entity.getPersistentData().m_128379_("noParticle", false);
            entity.getPersistentData().m_128379_("noEffect", false);
            entity.getPersistentData().m_128379_("ExtinctionBlock", false);
         }
      }
   }
}
