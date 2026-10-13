package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
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

public class AIWater2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_attack = false;
         boolean type = false;
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double rad = (double)0.0F;
         double tsuki7_mode = (double)0.0F;
         double range = (double)0.0F;
         double cnt1_local = (double)0.0F;
         double rad_now = (double)0.0F;
         double dis = (double)0.0F;
         double cnt2 = (double)0.0F;
         double HP = (double)0.0F;
         double CNT6 = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
            logic_attack = false;
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") > (double)0.0F && entity_a.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
                  logic_attack = true;
                  if (!(entity_a instanceof Player)) {
                     entity.getPersistentData().m_128347_("x_power", (double)0.0F);
                     entity.getPersistentData().m_128347_("y_power", (double)-0.5F);
                     entity.getPersistentData().m_128347_("z_power", (double)0.0F);
                  } else {
                     entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                     entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                     entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                  }

                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }

                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), entity_a.getPersistentData().m_128459_("cnt6")));
               }
            }

            if (!logic_attack || !entity.m_6084_()) {
               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, entity.getPersistentData().m_128459_("y_power") * (double)0.75F + (double)0.5F, entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
            }

            for(int index0 = 0; index0 < 2; ++index0) {
               entity.m_146922_((float)((double)entity.m_146908_() + (double)22.5F * Math.random()));
               entity.m_146926_(0.0F);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F && entity.m_20096_() || entity.getPersistentData().m_128459_("cnt1") > (double)100.0F || !entity.m_6084_()) {
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               }
            } else {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 60, 0, false, false));
                  }
               }

               double var10000;
               int var10002;
               label97: {
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  var10000 = entity.getPersistentData().m_128459_("cnt2");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label97;
                     }
                  }

                  var10002 = 0;
               }

               if (var10000 < (double)(15 + var10002) * CNT6) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 15, (double)0.25F, (double)0.25F, (double)0.25F, (double)2.0F);
                  }

                  entity.getPersistentData().m_128347_("NameRanged", entity.getPersistentData().m_128459_("NameRanged_ranged"));

                  for(int index1 = 0; index1 < 2; ++index1) {
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
                     x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)2.0F;
                     y_pos = entity.m_20186_() + entity.m_20154_().f_82480_ * (double)2.0F;
                     z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)2.0F;
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

                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                           entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * (double)0.75F);
                           entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * (double)0.75F);
                           entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * (double)0.75F);
                           entityinstance.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, entity.getPersistentData().m_128459_("y_power") * (double)0.75F, entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }

                     entity.m_146922_((float)((double)entity.m_146908_() + (double)22.5F * Math.random()));
                     entity.m_146926_(0.0F);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }
               } else if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
