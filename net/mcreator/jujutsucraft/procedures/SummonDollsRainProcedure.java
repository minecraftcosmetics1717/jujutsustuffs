package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.Doll1Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class SummonDollsRainProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         double size = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double NUM1 = (double)0.0F;
         double picth = (double)0.0F;
         double yaw = (double)0.0F;
         double HP = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var68 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var69 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var69 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var68, var69, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)6.0F) {
                  label238: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label239: {
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
                                 break label239;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label238;
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

               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }

                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)10.0F);
            } else {
               ChargeParticleProcedure.execute(world, entity, (double)0.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity46 = (LivingEntity)entity;
                  if (_livingEntity46.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity46.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-7.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") % (double)2.0F == (double)1.0F) {
               if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F) + Mth.m_216263_(RandomSource.m_216327_(), (double)-90.0F, (double)90.0F));
               pitch = Math.toRadians((double)0.0F);
               distance = (double)(5.0F + entity.m_20205_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)(entity.m_20206_() * 0.0F) + Math.sin(pitch) * (double)-1.0F * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (entity.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("NameRanged", Math.random());
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.DOLL_1.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                        if (_livingEntity64.m_21204_().m_22171_(Attributes.f_22281_)) {
                           AttributeInstance var63;
                           double var65;
                           label199: {
                              var63 = _livingEntity64.m_21051_(Attributes.f_22281_);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity60 = (LivingEntity)entityinstance;
                                 if (_livingEntity60.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var65 = _livingEntity60.m_21051_(Attributes.f_22281_).m_22115_();
                                    break label199;
                                 }
                              }

                              var65 = (double)0.0F;
                           }

                           int var67;
                           label194: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt61 = (LivingEntity)entity;
                                 if (_livEnt61.m_21023_(MobEffects.f_19600_)) {
                                    label190: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var67 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label190;
                                          }
                                       }

                                       var67 = 0;
                                    }

                                    ++var67;
                                    break label194;
                                 }
                              }

                              var67 = 0;
                           }

                           var63.m_22100_(var65 + (double)(1 * var67 * 3));
                        }
                     }

                     CompoundTag var64;
                     double var66;
                     label184: {
                        var64 = entityinstance.getPersistentData();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                              var66 = (double)_livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                              break label184;
                           }
                        }

                        var66 = (double)0.0F;
                     }

                     var64.m_128347_("LevelResistance", var66);
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(0.0F);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     if (entityinstance instanceof Doll1Entity) {
                        Doll1Entity _datEntSetI = (Doll1Entity)entityinstance;
                        _datEntSetI.m_20088_().m_135381_(Doll1Entity.DATA_move, 1);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 100, 0, false, false));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") % (double)4.0F == (double)1.0F) {
                        entityinstance.getPersistentData().m_128347_("skill", (double)1706.0F);
                        entityinstance.getPersistentData().m_128347_("cnt1", (double)5.0F);
                     } else {
                        entityinstance.getPersistentData().m_128347_("skill", (double)2004.0F);
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", (double)-2.5F + entity.getPersistentData().m_128459_("cnt6"));
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
