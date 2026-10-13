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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectCursedSpeechCrumbleAwayProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos;
         double y_pos;
         double z_pos;
         int var10000;
         label92: {
            x_pos = (double)0.0F;
            y_pos = (double)0.0F;
            z_pos = (double)0.0F;
            double theta = (double)0.0F;
            double distance = (double)0.0F;
            double range = (double)0.0F;
            double strength = (double)0.0F;
            EffectCursedSpeech1Procedure.execute(entity, entityiterator);
            x_pos = entityiterator.m_20185_();
            y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
            z_pos = entityiterator.m_20189_();
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label92;
               }
            }

            var10000 = 0;
         }

         double var23 = (double)Math.min(var10000 + 1, 30) * 0.1;
         double var22 = (double)Math.round((double)(entityiterator.m_20206_() + 1.0F) * Math.min(var23, (double)1.0F));
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 10, false, false));
            }
         }

         int var10002;
         label86: {
            entityiterator.m_20256_(new Vec3((double)0.0F, (double)-2.0F, (double)0.0F));
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label86;
               }
            }

            var10002 = 0;
         }

         entityiterator.f_19789_ = (float)(10 + var10002 * 2);

         for(int index0 = 0; index0 < (int)var22; ++index0) {
            y_pos -= ((double)0.5F + (double)(entityiterator.m_20205_() * 1.0F)) * var23;
            entity.getPersistentData().m_128347_("BlockRange", Math.min((double)(1.0F + entityiterator.m_20205_() * 2.0F) * var23, (double)(4.0F + entityiterator.m_20205_())));
            entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F);

            for(int index1 = 0; index1 < 4; ++index1) {
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)var23, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)var23, 0.5F, false);
               }
            }

            if (y_pos < entityiterator.m_20186_() - var22) {
               break;
            }
         }

         for(int index2 = 0; index2 < (int)((double)36.0F * var22); ++index2) {
            ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, var22), (double)4.0F, x_pos, x_pos, (double)(1.0F + entityiterator.m_20205_() * 2.0F), y_pos - (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), z_pos, z_pos, "minecraft:enchanted_hit");
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
