package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelcursedspirit3_22;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade322Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade322Renderer extends MobRenderer<CursedSpiritGrade322Entity, Modelcursedspirit3_22<CursedSpiritGrade322Entity>> {
   public CursedSpiritGrade322Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_22(context.m_174023_(Modelcursedspirit3_22.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade322Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/curesdspirit3_22.png");
   }
}
