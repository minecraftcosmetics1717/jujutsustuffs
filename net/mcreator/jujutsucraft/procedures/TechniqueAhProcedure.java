package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueAhProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double rad = (double)0.0F;
         double rad_now = (double)0.0F;
         double Damage = (double)0.0F;
         double Effect = (double)0.0F;
         double Knockback = (double)0.0F;
         double CNT6 = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double range = (double)0.0F;
         double strength = (double)0.0F;
         double old_skill = (double)0.0F;
         double loop_num = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(1.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().m_128459_("cnt2") < (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity9 = (LivingEntity)entity;
               if (_livingEntity9.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity9.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-19.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity10 = (LivingEntity)entity;
               if (_livingEntity10.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity10.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceProcedure.execute(entity) > (double)8.0F) {
                  label203: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label204: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                 break label204;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label203;
                           }
                        }
                     }

                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)8.0F));
               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }

                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity45 = (LivingEntity)entity;
                  if (_livingEntity45.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity45.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-19.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity46 = (LivingEntity)entity;
                  if (_livingEntity46.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity46.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.6F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.6F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.7F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.7F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               entity.getPersistentData().m_128347_("yaw", (double)(entity.m_146908_() + 90.0F));
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
            }

            x_power = entity.getPersistentData().m_128459_("x_power");
            y_power = entity.getPersistentData().m_128459_("y_power");
            z_power = entity.getPersistentData().m_128459_("z_power");
            rad_now = Math.toRadians(entity.getPersistentData().m_128459_("yaw") + (double)90.0F);
            loop_num = (double)0.0F;
            dis = (double)3.0F;
            logic_a = false;

            for(int index0 = 0; index0 < 36; ++index0) {
               dis += 0.15;
               entity.getPersistentData().m_128347_("Damage", ((double)15.0F + entity.getPersistentData().m_128459_("cnt1") * 0.05) * CNT6);
               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.pow(0.985, loop_num));
               entity.getPersistentData().m_128347_("Range", dis * (double)2.0F);
               entity.getPersistentData().m_128347_("knockback", (double)1.0F);
               entity.getPersistentData().m_128347_("effect", (double)12.0F);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               x_pos += x_power * 0.33;
               y_pos += y_power * 0.33;
               z_pos += z_power * 0.33;
               if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos - dis * (double)1.0F, z_pos, dis * (double)2.0F, dis * (double)2.0F)) {
                  if (!logic_a) {
                     logic_a = true;
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                        }
                     }
                  }

                  if (loop_num % (double)5.0F == (double)1.0F) {
                     entity.getPersistentData().m_128347_("BlockRange", dis * (double)1.0F);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)10.0F);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                     old_skill = entity.getPersistentData().m_128459_("skill");
                     entity.getPersistentData().m_128347_("skill", (double)107.0F);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("skill", old_skill);
                  }

                  if (Math.random() < 0.2 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)Math.max(dis * (double)0.25F, (double)2.0F), dis * (double)0.5F, dis * (double)0.5F, dis * (double)0.5F, (double)1.0F);
                  }

                  if (Math.random() < 0.2 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)Math.max(dis * 0.1, (double)1.0F), dis * (double)0.5F, dis * (double)0.5F, dis * (double)0.5F, (double)1.0F);
                  }

                  if (Math.random() < 0.2 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME_PURPLE.get(), x_pos, y_pos, z_pos, (int)Math.max(dis * 0.1, (double)1.0F), dis * (double)0.5F, dis * (double)0.5F, dis * (double)0.5F, (double)1.0F);
                  }

                  entity.getPersistentData().m_128379_("noEffect", true);
               }

               ++loop_num;
            }

            entity.getPersistentData().m_128379_("noEffect", false);
            range = ReturnEntitySizeProcedure.execute(entity);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(1.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            ParticleGeneratorCircleProcedure.execute(world, (double)36.0F, entity.getPersistentData().m_128459_("pitch"), (double)0.0F, (double)1.0F, (double)16.0F, x_pos, x_pos + x_power, y_pos, y_pos + y_power, entity.getPersistentData().m_128459_("yaw") - (double)90.0F, z_pos, z_pos + z_power, "minecraft:enchanted_hit");
            if (entity.getPersistentData().m_128459_("cnt1") > (double)16.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
