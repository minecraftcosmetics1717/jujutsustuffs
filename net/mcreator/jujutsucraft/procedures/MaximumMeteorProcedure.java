package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MaximumMeteorProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.f_19789_ = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() + (double)5.0F;
         z_pos = entity.m_20189_();
         entity.getPersistentData().m_128347_("Damage", (double)6.0F);
         DamageFixProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)100.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity14 = (LivingEntity)entity;
                  if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)215.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity15 = (LivingEntity)entity;
                  if (_livingEntity15.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity15.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               int var10001;
               label126: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label126;
                     }
                  }

                  var10001 = 0;
               }

               HP = (double)(400 + var10001 * 40);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.METEOR.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

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
                        LivingEntity _livingEntity26 = (LivingEntity)entityinstance;
                        if (_livingEntity26.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity26.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity30 = (LivingEntity)entityinstance;
                        if (_livingEntity30.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity30.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                        }
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                  }
               }
            }

            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), Math.max((double)0.5F - entity.getPersistentData().m_128459_("cnt1") * 0.005, (double)0.0F), entity.m_20184_().m_7094_()));
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)100.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity38 = (LivingEntity)entity;
                  if (_livingEntity38.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity38.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity39 = (LivingEntity)entity;
                  if (_livingEntity39.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity39.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)120.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity42 = (LivingEntity)entity;
                  if (_livingEntity42.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity42.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-49.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity43 = (LivingEntity)entity;
                  if (_livingEntity43.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity43.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") <= (double)120.0F) {
               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), (double)0.0F, entity.m_20184_().m_7094_()));
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)160.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
