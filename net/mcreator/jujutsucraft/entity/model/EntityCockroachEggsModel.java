package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityCockroachEggsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityCockroachEggsModel extends GeoModel<EntityCockroachEggsEntity> {
   public ResourceLocation getAnimationResource(EntityCockroachEggsEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cockroach_eggs.animation.json");
   }

   public ResourceLocation getModelResource(EntityCockroachEggsEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cockroach_eggs.geo.json");
   }

   public ResourceLocation getTextureResource(EntityCockroachEggsEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
