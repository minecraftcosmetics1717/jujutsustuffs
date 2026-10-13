package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.ModelGreatSerpent;
import net.mcreator.jujutsucraft.entity.GreatSerpentEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GreatSerpentRenderer extends MobRenderer<GreatSerpentEntity, ModelGreatSerpent<GreatSerpentEntity>> {
   public GreatSerpentRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelGreatSerpent(context.m_174023_(ModelGreatSerpent.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(GreatSerpentEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/greatserpent.png");
   }
}
