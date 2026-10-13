package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ChosoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChosoModel extends GeoModel<ChosoEntity> {
   public ResourceLocation getAnimationResource(ChosoEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ChosoEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ChosoEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
