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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Modelcursedspirit3_11<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_11"), "main");
   public final ModelPart LH;
   public final ModelPart RH;
   public final ModelPart body;

   public Modelcursedspirit3_11(ModelPart root) {
      this.LH = root.m_171324_("LH");
      this.RH = root.m_171324_("RH");
      this.body = root.m_171324_("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("LH", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -1.5F, -12.5F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(68, 0).m_171480_().m_171488_(9.5F, -1.5F, -8.5F, 12.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(10.5F, 8.5F, 1.5F));
      partdefinition.m_171599_("RH", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-9.5F, -1.5F, -12.5F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)).m_171514_(68, 0).m_171488_(-21.5F, -1.5F, -8.5F, 12.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-10.5F, 8.5F, 1.5F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(26, 26).m_171488_(-7.0F, -4.0F, -31.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(36, 97).m_171488_(-10.0F, -5.0F, -27.0F, 20.0F, 5.0F, 26.0F, new CubeDeformation(0.0F)).m_171514_(0, 53).m_171488_(-6.0F, -5.0F, -1.0F, 12.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(0, 69).m_171488_(-4.0F, -5.0F, 12.0F, 8.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 11.0F, 16.0F));
      body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(10.0F, -2.5F, -17.0F, 3.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -2.1F, -16.0F, 0.0F, 0.3927F, 0.0F));
      body.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-13.0F, -2.5F, -17.0F, 3.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -2.1F, -16.0F, 0.0F, -0.3927F, 0.0F));
      body.m_171599_("body_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -3.5F, -3.0F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.6F, 24.0F, 0.7854F, 0.0F, 0.0F));
      body.m_171599_("body_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.5F, -3.0F, 1.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.6F, 9.0F, 0.5236F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.LH.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RH.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RH.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.LH.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
