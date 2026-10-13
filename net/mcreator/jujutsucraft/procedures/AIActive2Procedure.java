package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

public class AIActive2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         ItemStack mainItem = ItemStack.f_41583_;
         ItemStack offItem = ItemStack.f_41583_;
         boolean logic_guard = false;
         boolean logic_heal = false;
         boolean logic_heal_cancel = false;
         boolean test = false;
         boolean target = false;
         boolean logic_avoid = false;
         boolean using = false;
         boolean output = false;
         boolean infinity = false;
         boolean using2 = false;
         double x_knockback = (double)0.0F;
         double y_knockback = (double)0.0F;
         double z_knockback = (double)0.0F;
         double dis = (double)0.0F;
         double old_skill = (double)0.0F;
         double limit = (double)0.0F;
         double distance = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double fix = (double)0.0F;
         double x_power = (double)0.0F;
         double speed = (double)0.0F;
         double level_neutralization = (double)0.0F;
         logic_heal_cancel = true;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         label754: {
            var54 = var10000;
            entity.getPersistentData().m_128347_("cnt_guard", Math.max(entity.getPersistentData().m_128459_("cnt_guard") - (double)1.0F, (double)0.0F));
            entity.getPersistentData().m_128347_("cnt_backstep", Math.max(entity.getPersistentData().m_128459_("cnt_backstep") - (double)1.0F, (double)0.0F));
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  var133 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                  break label754;
               }
            }

            var133 = (double)0.0F;
         }

         level_neutralization = var133;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt6 = (LivingEntity)entity;
            if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()) && level_neutralization == (double)37.0F) {
               return;
            }
         }

         if (entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
            test = entity.getPersistentData().m_128459_("cnt_target") % (double)5.0F == (double)4.0F;
            target = var54 instanceof LivingEntity;
         }

         distance = (double)99.0F;
         if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            if (target) {
               label743: {
                  label742: {
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entity;
                        if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                           if (!(entity instanceof LivingEntity)) {
                              break label742;
                           }

                           LivingEntity _livEnt12 = (LivingEntity)entity;
                           if (!_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label742;
                           }
                        }
                     }

                     var134 = false;
                     break label743;
                  }

                  var134 = true;
               }

               infinity = var134;
               if (test) {
                  logic_heal_cancel = false;
               }

               label761: {
                  label762: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                           break label762;
                        }
                     }

                     if (((Entity)var54).getPersistentData().m_128459_("skill") == (double)0.0F || !(((Entity)var54).getPersistentData().m_128459_("Damage") > (double)0.0F)) {
                        break label761;
                     }
                  }

                  if (!infinity || AntiInfinityProcedure.execute(var54)) {
                     logic_heal_cancel = true;
                     if (test) {
                        logic_guard = true;
                     }
                  }
               }

               if (test) {
                  if (!logic_guard) {
                     label716: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt16 = (LivingEntity)entity;
                           if (_livEnt16.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                              break label716;
                           }
                        }

                        if (level_neutralization > (double)0.0F && level_neutralization != (double)37.0F) {
                           logic_guard = true;
                        }
                     }
                  }

                  if (!logic_guard) {
                     label709: {
                        dis = (double)24.0F;
                        if (!(entity instanceof UroTakakoEntity)) {
                           if (!(entity instanceof LivingEntity)) {
                              break label709;
                           }

                           LivingEntity _livEnt18 = (LivingEntity)entity;
                           if (!_livEnt18.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label709;
                           }
                        }

                        dis = (double)36.0F;
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && (!infinity || AntiInfinityProcedure.execute(entityiterator))) {
                           if (entityiterator instanceof Projectile) {
                              if (DetectEnemyProjectileProcedure.execute(entity, entityiterator)) {
                                 logic_avoid = true;
                                 logic_guard = true;
                                 break;
                              }
                           } else if ((entityiterator.getPersistentData().m_128459_("skill") != (double)0.0F || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) && entityiterator.getPersistentData().m_128459_("Damage") > (double)0.0F && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              logic_avoid = true;
                              logic_guard = true;
                              break;
                           }
                        }
                     }
                  }

                  if (!logic_guard) {
                     dis = (double)16.0F;
                     if (entity instanceof UroTakakoEntity) {
                        dis = (double)32.0F;
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && (!infinity || AntiInfinityProcedure.execute(entityiterator)) && entityiterator.getPersistentData().m_128459_("skill") != (double)0.0F && (entityiterator.getPersistentData().m_128459_("Damage") > (double)0.0F || entityiterator.getPersistentData().m_128471_("PRESS_Z")) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_avoid = true;
                           logic_guard = true;
                           break;
                        }
                     }
                  }

                  if (logic_avoid) {
                     label768: {
                        if (entity.getPersistentData().m_128459_("skill") != (double)0.0F) {
                           logic_avoid = false;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt32 = (LivingEntity)entity;
                           if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              label659: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var135 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                       break label659;
                                    }
                                 }

                                 var135 = 0;
                              }

                              if (var135 < 6) {
                                 logic_avoid = false;
                              }
                              break label768;
                           }
                        }

                        logic_avoid = false;
                     }
                  }

                  if (entity.getPersistentData().m_128471_("CursedSpirit") && entity instanceof LivingEntity) {
                     LivingEntity _livEnt35 = (LivingEntity)entity;
                     if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        logic_avoid = true;
                     }
                  }
               }

               logic_heal_cancel = logic_heal_cancel || logic_guard;
               if (!logic_avoid && (!infinity || AntiInfinityProcedure.execute(var54))) {
                  label645: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           var136 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                           break label645;
                        }
                     }

                     var136 = 0;
                  }

                  if (var136 > 10 || entity.getPersistentData().m_128459_("cnt_x") < (double)0.0F) {
                     label639: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              var137 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                              break label639;
                           }
                        }

                        var137 = 0;
                     }

                     if (var137 > 0) {
                        label632: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 var138 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                 break label632;
                              }
                           }

                           var138 = 0;
                        }

                        if (var138 > 10 && distance < (double)6.0F) {
                           logic_avoid = true;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt40 = (LivingEntity)entity;
                        if (_livEnt40.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && distance < (double)24.0F && ((Entity)var54).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var54).getPersistentData().m_128459_("skill") > (double)-900.0F) {
                           logic_avoid = true;
                        }
                     }
                  }
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:no_guard")))) {
                  logic_guard = false;
               }

               logic_heal_cancel = logic_heal_cancel || logic_avoid;
            } else {
               logic_heal_cancel = false;
            }
         }

         if (logic_guard) {
            StartGuardProcedure.execute(world, entity);
            entity.m_6858_(false);
            entity.getPersistentData().m_128347_("cnt_guard", (double)20.0F);
            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
               label612: {
                  if (var54 instanceof LivingEntity) {
                     if (!(((Entity)var54).getPersistentData().m_128459_("skill") % (double)100.0F > (double)2.0F) || ((Entity)var54).getPersistentData().m_128471_("attack") || !(var54 instanceof LivingEntity)) {
                        break label612;
                     }

                     LivingEntity _livEnt50 = var54;
                     if (!_livEnt50.m_21023_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                        break label612;
                     }
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     CommandSourceStack var10001;
                     float var10002;
                     label598: {
                        var139 = entity.m_20194_().m_129892_();
                        var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10002 = (float)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label598;
                           }
                        }

                        var10002 = 0.0F;
                     }

                     var139.m_230957_(var10001, "effect give @s jujutsucraft:domain_amplification 1 " + Math.round(var10002) + " false");
                  }
               }
            }
         }

         if (logic_avoid && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:no_guard")))) {
            if (entity.m_20096_() && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               entity.getPersistentData().m_128379_("PRESS_S", true);
               WhenBackStepProcedure.execute(world, entity);
               entity.getPersistentData().m_128379_("PRESS_S", false);
               entity.getPersistentData().m_128347_("cnt_backstep", (double)20.0F);
               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  _entity.m_21573_().m_26573_();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt60 = (LivingEntity)entity;
               if (_livEnt60.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                  entity.getPersistentData().m_128347_("mode_fly", (double)(Math.random() < (double)0.5F ? -2 : -3));
               }
            }
         }

         if (test && (logic_avoid || Math.random() < 0.2) && GetDistanceProcedure.execute(entity) > (double)8.0F && entity instanceof LivingEntity) {
            LivingEntity _livEnt62 = (LivingEntity)entity;
            if (_livEnt62.m_21023_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
               KeySpaceOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

         float var140;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var140 = _livEnt.m_21233_();
         } else {
            var140 = -1.0F;
         }

         label810: {
            limit = (double)(var140 >= 800.0F ? 150 : 50);
            if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique"))) && (!entity.getPersistentData().m_128441_("entity_can_use_rct") || !entity.getPersistentData().m_128471_("entity_can_use_rct"))) {
               if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                  break label810;
               }

               GojoSatoruSchoolDaysEntity _datEntL67 = (GojoSatoruSchoolDaysEntity)entity;
               if (!(Boolean)_datEntL67.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                  break label810;
               }
            }

            output = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique_output")));
            if (!logic_heal_cancel) {
               if (distance < (double)8.0F) {
                  label775: {
                     logic_heal_cancel = true;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var140 = _livEnt.m_21223_();
                     } else {
                        var140 = -1.0F;
                     }

                     double var142 = (double)var140;
                     float var149;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var149 = _livEnt.m_21233_();
                     } else {
                        var149 = -1.0F;
                     }

                     if (var142 <= (double)var149 * (double)0.5F) {
                        logic_heal_cancel = false;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt71 = (LivingEntity)entity;
                        if (_livEnt71.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break label775;
                        }
                     }

                     label565: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var143 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                              break label565;
                           }
                        }

                        var143 = 0;
                     }

                     if (var143 >= 1) {
                        logic_heal_cancel = false;
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var140 = _livEnt.m_21223_();
               } else {
                  var140 = -1.0F;
               }

               float var150;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var150 = _livEnt.m_21233_();
               } else {
                  var150 = -1.0F;
               }

               if (var140 >= var150) {
                  logic_heal_cancel = true;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_reverse_lim") + (double)1.0F >= limit) {
               logic_heal_cancel = true;
               output = false;
            }

            if (output) {
               output = false;
               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:cant_combat"))) || entity.getPersistentData().m_128459_("cnt_target") <= (double)6.0F) {
                  dis = (double)(entity.m_20205_() * 1.0F);
                  using = false;
                  Vec3 _center = new Vec3(entity.m_20185_() + entity.m_20154_().f_82479_ * dis, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_ * dis, entity.m_20189_() + entity.m_20154_().f_82481_ * dis);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis * (double)3.0F / (double)2.0F), (e) -> true)) {
                     if (entityiterator instanceof LivingEntity && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && entityiterator.m_6084_() && entity != entityiterator) {
                        using = false;
                        if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                              using = true;
                           }
                        } else if (!entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var140 = _livEnt.m_21223_();
                           } else {
                              var140 = -1.0F;
                           }

                           float var151;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var151 = _livEnt.m_21233_();
                           } else {
                              var151 = -1.0F;
                           }

                           if (var140 < var151) {
                              using = true;
                           }
                        }

                        if (using) {
                           output = true;
                           logic_heal_cancel = false;
                           break;
                        }
                     }
                  }
               }
            }

            if (logic_heal_cancel) {
               logic_heal = false;
            } else {
               logic_heal = true;
               if (output) {
                  entity.getPersistentData().m_128347_("cnt_reverse_test", Math.max(entity.getPersistentData().m_128459_("cnt_reverse_test"), (double)100.0F));
               }
            }

            entity.getPersistentData().m_128347_("cnt_reverse_test", entity.getPersistentData().m_128459_("cnt_reverse_test") + (double)1.0F);
            if (logic_heal) {
               if (entity.getPersistentData().m_128459_("cnt_reverse_test") > (double)100.0F) {
                  label804: {
                     entity.getPersistentData().m_128347_("cnt_reverse_test", (double)0.0F);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt101 = (LivingEntity)entity;
                        if (_livEnt101.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                           break label804;
                        }
                     }

                     if (!entity.getPersistentData().m_128471_("PRESS_M")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 18, 9, false, false));
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_reverse", (double)15.0F);
                        KeyReverseCursedTechniqueOnKeyPressedProcedure.execute(entity);
                     }
                  }
               }
            } else if (!target) {
               entity.getPersistentData().m_128347_("cnt_reverse_lim", Math.max(entity.getPersistentData().m_128459_("cnt_reverse_lim") - 0.1, (double)0.0F));
            }

            if (entity.getPersistentData().m_128471_("PRESS_M")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt108 = (LivingEntity)entity;
                  if (_livEnt108.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                     entity.getPersistentData().m_128347_("cnt_reverse_lim", entity.getPersistentData().m_128459_("cnt_reverse_lim") + (double)1.0F);
                  }
               }

               entity.getPersistentData().m_128347_("cnt_reverse", Math.max(entity.getPersistentData().m_128459_("cnt_reverse") - (double)1.0F, (double)0.0F));
               if (!logic_heal) {
                  label528: {
                     if (!(entity.getPersistentData().m_128459_("cnt_reverse") <= (double)0.0F) && !(entity.getPersistentData().m_128459_("cnt_reverse_lim") >= limit)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var140 = _livEnt.m_21223_();
                        } else {
                           var140 = -1.0F;
                        }

                        float var152;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var152 = _livEnt.m_21233_();
                        } else {
                           var152 = -1.0F;
                        }

                        if (!(var140 >= var152) || output) {
                           break label528;
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_reverse", (double)0.0F);
                     KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
                  }
               }
            }
         }

         if (target && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt_weapon_main", entity.getPersistentData().m_128459_("cnt_weapon_main") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt_weapon_off", entity.getPersistentData().m_128459_("cnt_weapon_off") + (double)1.0F);
            using = false;
            using2 = false;
            mainItem = ItemStack.f_41583_.m_41777_();
            offItem = ItemStack.f_41583_.m_41777_();
            if (entity.getPersistentData().m_128459_("cnt_weapon_main") > (double)20.0F) {
               entity.getPersistentData().m_128347_("cnt_weapon_main", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_weapon_off", Math.min(entity.getPersistentData().m_128459_("cnt_weapon_off"), (double)100.0F));
               if (Math.abs(entity.getPersistentData().m_128459_("cnt_weapon_main") - entity.getPersistentData().m_128459_("cnt_weapon_off")) < (double)20.0F) {
                  entity.getPersistentData().m_128347_("cnt_weapon_main", entity.getPersistentData().m_128459_("cnt_weapon_off") - (double)20.0F);
               }

               using = true;
               ItemStack var147;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var147 = _livEnt.m_21205_();
               } else {
                  var147 = ItemStack.f_41583_;
               }

               mainItem = var147;
            }

            if (entity.getPersistentData().m_128459_("cnt_weapon_off") > (double)60.0F) {
               entity.getPersistentData().m_128347_("cnt_weapon_off", (double)40.0F);
               if (Math.abs(entity.getPersistentData().m_128459_("cnt_weapon_main") - entity.getPersistentData().m_128459_("cnt_weapon_off")) < (double)20.0F) {
                  entity.getPersistentData().m_128347_("cnt_weapon_off", entity.getPersistentData().m_128459_("cnt_weapon_main") - (double)20.0F);
               }

               using2 = true;
               ItemStack var148;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var148 = _livEnt.m_21206_();
               } else {
                  var148 = ItemStack.f_41583_;
               }

               offItem = var148;
            }

            if (using ^ using2) {
               fix = (double)0.0F;
               if ((using && mainItem.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get() || using2 && offItem.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) && distance < (double)40.0F) {
                  SupremeMartialSolutionRightClickedInAirProcedure.execute(world, entity);
                  fix = (double)200.0F;
               }

               if ((using && mainItem.m_41720_() == JujutsucraftModItems.DAITENGU_FAN.get() || using2 && offItem.m_41720_() == JujutsucraftModItems.DAITENGU_FAN.get()) && distance < (double)24.0F) {
                  DaitenguFanRightclickedProcedure.execute(world, x, y, z, entity);
                  fix = (double)200.0F;
               }

               if ((using && mainItem.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get() || using2 && offItem.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) && distance < (double)32.0F) {
                  DragonBoneRightclickedProcedure.execute(world, entity);
                  fix = (double)100.0F;
               }

               if (fix > (double)0.0F) {
                  if (using) {
                     entity.getPersistentData().m_128347_("cnt_weapon_main", (double)20.0F - fix);
                  } else if (using2) {
                     entity.getPersistentData().m_128347_("cnt_weapon_off", (double)60.0F - fix);
                  }
               }
            }
         }

         if (test && entity.getPersistentData().m_128459_("skill") == (double)0.0F && entity.m_20072_() && entity.m_20142_() && entity instanceof LivingEntity) {
            LivingEntity _livingEntity150 = (LivingEntity)entity;
            if (_livingEntity150.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
               if (var54 instanceof LivingEntity) {
                  RotateEntityProcedure.execute(((Entity)var54).m_20185_(), ((Entity)var54).m_20186_() + (double)((Entity)var54).m_20206_() * (double)0.5F, ((Entity)var54).m_20189_(), entity);
                  if (entity.m_20146_() < 4) {
                     entity.m_146922_(entity.m_146908_());
                     entity.m_146926_(-90.0F);
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
                     fix = entity.m_20186_();

                     for(int index0 = 0; index0 < (int)Math.round(Math.ceil((double)entity.m_20206_())); ++index0) {
                        if (!(world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), fix, entity.m_20189_())).m_60734_() instanceof LiquidBlock)) {
                           entity.m_146922_(entity.m_146908_());
                           entity.m_146926_((float)Math.max((double)entity.m_146909_(), (double)22.5F));
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }
                           break;
                        }

                        ++fix;
                     }
                  }
               }

               if (!InsideSolidCalculateProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (double)1.0F, (double)(entity.m_20205_() + 1.0F))) {
                  fix = (double)1.0F;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt172 = (LivingEntity)entity;
                     if (_livEnt172.m_21023_(MobEffects.f_19597_)) {
                        int var154;
                        label460: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                 var154 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                                 break label460;
                              }
                           }

                           var154 = 0;
                        }

                        fix = Math.max(fix - 0.15 * (double)(var154 + 1), (double)0.0F);
                     }
                  }

                  double var153;
                  label451: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity174 = (LivingEntity)entity;
                        if (_livingEntity174.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
                           var153 = _livingEntity174.m_21051_((Attribute)ForgeMod.SWIM_SPEED.get()).m_22135_();
                           break label451;
                        }
                     }

                     var153 = (double)0.0F;
                  }

                  fix *= Math.min(Math.max(var153, (double)0.0F), (double)4.0F);
                  speed = (double)0.75F * fix;
                  x_power = entity.m_20184_().m_7096_() + entity.m_20154_().f_82479_ * speed;
                  y_power = entity.m_20184_().m_7098_() + entity.m_20154_().f_82480_ * speed;
                  z_power = entity.m_20184_().m_7094_() + entity.m_20154_().f_82481_ * speed;
                  x_power = x_power < (double)0.0F ? Math.min(entity.m_20184_().m_7096_(), Math.max(x_power, speed * (double)-1.0F)) : Math.max(entity.m_20184_().m_7096_(), Math.min(x_power, speed * (double)1.0F));
                  y_power = y_power < (double)0.0F ? Math.min(entity.m_20184_().m_7098_(), Math.max(y_power, speed * (double)-1.0F)) : Math.max(entity.m_20184_().m_7098_(), Math.min(y_power, speed * (double)1.0F));
                  z_power = z_power < (double)0.0F ? Math.min(entity.m_20184_().m_7094_(), Math.max(z_power, speed * (double)-1.0F)) : Math.max(entity.m_20184_().m_7094_(), Math.min(z_power, speed * (double)1.0F));
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
                  if (entity instanceof Mob) {
                     Mob _entity = (Mob)entity;
                     _entity.m_21573_().m_26573_();
                  }
               }
            }
         }

      }
   }
}
