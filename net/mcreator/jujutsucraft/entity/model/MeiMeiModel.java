package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.MeiMeiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MeiMeiModel extends GeoModel<MeiMeiEntity> {
   public ResourceLocation getAnimationResource(MeiMeiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MeiMeiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MeiMeiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
