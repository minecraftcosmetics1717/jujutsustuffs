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

public class Modelcursedspirit3_3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_3"), "main");
   public final ModelPart Head;
   public final ModelPart HeadMain;
   public final ModelPart Eye;
   public final ModelPart Tail;
   public final ModelPart Tail1;
   public final ModelPart Tail2;
   public final ModelPart FinCaudal;
   public final ModelPart FinDorsal;
   public final ModelPart FinVentral;
   public final ModelPart RightFinVentral;
   public final ModelPart LeftFinVentral;
   public final ModelPart BodyMain;

   public Modelcursedspirit3_3(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.HeadMain = this.Head.m_171324_("HeadMain");
      this.Eye = this.Head.m_171324_("Eye");
      this.Tail = root.m_171324_("Tail");
      this.Tail1 = this.Tail.m_171324_("Tail1");
      this.Tail2 = this.Tail1.m_171324_("Tail2");
      this.FinCaudal = this.Tail2.m_171324_("FinCaudal");
      this.FinDorsal = root.m_171324_("FinDorsal");
      this.FinVentral = root.m_171324_("FinVentral");
      this.RightFinVentral = this.FinVentral.m_171324_("RightFinVentral");
      this.LeftFinVentral = this.FinVentral.m_171324_("LeftFinVentral");
      this.BodyMain = root.m_171324_("BodyMain");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 8.1707F, -4.037F));
      Head.m_171599_("HeadMain", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-1.5F, -0.9495F, -5.0284F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(6, 25).m_171480_().m_171488_(-1.0F, -0.9316F, -8.2188F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-1.5F, 1.4096F, -3.7745F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(7, 26).m_171480_().m_171488_(-1.0F, 1.4054F, -6.5612F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(7, 26).m_171480_().m_171488_(-0.5F, -0.2F, -11.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(6, 25).m_171480_().m_171488_(-0.5F, 1.4175F, -10.1891F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-2.0F, -1.4128F, -2.9962F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.085F, -0.3209F));
      PartDefinition Eye = Head.m_171599_("Eye", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.3F, 0.085F, -0.6209F));
      Eye.m_171599_("Eye_r1", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171480_().m_171488_(-3.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.4363F));
      Eye.m_171599_("Eye_r2", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171488_(1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-0.6F, 0.0F, 0.0F, 0.0F, -0.0873F, -0.4363F));
      PartDefinition Tail = partdefinition.m_171599_("Tail", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 9.0F, 5.0F));
      PartDefinition Tail1 = Tail.m_171599_("Tail1", CubeListBuilder.m_171558_().m_171514_(6, 23).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, -0.25F, 0.5F));
      Tail1.m_171599_("Tail1_r1", CubeListBuilder.m_171558_().m_171514_(22, -2).m_171480_().m_171488_(0.0F, 6.0F, -1.8F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -4.75F, -2.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition Tail2 = Tail1.m_171599_("Tail2", CubeListBuilder.m_171558_().m_171514_(9, 26).m_171480_().m_171488_(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(16, 16).m_171480_().m_171488_(-1.0F, -1.5F, 1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171419_(0.0F, -0.25F, 3.5F));
      PartDefinition FinCaudal = Tail2.m_171599_("FinCaudal", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.175F, 2.5584F));
      FinCaudal.m_171599_("FinCaudal_r1", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171480_().m_171488_(0.0F, -2.5F, -4.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(0.0F, 2.9538F, 2.3117F, -0.7854F, 0.0F, 0.0F));
      FinCaudal.m_171599_("FinCaudal_r2", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171480_().m_171488_(0.0F, -2.5F, -4.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, -2.9538F, 2.3117F, 0.7854F, 0.0F, 0.0F));
      PartDefinition FinDorsal = partdefinition.m_171599_("FinDorsal", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.5F, 6.3381F, -0.0315F));
      FinDorsal.m_171599_("FinDorsal_r1", CubeListBuilder.m_171558_().m_171514_(6, -9).m_171480_().m_171488_(0.0F, -1.5F, -5.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.5F, -2.2304F, -0.9239F, 0.9163F, 0.0F, 0.0F));
      PartDefinition FinVentral = partdefinition.m_171599_("FinVentral", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.0F, 25.5F, 3.0F));
      PartDefinition RightFinVentral = FinVentral.m_171599_("RightFinVentral", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.2154F, -14.9618F, -5.6485F));
      RightFinVentral.m_171599_("RightFinVentral_r1", CubeListBuilder.m_171558_().m_171514_(24, -4).m_171488_(0.0267F, -2.6016F, -2.1649F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4998F, -2.0E-4F, 0.9976F, -0.3491F, -0.7854F, 0.0F));
      PartDefinition LeftFinVentral = FinVentral.m_171599_("LeftFinVentral", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.2154F, -14.9618F, -5.6485F));
      LeftFinVentral.m_171599_("LeftFinVentral_r1", CubeListBuilder.m_171558_().m_171514_(24, -4).m_171480_().m_171488_(-0.0267F, -2.6016F, -2.1649F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.4998F, -2.0E-4F, 0.9976F, -0.3491F, 0.7854F, 0.0F));
      partdefinition.m_171599_("BodyMain", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171480_().m_171488_(-3.5F, -19.5F, -6.5F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(1.0F, 26.0F, 3.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.FinDorsal.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.FinVentral.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.BodyMain.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightFinVentral.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.LeftFinVentral.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.Tail1.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.Tail2.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
