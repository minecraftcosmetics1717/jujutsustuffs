package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade03Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade03Model extends GeoModel<CursedSpiritGrade03Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade03Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/tamamonomae.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade03Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/tamamonomae.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade03Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
