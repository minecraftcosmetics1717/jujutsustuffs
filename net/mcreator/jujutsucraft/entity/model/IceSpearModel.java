package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.IceSpearEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class IceSpearModel extends GeoModel<IceSpearEntity> {
   public ResourceLocation getAnimationResource(IceSpearEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/plojectile_crystal_ore.animation.json");
   }

   public ResourceLocation getModelResource(IceSpearEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/plojectile_crystal_ore.geo.json");
   }

   public ResourceLocation getTextureResource(IceSpearEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(IceSpearEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
