package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OkkotsuYutaModel extends GeoModel<OkkotsuYutaEntity> {
   public ResourceLocation getAnimationResource(OkkotsuYutaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(OkkotsuYutaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(OkkotsuYutaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
