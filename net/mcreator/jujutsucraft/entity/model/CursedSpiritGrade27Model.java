package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade27Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade27Model extends GeoModel<CursedSpiritGrade27Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade27Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit2_7.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade27Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit2_7.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade27Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
