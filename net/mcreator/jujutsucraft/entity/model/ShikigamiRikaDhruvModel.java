package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ShikigamiRikaDhruvEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ShikigamiRikaDhruvModel extends GeoModel<ShikigamiRikaDhruvEntity> {
   public ResourceLocation getAnimationResource(ShikigamiRikaDhruvEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/shikigami_dhruvrakdawala3.animation.json");
   }

   public ResourceLocation getModelResource(ShikigamiRikaDhruvEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/shikigami_dhruvrakdawala3.geo.json");
   }

   public ResourceLocation getTextureResource(ShikigamiRikaDhruvEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ShikigamiRikaDhruvEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
