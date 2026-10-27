package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class AIMahitoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         boolean infinity = false;
         boolean domain = false;
         boolean success = false;
         boolean phase2 = false;
         boolean sukuna = false;
         Entity targetEntity = null;

         if (entity.isAlive()) {
            boolean isPhase2;
            
            // Check if Mahito is in his second phase (Instant Spirit Body of Distorted Killing)
            if (entity instanceof LivingEntity livingEntity) {
               isPhase2 = livingEntity.hasEffect(JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get());
            } else {
               isPhase2 = false;
            }

            phase2 = isPhase2;
            AIActiveProcedure.execute(world, x, y, z, entity);

            // Apply passive resistance effect if not already present
            if (entity instanceof LivingEntity livingEntity) {
               if (!livingEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                  if (!entity.level().isClientSide()) {
                     livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 16, false, false));
                  }
               }
            }

            // Apply passive regeneration effect if not already present
            if (entity instanceof LivingEntity livingEntity) {
               if (!livingEntity.hasEffect(MobEffects.REGENERATION)) {
                  if (!entity.level().isClientSide()) {
                     livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            // Get target entity
            if (entity instanceof Mob mobEntity) {
               targetEntity = mobEntity.getTarget();
            }

            if (targetEntity instanceof LivingEntity livingTarget) {
               if (entity instanceof Mob mobEntity) {
                  targetEntity = mobEntity.getTarget();
               } else {
                  targetEntity = null;
               }

               // Check if the target is tagged as a human
               if (targetEntity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:humans")))) {
                  if (entity instanceof LivingEntity livingEntity) {
                     ItemStack emptyStack = ItemStack.EMPTY.copy();
                     emptyStack.setCount(1);
                     livingEntity.setItemInHand(InteractionHand.MAIN_HAND, emptyStack);
                     if (livingEntity instanceof Player player) {
                        player.getInventory().setChanged();
                     }
                  }

                  if (entity instanceof LivingEntity livingEntity) {
                     ItemStack emptyStack = ItemStack.EMPTY.copy();
                     emptyStack.setCount(1);
                     livingEntity.setItemInHand(InteractionHand.OFF_HAND, emptyStack);
                     if (livingEntity instanceof Player player) {
                        player.getInventory().setChanged();
                     }
                  }
               } else {
                  // Increment AI counter "cnt_x"
                  double cntX = entity.getPersistentData().getDouble("cnt_x") + 1.0;
                  entity.getPersistentData().putDouble("cnt_x", cntX);

                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     
                     if (entity instanceof Mob mobEntity) {
                        targetEntity = mobEntity.getTarget();
                     } else {
                        targetEntity = null;
                     }

                     boolean hasSukunaFlag;
                     if (ReturnInsideItemProcedure.execute(targetEntity).getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                        if (targetEntity instanceof LivingEntity targetLiving && targetLiving.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           hasSukunaFlag = true;
                        } else {
                           hasSukunaFlag = false;
                        }
                     } else {
                        hasSukunaFlag = true;
                     }

                     sukuna = hasSukunaFlag;
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);

                     if ((!(Math.random() > 0.7) || !LogicStartProcedure.execute(entity) || phase2) && !domain) {
                        tick = 0.0;
                        if (phase2) {
                           if (tick == 0.0) {
                              if (!(entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()))) {
                                 if (distance < 10.0 && Math.random() < 0.5) {
                                    entity.getPersistentData().putDouble("skill", (double)Math.round(1516.0F));
                                    level = 1.0;
                                    tick = 100.0;
                                 }
                              }

                              if (LogicStartProcedure.execute(entity) && distance < 4.0 && !sukuna) {
                                 entity.getPersistentData().putDouble("skill", (double)Math.round(1505.0F));
                                 level = 0.0;
                                 tick = 50.0;
                              }
                           }

                           if (tick > 0.0) {
                              if (entity instanceof LivingEntity livingEntity && !entity.level().isClientSide()) {
                                 livingEntity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                              }

                              if (level > 0.0) {
                                 if (entity instanceof LivingEntity livingEntity && !entity.level().isClientSide()) {
                                    livingEntity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                                 }
                              } else if (entity instanceof LivingEntity livingEntity && !entity.level().isClientSide()) {
                                 livingEntity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                              }
                           }
                        }

                        if (tick == 0.0) {
                           CalculateAttackProcedure.execute(world, entity);
                           if (LogicStartPassiveProcedure.execute(entity) && !phase2) {
                              if (entity.getPersistentData().getDouble("skill") % 100.0 == 2.0) {
                                 if (entity instanceof LivingEntity livingEntity) {
                                    ItemStack handStack = (Math.random() < 0.5 ? ItemStack.EMPTY : new ItemStack(JujutsucraftModItems.MAHITO_HAND_1.get())).copy();
                                    handStack.setCount(1);
                                    livingEntity.setItemInHand(InteractionHand.MAIN_HAND, handStack);
                                    if (livingEntity instanceof Player player) {
                                       player.getInventory().setChanged();
                                    }
                                 }
                              } else if (entity instanceof LivingEntity livingEntity) {
                                 ItemStack handStack = (Math.random() < 0.5 ? ItemStack.EMPTY : new ItemStack(JujutsucraftModItems.MAHITO_HAND_2.get())).copy();
                                 handStack.setCount(1);
                                 livingEntity.setItemInHand(InteractionHand.MAIN_HAND, handStack);
                                 if (livingEntity instanceof Player player) {
                                    player.getInventory().setChanged();
                                 }
                              }
                           } else if (entity instanceof LivingEntity livingEntity) {
                              ItemStack emptyStack = ItemStack.EMPTY.copy();
                              emptyStack.setCount(1);
                              livingEntity.setItemInHand(InteractionHand.MAIN_HAND, emptyStack);
                              if (livingEntity instanceof Player player) {
                                 player.getInventory().setChanged();
                              }
                           }
                        }

                        if (phase2) {
                           if (entity instanceof LivingEntity livingEntity) {
                              ItemStack emptyMain = ItemStack.EMPTY.copy();
                              emptyMain.setCount(1);
                              livingEntity.setItemInHand(InteractionHand.MAIN_HAND, emptyMain);
                              if (livingEntity instanceof Player player) {
                                 player.getInventory().setChanged();
                              }

                              ItemStack emptyOff = ItemStack.EMPTY.copy();
                              emptyOff.setCount(1);
                              livingEntity.setItemInHand(InteractionHand.OFF_HAND, emptyOff);
                              if (livingEntity instanceof Player player) {
                                 player.getInventory().setChanged();
                              }
                           }
                        }
                     } else {
                        if (domain) {
                           rnd = 20.0;
                           tick = 5.0;
                        } else {
                           boolean hasZoneAndDomain = entity instanceof LivingEntity livingEntity && 
                              livingEntity.hasEffect(JujutsucraftModMobEffects.ZONE.get()) && 
                              livingEntity.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());

                           float currentHealth = entity instanceof LivingEntity livingEntity ? livingEntity.getHealth() : -1.0F;
                           float maxHealth = entity instanceof LivingEntity livingEntity ? livingEntity.getMaxHealth() : -1.0F;

                           if (hasZoneAndDomain || currentHealth < maxHealth * 0.5F) {
                              int index0 = 0;
                              while (index0 < 256) {
                                 rnd = 3.0 + Math.ceil(Math.round(Math.random() * 17.0));
                                 if (rnd == 4.0) {
                                    tick = 50.0;
                                    if (!(Math.random() > 0.5)) break;
                                 } else if (rnd == 5.0) {
                                    tick = 50.0;
                                    if (!sukuna && !(distance > 6.0)) break;
                                 } else if (rnd == 6.0) {
                                    tick = 50.0;
                                    if (!(distance > 12.0)) break;
                                 } else if (rnd == 7.0) {
                                    tick = 12.0;
                                    if (!(distance < 6.0)) break;
                                 } else if (rnd == 8.0) {
                                    tick = 75.0;
                                    if (!(distance < 2.0)) break;
                                 } else if (rnd == 9.0) {
                                    tick = 150.0;
                                    if (!(Math.random() > 0.75) && !(distance < 6.0)) break;
                                 } else if (rnd == 10.0) {
                                    tick = 100.0;
                                    if (!(Math.random() > 0.75) && !(distance < 6.0)) break;
                                 } else if (rnd == 15.0) {
                                    tick = 250.0;
                                    boolean hasDomain = entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                    if (hasDomain || currentHealth >= maxHealth * 0.5F) break;
                                 } else if (rnd == 20.0) {
                                    tick = 20.0;
                                    if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) break;
                                 }
                                 ++index0;
                              }
                           } else {
                              rnd = 15.0;
                              tick = 250.0;
                           }
                        }

                        if (rnd >= 5.0) {
                           entity.getPersistentData().putDouble("skill", (double)Math.round(1500.0 + rnd));
                           if (entity instanceof LivingEntity livingEntity && !entity.level().isClientSide()) {
                              livingEntity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                           if (entity instanceof LivingEntity livingEntity && !entity.level().isClientSide()) {
                              livingEntity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        } else {
                           for (int index1 = 0; index1 < 3; ++index1) {
                              Vec3 eyePos = entity.getEyePosition(1.0F);
                              Vec3 viewVec = entity.getViewVector(1.0F).scale(3.0);
                              Vec3 targetRay = eyePos.add(viewVec);
                              
                              var.minecraft.world.phys.HitResult rayTrace = entity.level().clip(new ClipContext(eyePos, targetRay, Block.COLLIDER, Fluid.NONE, entity));
                              Vec3 hitPos = rayTrace.getLocation();
                              
                              SummonHumansProcedure.execute(world, hitPos.x(), hitPos.y(), hitPos.z(), entity);
                           }
                        }

                        // Reset hands to empty items
                        if (entity instanceof LivingEntity livingEntity) {
                           ItemStack emptyMain = ItemStack.EMPTY.copy();
                           emptyMain.setCount(1);
                           livingEntity.setItemInHand(InteractionHand.MAIN_HAND, emptyMain);
                           if (livingEntity instanceof Player player) {
                              player.getInventory().setChanged();
                           }

                           ItemStack emptyOff = ItemStack.EMPTY.copy();
                           emptyOff.setCount(1);
                           livingEntity.setItemInHand(InteractionHand.OFF_HAND, emptyOff);
                           if (livingEntity instanceof Player player) {
                              player.getInventory().setChanged();
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }
      }
   }
}