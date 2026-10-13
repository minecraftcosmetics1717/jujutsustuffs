package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String name = "";
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = (double)0.0F;
         double p_skill1 = (double)0.0F;
         double p_selectNumber = (double)0.0F;
         if (entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
            p_skill1 = playerVars.SecondTechnique ? playerVars.PlayerCurseTechnique2 : playerVars.PlayerCurseTechnique;
            p_selectNumber = playerVars.PlayerSelectCurseTechnique;
            if (!playerVars.noChangeTechnique) {
               p_selectNumber += (double)(entity.m_6144_() ? -1 : 1);
            }

            if (p_skill1 <= (double)10.0F) {
               name = "-----";

               for(int index0 = 0; index0 < 25; ++index0) {
                  p_passive = false;
                  p_physical = false;
                  if (p_skill1 == (double)-1.0F) {
                     if (p_selectNumber == (double)5.0F) {
                        p_physical = true;
                        cost = (double)0.0F;
                        name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     } else if (p_selectNumber == (double)6.0F) {
                        p_physical = true;
                        cost = (double)0.0F;
                        name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     } else if (p_selectNumber == (double)7.0F) {
                        p_physical = true;
                        cost = (double)0.0F;
                        name = Component.m_237115_("jujutsu.technique.attack5").getString();
                     }
                  } else if (p_skill1 == (double)1.0F) {
                     if (p_selectNumber == (double)5.0F) {
                        name = Component.m_237115_("jujutsu.technique.dismantle").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("jujutsu.technique.cleave").getString();
                        cost = (double)200.0F;
                     } else if (p_selectNumber != (double)7.0F) {
                        if (p_selectNumber == (double)20.0F) {
                           name = Component.m_237115_("jujutsu.technique.malevolent_shrine").getString();
                           cost = (double)1250.0F;
                        }
                     } else {
                        int var10000;
                        label368: {
                           name = Component.m_237115_("jujutsu.technique.open").getString();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                 break label368;
                              }
                           }

                           var10000 = 0;
                        }

                        cost = (double)(var10000 > 0 && !entity.getPersistentData().m_128471_("Failed") ? 1000 : 500);
                     }

                     if (p_selectNumber == (double)11.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.dismantle1").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)12.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.dismantle2").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)13.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.dismantle3").getString();
                        cost = (double)100.0F;
                     }
                  } else if (p_skill1 == (double)2.0F) {
                     if (p_selectNumber == (double)5.0F) {
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.infinity").getString();
                        cost = (double)0.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("jujutsu.technique.blue").getString();
                        cost = (double)200.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        name = Component.m_237115_("jujutsu.technique.red").getString();
                        cost = (double)500.0F;
                     } else if (p_selectNumber == (double)8.0F) {
                        name = Component.m_237115_("jujutsu.technique.gojo1").getString();
                        cost = (double)200.0F;
                     } else if (p_selectNumber == (double)15.0F) {
                        name = Component.m_237115_("jujutsu.technique.purple").getString();
                        cost = (double)1000.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("jujutsu.technique.unlimited_void").getString();
                        cost = (double)1250.0F;
                     }
                  } else if (p_skill1 == (double)3.0F) {
                     if (p_selectNumber == (double)4.0F) {
                     }

                     if (p_selectNumber == (double)5.0F) {
                        name = Component.m_237115_("jujutsu.technique.explode").getString();
                        cost = (double)400.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("jujutsu.technique.get_crushed").getString();
                        cost = (double)250.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        name = Component.m_237115_("jujutsu.technique.crumble_away").getString();
                        cost = (double)500.0F;
                     } else if (p_selectNumber == (double)8.0F) {
                        name = Component.m_237115_("jujutsu.technique.dont_move").getString();
                        cost = (double)150.0F;
                     } else if (p_selectNumber == (double)9.0F) {
                        name = Component.m_237115_("jujutsu.technique.blast_away").getString();
                        cost = (double)300.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = (double)1000.0F;
                     }
                  } else if (p_skill1 == (double)4.0F) {
                     if (p_selectNumber == (double)5.0F) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire").getString();
                        cost = (double)180.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire2").getString();
                        cost = (double)120.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        name = Component.m_237115_("jujutsu.technique.ember_insects").getString();
                        cost = (double)150.0F;
                     } else if (p_selectNumber == (double)8.0F) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire3").getString();
                        cost = (double)150.0F;
                     } else if (p_selectNumber == (double)9.0F) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire4").getString();
                        cost = (double)500.0F;
                     } else if (p_selectNumber == (double)15.0F) {
                        name = Component.m_237115_("jujutsu.technique.meteor").getString();
                        cost = (double)1250.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("jujutsu.technique.coffinofthe_iron_mountain").getString();
                        cost = (double)1250.0F;
                     }
                  } else if (p_skill1 == (double)5.0F) {
                     if (p_selectNumber == (double)3.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack6").getString();
                        cost = (double)50.0F;
                     } else if (p_selectNumber == (double)4.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack8").getString();
                        cost = (double)200.0F;
                     } else if (p_selectNumber == (double)5.0F) {
                        name = Component.m_237115_("jujutsu.technique.copy1").getString();
                        cost = (double)500.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("advancements.skill_copy_dhruv_lakdawalla.title").getString();
                        cost = (double)300.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        name = Component.m_237115_("advancements.skill_copy_takako_uro.title").getString();
                        cost = (double)200.0F;
                     } else if (p_selectNumber == (double)10.0F) {
                        String var36;
                        label480: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr39 = (ServerPlayer)entity;
                              if (_plr39.m_9236_() instanceof ServerLevel && _plr39.m_8960_().m_135996_(_plr39.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_curseis_lifted"))).m_8193_()) {
                                 var36 = "entity.jujutsucraft.rika_2";
                                 break label480;
                              }
                           }

                           var36 = "entity.jujutsucraft.rika";
                        }

                        name = Component.m_237115_(var36).getString();
                        cost = (double)150.0F;
                     } else if (p_selectNumber == (double)15.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.pure_love_cannon").getString();
                        cost = (double)1000.0F;
                     } else if (p_selectNumber == (double)19.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.rika2").getString();
                        cost = (double)0.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("jujutsu.technique.okkotsu20").getString();
                        cost = (double)1250.0F;
                     }
                  } else if (p_skill1 == (double)6.0F) {
                     if (p_selectNumber == (double)4.0F) {
                        p_passive = true;
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.cancel").getString();
                        cost = (double)0.0F;
                     } else if (p_selectNumber == (double)5.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.divine_dog_white").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.divine_dog_black").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber != (double)8.0F) {
                        if (p_selectNumber == (double)9.0F) {
                           name = Component.m_237115_("entity.jujutsucraft.great_serpent").getString();
                           cost = (double)300.0F;
                        } else if (p_selectNumber == (double)10.0F) {
                           name = Component.m_237115_("entity.jujutsucraft.toad").getString();
                           cost = (double)150.0F;
                        } else if (p_selectNumber == (double)7.0F) {
                           name = Component.m_237115_("entity.jujutsucraft.divine_dog_totality").getString();
                           cost = (double)400.0F;
                        }
                     } else {
                        label523: {
                           label466: {
                              if (entity.m_6144_()) {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr48 = (ServerPlayer)entity;
                                    if (_plr48.m_9236_() instanceof ServerLevel && _plr48.m_8960_().m_135996_(_plr48.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_nue_titan"))).m_8193_()) {
                                       break label466;
                                    }
                                 }

                                 if (entity instanceof Player) {
                                    Player _plr = (Player)entity;
                                    if (_plr.m_150110_().f_35937_) {
                                       break label466;
                                    }
                                 }
                              }

                              name = Component.m_237115_("entity.jujutsucraft.nue").getString();
                              cost = (double)250.0F;
                              break label523;
                           }

                           name = Component.m_237115_("entity.jujutsucraft.nue_totality").getString();
                           cost = (double)500.0F;
                        }
                     }

                     if (p_selectNumber == (double)11.0F) {
                        label452: {
                           label530: {
                              if (entity.m_6144_()) {
                                 label448: {
                                    label447: {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr56 = (ServerPlayer)entity;
                                          if (_plr56.m_9236_() instanceof ServerLevel && _plr56.m_8960_().m_135996_(_plr56.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_max_elephant"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique7") >= (double)0.0F) {
                                             break label447;
                                          }
                                       }

                                       if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique7") > (double)0.0F)) {
                                          break label448;
                                       }
                                    }

                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _plr59 = (ServerPlayer)entity;
                                       if (_plr59.m_9236_() instanceof ServerLevel && _plr59.m_8960_().m_135996_(_plr59.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_max_elephant_piercing_blood"))).m_8193_()) {
                                          break label530;
                                       }
                                    }
                                 }

                                 if (entity instanceof Player) {
                                    Player _plr = (Player)entity;
                                    if (_plr.m_150110_().f_35937_) {
                                       break label530;
                                    }
                                 }
                              }

                              name = Component.m_237115_("entity.jujutsucraft.max_elephant").getString();
                              cost = (double)750.0F;
                              break label452;
                           }

                           name = Component.m_237115_("jujutsu.technique.choso3").getString();
                           cost = (double)200.0F;
                        }
                     } else if (p_selectNumber == (double)12.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.rabbit_escape").getString();
                        cost = (double)125.0F;
                     } else if (p_selectNumber == (double)13.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.round_deer").getString();
                        cost = (double)600.0F;
                     } else if (p_selectNumber == (double)14.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.piercing_ox").getString();
                        cost = (double)400.0F;
                     } else if (p_selectNumber == (double)15.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.tiger_funeral").getString();
                        cost = (double)400.0F;
                     } else if (p_selectNumber == (double)17.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.merged_beast_agito").getString();
                        cost = (double)600.0F;
                     } else if (p_selectNumber == (double)18.0F) {
                        ItemStack var37;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var37 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var37 = ItemStack.f_41583_;
                        }

                        if (var37.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           p_passive = true;
                           name = Component.m_237115_("entity.jujutsucraft.eight_handled_sword_divergent_sila_divine_general_mahoraga").getString();
                           cost = (double)0.0F;
                        } else {
                           label421: {
                              label531: {
                                 if (entity.m_6144_()) {
                                    label417: {
                                       label416: {
                                          if (entity instanceof ServerPlayer) {
                                             ServerPlayer _plr72 = (ServerPlayer)entity;
                                             if (_plr72.m_9236_() instanceof ServerLevel && _plr72.m_8960_().m_135996_(_plr72.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= (double)0.0F) {
                                                break label416;
                                             }
                                          }

                                          if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique14") > (double)0.0F)) {
                                             break label417;
                                          }
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr75 = (ServerPlayer)entity;
                                          if (_plr75.m_9236_() instanceof ServerLevel && _plr75.m_8960_().m_135996_(_plr75.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga_wheel"))).m_8193_()) {
                                             break label531;
                                          }
                                       }
                                    }

                                    if (entity instanceof Player) {
                                       Player _plr = (Player)entity;
                                       if (_plr.m_150110_().f_35937_) {
                                          break label531;
                                       }
                                    }
                                 }

                                 name = Component.m_237115_("entity.jujutsucraft.eight_handled_sword_divergent_sila_divine_general_mahoraga").getString();
                                 cost = (double)1000.0F;
                                 break label421;
                              }

                              p_passive = true;
                              name = Component.m_237115_("item.jujutsucraft.mahoraga_wheel_helmet").getString();
                              cost = (double)1000.0F;
                           }
                        }
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("jujutsu.technique.chimera_shadow_garden").getString();
                        cost = (double)1250.0F;
                     }
                  } else if (p_skill1 == (double)7.0F) {
                     if (p_selectNumber == (double)3.0F) {
                        p_physical = true;
                        cost = (double)50.0F;
                        name = Component.m_237115_("jujutsu.technique.kick").getString();
                     } else if (p_selectNumber == (double)4.0F) {
                        p_physical = true;
                        cost = (double)50.0F;
                        name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     } else if (p_selectNumber == (double)5.0F) {
                        p_physical = true;
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.kashimo1").getString();
                        cost = (double)200.0F;
                     } else if (p_selectNumber == (double)10.0F) {
                        p_passive = true;
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.kashimo2").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)15.0F) {
                        p_passive = true;
                        name = Component.m_237115_("effect.mythical_beast_amber_effect").getString();
                        cost = (double)0.0F;
                     }

                     if (p_selectNumber == (double)16.0F) {
                        name = Component.m_237115_("jujutsu.technique.kashimo_ah").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)17.0F) {
                        name = Component.m_237115_("jujutsu.technique.kashimo_energy_wave").getString();
                        cost = (double)250.0F;
                     } else if (p_selectNumber == (double)19.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.flying_kick").getString();
                        cost = (double)400.0F;
                     }

                     if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = (double)1250.0F;
                     }
                  } else if (p_skill1 == (double)8.0F) {
                     if (p_selectNumber == (double)5.0F) {
                        name = Component.m_237115_("jujutsu.technique.dagon1").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("jujutsu.technique.dagon2").getString();
                        cost = (double)150.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        name = Component.m_237115_("jujutsu.technique.dagon3").getString();
                        cost = (double)150.0F;
                     } else if (p_selectNumber == (double)9.0F) {
                        name = Component.m_237115_("jujutsu.technique.dagon5").getString();
                        cost = (double)250.0F;
                     } else if (p_selectNumber == (double)10.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.bathynomus_giganteus").getString();
                        cost = (double)400.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("jujutsu.technique.dagon20").getString();
                        cost = (double)1250.0F;
                     }
                  } else if (p_skill1 == (double)9.0F) {
                     label513: {
                        if (p_selectNumber == (double)4.0F) {
                           ItemStack var38;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var38 = _livEnt.m_21205_();
                           } else {
                              var38 = ItemStack.f_41583_;
                           }

                           if (var38.m_41720_() == JujutsucraftModItems.GARUDA_ITEM.get()) {
                              p_physical = true;
                              name = Component.m_237115_("jujutsu.technique.attack7").getString();
                              cost = (double)50.0F;
                              break label513;
                           }
                        }

                        if (p_selectNumber == (double)5.0F) {
                           ItemStack var39;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var39 = _livEnt.m_21205_();
                           } else {
                              var39 = ItemStack.f_41583_;
                           }

                           if (var39.m_41720_() == JujutsucraftModItems.GARUDA_ITEM_BALL.get()) {
                              name = Component.m_237115_("jujutsu.technique.shoot").getString();
                              cost = (double)500.0F;
                              break label513;
                           }
                        }

                        if (p_selectNumber == (double)6.0F) {
                           name = Component.m_237115_("entity.jujutsucraft.garuda").getString();
                           cost = (double)75.0F;
                        } else if (p_selectNumber == (double)10.0F) {
                           p_passive = true;
                           name = Component.m_237115_("effect.star_rage").getString();
                           cost = (double)0.0F;
                        } else if (p_selectNumber == (double)20.0F) {
                           name = Component.m_237115_("jujutsu.technique.tsukumo_domain").getString();
                           cost = (double)1250.0F;
                        }
                     }
                  } else if (p_skill1 == (double)10.0F) {
                     if (p_selectNumber == (double)5.0F) {
                        name = Component.m_237115_("jujutsu.technique.choso1").getString();
                        cost = (double)120.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        name = Component.m_237115_("jujutsu.technique.choso2").getString();
                        cost = (double)25.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        name = Component.m_237115_("jujutsu.technique.choso3").getString();
                        cost = (double)200.0F;
                     } else if (p_selectNumber == (double)8.0F) {
                        name = Component.m_237115_("jujutsu.technique.choso4").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)9.0F) {
                        byte var40;
                        label378: {
                           p_passive = true;
                           name = Component.m_237115_("jujutsu.technique.choso5").getString();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt109 = (LivingEntity)entity;
                              if (_livEnt109.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                                 var40 = 0;
                                 break label378;
                              }
                           }

                           var40 = 100;
                        }

                        cost = (double)var40;
                     } else if (p_selectNumber == (double)16.0F) {
                        name = Component.m_237115_("jujutsu.technique.choso6").getString();
                        cost = (double)400.0F;
                     } else if (p_selectNumber == (double)18.0F) {
                        name = Component.m_237115_("item.jujutsucraft.wing_king_chestplate").getString();
                        cost = (double)150.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = (double)1250.0F;
                     }
                  }

                  if (p_selectNumber >= (double)0.0F && p_selectNumber <= (double)2.0F) {
                     name = Component.m_237115_("jujutsu.technique.attack" + Math.round(p_selectNumber + (double)1.0F)).getString();
                     p_physical = true;
                     cost = (double)0.0F;
                  } else if (p_selectNumber == (double)21.0F) {
                     name = Component.m_237115_("jujutsu.technique.cancel_domain").getString();
                     p_physical = true;
                     p_passive = true;
                     cost = (double)0.0F;
                  }

                  if (!name.equals("-----")) {
                     if (!ChangeTechniqueTestProcedure.execute(world, x, y, z, entity, p_skill1, p_selectNumber)) {
                        break;
                     }

                     name = "-----";
                  }

                  p_selectNumber += (double)(entity.m_6144_() ? -1 : 1);
                  if (p_selectNumber < (double)0.0F) {
                     p_selectNumber = (double)21.0F;
                  } else if (p_selectNumber > (double)21.0F) {
                     p_selectNumber = (double)0.0F;
                  }
               }

               TechniqueDecideProcedure.execute(entity, p_passive, p_physical, cost, p_skill1, p_selectNumber, name);
            } else {
               KeyChangeTechniqueOnKeyPressed2Procedure.execute(world, x, y, z, entity, p_skill1, p_selectNumber);
            }
         }

      }
   }
}
