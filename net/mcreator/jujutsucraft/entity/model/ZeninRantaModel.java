package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ZeninRantaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZeninRantaModel extends GeoModel<ZeninRantaEntity> {
   public ResourceLocation getAnimationResource(ZeninRantaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ZeninRantaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ZeninRantaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
