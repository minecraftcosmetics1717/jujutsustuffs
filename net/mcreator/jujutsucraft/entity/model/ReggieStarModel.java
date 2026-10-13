package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ReggieStarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ReggieStarModel extends GeoModel<ReggieStarEntity> {
   public ResourceLocation getAnimationResource(ReggieStarEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ReggieStarEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ReggieStarEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
