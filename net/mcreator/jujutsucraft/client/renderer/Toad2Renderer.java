package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modeltoad2;
import net.mcreator.jujutsucraft.entity.Toad2Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Toad2Renderer extends MobRenderer<Toad2Entity, Modeltoad2<Toad2Entity>> {
   public Toad2Renderer(EntityRendererProvider.Context context) {
      super(context, new Modeltoad2(context.m_174023_(Modeltoad2.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(Toad2Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/toad2.png");
   }
}
