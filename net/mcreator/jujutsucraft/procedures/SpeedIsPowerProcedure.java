package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SpeedIsPowerProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean SUCCESS = false;
         boolean logic_a = false;
         double d = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double num1 = (double)0.0F;
         double CNT6 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt10", entity.getPersistentData().m_128459_("cnt10") + (double)1.0F);
         range = ReturnEntitySizeProcedure.execute(entity);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var38 = var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 2, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt10") <= (double)20.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof Player) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 2, 1, false, false));
               }
            }

            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (entity instanceof Player) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity12 = (LivingEntity)entity;
                  if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity12.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-21.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity13 = (LivingEntity)entity;
                  if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity13.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            x_power = entity.m_20185_();
            y_power = entity.m_20186_();
            z_power = entity.m_20189_();
            distance = (double)16.0F * range * Mth.m_216263_(RandomSource.m_216327_(), (double)0.25F, (double)1.0F);

            for(int index0 = 0; index0 < (int)((double)8.0F * range); ++index0) {
               yaw = Math.toRadians((double)Mth.m_216271_(RandomSource.m_216327_(), 0, 360));
               pitch = Math.toRadians((double)0.0F);
               x_pos = x_power + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = y_power + Math.sin(pitch) * (double)-1.0F * distance;
               z_pos = z_power + Math.sin(yaw) * Math.cos(pitch) * distance;
               ParticleGeneratorProcedure.execute(world, (double)2.0F * range, (double)1.0F, (double)0.0F, Math.min(entity.getPersistentData().m_128459_("cnt6") * (double)1.0F + (double)5.0F, (double)10.0F), x_pos, x_pos + Math.cos(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance, y_pos, y_pos + Math.sin(pitch) * (double)-1.0F * distance, z_pos, z_pos + Math.sin(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance, "minecraft:cloud");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)((double)2.0F * range), (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.25F));
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)((double)2.0F * range), (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.25F), false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.25F));
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.25F), false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)1.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)0.5F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F);
            entity.getPersistentData().m_128347_("BlockRange", (double)1.0F * range);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt6", Math.min(entity.getPersistentData().m_128459_("cnt6") + (double)0.25F, (double)5.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt10") >= (double)20.0F) {
               if (var38 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt10", (double)19.0F);
               }
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt10") <= (double)25.0F) {
               if (entity.getPersistentData().m_128459_("cnt10") == (double)21.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity41 = (LivingEntity)entity;
                     if (_livingEntity41.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity41.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-7.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity42 = (LivingEntity)entity;
                     if (_livingEntity42.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity42.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (var38 instanceof LivingEntity) {
                     RotateEntityProcedure.execute(((Entity)var38).m_20185_(), ((Entity)var38).m_20186_() + (double)((Entity)var38).m_20206_() * (double)0.5F, ((Entity)var38).m_20189_(), entity);
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)9.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)9.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)9.0F);
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               }

               entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power"));
               entity.getPersistentData().m_128347_("y_knockback", entity.getPersistentData().m_128459_("y_power"));
               entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power"));
               x_power = entity.getPersistentData().m_128459_("x_power");
               y_power = entity.getPersistentData().m_128459_("y_power");
               z_power = entity.getPersistentData().m_128459_("z_power");
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != (double)0.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               num1 = (double)0.0F;
               distance = (double)0.0F;

               for(int index1 = 0; index1 < (int)((double)1.0F + dis); ++index1) {
                  logic_a = false;
                  ++num1;
                  if (num1 > (double)0.0F) {
                     num1 = (double)-2.0F;
                     ParticleGeneratorCircleProcedure.execute(world, (double)18.0F * range, entity.getPersistentData().m_128459_("pitch"), (double)0.5F * range, (double)6.0F * range, (double)4.0F, x_pos, x_pos - x_power * range, y_pos, y_pos - y_power * range, entity.getPersistentData().m_128459_("yaw"), z_pos, z_pos - z_power * range, "minecraft:cloud");
                  }

                  if (!logic_a) {
                     entity.getPersistentData().m_128347_("Damage", (double)26.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                     entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
                     entity.getPersistentData().m_128347_("effect", (double)5.0F);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                     entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
                     KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }
                  }

                  if (logic_a) {
                     break;
                  }

                  logic_a = true;
                  if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     x_pos += x_power;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     y_pos += y_power;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     z_pos += z_power;
                  }

                  if (logic_a) {
                     logic_a = false;
                     break;
                  }
               }

               entity.getPersistentData().m_128379_("attack", true);
               entity.m_6021_(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
               }

               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power"));
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power")));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F, false);
                  }
               }
            }

            if (var38 instanceof LivingEntity) {
               entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
               entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
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

            if (entity.getPersistentData().m_128459_("cnt10") == (double)26.0F) {
               entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power"));
               entity.getPersistentData().m_128347_("y_knockback", entity.getPersistentData().m_128459_("y_power"));
               entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power"));
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               if (entity.getPersistentData().m_128459_("cnt10") == (double)20.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)25.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, (double)2.0F);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", (double)26.0F * CNT6);
               entity.getPersistentData().m_128347_("knockback", (double)2.0F);
               entity.getPersistentData().m_128347_("Range", (double)8.0F * range);
               entity.getPersistentData().m_128347_("effect", (double)5.0F);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("knockback", (double)2.0F);
               entity.getPersistentData().m_128347_("Range", (double)8.0F * range);
               KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               d = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
               entity.getPersistentData().m_128347_("BlockDamage", Math.max(d * (double)0.25F, (double)1.0F));
               entity.getPersistentData().m_128347_("BlockRange", Math.max((double)1.0F * range, Math.max(d * (double)0.5F, (double)1.0F)));
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("knockback", (double)2.0F);
               entity.getPersistentData().m_128347_("Range", Math.max((double)2.0F * range, Math.max(d * (double)1.0F, (double)2.0F)));
               KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
            entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
            entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
            if (entity.getPersistentData().m_128459_("cnt10") > (double)30.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
