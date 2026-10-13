package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class StartCursedTechniqueProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         boolean CREATIVE = false;
         boolean item_use = false;
         boolean noUseCursePower = false;
         ItemStack mainHandItem = ItemStack.EMPTY;
         ItemStack mainHandItemOrgin = ItemStack.EMPTY;
         double cost = 0.0D;
         double NUM1 = 0.0D;
         double skill = 0.0D;
         double Tick = 0.0D;
         double T1 = 0.0D;
         double S1 = 0.0D;
         double T2 = 0.0D;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         mainHandItem = var10000.copy();
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         mainHandItemOrgin = var10000;
         if (mainHandItem.getTag().contains("used_item") && mainHandItem.getTag().getBoolean("used_item")) {
            mainHandItemOrgin.getTag().putBoolean("used_item", false);
            item_use = true;
         }

         if (item_use) {
            STR1 = mainHandItem.getHoverName().getString();
            skill = mainHandItem.getTag().getDouble("skill");
            cost = mainHandItem.getTag().getDouble("COOLDOWN_TICKS");
            if (mainHandItem.is(JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get())) {
               noUseCursePower = true;
            }
         } else {
            pVars.noChangeTechnique = true;
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         label338: {
            if (item_use) {
               label349: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label338;
                     }
                  }

                  label350: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           break label350;
                        }
                     }

                     if (!(entity instanceof LivingEntity)) {
                        break label349;
                     }

                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (!_livEnt10.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label349;
                     }
                  }

                  if (!noUseCursePower) {
                     break label338;
                  }
               }
            } else if (!LogicStartProcedure.execute(entity)) {
               break label338;
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                  } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                     return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity)) {
               CREATIVE = ((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                     } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entity);
               if (noUseCursePower) {
                  NUM1 = pVars.PlayerCursePower - 0.0D;
               } else {
                  NUM1 = pVars.PlayerCursePower - (item_use ? cost : pVars.PlayerSelectCurseTechniqueCost);
               }

               if (!(NUM1 >= 0.0D) && !CREATIVE) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                     }

                     return;
                  }

                  return;
               } else {
                  if (!CREATIVE) {
                     pVars.PlayerCursePower = NUM1;
                  }

                  if (item_use) {
                     T1 = (double)Math.round(Math.floor(skill / 100.0D));
                     S1 = (double)Math.round(Math.floor(skill % 100.0D));
                  } else {
                     STR1 = pVars.PlayerSelectCurseTechniqueName;
                     T1 = pVars.SecondTechnique ? pVars.PlayerCurseTechnique2 : pVars.PlayerCurseTechnique;
                     S1 = pVars.PlayerSelectCurseTechnique;
                  }

                  entity.getPersistentData().putDouble("skill", item_use ? skill : T1 * 100.0D + S1);
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                     }
                  }

                  if ((T1 != 2.0D || S1 != 5.0D) && (T1 != 9.0D || S1 != 10.0D) && (T1 != 18.0D || !(S1 >= 10.0D) || !(S1 < 15.0D)) && !CREATIVE) {
                     if (S1 == 20.0D) {
                        Tick = 20.0D;
                     } else {
                        Tick = Math.max((item_use ? cost : pVars.PlayerSelectCurseTechniqueCostOrgin) / 2.0D, 20.0D);
                        if (STR1.equals(Component.translatable("jujutsu.technique.attack1").getString())) {
                           Tick = 5.0D;
                        } else if (STR1.equals(Component.translatable("jujutsu.technique.attack2").getString())) {
                           Tick = 15.0D;
                        } else if (STR1.equals(Component.translatable("jujutsu.technique.attack3").getString())) {
                           Tick = 20.0D;
                        } else if (STR1.equals(Component.translatable("jujutsu.technique.attack4").getString())) {
                           Tick = 100.0D;
                        } else if (STR1.equals(Component.translatable("jujutsu.technique.attack5").getString())) {
                           Tick = 200.0D;
                        } else if (!STR1.equals(Component.translatable("jujutsu.technique.attack6").getString()) && !STR1.equals(Component.translatable("jujutsu.technique.flying_kick").getString())) {
                           if (STR1.equals(Component.translatable("jujutsu.technique.attack7").getString())) {
                              Tick = 100.0D;
                           }
                        } else {
                           Tick = 100.0D;
                        }

                        if (T1 == 5.0D && S1 == 5.0D) {
                           Tick = 20.0D;
                        }

                        if (T1 == 6.0D && S1 >= 5.0D && S1 < 20.0D && !STR1.equals(Component.translatable("jujutsu.technique.choso3").getString())) {
                           Tick = 5.0D;
                        }

                        if (T1 == 7.0D && (S1 == 5.0D || S1 == 10.0D)) {
                           Tick = 20.0D;
                        }

                        if (T1 == 19.0D && S1 < 5.0D && LogicStartPassiveProcedure.execute(entity)) {
                           Tick = 5.0D;
                        }

                        if (T1 == 39.0D && S1 >= 8.0D) {
                           Tick = 20.0D;
                        }

                        if (T1 == 40.0D && (S1 == 6.0D || S1 == 7.0D)) {
                           Tick = 20.0D;
                        }
                     }
                  } else {
                     Tick = 1.0D;
                  }

                  if (world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                     pVars.PlayerTechniqueUsedNumber += (double)Math.round(Tick);
                     if (pVars.PlayerTechniqueUsedNumber > (double)((T1 != 27.0D && T2 != 27.0D ? 4000 : 2000) * (1 + world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().get(new ResourceLocation("jujutsucraft:mastery_simple_domain"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }

                     if (pVars.PlayerTechniqueUsedNumber > (double)((T1 != 27.0D && T2 != 27.0D ? 12000 : 100) * (1 + world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().get(new ResourceLocation("jujutsucraft:mastery_domain_expansion"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }

                  if (mainHandItem.is(JujutsucraftModItems.LOUDSPEAKER.get())) {
                     mainHandItemOrgin.getTag().putBoolean("Used", true);
                  }

                  if (!noUseCursePower) {
                     if (pVars.PhysicalAttack && !item_use) {
                        if (S1 >= 0.0D && S1 <= 2.0D) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.is(JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get())) {
                              Tick *= 0.5D;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity33 = (LivingEntity)entity;
                              if (_livingEntity33.getAttributes().hasAttribute(Attributes.ATTACK_SPEED)) {
                                 double var10003;
                                 label217: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity34 = (LivingEntity)entity;
                                       if (_livingEntity34.getAttributes().hasAttribute(Attributes.ATTACK_SPEED)) {
                                          var10003 = _livingEntity34.getAttribute(Attributes.ATTACK_SPEED).getBaseValue();
                                          break label217;
                                       }
                                    }

                                    var10003 = 0.0D;
                                 }

                                 Tick += 20.0D * Math.max(1.7 - var10003, 0.0D);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(Tick), 1, false, false));
                              }

                              return;
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(Tick), 0, false, false));
                           }

                           return;
                        }

                        return;
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(Tick), 0, false, false));
                           }

                           return;
                        }

                        return;
                     }
                  } else {
                     entity.getPersistentData().putDouble("COOLDOWN_TICKS", Math.max(entity.getPersistentData().getDouble("COOLDOWN_TICKS"), (double)Math.round(Tick)));
                     return;
                  }
               }
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
            }
         }

      }
   }
}