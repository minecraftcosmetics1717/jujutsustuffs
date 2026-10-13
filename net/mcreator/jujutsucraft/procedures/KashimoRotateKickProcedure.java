package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityAttackSlashEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class KashimoRotateKickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_b = ItemStack.f_41583_;
         ItemStack item_a = ItemStack.f_41583_;
         Entity target_entity = null;
         boolean sword = false;
         boolean logic_a = false;
         double old_cnt1 = (double)0.0F;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double yaw1 = (double)0.0F;
         double pitch1 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1") + (double)1.0F, (double)10.0F));
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var50 = var10000;
         if (var50 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var50).m_20185_(), ((Entity)var50).m_20186_() + (double)((Entity)var50).m_20206_() * (double)0.5F, ((Entity)var50).m_20189_(), entity);
         }

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
         old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
         old_skill = entity.getPersistentData().m_128459_("skill");
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(0.0F + entity.m_20205_());
         double var115 = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         var115 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         var115 = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().m_128459_("cnt5") <= (double)100.0F) {
            ItemStack var118;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var118 = _livEnt.m_21205_();
            } else {
               var118 = ItemStack.f_41583_;
            }

            item_a = var118.m_41777_().m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var118 = _livEnt.m_21206_();
            } else {
               var118 = ItemStack.f_41583_;
            }

            item_b = var118.m_41777_().m_41777_();
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
                  LivingEntity _livingEntity37 = (LivingEntity)entity;
                  if (_livingEntity37.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity37.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-6.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity38 = (LivingEntity)entity;
                  if (_livingEntity38.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity38.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", (double)6.0F);
               DamageFixProcedure.execute(entity);
            }

            if (entity.getPersistentData().m_128459_("cnt5") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt5") < (double)10.0F) {
               if (entity.getPersistentData().m_128459_("cnt5") == (double)5.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (_level.m_5776_()) {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               }

               yaw1 = (double)entity.m_146908_();
               pitch1 = (double)entity.m_146909_();
               entity.m_146922_((float)(yaw1 + (entity.getPersistentData().m_128459_("cnt5") - (double)4.0F) * (double)45.0F));
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

               range = ReturnEntitySizeProcedure.execute(entity);
               range *= range;
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               dis = (double)2.5F * range;
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(pitch) * (double)-1.0F * dis;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_SLASH.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
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

                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        EntityAttackSlashEntity animatable = (EntityAttackSlashEntity)entityinstance;
                        animatable.setTexture("slash_white");
                     }

                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle1");
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity74 = (LivingEntity)entityinstance;
                        if (_livingEntity74.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity74.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)3.0F * range);
                        }
                     }

                     entityinstance.m_6021_(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityinstance.m_146908_(), entityinstance.m_146909_());
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), 1.0F, false);
                  }
               }

               entity.m_146922_((float)yaw1);
               entity.m_146926_((float)pitch1);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
                  x_power = entity.getPersistentData().m_128459_("x_power") * (double)1.0F;
                  y_power = entity.getPersistentData().m_128459_("y_power") * (double)1.0F;
                  z_power = entity.getPersistentData().m_128459_("z_power") * (double)1.0F;
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
                  StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  if (dis != (double)0.0F) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                  }

                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();

                  for(int index0 = 0; index0 < (int)Math.max(dis, (double)1.0F); ++index0) {
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           distance = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }

                     if (logic_a) {
                        break;
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }

                  entity.getPersistentData().m_128379_("attack", true);
                  if (logic_a) {
                     if (Math.round(distance) >= 1L) {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();

                        for(int index1 = 0; index1 < (int)Math.round(distance); ++index1) {
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
                              break;
                           }
                        }

                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }
                     }

                     logic_a = true;
                  }

                  if (logic_a || entity.getPersistentData().m_128459_("cnt5") >= (double)9.0F) {
                     entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                     entity.getPersistentData().m_128347_("cnt5", (double)10.0F);
                     EntityVectorProcedure.execute(entity, (double)0.0F, (double)0.0F, (double)0.0F);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt5") >= (double)10.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), (double)100.0F));
               entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)3.5F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity119 = (LivingEntity)entity;
                  if (_livingEntity119.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity119.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)1.0F);
                  }
               }

               AttackStrongPunchProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity120 = (LivingEntity)entity;
                  if (_livingEntity120.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity120.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
                  }
               }
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
