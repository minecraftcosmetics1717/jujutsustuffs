package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.MiguelEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MiguelModel extends GeoModel<MiguelEntity> {
   public ResourceLocation getAnimationResource(MiguelEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MiguelEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MiguelEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
