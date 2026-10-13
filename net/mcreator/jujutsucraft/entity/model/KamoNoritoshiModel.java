package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.KamoNoritoshiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KamoNoritoshiModel extends GeoModel<KamoNoritoshiEntity> {
   public ResourceLocation getAnimationResource(KamoNoritoshiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KamoNoritoshiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KamoNoritoshiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
