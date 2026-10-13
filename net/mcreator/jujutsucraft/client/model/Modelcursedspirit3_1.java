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

public class Modelcursedspirit3_1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_1"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit3_1(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-10.0F, -4.8133F, -4.3021F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(0.0F, -4.8133F, -4.3021F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 3).m_171488_(-7.5F, -10.8133F, -8.3021F, 15.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(10, 29).m_171488_(-7.5F, -6.8133F, -8.3021F, 15.0F, 3.0F, 7.0F, new CubeDeformation(0.5F)).m_171514_(2, 41).m_171488_(-3.5F, -10.8133F, -8.3021F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.1F)).m_171514_(40, 44).m_171488_(4.0F, -11.0133F, -10.3021F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.7F)).m_171514_(40, 44).m_171480_().m_171488_(-10.0F, -11.0133F, -10.3021F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.7F)).m_171555_(false).m_171514_(0, 59).m_171488_(-5.0F, -0.8133F, -8.3021F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(36, 56).m_171488_(-5.0F, -4.8133F, -8.3021F, 10.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F)).m_171514_(0, 0).m_171488_(-10.0F, -4.8133F, -8.3021F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(5.0F, -4.8133F, -8.3021F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, -0.1867F, 2.8021F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, -12.0F, -1.0F, 8.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(0.0F, -12.0F, -1.0F, 8.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-12.0F, -24.0F, -2.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(0.0F, -24.0F, -2.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 29).m_171480_().m_171488_(1.0F, -23.5F, -2.0F, 11.0F, 6.0F, 4.0F, new CubeDeformation(1.0F)).m_171555_(false).m_171514_(0, 29).m_171488_(-12.0F, -23.5F, -2.0F, 11.0F, 6.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.m_171419_(0.0F, 24.0F, -4.0F));
      Body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-2.013F, -2.3642F, 0.3255F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.5F, -22.85F, 8.8F, 2.7489F, 1.3963F, 3.1416F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-9.8F, -0.7F, 2.0F));
      RightArm.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-1.3861F, 0.1325F, -1.5998F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 51).m_171488_(-1.5861F, -2.616F, -0.6801F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.1073F, 8.5479F, -11.4206F, 1.7453F, 0.0F, 0.0F));
      RightArm.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.436F, -4.5953F, 0.7537F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.8073F, 8.5479F, -11.4206F, 2.1817F, -0.1745F, 0.0F));
      RightArm.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.5584F, -4.8879F, 0.8602F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.0073F, 8.5479F, -11.4206F, 2.1817F, 0.1309F, 0.0F));
      RightArm.m_171599_("RightLeg_r4", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.5446F, -4.8305F, 0.8393F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.1073F, 8.5479F, -11.2206F, 2.1817F, 0.4363F, 0.0F));
      RightArm.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.5774F, -3.8983F, 0.682F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.0073F, 8.5479F, -11.4206F, 2.1817F, -0.6545F, 0.0F));
      RightArm.m_171599_("RightLeg_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -4.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-2.7652F, 4.1076F, -2.8044F, 2.4871F, 1.0472F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(9.8F, -0.7F, 2.0F));
      LeftArm.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-1.6139F, 0.1325F, -1.5998F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(30, 43).m_171480_().m_171488_(-2.4139F, -5.616F, 0.2199F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 51).m_171480_().m_171488_(-1.4139F, -2.616F, -0.6801F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(5.1073F, 8.5479F, -11.4206F, 1.7453F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.564F, -4.5953F, 0.7537F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.8073F, 8.5479F, -11.4206F, 2.1817F, 0.1745F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r4", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.4416F, -4.8879F, 0.8602F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(5.0073F, 8.5479F, -11.4206F, 2.1817F, -0.1309F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r5", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171480_().m_171488_(-0.4554F, -4.8305F, 0.8393F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(5.1073F, 8.5479F, -11.2206F, 2.1817F, -0.4363F, 0.0F));
      LeftArm.m_171599_("RightLeg_r6", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-0.4226F, -3.8983F, 0.682F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0073F, 8.5479F, -11.4206F, 2.1817F, 0.6545F, 0.0F));
      LeftArm.m_171599_("LeftLeg_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.0F, -4.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(2.7652F, 4.1076F, -2.8044F, 2.4871F, -1.0472F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(0.0F, 3.0025F, -14.3453F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-9.9F, 18.9975F, 2.4453F));
      RightLeg.m_171599_("RightLeg_r7", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(-3.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.1F, 4.0025F, -12.3453F, 0.0F, 0.3054F, 0.0F));
      RightLeg.m_171599_("RightLeg_r8", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.0F, 4.0025F, -12.3453F, 0.0F, -0.3054F, 0.0F));
      RightLeg.m_171599_("RightLeg_r9", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171488_(-1.0F, -4.3526F, -3.131F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-0.4F, -3.6512F, -9.2608F, 0.1745F, 0.0F, -0.192F));
      RightLeg.m_171599_("RightLeg_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0642F, -0.3136F, -6.4905F, 5.0F, 9.0F, 6.0F, new CubeDeformation(0.4F)).m_171514_(21, 46).m_171488_(-0.0642F, -8.3136F, -4.4905F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(-0.7802F, -5.6071F, -2.4482F, 1.0472F, 0.0873F, -0.192F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(-2.0F, 3.0025F, -14.3453F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(9.9F, 18.9975F, 2.4453F));
      LeftLeg.m_171599_("LeftLeg_r7", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-1.1F, 4.0025F, -12.3453F, 0.0F, -0.3054F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r8", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(-3.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-1.0F, 4.0025F, -12.3453F, 0.0F, 0.3054F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r9", CubeListBuilder.m_171558_().m_171514_(13, 50).m_171480_().m_171488_(-1.0F, -4.3526F, -3.131F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(0.4F, -3.6512F, -9.2608F, 0.1745F, 0.0F, 0.192F));
      LeftLeg.m_171599_("LeftLeg_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.9358F, -0.3136F, -6.4905F, 5.0F, 9.0F, 6.0F, new CubeDeformation(0.4F)).m_171555_(false).m_171514_(21, 46).m_171480_().m_171488_(-1.9358F, -8.3136F, -4.4905F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.4F)).m_171555_(false), PartPose.m_171423_(0.7802F, -5.6071F, -2.4482F, 1.0472F, -0.0873F, 0.192F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.Head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.Head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
