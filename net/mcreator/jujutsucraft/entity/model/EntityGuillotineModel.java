package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityGuillotineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityGuillotineModel extends GeoModel<EntityGuillotineEntity> {
   public ResourceLocation getAnimationResource(EntityGuillotineEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/guillotine.animation.json");
   }

   public ResourceLocation getModelResource(EntityGuillotineEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/guillotine.geo.json");
   }

   public ResourceLocation getTextureResource(EntityGuillotineEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
