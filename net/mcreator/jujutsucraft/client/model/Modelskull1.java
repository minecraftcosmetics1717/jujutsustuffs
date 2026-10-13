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

public class Modelskull1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelskull_1"), "main");
   public final ModelPart bone;

   public Modelskull1(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-36.0F, -6.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(2, 22).m_171488_(-38.0F, -10.0F, 5.0F, 16.0F, 16.0F, 14.0F, new CubeDeformation(0.1F)).m_171514_(0, 95).m_171488_(-38.0F, 2.0F, 5.0F, 16.0F, 4.0F, 29.0F, new CubeDeformation(-0.1F)).m_171514_(0, 52).m_171488_(-42.0F, -13.0F, 19.0F, 24.0F, 19.0F, 24.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(-40.0F, -17.0F, 23.0F, 20.0F, 4.0F, 19.0F, new CubeDeformation(0.1F)).m_171514_(34, 0).m_171480_().m_171488_(-18.0F, -5.0F, 37.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(36, 2).m_171480_().m_171488_(-14.0F, -4.0F, 38.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(34, 0).m_171488_(-46.0F, -5.0F, 37.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)).m_171514_(36, 2).m_171488_(-50.0F, -4.0F, 38.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(30.0F, 18.0F, -24.0F));
      bone.m_171599_("bone_r1", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171480_().m_171488_(3.25F, -2.5F, -2.5F, 10.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)).m_171555_(false), PartPose.m_171423_(-11.25F, -15.0F, 37.0F, 0.0F, 0.0F, -0.7854F));
      bone.m_171599_("bone_r2", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171480_().m_171488_(-5.75F, -2.5F, -2.5F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(10, 29).m_171480_().m_171488_(-10.75F, -3.5F, -3.5F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(-11.25F, -17.0F, 37.0F, 0.0F, 0.0F, -0.3927F));
      bone.m_171599_("bone_r3", CubeListBuilder.m_171558_().m_171514_(10, 29).m_171488_(5.75F, -3.5F, -4.0F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.5F)).m_171514_(34, 0).m_171488_(-4.25F, -2.5F, -3.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-48.75F, -17.0F, 37.5F, 0.0F, 0.0F, 0.3927F));
      bone.m_171599_("bone_r4", CubeListBuilder.m_171558_().m_171514_(34, 0).m_171488_(-13.25F, -2.5F, -2.5F, 10.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-48.75F, -15.0F, 37.0F, 0.0F, 0.0F, 0.7854F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
