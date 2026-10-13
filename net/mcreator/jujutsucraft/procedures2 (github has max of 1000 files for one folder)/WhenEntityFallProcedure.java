package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
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
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenEntityFallProcedure {
   @SubscribeEvent
   public static void onEntityFall(LivingFallEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getEntity(), (double)event.getDistance());
      }

   }

   public static void execute(LevelAccessor world, Entity entity, double distance) {
      execute((Event)null, world, entity, distance);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double distance) {
      if (entity != null) {
         boolean logic_fall = false;
         double distance_power = (double)0.0F;
         double curse_energy_color = (double)0.0F;
         double particle_amount = (double)0.0F;
         double particle_speed = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         distance_power = distance - (double)8.0F;
         if (entity instanceof Player) {
            logic_fall = entity.m_6144_() && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX >= (double)6000.0F;
         } else {
            logic_fall = entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt4 = (LivingEntity)entity;
            if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               logic_fall = logic_fall || !(entity instanceof Player) || entity.m_6144_();
            }
         }

         boolean var10000;
         label195: {
            if (!logic_fall) {
               label192: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt7 = (LivingEntity)entity;
                     if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                        break label192;
                     }
                  }

                  var10000 = false;
                  break label195;
               }
            }

            var10000 = true;
         }

         logic_fall = var10000;
         if (distance_power > (double)0.0F) {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_();
            distance_power = Math.sqrt(distance_power + (double)1.0F);
            curse_energy_color = ReturnEnergyColorProcedure.execute(entity);
            if (distance_power > (double)4.0F || curse_energy_color > (double)0.0F) {
               entity.getPersistentData().m_128347_("BlockRange", Math.min(distance_power, (double)4.0F) + (double)entity.m_20205_());
               entity.getPersistentData().m_128347_("BlockDamage", (curse_energy_color > (double)0.0F ? (double)1.0F : (double)0.25F) * distance_power);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 15, 6, false, false));
               }
            }

            label189: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label189;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity16.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-10.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (logic_fall) {
               particle_amount = Math.min(distance_power * distance_power + (double)20.0F, (double)100.0F);
               particle_speed = (double)0.5F + Math.min(distance_power * (double)0.25F, (double)1.5F);
               if (curse_energy_color == (double)1.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.m_20205_() * (double)0.25F, (double)0.0F, (double)entity.m_20205_() * (double)0.25F, particle_speed);
                  }
               } else if (curse_energy_color == (double)2.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.m_20205_() * (double)0.25F, (double)0.0F, (double)entity.m_20205_() * (double)0.25F, particle_speed);
                  }
               } else if (curse_energy_color == (double)3.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.m_20205_() * (double)0.25F, (double)0.0F, (double)entity.m_20205_() * (double)0.25F, particle_speed);
                  }
               } else if (curse_energy_color == (double)4.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.m_20205_() * (double)0.25F, (double)0.0F, (double)entity.m_20205_() * (double)0.25F, particle_speed);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(particle_amount * (double)1.0F), (double)entity.m_20205_() * (double)0.25F, (double)0.0F, (double)entity.m_20205_() * (double)0.25F, particle_speed * (double)2.0F);
               }

               if (curse_energy_color > (double)0.0F && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * (double)0.5F), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * (double)0.5F), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1), false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.6));
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.6), false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.6));
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.6), false);
                  }
               }
            }
         }

         if (logic_fall && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         int var10001;
         label138: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt38 = (LivingEntity)entity;
               if (_livEnt38.m_21023_(MobEffects.f_19600_)) {
                  label133: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label133;
                        }
                     }

                     var10001 = 0;
                  }

                  var10001 += 5;
                  break label138;
               }
            }

            var10001 = 0;
         }

         if (distance < (double)var10001 && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

      }
   }
}
