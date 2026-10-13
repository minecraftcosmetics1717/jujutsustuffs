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

public class Modelcursedspirit3_22<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_22"), "main");
   public final ModelPart bone;
   public final ModelPart head;
   public final ModelPart left_arm;
   public final ModelPart left_leg;
   public final ModelPart left_leg2;
   public final ModelPart right_arm;
   public final ModelPart right_leg;
   public final ModelPart right_leg2;

   public Modelcursedspirit3_22(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.head = root.m_171324_("head");
      this.left_arm = root.m_171324_("left_arm");
      this.left_leg = root.m_171324_("left_leg");
      this.left_leg2 = root.m_171324_("left_leg2");
      this.right_arm = root.m_171324_("right_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.right_leg2 = root.m_171324_("right_leg2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-2.0F, -2.5F, -5.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-2.0F, -5.1356F, 0.2458F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(2, 21).m_171488_(-2.0F, -2.5F, -4.8F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -5.9009F, 5.3948F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -3.75F, -3.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.75F)).m_171514_(0, 19).m_171488_(-1.0F, -5.5F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 1).m_171488_(-1.0F, -1.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(-3.0F, -9.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(8, 25).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)).m_171514_(14, 27).m_171488_(-2.0F, -2.0F, -0.3F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.75F)).m_171514_(24, 21).m_171488_(-1.5F, -1.3F, -1.9F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 17.0F, -5.0F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(8, 15).m_171480_().m_171488_(-2.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.3827F, -2.0566F, -1.4651F, -0.7171F, 0.2377F, -0.0212F));
      head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(8, 15).m_171488_(0.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.3827F, -2.0566F, -1.4651F, -0.7171F, -0.2377F, 0.0212F));
      head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(8, 28).m_171488_(-2.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.75F, 0.0F, -0.7171F, 0.2377F, -0.0212F));
      head.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(8, 28).m_171488_(0.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.75F, 0.0F, -0.7171F, -0.2377F, 0.0212F));
      head.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(24, 11).m_171480_().m_171488_(0.0F, -6.5F, -4.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.55F)).m_171555_(false).m_171514_(24, 11).m_171488_(-1.0F, -6.5F, -4.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(0.0F, -0.9405F, 0.6285F, -0.3054F, 0.0F, 0.0F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 19.0F, -4.25F));
      left_arm.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, -1.0F, 0.25F, -2.3166F, -1.0228F, 2.3957F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 19.5F, -0.75F));
      left_leg.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(1.001F, 1.2549F, 0.2617F, 3.1416F, 0.0F, 2.3562F));
      PartDefinition left_leg2 = partdefinition.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 19.5F, 4.25F));
      left_leg2.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(1.001F, 1.2549F, 0.2617F, 3.1416F, 0.0F, 2.3562F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 19.0F, -4.25F));
      right_arm.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(-3.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.0F, 0.25F, -2.3166F, 1.0228F, -2.3957F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 19.5F, -0.75F));
      right_leg.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-1.001F, 1.2549F, 0.2617F, 3.1416F, 0.0F, -2.3562F));
      PartDefinition right_leg2 = partdefinition.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 19.5F, 4.25F));
      right_leg2.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-1.001F, 1.2549F, 0.2617F, 3.1416F, 0.0F, -2.3562F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.right_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
