package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.GetoSuguruCurseUserEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GetoSuguruCurseUserModel extends GeoModel<GetoSuguruCurseUserEntity> {
   public ResourceLocation getAnimationResource(GetoSuguruCurseUserEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(GetoSuguruCurseUserEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(GetoSuguruCurseUserEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
