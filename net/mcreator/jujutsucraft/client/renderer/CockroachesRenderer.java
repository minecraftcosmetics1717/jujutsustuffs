package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelrock_fragment;
import net.mcreator.jujutsucraft.entity.CockroachesEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CockroachesRenderer extends MobRenderer<CockroachesEntity, Modelrock_fragment<CockroachesEntity>> {
   public CockroachesRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelrock_fragment(context.m_174023_(Modelrock_fragment.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CockroachesEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/clear.png");
   }
}
