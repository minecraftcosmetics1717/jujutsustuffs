package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EffectProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double effect = (double)0.0F;
         effect = entity.getPersistentData().m_128459_("effect");
         EffectCharactorProcedure.execute(world, entity, entityiterator);
         if (effect != (double)0.0F) {
            if (effect <= (double)5.0F) {
               if (effect == (double)1.0F) {
                  Effect1Procedure.execute(world, entity, entityiterator);
               } else if (effect == (double)2.0F) {
                  Effect2Procedure.execute(world, entity, entityiterator);
               } else if (effect == (double)3.0F) {
                  Effect3Procedure.execute(world, entity, entityiterator);
               } else if (effect == (double)4.0F) {
                  Effect4Procedure.execute(world, entity, entityiterator);
               } else if (effect == (double)5.0F) {
                  Effect5Procedure.execute(world, entity, entityiterator);
               }
            } else if (effect <= (double)10.0F) {
               if (effect == (double)6.0F) {
                  Effect6Procedure.execute(world, entityiterator);
               } else if (effect == (double)7.0F) {
                  Effect7Procedure.execute(world, x, y, z, entity);
               } else if (effect == (double)8.0F) {
                  Effect8Procedure.execute(world, entityiterator);
               } else if (effect == (double)9.0F) {
                  Effect9Procedure.execute(world, entityiterator);
               } else if (effect == (double)10.0F) {
                  Effect10Procedure.execute(world, entity, entityiterator);
               }
            } else if (effect <= (double)15.0F) {
               if (effect == (double)11.0F) {
                  Effect11Procedure.execute(world, entity, entityiterator);
               } else if (effect == (double)12.0F) {
                  Effect12Procedure.execute(world, entityiterator);
               } else if (effect == (double)13.0F) {
                  Effect13Procedure.execute(world, entity, entityiterator);
               } else if (effect == (double)14.0F) {
                  Effect14Procedure.execute(world, entityiterator);
               } else if (effect == (double)15.0F) {
                  Effect15Procedure.execute(entityiterator);
               }
            } else if (effect <= (double)20.0F) {
               if (effect == (double)16.0F) {
                  Effect16Procedure.execute(entityiterator);
               } else if (effect == (double)17.0F) {
                  Effect17Procedure.execute(world, entity, entityiterator);
               }
            } else if (effect >= (double)300.0F) {
               EffectCursedSpeechProcedure.execute(world, entity, entityiterator);
            }
         }

      }
   }
}
