package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade217Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade217Model extends GeoModel<CursedSpiritGrade217Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit2_17.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit2_17.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
