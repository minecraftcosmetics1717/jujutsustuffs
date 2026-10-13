package net.mcreator.jujutsucraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraft.client.model.Modelcoffin;
import net.mcreator.jujutsucraft.entity.CoffinEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoffinRenderer extends MobRenderer<CoffinEntity, Modelcoffin<CoffinEntity>> {
   public CoffinRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelcoffin(context.m_174023_(Modelcoffin.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CoffinEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(1.1F, 1.1F, 1.1F);
   }

   public ResourceLocation getTextureLocation(CoffinEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/coffin.png");
   }
}
