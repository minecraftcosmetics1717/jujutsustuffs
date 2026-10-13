package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityImpactWaveModel extends GeoModel<EntityImpactWaveEntity> {
   public ResourceLocation getAnimationResource(EntityImpactWaveEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/rubble.animation.json");
   }

   public ResourceLocation getModelResource(EntityImpactWaveEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/rubble.geo.json");
   }

   public ResourceLocation getTextureResource(EntityImpactWaveEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/clear.png");
   }

   public void setCustomAnimations(EntityImpactWaveEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
