package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.HoshiKiraraEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HoshiKiraraModel extends GeoModel<HoshiKiraraEntity> {
   public ResourceLocation getAnimationResource(HoshiKiraraEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(HoshiKiraraEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(HoshiKiraraEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
