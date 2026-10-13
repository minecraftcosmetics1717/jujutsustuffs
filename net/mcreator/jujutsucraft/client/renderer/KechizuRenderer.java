package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelkechizu;
import net.mcreator.jujutsucraft.entity.KechizuEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KechizuRenderer extends MobRenderer<KechizuEntity, Modelkechizu<KechizuEntity>> {
   public KechizuRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelkechizu(context.m_174023_(Modelkechizu.LAYER_LOCATION)), 0.6F);
   }

   public ResourceLocation getTextureLocation(KechizuEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/kechizu.png");
   }
}
