package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class FrameOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double y_pos = (double)0.0F;
         double entity_size = (double)0.0F;
         Entity entity_target = null;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("NameRanged_ranged_keep") == (double)0.0F && entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
               entity_target = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("FREEZE_UUID"));
               if (entity_target instanceof LivingEntity && !entity_target.m_20147_()) {
                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 20, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19599_, 10, 20, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 1, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 1, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SCALE_CHANGE.get(), 3, 0, false, false));
                     }
                  }

                  if (entity_target.getPersistentData().m_128459_("select") == (double)0.0F && entity_target.getPersistentData().m_128459_("skill") > (double)-1000.0F) {
                     label132: {
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _livEnt18 = (LivingEntity)entity_target;
                           if (_livEnt18.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                              break label132;
                           }
                        }

                        entity_target.getPersistentData().m_128347_("skill", (double)-1000.0F);
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1, 0, false, false));
                           }
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }

                     entity_target.getPersistentData().m_128347_("skill", (double)-1000.0F);
                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 20, 0, false, false));
                        }
                     }
                  }

                  entity_target.m_6021_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F, entity.m_20189_());
                  if (entity_target instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F, entity.m_20189_(), entity_target.m_146908_(), entity_target.m_146909_());
                  }

                  entity_target.m_146922_(entity.m_146908_());
                  entity_target.m_146926_(entity.m_146909_());
                  entity_target.m_5618_(entity_target.m_146908_());
                  entity_target.m_5616_(entity_target.m_146908_());
                  entity_target.f_19859_ = entity_target.m_146908_();
                  entity_target.f_19860_ = entity_target.m_146909_();
                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity_target.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F) {
               if (entity.getPersistentData().m_128459_("NameRanged_ranged_keep") != (double)0.0F) {
                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_286979_)), 99999.0F);
               } else if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt_die", entity.getPersistentData().m_128459_("cnt_die") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_die") <= (double)1.0F) {
               world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)(entity.m_20206_() * 0.0F), z), Block.m_49956_(Blocks.f_50058_.m_49966_()));
               world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * (double)0.5F, z), Block.m_49956_(Blocks.f_50058_.m_49966_()));
               world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)(entity.m_20206_() * 1.0F), z), Block.m_49956_(Blocks.f_50058_.m_49966_()));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 0.5F, 1.25F);
                  } else {
                     _level.m_7785_(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x, y_pos, z, (int)((double)20.0F * entity_size), 0.2 * entity_size, 0.2 * entity_size, 0.2 * entity_size, (double)0.25F);
               }

               if (entity.getPersistentData().m_128459_("NameRanged_ranged_keep") == (double)0.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }

            if (entity.getPersistentData().m_128459_("NameRanged_ranged_keep") != (double)0.0F) {
               if (entity.getPersistentData().m_128459_("cnt_die") <= (double)2.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y_pos, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2.0F, 1.25F);
                     } else {
                        _level.m_7785_(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
                     }
                  }
               }

               entity.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID_keep"));
               entity.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged_ranged_keep"));
               entity.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num_keep"));
               entity.getPersistentData().m_128347_("Damage", (double)15.0F);
               entity.getPersistentData().m_128347_("Range", (double)12.0F * entity_size);
               entity.getPersistentData().m_128347_("knockback", (double)1.5F);
               RangeAttackProcedure.execute(world, x, y_pos, z, entity);
               entity.getPersistentData().m_128347_("BlockRange", (double)8.0F * entity_size);
               entity.getPersistentData().m_128347_("BlockDamage", 0.33);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x, y_pos, z, entity);
               entity.getPersistentData().m_128347_("Range", (double)12.0F * entity_size);
               entity.getPersistentData().m_128347_("knockback", (double)1.5F);
               KnockbackProcedure.execute(world, x, y_pos, z, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y_pos, z, (int)((double)10.0F * entity_size), 0.2 * entity_size, 0.2 * entity_size, 0.2 * entity_size, (double)0.5F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x, y_pos, z, (int)((double)10.0F * entity_size), (double)1.5F * entity_size, (double)1.5F * entity_size, (double)1.5F * entity_size, (double)0.5F);
               }

               if (entity.getPersistentData().m_128459_("cnt_die") >= (double)5.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
