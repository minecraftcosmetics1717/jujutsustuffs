package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade111Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade111Model extends GeoModel<CursedSpiritGrade111Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade111Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_11.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade111Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_11.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade111Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade111Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
