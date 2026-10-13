package net.mcreator.jujutsucraft.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class EntityImpactWaveLayer extends GeoRenderLayer<EntityImpactWaveEntity> {
   private static final ResourceLocation LAYER0 = new ResourceLocation("jujutsucraft", "textures/entities/orange.png");
   private static final ResourceLocation LAYER1 = new ResourceLocation("jujutsucraft", "textures/entities/flame_tiger.png");
   private static final ResourceLocation LAYER2 = new ResourceLocation("jujutsucraft", "textures/entities/red.png");

   public EntityImpactWaveLayer(GeoRenderer<EntityImpactWaveEntity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(PoseStack poseStack, EntityImpactWaveEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      RenderType glowRenderType;
      if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 2) {
         glowRenderType = RenderType.m_110488_(LAYER2);
      } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 1) {
         glowRenderType = RenderType.m_110488_(LAYER1);
      } else {
         glowRenderType = RenderType.m_110488_(LAYER0);
      }

      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.m_6299_(glowRenderType), partialTick, packedLight, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
   }
}
