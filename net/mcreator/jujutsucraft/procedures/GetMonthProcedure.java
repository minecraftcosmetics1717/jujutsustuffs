package net.mcreator.jujutsucraft.procedures;

import net.minecraft.network.chat.Component;

public class GetMonthProcedure {
   public static String execute(String month) {
      return month == null ? "" : Component.m_237115_("text.month." + month).getString();
   }
}
