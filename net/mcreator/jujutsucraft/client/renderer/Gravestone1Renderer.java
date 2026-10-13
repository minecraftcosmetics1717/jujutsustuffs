package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelgravestone1;
import net.mcreator.jujutsucraft.entity.Gravestone1Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Gravestone1Renderer extends MobRenderer<Gravestone1Entity, Modelgravestone1<Gravestone1Entity>> {
   public Gravestone1Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelgravestone1(context.m_174023_(Modelgravestone1.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(Gravestone1Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/gravestone.png");
   }
}
