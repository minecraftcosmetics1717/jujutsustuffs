package net.mcreator.jujutsucraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraft.client.model.Modelcursedspirit3_18;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade318Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade318Renderer extends MobRenderer<CursedSpiritGrade318Entity, Modelcursedspirit3_18<CursedSpiritGrade318Entity>> {
   public CursedSpiritGrade318Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_18(context.m_174023_(Modelcursedspirit3_18.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade318Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(0.8F, 0.8F, 0.8F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade318Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_18.png");
   }
}
