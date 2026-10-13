package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.MiyoRokujushiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MiyoRokujushiModel extends GeoModel<MiyoRokujushiEntity> {
   public ResourceLocation getAnimationResource(MiyoRokujushiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MiyoRokujushiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MiyoRokujushiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
