package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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

public class TechniqueFootProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         entity.f_19789_ = 0.0F;
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
                     label221: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label215: {
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
                                    break label215;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label221;
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
               if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                  entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), (double)1.75F, entity.m_20184_().m_7094_()));
                  entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               } else if (entity.m_20184_().m_7098_() < 0.1 || entity.getPersistentData().m_128459_("cnt2") > (double)30.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") < (double)20.0F) {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") <= (double)2.0F) {
                  LivingEntity var55;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var55 = _mobEnt.m_5448_();
                  } else {
                     var55 = null;
                  }

                  if (var55 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var55 = _mobEnt.m_5448_();
                     } else {
                        var55 = null;
                     }

                     x_pos = ((Entity)var55).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var55 = _mobEnt.m_5448_();
                     } else {
                        var55 = null;
                     }

                     double var58 = ((Entity)var55).m_20186_();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var58 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                     LivingEntity var59;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var59 = _mobEnt.m_5448_();
                     } else {
                        var59 = null;
                     }

                     z_pos = ((Entity)var59).m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }

                  int var60;
                  label172: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var60 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label172;
                        }
                     }

                     var60 = 0;
                  }

                  HP = (double)(40 + var60 * 8);
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() - (double)(4.0F + entity.m_20206_());
                  z_pos = entity.m_20189_();
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.FOOT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(90.0F);
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
                           LivingEntity _livingEntity69 = (LivingEntity)entityinstance;
                           if (_livingEntity69.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity69.m_21051_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity76 = (LivingEntity)entityinstance;
                           if (_livingEntity76.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity76.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)4.0F * CNT6);
                           }
                        }

                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity80 = (LivingEntity)entity;
                     if (_livingEntity80.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity80.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity81 = (LivingEntity)entity;
                     if (_livingEntity81.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity81.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F) {
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
