package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityBroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityBroomModel extends GeoModel<EntityBroomEntity> {
   public ResourceLocation getAnimationResource(EntityBroomEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/broom.animation.json");
   }

   public ResourceLocation getModelResource(EntityBroomEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/broom.geo.json");
   }

   public ResourceLocation getTextureResource(EntityBroomEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
