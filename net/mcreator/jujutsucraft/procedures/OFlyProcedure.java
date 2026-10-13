package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class OFlyProcedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         double PASSIVE_POWERFIX = (double)0.0F;
         String STR1 = "";
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
               int var10000;
               label25: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()).m_19557_();
                        break label25;
                     }
                  }

                  var10000 = 0;
               }

               PASSIVE_POWERFIX = (double)Math.round((double)var10000 * 0.017 * (double)10.0F);
               STR1 = "§l§c";

               for(int index0 = 0; index0 < (int)PASSIVE_POWERFIX; ++index0) {
                  STR1 = STR1 + "■";
               }
            }
         }

         return STR1;
      }
   }
}
