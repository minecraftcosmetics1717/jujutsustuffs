package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.DeathPaintingItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DeathPaintingItemModel extends GeoModel<DeathPaintingItem> {
   public ResourceLocation getAnimationResource(DeathPaintingItem animatable) {
      return new ResourceLocation("jujutsucraft", "animations/death_paintings.animation.json");
   }

   public ResourceLocation getModelResource(DeathPaintingItem animatable) {
      return new ResourceLocation("jujutsucraft", "geo/death_paintings.geo.json");
   }

   public ResourceLocation getTextureResource(DeathPaintingItem animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/death_paintings.png");
   }
}
