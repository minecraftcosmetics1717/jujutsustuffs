package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.PandaNormalEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PandaNormalModel extends GeoModel<PandaNormalEntity> {
   public ResourceLocation getAnimationResource(PandaNormalEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(PandaNormalEntity.DATA_form) == 1 ? new ResourceLocation("jujutsucraft", "animations/panda_gorilla.animation.json") : new ResourceLocation("jujutsucraft", "animations/panda_normal.animation.json");
   }

   public ResourceLocation getModelResource(PandaNormalEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(PandaNormalEntity.DATA_form) == 1 ? new ResourceLocation("jujutsucraft", "geo/panda_gorilla.geo.json") : new ResourceLocation("jujutsucraft", "geo/panda_normal.geo.json");
   }

   public ResourceLocation getTextureResource(PandaNormalEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(PandaNormalEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
