package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CurseUserEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CurseUserModel extends GeoModel<CurseUserEntity> {
   public ResourceLocation getAnimationResource(CurseUserEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(CurseUserEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(CurseUserEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
