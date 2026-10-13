package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.SlotEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SlotModel extends GeoModel<SlotEntity> {
   public ResourceLocation getAnimationResource(SlotEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/slot_machine.animation.json");
   }

   public ResourceLocation getModelResource(SlotEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/slot_machine.geo.json");
   }

   public ResourceLocation getTextureResource(SlotEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
