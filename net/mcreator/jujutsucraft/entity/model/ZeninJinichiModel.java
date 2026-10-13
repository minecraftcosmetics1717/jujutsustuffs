package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ZeninJinichiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZeninJinichiModel extends GeoModel<ZeninJinichiEntity> {
   public ResourceLocation getAnimationResource(ZeninJinichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ZeninJinichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ZeninJinichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
