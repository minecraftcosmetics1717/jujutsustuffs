package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class Cockroach2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         double dis = (double)0.0F;
         double HP = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F && entity.getPersistentData().m_128459_("cnt1") < (double)26.0F) {
            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            entity.m_146922_((float)(yaw + Math.random() * (double)180.0F - (double)90.0F));
            entity.m_146926_((float)(Math.random() * (double)22.5F - (double)11.25F));
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            dis = (double)1.0F + Math.random() * (double)5.0F;
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + Math.random() - (double)0.5F;
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + Math.random() - (double)0.5F;
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + Math.random() - (double)0.5F;
            entity.m_146922_((float)yaw);
            entity.m_146926_((float)picth);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 10, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.0F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.COCKROACHES.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                  entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)35.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
