package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
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
import software.bernie.geckolib.animatable.GeoEntity;

public class AttackOverheadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         double d = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double old_cnt6 = (double)0.0F;
         boolean logic_a = false;
         Entity target_entity = null;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         double var10001;
         double var10002;
         label301: {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            range = ReturnEntitySizeProcedure.execute(entity);
            var10001 = entity.getPersistentData().m_128459_("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt5 = (LivingEntity)entity;
               if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10002 = 0.3;
                  break label301;
               }
            }

            var10002 = 0.2;
         }

         CNT6 = (double)1.0F + var10001 * var10002;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         entity.f_19789_ = 0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var66 = var10000;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
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
                  distance = GetDistanceProcedure.execute(entity);
                  if (distance > (double)1.0F && distance < (double)4.0F) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") == (double)0.0F) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }

                  if (entity.getPersistentData().m_128459_("cnt5") > (double)0.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)0.125F);
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * (double)0.5F, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  ChargeParticleProcedure.execute(world, entity, (double)10.0F);
               } else {
                  ChargeParticleProcedure.execute(world, entity, (double)0.0F);
               }

               if (var66 instanceof LivingEntity) {
                  RotateEntityProcedure.execute(((Entity)var66).m_20185_(), ((Entity)var66).m_20186_() + (double)((Entity)var66).m_20206_() * (double)0.5F, ((Entity)var66).m_20189_(), entity);
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               }

               if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  if (entity.getPersistentData().m_128459_("skill") == (double)2712.0F || entity.getPersistentData().m_128459_("skill") >= (double)4705.0F && entity.getPersistentData().m_128459_("skill") < (double)4750.0F) {
                     entity.m_146922_((float)yaw);
                     entity.m_146926_((float)Math.max(pitch, (double)90.0F));
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else if (entity.m_20096_()) {
                     entity.m_146922_((float)yaw);
                     entity.m_146926_((float)Math.max(pitch, (double)67.5F));
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else {
                     entity.m_146922_((float)yaw);
                     entity.m_146926_((float)Math.max(pitch, (double)67.5F));
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

                  entity.getPersistentData().m_128379_("canFly", true);
                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
                  GetPowerFixProcedure.execute(entity);
                  entity.m_146922_((float)yaw);
                  entity.m_146926_((float)pitch);
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", (double)4.0F);
               DamageFixProcedure.execute(entity);
            } else {
               if (entity.getPersistentData().m_128459_("cnt4") == (double)0.0F || entity instanceof GeoEntity && GetEntityAnimationProcedure.execute(entity).equals("empty")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity66 = (LivingEntity)entity;
                     if (_livingEntity66.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity66.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-8.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity67 = (LivingEntity)entity;
                     if (_livingEntity67.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity67.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)2.0F, entity.getPersistentData().m_128459_("y_power") * (double)2.0F, entity.getPersistentData().m_128459_("z_power") * (double)2.0F));
               x_power = entity.m_20184_().m_7096_();
               y_power = entity.m_20184_().m_7098_();
               z_power = entity.m_20184_().m_7094_();
               distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (distance != (double)0.0F) {
                  x_power /= distance;
                  y_power /= distance;
                  z_power /= distance;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.1);
               entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.1);
               entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.1);
               logic_a = false;

               for(int index0 = 0; index0 < (int)Math.max(distance, (double)1.0F); ++index0) {
                  entity.getPersistentData().m_128347_("Damage", (double)9.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F * range);
                  entity.getPersistentData().m_128347_("knockback", 0.6);
                  entity.getPersistentData().m_128347_("effect", (double)5.0F);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        logic_a = true;
                        break;
                     }
                  }

                  if (logic_a) {
                     entity.m_20256_(new Vec3((double)0.0F, entity.m_20184_().m_7098_(), (double)0.0F));
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
               entity.getPersistentData().m_128347_("cnt8", Math.max(entity.getPersistentData().m_128459_("cnt8"), entity.getPersistentData().m_128459_("Damage")));
               if (entity.getPersistentData().m_128459_("cnt2") % (double)2.0F == (double)1.0F && entity.getPersistentData().m_128459_("cnt4") >= (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4") - (double)1.0F, (double)1.0F));
               }

               if (entity.m_20096_() && entity.getPersistentData().m_128459_("cnt2") > (double)5.0F) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  pitch = Math.toRadians((double)0.0F);
                  distance = (double)(1.0F * entity.m_20205_());
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance);
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + Math.sin(pitch) * (double)-1.0F * distance);
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);
                  if (entity.getPersistentData().m_128459_("cnt4") == (double)0.0F || entity instanceof GeoEntity) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity125 = (LivingEntity)entity;
                        if (_livingEntity125.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity125.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity126 = (LivingEntity)entity;
                        if (_livingEntity126.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity126.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               } else if (entity.getPersistentData().m_128459_("cnt2") > (double)80.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") != (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt3", (double)4.0F);
            entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
               }
            }

            d = Math.max(Math.sqrt(entity.getPersistentData().m_128459_("cnt8")), (double)1.0F) * range;
            entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
            if (!(entity.getPersistentData().m_128459_("cnt3") > (double)1.0F) && !(entity.getPersistentData().m_128459_("cnt4") > (double)15.0F)) {
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)5.0F);
               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
            } else if (entity.getPersistentData().m_128459_("cnt1") <= (double)9.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") <= (double)2.0F) {
                  if (entity.getPersistentData().m_128459_("cnt4") == (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)2.0F && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)d, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)d, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 0.75F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)d, 0.75F, false);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") <= (double)2.0F * d) {
                  if (entity.getPersistentData().m_128459_("cnt1") % (double)2.0F == (double)0.0F) {
                     old_cnt6 = entity.getPersistentData().m_128459_("cnt6");
                     entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);
                     entity.getPersistentData().m_128347_("Damage", (double)13.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)0.75F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)5.0F * range);
                     entity.getPersistentData().m_128347_("effect", (double)5.0F);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("cnt6", old_cnt6);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F + d * (double)1.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)0.5F * d);
                     entity.getPersistentData().m_128347_("knockback", (double)0.75F * CNT6);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  for(int index1 = 0; index1 < (int)((double)8.0F * range); ++index1) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)4.0F, x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)2.0F), (double)0.0F, z_pos, z_pos, Math.random() < (double)0.75F ? "minecraft:crit" : "minecraft:cloud");
                  }

                  for(int index2 = 0; index2 < (int)((double)8.0F * range); ++index2) {
                     distance = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)2.5F * range);
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, distance, distance, Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)8.0F), x_pos, x_pos, y_pos, y_pos + (double)1.0F, (double)0.0F, z_pos, z_pos, "minecraft:crit");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
                  entity.getPersistentData().m_128347_("BlockRange", (double)1.0F * d);
                  entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") > (double)17.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }

            entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
         }

      }
   }
}
