package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SukunaFushiguroModel extends GeoModel<SukunaFushiguroEntity> {
   public ResourceLocation getAnimationResource(SukunaFushiguroEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(SukunaFushiguroEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(SukunaFushiguroEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
