package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.AwasakaJiroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AwasakaJiroModel extends GeoModel<AwasakaJiroEntity> {
   public ResourceLocation getAnimationResource(AwasakaJiroEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(AwasakaJiroEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(AwasakaJiroEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
