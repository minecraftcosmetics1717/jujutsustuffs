package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class ResetCounterProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double number = (double)0.0F;
         double Level = (double)0.0F;
         boolean logic_a = false;
         boolean CREATIVE = false;
         entity.getPersistentData().m_128347_("Damage", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt3", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt4", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt6", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt7", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt8", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt9", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt10", (double)0.0F);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)10.0F);
         entity.getPersistentData().m_128379_("attack", false);
         entity.getPersistentData().m_128379_("betrayal", false);
      }
   }
}
