package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LogicGuardSuccessProcedure {
   public static boolean execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean var10000;
         label33: {
            label32: {
               boolean guard = false;
               double skill = (double)0.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt0 = (LivingEntity)entity;
                  if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     break label32;
                  }
               }

               if (!entity.getPersistentData().m_128471_("guard")) {
                  var10000 = false;
                  break label33;
               }
            }

            var10000 = true;
         }

         boolean var6 = var10000;
         double var7 = entity.getPersistentData().m_128459_("skill");
         return !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entity != sourceentity && (var7 != (double)0.0F || var6) && entity.getPersistentData().m_128459_("Damage") > (double)0.0F;
      } else {
         return false;
      }
   }
}
