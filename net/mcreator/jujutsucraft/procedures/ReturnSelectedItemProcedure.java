package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.item.ItemStack;

public class ReturnSelectedItemProcedure {
   public static ItemStack execute(ItemStack item) {
      ItemStack itemstack_1 = ItemStack.f_41583_;
      itemstack_1 = item.m_41777_();
      if (itemstack_1.m_41720_() != ItemStack.f_41583_.m_41720_()) {
         itemstack_1.m_41784_().m_128379_("DistributionItem", true);
      }

      return itemstack_1;
   }
}
