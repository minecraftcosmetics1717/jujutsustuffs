package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GojoSatoruModel extends GeoModel<GojoSatoruEntity> {
   public ResourceLocation getAnimationResource(GojoSatoruEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(GojoSatoruEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(GojoSatoruEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
