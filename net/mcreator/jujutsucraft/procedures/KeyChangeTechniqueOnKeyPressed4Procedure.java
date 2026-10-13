package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressed4Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity != null) {
         String name = "";
         String STR1 = "";
         boolean reChange = false;
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = (double)0.0F;
         double old_select = (double)0.0F;
         double PlayerCurseTechnique = (double)0.0F;
         double NUM1 = (double)0.0F;
         double NUM2 = (double)0.0F;
         double p_skill1 = (double)0.0F;
         double p_selectNumber = (double)0.0F;
         p_skill1 = playerCT;
         p_selectNumber = playerSelect;
         if (playerCT <= (double)40.0F) {
            name = "-----";

            for(int index0 = 0; index0 < 25; ++index0) {
               p_passive = false;
               p_physical = false;
               if (p_skill1 == (double)31.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.kusakabe1").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.kusakabe3").getString();
                     cost = (double)200.0F;
                  }
               } else if (p_skill1 == (double)32.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.chojuro1").getString();
                     cost = (double)120.0F;
                  } else if (p_selectNumber == (double)9.0F) {
                     name = Component.m_237115_("jujutsu.technique.chojuro2").getString();
                     cost = (double)350.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)33.0F) {
                  if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.yaga6").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.yaga10").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     name = Component.m_237115_("jujutsu.technique.yaga15").getString();
                     cost = (double)500.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)34.0F) {
                  if (p_selectNumber == (double)5.0F) {
                  }

                  if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.kugisaki2").getString();
                     cost = (double)100.0F;
                  } else {
                     if (p_selectNumber == (double)7.0F) {
                     }

                     if (p_selectNumber == (double)20.0F) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = (double)1000.0F;
                     }
                  }
               } else if (p_skill1 == (double)35.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.moon_dregs").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)36.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.nishimiya1").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.nishimiya2").getString();
                     cost = (double)120.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.nishimiya3").getString();
                     cost = (double)400.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)37.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.shikigami_heterocephalus_glaber").getString();
                     cost = (double)500.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.shikigami_pterosaur").getString();
                     cost = (double)500.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     p_passive = true;
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.cancel").getString();
                     cost = (double)0.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)38.0F) {
                  if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.uro10").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)39.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack6").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     cost = (double)50.0F;
                  }

                  if (p_selectNumber == (double)8.0F) {
                     cost = (double)10.0F;
                     name = Component.m_237115_("jujutsu.technique.yorozu9").getString();
                  } else if (p_selectNumber == (double)9.0F) {
                     cost = (double)25.0F;
                     name = Component.m_237115_("jujutsu.technique.yorozu10").getString();
                  } else if (p_selectNumber == (double)12.0F) {
                     if (LocateLiquidMetalProcedure.execute(world, entity)) {
                        p_physical = true;
                        String var10000 = Component.m_237115_("jujutsu.technique.yorozu8").getString();
                        name = var10000 + ": " + Component.m_237115_("jujutsu.message.cancel").getString();
                        cost = (double)0.0F;
                     } else {
                        name = Component.m_237115_("jujutsu.technique.yorozu8").getString();
                        cost = (double)400.0F;
                     }
                  } else if (p_selectNumber == (double)14.0F) {
                     label183: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt33 = (LivingEntity)entity;
                           if (_livEnt33.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                              p_physical = true;
                              String var36 = Component.m_237115_("item.jujutsucraft.insect_armor_chestplate").getString();
                              name = var36 + ": " + Component.m_237115_("jujutsu.message.cancel").getString();
                              cost = (double)0.0F;
                              break label183;
                           }
                        }

                        name = Component.m_237115_("item.jujutsucraft.insect_armor_chestplate").getString();
                        cost = (double)1200.0F;
                     }
                  } else if (p_selectNumber == (double)15.0F) {
                     if (LocateTrueSphereProcedure.execute(world, entity)) {
                        p_physical = true;
                        String var37 = Component.m_237115_("entity.jujutsucraft.true_sphere").getString();
                        name = var37 + ": " + Component.m_237115_("jujutsu.message.cancel").getString();
                        cost = (double)0.0F;
                     } else {
                        name = Component.m_237115_("entity.jujutsucraft.true_sphere").getString();
                        cost = (double)1500.0F;
                     }
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("jujutsu.technique.yorozu20").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)40.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.ino1").getString();
                     cost = (double)150.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     p_passive = true;
                     name = Component.m_237115_("jujutsu.technique.ino2").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     p_passive = true;
                     name = Component.m_237115_("jujutsu.technique.ino3").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     name = Component.m_237115_("jujutsu.technique.ino4").getString();
                     cost = (double)800.0F;
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
            KeyChangeTechniqueOnKeyPressed5Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
         }

      }
   }
}
