package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraftforge.registries.ForgeRegistries;

public class JackpotOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            double var10000;
            label73: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).m_19564_();
                     break label73;
                  }
               }

               var10000 = (double)0.0F;
            }

            label68: {
               level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).m_19557_();
                     break label68;
                  }
               }

               var10000 = (double)0.0F;
            }

            entity.getPersistentData().m_128379_("PRESS_M", false);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2, (int)((double)5.0F + level), false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 2, 2, false, false));
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F, entity.m_20189_(), 2, (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, 0.1);
            }

            if (Math.random() < 0.2 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123758_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F, entity.m_20189_(), 1, (double)(entity.m_20205_() * 2.0F), (double)(entity.m_20206_() * 1.0F), (double)(entity.m_20205_() * 2.0F), (double)0.5F);
            }

            if (entity.m_20142_() && entity.m_20096_() && !entity.m_6144_()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt25 = (LivingEntity)entity;
                  if (_livEnt25.m_21023_(MobEffects.f_19597_)) {
                     return;
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 1, (double)entity.m_20205_() * 0.1, (double)(entity.m_20206_() * 0.0F), (double)entity.m_20205_() * 0.1, (double)0.5F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 1, (double)entity.m_20205_() * 0.1, (double)(entity.m_20206_() * 0.0F), (double)entity.m_20205_() * 0.1, (double)0.25F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }
         }

      }
   }
}
