package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi9Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean power = false;
         boolean mode_speed = false;
         boolean type = false;
         boolean logic_attack = false;
         boolean oni = false;
         boolean logic_b = false;
         boolean FoxFire = false;
         double dis = (double)0.0F;
         double rad = (double)0.0F;
         double tsuki7_mode = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double rad_now = (double)0.0F;
         double yaw_now = (double)0.0F;
         double x_center = (double)0.0F;
         double y_center = (double)0.0F;
         double z_center = (double)0.0F;
         double y_fix = (double)0.0F;
         double y_power = (double)0.0F;
         double z_pwoer = (double)0.0F;
         double x_power = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double HP = (double)0.0F;
         double start_time = (double)0.0F;
         double CNT6 = (double)0.0F;
         double z_power = (double)0.0F;
         double range = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + entity.getPersistentData().m_128459_("cnt10"));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)40.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 19, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "stopsound @s");
               }

               if (entity.getPersistentData().m_128459_("cnt1") <= (double)25.0F) {
                  if (entity.getPersistentData().m_128459_("cnt1") == (double)21.0F) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 60, 0, true, true));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity13 = (LivingEntity)entity;
                        if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity13.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-16.0F);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity14 = (LivingEntity)entity;
                        if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  for(int index0 = 0; index0 < 2; ++index0) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)9.0F, (double)90.0F, (double)8.0F, (double)0.0F, (double)3.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_() + Math.random(), entity.m_20186_(), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_curse_power_blue");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)38.0F) {
                  if (OnGroundProcedure.execute(world, entity)) {
                     entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)39.0F));
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)1.0F);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)1.0F);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)1.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)38.0F));
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)2.0F * range), (double)0.25F * range, 0.1 * range, (double)0.25F * range, (double)1.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               for(int index1 = 0; index1 < 2; ++index1) {
                  ParticleGeneratorCircleProcedure.execute(world, (double)9.0F, (double)90.0F, (double)0.0F, (double)16.0F, (double)3.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random(), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_curse_power_blue");
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)19.0F) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                     if (GetDistanceProcedure.execute(entity) > (double)12.0F) {
                        label332: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                              label324: {
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
                                       break label324;
                                    }
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                    break label332;
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

                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, 20, (double)0.5F, (double)0.5F, (double)0.5F, (double)1.5F);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)9.0F, (double)90.0F, (double)0.0F, (double)16.0F, (double)3.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random(), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_curse_power_blue");
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)19.0F));
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 19, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (entity.getPersistentData().m_128459_("cnt3") <= (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity84 = (LivingEntity)entity;
                  if (_livingEntity84.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity84.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)101.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity85 = (LivingEntity)entity;
                  if (_livingEntity85.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity85.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)25.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)3.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)25.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)3.0F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F, false);
                  }
               }

               for(int index2 = 0; index2 < (int)((double)32.0F * range); ++index2) {
                  if (Math.random() < (double)0.75F && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)1.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)1.0F);
                  }

                  ++dis;
                  if (dis > (double)0.0F) {
                     entity.getPersistentData().m_128347_("Damage", (double)40.0F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)5.0F * range);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                     entity.getPersistentData().m_128347_("effect", (double)5.0F);
                     entity.getPersistentData().m_128347_("projectile_type", (double)2.0F);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                     ParticleGeneratorCircleProcedure.execute(world, (double)16.0F, entity.getPersistentData().m_128459_("pitch"), (double)0.0F, (double)16.0F, (double)3.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_(), entity.getPersistentData().m_128459_("yaw"), entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_curse_power_blue");
                     dis = (double)5.0F * range * (double)-0.5F;
                  }

                  entity.m_6021_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_() - entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_() - entity.getPersistentData().m_128459_("y_power"), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power"), entity.m_146908_(), entity.m_146909_());
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)25.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)3.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)25.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)3.0F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * range), 1.0F, false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * range), (double)0.25F * range, (double)0.25F * range, (double)0.25F * range, (double)1.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt3") == (double)7.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity181 = (LivingEntity)entity;
                  if (_livingEntity181.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity181.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-16.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity182 = (LivingEntity)entity;
                  if (_livingEntity182.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity182.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt3") > (double)30.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
