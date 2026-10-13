package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.YoshinoJunpeiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YoshinoJunpeiModel extends GeoModel<YoshinoJunpeiEntity> {
   public ResourceLocation getAnimationResource(YoshinoJunpeiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(YoshinoJunpeiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(YoshinoJunpeiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
