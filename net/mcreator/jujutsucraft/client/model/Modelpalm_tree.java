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

public class Modelpalm_tree<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelpalm_tree"), "main");
   public final ModelPart bone;

   public Modelpalm_tree(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, -173.1096F, -23.7003F, 8.0F, 94.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone.m_171599_("tree_r1", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.1324F, -15.2033F, -6.8594F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, 2.6578F, 0.0231F, 0.0038F));
      bone.m_171599_("tree_r2", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.1324F, -15.0331F, -7.0621F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, -2.3773F, -1.3552F, -1.461F));
      bone.m_171599_("tree_r3", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-15.8676F, -15.0331F, -7.0621F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, -0.9125F, -0.0231F, -3.1378F));
      bone.m_171599_("tree_r4", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-15.8676F, -15.2033F, -6.8594F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, -2.1605F, 1.3552F, 1.6806F));
      bone.m_171599_("tree_r5", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.1872F, -17.3952F, -2.4137F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, 3.041F, -0.7401F, -0.2013F));
      bone.m_171599_("tree_r6", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-15.8128F, -17.3952F, -2.4137F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, -0.6848F, 0.7401F, 2.9403F));
      bone.m_171599_("tree_r7", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -17.3236F, -2.5866F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, -0.6981F, -0.7854F, -2.9234F));
      bone.m_171599_("tree_r8", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -17.4668F, -2.2407F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -17.6131F, 7.6808F, 3.0543F, 0.7854F, 0.2182F));
      bone.m_171599_("tree_r9", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 2.9671F, 0.7854F, 3.1416F));
      bone.m_171599_("tree_r10", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, -0.1745F, 0.7854F, 0.0F));
      bone.m_171599_("tree_r11", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 2.9671F, -0.7854F, -3.1416F));
      bone.m_171599_("tree_r12", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, -0.1745F, -0.7854F, 0.0F));
      bone.m_171599_("tree_r13", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 0.0F, -1.5708F, -0.3927F));
      bone.m_171599_("tree_r14", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 2.2689F, -1.0472F, -3.1416F));
      bone.m_171599_("tree_r15", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 2.2689F, -0.2618F, -3.1416F));
      bone.m_171599_("tree_r16", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 2.2689F, 0.5236F, -3.1416F));
      bone.m_171599_("tree_r17", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 2.2689F, 1.309F, 3.1416F));
      bone.m_171599_("tree_r18", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, -0.8727F, -0.5236F, 0.0F));
      bone.m_171599_("tree_r19", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, -0.8727F, -1.309F, 0.0F));
      bone.m_171599_("tree_r20", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, -0.8727F, 0.2618F, 0.0F));
      bone.m_171599_("tree_r21", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, -0.8727F, 1.0472F, 0.0F));
      bone.m_171599_("tree_r22", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -13.4346F, -0.7731F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -19.5F, 0.0F, 1.5708F, 0.3927F));
      bone.m_171599_("tree_r23", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -0.5F, -32.0F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, -53.2997F, 2.7489F, 0.0F, -3.1416F));
      bone.m_171599_("tree_r24", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-16.0F, -0.5F, -32.0F, 32.0F, 1.0F, 64.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-4.3284F, -160.6096F, 14.2997F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("tree_r25", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-6.6716F, -47.0F, -4.0F, 8.0F, 94.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(-1.3284F, -36.9097F, -1.9573F, 0.3927F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
