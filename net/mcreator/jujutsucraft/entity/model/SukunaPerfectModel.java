package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SukunaPerfectModel extends GeoModel<SukunaPerfectEntity> {
   public ResourceLocation getAnimationResource(SukunaPerfectEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(SukunaPerfectEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(SukunaPerfectEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
