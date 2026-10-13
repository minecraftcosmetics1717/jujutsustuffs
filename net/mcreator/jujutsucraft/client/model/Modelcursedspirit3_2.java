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

public class Modelcursedspirit3_2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_2"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart tongue;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit3_2(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.tongue = this.Body.m_171324_("tongue");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(42, 0).m_171488_(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -25.0F, -4.0F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(64, 34).m_171488_(-5.0F, -23.6F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(-0.5F)).m_171514_(28, 21).m_171488_(-3.0F, -28.0F, -5.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(64, 98).m_171488_(-5.0F, -24.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.5F)).m_171514_(64, 64).m_171488_(-7.0F, -12.0F, -7.0F, 14.0F, 20.0F, 14.0F, new CubeDeformation(0.5F)).m_171514_(0, 34).m_171488_(-5.0F, -24.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(32, 24).m_171488_(-2.0F, -3.0F, 9.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(29, 22).m_171488_(-4.0F, -1.0F, 7.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(29, 6).m_171488_(-8.0F, -9.0F, -5.0F, 1.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(29, 6).m_171488_(7.0F, -9.0F, -5.0F, 1.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(64, 0).m_171488_(-7.0F, -12.4F, -7.0F, 14.0F, 20.0F, 14.0F, new CubeDeformation(-0.5F)).m_171514_(0, 0).m_171488_(-7.0F, -12.0F, -7.0F, 14.0F, 20.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(0, 58).m_171488_(-6.0F, 8.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition tongue = Body.m_171599_("tongue", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -7.1213F, 0.364F));
      tongue.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 72).m_171488_(-3.0F, -0.6642F, -19.3921F, 6.0F, 2.0F, 16.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(0.0F, -1.8787F, 1.4038F, 0.7854F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.8F, -17.7F, -2.0F));
      RightArm.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(43, 15).m_171480_().m_171488_(-4.1201F, -19.1153F, 3.3851F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-4.75F, 17.864F, 0.7412F, 0.2618F, 0.0F, 0.3927F));
      RightArm.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.1604F, 8.5991F, -1.1648F, 1.0F, 7.0F, 6.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(43, 15).m_171480_().m_171488_(-2.1604F, -6.4009F, 0.8352F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-4.75F, 17.864F, 0.7412F, -0.2618F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.8F, -17.7F, -2.0F));
      LeftArm.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(43, 15).m_171488_(2.1201F, -19.1153F, 3.3851F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(4.75F, 17.864F, 0.7412F, 0.2618F, 0.0F, -0.3927F));
      LeftArm.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.1604F, 8.5991F, -1.1648F, 1.0F, 7.0F, 6.0F, new CubeDeformation(-0.2F)).m_171514_(43, 15).m_171488_(0.1604F, -6.4009F, 0.8352F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(4.75F, 17.864F, 0.7412F, -0.2618F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(42, 16).m_171488_(-1.6F, 14.0025F, 1.6547F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(-7.9F, 3.9975F, -0.5547F));
      RightLeg.m_171599_("LeftLeg_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(8.3525F, 0.4431F, -2.9F, 1.0F, 7.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.7F, 11.1499F, 3.0977F, -1.5708F, 0.0F, 1.5708F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(42, 16).m_171488_(-0.9F, -6.6062F, 8.5379F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(-0.7F, 11.1499F, 3.0977F, 1.1781F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r4", CubeListBuilder.m_171558_().m_171514_(42, 16).m_171488_(-0.9F, -10.1626F, 0.9138F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-0.7F, 11.1499F, 3.0977F, -0.7854F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(42, 16).m_171480_().m_171488_(-0.4F, 14.0025F, 1.6547F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171419_(7.9F, 3.9975F, -0.5547F));
      LeftLeg.m_171599_("RightLeg_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-9.3525F, 0.4431F, -2.9F, 1.0F, 7.0F, 6.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.7F, 11.1499F, 3.0977F, -1.5708F, 0.0F, -1.5708F));
      LeftLeg.m_171599_("LeftLeg_r5", CubeListBuilder.m_171558_().m_171514_(42, 16).m_171480_().m_171488_(-1.1F, -6.6062F, 8.5379F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(0.7F, 11.1499F, 3.0977F, 1.1781F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r6", CubeListBuilder.m_171558_().m_171514_(42, 16).m_171480_().m_171488_(-1.1F, -10.1626F, 0.9138F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(0.7F, 11.1499F, 3.0977F, -0.7854F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
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
      this.tongue.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
   }
}
