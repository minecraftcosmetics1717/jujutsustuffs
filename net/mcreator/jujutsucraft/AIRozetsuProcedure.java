package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.RozetsuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIRozetsuProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double lv = (double)0.0F;
         double distance = (double)0.0F;
         double skill_num = (double)0.0F;
         double level = (double)0.0F;
         double strength = (double)0.0F;
         double health = (double)0.0F;
         double CNT6 = (double)0.0F;
         double dis = (double)0.0F;
         boolean domain = false;
         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("transform") > (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("transform", entity.getPersistentData().m_128459_("transform") + (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity5 = (LivingEntity)entity;
                  if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity5.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)2015.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity.getPersistentData().m_128459_("transform") < (double)4.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 100, 9, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123771_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)16.0F * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)1.25F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123799_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)8.0F * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)0.5F);
               }

               if (entity.getPersistentData().m_128459_("transform") > (double)100.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F, false);
                     }
                  }

                  entity.getPersistentData().m_128347_("transform", (double)0.0F);
                  if (entity instanceof RozetsuEntity) {
                     RozetsuEntity _datEntSetI = (RozetsuEntity)entity;
                     _datEntSetI.m_20088_().m_135381_(RozetsuEntity.DATA_form, 1);
                  }

                  if (entity instanceof RozetsuEntity) {
                     RozetsuEntity animatable = (RozetsuEntity)entity;
                     animatable.setTexture("rozetsu2");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity31 = (LivingEntity)entity;
                     if (_livingEntity31.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        AttributeInstance var10000;
                        double var10001;
                        label262: {
                           var10000 = _livingEntity31.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity30 = (LivingEntity)entity;
                              if (_livingEntity30.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity30.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                 break label262;
                              }
                           }

                           var10001 = (double)0.0F;
                        }

                        var10000.m_22100_(var10001 + (double)1.0F);
                     }
                  }

                  double var75;
                  label253: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity32 = (LivingEntity)entity;
                        if (_livingEntity32.m_21204_().m_22171_(Attributes.f_22276_)) {
                           var75 = _livingEntity32.m_21051_(Attributes.f_22276_).m_22115_();
                           break label253;
                        }
                     }

                     var75 = (double)0.0F;
                  }

                  health = var75 * (double)0.5F;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity34 = (LivingEntity)entity;
                     if (_livingEntity34.m_21204_().m_22171_(Attributes.f_22276_)) {
                        double var88;
                        label246: {
                           var76 = _livingEntity34.m_21051_(Attributes.f_22276_);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity33 = (LivingEntity)entity;
                              if (_livingEntity33.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 var88 = _livingEntity33.m_21051_(Attributes.f_22276_).m_22115_();
                                 break label246;
                              }
                           }

                           var88 = (double)0.0F;
                        }

                        var76.m_22100_(var88 + health);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     float var89;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var89 = _livEnt.m_21223_();
                     } else {
                        var89 = -1.0F;
                     }

                     _entity.m_21153_((float)((double)var89 + health));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19600_);
                  }

                  AnimationResetProcedure.execute(entity);
               }
            } else {
               int var77;
               if (entity instanceof RozetsuEntity) {
                  RozetsuEntity _datEntI = (RozetsuEntity)entity;
                  var77 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
               } else {
                  var77 = 0;
               }

               if (var77 == 1) {
                  label353: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), Integer.MAX_VALUE, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt40 = (LivingEntity)entity;
                        if (_livEnt40.m_21023_(MobEffects.f_19600_)) {
                           break label353;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 14, false, false));
                        }
                     }
                  }
               } else {
                  label363: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt42 = (LivingEntity)entity;
                        if (_livEnt42.m_21023_(MobEffects.f_19600_)) {
                           break label363;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 10, false, false));
                        }
                     }
                  }
               }

               label328: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt44 = (LivingEntity)entity;
                     if (_livEnt44.m_21023_(MobEffects.f_19606_)) {
                        break label328;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                     }
                  }
               }

               AIActiveProcedure.execute(world, x, y, z, entity);
               LivingEntity var78;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var78 = _mobEnt.m_5448_();
               } else {
                  var78 = null;
               }

               if (var78 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     int var79;
                     if (entity instanceof RozetsuEntity) {
                        RozetsuEntity _datEntI = (RozetsuEntity)entity;
                        var79 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
                     } else {
                        var79 = 0;
                     }

                     if (var79 == 0) {
                        float var80;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var80 = _livEnt.m_21223_();
                        } else {
                           var80 = -1.0F;
                        }

                        double var81 = (double)var80;
                        float var90;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var90 = _livEnt.m_21233_();
                        } else {
                           var90 = -1.0F;
                        }

                        if (var81 < (double)var90 * (double)0.5F) {
                           entity.getPersistentData().m_128347_("transform", (double)1.0F);
                           if (world instanceof ServerLevel) {
                              for(Entity entityiterator : ((ServerLevel)world).m_8583_()) {
                                 if (entityiterator != null && entity != entityiterator && entityiterator instanceof Mob && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_()) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                                 }
                              }
                           }
                        }
                     }

                     if (entity instanceof RozetsuEntity) {
                        RozetsuEntity _datEntI = (RozetsuEntity)entity;
                        var79 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
                     } else {
                        var79 = 0;
                     }

                     if (var79 > 0) {
                        float var83;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var83 = _livEnt.m_21223_();
                        } else {
                           var83 = -1.0F;
                        }

                        double var84 = (double)var83;
                        float var91;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var91 = _livEnt.m_21233_();
                        } else {
                           var91 = -1.0F;
                        }

                        if (var84 < (double)var91 * (double)0.5F) {
                           label302: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var85 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label302;
                                 }
                              }

                              var85 = 0;
                           }

                           int var86 = var85 - 10;
                           LivingEntity var92;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var92 = _mobEnt.m_5448_();
                           } else {
                              var92 = null;
                           }

                           label296: {
                              LivingEntity var36 = var92;
                              if (var36 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var36;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var93 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label296;
                                 }
                              }

                              var93 = 0;
                           }

                           if (var86 <= var93) {
                              entity.getPersistentData().m_128379_("flag_domain", true);
                           }
                        }
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (domain) {
                        tick = (double)20.0F;
                        rnd = (double)20.0F;
                     } else {
                        if (entity instanceof RozetsuEntity) {
                           RozetsuEntity _datEntI = (RozetsuEntity)entity;
                           var79 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
                        } else {
                           var79 = 0;
                        }

                        if (var79 > 0) {
                           label281: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt72 = (LivingEntity)entity;
                                 if (_livEnt72.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label281;
                                 }
                              }

                              if (distance < (double)6.0F && Math.random() < 0.15) {
                                 rnd = (double)4.0F;
                                 level = (double)1.0F;
                                 tick = (double)50.0F;
                              }
                           }
                        } else if (LogicStartProcedure.execute(entity) && Math.random() < (double)0.5F && !(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("SHIKIGAMI_ROZETSU_UUID")) instanceof LivingEntity)) {
                           rnd = (double)10.0F;
                           level = (double)0.0F;
                           tick = (double)100.0F;
                        }
                     }

                     if (rnd > (double)0.0F) {
                        ResetCounterProcedure.execute(entity);
                        if (rnd == (double)10.0F) {
                           SkillRozetsuShikigamiProcedure.execute(world, x, y, z, entity);
                        } else {
                           entity.getPersistentData().m_128347_("skill", (double)4300.0F + rnd);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                              }
                           }
                        }

                        if (level > (double)0.0F) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              }
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               }
            }
         }

      }
   }
}
