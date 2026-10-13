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

public class Modelcursedspirit3_21<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_21"), "main");
   public final ModelPart torso;
   public final ModelPart left_arm;
   public final ModelPart right_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart left_leg2;
   public final ModelPart right_leg2;
   public final ModelPart head;

   public Modelcursedspirit3_21(ModelPart root) {
      this.torso = root.m_171324_("torso");
      this.left_arm = root.m_171324_("left_arm");
      this.right_arm = root.m_171324_("right_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.left_leg2 = root.m_171324_("left_leg2");
      this.right_leg2 = root.m_171324_("right_leg2");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition torso = partdefinition.m_171599_("torso", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-6.0F, -28.0F, -1.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.25F)).m_171514_(0, 16).m_171488_(-8.0F, -28.0F, -1.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171488_(-4.0F, -28.0F, -1.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.0F, 25.0F, -11.0F));
      torso.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(1, 18).m_171488_(-5.0F, -4.0F, -2.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -15.25F, 13.5F, 1.5708F, 0.0F, 0.0F));
      torso.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(1, 16).m_171488_(-5.0F, -4.0F, -2.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-2.0F, -15.25F, 7.5F, 1.5708F, 0.0F, 0.0F));
      torso.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(1, 18).m_171488_(-5.0F, -4.0F, -2.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-2.0F, -15.25F, 19.5F, -1.5708F, 0.0F, 3.1416F));
      torso.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(29, 16).m_171488_(-5.0F, -15.5F, -2.25F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.5F)).m_171514_(29, 16).m_171488_(-5.0F, -21.5F, -2.25F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(29, 16).m_171488_(-5.0F, -9.5F, -2.25F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -18.0F, 2.0F, -1.5708F, 0.0F, 0.0F));
      torso.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(39, 16).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -20.8045F, 23.2193F, -0.7854F, 0.0F, 0.0F));
      torso.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-4.0F, -5.0F, -1.25F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -18.0F, 2.0F, 0.3927F, 0.0F, 0.0F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.0F, 0.0F, -9.0F));
      left_arm.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(1.9955F, -3.145F, -3.2012F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.9334F, 10.8939F, -3.9151F, 0.424F, -0.0162F, 1.9984F));
      left_arm.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(0.42F, -2.3107F, -2.3669F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(4.9334F, 10.8939F, -3.9151F, 0.3995F, 0.35F, 1.8538F));
      left_arm.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.7291F, -2.0618F, -2.118F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(4.9334F, 10.8939F, -3.9151F, -0.7396F, 1.209F, 0.4704F));
      left_arm.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(-3.5448F, -1.9816F, -2.0378F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(4.9334F, 10.8939F, -3.9151F, 0.3016F, 0.7074F, 1.6632F));
      left_arm.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(6, 29).m_171488_(-1.4603F, -9.1016F, -2.195F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.9334F, 10.8939F, -3.9151F, -0.9426F, -0.3614F, 0.4215F));
      left_arm.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(6, 29).m_171488_(-1.0F, -2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2849F, -0.274F, -0.8249F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.0F, 0.0F, -9.0F));
      right_arm.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171480_().m_171488_(-4.9955F, -3.145F, -3.2012F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.9334F, 10.8939F, -3.9151F, 0.424F, 0.0162F, -1.9984F));
      right_arm.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171480_().m_171488_(-3.42F, -2.3107F, -2.3669F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-4.9334F, 10.8939F, -3.9151F, 0.3995F, -0.35F, -1.8538F));
      right_arm.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-0.2709F, -2.0618F, -2.118F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(-4.9334F, 10.8939F, -3.9151F, -0.7396F, -1.209F, -0.4704F));
      right_arm.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171480_().m_171488_(-1.4552F, -1.9816F, -2.0378F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(-4.9334F, 10.8939F, -3.9151F, 0.3016F, -0.7074F, -1.6632F));
      right_arm.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(6, 29).m_171480_().m_171488_(-1.5397F, -9.1016F, -2.195F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.9334F, 10.8939F, -3.9151F, -0.9426F, 0.3614F, -0.4215F));
      right_arm.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(6, 29).m_171480_().m_171488_(-2.0F, -2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2849F, 0.274F, 0.8249F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-5.0F, 9.0F, -3.0F));
      right_leg.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(-3.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(-7.3631F, 12.0691F, 0.0F, -0.7854F, 0.0F, -1.7453F));
      right_leg.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(-5.5834F, 0.9598F, 0.0F, -0.7854F, 0.0F, -1.1781F));
      right_leg.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-2.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.3858F, 0.574F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(5.0F, 9.0F, -3.0F));
      left_leg.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(-5.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(7.3631F, 12.0691F, 0.0F, -0.7854F, 0.0F, 1.7453F));
      left_leg.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(5.5834F, 0.9598F, 0.0F, -0.7854F, 0.0F, 1.1781F));
      left_leg.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-4.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.3858F, 0.574F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition left_leg2 = partdefinition.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(5.0F, 9.0F, 6.0F));
      left_leg2.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(-5.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(7.3631F, 12.0691F, 0.0F, -0.7854F, 0.0F, 1.7453F));
      left_leg2.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(5.5834F, 0.9598F, 0.0F, -0.7854F, 0.0F, 1.1781F));
      left_leg2.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-4.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.3858F, 0.574F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition right_leg2 = partdefinition.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-5.0F, 9.0F, 6.0F));
      right_leg2.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(-3.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(-7.3631F, 12.0691F, 0.0F, -0.7854F, 0.0F, -1.7453F));
      right_leg2.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(-5.5834F, 0.9598F, 0.0F, -0.7854F, 0.0F, -1.1781F));
      right_leg2.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(4, 34).m_171488_(-2.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.3858F, 0.574F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-3.0F, -5.5F, 3.5F, 6.0F, 6.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(2, 2).m_171488_(-5.0F, -5.0F, -3.0F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.25F)).m_171514_(2, 2).m_171480_().m_171488_(2.0F, -5.0F, -3.0F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.25F)).m_171555_(false).m_171514_(32, 0).m_171488_(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.m_171419_(0.0F, -3.0F, -10.0F));
      head.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(30, 28).m_171480_().m_171488_(0.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.0F, -5.0F, -2.0F, 0.0F, 1.5708F, 0.0F));
      head.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(30, 28).m_171488_(-2.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.0F, -5.0F, -2.0F, 0.0F, -1.5708F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.torso.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.right_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
