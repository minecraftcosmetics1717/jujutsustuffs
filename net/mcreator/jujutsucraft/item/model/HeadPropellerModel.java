package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.HeadPropellerItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HeadPropellerModel extends GeoModel<HeadPropellerItem> {
   public ResourceLocation getAnimationResource(HeadPropellerItem object) {
      return new ResourceLocation("jujutsucraft", "animations/head_propeller.animation.json");
   }

   public ResourceLocation getModelResource(HeadPropellerItem object) {
      return new ResourceLocation("jujutsucraft", "geo/head_propeller.geo.json");
   }

   public ResourceLocation getTextureResource(HeadPropellerItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/head_propeller.png");
   }
}
