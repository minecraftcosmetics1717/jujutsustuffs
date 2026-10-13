package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.KusakabeAtsuyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KusakabeAtsuyaModel extends GeoModel<KusakabeAtsuyaEntity> {
   public ResourceLocation getAnimationResource(KusakabeAtsuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KusakabeAtsuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KusakabeAtsuyaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
