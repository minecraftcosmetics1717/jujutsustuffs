package net.mcreator.jujutsucraft.item.model;

import net.mcreator.jujutsucraft.item.ItadoriYujiPaperItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ItadoriYujiPaperModel extends GeoModel<ItadoriYujiPaperItem> {
   public ResourceLocation getAnimationResource(ItadoriYujiPaperItem object) {
      return new ResourceLocation("jujutsucraft", "animations/itadori_paper.animation.json");
   }

   public ResourceLocation getModelResource(ItadoriYujiPaperItem object) {
      return new ResourceLocation("jujutsucraft", "geo/itadori_paper.geo.json");
   }

   public ResourceLocation getTextureResource(ItadoriYujiPaperItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/itadori_paper.png");
   }
}
