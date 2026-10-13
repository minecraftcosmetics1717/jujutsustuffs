package net.mcreator.jujutsucraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraft.client.model.ModelMahitoHand4;
import net.mcreator.jujutsucraft.entity.BodyRepelEntity;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class BodyRepelRenderer extends MobRenderer<BodyRepelEntity, ModelMahitoHand4<BodyRepelEntity>> {
   public BodyRepelRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelMahitoHand4(context.m_174023_(ModelMahitoHand4.LAYER_LOCATION)), 1.0F);
   }

   protected void scale(BodyRepelEntity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(BodyRepelEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/mahitohand4.png");
   }
}
