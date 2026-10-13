package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.EntityCrystalEntity;
import net.mcreator.jujutsucraft.entity.RockFragmentEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class BlasterAwayProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      execute(event, event.getEntity().m_9236_(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean inWater = false;
         double vx = (double)0.0F;
         double vy = (double)0.0F;
         double vz = (double)0.0F;
         double x_step = (double)0.0F;
         double x_pos = (double)0.0F;
         double velocity = (double)0.0F;
         double z_pos = (double)0.0F;
         double speedVel = (double)0.0F;
         double z_step = (double)0.0F;
         double spread = (double)0.0F;
         double pSpeed = (double)0.0F;
         double size = (double)0.0F;
         double bbHeight = (double)0.0F;
         double vSq = (double)0.0F;
         double y_step = (double)0.0F;
         double y_pos = (double)0.0F;
         double bbWidth = (double)0.0F;
         if (entity instanceof LivingEntity) {
            if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entity instanceof EntityCrystalEntity || entity instanceof RockFragmentEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get())) {
                     return;
                  }
               }

               vx = entity.m_20184_().m_7096_();
               vy = entity.m_20184_().m_7098_();
               vz = entity.m_20184_().m_7094_();
               vSq = vx * vx + vy * vy + vz * vz;
               if (!(vSq < 4.8)) {
                  size = Math.min(ReturnEntitySizeProcedure.execute(entity), (double)1.0F);
                  if (!(vSq * size < 4.8)) {
                     velocity = Math.sqrt(vSq);
                     speedVel = velocity * size;
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();
                     x_step = vx / velocity;
                     y_step = vy / velocity;
                     z_step = vz / velocity;
                     bbHeight = (double)entity.m_20206_();
                     bbWidth = (double)entity.m_20205_();
                     CompoundTag data = entity.getPersistentData();
                     int particleCount = (int)Math.round(speedVel * (double)10.0F);
                     spread = speedVel / (double)4.0F;
                     pSpeed = speedVel / (double)8.0F;
                     int loopCount = (int)Math.round(velocity);

                     for(int index0 = 0; index0 < loopCount; ++index0) {
                        BlockPos pos = BlockPos.m_274561_(x_pos, y_pos, z_pos);
                        inWater = world.m_8055_(pos).m_60734_() == Blocks.f_49990_;
                        if (inWater || InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, bbHeight, bbWidth)) {
                           data.m_128347_("knockback", speedVel - (double)2.0F);
                           if (inWater) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel sl = (ServerLevel)world;
                                 sl.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, particleCount, spread, spread, spread, pSpeed);
                                 sl.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, particleCount, spread, spread, spread, pSpeed);
                              }

                              data.m_128347_("BlockDamage", (double)0.0F);
                              data.m_128347_("BlockRange", (double)0.0F);
                           } else {
                              if (world instanceof ServerLevel) {
                                 ServerLevel sl = (ServerLevel)world;
                                 sl.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, particleCount, spread, spread, spread, pSpeed);
                              }

                              if (world instanceof Level) {
                                 Level lvl = (Level)world;
                                 if (!lvl.m_5776_()) {
                                    lvl.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                                 }
                              }

                              data.m_128347_("BlockDamage", speedVel * (double)0.5F);
                              data.m_128347_("BlockRange", Math.min(bbWidth * speedVel, Math.max((double)4.0F, bbWidth)));
                           }

                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           data.m_128379_("noEffect", true);
                           if (inWater || InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, bbHeight, bbWidth)) {
                              break;
                           }
                        }

                        x_pos += x_step;
                        y_pos += y_step;
                        z_pos += z_step;
                     }

                     data.m_128379_("noEffect", false);
                  }
               }
            }
         }
      }
   }
}
