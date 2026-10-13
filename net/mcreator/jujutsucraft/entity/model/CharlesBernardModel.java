package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CharlesBernardEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CharlesBernardModel extends GeoModel<CharlesBernardEntity> {
   public ResourceLocation getAnimationResource(CharlesBernardEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(CharlesBernardEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(CharlesBernardEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
