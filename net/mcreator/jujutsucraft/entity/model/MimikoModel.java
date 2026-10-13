package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.MimikoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MimikoModel extends GeoModel<MimikoEntity> {
   public ResourceLocation getAnimationResource(MimikoEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MimikoEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MimikoEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
