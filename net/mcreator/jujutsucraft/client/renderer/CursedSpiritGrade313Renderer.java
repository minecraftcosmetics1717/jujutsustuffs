package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelcursedspirit3_13;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade313Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade313Renderer extends MobRenderer<CursedSpiritGrade313Entity, Modelcursedspirit3_13<CursedSpiritGrade313Entity>> {
   public CursedSpiritGrade313Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_13(context.m_174023_(Modelcursedspirit3_13.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade313Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_13.png");
   }
}
