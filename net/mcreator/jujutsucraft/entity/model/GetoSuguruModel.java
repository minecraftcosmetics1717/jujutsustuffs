package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.GetoSuguruEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GetoSuguruModel extends GeoModel<GetoSuguruEntity> {
   public ResourceLocation getAnimationResource(GetoSuguruEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(GetoSuguruEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(GetoSuguruEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
