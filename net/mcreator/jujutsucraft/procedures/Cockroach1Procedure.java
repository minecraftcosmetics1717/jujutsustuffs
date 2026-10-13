package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade04Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade12Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class Cockroach1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double HP = (double)0.0F;
         double num2 = (double)0.0F;
         double num3 = (double)0.0F;
         double num1 = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double xp2 = (double)0.0F;
         double yp2 = (double)0.0F;
         double zp2 = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_velocity = (double)0.0F;
         boolean logic_a = false;
         boolean pitch = false;
         boolean cockroach = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         entity.f_19789_ = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            int var10001;
            label167: {
               yaw = (double)entity.m_146908_();
               dis = (double)0.0F;
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)-6.0F;
               z_pos = entity.m_20189_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label167;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(50 + var10001 * 10);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TORNADO.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.m_146922_((float)yaw);
                  entityinstance.m_146926_((float)dis);
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity18 = (LivingEntity)entityinstance;
                     if (_livingEntity18.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity18.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity22 = (LivingEntity)entityinstance;
                     if (_livingEntity22.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity22.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)6.0F);
                     }
                  }

                  _serverLevel.m_7967_(entityinstance);
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
            entity.getPersistentData().m_128379_("PRESS_Z", true);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)12.0F) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (!(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt2") >= (double)80.0F) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)40.0F));
            if (entity.getPersistentData().m_128459_("cnt2") >= (double)40.0F && entity instanceof Player) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }
         }

         y_velocity = Math.min(Math.max(y_velocity, (double)-0.5F), (double)0.5F);
         if (GetHeightFromGroundProcedure.execute(world, entity) < (double)6.0F) {
            y_velocity = entity.m_20184_().m_7098_() + 0.1;
         } else if (GetHeightFromGroundProcedure.execute(world, entity) > (double)8.0F) {
            y_velocity = entity.m_20184_().m_7098_() - 0.1;
         } else {
            y_velocity = (double)0.0F;
         }

         if (!(entity instanceof Player) && !(entity instanceof CursedSpiritGrade12Entity)) {
            entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * 0.3, y_velocity, entity.m_20154_().f_82481_ * 0.3));
         } else {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), y_velocity, entity.m_20184_().m_7094_()));
         }

         num1 = Math.toRadians(entity.getPersistentData().m_128459_("cnt3"));
         num2 = (double)entity.m_20205_() + Math.min(0.1 * entity.getPersistentData().m_128459_("cnt1"), (double)4.0F);
         y_pos = y;
         cockroach = entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)23.0F || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)23.0F : entity instanceof CursedSpiritGrade04Entity;
         entity.getPersistentData().m_128347_("y_knockback", 0.2);

         for(int index0 = 0; index0 < 4; ++index0) {
            for(int index1 = 0; index1 < 15; ++index1) {
               x_pos = x + Math.sin(num1) * num2;
               z_pos = z + Math.cos(num1) * num2;
               if (Math.random() < (double)0.5F) {
                  if (cockroach) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get(), x_pos, y_pos, z_pos, 1, (double)1.0F, (double)1.0F, (double)1.0F, 0.1);
                     }
                  } else {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, 1, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 1, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                     }
                  }
               }

               num1 += Math.toRadians(Math.random() * (double)10.0F);
            }

            entity.getPersistentData().m_128347_("BlockRange", (double)1.5F + num2);
            entity.getPersistentData().m_128347_("BlockDamage", 0.2);
            entity.getPersistentData().m_128379_("noEffect", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            num1 += Math.toRadians((double)90.0F);
            num2 = Math.max(num2 - (double)(entity.m_20205_() * 2.0F), (double)1.0F);
            --y_pos;
         }

         entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt3", Math.toDegrees(num1));
         if (cockroach) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.2F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)80.0F || entity.getPersistentData().m_128459_("cnt1") > (double)40.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
