package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CalculateAttackProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean success;
         boolean danger;
         double rnd;
         double ticks;
         double level;
         boolean var10000;
         label534: {
            success = false;
            danger = false;
            boolean logic_attack = false;
            boolean can_run_attack = false;
            boolean can_bullet_attack = false;
            boolean can_jump_attack = false;
            boolean can_overhead_attack = false;
            boolean can_swim_attack = false;
            boolean cooltime_combat = false;
            boolean can_speed_attack = false;
            boolean cooltime_default = false;
            boolean logic_rifle = false;
            rnd = (double)0.0F;
            double distance1 = (double)0.0F;
            ticks = (double)0.0F;
            level = (double)0.0F;
            double weapon_size = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double attack_reach = (double)0.0F;
            double pitch = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double dis = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = 1;
                  break label534;
               }
            }

            var10000 = 0;
         }

         boolean var52;
         label529: {
            var52 = (boolean)var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                  break label529;
               }
            }

            var10000 = 0;
         }

         label569: {
            boolean var54 = var10000 > 0;
            if (!var52 || !var54) {
               label568: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt2 = (LivingEntity)entity;
                     if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label568;
                     }
                  }

                  if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     double var57 = GetWeaponSizeProcedure.execute(entity);
                     double var61 = GetReachProcedure.execute(entity);
                     double var58 = ReturnEntitySizeProcedure.execute(entity);
                     var58 = var58 * var58 * Math.sqrt(var57 * var61);
                     double var65 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     double var62 = Math.toRadians((double)entity.m_146909_());
                     double var66 = (double)2.5F * var58;
                     double var60 = entity.m_20185_() + Math.cos(var65) * Math.cos(var62) * var66;
                     double var63 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(var62) * (double)-1.0F * var66;
                     double var64 = entity.m_20189_() + Math.sin(var65) * Math.cos(var62) * var66;
                     Vec3 _center = new Vec3(var60, var63, var64);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F * var58 / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator) {
                           if (entityiterator instanceof Projectile) {
                              if (DetectEnemyProjectileProcedure.execute(entity, entityiterator)) {
                                 danger = true;
                                 break;
                              }
                           } else {
                              boolean var47 = LogicAttackProcedure.execute(world, entity, entityiterator);
                              if (var47) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt12 = (LivingEntity)entity;
                                    if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       label501: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt13 = (LivingEntity)entity;
                                             if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                break label501;
                                             }
                                          }

                                          if (!AntiInfinityProcedure.execute(entityiterator)) {
                                             continue;
                                          }
                                       }
                                    }
                                 }

                                 if (entityiterator.getPersistentData().m_128459_("Damage") > (double)0.0F && entityiterator.getPersistentData().m_128459_("skill") > (double)0.0F && entityiterator.m_6084_()) {
                                    danger = true;
                                    break;
                                 }

                                 if (var47 && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                                    danger = true;
                                    break;
                                 }
                              }
                           }
                        }
                     }

                     double var56;
                     label484: {
                        var56 = GetDistanceProcedure.execute(entity);
                        if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:cant_barrage_attack"))) && !var54) {
                           label480: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                                    var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).m_19564_();
                                    break label480;
                                 }
                              }

                              var10000 = 0;
                           }

                           if (var10000 < 1) {
                              var10000 = 1;
                              break label484;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var49;
                     label473: {
                        label472: {
                           var49 = (boolean)var10000;
                           if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:jumping_attackable")))) {
                              label469: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                       var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                                       break label469;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 <= 3) {
                                 if (!(entity instanceof LivingEntity)) {
                                    break label472;
                                 }

                                 LivingEntity _livEnt23 = (LivingEntity)entity;
                                 if (!_livEnt23.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                    break label472;
                                 }
                              }
                           }

                           if (!var52 && var56 > (double)8.0F && var56 < (double)32.0F && !danger) {
                              var10000 = 1;
                              break label473;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var50;
                     label454: {
                        label453: {
                           label541: {
                              var50 = (boolean)var10000;
                              if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:running_attackable")))) {
                                 label449: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                          var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                                          break label449;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (var10000 <= 3) {
                                    label542: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt26 = (LivingEntity)entity;
                                          if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                                             break label542;
                                          }
                                       }

                                       if (!(entity instanceof LivingEntity)) {
                                          break label541;
                                       }

                                       LivingEntity _livEnt27 = (LivingEntity)entity;
                                       if (!_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                          break label541;
                                       }
                                    }
                                 }
                              }

                              if (!var52) {
                                 label438: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                          var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                          break label438;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (var10000 < 1) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label453;
                                    }

                                    LivingEntity _livEnt29 = (LivingEntity)entity;
                                    if (!_livEnt29.m_21023_(MobEffects.f_19612_)) {
                                       break label453;
                                    }
                                 }
                              }
                           }

                           var10000 = 0;
                           break label454;
                        }

                        var10000 = 1;
                     }

                     boolean var48;
                     label421: {
                        label420: {
                           var48 = (boolean)var10000;
                           if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:overhead_attackable")))) {
                              label417: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                       var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                                       break label417;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 <= 3) {
                                 label543: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt32 = (LivingEntity)entity;
                                       if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                          break label543;
                                       }
                                    }

                                    if (!(entity instanceof LivingEntity)) {
                                       break label420;
                                    }

                                    LivingEntity _livEnt33 = (LivingEntity)entity;
                                    if (!_livEnt33.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                       break label420;
                                    }
                                 }
                              }
                           }

                           if (!var52 && var56 < (double)8.0F) {
                              var10000 = 1;
                              break label421;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var51;
                     label400: {
                        label572: {
                           var51 = (boolean)var10000;
                           if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:speed_attackable"))) || !(Math.random() < 0.2)) {
                              label570: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt35 = (LivingEntity)entity;
                                    if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                       break label570;
                                    }
                                 }

                                 if (!(entity instanceof LivingEntity)) {
                                    break label572;
                                 }

                                 LivingEntity _livEnt36 = (LivingEntity)entity;
                                 if (!_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                    break label572;
                                 }
                              }
                           }

                           if (!var52 && var56 > (double)8.0F && var56 < (double)24.0F) {
                              var10000 = 1;
                              break label400;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var53 = (boolean)var10000;
                     boolean var55 = LogicRifleProcedure.execute(world, entity);
                     int index0 = 0;

                     while(true) {
                        if (index0 >= 32) {
                           break label569;
                        }

                        if (var52) {
                           rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 3);
                        } else {
                           rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 7);
                        }

                        label546: {
                           if (rnd >= (double)1.0F && rnd <= (double)3.0F) {
                              if (rnd == (double)1.0F && Math.random() < (var49 ? (double)0.5F : (double)0.75F)) {
                                 break label546;
                              }

                              if (rnd == (double)2.0F) {
                              }

                              if (rnd == (double)3.0F && !var49) {
                                 break label546;
                              }
                           }

                           if (!(rnd >= (double)4.0F) || !(rnd <= (double)7.0F) || (rnd != (double)4.0F || var50) && (rnd != (double)5.0F || var48) && (rnd != (double)6.0F || var51) && (rnd != (double)7.0F || var53)) {
                              if (var56 > (double)20.0F * var58) {
                                 if (rnd == (double)4.0F || rnd == (double)5.0F) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var56 > (double)10.0F * var58) {
                                 if (rnd == (double)4.0F || rnd == (double)5.0F || rnd == (double)7.0F) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var56 > (double)5.0F * var58) {
                                 if (rnd == (double)4.0F || rnd == (double)5.0F || rnd == (double)6.0F || rnd == (double)7.0F) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var56 > (double)2.5F * var58) {
                                 if (rnd == (double)1.0F || rnd == (double)2.0F || rnd == (double)3.0F || rnd == (double)5.0F || rnd == (double)6.0F) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (rnd == (double)1.0F || rnd == (double)2.0F || rnd == (double)3.0F || rnd == (double)5.0F || rnd == (double)6.0F) {
                                 success = true;
                                 break label569;
                              }

                              if (danger) {
                                 if ((rnd == (double)3.0F || !(Math.random() < (double)0.75F)) && rnd != (double)2.0F && rnd != (double)4.0F) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var55 && var56 > (double)6.0F && var56 < (double)24.0F && (rnd == (double)1.0F || rnd == (double)2.0F || rnd == (double)3.0F)) {
                                 success = true;
                                 break label569;
                              }
                           }
                        }

                        ++index0;
                     }
                  }
               }
            }

            success = false;
         }

         if (success) {
            entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), (double)0.0F));
            if (rnd == (double)1.0F) {
               ticks = (double)5.0F;
               level = (double)1.0F;
            } else if (rnd == (double)2.0F) {
               ticks = (double)15.0F;
               level = (double)1.0F;
            } else if (rnd == (double)3.0F) {
               ticks = (double)20.0F;
               level = (double)1.0F;
            } else if (rnd == (double)4.0F) {
               ticks = (double)100.0F;
               level = (double)0.0F;
            } else if (rnd == (double)5.0F) {
               ticks = (double)200.0F;
               level = (double)0.0F;
            } else if (rnd == (double)6.0F) {
               ticks = (double)50.0F;
               level = (double)0.0F;
            } else if (rnd == (double)7.0F) {
               ticks = (double)50.0F;
               level = (double)0.0F;
            }

            ResetCounterProcedure.execute(entity);
            entity.getPersistentData().m_128347_("skill", (double)4199.0F + rnd);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
               }
            }

            if (level > (double)0.0F) {
               ItemStack var104;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var104 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
               } else {
                  var104 = ItemStack.f_41583_;
               }

               if (var104.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                  ticks *= (double)0.5F;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity45 = (LivingEntity)entity;
                  if (_livingEntity45.m_21204_().m_22171_(Attributes.f_22283_)) {
                     double var10003;
                     label269: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity46 = (LivingEntity)entity;
                           if (_livingEntity46.m_21204_().m_22171_(Attributes.f_22283_)) {
                              var10003 = _livingEntity46.m_21051_(Attributes.f_22283_).m_22135_();
                              break label269;
                           }
                        }

                        var10003 = (double)0.0F;
                     }

                     ticks += (double)20.0F * Math.max(1.7 - var10003, (double)0.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(ticks), 1, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(ticks), 0, false, false));
               }
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
               LivingEntity var105;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var105 = _mobEnt.m_5448_();
               } else {
                  var105 = null;
               }

               LivingEntity _entity = var105;
               if (_entity instanceof LivingEntity) {
                  LivingEntity _livEnt51 = _entity;
                  if (_livEnt51.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                     }

                     KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
                  }
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), (double)0.0F));
         }

      }
   }
}
