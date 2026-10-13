package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.BlueEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.RedEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HollowPurpleProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean big = false;
         double rnd = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double HP = (double)0.0F;
         double rad = (double)0.0F;
         double rad_now = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
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
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            double var131 = ((Entity)var10000).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var140 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var140 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var131, var140, ((Entity)var10002).m_20189_(), entity);
         }

         entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
         entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
         entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 3, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            int var142;
            label514: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var142 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label514;
                  }
               }

               var142 = 0;
            }

            HP = (double)(40 + var142 * 20);
            pitch = Math.toRadians((double)entity.m_146909_());
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F - 40.0F));
            distance = (double)(2.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.RED.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
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

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                     if (_livingEntity38.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity38.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity42 = (LivingEntity)entityinstance;
                     if (_livingEntity42.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity42.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)2.0F);
                     }
                  }

                  if (entityinstance instanceof RedEntity) {
                     RedEntity _datEntSetL = (RedEntity)entityinstance;
                     _datEntSetL.m_20088_().m_135381_(RedEntity.DATA_flag_purple, true);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F + 40.0F));
            distance = (double)(2.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLUE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
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

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity60 = (LivingEntity)entityinstance;
                     if (_livingEntity60.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity60.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                     if (_livingEntity64.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity64.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)2.0F);
                     }
                  }

                  if (entityinstance instanceof BlueEntity) {
                     BlueEntity _datEntSetL = (BlueEntity)entityinstance;
                     _datEntSetL.m_20088_().m_135381_(BlueEntity.DATA_flag_purple, true);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)20.0F && entity.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity70 = (LivingEntity)entity;
               if (_livingEntity70.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity70.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)20.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity71 = (LivingEntity)entity;
               if (_livingEntity71.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity71.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)24.0F), (e) -> true)) {
               if (entity != entityiterator && entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged")) {
                  label533: {
                     if (entityiterator instanceof RedEntity) {
                        RedEntity _datEntL76 = (RedEntity)entityiterator;
                        if ((Boolean)_datEntL76.m_20088_().m_135370_(RedEntity.DATA_flag_purple)) {
                           break label533;
                        }
                     }

                     if (!(entityiterator instanceof BlueEntity)) {
                        continue;
                     }

                     BlueEntity _datEntL77 = (BlueEntity)entityiterator;
                     if (!(Boolean)_datEntL77.m_20088_().m_135370_(BlueEntity.DATA_flag_purple)) {
                        continue;
                     }
                  }

                  logic_a = true;
                  if (entityiterator instanceof RedEntity) {
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F) + Math.max((double)40.0F - entity.getPersistentData().m_128459_("cnt1") * (double)4.0F, (double)0.0F));
                  } else if (entityiterator instanceof BlueEntity) {
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F) + Math.max((double)40.0F - entity.getPersistentData().m_128459_("cnt1") * (double)4.0F, (double)0.0F));
                  } else {
                     logic_a = false;
                  }

                  if (logic_a) {
                     pitch = Math.toRadians((double)entity.m_146909_());
                     distance = (double)(1.0F + entity.m_20205_());
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     entityiterator.m_6021_(x_pos, y_pos, z_pos);
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityiterator.m_146908_(), entityiterator.m_146909_());
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 5, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.0F);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") <= (double)20.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") >= (double)19.0F) {
               if (entity.getPersistentData().m_128459_("cnt4") > (double)0.0F && entity.getPersistentData().m_128459_("cnt6") >= (double)0.0F) {
                  for(int index0 = 0; index0 < (int)((double)2.0F * range); ++index0) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.5F * range, (double)0.75F * range, (double)4.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), entity.getPersistentData().m_128459_("cnt6") >= (double)6.0F ? "enchanted_hit" : "crit");
                  }

                  for(int index1 = 0; index1 < (int)((double)2.0F * range); ++index1) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)2.0F * range, (double)8.0F * range, (double)1.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "cloud");
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F && Math.random() < 0.1) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     for(int index2 = 0; index2 < (int)((double)4.0F * range); ++index2) {
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F * range, (double)8.0F * range, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)2.0F) * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_thunder_purple");
                     }

                     for(int index3 = 0; index3 < (int)((double)4.0F * range); ++index3) {
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.5F * range, (double)0.75F * range, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)2.0F) * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_thunder_purple");
                     }
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)12.0F) {
                     label538: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label539: {
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
                                    break label539;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label538;
                              }
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 != entity) {
                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                        }
                     }
                  }

                  if (!(entity instanceof GojoSatoruEntity)) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", (double)19.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 9, 5, false, false));
                     }
                  }

                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  pitch = Math.toRadians((double)entity.m_146909_());
                  distance = (double)1.5F + (double)entity.m_20205_();
                  x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
                  z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)6.0F) {
                     ChargeParticleProcedure.execute(world, entity, (double)1.0F);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, (double)0.0F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") < (double)4.0F) {
                     entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt5") > (double)20.0F) {
                        if (entity.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
                           entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity162 = (LivingEntity)entity;
                              if (_livingEntity162.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                                 _livingEntity162.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)215.0F);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity163 = (LivingEntity)entity;
                              if (_livingEntity163.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                                 _livingEntity163.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                              }
                           }

                           PlayAnimationProcedure.execute(world, entity);
                        }

                        entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)1.0F);
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              CompoundTag var143 = entity.getPersistentData();
                              _player.m_5661_(Component.m_237113_("§l\"" + Component.m_237115_("chant.jujutsucraft.purple" + Math.round(var143.m_128459_("cnt6"))).getString() + "\""), false);
                           }
                        }

                        if (entity instanceof Player) {
                           double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)50.0F;
                           entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.PlayerCursePowerChange = _setval;
                              capability.syncPlayerVariables(entity);
                           });
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)4.0F && entity.getPersistentData().m_128459_("cnt6") < (double)6.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)6.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 10, (double)0.25F, (double)0.25F, (double)0.25F, (double)1.5F);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }
                  }
               }
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               label559: {
                  label503: {
                     if (entity instanceof Player) {
                        if (entity.getPersistentData().m_128459_("cnt6") >= (double)6.0F && entity.m_6144_()) {
                           break label503;
                        }
                     } else if (entity instanceof GojoSatoruEntity) {
                        float var138;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var138 = _livEnt.m_21223_();
                        } else {
                           var138 = -1.0F;
                        }

                        double var139 = (double)var138;
                        float var144;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var144 = _livEnt.m_21233_();
                        } else {
                           var144 = -1.0F;
                        }

                        if (var139 < (double)var144 * 0.4) {
                           break label503;
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                     break label559;
                  }

                  entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)21.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity188 = (LivingEntity)entity;
                     if (_livingEntity188.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity188.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)215.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity189 = (LivingEntity)entity;
                     if (_livingEntity189.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity189.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)28.0F) {
                  logic_a = true;
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity191 = (LivingEntity)entity;
                  if (_livingEntity191.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity191.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)2015.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity192 = (LivingEntity)entity;
                  if (_livingEntity192.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity192.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)21.0F) {
                  logic_a = true;
               }
            }

            if (logic_a) {
               int var145;
               label488: {
                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  pitch = Math.toRadians((double)entity.m_146909_());
                  distance = (double)1.5F + (double)entity.m_20205_();
                  x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
                  z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var145 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label488;
                     }
                  }

                  var145 = 0;
               }

               HP = (double)(400 + var145 * 40);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.PURPLE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
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

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity208 = (LivingEntity)entityinstance;
                        if (_livingEntity208.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity208.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)4.0F) {
                        entityinstance.getPersistentData().m_128347_("size", (double)8.0F * ((double)0.5F + entity.getPersistentData().m_128459_("cnt6") * (double)0.5F));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity219 = (LivingEntity)entityinstance;
                           if (_livingEntity219.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity219.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)5.0F);
                           }
                        }
                     } else {
                        entityinstance.getPersistentData().m_128347_("size", (double)8.0F * ((double)0.5F + entity.getPersistentData().m_128459_("cnt6") * 0.2));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity224 = (LivingEntity)entityinstance;
                           if (_livingEntity224.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity224.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)5.0F);
                           }
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt2") == (double)2.0F) {
                        entityinstance.getPersistentData().m_128347_("size", (double)5.0F);
                        entityinstance.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6") - (double)4.0F, (double)2.0F));
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", "");
                        entityinstance.getPersistentData().m_128379_("explode", true);
                        entityinstance.getPersistentData().m_128379_("betrayal", true);
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_() + (double)2.0F + (double)entity.m_20206_() + Math.max(entityinstance.getPersistentData().m_128459_("size"), (double)5.0F) * 0.2;
                        z_pos = entity.m_20189_();
                     } else {
                        distance = (double)2.0F + ((double)entity.m_20205_() + Math.max(entityinstance.getPersistentData().m_128459_("size"), (double)5.0F) * 0.2) * (double)0.75F;
                        x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
                        z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     }

                     entityinstance.m_6021_(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityinstance.m_146908_(), entityinstance.m_146909_());
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)66.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
