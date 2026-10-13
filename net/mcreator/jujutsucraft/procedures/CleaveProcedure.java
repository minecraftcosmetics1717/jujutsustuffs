package net.mcreator.jujutsucraft.procedures;

import java.util.ArrayList;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class CleaveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_explode = false;
         Entity target_entity = null;
         double distance = (double)0.0F;
         double d = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double rad = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double size_height = (double)0.0F;
         double size_width = (double)0.0F;
         double speed = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 5, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(2.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var40 = var10000;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            label345: {
               label344: {
                  if (entity instanceof Player) {
                     if (entity.m_6144_()) {
                        break label344;
                     }
                  } else if (GetDistanceProcedure.execute(entity) > distance * (double)2.0F || Math.random() < (double)0.25F) {
                     break label344;
                  }

                  entity.getPersistentData().m_128347_("cnt1", (double)6.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  break label345;
               }

               entity.getPersistentData().m_128347_("cnt1", (double)6.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (var40 instanceof LivingEntity) {
               entity.m_7618_(Anchor.EYES, new Vec3(((Entity)var40).m_20185_(), ((Entity)var40).m_20186_() + (double)((Entity)var40).m_20206_() * (double)0.75F, ((Entity)var40).m_20189_()));
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)4.0F) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)4.0F));
            }

            ChargeParticleProcedure.execute(world, entity, (double)0.0F);
         }

         CNT6 = (double)1.0F;
         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)6.0F && entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               label369: {
                  if (entity instanceof Player) {
                     if (!entity.m_6144_()) {
                        break label369;
                     }
                  } else if (!(GetDistanceProcedure.execute(entity) > distance * (double)2.0F)) {
                     break label369;
                  }

                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               label355: {
                  if (entity.getPersistentData().m_128459_("cnt1") <= (double)16.0F) {
                     if (entity.getPersistentData().m_128459_("cnt1") % (double)2.0F != (double)0.0F) {
                        break label355;
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt1") != (double)22.0F) {
                     break label355;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") == (double)22.0F) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity46 = (LivingEntity)entity;
                        if (_livingEntity46.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity46.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
                        }
                     }

                     entity.getPersistentData().m_128347_("Damage", (double)19.0F + entity.getPersistentData().m_128459_("cnt1") * 0.1);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity50 = (LivingEntity)entity;
                        if (_livingEntity50.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity50.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)207.0F);
                        }
                     }

                     entity.getPersistentData().m_128347_("Damage", (double)17.0F + entity.getPersistentData().m_128459_("cnt1") * 0.1);
                     entity.getPersistentData().m_128347_("knockback", 0.01);
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  entity.getPersistentData().m_128347_("Range", distance * 2.4);
                  entity.getPersistentData().m_128347_("effect", (double)4.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 15, 0.1, 0.1, 0.1, (double)4.0F);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * (double)2.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                     entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
                     entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * (double)2.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                     entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * (double)2.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
                     entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * (double)2.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                  } else if (entity.m_20096_()) {
                     entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
                     entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                     entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                     entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
                     entity.m_146922_(entity.m_146908_());
                     entity.m_146926_(90.0F);
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
                     entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt3") > (double)120.0F) {
                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") >= (double)2.0F) {
                  if (entity.getPersistentData().m_128459_("cnt2") == (double)2.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.25F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity89 = (LivingEntity)entity;
                        if (_livingEntity89.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity89.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  entity.getPersistentData().m_128347_("Damage", (double)15.0F);
                  DamageFixProcedure.execute(entity);
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  d = Math.sqrt(entity.getPersistentData().m_128459_("Damage") * (double)1.0F);
                  logic_explode = entity.getPersistentData().m_128459_("cnt2") == (double)8.0F;
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
                  if (logic_explode) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                        }
                     }

                     entity.getPersistentData().m_128347_("BlockDamage", d * (double)1.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)8.0F * d * 0.1);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") <= (double)7.0F || logic_explode) {
                     int var10001;
                     label314: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label314;
                           }
                        }

                        var10001 = 0;
                     }

                     HP = (double)(20 + var10001 * 4);

                     for(int index0 = 0; index0 < 20; ++index0) {
                        dis = logic_explode ? (double)0.0F : (entity.getPersistentData().m_128459_("cnt2") - (double)3.0F) * (double)3.0F;

                        for(int index1 = 0; index1 < (logic_explode ? 15 : 3); ++index1) {
                           logic_a = false;
                           x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad) * dis;
                           y_pos = entity.getPersistentData().m_128459_("y_pos");
                           z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad) * dis;
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              y_pos = entity.getPersistentData().m_128459_("y_pos");

                              for(int index2 = 0; index2 < (int)Math.round(dis * (double)2.0F); ++index2) {
                                 ++y_pos;
                                 if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                                    logic_a = true;
                                    break;
                                 }
                              }
                           } else if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos)).m_60815_()) {
                              y_pos = entity.getPersistentData().m_128459_("y_pos");

                              for(int index3 = 0; index3 < (int)Math.round(dis * (double)2.0F); ++index3) {
                                 --y_pos;
                                 if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos)).m_60815_()) {
                                    logic_a = true;
                                    break;
                                 }
                              }
                           } else {
                              logic_a = true;
                           }

                           if (logic_a) {
                              if (logic_explode) {
                                 entity.getPersistentData().m_128347_("Damage", (double)15.0F);
                                 entity.getPersistentData().m_128347_("Range", (double)6.0F);
                                 entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 2, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 2, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.0F);
                                 }

                                 RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                                 if (Math.random() < 0.025 && world instanceof ServerLevel) {
                                    ServerLevel _serverLevel = (ServerLevel)world;
                                    Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROCK_FRAGMENT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                                    if (entityinstance != null) {
                                       entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                                       SetRangedAmmoProcedure.execute(entity, entityinstance);
                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _livingEntity123 = (LivingEntity)entityinstance;
                                          if (_livingEntity123.m_21204_().m_22171_(Attributes.f_22276_)) {
                                             _livingEntity123.m_21051_(Attributes.f_22276_).m_22100_(HP);
                                          }
                                       }

                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityinstance;
                                          _entity.m_21153_((float)HP);
                                       }

                                       entityinstance.m_20256_(new Vec3((Math.random() - (double)0.5F) * (double)3.0F, (Math.random() * (double)1.5F + (double)0.75F) * CNT6, (Math.random() - (double)0.5F) * (double)3.0F));
                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _livingEntity129 = (LivingEntity)entityinstance;
                                          if (_livingEntity129.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                             _livingEntity129.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((Math.random() + (double)1.0F) * CNT6);
                                          }
                                       }

                                       _serverLevel.m_7967_(entityinstance);
                                    }
                                 }
                              } else if (entity.getPersistentData().m_128459_("skill") != (double)106.0F) {
                                 if (entity.getPersistentData().m_128459_("skill") == (double)2108.0F && world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_DISMANTLE_ITADORI.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                                 }
                              } else {
                                 for(Entity entityiterator : new ArrayList(world.m_6907_())) {
                                    if (CanSeeSukunaSlashProcedure.execute(world, entity, entityiterator) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "particle jujutsucraft:particle_slash " + x_pos + " " + y_pos + " " + z_pos + " 0.1 0.1 0.1 0 " + Math.round(1.0F) + " normal");
                                    }
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                                 }
                              }
                           }

                           ++dis;
                        }

                        rad += Math.toRadians((double)18.0F);
                     }
                  }

                  entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
                  if (entity.getPersistentData().m_128459_("cnt2") >= (double)15.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               }
            }
         }

      }
   }
}
