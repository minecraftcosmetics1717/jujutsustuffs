package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FushiguroTojiModel extends GeoModel<FushiguroTojiEntity> {
   public ResourceLocation getAnimationResource(FushiguroTojiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(FushiguroTojiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(FushiguroTojiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
