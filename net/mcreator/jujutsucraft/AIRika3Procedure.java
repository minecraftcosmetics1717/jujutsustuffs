package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
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
import net.minecraftforge.registries.ForgeRegistries;

public class AIRika3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double rnd = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double HP = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double distance = (double)0.0F;
         Entity entity_a = null;
         Entity target_entity = null;
         if (entity instanceof RikaEntity) {
            PlayAnimationEntity2Procedure.execute(entity, "pure_love");
         }

         if (entity instanceof Rika2Entity) {
            PlayAnimationEntity2Procedure.execute(entity, "pure_love");
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (target_entity instanceof LivingEntity) {
            x_pos = target_entity.m_20185_();
            y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * (double)0.75F;
            z_pos = target_entity.m_20189_();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
               if (entity_a instanceof Mob) {
                  Mob _mobEnt = (Mob)entity_a;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               target_entity = var10000;
               if (target_entity instanceof LivingEntity) {
                  x_pos = target_entity.m_20185_();
                  y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * (double)0.75F;
                  z_pos = target_entity.m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               } else {
                  entity.m_146922_(entity_a.m_146908_());
                  entity.m_146926_(entity_a.m_146909_());
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

               if (entity_a.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)78.0F));
               }
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 20, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(3.0F + entity.m_20205_());
         entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance);
         entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(pitch) * (double)-1.0F * distance);
         entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);
         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 100, 0, false, false));
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                  if (entity_a.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
                     entity_a.getPersistentData().m_128347_("NameRanged", Math.random());
                  }

                  entity.getPersistentData().m_128347_("NameRanged", entity_a.getPersistentData().m_128459_("NameRanged"));
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100, 0, false, false));
                     }
                  }

                  if (!(entity_a instanceof Player) && entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 100, 9, false, false));
                     }
                  }
               }
            }

            int var10001;
            label132: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label132;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(400 + var10001 * 40);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.PURE_LOVE_CANNON.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity63 = (LivingEntity)entityinstance;
                     if (_livingEntity63.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity63.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(Math.max((double)4.0F * ReturnEntitySizeProcedure.execute(entity), (double)0.25F));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity65 = (LivingEntity)entityinstance;
                     if (_livingEntity65.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity65.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)80.0F) {
            if (Math.random() < 0.05 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
            if (entity.getPersistentData().m_128459_("friend_num_worker") != (double)0.0F) {
               entity.getPersistentData().m_128347_("despawn_flag", (double)1.0F);
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
