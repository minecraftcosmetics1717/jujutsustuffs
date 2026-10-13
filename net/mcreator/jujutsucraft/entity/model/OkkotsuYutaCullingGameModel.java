package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OkkotsuYutaCullingGameModel extends GeoModel<OkkotsuYutaCullingGameEntity> {
   public ResourceLocation getAnimationResource(OkkotsuYutaCullingGameEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(OkkotsuYutaCullingGameEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(OkkotsuYutaCullingGameEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
