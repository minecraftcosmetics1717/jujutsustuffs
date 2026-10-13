package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GaragaraProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         boolean logic_a;
         double CNT6;
         int var10000;
         label490: {
            SUCCESS = false;
            logic_a = false;
            Entity target_entity = null;
            double strength = (double)0.0F;
            double distance = (double)0.0F;
            double HP = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double dis = (double)0.0F;
            CNT6 = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            double old_cnt6 = (double)0.0F;
            double rad = (double)0.0F;
            double x_power = (double)0.0F;
            double y_pos = (double)0.0F;
            double pitch = (double)0.0F;
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label490;
               }
            }

            var10000 = 0;
         }

         double var44 = (double)Math.min(var10000, 50);
         double var53 = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + var44 * 0.025) * CNT6;
         double var54 = entity.m_20185_();
         double var74 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         double var58 = entity.m_20189_();
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         LivingEntity var127;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var127 = _mobEnt.m_5448_();
         } else {
            var127 = null;
         }

         Entity var43 = var127;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
            if (var43 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var43).m_20185_(), ((Entity)var43).m_20186_() + (double)((Entity)var43).m_20206_() * (double)0.5F, ((Entity)var43).m_20189_(), entity);
            }

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") <= (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 3, false, false));
                  }
               }

               if (var43 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) < (double)8.0F && (((Entity)var43).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var43).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt3", Math.min(entity.getPersistentData().m_128459_("cnt3"), (double)0.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     ChangeCurseEnergyProcedure.execute(entity, (double)-1.0F);
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, var54, var74, var58, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  ChargeParticleProcedure.execute(world, entity, (double)10.0F);
               } else {
                  ChargeParticleProcedure.execute(world, entity, (double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity42 = (LivingEntity)entity;
                  if (_livingEntity42.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity42.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-10.0F);
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

            if (entity.getPersistentData().m_128459_("cnt3") >= (double)10.0F) {
               if (var43 instanceof LivingEntity) {
                  var54 = ((Entity)var43).m_20185_();
                  var74 = ((Entity)var43).m_20186_() + (double)(((Entity)var43).m_20206_() * 0.0F);
                  var58 = ((Entity)var43).m_20189_();
               } else {
                  double var63 = (double)6.0F;

                  for(int index0 = 0; index0 < 6; ++index0) {
                     var54 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var63)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
                     var74 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var63)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
                     var58 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var63)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
                     Vec3 _center = new Vec3(var54, var74, var58);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var54 = entityiterator.m_20185_();
                           var74 = entityiterator.m_20186_() + (double)(entityiterator.m_20206_() * 0.0F);
                           var58 = entityiterator.m_20189_();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     var63 += (double)6.0F;
                  }
               }

               double var72 = var54 - entity.m_20185_();
               double var66 = var74 - (entity.m_20186_() + (double)(entity.m_20206_() * 0.0F));
               double var68 = var58 - entity.m_20189_();
               double var45 = Math.sqrt(var72 * var72 + var66 * var66 + var68 * var68);
               if (var45 > (double)1.0F) {
                  var72 /= var45;
                  double var128 = var66 / var45;
                  var68 /= var45;
               }

               entity.getPersistentData().m_128347_("x_power", var72 * (double)1.0F);
               entity.getPersistentData().m_128347_("z_power", var68 * (double)1.0F);
               entity.getPersistentData().m_128347_("cnt7", var45 / (double)2.0F);
               entity.getPersistentData().m_128347_("cnt9", var74 - (entity.m_20186_() + (double)(entity.m_20206_() * 0.0F)));
               entity.getPersistentData().m_128347_("cnt10", Math.max(Math.sqrt(var45) * (double)3.0F, (double)3.0F));
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") != (double)0.0F) {
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)10.0F);
            } else {
               ChargeParticleProcedure.execute(world, entity, (double)0.0F);
            }

            if (var43 instanceof LivingEntity) {
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

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
            entity.getPersistentData().m_128347_("y_power", (entity.getPersistentData().m_128459_("cnt9") / entity.getPersistentData().m_128459_("cnt7") + entity.getPersistentData().m_128459_("cnt10") * (double)4.0F / entity.getPersistentData().m_128459_("cnt7") - entity.getPersistentData().m_128459_("cnt10") * (double)8.0F / (entity.getPersistentData().m_128459_("cnt7") * entity.getPersistentData().m_128459_("cnt7")) * (entity.getPersistentData().m_128459_("cnt5") - (double)0.0F)) * (double)0.5F);
            if (entity.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity96 = (LivingEntity)entity;
                  if (_livingEntity96.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity96.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-8.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity97 = (LivingEntity)entity;
                  if (_livingEntity97.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity97.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double var73 = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
               double var67 = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
               double var69 = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
               entity.m_20256_(new Vec3(var73, var67, var69));
               double var64 = Math.sqrt(var73 * var73 + var67 * var67 + var69 * var69);
               if (var64 != (double)0.0F) {
                  var73 /= var64;
                  var67 /= var64;
                  var69 /= var64;
               }

               var54 = entity.m_20185_();
               var74 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               var58 = entity.m_20189_();
               entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.1);
               entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.1);
               entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.1);

               for(int index1 = 0; index1 < (int)Math.max(var64, (double)1.0F); ++index1) {
                  entity.getPersistentData().m_128347_("Damage", (double)9.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F * var53);
                  entity.getPersistentData().m_128347_("knockback", 0.6);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, var54, var74, var58, entity);
                  Vec3 _center = new Vec3(var54, var74, var58);

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

                  var54 += var73;
                  var74 += var67;
                  var58 += var69;
               }

               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               entity.getPersistentData().m_128379_("attack", true);
               DamageFixProcedure.execute(entity);
               entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               if (entity.m_20096_() && entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
                  double var62 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double var78 = Math.toRadians((double)0.0F);
                  double var46 = (double)(1.0F * entity.m_20205_());
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var62) * Math.cos(var78) * var46);
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + Math.sin(var78) * (double)-1.0F * var46);
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var62) * Math.cos(var78) * var46);
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity143 = (LivingEntity)entity;
                     if (_livingEntity143.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity143.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity144 = (LivingEntity)entity;
                     if (_livingEntity144.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity144.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               } else if (entity.getPersistentData().m_128459_("cnt1") > (double)80.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt4") > (double)0.0F) {
               if (!(entity instanceof Player) || entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity150 = (LivingEntity)entity;
                     if (_livingEntity150.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity150.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity151 = (LivingEntity)entity;
                     if (_livingEntity151.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity151.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               var54 = entity.getPersistentData().m_128459_("x_pos");
               var74 = entity.getPersistentData().m_128459_("y_pos");
               var58 = entity.getPersistentData().m_128459_("z_pos");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), var54, var74 + (double)0.5F, var58, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F) {
                  if (entity.getPersistentData().m_128459_("cnt1") <= (double)3.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 0.75F);
                        } else {
                           _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 1.25F);
                        } else {
                           _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var53, 1.25F, false);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") <= (double)2.0F) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.5F);
                           } else {
                              _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.75F);
                           } else {
                              _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var53, 0.75F, false);
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
                     double var70 = entity.getPersistentData().m_128459_("cnt6");
                     entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);
                     entity.getPersistentData().m_128347_("Damage", (double)35.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                     entity.getPersistentData().m_128347_("Range", (double)5.0F * var53);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, var54, var74, var58, entity);
                     entity.getPersistentData().m_128347_("Damage", (double)24.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                     entity.getPersistentData().m_128347_("Range", (double)10.0F * var53);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, var54, var74, var58, entity);
                     entity.getPersistentData().m_128347_("cnt6", var70);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F + var44 / (double)16.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)10.0F * var53);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var54, var74, var58, entity);
                  }

                  for(int index2 = 0; index2 < (int)((double)24.0F * var53); ++index2) {
                     double var47 = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)20.0F * var53);
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, var47, var47, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)4.0F), var54, var54 + (double)0.0F, var74 - (double)1.0F, var74 + (double)0.0F, (double)0.0F, var58, var58 + (double)0.0F, "jujutsucraft:particle_curse_power_blue");
                  }

                  for(int index3 = 0; index3 < (int)((double)8.0F * var53); ++index3) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)4.0F, var54, var54 + (double)0.0F, var74 - (double)1.0F, var74 + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)-0.5F), (double)0.0F, var58, var58 + (double)0.0F, "jujutsucraft:particle_curse_power_blue");
                  }
               }

               for(int index4 = 0; index4 < (int)((double)24.0F * var53); ++index4) {
                  double var48 = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)20.0F * var53);
                  ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, var48, var48, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)10.0F), var54, var54 + (double)0.0F, var74 - (double)1.0F, var74 + (double)0.0F, (double)0.0F, var58, var58 + (double)0.0F, "minecraft:crit");
               }

               for(int index5 = 0; index5 < (int)((double)8.0F * var53); ++index5) {
                  ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)8.0F, var54, var54 + (double)0.0F, var74 + (double)-1.0F, var74 + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)0.0F), (double)0.0F, var58, var58 + (double)0.0F, "minecraft:crit");
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F) {
                  for(int index6 = 0; index6 < (int)((double)8.0F * var53); ++index6) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)16.0F, var54, var54 + (double)0.0F, var74, var74 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, var58, var58 + (double)0.0F, "minecraft:crit");
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)8.0F, var54, var54 + (double)0.0F, var74, var74 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.5F), (double)0.0F, var58, var58 + (double)0.0F, "jujutsucraft:particle_curse_power_blue");
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") == (double)20.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 0.75F);
                        } else {
                           _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 1.25F);
                        } else {
                           _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 1.25F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 0.75F);
                        } else {
                           _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var74, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 1.25F);
                        } else {
                           _level.m_7785_(var54, var74, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(var53 * (double)2.0F), 1.25F, false);
                        }
                     }

                     entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                     entity.getPersistentData().m_128347_("BlockRange", var44 * (double)1.0F);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var54, var74, var58, entity);

                     for(int index7 = 0; index7 < (int)((double)64.0F * var53); ++index7) {
                        double var49 = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)20.0F * var53);
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, var49, var49 * var49, (double)0.0F, var54, var54 + (double)0.0F, var74 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)5.0F * var53), var74 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)5.0F * var53), (double)0.0F, var58, var58 + (double)0.0F, "explosion");
                     }

                     for(int index8 = 0; index8 < (int)((double)64.0F * var53); ++index8) {
                        double var50 = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)20.0F * var53);
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, var50, var50 * var50, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)16.0F), var54, var54 + (double)0.0F, var74 - (double)1.0F, var74 + (double)0.0F, (double)0.0F, var58, var58 + (double)0.0F, "jujutsucraft:particle_curse_power_blue");
                     }

                     int var10001;
                     label353: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label353;
                           }
                        }

                        var10001 = 0;
                     }

                     double var52 = (double)(20 + var10001 * 4);

                     for(int index9 = 0; index9 < 15; ++index9) {
                        double var51 = Mth.m_216263_(RandomSource.m_216327_(), (double)(2.0F + entity.m_20205_()), (double)10.0F * var53);
                        double var71 = Mth.m_216263_(RandomSource.m_216327_(), (double)-360.0F, (double)360.0F);
                        var54 = entity.getPersistentData().m_128459_("x_pos") + Math.cos(var71) * var51;
                        var74 = entity.getPersistentData().m_128459_("y_pos");
                        var58 = entity.getPersistentData().m_128459_("z_pos") + Math.sin(var71) * var51;
                        logic_a = false;
                        if (world.m_8055_(BlockPos.m_274561_(var54, var74, var58)).m_60815_()) {
                           var74 = entity.getPersistentData().m_128459_("y_pos");

                           for(int index10 = 0; index10 < (int)Math.round(var51 * (double)2.0F); ++index10) {
                              ++var74;
                              if (!world.m_8055_(BlockPos.m_274561_(var54, var74, var58)).m_60815_()) {
                                 logic_a = true;
                                 break;
                              }
                           }
                        } else if (!world.m_8055_(BlockPos.m_274561_(var54, var74 - (double)1.0F, var58)).m_60815_()) {
                           var74 = entity.getPersistentData().m_128459_("y_pos");

                           for(int index11 = 0; index11 < (int)Math.round(var51 * (double)2.0F); ++index11) {
                              --var74;
                              if (world.m_8055_(BlockPos.m_274561_(var54, var74 - (double)1.0F, var58)).m_60815_()) {
                                 logic_a = true;
                                 break;
                              }
                           }
                        } else {
                           logic_a = true;
                        }

                        if (logic_a && world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROCK_FRAGMENT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var54, var74, var58), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity218 = (LivingEntity)entityinstance;
                                 if (_livingEntity218.m_21204_().m_22171_(Attributes.f_22276_)) {
                                    _livingEntity218.m_21051_(Attributes.f_22276_).m_22100_(var52);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.m_21153_((float)var52);
                              }

                              entityinstance.m_20256_(new Vec3((Math.random() - (double)0.5F) * (double)3.0F, (Math.random() * (double)1.5F + (double)0.75F) * CNT6, (Math.random() - (double)0.5F) * (double)3.0F));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity224 = (LivingEntity)entityinstance;
                                 if (_livingEntity224.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    _livingEntity224.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((Math.random() + (double)1.5F) * CNT6);
                                 }
                              }

                              _serverLevel.m_7967_(entityinstance);
                           }
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_());
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F);
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_());
      }
   }
}
