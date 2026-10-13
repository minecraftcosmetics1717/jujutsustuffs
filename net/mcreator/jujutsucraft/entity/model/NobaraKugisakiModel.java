package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.NobaraKugisakiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NobaraKugisakiModel extends GeoModel<NobaraKugisakiEntity> {
   public ResourceLocation getAnimationResource(NobaraKugisakiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(NobaraKugisakiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(NobaraKugisakiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
