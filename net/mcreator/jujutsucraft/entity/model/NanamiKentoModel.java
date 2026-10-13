package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.NanamiKentoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NanamiKentoModel extends GeoModel<NanamiKentoEntity> {
   public ResourceLocation getAnimationResource(NanamiKentoEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(NanamiKentoEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(NanamiKentoEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
