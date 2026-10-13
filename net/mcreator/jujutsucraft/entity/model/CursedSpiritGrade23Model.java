package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade23Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade23Model extends GeoModel<CursedSpiritGrade23Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade23Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit2_3.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade23Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit2_3.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade23Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
