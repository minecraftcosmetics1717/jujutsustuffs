package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade16Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade16Model extends GeoModel<CursedSpiritGrade16Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_6.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_6.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
