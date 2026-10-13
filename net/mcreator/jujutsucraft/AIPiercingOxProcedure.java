package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIPiercingOxProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double NUM3 = (double)0.0F;
         double rnd = (double)0.0F;
         double NUM1 = (double)0.0F;
         double distance = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double entity_size = (double)0.0F;
         if (entity.m_6084_()) {
            double var10001;
            label88: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               NUM1 = (double)(6L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.5F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity2.m_21051_(Attributes.f_22281_).m_22115_();
                     break label88;
                  }
               }

               var10001 = (double)0.0F;
            }

            label83: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * (double)3.0F) / (double)4.0F, (double)3.0F)));
               NUM3 = (double)-60.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label83;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label78: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label78;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)NUM2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)1.0F) {
               AttackPiecingOxProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var49;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.m_5448_();
               } else {
                  var49 = null;
               }

               if (var49 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", NUM3 + (double)Math.round(NUM3 / (double)2.0F * Math.random()));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("skill", (double)1.0F);
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               }

               entity.getPersistentData().m_128347_("cnt_breath", entity.getPersistentData().m_128459_("cnt_breath") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_breath") > (double)40.0F) {
                  if (entity.getPersistentData().m_128459_("cnt_breath") == (double)41.0F && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 0.5F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
                     }
                  }

                  if (Math.random() < (double)0.75F) {
                     entity_size = ReturnEntitySizeProcedure.execute(entity);
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());
                     distance = 0.8 * (double)entity.m_20205_();
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(pitch) * (double)-1.0F * distance;
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)1.0F * entity_size), (double)entity.m_20205_() * 0.1, (double)entity.m_20206_() * 0.1, (double)entity.m_20205_() * 0.1, 0.05);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt_breath") > (double)60.0F) {
                     entity.getPersistentData().m_128347_("cnt_breath", (double)0.0F);
                  }
               }
            }
         }

      }
   }
}
