package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressed3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity != null) {
         String name = "";
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = (double)0.0F;
         double p_skill1 = (double)0.0F;
         double p_selectNumber = (double)0.0F;
         p_skill1 = playerCT;
         p_selectNumber = playerSelect;
         if (playerCT <= (double)30.0F) {
            name = "-----";

            for(int index0 = 0; index0 < 25; ++index0) {
               p_passive = false;
               p_physical = false;
               if (p_skill1 == (double)21.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.itadori1").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     name = Component.m_237115_("jujutsu.technique.dismantle").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)13.0F) {
                     name = Component.m_237115_("advancements.skill_piercing_blood.title").getString();
                     cost = (double)200.0F;
                  } else {
                     if (p_selectNumber == (double)14.0F) {
                     }

                     if (p_selectNumber == (double)18.0F) {
                        p_physical = true;
                        name = Component.m_237115_("effect.jujutsucraft.deep_concentration").getString();
                        cost = (double)1000.0F;
                     } else if (p_selectNumber == (double)19.0F) {
                        p_passive = true;
                        p_physical = true;
                        name = Component.m_237115_("effect.sukuna_effect").getString();
                        cost = (double)0.0F;
                     } else if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = (double)1250.0F;
                     }
                  }
               } else if (p_skill1 == (double)22.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.jinichi5").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     name = Component.m_237115_("jujutsu.technique.jinichi7").getString();
                     cost = (double)500.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     name = Component.m_237115_("jujutsu.technique.jinichi8").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.jinichi10").getString();
                     cost = (double)800.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)23.0F) {
                  if (p_selectNumber == (double)4.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.cockroach1").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.cockroach2").getString();
                     cost = (double)150.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     name = Component.m_237115_("jujutsu.technique.cockroach3").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.earthen_insect_trance").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)24.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.uraume_5").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.uraume_6").getString();
                     cost = (double)120.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     name = Component.m_237115_("jujutsu.technique.uraume_8").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)9.0F) {
                     name = Component.m_237115_("jujutsu.technique.uraume_9").getString();
                     cost = (double)300.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     cost = (double)800.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)25.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.gravestone_3").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.breath").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)26.0F) {
                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftModItems.SWORD_OGI.get() && p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("item.jujutsucraft.blazing_courage").getString();
                     cost = (double)100.0F;
                  }

                  if (p_selectNumber == (double)11.0F) {
                     name = Component.m_237115_("jujutsu.technique.ogi1").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)12.0F) {
                     name = Component.m_237115_("jujutsu.technique.ogi2").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)13.0F) {
                     name = Component.m_237115_("jujutsu.technique.ogi3").getString();
                     cost = (double)125.0F;
                  } else if (p_selectNumber == (double)14.0F) {
                     name = Component.m_237115_("jujutsu.technique.ogi4").getString();
                     cost = (double)150.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     name = Component.m_237115_("jujutsu.technique.ogi5").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)19.0F) {
                     name = Component.m_237115_("jujutsu.technique.ogi9").getString();
                     cost = (double)800.0F;
                  }

                  if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)27.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     p_physical = true;
                     name = Component.m_237115_("item.jujutsucraft.gavel").getString();
                     cost = (double)0.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.higuruma1").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.higuruma2").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack8").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)11.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.higuruma3").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)19.0F) {
                     p_physical = true;
                     p_passive = true;
                     name = Component.m_237115_("advancements.battle_hiromi_higuruma.title").getString();
                     cost = (double)0.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("jujutsu.technique.higuruma20").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)28.0F) {
                  if (p_selectNumber == (double)15.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.entity_jacobs_ladder_circle").getString();
                     cost = (double)700.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)29.0F) {
                  if (p_selectNumber == (double)4.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.flying_kick").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)5.0F) {
                     byte var28;
                     label247: {
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.hakari5").getString();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt49 = (LivingEntity)entity;
                           if (_livEnt49.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                              var28 = 0;
                              break label247;
                           }
                        }

                        var28 = 50;
                     }

                     cost = (double)var28;
                  } else if (p_selectNumber == (double)6.0F) {
                     byte var29;
                     label240: {
                        name = Component.m_237115_("jujutsu.technique.hakari6").getString();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt52 = (LivingEntity)entity;
                           if (_livEnt52.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                              var29 = 0;
                              break label240;
                           }
                        }

                        var29 = 50;
                     }

                     cost = (double)var29;
                  } else if (p_selectNumber == (double)7.0F) {
                     name = Component.m_237115_("jujutsu.technique.hakari7").getString();
                     cost = (double)0.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("jujutsu.technique.hakari20").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)30.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     p_passive = true;
                     name = Component.m_237115_("effect.jujutsucraft.prayer_song").getString();
                     cost = (double)400.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
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
            KeyChangeTechniqueOnKeyPressed4Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
         }

      }
   }
}
