package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PhysicalGiftedEffectOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_power = (double)0.0F;
         double z_power = (double)0.0F;
         double speed = (double)0.0F;
         double width = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.m_6084_()) {
               MobEffectInstance giftedEffect = livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get());
               int giftedAmp = giftedEffect != null ? giftedEffect.m_19564_() : 0;
               if (livingEntity.f_19797_ % 10 == 0) {
                  if (!livingEntity.m_21023_(MobEffects.f_19598_) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:haste infinite 0 true");
                  }

                  if (giftedAmp >= 3) {
                     if (livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                        livingEntity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
                     }

                     if (livingEntity.m_21023_(MobEffects.f_19604_)) {
                        livingEntity.m_21195_(MobEffects.f_19604_);
                     }

                     if (livingEntity.m_21023_(MobEffects.f_19614_)) {
                        livingEntity.m_21195_(MobEffects.f_19614_);
                     }

                     if (livingEntity.m_21023_(MobEffects.f_19615_)) {
                        livingEntity.m_21195_(MobEffects.f_19615_);
                     }

                     if (!livingEntity.m_21023_(MobEffects.f_19611_) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:night_vision infinite 0 true");
                     }

                     if (entity.m_20096_()) {
                        MobEffectInstance doubleJump = livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
                        int currentAmp = doubleJump != null ? doubleJump.m_19564_() : -1;
                        if (currentAmp < 4) {
                           livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, currentAmp + 1, false, false));
                        } else if (doubleJump.m_19557_() < 20) {
                           livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, 4, false, false));
                        }
                     }
                  }
               }

               if (entity.m_20142_() && world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() - 0.1, entity.m_20189_())).m_60734_() == Blocks.f_49990_ && world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_())).m_60734_() != Blocks.f_49990_) {
                  x_power = entity.m_20184_().m_7096_();
                  z_power = entity.m_20184_().m_7094_();
                  speed = (double)1.0F;
                  width = (double)entity.m_20205_() * (double)0.25F;
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, (float)(width * (double)8.0F), 2.0F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, (float)(width * (double)8.0F), 2.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.round(width * (double)35.0F), width, (double)0.0F, width, speed);
                  }

                  entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)2.0F, Math.max(entity.m_20184_().m_7098_(), 0.025), entity.m_20154_().f_82481_ * (double)2.0F));
               }

               return;
            }
         }

      }
   }
}
