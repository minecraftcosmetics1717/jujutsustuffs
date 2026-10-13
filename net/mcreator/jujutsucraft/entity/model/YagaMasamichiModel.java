package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.YagaMasamichiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YagaMasamichiModel extends GeoModel<YagaMasamichiEntity> {
   public ResourceLocation getAnimationResource(YagaMasamichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(YagaMasamichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(YagaMasamichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
