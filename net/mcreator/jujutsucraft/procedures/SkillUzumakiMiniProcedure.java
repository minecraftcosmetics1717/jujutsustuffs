package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillUzumakiMiniProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         String STR2 = "";
         boolean adult = false;
         boolean reChange = false;
         boolean player = false;
         double rnd = (double)0.0F;
         double lv_st = (double)0.0F;
         double lv_df = (double)0.0F;
         double count_spirit = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double num1 = (double)0.0F;
         double x_dis = (double)0.0F;
         double y_dis = (double)0.0F;
         double z_dis = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         player = entity instanceof Player;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
               }
            }

            num1 = entity.getPersistentData().m_128459_("cnt1") / (double)19.5F;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, (int)((double)1.0F * num1), 0.1 * num1, 0.1 * num1, 0.1 * num1, 0.1 * num1);
            }

            y_pos = (double)-200.0F - Math.random();
            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.f_20555_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), y_pos, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            reChange = false;
            Vec3 _center = new Vec3(entity.m_20185_(), y_pos, entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.05), (e) -> true)) {
               if (entityiterator instanceof Chicken && y_pos == entityiterator.m_20186_()) {
                  if (!entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }

                  reChange = true;
                  break;
               }
            }

            if (reChange) {
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 0.5F, 0.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 0.5F, 0.25F, false);
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") == (double)0.0F) {
                  if (GetDistanceProcedure.execute(entity) >= (double)10.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") > (double)0.0F) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().m_128471_("PRESS_Z")) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") >= (double)200.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var100 = ((Entity)var10000).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var100 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var101;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var101 = _mobEnt.m_5448_();
               } else {
                  var101 = null;
               }

               z_pos = ((Entity)var101).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)19.0F));
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("x_pos"));
               entity.getPersistentData().m_128347_("cnt7", entity.getPersistentData().m_128459_("y_pos"));
               entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("z_pos"));
            }

            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            x_dis = entity.getPersistentData().m_128459_("x_power") * 0.02;
            y_dis = entity.getPersistentData().m_128459_("y_power") * 0.02;
            z_dis = entity.getPersistentData().m_128459_("z_power") * 0.02;
            distance = (double)0.0F;
            range = (double)5.0F + Math.min(rnd / (double)10.0F, (double)10.0F);
            rnd = (double)1.0F;

            for(int index0 = 0; index0 < 45; ++index0) {
               ++distance;
               if (distance > (double)0.0F) {
                  distance = (double)-5.0F;
                  entity.getPersistentData().m_128347_("Damage", (double)24.0F);
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.pow(0.98, Math.max(entity.getPersistentData().m_128459_("cnt3") - (double)2.0F, (double)0.0F)));
                  entity.getPersistentData().m_128347_("Range", (double)3.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, 2, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.min(Math.sqrt(rnd) * (double)0.5F, (double)10.0F));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.min(Math.sqrt(rnd) * (double)0.5F, (double)10.0F));
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)24.0F);
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.pow(0.98, Math.max(entity.getPersistentData().m_128459_("cnt3") - (double)2.0F, (double)0.0F)));
                  entity.getPersistentData().m_128347_("Range", (double)3.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)3.0F);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)2.0F);
                  break;
               }

               x_pos += x_dis;
               y_pos += y_dis;
               z_pos += z_dis;
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            ParticleGeneratorProcedure.execute(world, Math.sqrt(rnd) * 0.1, (double)2.0F * range, (double)5.0F, (double)4.0F, entity.getPersistentData().m_128459_("cnt5"), entity.getPersistentData().m_128459_("cnt5") + entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("cnt7"), entity.getPersistentData().m_128459_("cnt7") + entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("cnt8"), entity.getPersistentData().m_128459_("cnt8") + entity.getPersistentData().m_128459_("z_power"), "minecraft:soul");
            if (entity.getPersistentData().m_128459_("cnt2") > (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
