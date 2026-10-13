package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade013Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade013Model extends GeoModel<CursedSpiritGrade013Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade013Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit0_13.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade013Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit0_13.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade013Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
