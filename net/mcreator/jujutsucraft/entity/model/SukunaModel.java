package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SukunaModel extends GeoModel<SukunaEntity> {
   public ResourceLocation getAnimationResource(SukunaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(SukunaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(SukunaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
