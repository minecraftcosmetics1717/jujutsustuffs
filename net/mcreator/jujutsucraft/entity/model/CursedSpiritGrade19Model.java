package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade19Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade19Model extends GeoModel<CursedSpiritGrade19Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_9.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_9.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade19Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
