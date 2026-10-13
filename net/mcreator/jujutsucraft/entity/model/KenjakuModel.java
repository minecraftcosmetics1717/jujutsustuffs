package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KenjakuModel extends GeoModel<KenjakuEntity> {
   public ResourceLocation getAnimationResource(KenjakuEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KenjakuEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KenjakuEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
