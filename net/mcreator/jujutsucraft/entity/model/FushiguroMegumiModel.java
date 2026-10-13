package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.FushiguroMegumiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FushiguroMegumiModel extends GeoModel<FushiguroMegumiEntity> {
   public ResourceLocation getAnimationResource(FushiguroMegumiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(FushiguroMegumiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(FushiguroMegumiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
