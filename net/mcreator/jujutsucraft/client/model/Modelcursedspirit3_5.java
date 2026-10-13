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

public class Modelcursedspirit3_5<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_5"), "main");
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart Mouth;
   public final ModelPart BodyMain;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit3_5(ModelPart root) {
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.Mouth = root.m_171324_("Mouth");
      this.BodyMain = root.m_171324_("BodyMain");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-22.533F, -40.7585F, -0.2559F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(48, 366).m_171488_(-7.8955F, -47.4189F, 14.8459F, 16.0F, 45.0F, 17.0F, new CubeDeformation(-1.56F)).m_171514_(250, 347).m_171488_(-8.0934F, -56.0704F, 14.6334F, 16.0F, 24.0F, 17.0F, new CubeDeformation(0.68F)), PartPose.m_171423_(-23.0F, 41.0F, -14.0F, 0.2182F, 0.0F, 0.5672F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(45, 388).m_171488_(-10.1809F, 2.7763F, -31.6548F, 10.0F, 10.0F, 21.0F, new CubeDeformation(-1.6F)), PartPose.m_171423_(-23.0F, 41.0F, -14.0F, 0.3501F, 0.3435F, -0.0111F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(181, 274).m_171488_(-15.7381F, 3.0665F, -33.7323F, 10.0F, 10.0F, 35.0F, new CubeDeformation(-1.6F)), PartPose.m_171423_(-23.0F, 41.0F, -14.0F, 0.4025F, 0.5565F, 0.0119F));
      RightArm.m_171599_("RightArm_r4", CubeListBuilder.m_171558_().m_171514_(236, 292).m_171488_(-7.2331F, 4.9612F, -27.5483F, 10.0F, 10.0F, 35.0F, new CubeDeformation(-1.6F)), PartPose.m_171423_(-23.0F, 41.0F, -14.0F, 0.2628F, -0.0843F, -0.0226F));
      RightArm.m_171599_("RightArm_r5", CubeListBuilder.m_171558_().m_171514_(320, 270).m_171488_(-14.8911F, 4.9612F, -15.037F, 22.0F, 10.0F, 22.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(-23.0F, 41.0F, -14.0F, 0.2778F, 0.3367F, 0.0939F));
      RightArm.m_171599_("RightArm_r6", CubeListBuilder.m_171558_().m_171514_(11, 364).m_171488_(-8.2349F, 3.4609F, -4.7849F, 16.0F, 16.0F, 32.0F, new CubeDeformation(-0.72F)), PartPose.m_171423_(-23.0F, 41.0F, -14.0F, 0.8727F, 0.0F, 0.5672F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(22.533F, -40.7585F, -0.2559F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(48, 366).m_171480_().m_171488_(-8.1045F, -47.4189F, 14.8459F, 16.0F, 45.0F, 17.0F, new CubeDeformation(-1.56F)).m_171555_(false).m_171514_(250, 347).m_171480_().m_171488_(-7.9066F, -56.0704F, 14.6334F, 16.0F, 24.0F, 17.0F, new CubeDeformation(0.68F)).m_171555_(false), PartPose.m_171423_(23.0F, 41.0F, -14.0F, 0.2182F, 0.0F, -0.5672F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(45, 388).m_171480_().m_171488_(0.1809F, 2.7763F, -31.6548F, 10.0F, 10.0F, 21.0F, new CubeDeformation(-1.6F)).m_171555_(false), PartPose.m_171423_(23.0F, 41.0F, -14.0F, 0.3501F, -0.3435F, 0.0111F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(181, 274).m_171480_().m_171488_(5.7381F, 3.0665F, -33.7323F, 10.0F, 10.0F, 35.0F, new CubeDeformation(-1.6F)).m_171555_(false), PartPose.m_171423_(23.0F, 41.0F, -14.0F, 0.4025F, -0.5565F, -0.0119F));
      LeftArm.m_171599_("LeftArm_r4", CubeListBuilder.m_171558_().m_171514_(236, 292).m_171480_().m_171488_(-2.7669F, 4.9612F, -27.5483F, 10.0F, 10.0F, 35.0F, new CubeDeformation(-1.6F)).m_171555_(false), PartPose.m_171423_(23.0F, 41.0F, -14.0F, 0.2628F, 0.0843F, 0.0226F));
      LeftArm.m_171599_("LeftArm_r5", CubeListBuilder.m_171558_().m_171514_(320, 270).m_171480_().m_171488_(-7.1089F, 4.9612F, -15.037F, 22.0F, 10.0F, 22.0F, new CubeDeformation(-1.2F)).m_171555_(false), PartPose.m_171423_(23.0F, 41.0F, -14.0F, 0.2778F, -0.3367F, -0.0939F));
      LeftArm.m_171599_("LeftArm_r6", CubeListBuilder.m_171558_().m_171514_(11, 364).m_171480_().m_171488_(-7.7651F, 3.4609F, -4.7849F, 16.0F, 16.0F, 32.0F, new CubeDeformation(-0.72F)).m_171555_(false), PartPose.m_171423_(23.0F, 41.0F, -14.0F, 0.8727F, 0.0F, -0.5672F));
      PartDefinition Mouth = partdefinition.m_171599_("Mouth", CubeListBuilder.m_171558_().m_171514_(15, 110).m_171488_(-1.0F, -6.4974F, -41.8092F, 4.0F, 2.0F, 2.0F, new CubeDeformation(2.2F)), PartPose.m_171423_(-1.0F, -40.7566F, -2.9367F, 0.1745F, 0.0F, 0.0F));
      Mouth.m_171599_("Mouth_r1", CubeListBuilder.m_171558_().m_171514_(144, 391).m_171488_(18.9049F, -7.9162F, 3.6282F, 3.0F, 8.0F, 2.0F, new CubeDeformation(1.64F)), PartPose.m_171423_(2.7363F, 6.1951F, -21.7892F, 2.1238F, 0.4968F, 0.2861F));
      Mouth.m_171599_("Mouth_r2", CubeListBuilder.m_171558_().m_171514_(191, 0).m_171488_(-24.8335F, -6.0504F, 3.6282F, 3.0F, 8.0F, 2.0F, new CubeDeformation(1.64F)), PartPose.m_171423_(2.7363F, 6.1951F, -21.7892F, 2.1238F, -0.4968F, -0.2861F));
      Mouth.m_171599_("Mouth_r3", CubeListBuilder.m_171558_().m_171514_(201, 17).m_171488_(-19.1746F, -5.5953F, -15.9261F, 13.0F, 2.0F, 2.0F, new CubeDeformation(1.64F)), PartPose.m_171423_(2.4763F, 6.1951F, -21.7892F, 0.7617F, -0.2143F, 0.2194F));
      Mouth.m_171599_("Mouth_r4", CubeListBuilder.m_171558_().m_171514_(201, 21).m_171488_(3.3587F, -6.4831F, -15.9261F, 13.0F, 2.0F, 2.0F, new CubeDeformation(1.64F)), PartPose.m_171423_(2.4763F, 6.1951F, -21.7892F, 0.7617F, 0.2143F, -0.2194F));
      Mouth.m_171599_("Mouth_r5", CubeListBuilder.m_171558_().m_171514_(0, 187).m_171488_(-2.9815F, -6.7259F, -15.9261F, 4.0F, 2.0F, 2.0F, new CubeDeformation(2.2F)), PartPose.m_171423_(1.9815F, 6.1951F, -21.7892F, 0.7854F, 0.0F, 0.0F));
      Mouth.m_171599_("Mouth_r6", CubeListBuilder.m_171558_().m_171514_(36, 2).m_171488_(-22.0162F, -10.1762F, 5.1022F, 3.0F, 13.0F, 2.0F, new CubeDeformation(1.16F)).m_171514_(241, 344).m_171488_(15.5437F, -10.1762F, 5.1022F, 3.0F, 13.0F, 2.0F, new CubeDeformation(1.16F)), PartPose.m_171423_(2.7362F, 6.1951F, -21.7892F, 2.2689F, 0.0F, 0.0F));
      Mouth.m_171599_("Mouth_r7", CubeListBuilder.m_171558_().m_171514_(120, 104).m_171488_(-19.0F, -5.12F, -0.2088F, 13.0F, 2.0F, 2.0F, new CubeDeformation(1.94F)), PartPose.m_171423_(2.4527F, -0.0773F, -41.6004F, 0.0F, 0.0F, 0.3054F));
      Mouth.m_171599_("Mouth_r8", CubeListBuilder.m_171558_().m_171514_(120, 50).m_171488_(6.0F, -5.12F, -0.2088F, 13.0F, 2.0F, 2.0F, new CubeDeformation(1.94F)), PartPose.m_171423_(-0.4527F, -0.0773F, -41.6004F, 0.0F, 0.0F, -0.3054F));
      Mouth.m_171599_("Mouth_r9", CubeListBuilder.m_171558_().m_171514_(18, 75).m_171488_(16.0F, -11.12F, -0.2088F, 3.0F, 8.0F, 2.0F, new CubeDeformation(1.64F)), PartPose.m_171423_(6.3461F, -1.4964F, -25.3275F, 0.9949F, 0.538F, -0.1893F));
      Mouth.m_171599_("Mouth_r10", CubeListBuilder.m_171558_().m_171514_(20, 55).m_171488_(17.28F, -6.5F, -1.0F, 3.0F, 15.0F, 2.0F, new CubeDeformation(1.36F)).m_171514_(20, 0).m_171488_(-20.28F, -6.5F, -1.0F, 3.0F, 15.0F, 2.0F, new CubeDeformation(1.36F)), PartPose.m_171423_(1.0F, -4.4308F, -29.0135F, 1.309F, 0.0F, 0.0F));
      Mouth.m_171599_("Mouth_r11", CubeListBuilder.m_171558_().m_171514_(20, 10).m_171488_(-19.0F, -11.12F, -0.2088F, 3.0F, 8.0F, 2.0F, new CubeDeformation(1.64F)), PartPose.m_171423_(-4.3461F, -1.4964F, -25.3275F, 0.9949F, -0.538F, 0.1893F));
      PartDefinition BodyMain = partdefinition.m_171599_("BodyMain", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.0F, -9.3468F, 29.2322F));
      BodyMain.m_171599_("BodyMain_r1", CubeListBuilder.m_171558_().m_171514_(234, 158).m_171488_(-18.0F, -13.04F, -10.0F, 19.0F, 14.0F, 22.0F, new CubeDeformation(-0.04F)).m_171514_(234, 158).m_171480_().m_171488_(1.0F, -13.04F, -10.0F, 19.0F, 14.0F, 22.0F, new CubeDeformation(-0.04F)).m_171555_(false).m_171514_(257, 227).m_171480_().m_171488_(-17.5F, -13.04F, 10.0F, 37.0F, 16.0F, 6.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r2", CubeListBuilder.m_171558_().m_171514_(395, 146).m_171488_(-12.0F, -13.04F, -8.0F, 25.0F, 14.0F, 23.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.5F, 10.5384F, 0.3554F, 0.2618F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r3", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(-18.0F, -27.04F, -17.0F, 37.0F, 22.0F, 33.0F, new CubeDeformation(3.92F)), PartPose.m_171423_(0.5F, -36.1978F, -20.9092F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r4", CubeListBuilder.m_171558_().m_171514_(214, 0).m_171488_(-18.0F, -25.04F, -3.0F, 37.0F, 20.0F, 25.0F, new CubeDeformation(-0.04F)), PartPose.m_171423_(0.0F, -7.0013F, -17.1827F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r5", CubeListBuilder.m_171558_().m_171514_(94, 351).m_171488_(-18.0F, -20.04F, 0.0F, 37.0F, 15.0F, 12.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.5F, -8.8714F, -35.1402F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r6", CubeListBuilder.m_171558_().m_171514_(28, 55).m_171488_(-18.5F, -14.0F, -2.5F, 37.0F, 28.0F, 5.0F, new CubeDeformation(0.24F)), PartPose.m_171423_(1.0F, -13.8353F, -53.691F, 1.7017F, 0.0F, -3.1416F));
      BodyMain.m_171599_("BodyMain_r7", CubeListBuilder.m_171558_().m_171514_(251, 451).m_171488_(-13.7363F, -12.7552F, -12.145F, 23.0F, 39.0F, 4.0F, new CubeDeformation(0.24F)).m_171514_(118, 223).m_171488_(-21.2362F, -6.4288F, -9.0087F, 5.0F, 8.0F, 19.0F, new CubeDeformation(0.24F)).m_171514_(118, 223).m_171480_().m_171488_(11.7637F, -6.4288F, -9.0087F, 5.0F, 8.0F, 19.0F, new CubeDeformation(0.24F)).m_171555_(false), PartPose.m_171423_(3.2362F, -25.2147F, -53.958F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r8", CubeListBuilder.m_171558_().m_171514_(214, 54).m_171480_().m_171488_(-1.0F, -13.04F, -11.0F, 19.0F, 14.0F, 27.0F, new CubeDeformation(0.4F)).m_171555_(false).m_171514_(332, 204).m_171480_().m_171488_(-4.0F, -13.04F, 6.0F, 25.0F, 15.0F, 2.0F, new CubeDeformation(0.44F)).m_171555_(false).m_171514_(332, 204).m_171488_(-23.0F, -13.04F, 6.0F, 25.0F, 15.0F, 2.0F, new CubeDeformation(0.44F)).m_171514_(104, 274).m_171488_(-22.5F, -13.04F, 6.0F, 43.0F, 15.0F, 13.0F, new CubeDeformation(0.24F)).m_171514_(214, 54).m_171488_(-20.0F, -13.04F, -11.0F, 19.0F, 14.0F, 27.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(2.0F, -4.8825F, -1.7951F, 0.2618F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r9", CubeListBuilder.m_171558_().m_171514_(236, 252).m_171480_().m_171488_(-2.0F, -25.04F, 2.0F, 21.0F, 26.0F, 14.0F, new CubeDeformation(2.48F)).m_171555_(false).m_171514_(236, 252).m_171488_(-21.16F, -25.04F, 2.0F, 21.0F, 26.0F, 14.0F, new CubeDeformation(2.48F)), PartPose.m_171423_(2.08F, -9.001F, 0.7425F, 0.6109F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r10", CubeListBuilder.m_171558_().m_171514_(1, 171).m_171480_().m_171488_(1.0F, -25.04F, -7.0F, 18.0F, 26.0F, 23.0F, new CubeDeformation(2.56F)).m_171555_(false).m_171514_(1, 171).m_171488_(-21.16F, -25.04F, -7.0F, 18.0F, 26.0F, 23.0F, new CubeDeformation(2.56F)), PartPose.m_171423_(2.08F, -14.3978F, -0.2091F, 0.2182F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r11", CubeListBuilder.m_171558_().m_171514_(229, 111).m_171480_().m_171488_(-1.0F, -25.04F, -6.5F, 19.0F, 17.0F, 23.0F, new CubeDeformation(3.84F)).m_171555_(false).m_171514_(229, 111).m_171488_(-20.0F, -25.04F, -6.5F, 19.0F, 17.0F, 23.0F, new CubeDeformation(3.84F)), PartPose.m_171423_(2.0F, -26.3493F, 0.4048F, 0.5672F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r12", CubeListBuilder.m_171558_().m_171514_(0, 110).m_171488_(-18.0F, -38.04F, -13.0F, 19.0F, 33.0F, 27.0F, new CubeDeformation(3.68F)).m_171514_(0, 110).m_171480_().m_171488_(1.0F, -38.04F, -13.0F, 19.0F, 33.0F, 27.0F, new CubeDeformation(3.68F)).m_171555_(false), PartPose.m_171423_(0.0F, -36.631F, -3.4796F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r13", CubeListBuilder.m_171558_().m_171514_(0, 269).m_171480_().m_171488_(-1.0F, -31.04F, 0.2F, 19.0F, 26.0F, 15.0F, new CubeDeformation(5.16F)).m_171555_(false).m_171514_(0, 269).m_171488_(-20.48F, -31.04F, 0.2F, 19.0F, 26.0F, 15.0F, new CubeDeformation(5.16F)), PartPose.m_171423_(2.24F, -41.3329F, -0.0487F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r14", CubeListBuilder.m_171558_().m_171514_(0, 469).m_171480_().m_171488_(-1.0F, -33.04F, 7.0F, 19.0F, 28.0F, 15.0F, new CubeDeformation(0.4F)).m_171555_(false).m_171514_(0, 469).m_171488_(-20.0F, -33.04F, 7.0F, 19.0F, 28.0F, 15.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(2.0F, -19.2854F, -40.3477F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r15", CubeListBuilder.m_171558_().m_171514_(0, 219).m_171480_().m_171488_(-1.0F, -33.04F, 0.0F, 19.0F, 28.0F, 22.0F, new CubeDeformation(0.52F)).m_171555_(false).m_171514_(0, 219).m_171488_(-21.0F, -33.04F, 0.0F, 19.0F, 28.0F, 22.0F, new CubeDeformation(0.52F)), PartPose.m_171423_(2.5F, -33.3773F, -34.1404F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r16", CubeListBuilder.m_171558_().m_171514_(338, 0).m_171480_().m_171488_(1.0F, -27.04F, 3.0F, 17.0F, 22.0F, 10.0F, new CubeDeformation(4.36F)).m_171555_(false).m_171514_(338, 0).m_171488_(-20.0F, -27.04F, 3.0F, 16.0F, 22.0F, 10.0F, new CubeDeformation(4.36F)), PartPose.m_171423_(2.0F, -41.1218F, -21.7774F, 1.4399F, 0.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r17", CubeListBuilder.m_171558_().m_171514_(126, 168).m_171480_().m_171488_(-1.0F, -25.04F, -18.0F, 19.0F, 20.0F, 34.0F, new CubeDeformation(3.44F)).m_171555_(false).m_171514_(126, 168).m_171488_(-20.0F, -25.04F, -18.0F, 19.0F, 20.0F, 34.0F, new CubeDeformation(3.44F)), PartPose.m_171423_(2.0F, -14.4444F, -3.9948F, 0.5672F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171488_(-6.56F, 31.08F, -3.44F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.32F)).m_171514_(124, 197).m_171488_(-4.96F, 32.0F, -9.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.28F)), PartPose.m_171419_(-15.12F, -10.28F, 30.52F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(101, 128).m_171488_(-1.96F, -5.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.28F)), PartPose.m_171423_(1.48F, 37.0F, -7.88F, 0.0F, -0.2618F, 0.0F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.96F, -22.0F, 0.0F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.24F)), PartPose.m_171423_(-1.6F, 35.7986F, 0.8336F, 0.48F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.96F, -28.0F, 0.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(1.04F)), PartPose.m_171423_(-4.2441F, 26.2791F, -11.1824F, -0.3025F, 0.0226F, 0.2608F));
      RightLeg.m_171599_("RightLeg_r4", CubeListBuilder.m_171558_().m_171514_(134, 199).m_171488_(-0.04F, -5.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.28F)), PartPose.m_171423_(-9.4F, 37.0F, -7.88F, 0.0F, 0.2618F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171480_().m_171488_(1.56F, 31.08F, -3.44F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.32F)).m_171555_(false).m_171514_(124, 197).m_171480_().m_171488_(2.96F, 32.0F, -9.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.28F)).m_171555_(false), PartPose.m_171419_(15.12F, -10.28F, 30.52F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(101, 128).m_171480_().m_171488_(-0.04F, -5.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.28F)).m_171555_(false), PartPose.m_171423_(-1.48F, 37.0F, -7.88F, 0.0F, 0.2618F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.04F, -22.0F, 0.0F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.24F)).m_171555_(false), PartPose.m_171423_(1.6F, 35.7986F, 0.8336F, 0.48F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.04F, -28.0F, 0.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(1.04F)).m_171555_(false), PartPose.m_171423_(4.2441F, 26.2791F, -11.1824F, -0.3025F, -0.0226F, -0.2608F));
      LeftLeg.m_171599_("LeftLeg_r4", CubeListBuilder.m_171558_().m_171514_(134, 199).m_171480_().m_171488_(-1.96F, -5.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.28F)).m_171555_(false), PartPose.m_171423_(9.4F, 37.0F, -7.88F, 0.0F, -0.2618F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 512, 512);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Mouth.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.BodyMain.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
