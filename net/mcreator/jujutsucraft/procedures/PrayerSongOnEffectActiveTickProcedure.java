package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PrayerSongOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double tick = (double)0.0F;
         double level = (double)0.0F;
         if (entity.m_6084_()) {
            label111: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                     double var30 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get()).m_19564_();
                     break label111;
                  }
               }

               double var10000 = (double)0.0F;
            }

            double var31;
            label106: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                     var31 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get()).m_19557_();
                     break label106;
                  }
               }

               var31 = (double)0.0F;
            }

            label101: {
               tick = var31;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                     break label101;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 5, 0, false, false));
                  }
               }
            }

            if (entity.m_20096_()) {
               label122: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label122;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt7 = (LivingEntity)entity;
                     if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label122;
                     }
                  }

                  if (tick % (double)3.0F == (double)0.0F && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
                     }
                  }

                  if (tick % (double)5.0F == (double)0.0F) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity9 = (LivingEntity)entity;
                        if (_livingEntity9.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity9.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-15.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            }

            if (tick % (double)5.0F == (double)0.0F) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)12.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 20, 0));
                     }
                  }
               }
            }

            label120: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt13 = (LivingEntity)entity;
                  if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label120;
                  }
               }

               if (!(entity instanceof LivingEntity)) {
                  return;
               }

               LivingEntity _livEnt14 = (LivingEntity)entity;
               if (!_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get());
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get());
         }

      }
   }
}
