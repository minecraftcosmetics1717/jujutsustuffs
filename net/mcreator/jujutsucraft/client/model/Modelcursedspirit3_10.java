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

public class Modelcursedspirit3_10<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_10"), "main");
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart Head;

   public Modelcursedspirit3_10(ModelPart root) {
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.Head = root.m_171324_("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-7.2825F, 16.1735F, 3.1094F));
      RightLeg.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(53, 0).m_171480_().m_171488_(15.0F, -1.8F, 0.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(-1.748F, 7.2816F, -14.1431F, 0.0F, -1.5708F, -1.5708F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(12, 17).m_171480_().m_171488_(-3.6807F, -8.5791F, 5.3345F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(6.078F, -0.4989F, 10.9941F, 3.1416F, -1.1781F, 1.5708F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(13, 18).m_171480_().m_171488_(-10.6807F, -8.2791F, 6.1345F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-8.6357F, 0.0143F, 10.7815F, 1.5708F, -1.1781F, 1.5708F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(13, 18).m_171480_().m_171488_(-13.2836F, -8.5791F, 3.1673F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(6.078F, -8.8349F, 5.0812F, 0.0F, -0.96F, -1.5708F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(7.2825F, 16.1735F, 3.1094F));
      LeftLeg.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(53, 0).m_171488_(-19.0F, -1.8F, 0.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(1.748F, 7.2816F, -14.1431F, 0.0F, 1.5708F, 1.5708F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(12, 17).m_171488_(2.6807F, -8.5791F, 5.3345F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-6.078F, -0.4989F, 10.9941F, 3.1416F, 1.1781F, -1.5708F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(13, 18).m_171488_(3.6807F, -8.2791F, 6.1345F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.6357F, 0.0143F, 10.7815F, 1.5708F, 1.1781F, -1.5708F));
      LeftLeg.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(13, 18).m_171488_(7.2836F, -8.5791F, 3.1673F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-6.078F, -8.8349F, 5.0812F, 0.0F, 0.96F, 1.5708F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-7.9151F, 13.7137F, -1.8405F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(12, 18).m_171480_().m_171488_(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false).m_171514_(52, 0).m_171480_().m_171488_(-5.0F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.1154F, 9.7415F, -9.1931F, 0.0F, -1.5708F, -1.5708F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(13, 19).m_171480_().m_171488_(-19.2354F, -11.1159F, 1.0325F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(8.6596F, -4.4005F, 6.2951F, -0.1481F, -1.0061F, -1.5254F));
      RightArm.m_171599_("RightArm_r4", CubeListBuilder.m_171558_().m_171514_(13, 19).m_171480_().m_171488_(-15.4F, -13.7F, -0.7F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(7.208F, -3.9281F, 12.3605F, 1.2322F, -0.2379F, -1.2691F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(7.9151F, 13.7137F, -1.8405F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(14, 20).m_171488_(12.2354F, -11.1159F, 2.0325F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-8.6596F, -4.4005F, 6.2951F, -0.1481F, 1.0061F, 1.5254F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(52, 0).m_171488_(0.0F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.05F)).m_171514_(12, 18).m_171488_(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.1154F, 9.7415F, -9.1931F, 0.0F, 1.5708F, 1.5708F));
      LeftArm.m_171599_("LeftArm_r4", CubeListBuilder.m_171558_().m_171514_(13, 19).m_171488_(7.4F, -13.7F, -0.7F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-7.208F, -3.9281F, 12.3605F, 1.2322F, 0.2379F, 1.2691F));
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 15.1453F, -0.722F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(-4.0F, -6.0F, -7.5F, 8.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(10, 10).m_171488_(-4.0F, -6.0F, 4.5F, 8.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, -1.309F, -1.5708F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(11, 11).m_171488_(-2.5F, -6.0F, 6.1F, 5.0F, 11.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3622F, -0.7519F, -0.2532F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(11, 11).m_171480_().m_171488_(-2.3F, -0.4F, 6.1F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.4499F, 0.4804F, 2.333F));
      Head.m_171599_("Head_r4", CubeListBuilder.m_171558_().m_171514_(11, 11).m_171488_(-2.7F, -0.4F, 6.1F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.4499F, -0.4804F, -2.333F));
      Head.m_171599_("Head_r5", CubeListBuilder.m_171558_().m_171514_(11, 11).m_171488_(-2.5F, 1.0F, 6.1F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)).m_171514_(11, 11).m_171488_(1.5F, -1.0F, 6.1F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)).m_171514_(11, 11).m_171488_(-2.5F, -6.0F, 6.1F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.7794F, -0.7519F, -2.8884F));
      Head.m_171599_("Head_r6", CubeListBuilder.m_171558_().m_171514_(11, 11).m_171488_(-2.5F, 1.0F, 6.1F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)).m_171514_(11, 11).m_171488_(-2.5F, -1.0F, 6.1F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)).m_171514_(11, 11).m_171488_(-2.5F, -6.0F, 6.1F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.7794F, 0.7519F, 2.8884F));
      Head.m_171599_("Head_r7", CubeListBuilder.m_171558_().m_171514_(11, 11).m_171488_(-2.5F, -6.0F, 6.1F, 5.0F, 11.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3622F, 0.7519F, 0.2532F));
      Head.m_171599_("Head_r8", CubeListBuilder.m_171558_().m_171514_(11, 11).m_171488_(-4.0F, -6.0F, 5.5F, 8.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(1, 1).m_171488_(-5.5F, 5.0341F, -5.7412F, 11.0F, 3.0F, 12.0F, new CubeDeformation(-1.0F)).m_171514_(1, 1).m_171488_(-5.5F, 4.0341F, -5.7412F, 11.0F, 2.0F, 12.0F, new CubeDeformation(-0.1F)).m_171514_(6, 30).m_171488_(-4.5F, -8.0F, -7.5F, 9.0F, 6.0F, 15.0F, new CubeDeformation(0.15F)).m_171514_(29, 30).m_171488_(-4.0F, -12.8F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-1.0F)).m_171514_(12, 36).m_171488_(-4.5F, -11.5F, -4.5F, 9.0F, 6.0F, 9.0F, new CubeDeformation(0.15F)).m_171514_(8, 32).m_171488_(-4.5F, -10.0F, -6.5F, 9.0F, 6.0F, 13.0F, new CubeDeformation(0.15F)).m_171514_(11, 11).m_171488_(-4.0F, -6.0F, -7.5F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(11, 11).m_171488_(-4.0F, 1.0F, -7.5F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
      Head.m_171599_("Head_r9", CubeListBuilder.m_171558_().m_171514_(8, 28).m_171488_(-2.5F, -3.0F, -8.5F, 5.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.8297F, -1.2939F, 2.7794F, 0.7519F, 2.8884F));
      Head.m_171599_("Head_r10", CubeListBuilder.m_171558_().m_171514_(8, 28).m_171488_(-2.5F, -3.0F, -8.5F, 5.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.8297F, -1.2939F, 2.7794F, -0.7519F, -2.8884F));
      Head.m_171599_("Head_r11", CubeListBuilder.m_171558_().m_171514_(6, 30).m_171488_(-4.5F, -3.0F, -7.5F, 9.0F, 6.0F, 15.0F, new CubeDeformation(0.1F)).m_171514_(8, 32).m_171488_(-4.5F, -5.0F, -6.5F, 9.0F, 6.0F, 13.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -4.8297F, -1.2939F, 1.5708F, -1.309F, -1.5708F));
      Head.m_171599_("Head_r12", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-5.1646F, -3.0F, -9.0646F, 10.0F, 6.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.0F, 0.0715F, -0.2983F, 0.3622F, 0.7519F, 0.2532F));
      Head.m_171599_("Head_r13", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-4.8354F, -3.0F, -9.0646F, 10.0F, 6.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.0F, 0.0715F, -0.2983F, 0.3622F, -0.7519F, -0.2532F));
      Head.m_171599_("Head_r14", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-5.0F, -3.0F, -9.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.0F, 0.0768F, -0.3067F, 0.2618F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
