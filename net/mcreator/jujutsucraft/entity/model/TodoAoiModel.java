package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.TodoAoiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TodoAoiModel extends GeoModel<TodoAoiEntity> {
   public ResourceLocation getAnimationResource(TodoAoiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/todo_aoi.animation.json");
   }

   public ResourceLocation getModelResource(TodoAoiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/todo_aoi.geo.json");
   }

   public ResourceLocation getTextureResource(TodoAoiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
