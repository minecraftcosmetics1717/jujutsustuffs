package net.mcreator.jujutsucraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraft.client.model.Modelgravestone4;
import net.mcreator.jujutsucraft.entity.Gravestone4Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Gravestone4Renderer extends MobRenderer<Gravestone4Entity, Modelgravestone4<Gravestone4Entity>> {
   public Gravestone4Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelgravestone4(context.m_174023_(Modelgravestone4.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(Gravestone4Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(3.0F, 3.0F, 3.0F);
   }

   public ResourceLocation getTextureLocation(Gravestone4Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/gravestone.png");
   }
}
