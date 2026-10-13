package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade13Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade13Model extends GeoModel<CursedSpiritGrade13Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade13Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_3.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade13Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_3.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade13Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
