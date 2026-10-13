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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackOverheadSuperProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         boolean logic_a;
         int var10000;
         label301: {
            double strength = (double)0.0F;
            double distance = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double dis = (double)0.0F;
            double CNT6 = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            double x_power = (double)0.0F;
            double y_pos = (double)0.0F;
            double pitch = (double)0.0F;
            double old_cnt6 = (double)0.0F;
            Entity target_entity = null;
            SUCCESS = false;
            logic_a = false;
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label301;
               }
            }

            var10000 = 0;
         }

         double var38 = (double)Math.min(var10000, 50);
         double var42 = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + var38 * 0.025);
         double var52 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         double var43 = entity.m_20185_();
         double var59 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         double var46 = entity.m_20189_();
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         LivingEntity var94;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var94 = _mobEnt.m_5448_();
         } else {
            var94 = null;
         }

         Entity var64 = var94;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
            if (var64 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var64).m_20185_(), ((Entity)var64).m_20186_() + (double)((Entity)var64).m_20206_() * (double)0.5F, ((Entity)var64).m_20189_(), entity);
            }

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity23 = (LivingEntity)entity;
                  if (_livingEntity23.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity23.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-10.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity24 = (LivingEntity)entity;
                  if (_livingEntity24.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity24.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt3") >= (double)10.0F) {
               if (var64 instanceof LivingEntity) {
                  var43 = ((Entity)var64).m_20185_();
                  var59 = ((Entity)var64).m_20186_() + (double)(((Entity)var64).m_20206_() * 0.0F);
                  var46 = ((Entity)var64).m_20189_();
               } else {
                  double var50 = (double)6.0F;

                  for(int index0 = 0; index0 < 6; ++index0) {
                     var43 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var50)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
                     var59 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var50)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
                     var46 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var50)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
                     Vec3 _center = new Vec3(var43, var59, var46);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var43 = entityiterator.m_20185_();
                           var59 = entityiterator.m_20186_() + (double)(entityiterator.m_20206_() * 0.0F);
                           var46 = entityiterator.m_20189_();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     var50 += (double)6.0F;
                  }
               }

               double var57 = var43 - entity.m_20185_();
               double var53 = var59 - (entity.m_20186_() + (double)(entity.m_20206_() * 0.0F));
               double var55 = var46 - entity.m_20189_();
               double var39 = Math.sqrt(var57 * var57 + var53 * var53 + var55 * var55);
               if (var39 > (double)1.0F) {
                  var57 /= var39;
                  double var95 = var53 / var39;
                  var55 /= var39;
               }

               entity.getPersistentData().m_128347_("x_power", var57 * (double)1.0F);
               entity.getPersistentData().m_128347_("z_power", var55 * (double)1.0F);
               entity.getPersistentData().m_128347_("cnt7", var39 / (double)2.0F);
               entity.getPersistentData().m_128347_("cnt9", var59 - (entity.m_20186_() + (double)(entity.m_20206_() * 0.0F)));
               entity.getPersistentData().m_128347_("cnt10", Math.max(Math.sqrt(var39) * (double)3.0F, (double)3.0F));
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") != (double)0.0F) {
            if (var64 instanceof LivingEntity) {
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
                  LivingEntity _livingEntity76 = (LivingEntity)entity;
                  if (_livingEntity76.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity76.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-8.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity77 = (LivingEntity)entity;
                  if (_livingEntity77.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity77.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double var58 = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
               double var54 = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
               double var56 = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
               entity.m_20256_(new Vec3(var58, var54, var56));
               double var51 = Math.sqrt(var58 * var58 + var54 * var54 + var56 * var56);
               if (var51 != (double)0.0F) {
                  var58 /= var51;
                  var54 /= var51;
                  var56 /= var51;
               }

               var43 = entity.m_20185_();
               var59 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               var46 = entity.m_20189_();
               entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.1);
               entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.1);
               entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.1);

               for(int index1 = 0; index1 < (int)Math.max(var51, (double)1.0F); ++index1) {
                  entity.getPersistentData().m_128347_("Damage", (double)9.0F * var52);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F * var42);
                  entity.getPersistentData().m_128347_("knockback", 0.6);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, var43, var59, var46, entity);
                  Vec3 _center = new Vec3(var43, var59, var46);

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

                  var43 += var58;
                  var59 += var54;
                  var46 += var56;
               }

               entity.getPersistentData().m_128347_("Damage", (double)15.0F * var52);
               entity.getPersistentData().m_128379_("attack", true);
               DamageFixProcedure.execute(entity);
               entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               if (entity.m_20096_() && entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
                  double var49 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double var62 = Math.toRadians((double)0.0F);
                  double var40 = (double)(1.0F * entity.m_20205_());
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var49) * Math.cos(var62) * var40);
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + Math.sin(var62) * (double)-1.0F * var40);
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var49) * Math.cos(var62) * var40);
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity123 = (LivingEntity)entity;
                     if (_livingEntity123.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity123.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity124 = (LivingEntity)entity;
                     if (_livingEntity124.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity124.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
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
                     LivingEntity _livingEntity130 = (LivingEntity)entity;
                     if (_livingEntity130.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity130.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity131 = (LivingEntity)entity;
                     if (_livingEntity131.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity131.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               var43 = entity.getPersistentData().m_128459_("x_pos");
               var59 = entity.getPersistentData().m_128459_("y_pos");
               var46 = entity.getPersistentData().m_128459_("z_pos");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
                  if (entity.getPersistentData().m_128459_("cnt1") <= (double)3.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 0.75F);
                        } else {
                           _level.m_7785_(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 1.25F);
                        } else {
                           _level.m_7785_(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)var42, 1.25F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 0.75F);
                        } else {
                           _level.m_7785_(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 0.75F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 1.25F);
                        } else {
                           _level.m_7785_(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)var42, 1.25F, false);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") <= (double)2.0F) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.5F);
                           } else {
                              _level.m_7785_(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var59, var46), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.75F);
                           } else {
                              _level.m_7785_(var43, var59, var46, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)var42, 0.75F, false);
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
                     double var63 = entity.getPersistentData().m_128459_("cnt6");
                     entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);
                     entity.getPersistentData().m_128347_("Damage", (double)24.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                     entity.getPersistentData().m_128347_("Range", (double)8.0F * var42);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, var43, var59, var46, entity);
                     entity.getPersistentData().m_128347_("cnt6", var63);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F + var38 / (double)16.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)4.0F * var42);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var43, var59, var46, entity);
                  }

                  for(int index2 = 0; index2 < (int)((double)24.0F * var42); ++index2) {
                     double var41 = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)4.0F * var42);
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, var41, var41, Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)8.0F), var43, var43 + (double)0.0F, var59, var59 + (double)1.0F, (double)0.0F, var46, var46 + (double)0.0F, "minecraft:crit");
                  }

                  for(int index3 = 0; index3 < (int)((double)8.0F * var42); ++index3) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)8.0F, var43, var43 + (double)0.0F, var59, var59 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, var46, var46 + (double)0.0F, "minecraft:crit");
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)4.0F, var43, var43 + (double)0.0F, var59, var59 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.5F), (double)0.0F, var46, var46 + (double)0.0F, "minecraft:cloud");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
                  entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                  entity.getPersistentData().m_128347_("BlockRange", var38 * (double)1.0F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, var43, var59, var46, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F) {
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
