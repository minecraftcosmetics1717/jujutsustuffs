package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.ModelTimeCellMoonPalace;
import net.mcreator.jujutsucraft.entity.EntityTimeCellMoonPalaceEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityTimeCellMoonPalaceRenderer extends MobRenderer<EntityTimeCellMoonPalaceEntity, ModelTimeCellMoonPalace<EntityTimeCellMoonPalaceEntity>> {
   public EntityTimeCellMoonPalaceRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelTimeCellMoonPalace(context.m_174023_(ModelTimeCellMoonPalace.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityTimeCellMoonPalaceEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/timecellmoonpalace.png");
   }
}
