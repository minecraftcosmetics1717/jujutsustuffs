package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.HakariKinjiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HakariKinjiModel extends GeoModel<HakariKinjiEntity> {
   public ResourceLocation getAnimationResource(HakariKinjiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(HakariKinjiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(HakariKinjiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
