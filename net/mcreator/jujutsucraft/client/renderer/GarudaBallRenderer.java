package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.ModelGaruda2;
import net.mcreator.jujutsucraft.entity.GarudaBallEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GarudaBallRenderer extends MobRenderer<GarudaBallEntity, ModelGaruda2<GarudaBallEntity>> {
   public GarudaBallRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelGaruda2(context.m_174023_(ModelGaruda2.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(GarudaBallEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/garuda.png");
   }
}
