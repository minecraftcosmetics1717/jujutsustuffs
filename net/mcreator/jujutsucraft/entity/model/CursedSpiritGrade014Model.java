package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade014Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade014Model extends GeoModel<CursedSpiritGrade014Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade014Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit0_14.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade014Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit0_14.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade014Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
