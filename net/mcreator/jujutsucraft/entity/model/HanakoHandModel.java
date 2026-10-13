package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.HanakoHandEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class HanakoHandModel extends GeoModel<HanakoHandEntity> {
   public ResourceLocation getAnimationResource(HanakoHandEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/hanako_hand.animation.json");
   }

   public ResourceLocation getModelResource(HanakoHandEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/hanako_hand.geo.json");
   }

   public ResourceLocation getTextureResource(HanakoHandEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(HanakoHandEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
