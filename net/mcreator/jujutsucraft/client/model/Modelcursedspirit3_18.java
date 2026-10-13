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

public class Modelcursedspirit3_18<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_18"), "main");
   public final ModelPart head;
   public final ModelPart Body;
   public final ModelPart LeftArm;
   public final ModelPart RightArm;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg;

   public Modelcursedspirit3_18(ModelPart root) {
      this.head = root.m_171324_("head");
      this.Body = root.m_171324_("Body");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.RightLeg = root.m_171324_("RightLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(8, 6).m_171488_(-4.0F, 7.0F, -20.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(108, 119).m_171488_(-3.0F, 1.0F, -20.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(-0.05F)).m_171514_(2, 123).m_171488_(-3.0F, 5.0F, -20.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171514_(8, 6).m_171488_(-7.0F, -3.0F, -19.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(8, 6).m_171488_(-3.0F, -4.0F, -19.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(8, 6).m_171480_().m_171488_(3.0F, -3.0F, -19.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(6, 4).m_171480_().m_171488_(7.0F, -2.0F, -18.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(6, 4).m_171488_(-11.0F, -2.0F, -18.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(58, 24).m_171488_(-8.0F, -10.0F, -17.0F, 16.0F, 21.0F, 19.0F, new CubeDeformation(0.0F)).m_171514_(37, 0).m_171488_(-6.0F, -12.0F, -15.0F, 12.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-10.0F, -7.0F, -15.0F, 20.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(8, 6).m_171488_(-4.0F, -2.0F, -20.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, -7.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(2, 123).m_171488_(-3.0F, -1.5F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 1.5F, -19.0F, 0.0F, 0.0F, -3.1416F));
      partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-14.5F, -8.0F, 0.5F, 29.0F, 21.0F, 27.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(17, 2).m_171480_().m_171488_(-9.5F, 13.0F, 2.5F, 19.0F, 3.0F, 25.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(4, 4).m_171480_().m_171488_(-11.5F, -6.0F, 27.5F, 23.0F, 20.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 1.0F, -11.5F));
      partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.75F, 20.0F, -10.25F, 11.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(1, 3).m_171488_(-3.75F, -3.0F, -4.25F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(13.75F, 2.0F, -7.75F));
      partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-5.25F, 20.0F, -10.25F, 11.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(1, 3).m_171480_().m_171488_(-4.25F, -3.0F, -4.25F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-13.75F, 2.0F, -7.75F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-6.0F, 20.0F, -10.0F, 11.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(16.0F, 2.0F, 17.0F));
      LeftLeg.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 14.0F, -3.0F, 0.7854F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(0.0F, 6.0F, -6.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-5.0F, 20.0F, -10.0F, 11.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-16.0F, 2.0F, 17.0F));
      RightLeg.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171480_().m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 14.0F, -3.0F, 0.7854F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171480_().m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(1.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 6.0F, -6.0F, -0.7854F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
