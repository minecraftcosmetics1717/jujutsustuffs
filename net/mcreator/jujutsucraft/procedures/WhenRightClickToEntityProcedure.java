package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.entity.EntityProjectionSorceryEntity;
import net.mcreator.jujutsucraft.entity.FrameEntity;
import net.mcreator.jujutsucraft.entity.FushiguroMegumiEntity;
import net.mcreator.jujutsucraft.entity.FushiguroMegumiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenRightClickToEntityProcedure {
   @SubscribeEvent
   public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
      if (event.getHand() == event.getEntity().m_7655_()) {
         execute(event, event.getLevel(), event.getTarget(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      execute((Event)null, world, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         boolean right_clicked = false;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (sourceentity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
            T1 = pVars.PlayerCurseTechnique;
            T2 = pVars.PlayerCurseTechnique2;
         }

         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt1 = (LivingEntity)sourceentity;
            if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) && ReturnInsideItemProcedure.execute(sourceentity).m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
               right_clicked = false;
               if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity)) {
                  if (entity instanceof FushiguroMegumiEntity || entity instanceof FushiguroMegumiShibuyaEntity) {
                     right_clicked = true;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.SUKUNA_FUSHIGURO.get()).m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.m_146922_(entity.m_146908_());
                           entityToSpawn.m_5618_(entity.m_146908_());
                           entityToSpawn.m_5616_(entity.m_146908_());
                           entityToSpawn.m_146926_(entity.m_146909_());
                        }
                     }
                  }
               } else {
                  right_clicked = true;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.SUKUNA.get()).m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.m_146922_(entity.m_146908_());
                        entityToSpawn.m_5618_(entity.m_146908_());
                        entityToSpawn.m_5616_(entity.m_146908_());
                        entityToSpawn.m_146926_(entity.m_146909_());
                     }
                  }
               }

               if (right_clicked) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
                  }

                  ItemStack _setval = ItemStack.f_41583_;
                  sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.BodyItem = _setval.m_41777_();
                     capability.syncPlayerVariables(sourceentity);
                  });
                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

                  return;
               }
            }
         }

         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt23 = (LivingEntity)sourceentity;
            if (_livEnt23.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt24 = (LivingEntity)sourceentity;
                  if (_livEnt24.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     return;
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt25 = (LivingEntity)sourceentity;
                  if (_livEnt25.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                     return;
                  }
               }
            }
         }

         if (!(entity instanceof DomainExpansionEntityEntity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt27 = (LivingEntity)entity;
               if (_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  return;
               }
            }

            if ((T1 == (double)19.0F || T2 == (double)19.0F) && !(entity instanceof FrameEntity) && !(entity instanceof EntityProjectionSorceryEntity) && entity.getPersistentData().m_128459_("select") == (double)0.0F) {
               label109: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt31 = (LivingEntity)entity;
                     if (_livEnt31.m_21023_((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get())) {
                        break label109;
                     }
                  }

                  if (pVars.PlayerCursePower + pVars.PlayerCursePowerChange >= (double)40.0F) {
                     pVars.PlayerCursePowerChange -= (double)40.0F;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 50, 0, false, false));
                        }
                     }

                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)sourceentity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }
                  }
               }
            }

            if ((T1 == (double)24.0F || T2 == (double)24.0F) && entity.m_146889_() * 100.0F < 5.0F && pVars.PlayerCursePower + pVars.PlayerCursePowerChange >= (double)40.0F) {
               pVars.PlayerCursePowerChange -= (double)40.0F;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 5, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 80, 1, false, false));
                  }
               }

               entity.m_146917_(100);
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            }

         }
      }
   }
}
