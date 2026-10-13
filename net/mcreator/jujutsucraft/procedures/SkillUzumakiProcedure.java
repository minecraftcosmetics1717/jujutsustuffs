package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade03Entity;
import net.mcreator.jujutsucraft.entity.GetoSuguruCurseUserEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillUzumakiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double distance = (double)0.0F;
         double num1 = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         Entity target_entity = null;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (target_entity instanceof LivingEntity) {
            x_pos = target_entity.m_20185_();
            y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * (double)0.75F;
            z_pos = target_entity.m_20189_();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt9") < (double)20.0F) {
            entity.getPersistentData().m_128347_("cnt9", entity.getPersistentData().m_128459_("cnt9") + (double)1.0F);
            if (entity instanceof Player) {
               if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt9", (double)30.0F);
               }
            } else if (!entity.getPersistentData().m_128471_("uzumaki")) {
               entity.getPersistentData().m_128347_("cnt9", (double)30.0F);
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle soul ^ ^ ^3 0.1 0.1 0.1 0 2 normal @s");
            }
         }

         if (entity.getPersistentData().m_128459_("cnt9") >= (double)30.0F && entity.getPersistentData().m_128459_("cnt9") < (double)35.0F) {
            entity.getPersistentData().m_128347_("skill", (double)1816.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt9") >= (double)20.0F && entity.getPersistentData().m_128459_("cnt9") < (double)25.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)0.0F);
            distance = (double)(-3.0F - entity.m_20205_());
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance);
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance);
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)20.0F) {
               if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity38 = (LivingEntity)entity;
                  if (_livingEntity38.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity38.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-3.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               num1 = entity.getPersistentData().m_128459_("cnt1") / (double)19.5F;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos + (double)2.0F, z_pos, (int)((double)50.0F * num1), (double)1.5F * num1, (double)1.5F * num1, (double)1.5F * num1, (double)0.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos + (double)2.0F, z_pos, (int)((double)25.0F * num1), (double)1.5F * num1, (double)1.5F * num1, (double)1.5F * num1, (double)0.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)700.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)(entity.getPersistentData().m_128459_("COOLDOWN_TICKS") * (double)2.0F), 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 100, 0, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 1.0F, 0.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 1.0F, 0.25F, false);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && !(entity instanceof Player)) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)256.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator.getPersistentData().m_128471_("CursedSpirit") && !(entityiterator instanceof Player) && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123746_, entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F, entityiterator.m_20189_(), (int)Math.min(Math.pow((double)(entityiterator.m_20205_() * 2.0F + entityiterator.m_20206_() * 2.0F), (double)2.0F), (double)100.0F), (double)entityiterator.m_20205_() * (double)0.5F, (double)entityiterator.m_20206_() * (double)0.5F, (double)entityiterator.m_20205_() * (double)0.5F, (double)0.0F);
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                  if (entity instanceof Player) {
                     x_pos = (double)0.0F;
                     z_pos = (double)0.0F;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        Commands var91 = entity.m_20194_().m_129892_();
                        CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        long var10002 = Math.round(x_pos);
                        var91.m_230957_(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                     }

                     num1 = (double)0.0F;

                     for(int index0 = 0; index0 < 10000; ++index0) {
                        ++num1;
                        STR1 = "data_cursed_spirit_manipulation" + Math.round(num1);
                        if (entity.getPersistentData().m_128459_(STR1) == (double)0.0F) {
                           break;
                        }

                        y_pos = entity.getPersistentData().m_128459_(STR1);
                        if (world instanceof ServerLevel) {
                           ServerLevel _origLevel = (ServerLevel)world;
                           LevelAccessor var34 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                           if (var34 != null) {
                              Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                              for(Entity entityiterator : var34.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
                                 if (entity != entityiterator && entity.getPersistentData().m_128461_(STR1 + "_name").equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                                    double var98;
                                    int var10003;
                                    label361: {
                                       var92 = entity.getPersistentData();
                                       var98 = entity.getPersistentData().m_128459_("cnt6");
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label361;
                                          }
                                       }

                                       var10003 = 0;
                                    }

                                    var92.m_128347_("cnt6", var98 + (double)(var10003 + 1) * 0.1);
                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                                    }

                                    if (!entityiterator.m_9236_().m_5776_()) {
                                       entityiterator.m_146870_();
                                    }
                                 }
                              }
                           }

                           world = world;
                        }

                        entity.getPersistentData().m_128347_(STR1, (double)0.0F);
                        entity.getPersistentData().m_128347_(STR1 + "_num", (double)0.0F);
                        entity.getPersistentData().m_128359_(STR1 + "_name", "");
                     }

                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  } else {
                     entity.getPersistentData().m_128379_("use_uzumaki", true);
                     if (entity instanceof GetoSuguruCurseUserEntity) {
                        entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                        GetoSpawnCurseRandomProcedure.execute(world, x, y, z, entity);
                        entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") - (double)1.0F);
                        entity.getPersistentData().m_128347_("skill", (double)1815.0F);
                     }
                  }

                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && !(entity instanceof Player)) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)256.0F), (e) -> true)) {
                        if (entity != entityiterator && !(entityiterator instanceof CursedSpiritGrade03Entity) && entityiterator.getPersistentData().m_128471_("CursedSpirit") && !(entityiterator instanceof Player) && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                           double var99;
                           int var100;
                           label335: {
                              var93 = entity.getPersistentData();
                              var99 = entity.getPersistentData().m_128459_("cnt6");
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var100 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label335;
                                 }
                              }

                              var100 = 0;
                           }

                           var93.m_128347_("cnt6", var99 + (double)(var100 + 1) * 0.1);
                           if (!entityiterator.m_9236_().m_5776_()) {
                              entityiterator.m_146870_();
                           }
                        }
                     }
                  }

                  int var96;
                  label327: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var96 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label327;
                        }
                     }

                     var96 = 0;
                  }

                  HP = (double)(400 + var96 * 40);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.UZUMAKI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                           LivingEntity _livingEntity121 = (LivingEntity)entityinstance;
                           if (_livingEntity121.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity121.m_21051_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity128 = (LivingEntity)entityinstance;
                           if (_livingEntity128.m_21204_().m_22171_(Attributes.f_22281_)) {
                              label315: {
                                 var94 = _livingEntity128.m_21051_(Attributes.f_22281_);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity125 = (LivingEntity)entityinstance;
                                    if (_livingEntity125.m_21204_().m_22171_(Attributes.f_22281_)) {
                                       var97 = _livingEntity125.m_21051_(Attributes.f_22281_).m_22115_();
                                       break label315;
                                    }
                                 }

                                 var97 = (double)0.0F;
                              }

                              var94.m_22100_(var97 + entity.getPersistentData().m_128459_("cnt6"));
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity130 = (LivingEntity)entityinstance;
                           if (_livingEntity130.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity130.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)80.0F) {
               if (target_entity instanceof LivingEntity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 20, false, false));
                     }
                  }

                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (target_entity.getPersistentData().m_128459_("skill") == (double)515.0F) {
                     if (target_entity.getPersistentData().m_128459_("cnt1") < (double)80.0F) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     } else {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  } else {
                     if (target_entity instanceof OkkotsuYutaEntity && target_entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                        label271: {
                           if (target_entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)target_entity;
                              if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                 var95 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                                 break label271;
                              }
                           }

                           var95 = 0;
                        }

                        if (var95 >= 10) {
                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().m_128379_("PRESS_Z", false);
                        }
                     }

                     if (target_entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                        if (GetDistanceProcedure.execute(entity) >= (double)10.0F) {
                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().m_128379_("PRESS_Z", false);
                        }
                     }

                     if (target_entity.getPersistentData().m_128459_("skill") > (double)0.0F) {
                        if (target_entity.getPersistentData().m_128471_("PRESS_Z")) {
                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().m_128379_("PRESS_Z", false);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") >= (double)200.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)78.0F));
               }
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)90.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity165 = (LivingEntity)entity;
                  if (_livingEntity165.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity165.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-7.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
