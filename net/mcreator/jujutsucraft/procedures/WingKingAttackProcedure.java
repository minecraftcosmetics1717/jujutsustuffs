package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BulletBloodProjectileEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class WingKingAttackProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double damage = (double)0.0F;
         if (entity.getPersistentData().m_128459_("cnt2") <= (double)3.0F) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var47 = ((Entity)var10000).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var47 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var48;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var48 = _mobEnt.m_5448_();
               } else {
                  var48 = null;
               }

               z_pos = ((Entity)var48).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)3.0F && entity.getPersistentData().m_128459_("cnt1") % (double)3.0F == (double)1.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)1.5F);
               DamageFixProcedure.execute(entity);
               damage = entity.getPersistentData().m_128459_("Damage");
               yaw = (double)entity.m_146908_();
               picth = (double)entity.m_146909_();
               if (entity.getPersistentData().m_128459_("cnt2") % (double)2.0F == (double)1.0F) {
                  yaw2 = yaw + (double)112.5F;
               } else {
                  yaw2 = yaw - (double)112.5F;
               }

               pitch2 = entity.getPersistentData().m_128459_("cnt2") * (double)-22.5F;
               entity.m_146922_((float)yaw2);
               entity.m_146926_((float)pitch2);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               Level projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new BulletBloodProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_BLOOD_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, (float)damage, 0);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                  _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 1.0F, 0.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.m_146922_((float)yaw);
               entity.m_146926_((float)picth);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)2.0F);
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

         entity.getPersistentData().m_128347_("Damage", (double)9.0F);
         DamageFixProcedure.execute(entity);
      }
   }
}
