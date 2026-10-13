package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BulletFlameProjectileEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class JogoFlame1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double picth = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         Entity target = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var36 = var10000;
         if (var36 instanceof LivingEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)9.0F && var36 instanceof LivingEntity) {
            entity.getPersistentData().m_128347_("x_pos", ((Entity)var36).m_20185_());
            entity.getPersistentData().m_128347_("y_pos", ((Entity)var36).m_20186_() + (double)((Entity)var36).m_20206_() * 0.8);
            entity.getPersistentData().m_128347_("z_pos", ((Entity)var36).m_20189_());
         }

         if (var36 instanceof LivingEntity) {
            RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         picth = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(picth) * (double)-1.0F * ((double)1.5F + (double)entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (var36 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)8.0F && (((Entity)var36).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var36).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var36).getPersistentData().m_128471_("attack") || ((Entity)var36).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") == (double)107.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)8.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)8.0F) {
               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               } else {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
               }
            }
         }

         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity57 = (LivingEntity)entity;
            if (_livingEntity57.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity57.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-4.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, (int)((double)2.0F * CNT6), 0.1, 0.1, 0.1, 0.01 * CNT6);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123799_, x_pos, y_pos, z_pos, (int)((double)2.0F * CNT6), 0.1, 0.1, 0.1, 0.01 * CNT6);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)25.0F * CNT6) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, (int)((double)10.0F * CNT6), 0.1, 0.1, 0.1, (double)0.25F * CNT6);
            }

            entity.getPersistentData().m_128347_("Damage", (double)1.5F * CNT6);
            DamageFixProcedure.execute(entity);
            damage = entity.getPersistentData().m_128459_("Damage");
            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();

            for(int index0 = 0; index0 < 4; ++index0) {
               entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)6.0F * CNT6));
               entity.m_146926_((float)(picth + (Math.random() - (double)0.5F) * (double)6.0F * CNT6));
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
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new BulletFlameProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_FLAME_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        entityToSpawn.m_20254_(100);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, (float)damage, 0, (byte)100);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                  _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)(((double)2.5F + Math.random() * 0.2) * CNT6), 0.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
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

            entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)5.0F * CNT6);
            entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
            entity.getPersistentData().m_128347_("effect", (double)10.0F);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F * CNT6 + (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
