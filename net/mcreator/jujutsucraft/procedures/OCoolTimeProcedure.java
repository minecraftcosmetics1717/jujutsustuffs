package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class OCoolTimeProcedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         int var10000;
         label38: {
            String STR1 = "";
            double NUM1 = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19557_();
                        break label38;
                     }
                  }

                  var10000 = 0;
                  break label38;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                  break label38;
               }
            }

            var10000 = 0;
         }

         double var8 = Math.ceil((double)var10000 * 0.1);
         String var7 = var8 > (double)0.0F ? "" + Math.round(var8) : "";
         return var7;
      }
   }
}
