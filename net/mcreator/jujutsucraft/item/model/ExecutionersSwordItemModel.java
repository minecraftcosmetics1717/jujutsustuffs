package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.ExecutionersSwordItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ExecutionersSwordItemModel extends GeoModel<ExecutionersSwordItem> {
   public ResourceLocation getAnimationResource(ExecutionersSwordItem animatable) {
      return new ResourceLocation("jujutsucraft", "animations/gavel.animation.json");
   }

   public ResourceLocation getModelResource(ExecutionersSwordItem animatable) {
      return new ResourceLocation("jujutsucraft", "geo/gavel.geo.json");
   }

   public ResourceLocation getTextureResource(ExecutionersSwordItem animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/gavel.png");
   }
}
