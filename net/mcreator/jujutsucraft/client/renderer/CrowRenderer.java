package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelcrow;
import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrowRenderer extends MobRenderer<CrowEntity, Modelcrow<CrowEntity>> {
   public CrowRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelcrow(context.m_174023_(Modelcrow.LAYER_LOCATION)), 0.3F);
   }

   public ResourceLocation getTextureLocation(CrowEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/crow.png");
   }
}
