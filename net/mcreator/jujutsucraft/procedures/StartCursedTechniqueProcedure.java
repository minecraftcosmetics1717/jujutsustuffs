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
         ItemStack mainHandItem = ItemStack.f_41583_;
         ItemStack mainHandItemOrgin = ItemStack.f_41583_;
         double cost = (double)0.0F;
         double NUM1 = (double)0.0F;
         double skill = (double)0.0F;
         double Tick = (double)0.0F;
         double T1 = (double)0.0F;
         double S1 = (double)0.0F;
         double T2 = (double)0.0F;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         mainHandItem = var10000.m_41777_();
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         mainHandItemOrgin = var10000;
         if (mainHandItem.m_41784_().m_128441_("used_item") && mainHandItem.m_41784_().m_128471_("used_item")) {
            mainHandItemOrgin.m_41784_().m_128379_("used_item", false);
            item_use = true;
         }

         if (item_use) {
            STR1 = mainHandItem.m_41611_().getString();
            skill = mainHandItem.m_41784_().m_128459_("skill");
            cost = mainHandItem.m_41784_().m_128459_("COOLDOWN_TICKS");
            if (mainHandItem.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
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
                     if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label338;
                     }
                  }

                  label350: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           break label350;
                        }
                     }

                     if (!(entity instanceof LivingEntity)) {
                        break label349;
                     }

                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (!_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
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
                     return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity)) {
               CREATIVE = ((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                     } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                        return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entity);
               if (noUseCursePower) {
                  NUM1 = pVars.PlayerCursePower - (double)0.0F;
               } else {
                  NUM1 = pVars.PlayerCursePower - (item_use ? cost : pVars.PlayerSelectCurseTechniqueCost);
               }

               if (!(NUM1 >= (double)0.0F) && !CREATIVE) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), true);
                     }

                     return;
                  }

                  return;
               } else {
                  if (!CREATIVE) {
                     pVars.PlayerCursePower = NUM1;
                  }

                  if (item_use) {
                     T1 = (double)Math.round(Math.floor(skill / (double)100.0F));
                     S1 = (double)Math.round(Math.floor(skill % (double)100.0F));
                  } else {
                     STR1 = pVars.PlayerSelectCurseTechniqueName;
                     T1 = pVars.SecondTechnique ? pVars.PlayerCurseTechnique2 : pVars.PlayerCurseTechnique;
                     S1 = pVars.PlayerSelectCurseTechnique;
                  }

                  entity.getPersistentData().m_128347_("skill", item_use ? skill : T1 * (double)100.0F + S1);
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                     }
                  }

                  if ((T1 != (double)2.0F || S1 != (double)5.0F) && (T1 != (double)9.0F || S1 != (double)10.0F) && (T1 != (double)18.0F || !(S1 >= (double)10.0F) || !(S1 < (double)15.0F)) && !CREATIVE) {
                     if (S1 == (double)20.0F) {
                        Tick = (double)20.0F;
                     } else {
                        Tick = Math.max((item_use ? cost : pVars.PlayerSelectCurseTechniqueCostOrgin) / (double)2.0F, (double)20.0F);
                        if (STR1.equals(Component.m_237115_("jujutsu.technique.attack1").getString())) {
                           Tick = (double)5.0F;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack2").getString())) {
                           Tick = (double)15.0F;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack3").getString())) {
                           Tick = (double)20.0F;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack4").getString())) {
                           Tick = (double)100.0F;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack5").getString())) {
                           Tick = (double)200.0F;
                        } else if (!STR1.equals(Component.m_237115_("jujutsu.technique.attack6").getString()) && !STR1.equals(Component.m_237115_("jujutsu.technique.flying_kick").getString())) {
                           if (STR1.equals(Component.m_237115_("jujutsu.technique.attack7").getString())) {
                              Tick = (double)100.0F;
                           }
                        } else {
                           Tick = (double)100.0F;
                        }

                        if (T1 == (double)5.0F && S1 == (double)5.0F) {
                           Tick = (double)20.0F;
                        }

                        if (T1 == (double)6.0F && S1 >= (double)5.0F && S1 < (double)20.0F && !STR1.equals(Component.m_237115_("jujutsu.technique.choso3").getString())) {
                           Tick = (double)5.0F;
                        }

                        if (T1 == (double)7.0F && (S1 == (double)5.0F || S1 == (double)10.0F)) {
                           Tick = (double)20.0F;
                        }

                        if (T1 == (double)19.0F && S1 < (double)5.0F && LogicStartPassiveProcedure.execute(entity)) {
                           Tick = (double)5.0F;
                        }

                        if (T1 == (double)39.0F && S1 >= (double)8.0F) {
                           Tick = (double)20.0F;
                        }

                        if (T1 == (double)40.0F && (S1 == (double)6.0F || S1 == (double)7.0F)) {
                           Tick = (double)20.0F;
                        }
                     }
                  } else {
                     Tick = (double)1.0F;
                  }

                  if (world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                     pVars.PlayerTechniqueUsedNumber += (double)Math.round(Tick);
                     if (pVars.PlayerTechniqueUsedNumber > (double)((T1 != (double)27.0F && T2 != (double)27.0F ? 4000 : 2000) * (1 + world.m_6106_().m_5470_().m_46215_(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_simple_domain"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }

                     if (pVars.PlayerTechniqueUsedNumber > (double)((T1 != (double)27.0F && T2 != (double)27.0F ? 12000 : 100) * (1 + world.m_6106_().m_5470_().m_46215_(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  }

                  if (mainHandItem.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get()) {
                     mainHandItemOrgin.m_41784_().m_128379_("Used", true);
                  }

                  if (!noUseCursePower) {
                     if (pVars.PhysicalAttack && !item_use) {
                        if (S1 >= (double)0.0F && S1 <= (double)2.0F) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              Tick *= (double)0.5F;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity33 = (LivingEntity)entity;
                              if (_livingEntity33.m_21204_().m_22171_(Attributes.f_22283_)) {
                                 double var10003;
                                 label217: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity34 = (LivingEntity)entity;
                                       if (_livingEntity34.m_21204_().m_22171_(Attributes.f_22283_)) {
                                          var10003 = _livingEntity34.m_21051_(Attributes.f_22283_).m_22135_();
                                          break label217;
                                       }
                                    }

                                    var10003 = (double)0.0F;
                                 }

                                 Tick += (double)20.0F * Math.max(1.7 - var10003, (double)0.0F);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(Tick), 1, false, false));
                              }

                              return;
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(Tick), 0, false, false));
                           }

                           return;
                        }

                        return;
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(Tick), 0, false, false));
                           }

                           return;
                        }

                        return;
                     }
                  } else {
                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", Math.max(entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), (double)Math.round(Tick)));
                     return;
                  }
               }
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), true);
            }
         }

      }
   }
}
