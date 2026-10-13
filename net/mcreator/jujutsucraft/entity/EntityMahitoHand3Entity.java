package net.mcreator.jujutsucraft.entity;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.procedures.AIMahitoHand3Procedure;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class EntityMahitoHand3Entity extends PathfinderMob {
   public EntityMahitoHand3Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.ENTITY_MAHITO_HAND_3.get(), world);
   }

   public EntityMahitoHand3Entity(EntityType<EntityMahitoHand3Entity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 0;
      this.m_21557_(true);
      this.m_21530_();
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public boolean m_6785_(double distanceToClosestPlayer) {
      return false;
   }

   public boolean m_6469_(DamageSource damagesource, float amount) {
      return damagesource.m_276093_(DamageTypes.f_268722_) ? false : super.m_6469_(damagesource, amount);
   }

   public void m_8119_() {
      super.m_8119_();
      Level world = this.m_9236_();
      Entity owner = null;
      if (!this.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
         owner = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply((LevelAccessor)world, (String)this.getPersistentData().m_128461_("OWNER_UUID"));
      }

      if (owner != null) {
         Vec3 ownerPos = owner.m_20182_();
         Vec3 targetPos = new Vec3(ownerPos.f_82479_, ownerPos.f_82480_ + (double)0.25F, ownerPos.f_82481_);
         this.m_146884_(targetPos);
      }

   }

   public void m_6075_() {
      super.m_6075_();
      AIMahitoHand3Procedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      this.m_6210_();
   }

   public boolean m_6063_() {
      double x = this.m_20185_();
      double y = this.m_20186_();
      double z = this.m_20189_();
      Level world = this.m_9236_();
      return false;
   }

   public boolean m_6094_() {
      return false;
   }

   protected void m_7324_(Entity entityIn) {
   }

   protected void m_6138_() {
   }

   public EntityDimensions m_6972_(Pose pose) {
      Level world = this.m_9236_();
      double x = this.m_20185_();
      double y = this.m_20186_();
      double z = this.m_20189_();
      return super.m_6972_(pose).m_20388_((float)SizeByNBTProcedure.execute(this));
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, (double)80.0F);
      builder = builder.m_22268_(Attributes.f_22284_, (double)0.0F);
      builder = builder.m_22268_(Attributes.f_22281_, (double)0.0F);
      builder = builder.m_22268_(Attributes.f_22277_, (double)16.0F);
      builder = builder.m_22268_(Attributes.f_22278_, (double)2.0F);
      return builder;
   }
}
