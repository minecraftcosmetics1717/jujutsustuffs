package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraftforge.registries.ForgeRegistries;

public class RatExplodeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         double num3 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 10, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F && entity.getPersistentData().m_128459_("cnt1") < (double)10.0F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity8 = (LivingEntity)entity;
            if (_livingEntity8.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity8.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)2015.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F && entity.getPersistentData().m_128459_("cnt1") < (double)25.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") < (double)20.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            range = ReturnEntitySizeProcedure.execute(entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)15.0F * range), (double)1.5F * range, (double)1.5F * range, (double)1.5F * range, (double)1.0F);
            }

            for(int index0 = 0; index0 < (int)((double)32.0F * range); ++index0) {
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F * range, (double)2.0F * range, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)4.0F) * range, x_pos, x_pos, entity.m_20186_(), entity.m_20186_(), (double)0.0F, z_pos, z_pos, Math.random() < (double)0.5F ? "jujutsucraft:particle_flame_purple" : "sneeze");
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)-45.0F, (double)45.0F), (double)0.0F * range, (double)2.0F * range, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)3.0F) * range, x_pos, x_pos, y_pos, y_pos, Mth.m_216263_(RandomSource.m_216327_(), (double)-360.0F, (double)360.0F), z_pos, z_pos, Math.random() < (double)0.5F ? "jujutsucraft:particle_flame_purple" : "sneeze");
            }

            entity.getPersistentData().m_128347_("Damage", (double)13.0F);
            entity.getPersistentData().m_128347_("Range", Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)6.0F, (double)48.0F));
            entity.getPersistentData().m_128347_("knockback", (double)0.5F);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("Damage", (double)14.0F);
            entity.getPersistentData().m_128347_("Range", Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)6.0F, (double)32.0F));
            entity.getPersistentData().m_128347_("knockback", (double)1.0F);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("BlockRange", Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)6.0F, (double)32.0F));
            entity.getPersistentData().m_128347_("BlockDamage", 0.2);
            BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)35.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
