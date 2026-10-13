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

public class Modelcursedspirit3_13<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_13"), "main");
   public final ModelPart head;
   public final ModelPart left_leg1;
   public final ModelPart left_leg2;
   public final ModelPart right_leg1;
   public final ModelPart right_leg2;
   public final ModelPart right_leg3;
   public final ModelPart left_leg3;
   public final ModelPart torso;

   public Modelcursedspirit3_13(ModelPart root) {
      this.head = root.m_171324_("head");
      this.left_leg1 = root.m_171324_("left_leg1");
      this.left_leg2 = root.m_171324_("left_leg2");
      this.right_leg1 = root.m_171324_("right_leg1");
      this.right_leg2 = root.m_171324_("right_leg2");
      this.right_leg3 = root.m_171324_("right_leg3");
      this.left_leg3 = root.m_171324_("left_leg3");
      this.torso = root.m_171324_("torso");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -6.0F, -7.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171488_(-4.0F, -0.5F, -7.25F, 8.0F, 3.0F, 7.0F, new CubeDeformation(-0.5F)), PartPose.m_171419_(0.0F, -9.0F, -11.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.5F, -4.0F, -2.5F, 3.0F, 7.0F, 6.0F, new CubeDeformation(-0.75F)).m_171555_(false).m_171514_(0, 16).m_171488_(4.5F, -4.0F, -2.5F, 3.0F, 7.0F, 6.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(-3.0F, 0.7228F, -2.1924F, -1.1345F, 0.0F, 0.0F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -1.5F, -4.25F, 8.0F, 3.0F, 8.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(0.0F, 3.2312F, -1.4957F, -0.6109F, 0.0F, -3.1416F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(33, 1).m_171488_(-3.5F, -1.4F, -4.5F, 8.0F, 4.0F, 6.0F, new CubeDeformation(-0.9F)), PartPose.m_171423_(0.5F, 2.1153F, -1.9366F, -0.6109F, 0.0F, -3.1416F));
      PartDefinition left_leg1 = partdefinition.m_171599_("left_leg1", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.0F, -9.0F, 3.0F));
      left_leg1.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(36, 16).m_171480_().m_171488_(-3.5F, -6.5F, 0.0F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(16.1157F, 30.5851F, -18.204F, 1.1781F, 0.0F, 3.1416F));
      left_leg1.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(3.7693F, -4.204F, 2.2334F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.m_171423_(8.9757F, 15.9773F, -8.1645F, -0.5727F, 1.2422F, -0.743F));
      left_leg1.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171488_(-4.2304F, -19.5815F, -8.109F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(8.9757F, 15.9773F, -8.1645F, -1.3712F, -0.9708F, 0.5192F));
      left_leg1.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(5.4733F, -18.5815F, -1.3355F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.9757F, 15.9773F, -8.1645F, -0.6439F, 0.3979F, -1.0942F));
      PartDefinition left_leg2 = partdefinition.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.0F, -8.0F, 7.0F));
      left_leg2.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(36, 16).m_171480_().m_171488_(-4.0F, -5.5F, 0.0F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(12.6157F, 30.7178F, -0.1279F, 1.3963F, 0.0F, 3.1416F));
      left_leg2.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-0.2568F, -10.7905F, -0.75F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)), PartPose.m_171423_(13.7568F, 20.541F, 3.6444F, 0.0815F, -0.1133F, 0.1144F));
      left_leg2.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171488_(-2.0F, -6.5F, -1.25F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(4.2486F, 3.0695F, 0.6946F, 2.3802F, -1.235F, 2.8537F));
      left_leg2.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(2, 15).m_171488_(-2.2349F, -5.5F, -2.0855F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.2486F, 3.0695F, 0.6946F, 0.2305F, 0.0989F, -0.9974F));
      PartDefinition right_leg1 = partdefinition.m_171599_("right_leg1", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.0F, -9.0F, 3.0F));
      right_leg1.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(36, 16).m_171488_(-4.5F, -6.5F, 0.0F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-16.1157F, 30.5851F, -18.204F, 1.1781F, 0.0F, -3.1416F));
      right_leg1.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-5.7693F, -4.204F, 2.2334F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171423_(-8.9757F, 15.9773F, -8.1645F, -0.5727F, -1.2422F, 0.743F));
      right_leg1.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171480_().m_171488_(0.2304F, -19.5815F, -8.109F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)).m_171555_(false), PartPose.m_171423_(-8.9757F, 15.9773F, -8.1645F, -1.3712F, 0.9708F, -0.5192F));
      right_leg1.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-8.4733F, -18.5815F, -1.3355F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-8.9757F, 15.9773F, -8.1645F, -0.6439F, -0.3979F, 1.0942F));
      PartDefinition right_leg2 = partdefinition.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.0F, -8.0F, 7.0F));
      right_leg2.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(36, 16).m_171488_(-4.0F, -5.5F, 0.0F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-12.6157F, 30.7178F, -0.1279F, 1.3963F, 0.0F, -3.1416F));
      right_leg2.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.7432F, -10.7905F, -0.75F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.35F)).m_171555_(false), PartPose.m_171423_(-13.7568F, 20.541F, 3.6444F, 0.0815F, 0.1133F, -0.1144F));
      right_leg2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 17).m_171480_().m_171488_(-2.0F, -6.5F, -1.25F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.4F)).m_171555_(false), PartPose.m_171423_(-4.2486F, 3.0695F, 0.6946F, 2.3802F, 1.235F, -2.8537F));
      right_leg2.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-0.7651F, -5.5F, -2.0855F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.2486F, 3.0695F, 0.6946F, 0.2305F, -0.0989F, 0.9974F));
      PartDefinition right_leg3 = partdefinition.m_171599_("right_leg3", CubeListBuilder.m_171558_(), PartPose.m_171419_(-8.0611F, 2.8665F, 14.4582F));
      right_leg3.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(21, 22).m_171480_().m_171488_(-2.0F, 0.5F, -2.5F, 4.0F, 10.0F, 1.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171423_(-9.5736F, 22.7323F, 10.1251F, -1.5708F, 0.0F, 0.0F));
      right_leg3.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-2.4335F, -15.1903F, -5.1705F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-8.573F, 14.4564F, 7.1396F, 0.9206F, -0.0878F, 0.0744F));
      right_leg3.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-8.1386F, -4.5874F, -1.8355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)).m_171555_(false), PartPose.m_171423_(-0.9108F, 9.9728F, -5.6284F, -0.3008F, -0.4353F, -0.1512F));
      right_leg3.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-0.7651F, -6.5F, -1.0855F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.58F, 0.1781F, 0.7521F));
      PartDefinition left_leg3 = partdefinition.m_171599_("left_leg3", CubeListBuilder.m_171558_(), PartPose.m_171419_(8.0611F, 2.8665F, 14.4582F));
      left_leg3.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(21, 22).m_171488_(-2.0F, 0.5F, -2.5F, 4.0F, 10.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.m_171423_(9.5736F, 22.7323F, 10.1251F, -1.5708F, 0.0F, 0.0F));
      left_leg3.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-0.5665F, -15.1903F, -5.1705F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(8.573F, 14.4564F, 7.1396F, 0.9206F, 0.0878F, -0.0744F));
      left_leg3.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(4.1386F, -4.5874F, -1.8355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.m_171423_(0.9108F, 9.9728F, -5.6284F, -0.3008F, 0.4353F, 0.1512F));
      left_leg3.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.2349F, -6.5F, -1.0855F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.58F, -0.1781F, -0.7521F));
      PartDefinition torso = partdefinition.m_171599_("torso", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.5F, 15.5F, 10.0F));
      torso.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(9, 25).m_171488_(-1.778F, -5.6171F, -1.778F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, -25.5863F, -15.3087F, 1.7263F, 0.1536F, -0.7734F));
      torso.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(9, 25).m_171488_(-1.8162F, -0.377F, -1.8162F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-0.5F, -25.5863F, -15.3087F, 1.5708F, 0.0F, -0.7854F));
      torso.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171480_().m_171488_(-7.0F, -2.0F, -3.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5F, -14.3223F, 7.3569F, 1.2176F, -0.274F, -0.2849F));
      torso.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171488_(-1.0F, -2.0F, -3.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, -14.3223F, 7.3569F, 1.2176F, 0.274F, 0.2849F));
      torso.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171488_(-5.0F, -6.5F, -5.0F, 10.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, -19.6256F, 4.882F, 0.7854F, 0.0F, 0.0F));
      torso.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-6.5F, -19.5F, 17.0F, 12.0F, 11.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.torso.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.right_leg1.f_104204_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.right_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg1.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_leg3.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_leg3.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
