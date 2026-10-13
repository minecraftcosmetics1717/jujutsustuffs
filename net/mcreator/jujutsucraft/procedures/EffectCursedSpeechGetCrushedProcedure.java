package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
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

public class EffectCursedSpeechGetCrushedProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double range = (double)0.0F;
         EffectCursedSpeech1Procedure.execute(entity, entityiterator);
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         range = ReturnEntitySizeProcedure.execute(entityiterator);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         for(int index0 = 0; index0 < (int)((double)36.0F * range); ++index0) {
            ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), (double)2.0F * range, (double)0.0F, (double)2.0F, x_pos, x_pos, y_pos, y_pos, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), z_pos, z_pos, "minecraft:enchanted_hit");
         }

         for(int index1 = 0; index1 < 3; ++index1) {
            Effect1Procedure.execute(world, entity, entityiterator);
            if (!entityiterator.m_6084_()) {
               break;
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 10, false, false));
            }
         }

         if (!entityiterator.m_6084_()) {
            if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
               entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "scale delay set pehkui:height 1 @s");
            }

            if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
               entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "scale set pehkui:height 0.01 @s");
            }
         }

      }
   }
}
