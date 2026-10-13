package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityCockroachEggsEntity;
import net.mcreator.jujutsucraft.entity.EntityDomainIshigoriEntity;
import net.mcreator.jujutsucraft.entity.EntityDomainUroEntity;
import net.mcreator.jujutsucraft.entity.EntityGuillotineEntity;
import net.mcreator.jujutsucraft.entity.EntityHeartEntity;
import net.mcreator.jujutsucraft.entity.EntityJupiterEntity;
import net.mcreator.jujutsucraft.entity.EntityUnlimitedVoidEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIGravestoneProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double dis = (double)0.0F;
         double x_center = (double)0.0F;
         double y_center = (double)0.0F;
         double z_center = (double)0.0F;
         double distance = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         boolean flag = false;
         boolean logic_a = false;
         if (entity instanceof EntityUnlimitedVoidEntity) {
            entity.getPersistentData().m_128347_("cnt_beat", entity.getPersistentData().m_128459_("cnt_beat") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_beat") > (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt_beat", (double)-5.0F);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID_HOLE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123760_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 10, (double)2.0F, (double)2.0F, (double)2.0F, (double)0.0F);
               }
            }
         } else if (entity instanceof EntityDomainUroEntity) {
            dis = Math.max(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - (double)2.0F, (double)0.0F);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            y_pos = entity.m_20186_();
            y_center = y_pos;
            x_pos = entity.m_20185_() + Math.cos(yaw) * dis;
            z_pos = entity.m_20189_() + Math.sin(yaw) * dis;
            x_power = Math.cos(yaw) * (double)-4.0F;
            z_power = Math.sin(yaw) * (double)-4.0F;
            distance = Math.min(Math.max(dis / (double)4.0F * (double)2.0F, (double)1.0F), (double)entity.f_19797_ * (double)0.25F);

            for(int index0 = 0; index0 < (int)distance; ++index0) {
               for(int index1 = 0; index1 < 2; ++index1) {
                  logic_a = !logic_a;
                  x_center = x_pos + Math.cos(yaw + Math.toRadians(logic_a ? (double)90.0F : (double)-90.0F)) * (double)4.0F;
                  z_center = z_pos + Math.sin(yaw + Math.toRadians(logic_a ? (double)90.0F : (double)-90.0F)) * (double)4.0F;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_center, y_center, z_center, 1, (double)0.25F, (double)0.5F, (double)0.25F, 0.025);
                  }
               }

               x_pos += x_power;
               z_pos += z_power;
            }
         }

         if (entity instanceof EntityDomainIshigoriEntity && entity.f_19797_ > 40 && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         if (entity instanceof EntityJupiterEntity) {
            entity.m_146922_((float)((double)entity.m_146908_() + (double)0.5F));
            entity.m_146926_(entity.m_146909_());
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }
         } else if (entity instanceof EntityCockroachEggsEntity) {
            if (Math.random() < 0.025 && entity instanceof EntityCockroachEggsEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "shake");
            }
         } else if (entity instanceof EntityHeartEntity) {
            entity.getPersistentData().m_128347_("cnt_beat", entity.getPersistentData().m_128459_("cnt_beat") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_beat") > (double)22.0F) {
               entity.getPersistentData().m_128347_("cnt_beat", (double)0.0F);
               if (entity instanceof EntityHeartEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "heart_beat");
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            }
         } else if (entity instanceof EntityGuillotineEntity && entity.getPersistentData().m_128459_("y_offset") < (double)0.0F) {
            entity.m_6021_(x, y - Math.max((double)-0.5F, entity.getPersistentData().m_128459_("y_offset")), z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(x, y - Math.max((double)-0.5F, entity.getPersistentData().m_128459_("y_offset")), z, entity.m_146908_(), entity.m_146909_());
            }

            entity.getPersistentData().m_128347_("y_offset", entity.getPersistentData().m_128459_("y_offset") + (double)0.5F);
         }

         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
               label116: {
                  flag = true;
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt51 = (LivingEntity)entity_a;
                     if (_livEnt51.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label116;
                     }
                  }

                  if (entity_a.getPersistentData().m_128459_("select") == (double)0.0F) {
                     entity.getPersistentData().m_128379_("flag", true);
                  }
               }
            }
         }

         if (!flag) {
            entity.getPersistentData().m_128379_("flag", true);
         }

         if (entity.getPersistentData().m_128471_("flag") && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
