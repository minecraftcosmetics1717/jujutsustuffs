package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityThreefoldAfflictionEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityThreefoldAfflictionModel extends GeoModel<EntityThreefoldAfflictionEntity> {
   public ResourceLocation getAnimationResource(EntityThreefoldAfflictionEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/threefold_affliction.animation.json");
   }

   public ResourceLocation getModelResource(EntityThreefoldAfflictionEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/threefold_affliction.geo.json");
   }

   public ResourceLocation getTextureResource(EntityThreefoldAfflictionEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
