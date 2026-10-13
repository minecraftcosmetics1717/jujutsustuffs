package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade11Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade11Model extends GeoModel<CursedSpiritGrade11Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_1.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_1.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
