package net.mcreator.jujutsucraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraft.entity.ProjectileSlashEntity;
import net.mcreator.jujutsucraft.entity.model.ProjectileSlashModel;
import net.mcreator.jujutsucraft.procedures.CanSeeSukunaSlashProcedure;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ProjectileSlashRenderer extends GeoEntityRenderer<ProjectileSlashEntity> {
   public ProjectileSlashRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new ProjectileSlashModel());
      this.f_114477_ = 0.0F;
   }

   public void render(ProjectileSlashEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
      Entity viewingPlayer = Minecraft.m_91087_().f_91074_;
      Level world = entity.m_9236_();
      if (viewingPlayer == null || CanSeeSukunaSlashProcedure.execute(world, entity, viewingPlayer)) {
         super.m_7392_(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
      }
   }

   public RenderType getRenderType(ProjectileSlashEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, ProjectileSlashEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(ProjectileSlashEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
