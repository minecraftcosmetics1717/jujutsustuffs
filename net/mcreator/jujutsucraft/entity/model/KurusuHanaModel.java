package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.KurusuHanaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KurusuHanaModel extends GeoModel<KurusuHanaEntity> {
   public ResourceLocation getAnimationResource(KurusuHanaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KurusuHanaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KurusuHanaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
