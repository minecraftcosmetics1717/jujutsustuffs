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

public class Modelclothes_kirara<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_kirara"), "main");
   public final ModelPart armorHead;
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;
   public final ModelPart armorRightBoot;
   public final ModelPart armorLeftBoot;

   public Modelclothes_kirara(ModelPart root) {
      this.armorHead = root.m_171324_("armorHead");
      this.armorBody = root.m_171324_("armorBody");
      this.armorRightArm = root.m_171324_("armorRightArm");
      this.armorLeftArm = root.m_171324_("armorLeftArm");
      this.armorRightLeg = root.m_171324_("armorRightLeg");
      this.armorLeftLeg = root.m_171324_("armorLeftLeg");
      this.armorRightBoot = root.m_171324_("armorRightBoot");
      this.armorLeftBoot = root.m_171324_("armorLeftBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition armorHead = partdefinition.m_171599_("armorHead", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.01F)).m_171514_(32, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.51F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      armorHead.m_171599_("headwear_r1", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.2054F, -4.7158F, 0.0378F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6373F, -1.1107F, 3.8089F, 1.2743F, 0.4754F, 0.1105F));
      armorHead.m_171599_("headwear_r2", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-0.1887F, -3.4395F, -1.2179F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.4686F, 4.5424F, 0.4605F, -0.1218F, -0.9242F));
      armorHead.m_171599_("headwear_r3", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6914F, -0.0765F, 3.6743F, 0.9846F, -1.2457F, -1.3612F));
      armorHead.m_171599_("headwear_r4", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.2846F, -3.2247F, -0.1043F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6373F, -1.1107F, 3.8089F, 0.7097F, 0.6961F, -0.4519F));
      armorHead.m_171599_("headwear_r5", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(1.1502F, 1.1239F, 4.7945F, 0.2663F, 0.3226F, -0.1122F));
      armorHead.m_171599_("headwear_r6", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-1.0413F, -4.1389F, -0.1147F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6373F, -1.1107F, 3.8089F, 1.7546F, 0.6106F, 0.7003F));
      armorHead.m_171599_("headwear_r7", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-2.9587F, -4.1389F, -0.1147F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6373F, -1.1107F, 3.8089F, 1.7546F, -0.6106F, -0.7003F));
      armorHead.m_171599_("headwear_r8", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-1.1502F, 1.1239F, 4.7945F, 0.2663F, -0.3226F, 0.1122F));
      armorHead.m_171599_("headwear_r9", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-1.7154F, -3.2247F, -0.1043F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6373F, -1.1107F, 3.8089F, 0.7097F, -0.6961F, 0.4519F));
      armorHead.m_171599_("headwear_r10", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6914F, -0.0765F, 3.6743F, 0.9846F, 1.2457F, 1.3612F));
      armorHead.m_171599_("headwear_r11", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-3.8113F, -3.4395F, -1.2179F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 1.4686F, 4.5424F, 0.4605F, 0.1218F, 0.9242F));
      armorHead.m_171599_("headwear_r12", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-1.7946F, -4.7158F, 0.0378F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6373F, -1.1107F, 3.8089F, 1.2743F, -0.4754F, -0.1105F));
      PartDefinition armorBody = partdefinition.m_171599_("armorBody", CubeListBuilder.m_171558_().m_171514_(16, 32).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).m_171514_(16, 16).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      armorBody.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(19, 40).m_171488_(-4.0F, -1.05F, 2.7F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 7.7893F, -4.1999F, 0.7854F, 0.0F, 0.0F));
      armorBody.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(19, 37).m_171488_(-4.0F, -1.5F, 0.1F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 3.47F, -2.6F, -0.3927F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorRightArm", CubeListBuilder.m_171558_().m_171514_(48, 48).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).m_171514_(32, 48).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("armorLeftArm", CubeListBuilder.m_171558_().m_171514_(40, 32).m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).m_171514_(40, 16).m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("armorRightLeg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorLeftLeg", CubeListBuilder.m_171558_().m_171514_(16, 48).m_171488_(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorRightBoot", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorLeftBoot", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-5.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorHead.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorBody.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
