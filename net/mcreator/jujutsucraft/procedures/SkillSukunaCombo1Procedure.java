package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.ProjectileSlashEntity;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSukunaCombo1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double CNT6 = (double)0.0F;
         double tick = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double dis = (double)0.0F;
         double HP = (double)0.0F;
         double rnd = (double)0.0F;
         double strength = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double old_cnt2 = (double)0.0F;
         double old_cnt1 = (double)0.0F;
         double size = (double)0.0F;
         double pitch = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            double var105 = ((Entity)var10000).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var106 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var106 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var105, var106, ((Entity)var10002).m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)12.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity15 = (LivingEntity)entity;
                  if (_livingEntity15.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity15.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-7.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity16.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 4, 4, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)9.0F);
            DamageFixProcedure.execute(entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)12.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)12.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (_level.m_5776_()) {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
               if (entity.getPersistentData().m_128459_("cnt1") == (double)12.0F) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
               }

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
               entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * (double)1.0F);
               entity.getPersistentData().m_128347_("y_knockback", entity.getPersistentData().m_128459_("y_power") * (double)1.0F);
               entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * (double)1.0F);

               for(int index0 = 0; index0 < (int)Math.max(dis, (double)1.0F); ++index0) {
                  if (!logic_a) {
                     entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
                     entity.getPersistentData().m_128347_("knockback", 0.1);
                     entity.getPersistentData().m_128347_("effect", (double)5.0F);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           distance = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }
                  }

                  if (logic_a) {
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
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

               if (logic_a || entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)15.0F);
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)1.25F);
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               }

               ParticleGeneratorCircleProcedure.execute(world, (double)36.0F * range, entity.getPersistentData().m_128459_("pitch"), (double)1.0F * range, (double)2.0F * range, (double)4.0F, entity.m_20185_(), entity.m_20185_() - entity.getPersistentData().m_128459_("x_power") * range, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F - entity.getPersistentData().m_128459_("y_power") * range, entity.getPersistentData().m_128459_("yaw"), entity.m_20189_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power") * range, "minecraft:crit");
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F) {
                  old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
                  old_cnt2 = entity.getPersistentData().m_128459_("cnt2");
                  entity.getPersistentData().m_128347_("cnt1", (double)9.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * (double)1.0F);
                  entity.getPersistentData().m_128347_("y_knockback", entity.getPersistentData().m_128459_("y_power") * (double)1.0F);
                  entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * (double)1.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity110 = (LivingEntity)entity;
                     if (_livingEntity110.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity110.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)1.0F);
                     }
                  }

                  AttackStrongPunchProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity111 = (LivingEntity)entity;
                     if (_livingEntity111.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity111.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
                     }
                  }

                  if (LogicStartPassiveProcedure.execute(entity)) {
                     int var108;
                     label221: {
                        yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                        pitch = Math.toRadians((double)entity.m_146909_());
                        distance = (double)0.5F * (double)entity.m_20205_();
                        x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
                        z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var108 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label221;
                           }
                        }

                        var108 = 0;
                     }

                     HP = (double)(30 + var108 * 7);
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
                              LivingEntity _livingEntity128 = (LivingEntity)entityinstance;
                              if (_livingEntity128.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 _livingEntity128.m_21051_(Attributes.f_22276_).m_22100_(HP);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.m_21153_((float)HP);
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity132 = (LivingEntity)entityinstance;
                              if (_livingEntity132.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 _livingEntity132.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(size);
                              }
                           }

                           entityinstance.getPersistentData().m_128347_("size", size * (double)1.0F);
                           entityinstance.getPersistentData().m_128347_("cnt6", (double)1.0F);
                           entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)9.0F);
                           entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)9.0F);
                           entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)9.0F);
                           entityinstance.getPersistentData().m_128347_("skill", (double)105.0F);
                           entityinstance.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)50.0F);
                           if (entityinstance instanceof ProjectileSlashEntity) {
                              PlayAnimationEntity2Procedure.execute(entityinstance, "vertical1");
                           }

                           _serverLevel.m_7967_(entityinstance);
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

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.5F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.75F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                        }
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt1", old_cnt1);
                  entity.getPersistentData().m_128347_("cnt2", old_cnt2);
                  entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)23.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
