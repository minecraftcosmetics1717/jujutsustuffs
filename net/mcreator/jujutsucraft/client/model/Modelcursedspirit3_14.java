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

public class Modelcursedspirit3_14<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_14"), "main");
   public final ModelPart Head;
   public final ModelPart bone;
   public final ModelPart eyes;
   public final ModelPart Body;
   public final ModelPart RightFeather;
   public final ModelPart LeftFeather;
   public final ModelPart RightArm1;
   public final ModelPart RightArm2;
   public final ModelPart RightArm3;
   public final ModelPart LeftArm1;
   public final ModelPart LeftArm2;
   public final ModelPart LeftArm3;

   public Modelcursedspirit3_14(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.bone = this.Head.m_171324_("bone");
      this.eyes = this.Head.m_171324_("eyes");
      this.Body = root.m_171324_("Body");
      this.RightFeather = root.m_171324_("RightFeather");
      this.LeftFeather = root.m_171324_("LeftFeather");
      this.RightArm1 = root.m_171324_("RightArm1");
      this.RightArm2 = root.m_171324_("RightArm2");
      this.RightArm3 = root.m_171324_("RightArm3");
      this.LeftArm1 = root.m_171324_("LeftArm1");
      this.LeftArm2 = root.m_171324_("LeftArm2");
      this.LeftArm3 = root.m_171324_("LeftArm3");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-3.0F, -3.5F, -7.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(1, 1).m_171488_(-4.0F, -2.5F, -8.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-3.0F, -2.5F, -9.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 7.0F, -3.0F));
      PartDefinition bone = Head.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 3.3284F, -9.5858F));
      bone.m_171599_("Head_r10_r1", CubeListBuilder.m_171558_().m_171514_(16, 53).m_171480_().m_171488_(-1.5F, -2.5F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-1.7F, -0.3536F, -0.3536F, -0.5236F, 0.7854F, -1.5708F));
      bone.m_171599_("Head_r11_r1", CubeListBuilder.m_171558_().m_171514_(16, 53).m_171488_(-0.5F, -2.5F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.7F, -0.3536F, -0.3536F, -0.5236F, -0.7854F, 1.5708F));
      Head.m_171599_("eyes", CubeListBuilder.m_171558_().m_171514_(56, 0).m_171480_().m_171488_(3.4F, -19.0F, 13.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(56, 0).m_171488_(-4.4F, -19.0F, 13.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 17.0F, -20.0F));
      partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -3.5145F, 1.0908F, 10.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-3.5F, -2.0F, -0.9053F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.5F, -3.0F, -0.9053F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -3.0F, 8.0947F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-6.0F, -4.0F, 11.0947F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -3.0F, 20.0947F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -1.5F, 23.0947F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.0F, -2.0F, 8.0947F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 7.0F, -4.0F));
      PartDefinition RightFeather = partdefinition.m_171599_("RightFeather", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.3848F, 4.5093F, 0.3595F));
      RightFeather.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(-4, 46).m_171488_(-19.5F, 1.0F, -2.0F, 19.0F, 0.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.5F, -1.0F, -1.0F, 0.4532F, 0.4309F, 0.2787F));
      RightFeather.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(-2, 42).m_171488_(-6.5F, 0.0F, -2.0F, 13.0F, 0.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.5F, -1.0F, -1.0F, 0.1745F, 0.0F, 0.0F));
      PartDefinition LeftFeather = partdefinition.m_171599_("LeftFeather", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.3848F, 4.5093F, 0.3595F));
      LeftFeather.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(-4, 46).m_171480_().m_171488_(0.5F, 1.0F, -2.0F, 19.0F, 0.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.5F, -1.0F, -1.0F, 0.4532F, -0.4309F, -0.2787F));
      LeftFeather.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(-2, 42).m_171480_().m_171488_(-6.5F, 0.0F, -2.0F, 13.0F, 0.0F, 4.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.5F, -1.0F, -1.0F, 0.1745F, 0.0F, 0.0F));
      PartDefinition RightArm1 = partdefinition.m_171599_("RightArm1", CubeListBuilder.m_171558_(), PartPose.m_171423_(2.9172F, 10.3978F, -2.6618F, 0.0F, 0.0F, 0.0873F));
      RightArm1.m_171599_("Body_r19_r1", CubeListBuilder.m_171558_().m_171514_(1, 19).m_171488_(1.541F, 7.2109F, 9.4823F, 10.0F, 13.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(2.4357F, -10.5107F, -7.6864F, -0.2618F, 0.0F, 0.3927F));
      PartDefinition RightArm2 = partdefinition.m_171599_("RightArm2", CubeListBuilder.m_171558_(), PartPose.m_171423_(2.9172F, 10.3978F, -0.6618F, 0.1201F, -0.4205F, -0.2875F));
      RightArm2.m_171599_("Body_r19_r2", CubeListBuilder.m_171558_().m_171514_(1, 19).m_171488_(1.4804F, 6.6401F, 11.6434F, 10.0F, 13.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(2.4357F, -10.5107F, -9.6864F, -0.2618F, 0.0F, 0.3927F));
      PartDefinition RightArm3 = partdefinition.m_171599_("RightArm3", CubeListBuilder.m_171558_(), PartPose.m_171423_(2.9172F, 10.3978F, 3.3382F, 0.1946F, -0.3931F, -0.4752F));
      RightArm3.m_171599_("Body_r19_r3", CubeListBuilder.m_171558_().m_171514_(1, 19).m_171488_(2.2638F, 5.6254F, 15.5622F, 10.0F, 13.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(2.4357F, -10.5107F, -13.6864F, -0.2618F, 0.0F, 0.3927F));
      PartDefinition LeftArm1 = partdefinition.m_171599_("LeftArm1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-2.9172F, 10.3978F, -2.6618F, 0.0F, 0.0F, -0.0873F));
      LeftArm1.m_171599_("Body_r19_r4", CubeListBuilder.m_171558_().m_171514_(1, 19).m_171480_().m_171488_(-11.541F, 7.2109F, 9.4823F, 10.0F, 13.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-2.4357F, -10.5107F, -7.6864F, -0.2618F, 0.0F, -0.3927F));
      PartDefinition LeftArm2 = partdefinition.m_171599_("LeftArm2", CubeListBuilder.m_171558_(), PartPose.m_171423_(-2.9172F, 10.3978F, -0.6618F, 0.1201F, 0.4205F, 0.2875F));
      LeftArm2.m_171599_("Body_r19_r5", CubeListBuilder.m_171558_().m_171514_(1, 19).m_171480_().m_171488_(-11.4804F, 6.6401F, 11.6434F, 10.0F, 13.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-2.4357F, -10.5107F, -9.6864F, -0.2618F, 0.0F, -0.3927F));
      PartDefinition LeftArm3 = partdefinition.m_171599_("LeftArm3", CubeListBuilder.m_171558_(), PartPose.m_171423_(-2.9172F, 10.3978F, 3.3382F, 0.1946F, 0.3931F, 0.4752F));
      LeftArm3.m_171599_("Body_r19_r6", CubeListBuilder.m_171558_().m_171514_(1, 19).m_171480_().m_171488_(-12.2639F, 5.6254F, 15.5622F, 10.0F, 13.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-2.4357F, -10.5107F, -13.6864F, -0.2618F, 0.0F, -0.3927F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightFeather.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftFeather.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.Head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.RightFeather.f_104205_ = Mth.m_14031_(ageInTicks * 0.6F) * 0.6F;
      this.LeftFeather.f_104205_ = Mth.m_14031_(ageInTicks * 0.6F + 3.0F) * 0.6F;
   }
}
