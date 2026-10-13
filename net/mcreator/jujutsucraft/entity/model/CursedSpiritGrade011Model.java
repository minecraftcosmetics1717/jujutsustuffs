package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade011Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade011Model extends GeoModel<CursedSpiritGrade011Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade011Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/gashadokuro.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade011Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/gashadokuro.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade011Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
