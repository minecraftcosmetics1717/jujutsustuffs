package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FushiguroTojiBugModel extends GeoModel<FushiguroTojiBugEntity> {
   public ResourceLocation getAnimationResource(FushiguroTojiBugEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(FushiguroTojiBugEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(FushiguroTojiBugEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
