package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.minecraft.world.entity.Entity;

public class GojoSatoruDisplayConditionProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         if (entity instanceof GojoSatoruEntity) {
            GojoSatoruEntity _datEntL0 = (GojoSatoruEntity)entity;
            if ((Boolean)_datEntL0.m_20088_().m_135370_(GojoSatoruEntity.DATA_ghost)) {
               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }
}
