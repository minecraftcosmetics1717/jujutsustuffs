package net.mcreator.jujutsucraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraft.client.model.Modelawaji_knot;
import net.mcreator.jujutsucraft.entity.EntityAwajiKnotEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityAwajiKnotRenderer extends MobRenderer<EntityAwajiKnotEntity, Modelawaji_knot<EntityAwajiKnotEntity>> {
   public EntityAwajiKnotRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelawaji_knot(context.m_174023_(Modelawaji_knot.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(EntityAwajiKnotEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(3.4F, 3.4F, 3.4F);
   }

   public ResourceLocation getTextureLocation(EntityAwajiKnotEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/awaji_knot.png");
   }
}
