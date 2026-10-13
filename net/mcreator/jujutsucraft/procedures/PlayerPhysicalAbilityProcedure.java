package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerPhysicalAbilityProcedure {
   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double level_jump_set = (double)0.0F;
         double PlayerCT1 = (double)0.0F;
         double level_armor = (double)0.0F;
         double level = (double)0.0F;
         double old_health = (double)0.0F;
         double level_speed_set = (double)0.0F;
         double level_sukuna = (double)0.0F;
         double old_cool = (double)0.0F;
         double level_speed = (double)0.0F;
         double level_armorToughness = (double)0.0F;
         double level_physicalGifted = (double)0.0F;
         double level_power = (double)0.0F;
         double level_resistance = (double)0.0F;
         double level_jump = (double)0.0F;
         double PlayerCT2 = (double)0.0F;
         double level_health = (double)0.0F;
         boolean projectionSorcery = false;
         boolean MythricalBeastAmberEffect = false;
         boolean blue = false;
         boolean YujiItadori = false;
         boolean hasSpeed = false;
         boolean hasJump = false;
         if (entity.m_6084_() && entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (serverPlayer.f_19797_ % 2 == 0) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               level = playerVars.PlayerLevel;
               PlayerCT1 = playerVars.PlayerCurseTechnique;
               PlayerCT2 = playerVars.PlayerCurseTechnique2;
               if (PlayerCT1 != (double)0.0F) {
                  boolean var10000;
                  label452: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt1 = (LivingEntity)entity;
                        if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           var10000 = true;
                           break label452;
                        }
                     }

                     var10000 = false;
                  }

                  MythricalBeastAmberEffect = var10000;
                  YujiItadori = PlayerCT1 == (double)21.0F || PlayerCT2 == (double)21.0F;
                  if (PlayerCT1 == (double)2.0F || PlayerCT2 == (double)2.0F) {
                     label440: {
                        if (LogicStartPassiveProcedure.execute(entity) && entity instanceof ServerPlayer) {
                           ServerPlayer _plr2 = (ServerPlayer)entity;
                           if (_plr2.m_9236_() instanceof ServerLevel && _plr2.m_8960_().m_135996_(_plr2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_high_speed"))).m_8193_()) {
                              var10000 = true;
                              break label440;
                           }
                        }

                        var10000 = false;
                     }

                     blue = var10000;
                  }

                  if (PlayerCT1 == (double)19.0F || PlayerCT2 == (double)19.0F) {
                     projectionSorcery = LogicStartPassiveProcedure.execute(entity);
                  }

                  if (YujiItadori) {
                     level = Math.max(level + (double)3.0F, level * 1.2);
                  }

                  if (serverPlayer.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     level_sukuna = (double)Math.min(serverPlayer.m_21124_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).m_19564_() + 1, 20);
                     if (level_sukuna <= (double)10.0F) {
                        level = Math.max(level, (double)(15L + Math.round(Math.floor(level_sukuna * (double)0.5F))));
                     } else if (level_sukuna <= (double)19.0F) {
                        level = Math.max(level, (double)(10L + Math.round(Math.floor(level_sukuna * (double)1.0F))));
                     } else {
                        level = Math.max(level, (double)35.0F);
                     }
                  }

                  if (playerVars.PlayerCursePowerFormer == (double)0.0F) {
                     level = Math.max(level + (double)6.0F, level * 1.3);
                     level_physicalGifted = (double)5.0F;
                  } else if (playerVars.PlayerCursePowerFormer < (double)100.0F) {
                     level = Math.max(level + (double)3.0F, level * 1.2);
                     level_physicalGifted = (double)1.0F;
                  }

                  if (level > (double)0.0F) {
                     level = Math.max(level - (double)1.0F, (double)0.0F);
                     level_power = (double)Math.round(level);
                     level_power = level_power < (double)3.0F ? Math.min(level_power, (double)1.0F) : level_power;
                     level_resistance = (double)Math.round(level < (double)3.0F ? (double)0.0F : Math.min(level / (double)4.0F, (double)3.0F));
                     level_health = (double)Math.round(level >= (double)19.0F ? (double)9.0F : Math.min(level / (double)3.0F, (double)4.0F));
                     if (level_sukuna > (double)0.0F) {
                        level_health = (double)Math.round(Math.max(level_health, (double)14.0F));
                     }

                     if (level > (double)0.0F) {
                        if (entity.m_20142_()) {
                           level_speed = level * (double)0.5F;
                           if (projectionSorcery) {
                              level_speed = (double)Math.round(Math.min(Math.max(level_speed * (double)3.0F, (double)10.0F), (double)120.0F));
                           } else if (!(level_physicalGifted > (double)0.0F) && !YujiItadori && !MythricalBeastAmberEffect && !blue) {
                              level_speed = (double)Math.round(Math.min(level_speed, (double)15.0F));
                           } else {
                              level_speed = (double)Math.round(Math.min(Math.max(level_speed * (double)2.0F, (double)3.0F), (double)30.0F));
                           }

                           hasSpeed = serverPlayer.m_21023_(MobEffects.f_19596_);
                           level_speed_set = hasSpeed ? (double)serverPlayer.m_21124_(MobEffects.f_19596_).m_19564_() : (double)0.0F;
                           if (!hasSpeed) {
                              if (entity.m_20096_()) {
                                 if (PlayerCT1 >= (double)0.0F && PlayerCT2 >= (double)0.0F) {
                                    if (projectionSorcery) {
                                       level_speed_set = (double)10.0F;
                                    } else if (blue) {
                                       level_speed_set = (double)5.0F;
                                    } else if (!YujiItadori && !MythricalBeastAmberEffect) {
                                       level_speed_set = (double)0.0F;
                                    } else {
                                       level_speed_set = (double)3.0F;
                                    }
                                 } else {
                                    level_speed_set = level_physicalGifted;
                                 }

                                 serverPlayer.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 20, (int)level_speed_set, false, false));
                              }
                           } else {
                              level_speed_set += (double)(!(level_physicalGifted > (double)0.0F) && !YujiItadori && !MythricalBeastAmberEffect && !projectionSorcery && !blue ? 1 : 2);
                              if (serverPlayer.m_21124_(MobEffects.f_19596_).m_19557_() <= 5) {
                                 serverPlayer.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 10, (int)Math.min(level_speed_set, level_speed), false, false));
                              }
                           }
                        }

                        if (entity.m_6144_() || !entity.m_20096_()) {
                           hasJump = serverPlayer.m_21023_(MobEffects.f_19603_);
                           if (entity.m_6144_()) {
                              level_jump = (double)Math.round(Math.min(level / (double)4.0F, (double)6.0F));
                              level_jump_set = hasJump ? (double)serverPlayer.m_21124_(MobEffects.f_19603_).m_19564_() : (double)0.0F;
                              ++level_jump_set;
                              if (!hasJump) {
                                 level_jump_set = level_speed_set - (double)1.0F;
                              }
                           } else {
                              level_jump = (double)Math.round(Math.min(level_speed_set / (double)4.0F, level / (double)4.0F));
                              level_jump_set = level_jump;
                           }

                           if ((hasJump ? serverPlayer.m_21124_(MobEffects.f_19603_).m_19557_() : 0) <= 5) {
                              serverPlayer.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 10, (int)Math.min(level_jump, level_jump_set), false, false));
                           }
                        }
                     }

                     if (serverPlayer.f_19797_ % 100 == 10) {
                        if ((!serverPlayer.m_21023_(MobEffects.f_19600_) || (double)serverPlayer.m_21124_(MobEffects.f_19600_).m_19564_() < level_power) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:strength infinite " + Math.round(level_power) + " true");
                        }

                        if ((!serverPlayer.m_21023_(MobEffects.f_19606_) || (double)serverPlayer.m_21124_(MobEffects.f_19606_).m_19564_() < level_resistance) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:resistance infinite " + Math.round(level_resistance) + " true");
                        }

                        if (!serverPlayer.m_21023_(MobEffects.f_19616_) || (double)serverPlayer.m_21124_(MobEffects.f_19616_).m_19564_() < level_health) {
                           float var74;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var74 = _livEnt.m_21223_();
                           } else {
                              var74 = -1.0F;
                           }

                           int var10003;
                           label360: {
                              var75 = (double)var74;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19616_)) {
                                    var10003 = _livEnt.m_21124_(MobEffects.f_19616_).m_19564_();
                                    break label360;
                                 }
                              }

                              var10003 = 0;
                           }

                           old_health = var75 + (double)4.0F * (level_health - (double)var10003 + (double)1.0F);
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:health_boost infinite " + Math.round(level_health) + " true");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21153_((float)old_health);
                           }
                        }

                        level_armor = level * (double)1.0F;
                        level_armorToughness = level * 0.15;
                        if (YujiItadori) {
                           level_armor += (double)4.0F;
                           level_armorToughness += (double)0.5F;
                        }

                        level_armor = Math.min(level_armor, (double)30.0F);
                        level_armorToughness = Math.min(level_armorToughness, (double)20.0F);
                        if (serverPlayer.m_21051_(Attributes.f_22284_) != null && level_armor > serverPlayer.m_21133_(Attributes.f_22284_)) {
                           serverPlayer.m_21051_(Attributes.f_22284_).m_22100_(level_armor);
                        }

                        if (serverPlayer.m_21051_(Attributes.f_22285_) != null && level_armorToughness > serverPlayer.m_21133_(Attributes.f_22285_)) {
                           serverPlayer.m_21051_(Attributes.f_22285_).m_22100_(level_armorToughness);
                        }

                        if (PlayerCT1 >= (double)0.0F && PlayerCT2 >= (double)0.0F) {
                           if (PlayerCT1 != (double)1.0F && PlayerCT2 != (double)1.0F && PlayerCT1 != (double)4.0F && PlayerCT2 != (double)4.0F) {
                              if (PlayerCT1 == (double)8.0F || PlayerCT2 == (double)8.0F) {
                                 if (!serverPlayer.m_21023_(MobEffects.f_19593_) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                    entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:dolphins_grace infinite 4 true");
                                 }

                                 if (!serverPlayer.m_21023_(MobEffects.f_19608_) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                    entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:water_breathing infinite 0 true");
                                 }
                              }
                           } else if (!serverPlayer.m_21023_(MobEffects.f_19607_) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:fire_resistance infinite 0 true");
                           }
                        } else if (level_physicalGifted > (double)0.0F) {
                           --level_physicalGifted;
                           if ((!serverPlayer.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()) || (double)serverPlayer.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_() < level_physicalGifted) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:physical_gifted_effect infinite " + Math.round(level_physicalGifted) + " true");
                           }
                        }
                     }
                  }

                  if (serverPlayer.f_19797_ % 10 == 0 && PlayerCT1 == (double)10.0F && entity.m_20071_()) {
                     old_cool = serverPlayer.getPersistentData().m_128459_("COOLDOWN_TICKS");
                     serverPlayer.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
                     serverPlayer.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
                  }

                  if (serverPlayer.f_19797_ % 100 == 10) {
                     if (playerVars.FlagSixEyes && !serverPlayer.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get()) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:six_eyes infinite 0 true");
                     }

                     if (serverPlayer.getPersistentData().m_128471_("CursedSpirit") && !serverPlayer.m_21023_(MobEffects.f_19611_) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:night_vision infinite 0 true");
                     }

                     if (playerVars.flag_sukuna && !serverPlayer.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        level_sukuna = GetSukunaLevelProcedure.execute(entity);
                        if (level_sukuna > (double)0.0F) {
                           level_sukuna = (double)Math.round(Math.min(Math.max(level_sukuna, (double)1.0F), (double)20.0F));
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:sukuna_effect infinite " + Math.round(level_sukuna) + " true");
                           }
                        }
                     }
                  }

                  if ((PlayerCT2 == (double)38.0F || PlayerCT1 == (double)38.0F) && LogicStartPassiveProcedure.execute(entity)) {
                     serverPlayer.f_19789_ = 0.0F;
                     if ((entity.m_20096_() || entity.m_20069_()) && (serverPlayer.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()) ? serverPlayer.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).m_19564_() : 0) < 5) {
                        serverPlayer.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), Math.min((serverPlayer.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()) ? serverPlayer.m_21124_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()).m_19557_() : 0) + 10, 60), 0, true, true));
                     }
                  }
               }
            }
         }

      }
   }
}
