package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.DivineDogBlackEntity;
import net.mcreator.jujutsucraft.entity.DivineDogTotalityEntity;
import net.mcreator.jujutsucraft.entity.DivineDogWhiteEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.GreatSerpentEntity;
import net.mcreator.jujutsucraft.entity.MaxElephantEntity;
import net.mcreator.jujutsucraft.entity.MergedBeastAgitoEntity;
import net.mcreator.jujutsucraft.entity.NueEntity;
import net.mcreator.jujutsucraft.entity.PiercingOxEntity;
import net.mcreator.jujutsucraft.entity.RabbitEscapeEntity;
import net.mcreator.jujutsucraft.entity.RoundDeerEntity;
import net.mcreator.jujutsucraft.entity.TigerFuneralEntity;
import net.mcreator.jujutsucraft.entity.ToadEntity;
import net.minecraft.world.entity.Entity;

public class ReturnTenShadowsNumProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double NUM1 = (double)0.0F;
         if (entity instanceof DivineDogWhiteEntity) {
            NUM1 = (double)1.0F;
         } else if (entity instanceof DivineDogBlackEntity) {
            NUM1 = (double)2.0F;
         } else if (entity instanceof DivineDogTotalityEntity) {
            NUM1 = (double)3.0F;
         } else if (entity instanceof NueEntity) {
            NUM1 = (double)4.0F;
         } else if (entity instanceof GreatSerpentEntity) {
            NUM1 = (double)5.0F;
         } else if (entity instanceof ToadEntity) {
            NUM1 = (double)6.0F;
         } else if (entity instanceof MaxElephantEntity) {
            NUM1 = (double)7.0F;
         } else if (entity instanceof RabbitEscapeEntity) {
            NUM1 = (double)8.0F;
         } else if (entity instanceof RoundDeerEntity) {
            NUM1 = (double)9.0F;
         }

         if (entity instanceof PiercingOxEntity) {
            NUM1 = (double)10.0F;
         } else if (entity instanceof TigerFuneralEntity) {
            NUM1 = (double)11.0F;
         } else if (entity instanceof MergedBeastAgitoEntity) {
            NUM1 = (double)13.0F;
         } else if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
            NUM1 = (double)14.0F;
         }

         return NUM1;
      }
   }
}
