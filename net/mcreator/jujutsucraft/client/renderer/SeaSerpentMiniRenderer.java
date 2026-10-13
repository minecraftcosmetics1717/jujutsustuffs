package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modeldagon_fish_mini;
import net.mcreator.jujutsucraft.entity.SeaSerpentMiniEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaSerpentMiniRenderer extends MobRenderer<SeaSerpentMiniEntity, Modeldagon_fish_mini<SeaSerpentMiniEntity>> {
   public SeaSerpentMiniRenderer(EntityRendererProvider.Context context) {
      super(context, new Modeldagon_fish_mini(context.m_174023_(Modeldagon_fish_mini.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(SeaSerpentMiniEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/dagon_fish_mini.png");
   }
}
