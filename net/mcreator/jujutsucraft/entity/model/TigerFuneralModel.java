package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.TigerFuneralEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TigerFuneralModel extends GeoModel<TigerFuneralEntity> {
   public ResourceLocation getAnimationResource(TigerFuneralEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/tigerfuneral.animation.json");
   }

   public ResourceLocation getModelResource(TigerFuneralEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/tigerfuneral.geo.json");
   }

   public ResourceLocation getTextureResource(TigerFuneralEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
