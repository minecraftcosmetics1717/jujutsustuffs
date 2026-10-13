package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.ProjectileSlashEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ProjectileSlashModel extends GeoModel<ProjectileSlashEntity> {
   public ResourceLocation getAnimationResource(ProjectileSlashEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/projectile_slash.animation.json");
   }

   public ResourceLocation getModelResource(ProjectileSlashEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/projectile_slash.geo.json");
   }

   public ResourceLocation getTextureResource(ProjectileSlashEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ProjectileSlashEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
