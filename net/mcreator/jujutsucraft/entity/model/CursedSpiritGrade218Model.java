package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade218Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade218Model extends GeoModel<CursedSpiritGrade218Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade218Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit2_18.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade218Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit2_18.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade218Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
