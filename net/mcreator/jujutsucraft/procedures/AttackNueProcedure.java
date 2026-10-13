package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.NueEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraftforge.registries.ForgeRegistries;

public class AttackNueProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double level_jump = (double)0.0F;
         double level = (double)0.0F;
         double level_speed = (double)0.0F;
         double dis = (double)0.0F;
         double distance = (double)0.0F;
         double entity_size = (double)0.0F;
         Entity entity_a = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof NueEntity) {
            PlayAnimationEntity2Procedure.execute(entity, "tackle");
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
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

               double var67 = ((Entity)var10000).m_20186_();
               LivingEntity var69;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var69 = _mobEnt.m_5448_();
               } else {
                  var69 = null;
               }

               y_pos = var67 + (double)((Entity)var69).m_20206_() * (double)0.5F;
               LivingEntity var68;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var68 = _mobEnt.m_5448_();
               } else {
                  var68 = null;
               }

               z_pos = ((Entity)var68).m_20189_();
            } else {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               distance = (double)(64.0F + entity.m_20205_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (!(entity instanceof Player)) {
                  rotate = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)24.0F), (e) -> true)) {
                     if (!rotate && entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        rotate = true;
                        x_pos = entityiterator.m_20185_();
                        y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                        z_pos = entityiterator.m_20189_();
                     }
                  }

                  if (!rotate && entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                        dis = GetDistanceIteratorProcedure.execute(entity, entity_a);
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity) {
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           x_pos = ((Entity)var10000).m_20185_();
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           double var63 = ((Entity)var10000).m_20186_();
                           LivingEntity var10001;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10001 = _mobEnt.m_5448_();
                           } else {
                              var10001 = null;
                           }

                           y_pos = var63 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                           LivingEntity var64;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var64 = _mobEnt.m_5448_();
                           } else {
                              var64 = null;
                           }

                           z_pos = ((Entity)var64).m_20189_();
                        } else {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis * (double)1.5F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis * (double)1.5F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis * (double)1.5F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().m_128379_("canFly", true);
            GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 1.0F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)30.0F) {
            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, entity.getPersistentData().m_128459_("y_power") * (double)0.75F, entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * entity_size), 0.4 * (double)entity.m_20205_(), 0.4 * (double)entity.m_20206_(), 0.4 * (double)entity.m_20205_(), 0.1);
         }

         RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * (double)100.0F, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * (double)100.0F, entity.m_20189_() + entity.m_20184_().m_7094_() * (double)100.0F, entity);
         entity.getPersistentData().m_128347_("Damage", (double)12.0F);
         entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20206_()));
         entity.getPersistentData().m_128347_("knockback", (double)0.5F + Math.random());
         entity.getPersistentData().m_128347_("effect", (double)9.0F);
         entity.getPersistentData().m_128379_("swing", true);
         entity.getPersistentData().m_128379_("attack", true);
         RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * (double)0.5F, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
