package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade02Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade02Model extends GeoModel<CursedSpiritGrade02Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/hanako.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/hanako.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
