package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class LogicBetrayalProcedure {
   public static boolean execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         if (world.m_5776_()) {
            return false;
         } else {
            if (entityiterator instanceof LivingEntity && entity.getPersistentData().m_128471_("betrayal")) {
               if (entity == entityiterator) {
                  return true;
               }

               if (entity.getPersistentData().m_128471_("DomainAttack")) {
                  return true;
               }

               if (entity.getPersistentData().m_128471_("attack")) {
                  return true;
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }
}
