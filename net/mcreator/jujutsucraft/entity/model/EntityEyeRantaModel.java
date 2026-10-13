package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityEyeRantaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityEyeRantaModel extends GeoModel<EntityEyeRantaEntity> {
   public ResourceLocation getAnimationResource(EntityEyeRantaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/eye_ranta.animation.json");
   }

   public ResourceLocation getModelResource(EntityEyeRantaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/eye_ranta.geo.json");
   }

   public ResourceLocation getTextureResource(EntityEyeRantaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
