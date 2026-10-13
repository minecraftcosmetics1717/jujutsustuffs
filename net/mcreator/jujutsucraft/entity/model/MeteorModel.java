package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.MeteorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MeteorModel extends GeoModel<MeteorEntity> {
   public ResourceLocation getAnimationResource(MeteorEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/ball_maximum.animation.json");
   }

   public ResourceLocation getModelResource(MeteorEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/ball_maximum.geo.json");
   }

   public ResourceLocation getTextureResource(MeteorEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(MeteorEntity.DATA_mode) == 0 ? new ResourceLocation("jujutsucraft", "textures/entities/clear.png") : new ResourceLocation("jujutsucraft", "textures/entities/ball_maximum.png");
   }

   public void setCustomAnimations(MeteorEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("BallMain");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
