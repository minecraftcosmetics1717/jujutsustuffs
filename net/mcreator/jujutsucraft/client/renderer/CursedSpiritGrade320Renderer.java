package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelcursedspirit3_20;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade320Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade320Renderer extends MobRenderer<CursedSpiritGrade320Entity, Modelcursedspirit3_20<CursedSpiritGrade320Entity>> {
   public CursedSpiritGrade320Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_20(context.m_174023_(Modelcursedspirit3_20.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade320Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_20.png");
   }
}
