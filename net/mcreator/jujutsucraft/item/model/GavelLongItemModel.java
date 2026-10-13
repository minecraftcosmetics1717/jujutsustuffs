package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.GavelLongItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GavelLongItemModel extends GeoModel<GavelLongItem> {
   public ResourceLocation getAnimationResource(GavelLongItem animatable) {
      return new ResourceLocation("jujutsucraft", "animations/gavel.animation.json");
   }

   public ResourceLocation getModelResource(GavelLongItem animatable) {
      return new ResourceLocation("jujutsucraft", "geo/gavel.geo.json");
   }

   public ResourceLocation getTextureResource(GavelLongItem animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/gavel.png");
   }
}
