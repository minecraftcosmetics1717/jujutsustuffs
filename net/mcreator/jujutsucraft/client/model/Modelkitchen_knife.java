package net.mcreator.jujutsucraft.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelkitchen_knife<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelkitchen_knife"), "main");
   public final ModelPart body;

   public Modelkitchen_knife(ModelPart root) {
      this.body = root.m_171324_("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 1.0F, 0.0F));
      body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(10, 0).m_171488_(-1.0F, 1.45F, 0.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 1.4F, -0.5F, 0.0F, 0.0F, 0.0F));
      body.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -9.95F, -0.5F, 3.0F, 12.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(0.5F, 1.4F, 0.0F, 0.0F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 16, 16);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
