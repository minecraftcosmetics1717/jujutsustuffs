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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class JogoFlame2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         Entity target = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var16 = var10000;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 2.0F, 1.0F);
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (var16 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceProcedure.execute(entity) > (double)12.0F && (((Entity)var16).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var16).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var16).getPersistentData().m_128471_("attack") || ((Entity)var16).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)4.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)4.0F) {
               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               } else {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 5, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 5, (double)4.0F, (double)4.0F, (double)4.0F, (double)0.0F);
            }
         }

         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") <= (double)2.0F + entity.getPersistentData().m_128459_("cnt6") * (double)0.5F) {
               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, (int)((double)20.0F * CNT6), (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F * CNT6);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123755_, x_pos, y_pos, z_pos, (int)((double)20.0F * CNT6), (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F * CNT6);
               }
            }

            entity.getPersistentData().m_128347_("Damage", ((double)15.0F + entity.getPersistentData().m_128459_("cnt2") * 0.1) * CNT6);
            entity.getPersistentData().m_128347_("Range", Math.min((double)24.0F, entity.getPersistentData().m_128459_("cnt2") * (double)3.0F) * CNT6);
            entity.getPersistentData().m_128347_("knockback", 0.1 * CNT6);
            entity.getPersistentData().m_128347_("effect", (double)10.0F);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().m_128459_("cnt2") % (double)4.0F == (double)1.0F) {
               entity.getPersistentData().m_128347_("BlockRange", Math.min((double)12.0F, entity.getPersistentData().m_128459_("cnt2") * (double)1.5F) * CNT6);
               entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F * CNT6 * Math.max((double)1.0F - entity.getPersistentData().m_128459_("cnt2") / ((double)8.0F * CNT6), 0.05));
               entity.getPersistentData().m_128347_("effect", (double)3.0F);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt2") > (double)8.0F * CNT6) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
