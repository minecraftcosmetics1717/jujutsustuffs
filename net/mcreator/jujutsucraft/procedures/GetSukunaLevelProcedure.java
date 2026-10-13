package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class GetSukunaLevelProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double num1 = (double)0.0F;
         double cursed_technique2 = (double)0.0F;
         double cursed_technique = (double)0.0F;
         if (ReturnInsideItemProcedure.execute(entity).m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
            if (entity instanceof Player) {
               num1 = (double)((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41613_();
            } else {
               if (entity instanceof SukunaEntity) {
                  num1 = (double)16.0F;
               } else if (entity instanceof SukunaFushiguroEntity || entity instanceof SukunaPerfectEntity) {
                  num1 = (double)20.0F;
               }

               if (entity instanceof ItadoriYujiEntity) {
                  num1 = (double)3.0F;
               } else if (entity instanceof ItadoriYujiShibuyaEntity) {
                  num1 = (double)16.0F;
               }
            }
         }

         return num1;
      }
   }
}
