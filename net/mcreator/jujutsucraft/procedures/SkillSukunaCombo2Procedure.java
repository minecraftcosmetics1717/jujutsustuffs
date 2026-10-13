package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.ProjectileSlashEntity;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSukunaCombo2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_b = ItemStack.f_41583_;
         ItemStack item_a = ItemStack.f_41583_;
         double old_cnt1 = (double)0.0F;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double size = (double)0.0F;
         double HP = (double)0.0F;
         Entity target_entity = null;
         boolean sword = false;
         boolean vertical = false;
         entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1") + (double)1.0F, (double)10.0F));
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
         range = ReturnEntitySizeProcedure.execute(entity);
         sword = LogicSwordProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.m_20256_(new Vec3(entity.m_20184_().m_7096_() * (double)0.5F, Math.min(entity.m_20184_().m_7098_() * (double)0.5F, Math.min(entity.m_20184_().m_7098_(), 0.1)), entity.m_20184_().m_7094_() * (double)0.5F));
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var55 = var10000;
         if (var55 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var55).m_20185_(), ((Entity)var55).m_20186_() + (double)((Entity)var55).m_20206_() * (double)0.5F, ((Entity)var55).m_20189_(), entity);
         }

         old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
         old_skill = entity.getPersistentData().m_128459_("skill");
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(0.0F + entity.m_20205_());
         double var86 = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         var86 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         var86 = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().m_128459_("cnt5") <= (double)100.0F) {
            ItemStack var89;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var89 = _livEnt.m_21205_();
            } else {
               var89 = ItemStack.f_41583_;
            }

            item_a = var89.m_41777_().m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var89 = _livEnt.m_21206_();
            } else {
               var89 = ItemStack.f_41583_;
            }

            item_b = var89.m_41777_().m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = ItemStack.f_41583_.m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = ItemStack.f_41583_.m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }

            if (entity.getPersistentData().m_128459_("cnt5") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity38 = (LivingEntity)entity;
                  if (_livingEntity38.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity38.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-7.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity39 = (LivingEntity)entity;
                  if (_livingEntity39.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity39.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("cnt6", (double)2.5F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity41 = (LivingEntity)entity;
                  if (_livingEntity41.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity41.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)1.0F);
                  }
               }

               AttackStrongPunchProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity42 = (LivingEntity)entity;
                  if (_livingEntity42.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity42.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt5") >= (double)8.0F && entity.getPersistentData().m_128459_("cnt5") <= (double)12.0F) {
               if (LogicStartPassiveProcedure.execute(entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.75F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 0.75F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.75F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
                     }
                  }

                  int var10001;
                  label172: {
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());
                     distance = (double)0.5F * (double)entity.m_20205_();
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label172;
                        }
                     }

                     var10001 = 0;
                  }

                  HP = (double)(30 + var10001 * 7);
                  size = (double)0.5F * ReturnEntitySizeProcedure.execute(entity);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.PROJECTILE_SLASH.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                           LivingEntity _livingEntity66 = (LivingEntity)entityinstance;
                           if (_livingEntity66.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity66.m_21051_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity70 = (LivingEntity)entityinstance;
                           if (_livingEntity70.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity70.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(size);
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("size", size * (double)5.0F * ((double)1.0F + (double)0.5F * entity.getPersistentData().m_128459_("cnt6")));
                        entityinstance.getPersistentData().m_128347_("cnt6", (double)1.0F + 0.05 * entity.getPersistentData().m_128459_("cnt5"));
                        entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)9.0F);
                        entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)9.0F);
                        entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)9.0F);
                        entityinstance.getPersistentData().m_128347_("skill", (double)105.0F);
                        entityinstance.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)50.0F);
                        if (entityinstance instanceof ProjectileSlashEntity) {
                           RandomSource var91 = RandomSource.m_216327_();
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.m_216271_(var91, 1, 5)));
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), (double)100.0F));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt5") >= (double)12.0F) {
               entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), (double)100.0F));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_a.m_41777_();
               _setstack.m_41764_(item_a.m_41613_());
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_b.m_41777_();
               _setstack.m_41764_(item_b.m_41613_());
               _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }

            entity.getPersistentData().m_128347_("cnt1", old_cnt1);
            entity.getPersistentData().m_128347_("skill", old_skill);
         } else if (entity.getPersistentData().m_128459_("cnt5") > (double)110.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
