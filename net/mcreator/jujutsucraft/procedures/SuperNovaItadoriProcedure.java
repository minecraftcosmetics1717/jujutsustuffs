package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SuperNovaItadoriProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double speed = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 10, false, false));
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.75F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.75F, 0.75F, false);
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(1.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_);
         }

         dis = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            ParticleGeneratorProcedure.execute(world, dis * 0.1, (double)2.0F * dis, (double)30.0F, (double)2.0F, entity.m_20185_(), entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_() + (double)entity.m_20206_() * 0.9, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"), "jujutsucraft:particle_blood_red");
            speed = (double)0.5F;
            if (!world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power") * speed, entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_()) {
               entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power") * speed);
            }

            if (!world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power") * speed, entity.getPersistentData().m_128459_("z_pos"))).m_60815_()) {
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power") * speed);
            }

            if (!world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power") * speed)).m_60815_()) {
               entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power") * speed);
            }
         } else {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)((double)1.5F * dis), 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)((double)1.5F * dis), 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)((double)1.5F * dis), 0.75F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)((double)1.5F * dis), 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)((double)1.5F * dis), 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)((double)1.5F * dis), 0.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)((double)25.0F * dis), 0.1 * dis, 0.1 * dis, 0.1 * dis, (double)1.0F);
            }

            entity.getPersistentData().m_128347_("Damage", (double)15.0F);
            entity.getPersistentData().m_128347_("Range", (double)8.0F * dis);
            entity.getPersistentData().m_128347_("knockback", (double)0.75F);
            entity.getPersistentData().m_128347_("effect", (double)15.0F);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("BlockRange", Math.min(entity.getPersistentData().m_128459_("cnt1") - (double)9.0F, (double)4.0F) * dis);
            entity.getPersistentData().m_128347_("BlockDamage", 0.2);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().m_128459_("cnt1") > (double)14.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
