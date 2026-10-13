package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressed2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity != null) {
         String name = "";
         String STR1 = "";
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = (double)0.0F;
         double NUM1 = (double)0.0F;
         double NUM2 = (double)0.0F;
         double p_skill1 = (double)0.0F;
         double p_selectNumber = (double)0.0F;
         p_skill1 = playerCT;
         p_selectNumber = playerSelect;
         if (playerCT <= (double)20.0F) {
            name = "-----";

            for(int index0 = 0; index0 < 52; ++index0) {
               p_passive = false;
               p_physical = false;
               if (p_skill1 == (double)11.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     p_physical = true;
                     cost = (double)50.0F;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack8").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     name = Component.m_237115_("jujutsu.technique.bird_strike").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)12.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.granite_blast").getString() + "1";
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.granite_blast").getString() + "2";
                     cost = (double)300.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("jujutsu.technique.ishigori_domain").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)13.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     p_passive = true;
                     name = Component.m_237115_("jujutsu.technique.nanami1").getString();
                     cost = (double)25.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     cost = (double)50.0F;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                  } else if (p_selectNumber == (double)7.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.nanami2").getString();
                     cost = (double)400.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("jujutsu.technique.nanami_domain").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)14.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.hanami1").getString();
                     cost = (double)120.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.hanami2").getString();
                     cost = (double)80.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.hanami10").getString();
                     cost = (double)500.0F;
                  } else {
                     label391: {
                        label317: {
                           if (p_selectNumber == (double)15.0F) {
                              ItemStack var49;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var49 = _livEnt.m_21205_();
                              } else {
                                 var49 = ItemStack.f_41583_;
                              }

                              if (var49.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                 break label317;
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var49 = _livEnt.m_21206_();
                              } else {
                                 var49 = ItemStack.f_41583_;
                              }

                              if (var49.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                 break label317;
                              }
                           }

                           if (p_selectNumber == (double)20.0F) {
                              name = Component.m_237115_("jujutsu.technique.hanami_domain").getString();
                              cost = (double)1250.0F;
                           }
                           break label391;
                        }

                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.hanami15").getString();
                        cost = (double)0.0F;
                     }
                  }
               } else if (p_skill1 == (double)15.0F) {
                  if (p_selectNumber == (double)3.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack6").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)4.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     cost = (double)50.0F;
                  }

                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.idle_transfiguration").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.entity_mahito_hand_3").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     name = Component.m_237115_("jujutsu.technique.mahito7").getString();
                     cost = (double)25.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     String var45 = Component.m_237115_("jujutsu.technique.mahito_soul_multiplicity").getString();
                     name = var45 + ": " + Component.m_237115_("jujutsu.technique.mahito_body_repel1").getString();
                     cost = (double)150.0F;
                  } else if (p_selectNumber == (double)9.0F) {
                     String var46 = Component.m_237115_("jujutsu.technique.mahito_soul_multiplicity").getString();
                     name = var46 + ": " + Component.m_237115_("jujutsu.technique.mahito_body_repel2").getString();
                     cost = (double)300.0F;
                  }

                  if (p_selectNumber == (double)10.0F) {
                     String var47 = Component.m_237115_("jujutsu.technique.mahito_soul_multiplicity").getString();
                     name = var47 + ": " + Component.m_237115_("entity.jujutsucraft.polymorphic_soul_isomer").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     String var48 = Component.m_237115_("jujutsu.technique.mahito_idel_mutation").getString();
                     name = var48 + ": " + Component.m_237115_("effect.instant_spirit_bodyof_distorted_killing_effect").getString();
                     cost = (double)500.0F;
                  } else if (p_selectNumber == (double)16.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack8").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("jujutsu.technique.mahito_domain").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)16.0F) {
                  if (p_selectNumber == (double)4.0F) {
                     p_physical = true;
                     cost = (double)50.0F;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                  } else if (p_selectNumber == (double)5.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack6").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.air_cannon").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.mahoraga8").getString();
                     cost = (double)150.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.mahoraga15").getString();
                     cost = (double)300.0F;
                  } else if (p_selectNumber == (double)19.0F) {
                     label400: {
                        ItemStack var10000;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                              break label400;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41784_().m_128459_("skill205") >= (double)1000.0F) {
                           name = Component.m_237115_("jujutsu.technique.mahoraga19").getString();
                           cost = (double)500.0F;
                        }
                     }
                  }
               } else if (p_skill1 == (double)17.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.flying_kick").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.message.takaba2").getString();
                     cost = (double)500.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     name = Component.m_237115_("jujutsu.message.takaba1").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 != (double)18.0F) {
                  if (p_skill1 == (double)19.0F) {
                     if (p_selectNumber == (double)5.0F) {
                        p_passive = true;
                        name = Component.m_237115_("effect.projection_sorcery").getString();
                        cost = (double)40.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        name = Component.m_237115_("jujutsu.technique.top_speed").getString();
                        cost = (double)300.0F;
                     } else if (p_selectNumber == (double)10.0F) {
                        name = Component.m_237115_("jujutsu.technique.air_explode").getString();
                        cost = (double)125.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.entity_time_cell_moon_palace").getString();
                        cost = (double)1250.0F;
                     }
                  } else if (p_skill1 == (double)20.0F) {
                     if (p_selectNumber == (double)3.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack7").getString();
                        cost = (double)50.0F;
                     } else if (p_selectNumber == (double)4.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack4").getString();
                        cost = (double)50.0F;
                     } else if (p_selectNumber == (double)5.0F) {
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.boogie_woogie").getString();
                        cost = (double)10.0F;
                     } else if (p_selectNumber == (double)6.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.todo_lariat").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)7.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack9").getString();
                        cost = (double)100.0F;
                     } else if (p_selectNumber == (double)15.0F) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.todo_ultra").getString();
                        cost = (double)600.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = (double)1250.0F;
                     }
                  }
               } else {
                  label402: {
                     if (p_selectNumber == (double)17.0F && entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           name = Component.m_237115_("jujutsu.technique.geto_set1").getString();
                           cost = (double)1500.0F;
                           break label402;
                        }
                     }

                     if (p_selectNumber == (double)18.0F && entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           cost = (double)1750.0F;
                           name = Component.m_237115_("jujutsu.technique.geto_set2").getString();
                           break label402;
                        }
                     }

                     if (p_selectNumber == (double)19.0F && entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           name = Component.m_237115_("jujutsu.technique.geto_set3").getString();
                           cost = (double)2000.0F;
                           break label402;
                        }
                     }

                     if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("entity.jujutsucraft.entity_womb_profusion").getString();
                        cost = (double)1250.0F;
                     } else if (entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                        if (p_selectNumber == (double)10.0F) {
                           p_passive = true;
                           p_physical = true;
                           name = Component.m_237115_("jujutsu.technique.cancel").getString();
                           cost = (double)0.0F;
                        } else if (p_selectNumber >= (double)11.0F && p_selectNumber <= (double)13.0F) {
                           p_passive = true;
                           NUM1 = (double)0.0F;
                           NUM2 = (double)-1.0F;

                           for(int index1 = 0; index1 < 10000; ++index1) {
                              ++NUM1;
                              STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                              if (entity.getPersistentData().m_128459_(STR1) == (double)0.0F) {
                                 if (p_selectNumber == (double)11.0F) {
                                    NUM2 = (double)1.0F;
                                 } else {
                                    if (p_selectNumber != (double)13.0F) {
                                       break;
                                    }

                                    NUM2 = (double)Math.round(NUM1 - (double)1.0F);
                                 }
                              } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName.contains(entity.getPersistentData().m_128461_(STR1 + "_name") + " ×")) {
                                 if (p_selectNumber == (double)11.0F) {
                                    NUM2 = (double)Math.round(NUM1 - (double)1.0F);
                                 } else if (p_selectNumber == (double)13.0F) {
                                    NUM2 = (double)Math.round(NUM1 + (double)1.0F);
                                 } else {
                                    NUM2 = (double)Math.round(NUM1);
                                 }
                              }

                              if (NUM2 != (double)-1.0F) {
                                 name = entity.getPersistentData().m_128461_("data_cursed_spirit_manipulation" + Math.round(NUM2) + "_name");
                                 if (name.equals("")) {
                                    name = "-----";
                                 } else {
                                    name = name + " ×" + Math.round(entity.getPersistentData().m_128459_("data_cursed_spirit_manipulation" + Math.round(NUM2) + "_num"));
                                    p_selectNumber = (double)12.0F;
                                 }
                                 break;
                              }
                           }

                           cost = (double)0.0F;
                        } else if (p_selectNumber == (double)15.0F) {
                           name = Component.m_237115_("jujutsu.technique.uzumaki").getString();
                           cost = (double)300.0F;
                        }
                     } else {
                        p_physical = true;
                        cost = (double)10.0F;
                     }
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
            KeyChangeTechniqueOnKeyPressed3Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
         }

      }
   }
}
