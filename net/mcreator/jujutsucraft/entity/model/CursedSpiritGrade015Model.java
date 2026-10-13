package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade015Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade015Model extends GeoModel<CursedSpiritGrade015Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade015Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit0_15.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade015Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit0_15.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade015Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
