package net.mcreator.jujutsucraft.client.renderer;

import net.mcreator.jujutsucraft.client.model.Modelreceipt;
import net.mcreator.jujutsucraft.entity.EntityReceiptEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityReceiptRenderer extends MobRenderer<EntityReceiptEntity, Modelreceipt<EntityReceiptEntity>> {
   public EntityReceiptRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelreceipt(context.m_174023_(Modelreceipt.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityReceiptEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/receipt.png");
   }
}
