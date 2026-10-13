package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KashimoHajimeModel extends GeoModel<KashimoHajimeEntity> {
   public ResourceLocation getAnimationResource(KashimoHajimeEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KashimoHajimeEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KashimoHajimeEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
