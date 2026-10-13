package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.FushiguroMegumiShibuyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FushiguroMegumiShibuyaModel extends GeoModel<FushiguroMegumiShibuyaEntity> {
   public ResourceLocation getAnimationResource(FushiguroMegumiShibuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(FushiguroMegumiShibuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(FushiguroMegumiShibuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
