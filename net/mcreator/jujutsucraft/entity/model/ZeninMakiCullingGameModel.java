package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ZeninMakiCullingGameEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZeninMakiCullingGameModel extends GeoModel<ZeninMakiCullingGameEntity> {
   public ResourceLocation getAnimationResource(ZeninMakiCullingGameEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ZeninMakiCullingGameEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ZeninMakiCullingGameEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
