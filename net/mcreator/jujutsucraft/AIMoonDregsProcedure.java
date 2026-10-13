package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIMoonDregsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_infinity = false;
         Entity entity_a = null;
         Entity owner_uuid = null;
         double x_target = (double)0.0F;
         double NUM2 = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double velocity = (double)0.0F;
         double yaw = (double)0.0F;
         double NUM1 = (double)0.0F;
         double dis = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double pitch = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity.m_6084_()) {
            label322: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               entity.f_19789_ = 0.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     break label322;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 60, 1, false, false));
                  }
               }
            }

            if (entity.m_20160_() && entity.m_146895_() instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2, 0, false, false));
                  }
               }

               Entity _entity = entity.m_146895_();
               if (_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2, 4, false, false));
                  }
               }

               _entity = entity.m_146895_();
               if (_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
                  }
               }

               _entity = entity.m_146895_();
               if (_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2, 0, false, false));
                  }
               }
            }

            double var10001;
            label316: {
               NUM1 = (double)(2L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.5F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity17 = (LivingEntity)entity;
                  if (_livingEntity17.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity17.m_21051_(Attributes.f_22281_).m_22115_();
                     break label316;
                  }
               }

               var10001 = (double)0.0F;
            }

            label311: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * (double)3.0F) / (double)4.0F, (double)3.0F)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt18 = (LivingEntity)entity;
                  if (_livEnt18.m_21023_(MobEffects.f_19600_)) {
                     break label311;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label306: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label306;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)NUM2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") > (double)100.0F) {
               LivingEntity var91;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.m_5448_();
               } else {
                  var91 = null;
               }

               if (var91 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.m_5448_();
                  } else {
                     var91 = null;
                  }

                  x_pos = ((Entity)var91).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.m_5448_();
                  } else {
                     var91 = null;
                  }

                  double var94 = ((Entity)var91).m_20186_();
                  LivingEntity var98;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var98 = _mobEnt.m_5448_();
                  } else {
                     var98 = null;
                  }

                  y_pos = var94 + (double)((Entity)var98).m_20206_() * (double)0.5F;
                  LivingEntity var95;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var95 = _mobEnt.m_5448_();
                  } else {
                     var95 = null;
                  }

                  z_pos = ((Entity)var95).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               if (!entity.m_20160_()) {
                  LivingEntity var96;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var96 = _mobEnt.m_5448_();
                  } else {
                     var96 = null;
                  }

                  if (var96 instanceof LivingEntity) {
                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                        ResetCounterProcedure.execute(entity);
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  }

                  if (entity.getPersistentData().m_128459_("skill") == (double)0.0F && entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                        logic_a = true;
                        yaw = (double)entity_a.m_146908_();
                        pitch = (double)entity_a.m_146909_();
                        x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + (double)(entity_a.m_6144_() ? 90 : 30))) * (double)3.0F * (double)(entity_a.m_6144_() ? 1 : -1);
                        y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F + (entity_a.m_6144_() ? Math.sin(pitch) * (double)-1.0F - (double)0.5F : (double)0.5F);
                        z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + (double)(entity_a.m_6144_() ? 90 : 30))) * (double)3.0F * (double)(entity_a.m_6144_() ? 1 : -1);
                        if (entity_a.m_6144_()) {
                           Vec3 _center = new Vec3(x, y + (double)(entity.m_20206_() / 2.0F), z);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)(2.0F + entity.m_20205_()) / (double)2.0F), (e) -> true)) {
                              if (entity != entityiterator) {
                                 velocity = (double)0.0F;
                                 x_power = (double)0.0F;
                                 y_power = (double)0.0F;
                                 z_power = (double)0.0F;
                                 logic_infinity = false;
                                 double var97;
                                 if (entityiterator instanceof Projectile) {
                                    Projectile _projEnt = (Projectile)entityiterator;
                                    var97 = _projEnt.m_20184_().m_82553_();
                                 } else {
                                    var97 = (double)0.0F;
                                 }

                                 if (var97 > (double)0.0F) {
                                    logic_infinity = false;
                                    velocity = Math.sqrt(Math.pow(entityiterator.m_20184_().m_7096_(), (double)2.0F) + Math.pow(entityiterator.m_20184_().m_7098_(), (double)2.0F) + Math.pow(entityiterator.m_20184_().m_7094_(), (double)2.0F));
                                    if (velocity > (double)0.0F) {
                                       x_power = entityiterator.m_20184_().m_7096_() / velocity;
                                       y_power = entityiterator.m_20184_().m_7098_() / velocity;
                                       z_power = entityiterator.m_20184_().m_7094_() / velocity;
                                       dis = Math.sqrt(Math.pow(entityiterator.m_20185_() - entity.m_20185_(), (double)2.0F) + Math.pow(entityiterator.m_20186_() - entity.m_20186_(), (double)2.0F) + Math.pow(entityiterator.m_20189_() - entity.m_20189_(), (double)2.0F));
                                       if (dis > Math.sqrt(Math.pow(entityiterator.m_20185_() + x_power * 0.001 - entity.m_20185_(), (double)2.0F) + Math.pow(entityiterator.m_20186_() + y_power * 0.001 - entity.m_20186_(), (double)2.0F) + Math.pow(entityiterator.m_20189_() + z_power * 0.001 - entity.m_20189_(), (double)2.0F))) {
                                          logic_infinity = true;
                                       }
                                    }
                                 }

                                 if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                                    logic_infinity = true;
                                    if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && (entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged") || entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged"))) {
                                       logic_infinity = false;
                                    }

                                    if (entity.getPersistentData().m_128459_("NameRanged") != (double)0.0F && (entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged") || entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged"))) {
                                       logic_infinity = false;
                                    }
                                 }

                                 if (logic_infinity) {
                                    if (!entity.getPersistentData().m_128471_("Stop")) {
                                       entityiterator.getPersistentData().m_128379_("Stop", true);
                                    }

                                    if (velocity > (double)0.0F) {
                                       entityiterator.m_20256_(new Vec3(x_power * 0.01, (double)0.0F, z_power * 0.01));
                                    } else {
                                       entityiterator.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                                    }
                                 }
                              }
                           }
                        }

                        if (Math.abs(x_target - entity.m_20185_()) > (double)0.5F) {
                           x_target = entity.m_20185_() + (entity.m_20185_() > x_target ? (double)-0.5F : (double)0.5F);
                        }

                        if (Math.abs(y_target - entity.m_20186_()) > (double)0.5F) {
                           y_target = entity.m_20186_() + (entity.m_20186_() > y_target ? (double)-0.5F : (double)0.5F);
                        }

                        if (Math.abs(z_target - entity.m_20189_()) > (double)0.5F) {
                           z_target = entity.m_20189_() + (entity.m_20189_() > z_target ? (double)-0.5F : (double)0.5F);
                        }

                        entity.m_6021_(x_target, y_target, z_target);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_target, y_target, z_target, entity.m_146908_(), entity.m_146909_());
                        }

                        entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? (double)0.0F : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                        entity.m_146922_(entity_a.m_146908_());
                        entity.m_146926_(entity_a.m_146909_());
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
                  }
               }
            } else {
               AIMoonDregsMove1Procedure.execute(world, entity);
            }
         }

         if (LogicOwnerExistProcedure.execute(world, entity)) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         } else if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

      }
   }
}
