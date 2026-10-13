package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EmberInsectEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EmberInsectModel extends GeoModel<EmberInsectEntity> {
   public ResourceLocation getAnimationResource(EmberInsectEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/ember_insects.animation.json");
   }

   public ResourceLocation getModelResource(EmberInsectEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/ember_insects.geo.json");
   }

   public ResourceLocation getTextureResource(EmberInsectEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EmberInsectEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("AllBody");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
