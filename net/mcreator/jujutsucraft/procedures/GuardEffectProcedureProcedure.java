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
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GuardEffectProcedureProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         boolean logic_a = false;
         boolean logic_iron_attack = false;
         boolean logic_iron_guard = false;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entityiterator;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
               PlayAnimationEntityGuardProcedure.execute(world, entity, entityiterator);
            }
         }

         boolean var10000;
         label181: {
            label180: {
               num1 = entity.getPersistentData().m_128459_("skill");
               num2 = entityiterator.getPersistentData().m_128459_("skill");
               if (LogicSwordProcedure.execute(entity)) {
                  if (num1 != (double)0.0F && entity.getPersistentData().m_128471_("attack")) {
                     break label180;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label180;
                     }
                  }

                  if (num1 == (double)0.0F) {
                     break label180;
                  }
               }

               var10000 = 0;
               break label181;
            }

            var10000 = 1;
         }

         label168: {
            label167: {
               logic_iron_attack = (boolean)var10000;
               if (LogicSwordProcedure.execute(entityiterator)) {
                  if (num2 != (double)0.0F && entityiterator.getPersistentData().m_128471_("attack")) {
                     break label167;
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                     if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label167;
                     }
                  }
               }

               var10000 = (boolean)0;
               break label168;
            }

            var10000 = (boolean)1;
         }

         logic_iron_guard = var10000;
         if (!logic_iron_attack) {
            if (num1 == (double)105.0F || num1 == (double)106.0F) {
               logic_iron_attack = true;
            }

            if (num1 >= (double)806.0F && num1 <= (double)809.0F) {
               logic_iron_attack = true;
            }

            if (num1 >= (double)1405.0F && num1 <= (double)1410.0F) {
               logic_iron_attack = true;
            }

            if (num1 == (double)2405.0F || num1 == (double)2409.0F) {
               logic_iron_attack = true;
            }

            if (num1 >= (double)3205.0F && num1 < (double)3220.0F) {
               logic_iron_attack = true;
            }

            if (num1 == (double)3908.0F || num1 == (double)3909.0F) {
               logic_iron_attack = true;
            }
         }

         if (logic_iron_guard && num1 != (double)0.0F && !entity.getPersistentData().m_128471_("attack")) {
            label133: {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entityiterator;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                     break label133;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 10) {
               logic_iron_guard = false;
            }
         }

         if (!logic_iron_guard) {
            if (LogicIronBodyProcedure.execute(entityiterator)) {
               logic_iron_guard = true;
            }

            if (num2 == (double)105.0F || num2 == (double)106.0F) {
               logic_iron_guard = true;
            }
         }

         if (logic_iron_attack && logic_iron_guard) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), x, y, z, 1, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.25F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_sword")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
               } else {
                  _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_sword")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1), false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.strong")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
               } else {
                  _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.strong")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1), false);
               }
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x, y, z, 1, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.25F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.strong")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
               } else {
                  _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.strong")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1), false);
               }
            }
         }

         if (logic_iron_guard && GetDistanceIteratorProcedure.execute(entity, entityiterator) < (double)5.0F) {
            logic_a = entityiterator.getPersistentData().m_128471_("attack");
            entityiterator.getPersistentData().m_128379_("attack", true);
            CursedToolsAbilityProcedure.execute(entityiterator, entity);
            entityiterator.getPersistentData().m_128379_("attack", logic_a);
         }

         label115: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                  break label115;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0) {
            JustGuardProcedure.execute(entityiterator);
         }

      }
   }
}
