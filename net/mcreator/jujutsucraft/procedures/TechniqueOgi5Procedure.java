package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi5Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         boolean type = false;
         double dis = (double)0.0F;
         double rad = (double)0.0F;
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
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + entity.getPersistentData().m_128459_("cnt10"));
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(-3.0F - entity.m_20205_()));
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + Math.sin(pitch) * (double)-1.0F * (double)(-3.0F - entity.m_20205_()) + entity.getPersistentData().m_128459_("cnt1") * (double)0.25F);
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(-3.0F - entity.m_20205_()));
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            if (entity.getPersistentData().m_128459_("cnt1") >= (double)14.0F) {
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
                     label237: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label229: {
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
                                    break label229;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label237;
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
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)13.0F));
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
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.m_20186_(), z_pos, 5, (double)0.25F, 0.1, (double)0.25F, (double)0.5F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.m_20186_(), z_pos, 2, (double)0.25F, 0.1, (double)0.25F, (double)0.5F);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.m_20186_(), z_pos, 5, (double)0.25F, (double)0.25F, (double)0.25F, CNT6 * 0.1);
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.FLAME_TIGER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoGravity:1b,Silent:1b,Invulnerable:1b}");
                     }

                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity79 = (LivingEntity)entity;
                  if (_livingEntity79.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity79.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            dis = Math.min((entity.getPersistentData().m_128459_("cnt1") - (double)14.5F) * 0.6, (double)12.0F) * CNT6 * range;

            for(int index0 = 0; index0 < 72; ++index0) {
               rad += Math.toRadians((double)10.0F) * Math.random();
               x_pos = x + Math.cos(rad) * dis;
               z_pos = z + Math.sin(rad) * dis;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y, z_pos, 1, 0.1, 0.1, 0.1, 0.05);
               }
            }

            x_power = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (dis + (double)entity.m_20205_()) - entity.getPersistentData().m_128459_("x_pos");
            y_power = entity.m_20186_() + (double)entity.m_20206_() * 0.7 + Math.sin(pitch) * (double)-1.0F * (dis + (double)entity.m_20205_()) - entity.getPersistentData().m_128459_("y_pos");
            z_pwoer = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (dis + (double)entity.m_20205_()) - entity.getPersistentData().m_128459_("z_pos");
            dis = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_pwoer, (double)2.0F));
            if (dis > (double)1.0F) {
               x_power = x_power / dis * (double)1.0F;
               y_power = y_power / dis * (double)1.0F;
               z_pwoer = z_pwoer / dis * (double)1.0F;
            }

            entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + x_power);
            entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + y_power);
            entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + z_pwoer);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)((double)15.0F * CNT6), 1.2, 1.2, 1.2, 0.1 * CNT6);
            }

            entity.getPersistentData().m_128347_("Damage", (double)21.0F * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)5.0F);
            entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
            entity.getPersistentData().m_128347_("effect", (double)5.0F);
            entity.getPersistentData().m_128347_("projectile_type", (double)2.0F);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)((double)25.0F * CNT6), 0.3, 0.3, 0.3, (double)0.5F * CNT6);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)5.0F * CNT6), 0.3, 0.3, 0.3, (double)0.5F * CNT6);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }

               CompoundTag var111;
               int var10003;
               label203: {
                  var111 = entity.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label203;
                     }
                  }

                  var10003 = 0;
               }

               var111.m_128347_("BlockDamage", ((double)0.5F + (double)var10003 * (double)0.5F) * CNT6);
               entity.getPersistentData().m_128347_("BlockRange", (double)4.0F);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F + (double)20.0F * CNT6) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
