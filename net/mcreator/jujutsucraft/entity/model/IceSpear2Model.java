package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.IceSpear2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceSpear2Model extends GeoModel<IceSpear2Entity> {
   public ResourceLocation getAnimationResource(IceSpear2Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/ice_spear2.animation.json");
   }

   public ResourceLocation getModelResource(IceSpear2Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/ice_spear2.geo.json");
   }

   public ResourceLocation getTextureResource(IceSpear2Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
