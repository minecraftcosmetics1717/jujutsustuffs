package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade13Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade23Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Test2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean logic_b = false;
         boolean logic_a = false;
         String STR2 = "";
         String STR1 = "";
         String DimensionID = "";
         double SpawnedStrength = (double)0.0F;
         double NUM2 = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double spawn_z = (double)0.0F;
         double yaw = (double)0.0F;
         double spawn_x = (double)0.0F;
         double NUM1 = (double)0.0F;
         double spawn_y = (double)0.0F;
         double level_strength = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double level_strength2 = (double)0.0F;
         double speed = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         if (entity.getPersistentData().m_128459_("data_cursed_spirit_manipulation1") != (double)0.0F && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               x_pos = (double)0.0F;
               z_pos = (double)0.0F;
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  Commands var10000 = entity.m_20194_().m_129892_();
                  CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                  long var10002 = Math.round(x_pos);
                  var10000.m_230957_(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
               }

               DimensionID = ("" + String.valueOf(entity.m_9236_().m_46472_())).replace("ResourceKey[minecraft:dimension / ", "").replace("]", "");
               Player = entity instanceof Player;
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               NUM1 = (double)0.0F;
               entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)45.0F));
               entity.m_146926_((float)Math.min(pitch, (double)0.0F));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (entity.m_6144_()) {
                  spawn_x = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                  spawn_y = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  spawn_z = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               } else {
                  spawn_x = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                  spawn_y = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  spawn_z = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               }

               speed = (double)6.5F;

               for(int index0 = 0; index0 < 10000; ++index0) {
                  ++NUM1;
                  STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                  SpawnedStrength = (double)0.0F;
                  if (entity.getPersistentData().m_128459_(STR1) == (double)0.0F) {
                     break;
                  }

                  String var94 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                  String var102 = entity.getPersistentData().m_128461_(STR1 + "_name");
                  if (var94.equals(var102 + " ×" + Math.round(entity.getPersistentData().m_128459_(STR1 + "_num")))) {
                     label231: {
                        y_pos = entity.getPersistentData().m_128459_(STR1);
                        logic_a = false;
                        logic_b = false;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt28 = (LivingEntity)entity;
                           if (_livEnt28.m_21023_(MobEffects.f_19600_)) {
                              label226: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var96 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label226;
                                    }
                                 }

                                 var96 = 0;
                              }

                              ++var96;
                              break label231;
                           }
                        }

                        var96 = 0;
                     }

                     level_strength = (double)var96;
                     if (world instanceof ServerLevel) {
                        ServerLevel _origLevel = (ServerLevel)world;
                        LevelAccessor var58 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                        if (var58 != null) {
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : var58.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
                              if (entity != entityiterator && entity.getPersistentData().m_128461_(STR1 + "_name").equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                                 if (!logic_a) {
                                    logic_a = true;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity36 = (LivingEntity)entity;
                                       if (_livingEntity36.m_21204_().m_22171_(Attributes.f_22281_)) {
                                          label207: {
                                             if (entityiterator instanceof LivingEntity) {
                                                LivingEntity _livEnt37 = (LivingEntity)entityiterator;
                                                if (_livEnt37.m_21023_(MobEffects.f_19600_)) {
                                                   label203: {
                                                      if (entityiterator instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                         if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                            var98 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                            break label203;
                                                         }
                                                      }

                                                      var98 = 0;
                                                   }

                                                   ++var98;
                                                   break label207;
                                                }
                                             }

                                             var98 = 0;
                                          }

                                          level_strength2 = (double)var98;
                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livingEntity40 = (LivingEntity)entityiterator;
                                             if (_livingEntity40.m_21204_().m_22171_(Attributes.f_22281_)) {
                                                label195: {
                                                   var99 = _livingEntity40.m_21051_(Attributes.f_22281_);
                                                   if (entityiterator instanceof LivingEntity) {
                                                      LivingEntity _livingEntity39 = (LivingEntity)entityiterator;
                                                      if (_livingEntity39.m_21204_().m_22171_(Attributes.f_22281_)) {
                                                         var103 = _livingEntity39.m_21051_(Attributes.f_22281_).m_22115_();
                                                         break label195;
                                                      }
                                                   }

                                                   var103 = (double)0.0F;
                                                }

                                                var99.m_22100_(Math.max(var103, level_strength * (double)3.0F * (double)0.5F * ((Math.max(level_strength * (double)3.0F, (double)1.0F) - Math.max(level_strength2 * (double)3.0F, (double)1.0F)) / Math.max(level_strength * (double)3.0F, (double)1.0F))));
                                             }
                                          }
                                       }
                                    }

                                    label190: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var100 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label190;
                                          }
                                       }

                                       var100 = 0;
                                    }

                                    if (var100 >= 8) {
                                       entity.getPersistentData().m_128347_("cnt1", (double)-5.0F);
                                    }

                                    entityiterator.getPersistentData().m_128347_("cnt_target", (double)0.0F);
                                    entityiterator.getPersistentData().m_128347_("modement_mode", (double)0.0F);
                                    entityiterator.getPersistentData().m_128347_("cnt_settarget", (double)0.0F);
                                    entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                                    entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                                    entityiterator.getPersistentData().m_128379_("Player", Player);
                                    entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                                    entityiterator.getPersistentData().m_128359_("TARGET_UUID", "");
                                    entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                                    entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "data merge entity @s {Invulnerable:0b,NoAI:0b}");
                                    }

                                    entityiterator.m_146922_((float)yaw);
                                    entityiterator.m_146926_((float)pitch);
                                    entityiterator.m_5618_(entityiterator.m_146908_());
                                    entityiterator.m_5616_(entityiterator.m_146908_());
                                    entityiterator.f_19859_ = entityiterator.m_146908_();
                                    entityiterator.f_19860_ = entityiterator.m_146909_();
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       _entity.f_20884_ = _entity.m_146908_();
                                       _entity.f_20886_ = _entity.m_146908_();
                                    }

                                    label181: {
                                       entityiterator.m_5997_((double)0.0F, (double)0.0F, (double)0.0F);
                                       entityiterator.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                                       entity.getPersistentData().m_128347_(STR1 + "_num", (double)0.0F);
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var101 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label181;
                                          }
                                       }

                                       var101 = (double)0.0F;
                                    }

                                    SpawnedStrength = var101;
                                    if (entityiterator instanceof CursedSpiritGrade13Entity || entityiterator instanceof CursedSpiritGrade23Entity) {
                                       ResetCounterProcedure.execute(entityiterator);
                                       entityiterator.m_5997_(entityiterator.m_20154_().f_82479_ * speed, entityiterator.m_20154_().f_82480_ * speed, entityiterator.m_20154_().f_82481_ * speed);
                                       entityiterator.m_20256_(new Vec3(entityiterator.m_20154_().f_82479_ * speed, entityiterator.m_20154_().f_82480_ * speed, entityiterator.m_20154_().f_82481_ * speed));
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                                          }
                                       }

                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                          }
                                       }

                                       entityiterator.getPersistentData().m_128347_("skill", (double)1706.0F);
                                       entityiterator.getPersistentData().m_128347_("cnt1", (double)6.0F);
                                       entityiterator.getPersistentData().m_128347_("cnt6", (double)-2.5F);
                                       entityiterator.getPersistentData().m_128347_("yaw", (double)entityiterator.m_146908_());
                                       entityiterator.getPersistentData().m_128347_("pitch", (double)entityiterator.m_146909_());
                                       entityiterator.getPersistentData().m_128347_("x_power", entityiterator.m_20154_().f_82479_ * speed * (double)0.5F);
                                       entityiterator.getPersistentData().m_128347_("y_power", entityiterator.m_20154_().f_82480_ * speed * (double)0.5F);
                                       entityiterator.getPersistentData().m_128347_("z_power", entityiterator.m_20154_().f_82481_ * speed * (double)0.5F);
                                    }

                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "execute in " + DimensionID + " run tp @s " + spawn_x + " " + spawn_y + " " + spawn_z);
                                    }

                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "execute in " + DimensionID + " run particle squid_ink " + spawn_x + " " + spawn_y + " " + spawn_z + " 0.5 0.5 0.5 0 25 normal");
                                    }
                                 } else {
                                    entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR1 + "_num") + (double)1.0F);
                                 }
                              }
                           }
                        }

                        world = world;
                     }

                     if (entity.getPersistentData().m_128459_(STR1 + "_num") == (double)0.0F) {
                        NUM2 = NUM1;

                        for(int index1 = 0; index1 < 10000; ++index1) {
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM2);
                           STR2 = "data_cursed_spirit_manipulation" + Math.round(NUM2 + (double)1.0F);
                           entity.getPersistentData().m_128347_(STR1, entity.getPersistentData().m_128459_(STR2));
                           entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR2 + "_num"));
                           entity.getPersistentData().m_128359_(STR1 + "_name", entity.getPersistentData().m_128461_(STR2 + "_name"));
                           if (entity.getPersistentData().m_128459_(STR2) == (double)0.0F) {
                              break;
                           }

                           ++NUM2;
                        }

                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                     }

                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - Math.max(SpawnedStrength * (double)5.0F, (double)5.0F);
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     break;
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
            }
         } else {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

         if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
