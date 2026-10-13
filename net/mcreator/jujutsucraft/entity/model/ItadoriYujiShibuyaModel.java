package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ItadoriYujiShibuyaModel extends GeoModel<ItadoriYujiShibuyaEntity> {
   public ResourceLocation getAnimationResource(ItadoriYujiShibuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ItadoriYujiShibuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ItadoriYujiShibuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
