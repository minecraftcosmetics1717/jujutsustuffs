package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.PlayfulCloudItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlayfulCloudItemModel extends GeoModel<PlayfulCloudItem> {
   public ResourceLocation getAnimationResource(PlayfulCloudItem animatable) {
      return new ResourceLocation("jujutsucraft", "animations/playful_cloud.animation.json");
   }

   public ResourceLocation getModelResource(PlayfulCloudItem animatable) {
      return new ResourceLocation("jujutsucraft", "geo/playful_cloud.geo.json");
   }

   public ResourceLocation getTextureResource(PlayfulCloudItem animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/playful_cloud.png");
   }
}
