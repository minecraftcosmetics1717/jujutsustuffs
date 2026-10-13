package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class SizeByNBTProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity0 = (LivingEntity)entity;
            if (_livingEntity0.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity1 = (LivingEntity)entity;
                  if (_livingEntity1.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity1.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22135_();
                     return var10000;
                  }
               }

               var10000 = (double)0.0F;
               return var10000;
            }
         }

         var10000 = (double)1.0F;
         return var10000;
      }
   }
}
