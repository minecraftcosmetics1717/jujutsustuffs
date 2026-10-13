package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.JujutsuSorcererEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JujutsuSorcererModel extends GeoModel<JujutsuSorcererEntity> {
   public ResourceLocation getAnimationResource(JujutsuSorcererEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(JujutsuSorcererEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(JujutsuSorcererEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
