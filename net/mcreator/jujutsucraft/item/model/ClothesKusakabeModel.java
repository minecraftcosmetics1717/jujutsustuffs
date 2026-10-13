package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.ClothesKusakabeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesKusakabeModel extends GeoModel<ClothesKusakabeItem> {
   public ResourceLocation getAnimationResource(ClothesKusakabeItem object) {
      return new ResourceLocation("jujutsucraft", "animations/clothes_kusakabe.animation.json");
   }

   public ResourceLocation getModelResource(ClothesKusakabeItem object) {
      return new ResourceLocation("jujutsucraft", "geo/clothes_kusakabe.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesKusakabeItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/clothes_kusakabe.png");
   }
}
