package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.ModelMahitoCar;
import net.mcreator.jujutsucraft.entity.HumanCarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HumanCarRenderer extends MobRenderer<HumanCarEntity, ModelMahitoCar<HumanCarEntity>> {
   public HumanCarRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelMahitoCar(context.m_174023_(ModelMahitoCar.LAYER_LOCATION)), 1.2F);
   }

   public ResourceLocation getTextureLocation(HumanCarEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/mahitocar.png");
   }
}
