package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EffectConfirmProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double effect = (double)0.0F;
         effect = entity.getPersistentData().m_128459_("effectConfirm");
         if (effect != (double)0.0F) {
            if (effect == (double)1.0F) {
               EffectConfirm1Procedure.execute(world, entity, entityiterator);
            } else if (effect == (double)2.0F) {
               EffectConfirm2Procedure.execute(entityiterator);
            } else if (effect == (double)3.0F) {
               EffectConfirm3Procedure.execute(entityiterator);
            } else if (effect == (double)4.0F) {
               EffectConfirm4Procedure.execute(entityiterator);
            }
         }

         EffectConfilmCharactorProcedure.execute(world, x, y, z, entity, entityiterator);
      }
   }
}
