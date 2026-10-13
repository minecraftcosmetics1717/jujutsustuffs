package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityWaterEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class JogoFlame4Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         old_skill = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt5") == (double)0.0F) {
            ChojuroStoneHandProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt5", (double)1.0F);
         }

         double var10000;
         int var10002;
         label47: {
            var10000 = entity.getPersistentData().m_128459_("cnt4");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label47;
               }
            }

            var10002 = 0;
         }

         if (var10000 <= (double)Math.min(10 + var10002, 20)) {
            entity.getPersistentData().m_128347_("skill", old_skill);
            yaw = Math.toRadians((double)entity.m_146908_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-90.0F, (double)90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(1.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)1.25F);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)1.25F);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)1.25F);
                  entityinstance.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)1.25F, entity.m_20154_().f_82480_ * (double)1.25F, entity.m_20154_().f_82481_ * (double)1.25F));
                  if (entityinstance instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntSetI = (EntityWaterEntity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 2);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt5") != (double)0.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
