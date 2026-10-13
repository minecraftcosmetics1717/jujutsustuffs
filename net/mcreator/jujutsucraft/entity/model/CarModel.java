package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CarModel extends GeoModel<CarEntity> {
   public ResourceLocation getAnimationResource(CarEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/car.animation.json");
   }

   public ResourceLocation getModelResource(CarEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/car.geo.json");
   }

   public ResourceLocation getTextureResource(CarEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
