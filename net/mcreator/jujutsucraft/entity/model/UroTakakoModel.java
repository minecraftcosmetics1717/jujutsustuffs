package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UroTakakoModel extends GeoModel<UroTakakoEntity> {
   public ResourceLocation getAnimationResource(UroTakakoEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/uro_takako.animation.json");
   }

   public ResourceLocation getModelResource(UroTakakoEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/uro_takako.geo.json");
   }

   public ResourceLocation getTextureResource(UroTakakoEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
