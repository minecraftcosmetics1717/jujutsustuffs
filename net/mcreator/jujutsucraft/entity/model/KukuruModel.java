package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.KukuruEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KukuruModel extends GeoModel<KukuruEntity> {
   public ResourceLocation getAnimationResource(KukuruEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KukuruEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KukuruEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
