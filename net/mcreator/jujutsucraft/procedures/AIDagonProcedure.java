package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.DagonEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIDagonProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean infinity = false;
         boolean domain = false;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double health = (double)0.0F;
         double CNT6 = (double)0.0F;
         double dis = (double)0.0F;
         if (entity.m_6084_()) {
            int var10000;
            if (entity instanceof DagonEntity) {
               DagonEntity _datEntI = (DagonEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 >= 1) {
               label296: {
                  AIActiveProcedure.execute(world, x, y, z, entity);
                  AIActiveFlyingProcedure.execute(world, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19596_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                        break label296;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 13, false, false));
                     }
                  }
               }
            }

            label272: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                     break label272;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                  }
               }
            }

            label267: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19593_)) {
                     break label267;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, Integer.MAX_VALUE, 4, false, false));
                  }
               }
            }

            label262: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_(MobEffects.f_19608_)) {
                     break label262;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19608_, Integer.MAX_VALUE, 0, false, false));
                  }
               }
            }

            if (entity instanceof DagonEntity) {
               DagonEntity _datEntI = (DagonEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 == 0) {
               float var63;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var63 = _livEnt.m_21223_();
               } else {
                  var63 = -1.0F;
               }

               double var64 = (double)var63;
               float var10001;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21233_();
               } else {
                  var10001 = -1.0F;
               }

               if (var64 < (double)var10001 * (double)0.75F || entity.getPersistentData().m_128459_("cnt_target") > (double)600.0F) {
                  if (entity instanceof DagonEntity) {
                     DagonEntity _datEntSetI = (DagonEntity)entity;
                     _datEntSetI.m_20088_().m_135381_(DagonEntity.DATA_form, 1);
                  }

                  if (entity instanceof DagonEntity) {
                     DagonEntity animatable = (DagonEntity)entity;
                     animatable.setTexture("dagon2");
                  }

                  label251: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity17 = (LivingEntity)entity;
                        if (_livingEntity17.m_21204_().m_22171_(Attributes.f_22276_)) {
                           var64 = _livingEntity17.m_21051_(Attributes.f_22276_).m_22115_();
                           break label251;
                        }
                     }

                     var64 = (double)0.0F;
                  }

                  health = var64 * (double)2.0F;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity19 = (LivingEntity)entity;
                     if (_livingEntity19.m_21204_().m_22171_(Attributes.f_22276_)) {
                        label243: {
                           var66 = _livingEntity19.m_21051_(Attributes.f_22276_);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity18 = (LivingEntity)entity;
                              if (_livingEntity18.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 var70 = _livingEntity18.m_21051_(Attributes.f_22276_).m_22115_();
                                 break label243;
                              }
                           }

                           var70 = (double)0.0F;
                        }

                        var66.m_22100_(var70 + health);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     _entity.m_21153_(var10001);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19600_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STUN.get());
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  entity.m_20256_(new Vec3((double)0.0F, (double)2.0F, (double)0.0F));
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)15.0F * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)1.0F);
                  }
               }
            }

            LivingEntity var67;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var67 = _mobEnt.m_5448_();
            } else {
               var67 = null;
            }

            if (var67 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  int var68;
                  if (entity instanceof DagonEntity) {
                     DagonEntity _datEntI = (DagonEntity)entity;
                     var68 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
                  } else {
                     var68 = 0;
                  }

                  if (var68 >= 1) {
                     CompoundTag var69 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21223_();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var72 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.m_21233_();
                     } else {
                        var10003 = -1.0F;
                     }

                     label225: {
                        if (var72 < (double)var10003 * (double)0.5F) {
                           label222: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var73 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label222;
                                 }
                              }

                              var73 = 0;
                           }

                           int var74 = var73 - 10;
                           LivingEntity var76;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var76 = _mobEnt.m_5448_();
                           } else {
                              var76 = null;
                           }

                           label216: {
                              LivingEntity var31 = var76;
                              if (var31 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var31;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var77 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label216;
                                 }
                              }

                              var77 = 0;
                           }

                           if (var74 <= var77) {
                              var75 = true;
                              break label225;
                           }
                        }

                        var75 = false;
                     }

                     var69.m_128379_("flag_domain", var75);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     ResetCounterProcedure.execute(entity);
                     if ((!LogicStartProcedure.execute(entity) || !(Math.random() > 0.3) && !entity.getPersistentData().m_128471_("UseCursedTechnique")) && !domain) {
                        CalculateAttackProcedure.execute(world, entity);
                     } else {
                        if (domain) {
                           tick = (double)20.0F;
                           rnd = (double)20.0F;
                           entity.getPersistentData().m_128379_("flag_domain", false);
                        } else {
                           distance = GetDistanceProcedure.execute(entity);

                           for(int index0 = 0; index0 < 256; ++index0) {
                              rnd = (double)Math.round(Math.ceil(Math.random() * (double)20.0F));
                              if (rnd == (double)5.0F) {
                                 tick = (double)50.0F;
                                 if (!(distance > (double)16.0F)) {
                                    break;
                                 }
                              } else if (rnd == (double)6.0F) {
                                 tick = (double)75.0F;
                                 if (!(distance < (double)8.0F)) {
                                    break;
                                 }
                              } else {
                                 if (rnd == (double)7.0F) {
                                    tick = (double)75.0F;
                                    break;
                                 }

                                 if (rnd == (double)9.0F) {
                                    tick = (double)125.0F;
                                    break;
                                 }

                                 if (rnd == (double)10.0F) {
                                    if (!(Math.random() < (double)0.5F)) {
                                       tick = (double)200.0F;
                                       break;
                                    }
                                 } else if (rnd == (double)20.0F) {
                                    tick = (double)20.0F;
                                    if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        entity.getPersistentData().m_128347_("skill", (double)Math.round((double)800.0F + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }

                        entity.getPersistentData().m_128379_("UseCursedTechnique", false);
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
