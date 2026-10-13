package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ZeninMakiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZeninMakiModel extends GeoModel<ZeninMakiEntity> {
   public ResourceLocation getAnimationResource(ZeninMakiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ZeninMakiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ZeninMakiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
