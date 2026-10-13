package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.DaidoHaganeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DaidoHaganeModel extends GeoModel<DaidoHaganeEntity> {
   public ResourceLocation getAnimationResource(DaidoHaganeEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(DaidoHaganeEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(DaidoHaganeEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
