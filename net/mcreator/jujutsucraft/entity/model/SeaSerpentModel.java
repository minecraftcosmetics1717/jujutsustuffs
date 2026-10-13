package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.SeaSerpentEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SeaSerpentModel extends GeoModel<SeaSerpentEntity> {
   public ResourceLocation getAnimationResource(SeaSerpentEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/dagon_fish1.animation.json");
   }

   public ResourceLocation getModelResource(SeaSerpentEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/dagon_fish1.geo.json");
   }

   public ResourceLocation getTextureResource(SeaSerpentEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SeaSerpentEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("all");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
