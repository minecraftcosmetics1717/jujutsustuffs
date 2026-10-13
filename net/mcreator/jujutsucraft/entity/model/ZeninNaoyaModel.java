package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ZeninNaoyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZeninNaoyaModel extends GeoModel<ZeninNaoyaEntity> {
   public ResourceLocation getAnimationResource(ZeninNaoyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ZeninNaoyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ZeninNaoyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
