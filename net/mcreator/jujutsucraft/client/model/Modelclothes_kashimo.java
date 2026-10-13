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

public class Modelclothes_kashimo<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_kashimo"), "main");
   public final ModelPart head;
   public final ModelPart bone;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart right_boot;
   public final ModelPart left_boot;
   public final ModelPart steve;

   public Modelclothes_kashimo(ModelPart root) {
      this.head = root.m_171324_("head");
      this.bone = this.head.m_171324_("bone");
      this.body = root.m_171324_("body");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.right_boot = root.m_171324_("right_boot");
      this.left_boot = root.m_171324_("left_boot");
      this.steve = root.m_171324_("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.26F)).m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.05F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(29, 20).m_171480_().m_171488_(-0.6F, 1.3F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-3.5F, -9.5F, -0.5F, 0.0F, 0.0F, -0.2618F));
      head.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(29, 20).m_171488_(-0.4F, 1.3F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(3.5F, -9.5F, -0.5F, 0.0F, 0.0F, 0.2618F));
      head.m_171599_("head_r3", CubeListBuilder.m_171558_().m_171514_(26, 26).m_171480_().m_171488_(-3.924F, -2.4175F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -9.2809F, 0.0F, -0.2618F, 0.0F, -0.2618F));
      head.m_171599_("head_r4", CubeListBuilder.m_171558_().m_171514_(26, 26).m_171488_(2.924F, -2.4175F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -9.2809F, 0.0F, -0.2618F, 0.0F, 0.2618F));
      PartDefinition bone = head.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -2.0F, 4.0F));
      bone.m_171599_("head_r5", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171488_(1.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.m_171423_(-1.0F, 0.0F, 0.0F, 0.0F, -0.1745F, -0.3927F));
      bone.m_171599_("head_r6", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171488_(-2.0F, -4.5F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.m_171423_(2.4319F, -3.139F, 0.6946F, 0.0F, -0.0436F, -0.7854F));
      bone.m_171599_("head_r7", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171488_(-2.0F, -5.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.m_171423_(-0.2088F, -0.7855F, 1.7596F, 0.5472F, -0.5964F, -1.0004F));
      bone.m_171599_("head_r8", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171488_(1.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2428F, -0.6501F, -0.4932F));
      bone.m_171599_("head_r9", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171480_().m_171488_(-5.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).m_171555_(false), PartPose.m_171423_(1.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.3927F));
      bone.m_171599_("head_r10", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171480_().m_171488_(-2.0F, -4.5F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).m_171555_(false), PartPose.m_171423_(-2.4319F, -3.139F, 0.6946F, 0.0F, 0.0436F, 0.7854F));
      bone.m_171599_("head_r11", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171480_().m_171488_(-2.0F, -5.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).m_171555_(false), PartPose.m_171423_(0.2088F, -0.7855F, 1.7596F, 0.5472F, 0.5964F, 1.0004F));
      bone.m_171599_("head_r12", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171480_().m_171488_(-5.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2428F, 0.6501F, 0.4932F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.261F)).m_171514_(12, 16).m_171480_().m_171488_(-3.0F, -0.5F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(18, 27).m_171488_(-3.5F, -3.0F, -0.5F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.m_171423_(0.0F, 14.0F, 3.0F, 0.1745F, 0.0F, 0.0F));
      body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(17, 27).m_171488_(-3.5F, -2.5F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.m_171423_(0.0F, 13.5944F, -2.4208F, -0.1745F, 0.0F, 0.0F));
      partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171514_(0, 9).m_171488_(-3.0F, 3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)).m_171514_(0, 16).m_171488_(-3.0F, 1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.38F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false).m_171514_(0, 9).m_171480_().m_171488_(-1.0F, 3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)).m_171555_(false).m_171514_(0, 16).m_171480_().m_171488_(-1.0F, 1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.38F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -0.0648F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.14F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      right_leg.m_171599_("right_leg_r1", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)).m_171555_(false).m_171514_(0, 4).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171423_(0.0F, 5.5F, 0.0F, 0.0F, 0.0436F, 0.0F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -0.0648F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.14F)), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      left_leg.m_171599_("left_leg_r1", CubeListBuilder.m_171558_().m_171514_(0, 4).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).m_171514_(0, 26).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(0.0F, 5.5F, 0.0F, 0.0F, -0.0436F, 0.0F));
      partdefinition.m_171599_("right_boot", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("left_boot", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("steve", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(40, 16).m_171480_().m_171488_(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(40, 16).m_171488_(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171480_().m_171488_(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 16).m_171488_(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_boot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_boot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
