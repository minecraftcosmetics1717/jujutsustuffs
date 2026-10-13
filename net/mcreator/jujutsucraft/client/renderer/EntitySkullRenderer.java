package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelskull1;
import net.mcreator.jujutsucraft.entity.EntitySkullEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntitySkullRenderer extends MobRenderer<EntitySkullEntity, Modelskull1<EntitySkullEntity>> {
   public EntitySkullRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelskull1(context.m_174023_(Modelskull1.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntitySkullEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/skull1.png");
   }
}
