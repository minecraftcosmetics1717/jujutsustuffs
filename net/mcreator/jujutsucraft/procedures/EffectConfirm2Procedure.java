package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class EffectConfirm2Procedure {
   public static void execute(Entity entityiterator) {
      if (entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         Entity entity_a = null;
         entityiterator.getPersistentData().m_128347_("Damage", (double)0.0F);
         entityiterator.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
      }
   }
}
