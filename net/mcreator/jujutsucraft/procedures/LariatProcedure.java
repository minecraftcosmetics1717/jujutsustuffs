package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
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

public class LariatProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double old_cnt2 = (double)0.0F;
         double old_cnt1 = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
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

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)4.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > (double)12.0F) {
                     label285: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label286: {
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
                                    break label286;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label285;
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

               if (entity.getPersistentData().m_128471_("PRESS_Z") || !OnGroundProcedure.execute(world, entity)) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)4.0F));
               }

               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
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
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)12.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)6.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)10.0F * range), range * (double)0.25F, 0.1, range * (double)0.25F, (double)0.5F);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  LivingEntity var80;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var80 = _mobEnt.m_5448_();
                  } else {
                     var80 = null;
                  }

                  if (var80 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var80 = _mobEnt.m_5448_();
                     } else {
                        var80 = null;
                     }

                     double var82 = ((Entity)var80).m_20185_();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     double var83 = ((Entity)var10001).m_20186_();
                     LivingEntity var10002;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.m_5448_();
                     } else {
                        var10002 = null;
                     }

                     var83 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.m_5448_();
                     } else {
                        var10002 = null;
                     }

                     RotateEntityProcedure.execute(var82, var83, ((Entity)var10002).m_20189_(), entity);
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F * CNT6);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F * CNT6);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F * CNT6);
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity63 = (LivingEntity)entity;
                     if (_livingEntity63.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity63.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity64 = (LivingEntity)entity;
                     if (_livingEntity64.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity64.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
               if (entity.getPersistentData().m_128459_("cnt1") == (double)6.0F) {
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
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
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

               if (logic_a || entity.getPersistentData().m_128459_("cnt1") >= (double)12.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)12.0F);
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)1.25F);
               }

               ParticleGeneratorCircleProcedure.execute(world, (double)36.0F * range, entity.getPersistentData().m_128459_("pitch"), (double)1.0F * range, (double)2.0F * range, (double)4.0F, entity.m_20185_(), entity.m_20185_() - entity.getPersistentData().m_128459_("x_power") * range, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F - entity.getPersistentData().m_128459_("y_power") * range, entity.getPersistentData().m_128459_("yaw"), entity.m_20189_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power") * range, "minecraft:crit");
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)12.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               if (entity.getPersistentData().m_128459_("cnt1") == (double)13.0F) {
                  old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
                  old_cnt2 = entity.getPersistentData().m_128459_("cnt2");
                  entity.getPersistentData().m_128347_("cnt1", (double)9.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * (double)1.0F);
                  entity.getPersistentData().m_128347_("y_knockback", entity.getPersistentData().m_128459_("y_power") * (double)1.0F);
                  entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * (double)1.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity140 = (LivingEntity)entity;
                     if (_livingEntity140.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity140.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)1.0F);
                     }
                  }

                  AttackStrongPunchProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity141 = (LivingEntity)entity;
                     if (_livingEntity141.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity141.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt1", old_cnt1);
                  entity.getPersistentData().m_128347_("cnt2", old_cnt2);
                  entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
