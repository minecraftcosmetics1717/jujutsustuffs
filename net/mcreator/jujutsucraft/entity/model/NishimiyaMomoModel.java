package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.NishimiyaMomoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NishimiyaMomoModel extends GeoModel<NishimiyaMomoEntity> {
   public ResourceLocation getAnimationResource(NishimiyaMomoEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(NishimiyaMomoEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(NishimiyaMomoEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
