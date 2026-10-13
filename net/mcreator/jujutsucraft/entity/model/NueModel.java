package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.NueEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NueModel extends GeoModel<NueEntity> {
   public ResourceLocation getAnimationResource(NueEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/nue.animation.json");
   }

   public ResourceLocation getModelResource(NueEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/nue.geo.json");
   }

   public ResourceLocation getTextureResource(NueEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
