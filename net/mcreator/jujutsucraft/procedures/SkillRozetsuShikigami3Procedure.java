package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillRozetsuShikigami3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double mode = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double distance = (double)0.0F;
         double CNT6 = (double)0.0F;
         double dis = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         yaw = (double)entity.m_146908_();
         pitch = (double)entity.m_146909_();
         distance = (double)(1.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         z_pos = entity.m_20189_() + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * distance;
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
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

               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               entity.getPersistentData().m_128359_("SHIKIGAMI_ROZETSU_UUID", entityinstance.m_20149_());
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity31 = (LivingEntity)entityinstance;
                  if (_livingEntity31.m_21204_().m_22171_(Attributes.f_22281_)) {
                     AttributeInstance var10000;
                     double var10001;
                     label97: {
                        var10000 = _livingEntity31.m_21051_(Attributes.f_22281_);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity27 = (LivingEntity)entityinstance;
                           if (_livingEntity27.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var10001 = _livingEntity27.m_21051_(Attributes.f_22281_).m_22115_();
                              break label97;
                           }
                        }

                        var10001 = (double)0.0F;
                     }

                     double var10002;
                     label92: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity28 = (LivingEntity)entity;
                           if (_livingEntity28.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var10002 = _livingEntity28.m_21051_(Attributes.f_22281_).m_22115_();
                              break label92;
                           }
                        }

                        var10002 = (double)0.0F;
                     }

                     int var10003;
                     label87: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label87;
                           }
                        }

                        var10003 = 0;
                     }

                     var10000.m_22100_(var10001 + (var10002 + (double)(var10003 * 3)) * (double)0.5F);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var47;
                     MobEffect var48;
                     int var10005;
                     label76: {
                        var47 = new MobEffectInstance;
                        var48 = MobEffects.f_19606_;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                              break label76;
                           }
                        }

                        var10005 = 0;
                     }

                     var47.<init>(var48, Integer.MAX_VALUE, Math.max(var10005, 0), false, false);
                     _entity.m_7292_(var47);
                  }
               }

               entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
               entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
               entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
               entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
               entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
               entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
               entityinstance.getPersistentData().m_128379_("Shikigami", true);
               if (entity instanceof Player) {
                  entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
               }

               _serverLevel.m_7967_(entityinstance);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123771_, x_pos, y_pos, z_pos, 15, 0.2, 0.2, 0.2, (double)0.0F);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123771_, x_pos, y_pos, z_pos, 15, 0.2, 0.2, 0.2, (double)0.25F);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }
         }

         entity.getPersistentData().m_128347_("skill", (double)0.0F);
         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
      }
   }
}
