package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ShigemoHarutaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShigemoHarutaModel extends GeoModel<ShigemoHarutaEntity> {
   public ResourceLocation getAnimationResource(ShigemoHarutaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ShigemoHarutaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ShigemoHarutaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
