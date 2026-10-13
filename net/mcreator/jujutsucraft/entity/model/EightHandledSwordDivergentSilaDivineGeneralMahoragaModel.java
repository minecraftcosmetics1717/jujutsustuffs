package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EightHandledSwordDivergentSilaDivineGeneralMahoragaModel extends GeoModel<EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity> {
   public ResourceLocation getAnimationResource(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/mahoraga.animation.json");
   }

   public ResourceLocation getModelResource(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/mahoraga.geo.json");
   }

   public ResourceLocation getTextureResource(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
