package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.TransfiguredHumanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TransfiguredHumanModel extends GeoModel<TransfiguredHumanEntity> {
   public ResourceLocation getAnimationResource(TransfiguredHumanEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(TransfiguredHumanEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(TransfiguredHumanEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
