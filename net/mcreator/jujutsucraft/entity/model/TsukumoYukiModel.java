package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.TsukumoYukiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TsukumoYukiModel extends GeoModel<TsukumoYukiEntity> {
   public ResourceLocation getAnimationResource(TsukumoYukiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(TsukumoYukiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(TsukumoYukiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
