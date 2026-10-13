package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.KumiyaJuzoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KumiyaJuzoModel extends GeoModel<KumiyaJuzoEntity> {
   public ResourceLocation getAnimationResource(KumiyaJuzoEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KumiyaJuzoEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KumiyaJuzoEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
