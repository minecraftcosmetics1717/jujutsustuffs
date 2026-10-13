package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.GavelBigItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GavelBigItemModel extends GeoModel<GavelBigItem> {
   public ResourceLocation getAnimationResource(GavelBigItem animatable) {
      return new ResourceLocation("jujutsucraft", "animations/gavel.animation.json");
   }

   public ResourceLocation getModelResource(GavelBigItem animatable) {
      return new ResourceLocation("jujutsucraft", "geo/gavel.geo.json");
   }

   public ResourceLocation getTextureResource(GavelBigItem animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/gavel.png");
   }
}
