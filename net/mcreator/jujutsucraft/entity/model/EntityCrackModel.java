package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityCrackEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityCrackModel extends GeoModel<EntityCrackEntity> {
   public ResourceLocation getAnimationResource(EntityCrackEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/crack.animation.json");
   }

   public ResourceLocation getModelResource(EntityCrackEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/crack.geo.json");
   }

   public ResourceLocation getTextureResource(EntityCrackEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityCrackEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bone");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
