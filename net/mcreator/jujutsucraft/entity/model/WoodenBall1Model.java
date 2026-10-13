package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.WoodenBall1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WoodenBall1Model extends GeoModel<WoodenBall1Entity> {
   public ResourceLocation getAnimationResource(WoodenBall1Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/wooden_ball.animation.json");
   }

   public ResourceLocation getModelResource(WoodenBall1Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/wooden_ball.geo.json");
   }

   public ResourceLocation getTextureResource(WoodenBall1Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(WoodenBall1Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
