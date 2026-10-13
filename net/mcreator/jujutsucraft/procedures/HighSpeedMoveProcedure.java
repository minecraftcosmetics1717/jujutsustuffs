package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade16Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HighSpeedMoveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_b = false;
         boolean logic_a = false;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt2") < (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 3, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F && entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt1", (double)(entity.getPersistentData().m_128471_("PRESS_S") ? -1 : 1));
            }
         } else {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               if (entity instanceof CursedSpiritGrade16Entity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 3, 0, false, false));
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)20.0F * range), (double)0.5F * range, (double)0.5F * range, (double)0.5F * range, (double)0.0F);
                  }
               } else {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)5.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)1.0F);
                  }
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               speed = (double)0.5F * entity.getPersistentData().m_128459_("cnt1");
               x_power = entity.m_20154_().f_82479_ * speed;
               y_power = entity.m_20154_().f_82480_ * speed;
               z_power = entity.m_20154_().f_82481_ * speed;

               for(int index0 = 0; index0 < 48; ++index0) {
                  logic_a = true;
                  logic_b = false;
                  if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                     entity.getPersistentData().m_128347_("Range", (double)3.0F * range);
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_b = true;
                           break;
                        }
                     }
                  }

                  if (logic_b) {
                     break;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     x_pos += x_power;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     z_pos += z_power;
                  }

                  if (logic_a) {
                     for(int index1 = 0; index1 < 4; ++index1) {
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + (double)1.0F, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           ++y_pos;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos + y_power, z_pos + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           break;
                        }
                     }
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     y_pos += y_power;
                  }

                  if (logic_a) {
                     break;
                  }
               }

               entity.m_6021_(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
               }

               if (entity instanceof CursedSpiritGrade16Entity) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)20.0F * range), (double)0.5F * range, (double)0.5F * range, (double)0.5F * range, 0.1);
                  }
               } else {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)5.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)1.0F);
                  }
               }

               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  _entity.m_21573_().m_26573_();
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") > (double)3.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
