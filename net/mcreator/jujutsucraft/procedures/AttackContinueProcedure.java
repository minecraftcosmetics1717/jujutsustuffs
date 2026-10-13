package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade217Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.HigurumaHiromiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackContinueProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_b = ItemStack.f_41583_;
         ItemStack item_a = ItemStack.f_41583_;
         boolean attack = false;
         boolean overhead_continue = false;
         boolean sword = false;
         boolean keep = false;
         Entity target_entity = null;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double dis = (double)0.0F;
         double old_cnt1 = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double num2 = (double)0.0F;
         double CT2 = (double)0.0F;
         double CT1 = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double weapon_size = (double)0.0F;
         double attack_reach = (double)0.0F;
         double energyMAX = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var61 = var10000;
         sword = LogicSwordProcedure.execute(entity);
         if (entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
            CT1 = playerVars.PlayerCurseTechnique;
            CT2 = playerVars.PlayerCurseTechnique2;
            energyMAX = playerVars.PlayerCursePowerMAX;
         }

         if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 1, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)4.0F);
            DamageFixProcedure.execute(entity);
            if ((CT1 == (double)19.0F || CT2 == (double)19.0F) && LogicStartPassiveProcedure.execute(entity)) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)9.0F));
            }
         } else {
            if (energyMAX >= (double)100.0F) {
               ChangeCurseEnergyProcedure.execute(entity, (double)-2.0F);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
            old_skill = entity.getPersistentData().m_128459_("skill");
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F;
            z_pos = entity.m_20189_();
            ItemStack var112;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var112 = _livEnt.m_21205_();
            } else {
               var112 = ItemStack.f_41583_;
            }

            item_a = var112.m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var112 = _livEnt.m_21206_();
            } else {
               var112 = ItemStack.f_41583_;
            }

            item_b = var112.m_41777_();
            if (entity.m_20096_()) {
               if ((entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity || CT1 == (double)16.0F || CT2 == (double)16.0F || entity instanceof RikaEntity || entity instanceof Rika2Entity) && !(entity instanceof Player) && entity.f_19797_ % 400 > 200) {
                  overhead_continue = true;
               }

               if ((entity instanceof HigurumaHiromiEntity || CT1 == (double)27.0F || CT2 == (double)27.0F) && (item_a.m_41720_() == JujutsucraftModItems.GAVEL.get() || item_b.m_41720_() == JujutsucraftModItems.GAVEL.get())) {
                  overhead_continue = true;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt5") <= (double)100.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
                  if (entity instanceof Player) {
                     keep = entity.getPersistentData().m_128471_("PRESS_Z");
                  } else if (overhead_continue) {
                     keep = true;
                  } else {
                     weapon_size = GetWeaponSizeProcedure.execute(entity);
                     attack_reach = GetReachProcedure.execute(entity);
                     range = ReturnEntitySizeProcedure.execute(entity);
                     range = range * range * Math.sqrt(weapon_size * attack_reach);
                     dis = (double)2.5F * range;
                     if (var61 instanceof LivingEntity && GetDistanceProcedure.execute(entity) < (double)6.0F * range && ((Entity)var61).getPersistentData().m_128471_("attack")) {
                        keep = true;
                     }

                     if (!keep) {
                        yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                        pitch = Math.toRadians((double)entity.m_146909_());
                        Vec3 _center = new Vec3(entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis, entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * dis, entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F * range / (double)2.0F), (e) -> true)) {
                           if (entity != entityiterator) {
                              if (entityiterator instanceof Projectile) {
                                 if (DetectEnemyProjectileProcedure.execute(entity, entityiterator)) {
                                    keep = true;
                                    break;
                                 }
                              } else if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 keep = true;
                                 break;
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof CursedSpiritGrade217Entity) {
                     keep = true;
                  } else if (entity.getPersistentData().m_128459_("cnt5") > (double)30.0F) {
                     keep = false;
                  }

                  if (!keep) {
                     entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), (double)100.0F));
                  }
               }

               label269: {
                  num2 = item_a.m_41720_() == ItemStack.f_41583_.m_41720_() ? (double)0.0F : Math.max(item_a.m_41784_().m_128459_("Power"), (double)0.0F);
                  if (entity instanceof Player) {
                     if (CT1 != (double)21.0F && CT2 != (double)21.0F) {
                        break label269;
                     }
                  } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
                     break label269;
                  }

                  num2 -= (double)0.125F;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt59 = (LivingEntity)entity;
                  if (_livEnt59.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                     num2 -= (double)0.125F;
                  }
               }

               label259: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var114 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                        break label259;
                     }
                  }

                  var114 = 0;
               }

               if (var114 > 0) {
                  num2 -= (double)0.25F;
               }

               if (item_a.m_41720_() != ItemStack.f_41583_.m_41720_()) {
                  num2 = Math.max(num2, (double)0.0F);
               }

               if (overhead_continue) {
                  if (entity.getPersistentData().m_128459_("cnt5") % (double)2.0F == (double)1.0F) {
                     attack = true;
                  }
               } else {
                  attack = num2 >= (double)0.0F ? entity.getPersistentData().m_128459_("cnt5") % (double)(2L + Math.round(num2 / (double)0.25F)) == (double)1.0F : true;
               }

               if (attack || entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F) {
                  if (entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F) {
                     entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)2.5F));
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", -0.1 + entity.getPersistentData().m_128459_("cnt5") * 0.01);
                  }

                  if (!overhead_continue) {
                     if (entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F) {
                        AttackStrongProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     } else {
                        AttackWeakProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }
                  } else {
                     if (var61 instanceof LivingEntity) {
                        RotateEntityProcedure.execute(((Entity)var61).m_20185_(), ((Entity)var61).m_20186_() + (double)((Entity)var61).m_20206_() * (double)0.5F, ((Entity)var61).m_20189_(), entity);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity77 = (LivingEntity)entity;
                        if (_livingEntity77.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity77.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var112 = _livEnt.m_21205_();
                     } else {
                        var112 = ItemStack.f_41583_;
                     }

                     item_a = var112.m_41777_().m_41777_();
                     if (entity.getPersistentData().m_128459_("cnt5") % (double)4.0F != (double)1.0F && !(entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var112 = _livEnt.m_21206_();
                        } else {
                           var112 = ItemStack.f_41583_;
                        }

                        if (var112.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = item_a.m_41777_();
                              _setstack.m_41764_(item_a.m_41613_());
                              _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity99 = (LivingEntity)entity;
                           if (_livingEntity99.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                              _livingEntity99.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)3.0F);
                           }
                        }
                     } else {
                        if (item_a.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var112 = _livEnt.m_21206_();
                              } else {
                                 var112 = ItemStack.f_41583_;
                              }

                              ItemStack _setstack = var112.m_41777_().m_41777_();
                              ItemStack var10001;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.m_21206_();
                              } else {
                                 var10001 = ItemStack.f_41583_;
                              }

                              _setstack.m_41764_(var10001.m_41613_());
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity91 = (LivingEntity)entity;
                           if (_livingEntity91.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                              _livingEntity91.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
                           }
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                     entity.getPersistentData().m_128347_("Damage", (double)9.0F);
                     entity.getPersistentData().m_128379_("attack", true);
                     DamageFixProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("Damage"));
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)0.0F);
                     distance = (double)(1.0F * entity.m_20205_());
                     entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance);
                     entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + Math.sin(pitch) * (double)-1.0F * distance);
                     entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);
                     entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                     entity.getPersistentData().m_128347_("cnt3", (double)2.0F);
                     entity.getPersistentData().m_128347_("cnt4", (double)0.0F);
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") - (double)2.0F);
                     AttackOverheadProcedure.execute(world, x, y, z, entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19597_);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 0, false, false));
                        }
                     }

                     x_power = entity.m_20154_().f_82479_ * (double)1.0F;
                     y_power = entity.m_20184_().m_7098_();
                     z_power = entity.m_20154_().f_82481_ * (double)1.0F;
                     entity.m_20256_(new Vec3(x_power, y_power, z_power));
                     StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", old_cnt1);
               entity.getPersistentData().m_128347_("skill", old_skill);
            } else if (entity.getPersistentData().m_128459_("cnt5") > (double)110.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
