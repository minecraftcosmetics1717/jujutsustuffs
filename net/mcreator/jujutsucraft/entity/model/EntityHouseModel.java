package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityHouseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityHouseModel extends GeoModel<EntityHouseEntity> {
   public ResourceLocation getAnimationResource(EntityHouseEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/reggie_house.animation.json");
   }

   public ResourceLocation getModelResource(EntityHouseEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/reggie_house.geo.json");
   }

   public ResourceLocation getTextureResource(EntityHouseEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityHouseEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
