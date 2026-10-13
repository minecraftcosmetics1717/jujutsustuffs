package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RikaModel extends GeoModel<RikaEntity> {
   public ResourceLocation getAnimationResource(RikaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/rika.animation.json");
   }

   public ResourceLocation getModelResource(RikaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/rika.geo.json");
   }

   public ResourceLocation getTextureResource(RikaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(RikaEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
