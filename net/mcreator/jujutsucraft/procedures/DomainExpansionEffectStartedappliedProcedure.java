package net.mcreator.jujutsucraft.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DomainExpansionEffectStartedappliedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double tick = (double)0.0F;
         double level = (double)0.0F;
         entity.getPersistentData().m_128347_("totalDamage", (double)0.0F);
         CompoundTag var10000 = entity.getPersistentData();
         double var10002;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10002 = (double)_livEnt.m_21223_();
         } else {
            var10002 = (double)-1.0F;
         }

         var10000.m_128347_("oldHealth", var10002);
      }
   }
}
