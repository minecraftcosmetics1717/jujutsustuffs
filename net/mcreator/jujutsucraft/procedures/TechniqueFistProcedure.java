package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.phys.Vec3;

public class TechniqueFistProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         entity.f_19789_ = 0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
            if (entity.getPersistentData().m_128459_("cnt2") <= (double)1.0F) {
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
                     label232: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label224: {
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
                                    break label224;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label232;
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
                  entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)0.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }

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

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  ChargeParticleProcedure.execute(world, entity, (double)10.0F);
               } else {
                  ChargeParticleProcedure.execute(world, entity, (double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") >= (double)1.0F) {
               LivingEntity var61;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var61 = _mobEnt.m_5448_();
               } else {
                  var61 = null;
               }

               if (var61 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var61 = _mobEnt.m_5448_();
                  } else {
                     var61 = null;
                  }

                  x_pos = ((Entity)var61).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var61 = _mobEnt.m_5448_();
                  } else {
                     var61 = null;
                  }

                  double var64 = ((Entity)var61).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var64 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                  LivingEntity var65;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var65 = _mobEnt.m_5448_();
                  } else {
                     var65 = null;
                  }

                  z_pos = ((Entity)var65).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               }

               if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                  entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), (double)1.75F, entity.m_20184_().m_7094_()));
                  entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               } else if (entity.m_20184_().m_7098_() < 0.1 || entity.getPersistentData().m_128459_("cnt2") > (double)30.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") < (double)30.0F * CNT6) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity62 = (LivingEntity)entity;
                     if (_livingEntity62.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity62.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity63 = (LivingEntity)entity;
                     if (_livingEntity63.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity63.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               LivingEntity var66;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var66 = _mobEnt.m_5448_();
               } else {
                  var66 = null;
               }

               if (var66 instanceof LivingEntity) {
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

               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
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

               int var67;
               label177: {
                  entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), (double)0.0F, entity.m_20184_().m_7094_()));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var67 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label177;
                     }
                  }

                  var67 = 0;
               }

               HP = (double)(40 + var67 * 8);
               entity.getPersistentData().m_128347_("x_pos", (Math.random() - (double)0.5F) * (double)16.0F * CNT6);
               entity.getPersistentData().m_128347_("y_pos", Math.random() * (double)2.0F * CNT6);
               entity.getPersistentData().m_128347_("z_pos", (Math.random() - (double)0.5F) * (double)16.0F * CNT6);
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-6.0F * CNT6)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.getPersistentData().m_128459_("x_pos");
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-6.0F * CNT6)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.getPersistentData().m_128459_("y_pos");
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-6.0F * CNT6)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.getPersistentData().m_128459_("z_pos");
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.FIST.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
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
                        LivingEntity _livingEntity91 = (LivingEntity)entityinstance;
                        if (_livingEntity91.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity91.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", (double)2.5F);
                     entityinstance.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos"));
                     entityinstance.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos"));
                     entityinstance.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos"));
                     entityinstance.getPersistentData().m_128347_("speed", (double)0.5F);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity108 = (LivingEntity)entityinstance;
                        if (_livingEntity108.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity108.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)2.5F);
                        }
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

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
            } else {
               if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F * CNT6 + (double)30.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }

               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

      }
   }
}
