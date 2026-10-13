package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EarthenInsectTranceEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EarthenInsectTranceModel extends GeoModel<EarthenInsectTranceEntity> {
   public ResourceLocation getAnimationResource(EarthenInsectTranceEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/earthen_insect_trance.animation.json");
   }

   public ResourceLocation getModelResource(EarthenInsectTranceEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/earthen_insect_trance.geo.json");
   }

   public ResourceLocation getTextureResource(EarthenInsectTranceEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EarthenInsectTranceEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
