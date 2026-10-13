package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.RozetsuShikigamiVessel2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RozetsuShikigamiVessel2Model extends GeoModel<RozetsuShikigamiVessel2Entity> {
   public ResourceLocation getAnimationResource(RozetsuShikigamiVessel2Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/rozetsu_shikigami_tenshadows_reinforce.animation.json");
   }

   public ResourceLocation getModelResource(RozetsuShikigamiVessel2Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/rozetsu_shikigami_tenshadows_reinforce.geo.json");
   }

   public ResourceLocation getTextureResource(RozetsuShikigamiVessel2Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
