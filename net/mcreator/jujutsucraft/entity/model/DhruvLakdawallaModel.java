package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.DhruvLakdawallaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DhruvLakdawallaModel extends GeoModel<DhruvLakdawallaEntity> {
   public ResourceLocation getAnimationResource(DhruvLakdawallaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/dhruv_lakdawalla.animation.json");
   }

   public ResourceLocation getModelResource(DhruvLakdawallaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/dhruv_lakdawalla.geo.json");
   }

   public ResourceLocation getTextureResource(DhruvLakdawallaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
