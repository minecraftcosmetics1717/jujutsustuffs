package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityBroomEntity;
import net.mcreator.jujutsucraft.entity.EntitySlashEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class WindScytheProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double picth = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         picth = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(picth) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)1.0F * range, (double)90.0F, (double)0.5F * range, (double)0.75F * range, (double)1.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "cloud");
            ParticleGeneratorCircleProcedure.execute(world, (double)1.0F * range, (double)90.0F, (double)0.0F * range, (double)4.0F * range, (double)1.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "cloud");
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.9F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.9F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)1.0F);
            } else {
               ChargeParticleProcedure.execute(world, entity, (double)0.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)8.0F) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > (double)8.0F) {
                     label254: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label247: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                    break label247;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label254;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)8.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }
               }
            }

            LivingEntity var71;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var71 = _mobEnt.m_5448_();
            } else {
               var71 = null;
            }

            if (var71 instanceof LivingEntity && (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F || entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt6") < (double)4.0F)) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var71 = _mobEnt.m_5448_();
               } else {
                  var71 = null;
               }

               x_pos = ((Entity)var71).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var71 = _mobEnt.m_5448_();
               } else {
                  var71 = null;
               }

               double var74 = ((Entity)var71).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var74 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var75;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var75 = _mobEnt.m_5448_();
               } else {
                  var75 = null;
               }

               z_pos = ((Entity)var75).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }
         } else {
            LivingEntity var76;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var76 = _mobEnt.m_5448_();
            } else {
               var76 = null;
            }

            if (var76 instanceof LivingEntity) {
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

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity81 = (LivingEntity)entity;
                  if (_livingEntity81.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity81.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-6.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity.m_20202_() instanceof EntityBroomEntity) {
                  if (entity.m_20202_() instanceof EntityBroomEntity) {
                     PlayAnimationEntity2Procedure.execute(entity.m_20202_(), "attack");
                  }

                  Entity _ent = entity.m_20202_();
                  if (_ent instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)_ent;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               damage = entity.getPersistentData().m_128459_("cnt6");
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)(damage * (double)5.0F), 0.1 + damage * 0.2, 0.1 + damage * 0.2, 0.1 + damage * 0.2, (double)1.0F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.2F, 1.2F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.2F, 1.2F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.2F, 1.2F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.2F, 1.2F, false);
                  }
               }

               int var77;
               label195: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var77 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label195;
                     }
                  }

                  var77 = 0;
               }

               HP = (double)(20 + var77 * 5);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_SLASH.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                        LivingEntity _livingEntity103 = (LivingEntity)entityinstance;
                        if (_livingEntity103.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity103.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)6.0F);
                     entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)6.0F);
                     entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)6.0F);
                     entityinstance.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)6.0F, entity.m_20154_().f_82480_ * (double)6.0F, entity.m_20154_().f_82481_ * (double)6.0F));
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity124 = (LivingEntity)entityinstance;
                        if (_livingEntity124.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity124.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)2.0F * CNT6 * range);
                        }
                     }

                     if (entityinstance instanceof EntitySlashEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "vertical1");
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", (double)9.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
               entity.getPersistentData().m_128347_("Range", (double)6.0F);
               entity.getPersistentData().m_128347_("knockback", (double)2.0F);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt3") > (double)5.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
