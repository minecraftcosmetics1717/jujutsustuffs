package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade112Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade112Model extends GeoModel<CursedSpiritGrade112Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade112Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_12.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade112Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_12.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade112Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
