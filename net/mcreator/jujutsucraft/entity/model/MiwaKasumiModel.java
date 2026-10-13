package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.MiwaKasumiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MiwaKasumiModel extends GeoModel<MiwaKasumiEntity> {
   public ResourceLocation getAnimationResource(MiwaKasumiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MiwaKasumiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MiwaKasumiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
