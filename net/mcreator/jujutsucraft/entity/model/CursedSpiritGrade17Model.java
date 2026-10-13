package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade17Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade17Model extends GeoModel<CursedSpiritGrade17Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_7.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_7.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
