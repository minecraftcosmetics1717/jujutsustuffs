package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class GetWeaponSizeProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double attack_reach = (double)0.0F;
         ItemStack item_a = ItemStack.f_41583_;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         item_a = var10000.m_41777_();
         attack_reach = (double)1.0F;
         if (item_a.m_41784_().m_128459_("Range") != (double)0.0F) {
            attack_reach = (double)1.0F + item_a.m_41784_().m_128459_("Range");
         }

         return attack_reach;
      }
   }
}
