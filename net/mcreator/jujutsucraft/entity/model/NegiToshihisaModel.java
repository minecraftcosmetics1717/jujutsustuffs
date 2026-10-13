package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.NegiToshihisaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NegiToshihisaModel extends GeoModel<NegiToshihisaEntity> {
   public ResourceLocation getAnimationResource(NegiToshihisaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(NegiToshihisaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(NegiToshihisaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
