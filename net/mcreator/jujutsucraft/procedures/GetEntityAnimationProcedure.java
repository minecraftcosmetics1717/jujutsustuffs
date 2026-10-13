package net.mcreator.jujutsucraft.procedures;

import java.lang.reflect.Field;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.animatable.GeoEntity;

public class GetEntityAnimationProcedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         if (entity instanceof GeoEntity) {
            try {
               Field animationProcedureField = entity.getClass().getField("animationprocedure");
               return (String)animationProcedureField.get(entity);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }

         return "";
      }
   }
}
