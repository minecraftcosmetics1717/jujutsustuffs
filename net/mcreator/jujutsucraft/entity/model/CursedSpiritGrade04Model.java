package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade04Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade04Model extends GeoModel<CursedSpiritGrade04Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade04Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit0_4.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade04Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit0_4.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade04Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
