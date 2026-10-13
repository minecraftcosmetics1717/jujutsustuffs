package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.item.ItemStack;

public class HanamiHandMakeItemGlowProcedure {
   public static boolean execute(ItemStack itemstack) {
      return itemstack.m_41784_().m_128459_("Power") > (double)0.0F;
   }
}
