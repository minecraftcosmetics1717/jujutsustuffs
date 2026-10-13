package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelmalevolent_shrine;
import net.mcreator.jujutsucraft.entity.EntityMalevolentShrineEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityMalevolentShrineRenderer extends MobRenderer<EntityMalevolentShrineEntity, Modelmalevolent_shrine<EntityMalevolentShrineEntity>> {
   public EntityMalevolentShrineRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelmalevolent_shrine(context.m_174023_(Modelmalevolent_shrine.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityMalevolentShrineEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/malevolent_shrine.png");
   }
}
