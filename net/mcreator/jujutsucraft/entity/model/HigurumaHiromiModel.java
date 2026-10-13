package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.HigurumaHiromiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HigurumaHiromiModel extends GeoModel<HigurumaHiromiEntity> {
   public ResourceLocation getAnimationResource(HigurumaHiromiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(HigurumaHiromiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(HigurumaHiromiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
