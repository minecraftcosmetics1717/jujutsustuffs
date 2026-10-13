package net.mcreator.jujutsucraft.entity;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.procedures.BulletKitchenKnifeProjectileHitsLivingEntityProcedure;
import net.mcreator.jujutsucraft.procedures.BulletKitchenKnifeWhileProjectileFlyingTickProcedure;
import net.mcreator.jujutsucraft.procedures.BulletNailProjectileHitsBlockProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class BulletKitchenKnifeEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM;

   public BulletKitchenKnifeEntity(PlayMessages.SpawnEntity packet, Level world) {
      super((EntityType)JujutsucraftModEntities.BULLET_KITCHEN_KNIFE.get(), world);
   }

   public BulletKitchenKnifeEntity(EntityType<? extends BulletKitchenKnifeEntity> type, Level world) {
      super(type, world);
   }

   public BulletKitchenKnifeEntity(EntityType<? extends BulletKitchenKnifeEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public BulletKitchenKnifeEntity(EntityType<? extends BulletKitchenKnifeEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack m_7846_() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack m_7941_() {
      return PROJECTILE_ITEM;
   }

   protected void m_7761_(LivingEntity entity) {
      super.m_7761_(entity);
      entity.m_21317_(entity.m_21234_() - 1);
   }

   public void m_5790_(EntityHitResult entityHitResult) {
      super.m_5790_(entityHitResult);
      BulletKitchenKnifeProjectileHitsLivingEntityProcedure.execute(this.m_9236_(), entityHitResult.m_82443_(), this);
   }

   public void m_8060_(BlockHitResult blockHitResult) {
      super.m_8060_(blockHitResult);
      BulletNailProjectileHitsBlockProcedure.execute(this.m_9236_(), (double)blockHitResult.m_82425_().m_123341_(), (double)blockHitResult.m_82425_().m_123342_(), (double)blockHitResult.m_82425_().m_123343_());
   }

   public void m_8119_() {
      super.m_8119_();
      BulletKitchenKnifeWhileProjectileFlyingTickProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_19749_(), this);
   }

   public static BulletKitchenKnifeEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 2.0F, (double)6.0F, 0);
   }

   public static BulletKitchenKnifeEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 2.0F, (double)6.0F, 0);
   }

   public static BulletKitchenKnifeEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      BulletKitchenKnifeEntity entityarrow = new BulletKitchenKnifeEntity((EntityType)JujutsucraftModEntities.BULLET_KITCHEN_KNIFE.get(), entity, world);
      entityarrow.m_6686_(entity.m_20252_(1.0F).f_82479_, entity.m_20252_(1.0F).f_82480_, entity.m_20252_(1.0F).f_82481_, power * 2.0F, 0.0F);
      entityarrow.m_20225_(true);
      entityarrow.m_36762_(true);
      entityarrow.m_36781_(damage);
      entityarrow.m_36735_(knockback);
      world.m_7967_(entityarrow);
      return entityarrow;
   }

   public static BulletKitchenKnifeEntity shoot(LivingEntity entity, LivingEntity target) {
      BulletKitchenKnifeEntity entityarrow = new BulletKitchenKnifeEntity((EntityType)JujutsucraftModEntities.BULLET_KITCHEN_KNIFE.get(), entity, entity.m_9236_());
      double dx = target.m_20185_() - entity.m_20185_();
      double dy = target.m_20186_() + (double)target.m_20192_() - 1.1;
      double dz = target.m_20189_() - entity.m_20189_();
      entityarrow.m_6686_(dx, dy - entityarrow.m_20186_() + Math.hypot(dx, dz) * (double)0.2F, dz, 4.0F, 12.0F);
      entityarrow.m_20225_(true);
      entityarrow.m_36781_((double)6.0F);
      entityarrow.m_36735_(0);
      entityarrow.m_36762_(true);
      entity.m_9236_().m_7967_(entityarrow);
      return entityarrow;
   }

   static {
      PROJECTILE_ITEM = new ItemStack((ItemLike)JujutsucraftModItems.KITCHEN_KNIFE.get());
   }
}
