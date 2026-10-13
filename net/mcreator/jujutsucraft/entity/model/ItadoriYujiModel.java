package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ItadoriYujiModel extends GeoModel<ItadoriYujiEntity> {
   public ResourceLocation getAnimationResource(ItadoriYujiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ItadoriYujiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ItadoriYujiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
