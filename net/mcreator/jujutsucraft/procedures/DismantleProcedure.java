package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.ProjectileSlashEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DismantleProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean vertical = false;
         boolean canUseWorld = false;
         boolean worldCutter = false;
         double distance = (double)0.0F;
         double picth = (double)0.0F;
         double HP = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         double size = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch = (double)0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         label354: {
            label353: {
               var38 = var10000;
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity instanceof Player) {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr4 = (ServerPlayer)entity;
                     if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_cut_the_world"))).m_8193_()) {
                        break label353;
                     }
                  }
               } else {
                  if (entity instanceof SukunaFushiguroEntity && entity instanceof SukunaFushiguroEntity) {
                     SukunaFushiguroEntity _datEntL6 = (SukunaFushiguroEntity)entity;
                     if ((Boolean)_datEntL6.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_world_cut)) {
                        break label353;
                     }
                  }

                  if (entity instanceof SukunaPerfectEntity) {
                     break label353;
                  }
               }

               canUseWorld = false;
               break label354;
            }

            canUseWorld = true;
         }

         if (var38 instanceof LivingEntity) {
            if (canUseWorld && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            entity.m_7618_(Anchor.EYES, new Vec3(((Entity)var38).m_20185_(), ((Entity)var38).m_20186_() + (double)((Entity)var38).m_20206_() * (double)0.5F, ((Entity)var38).m_20189_()));
            entity.getPersistentData().m_128379_("PRESS_Z", false);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)6.0F && (((Entity)var38).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var38).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var38).getPersistentData().m_128471_("attack") || ((Entity)var38).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
            }

            if (canUseWorld && var38 instanceof LivingEntity) {
               LivingEntity _livEnt21 = var38;
               if (_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && !entity.getPersistentData().m_128471_("flag_dismantle")) {
                  entity.getPersistentData().m_128379_("flag_dismantle", true);
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (var38 instanceof LivingEntity) {
                     RotateEntityProcedure.execute(((Entity)var38).m_20185_(), ((Entity)var38).m_20186_() + (double)((Entity)var38).m_20206_() * (double)0.5F, ((Entity)var38).m_20189_(), entity);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
            label324: {
               label323: {
                  if (entity instanceof Player) {
                     if (entity.m_6144_()) {
                        break label323;
                     }
                  } else if (Math.random() < (double)0.5F) {
                     break label323;
                  }

                  entity.getPersistentData().m_128347_("cnt7", (double)2.0F);
                  break label324;
               }

               entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
            }

            if (var38 instanceof LivingEntity && canUseWorld && var38 instanceof LivingEntity) {
               LivingEntity _livEnt38 = var38;
               if (_livEnt38.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  entity.getPersistentData().m_128347_("cnt7", (double)2.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 6, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);
            range = (double)0.5F;
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               picth = Math.toRadians((double)entity.m_146909_());
               distance = (double)(1.0F + entity.m_20205_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(picth) * (double)-1.0F * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * distance;
               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") < (double)3.0F) {
                     entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt5") > (double)20.0F) {
                        entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)1.0F);
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              CompoundTag var10001 = entity.getPersistentData();
                              _player.m_5661_(Component.m_237113_("§l\"" + Component.m_237115_("chant.jujutsucraft.dismantle" + Math.round(var10001.m_128459_("cnt6"))).getString() + "\""), false);
                           }
                        }

                        if (entity instanceof Player) {
                           double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)30.0F;
                           entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.PlayerCursePowerChange = _setval;
                              capability.syncPlayerVariables(entity);
                           });
                        }
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, (double)0.25F, (double)0.25F, (double)0.25F, (double)1.0F);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ChargeParticleProcedure.execute(world, entity, (double)1.0F);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, (double)0.0F);
                  }
               }
            }

            range = (double)1.0F;
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F && canUseWorld) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity76 = (LivingEntity)entity;
               if (_livingEntity76.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity76.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)(entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F ? 207 : 120));
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && entity.getPersistentData().m_128459_("cnt7") == (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)5.0F));
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            vertical = Math.random() < (double)0.5F;
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F && canUseWorld) {
               worldCutter = true;
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)0.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 1.0F, false);
                  }
               }

               if (!canUseWorld) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (vertical) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity89 = (LivingEntity)entity;
                        if (_livingEntity89.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity89.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)207.0F);
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity90 = (LivingEntity)entity;
                        if (_livingEntity90.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity90.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity92 = (LivingEntity)entity;
                        if (_livingEntity92.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity92.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
                        }
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
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

            int var85;
            label306: {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F) + Mth.m_216263_(RandomSource.m_216327_(), (double)-90.0F, (double)90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               distance = (double)0.5F * (double)entity.m_20205_();
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var85 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label306;
                  }
               }

               var85 = 0;
            }

            HP = (double)(30 + var85 * 7) * CNT6;
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
                     LivingEntity _livingEntity111 = (LivingEntity)entityinstance;
                     if (_livingEntity111.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity111.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity115 = (LivingEntity)entityinstance;
                     if (_livingEntity115.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity115.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(size);
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("size", size * (double)5.0F * ((double)1.0F + (double)0.5F * entity.getPersistentData().m_128459_("cnt6")));
                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + entity.getPersistentData().m_128459_("cnt8") * 0.025);
                  entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)9.0F);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)9.0F);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)9.0F);
                  if (worldCutter && entityinstance instanceof ProjectileSlashEntity) {
                     ProjectileSlashEntity _datEntSetI = (ProjectileSlashEntity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(ProjectileSlashEntity.DATA_mode, 1);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)0.0F) {
                     if (vertical) {
                        if (entityinstance instanceof ProjectileSlashEntity) {
                           PlayAnimationEntity2Procedure.execute(entityinstance, "vertical1");
                        }
                     } else if (entityinstance instanceof ProjectileSlashEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle1");
                     }
                  } else if (vertical) {
                     if (entityinstance instanceof ProjectileSlashEntity) {
                        RandomSource var86 = RandomSource.m_216327_();
                        PlayAnimationEntity2Procedure.execute(entityinstance, "vertical" + Math.round((float)Mth.m_216271_(var86, 1, 5)));
                     }
                  } else if (entityinstance instanceof ProjectileSlashEntity) {
                     RandomSource var87 = RandomSource.m_216327_();
                     PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.m_216271_(var87, 1, 5)));
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt7") == (double)1.0F) {
               if (var38 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }

               if ((!entity.getPersistentData().m_128471_("PRESS_Z") || !(entity.getPersistentData().m_128459_("cnt8") < (double)16.0F)) && !(entity.getPersistentData().m_128459_("cnt8") < (double)8.0F)) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt1", (double)3.0F);
                  entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + (double)1.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
