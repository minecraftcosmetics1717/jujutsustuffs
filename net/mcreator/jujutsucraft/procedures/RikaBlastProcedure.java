package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BulletCannonProjectileEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class RikaBlastProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         Entity target_entity = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         if (entity instanceof RikaEntity) {
            PlayAnimationEntity2Procedure.execute(entity, "pure_love");
         }

         if (entity instanceof Rika2Entity) {
            PlayAnimationEntity2Procedure.execute(entity, "pure_love");
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var34 = var10000;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         picth = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.45 + Math.sin(picth) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               entity.getPersistentData().m_128347_("cnt6", Math.min(entity.getPersistentData().m_128459_("cnt6"), (double)-2.5F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)2.5F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)((double)1.0F + CNT6), 0.05, 0.05, 0.05, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)((double)1.0F * CNT6), 0.05, 0.05, 0.05, 0.05);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)8.0F) {
               if (var34 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > (double)8.0F && (((Entity)var34).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var34).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var34).getPersistentData().m_128471_("attack") || ((Entity)var34).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)2.5F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)8.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") > (double)2.5F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt6", (double)2.5F);
                  } else if (entity.getPersistentData().m_128459_("cnt6") == (double)2.5F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)2.5F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") == (double)2.5F) {
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                     }

                     ChangeCurseEnergyProcedure.execute(entity, (double)-2.0F);
                  }
               }
            }

            if (var34 instanceof LivingEntity && (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F || entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt6") < (double)4.0F)) {
               RotateEntityProcedure.execute(((Entity)var34).m_20185_(), ((Entity)var34).m_20186_() + (double)((Entity)var34).m_20206_() * (double)0.5F, ((Entity)var34).m_20189_(), entity);
               entity.getPersistentData().m_128347_("cnt5", (double)1.0F);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F + (double)15.0F * CNT6) {
            if (entity.getPersistentData().m_128459_("cnt5") == (double)0.0F && entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }

            if (entity.getPersistentData().m_128459_("cnt3") < (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
               damage = entity.getPersistentData().m_128459_("cnt6");
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(damage * (double)5.0F), 0.1 + damage * 0.2, 0.1 + damage * 0.2, 0.1 + damage * 0.2, (double)1.0F);
               }

               picth = 0.8;

               for(int index0 = 0; index0 < (int)Math.round(damage + (double)1.0F); ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)picth);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)picth, false);
                     }
                  }

                  picth -= 0.1;
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)2.0F * CNT6);
            DamageFixProcedure.execute(entity);
            damage = entity.getPersistentData().m_128459_("Damage");
            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
            entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            for(int index1 = 0; (long)index1 < Math.round((double)4.0F * (CNT6 + (double)0.25F)); ++index1) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new BulletCannonProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CANNON_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, (float)damage, 0, (byte)1);
                  _entityToSpawn.m_6034_(x_pos, y_pos, z_pos);
                  _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)((double)3.0F * (CNT6 + (double)0.25F) + Math.random() * 0.2), 4.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }

            entity.m_146922_((float)yaw);
            entity.m_146926_((float)x_pos);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128347_("Damage", (double)15.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
            entity.getPersistentData().m_128347_("Range", (double)4.0F);
            entity.getPersistentData().m_128347_("knockback", (double)2.0F);
            DamageFixProcedure.execute(entity);

            for(int index2 = 0; index2 < (int)((double)9.0F * range); ++index2) {
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)8.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "minecraft:crit");
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)4.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "minecraft:cloud");
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)18.0F * range, (double)entity.m_146909_(), (double)0.0F, (double)2.0F, (double)8.0F, x_pos, x_pos, y_pos, y_pos, (double)entity.m_146908_(), z_pos, z_pos, "minecraft:crit");
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F + (double)15.0F * CNT6) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
