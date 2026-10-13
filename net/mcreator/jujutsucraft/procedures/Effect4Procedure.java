package net.mcreator.jujutsucraft.procedures;

import java.util.ArrayList;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class Effect4Procedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         double size_width = (double)0.0F;
         double size_height = (double)0.0F;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         speed = (double)1.0F + entityiterator.getPersistentData().m_128459_("cnt6") * 0.2;
         size_width = (double)entityiterator.m_20205_() * 0.3;
         size_height = (double)entityiterator.m_20206_() * 0.3;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 10, 1, false, false));
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.5F));
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.5F), false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1), false);
            }
         }

         if (entity.getPersistentData().m_128459_("skill") == (double)106.0F) {
            for(Entity _player : new ArrayList(world.m_6907_())) {
               if (CanSeeSukunaSlashProcedure.execute(world, entity, _player) && !_player.m_9236_().m_5776_() && _player.m_20194_() != null) {
                  _player.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, _player.m_20182_(), _player.m_20155_(), _player.m_9236_() instanceof ServerLevel ? (ServerLevel)_player.m_9236_() : null, 4, _player.m_7755_().getString(), _player.m_5446_(), _player.m_9236_().m_7654_(), _player), "particle jujutsucraft:particle_slash " + x_pos + " " + y_pos + " " + z_pos + " " + size_width + " " + size_height + " " + size_width + " 0 " + Math.round((double)4.0F * speed) + " normal");
               }
            }
         } else if (entity.getPersistentData().m_128459_("skill") == (double)2108.0F && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_DISMANTLE_ITADORI.get(), x_pos, y_pos, z_pos, (int)((double)2.0F * speed), size_width, size_height, size_width, (double)0.0F * speed);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)((double)2.0F * speed), size_width, size_height, size_width, (double)0.5F);
         }

         Effect1Procedure.execute(world, entity, entityiterator);
      }
   }
}
