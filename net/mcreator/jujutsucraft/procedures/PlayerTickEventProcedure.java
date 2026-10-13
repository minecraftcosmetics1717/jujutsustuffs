package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerTickEventProcedure {
   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double currentCursePowerChange = (double)0.0F;
         double healCursePower = (double)0.0F;
         if (entity.m_6084_()) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer serverPlayer = (ServerPlayer)entity;
               if (serverPlayer.f_19797_ % 10 == 0) {
                  JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                  currentCursePowerChange = playerVars.PlayerCursePowerChange;
                  healCursePower = (double)0.0F;
                  if (playerVars.PlayerCurseTechnique != (double)0.0F) {
                     if (serverPlayer.m_7500_()) {
                        if (playerVars.PlayerCursePower < playerVars.PlayerCursePowerMAX || currentCursePowerChange != (double)0.0F) {
                           playerVars.PlayerCursePower = playerVars.PlayerCursePowerMAX;
                           playerVars.PlayerCursePowerChange = (double)0.0F;
                           playerVars.syncPlayerVariables(entity);
                        }
                     } else {
                        if (currentCursePowerChange < (double)0.0F) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt1 = (LivingEntity)entity;
                              if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 currentCursePowerChange *= (double)0.5F;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt2 = (LivingEntity)entity;
                              if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                                 int var10002;
                                 label84: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                                          var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get()).m_19564_();
                                          break label84;
                                       }
                                    }

                                    var10002 = 0;
                                 }

                                 currentCursePowerChange *= 0.1 / (double)(Math.max(var10002, 0) + 1);
                              }
                           }
                        }

                        healCursePower = (double)1.0F + ((double)2.0F + playerVars.PlayerLevel) / 1.1 * 0.2;
                        float var10000;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21223_();
                        } else {
                           var10000 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var10000 >= var10001) {
                           healCursePower *= (double)2.0F;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt6 = (LivingEntity)entity;
                           if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                              healCursePower *= 1.2;
                           }
                        }

                        currentCursePowerChange += (double)Math.round(healCursePower);
                        if (currentCursePowerChange != (double)0.0F) {
                           playerVars.PlayerCursePower = (double)Math.round(Math.max(Math.min(playerVars.PlayerCursePower + currentCursePowerChange, playerVars.PlayerCursePowerMAX), (double)0.0F));
                           playerVars.PlayerCursePowerChange = (double)0.0F;
                           playerVars.syncPlayerVariables(entity);
                           if (playerVars.PlayerCursePower <= (double)0.0F && entity.getPersistentData().m_128471_("CursedSpirit")) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                              }

                              entity.m_6074_();
                           }
                        }
                     }
                  }

                  if (serverPlayer.m_8960_().m_135996_(serverPlayer.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:advancement_insect"))).m_8193_() && serverPlayer.m_36324_().m_38702_() < 20) {
                     serverPlayer.m_36324_().m_38705_(20);
                  }
               }
            }

            WhenPlayerActiveTickInfinityProcedure.execute(entity);
         }

         PlayerTickSecondTechniqueProcedure.execute(world, x, y, z, entity);
      }
   }
}
