package net.mcreator.jujutsucraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraft.client.model.Modelpalm_tree;
import net.mcreator.jujutsucraft.entity.PalmTreeEntity;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class PalmTreeRenderer extends MobRenderer<PalmTreeEntity, Modelpalm_tree<PalmTreeEntity>> {
   public PalmTreeRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelpalm_tree(context.m_174023_(Modelpalm_tree.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(PalmTreeEntity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(PalmTreeEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/palm_tree.png");
   }
}
