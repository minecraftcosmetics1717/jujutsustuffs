package net.mcreator.jujutsucraft.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressed5Procedure {
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
         if (playerCT <= (double)50.0F) {
            name = "-----";

            for(int index0 = 0; index0 < 25; ++index0) {
               p_passive = false;
               p_physical = false;
               if (p_skill1 == (double)41.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("jujutsu.technique.kaori2").getString();
                     cost = (double)75.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.kaori1").getString();
                     cost = (double)150.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)42.0F) {
                  cost = (double)0.0F;
               } else if (p_skill1 == (double)43.0F) {
                  if (p_selectNumber == (double)3.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)4.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.rozetsu_shikigami").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.rozetsu_shikigami_vessel").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.rozetsu_shikigami_vessel_2").getString();
                     cost = (double)400.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("jujutsu.technique.rozetsu_domain").getString();
                     cost = (double)1250.0F;
                  }
               } else if (p_skill1 == (double)44.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("item.jujutsucraft.kitchen_knife").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.car").getString();
                     cost = (double)200.0F;
                  } else if (p_selectNumber == (double)11.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.truck").getString();
                     cost = (double)300.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.entity_house").getString();
                     cost = (double)600.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)45.0F) {
                  if (p_selectNumber == (double)5.0F) {
                     name = Component.m_237115_("item.jujutsucraft.tooth").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("item.jujutsucraft.eye").getString();
                     cost = (double)400.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)46.0F) {
                  if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("entity.jujutsucraft.entity_eye_ranta").getString();
                     cost = (double)250.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)47.0F) {
                  if (p_selectNumber == (double)4.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)5.0F) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.crystal1").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)6.0F) {
                     name = Component.m_237115_("jujutsu.technique.crystal2").getString();
                     cost = (double)50.0F;
                  } else if (p_selectNumber == (double)7.0F) {
                     name = Component.m_237115_("jujutsu.technique.crystal3").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)8.0F) {
                     name = Component.m_237115_("jujutsu.technique.crystal4").getString();
                     cost = (double)400.0F;
                  } else if (p_selectNumber == (double)9.0F) {
                     name = Component.m_237115_("jujutsu.technique.crystal5").getString();
                     cost = (double)300.0F;
                  } else if (p_selectNumber == (double)10.0F) {
                     name = Component.m_237115_("jujutsu.technique.crystal6").getString();
                     cost = (double)100.0F;
                  } else if (p_selectNumber == (double)15.0F) {
                     name = Component.m_237115_("jujutsu.technique.crystal7").getString();
                     cost = (double)500.0F;
                  } else if (p_selectNumber == (double)20.0F) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = (double)1000.0F;
                  }
               } else if (p_skill1 == (double)48.0F) {
                  cost = (double)0.0F;
               } else if (p_skill1 == (double)49.0F) {
                  cost = (double)0.0F;
               } else if (p_skill1 == (double)50.0F) {
                  cost = (double)0.0F;
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
         }

      }
   }
}
