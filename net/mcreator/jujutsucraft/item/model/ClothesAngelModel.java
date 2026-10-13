package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.ClothesAngelItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesAngelModel extends GeoModel<ClothesAngelItem> {
   public ResourceLocation getAnimationResource(ClothesAngelItem object) {
      return new ResourceLocation("jujutsucraft", "animations/clothes_angel.animation.json");
   }

   public ResourceLocation getModelResource(ClothesAngelItem object) {
      return new ResourceLocation("jujutsucraft", "geo/clothes_angel.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesAngelItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/clothes_angel.png");
   }
}
