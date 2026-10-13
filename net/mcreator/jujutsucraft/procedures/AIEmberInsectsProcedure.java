package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.FoxFireEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEmberInsectsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double dis = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double CNT6 = (double)0.0F;
         double speed = (double)0.0F;
         double start_time = (double)0.0F;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean reverse = false;
         boolean FoxFire = false;
         boolean SUCCESS = false;
         Entity entity_a = null;
         Entity entity_b = null;
         FoxFire = entity instanceof FoxFireEntity;
         start_time = FoxFire ? (double)15.0F : (double)10.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)64.0F;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_ * (double)64.0F;
         z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)64.0F;
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity_a instanceof Mob) {
               Mob _mobEnt = (Mob)entity_a;
               _mobEnt.m_5448_();
            } else {
               Object var10000 = null;
            }

            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
               if (entity.getPersistentData().m_128459_("cnt1") == start_time || entity.getPersistentData().m_128459_("cnt1") > start_time && Math.random() < 0.2) {
                  dis = (double)6.0F;

                  for(int index0 = 0; index0 < 8; ++index0) {
                     x_pos = entity_a.m_20185_() + entity_a.m_20154_().f_82479_ * dis;
                     y_pos = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.9 + entity_a.m_20154_().f_82480_ * dis;
                     z_pos = entity_a.m_20189_() + entity_a.m_20154_().f_82481_ * dis;
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity_a, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           x_pos = entityiterator.m_20185_();
                           y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                           z_pos = entityiterator.m_20189_();
                           break;
                        }
                     }

                     if (SUCCESS || entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                        break;
                     }

                     dis += (double)6.0F;
                  }

                  entity.getPersistentData().m_128347_("x_pos", x_pos);
                  entity.getPersistentData().m_128347_("y_pos", y_pos);
                  entity.getPersistentData().m_128347_("z_pos", z_pos);
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
               }

               if (entity.getPersistentData().m_128459_("cnt1") <= start_time) {
                  if (FoxFire && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y + (double)entity.m_20206_() * (double)0.5F, z, 4, 0.1, 0.1, 0.1, 0.1);
                  }

                  entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? (double)0.0F : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                  if (entity.getPersistentData().m_128459_("cnt1") < start_time) {
                     entity.m_146922_(entity_a.m_146908_());
                     entity.m_146926_(entity_a.m_146909_());
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else if (dis > (double)32.0F && entity.getPersistentData().m_128459_("move") == (double)0.0F) {
                     x_pos = entity_a.m_20185_() + entity_a.m_20154_().f_82479_ * (double)-8.0F;
                     y_pos = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.9 + entity_a.m_20154_().f_82480_ * (double)-8.0F;
                     z_pos = entity_a.m_20189_() + entity_a.m_20154_().f_82481_ * (double)-8.0F;
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.m_146922_(entity.m_146908_() + 180.0F);
                     entity.m_146926_(entity.m_146909_() * -1.0F);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)64.0F;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_ * (double)64.0F;
                     z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)64.0F;
                  }
               }
            }
         }

         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") >= start_time) {
            entity.getPersistentData().m_128379_("canFly", true);
            GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (FoxFire) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 1, 0.1, 0.1, 0.1, 0.1);
               }
            } else if (entity.getPersistentData().m_128459_("move") != (double)0.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 1, 0.1, 0.1, 0.1, 0.1);
            }

            if (entity.getPersistentData().m_128459_("cnt1") == start_time) {
               if (entity.getPersistentData().m_128459_("move") == (double)0.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                     }
                  }
               } else {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
                     }
                  }
               }

               if (!FoxFire && entity.getPersistentData().m_128459_("cnt6") >= (double)0.0F && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, 0.1, 0.1, 0.1, (double)0.5F);
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * ((double)1.0F + entity.getPersistentData().m_128459_("speed"));
               y_power = entity.getPersistentData().m_128459_("y_power") * ((double)1.0F + entity.getPersistentData().m_128459_("speed"));
               z_power = entity.getPersistentData().m_128459_("z_power") * ((double)1.0F + entity.getPersistentData().m_128459_("speed"));
            } else {
               if (FoxFire) {
                  speed = 0.075;
               } else {
                  speed = entity.getPersistentData().m_128459_("move") == (double)0.0F ? (double)0.125F : 0.05;
               }

               if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * ((double)1.0F + entity.getPersistentData().m_128459_("speed"))) {
                  x_power = entity.m_20184_().m_7096_() - speed;
               } else {
                  x_power = entity.m_20184_().m_7096_() + speed;
               }

               if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * ((double)1.0F + entity.getPersistentData().m_128459_("speed"))) {
                  y_power = entity.m_20184_().m_7098_() - speed;
               } else {
                  y_power = entity.m_20184_().m_7098_() + speed;
               }

               if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * ((double)1.0F + entity.getPersistentData().m_128459_("speed"))) {
                  z_power = entity.m_20184_().m_7094_() - speed;
               } else {
                  z_power = entity.m_20184_().m_7094_() + speed;
               }
            }

            if (!entity.getPersistentData().m_128471_("Stop")) {
               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               BulletDomainHit2Procedure.execute(world, entity);
               RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * (double)32.0F, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * (double)32.0F, entity.m_20189_() + entity.m_20184_().m_7094_() * (double)32.0F, entity);
            } else {
               entity.getPersistentData().m_128379_("Stop", false);
            }

            entity.getPersistentData().m_128347_("Damage", ((double)15.0F + entity.getPersistentData().m_128459_("cnt1") * 0.01) * Math.max(CNT6, (double)0.75F));
            entity.getPersistentData().m_128347_("Range", (double)2.5F);
            entity.getPersistentData().m_128347_("knockback", FoxFire ? 0.1 : (double)1.0F * Math.max(CNT6, (double)0.75F));
            entity.getPersistentData().m_128347_("effect", (double)7.0F);
            RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * (double)0.5F, z, entity);
         }

         dis = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
         if (dis < 0.01) {
            dis = (double)1.0F;
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)80.0F || entity.getPersistentData().m_128459_("cnt1") > (double)50.0F && entity.getPersistentData().m_128459_("move") != (double)0.0F || !entity.m_6084_() || world.m_8055_(BlockPos.m_274561_(x + entity.getPersistentData().m_128459_("x_power") / dis, y + entity.getPersistentData().m_128459_("y_power") / dis, z + entity.getPersistentData().m_128459_("z_power") / dis)).m_60815_() && entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("Damage", (double)15.0F * Math.max(CNT6, (double)0.75F));
            entity.getPersistentData().m_128347_("Range", (double)5.0F);
            entity.getPersistentData().m_128347_("knockback", FoxFire ? 0.1 : (double)1.0F * Math.max(CNT6, (double)0.75F));
            RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * (double)0.5F, z, entity);
            entity.getPersistentData().m_128347_("effect", (double)3.0F);
            Effect7Procedure.execute(world, x, y + (double)entity.m_20206_() * (double)0.5F, z, entity);
            entity.getPersistentData().m_128347_("effect", (double)0.0F);
         }

      }
   }
}
