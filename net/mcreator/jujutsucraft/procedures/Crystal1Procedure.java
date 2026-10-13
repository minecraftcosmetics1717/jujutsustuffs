package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade112Entity;
import net.mcreator.jujutsucraft.entity.EntityCrystalEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class Crystal1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double distance = (double)0.0F;
         double speed = (double)0.0F;
         double size = (double)0.0F;
         double strength = (double)0.0F;
         double range = (double)0.0F;
         String stt1 = "";
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            double var75 = ((Entity)var10000).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var78 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var78 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var75, var78, ((Entity)var10002).m_20189_(), entity);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(0.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)2.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)1.0F));
               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity38 = (LivingEntity)entity;
               if (_livingEntity38.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity38.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-4.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            distance = (double)(3.0F + entity.m_20205_());

            for(int index0 = 0; index0 < (int)((double)2.0F * range); ++index0) {
               yaw = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               pitch = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, distance, x_pos + Math.cos(yaw) * Math.cos(pitch) * distance, x_pos, y_pos + Math.sin(pitch) * (double)-1.0F * distance, y_pos, z_pos + Math.sin(yaw) * Math.cos(pitch) * distance, z_pos, entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F ? "minecraft:enchanted_hit" : "minecraft:crit");
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            int var80;
            label152: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var80 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label152;
                  }
               }

               var80 = 0;
            }

            HP = (double)(20 + var80 * 4);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(0.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            speed = (double)8.0F;
            String var77;
            if (entity instanceof CursedSpiritGrade112Entity) {
               CursedSpiritGrade112Entity animatable = (CursedSpiritGrade112Entity)entity;
               var77 = animatable.getTexture();
            } else {
               var77 = "null";
            }

            stt1 = var77;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRYSTAL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                     LivingEntity _livingEntity59 = (LivingEntity)entityinstance;
                     if (_livingEntity59.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity59.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity63 = (LivingEntity)entityinstance;
                     if (_livingEntity63.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity63.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)1.0F);
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * speed);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * speed);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * speed);
                  if (entityinstance instanceof EntityCrystalEntity) {
                     PlayAnimationEntity2Procedure.execute(entityinstance, "act1");
                  }

                  if (entity instanceof CursedSpiritGrade112Entity && entityinstance instanceof EntityCrystalEntity) {
                     EntityCrystalEntity animatable = (EntityCrystalEntity)entityinstance;
                     animatable.setTexture(stt1);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)4.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
