package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.MechamaruEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MechamaruModel extends GeoModel<MechamaruEntity> {
   public ResourceLocation getAnimationResource(MechamaruEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MechamaruEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MechamaruEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
