package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HairpinProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         Entity entity_a = null;
         boolean SUCCESS = false;
         boolean player = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double range = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double NUM1 = (double)0.0F;
         double CNT6 = (double)0.0F;
         double dis = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1.0F, 1.22F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.OFF_HAND, true);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)32.0F), (e) -> true)) {
               if (entity != entityiterator && entityiterator.getPersistentData().m_128459_("Nail") > (double)0.0F) {
                  double var55;
                  if (entityiterator instanceof Projectile) {
                     Projectile _projEnt = (Projectile)entityiterator;
                     var55 = _projEnt.m_20184_().m_82553_();
                  } else {
                     var55 = (double)0.0F;
                  }

                  if (var55 > (double)0.0F) {
                     SUCCESS = true;
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_();
                     z_pos = entityiterator.m_20189_();
                     x_power = entityiterator.m_20154_().f_82479_;
                     y_power = entityiterator.m_20154_().f_82480_;
                     z_power = entityiterator.m_20154_().f_82481_;
                     CNT6 = (double)1.0F;
                     if (!entityiterator.m_9236_().m_5776_()) {
                        entityiterator.m_146870_();
                     }
                     break;
                  }

                  if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     SUCCESS = true;
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_();
                     z_pos = entityiterator.m_20189_();
                     x_power = (Math.random() - (double)0.5F) * (double)2.0F;
                     y_power = (Math.random() - (double)0.5F) * (double)2.0F;
                     z_power = (Math.random() - (double)0.5F) * (double)2.0F;
                     CNT6 = Math.sqrt(entityiterator.getPersistentData().m_128459_("Nail"));
                     entityiterator.getPersistentData().m_128347_("Nail", (double)0.0F);
                     break;
                  }
               }
            }

            if (SUCCESS) {
               range = (double)1.0F * CNT6;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)range, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)((double)10.0F * CNT6), (double)0.25F * range, (double)0.25F * range, (double)0.25F * range, (double)1.0F * range);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y_pos, z_pos, (int)((double)5.0F * CNT6), (double)0.25F * range, (double)0.25F * range, (double)0.25F * range, (double)1.0F * range);
               }

               x_pos -= x_power * (double)0.25F * (double)16.0F * range;
               y_pos -= y_power * (double)0.25F * (double)16.0F * range;
               z_pos -= z_power * (double)0.25F * (double)16.0F * range;

               for(int index0 = 0; index0 < (int)((double)32.0F * range); ++index0) {
                  ++NUM1;
                  if (NUM1 > (double)0.0F) {
                     entity.getPersistentData().m_128347_("Damage", (double)13.0F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)3.0F * CNT6);
                     entity.getPersistentData().m_128347_("effect", (double)1.0F);
                     entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
                     entity.getPersistentData().m_128379_("ignore", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("BlockRange", (double)1.0F * CNT6);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     NUM1 = (double)-4.0F;
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)((double)1.0F + CNT6), 0.1 * range, 0.1 * range, 0.1 * range, (double)0.0F);
                  }

                  x_pos += x_power * (double)0.25F;
                  y_pos += y_power * (double)0.25F;
                  z_pos += z_power * (double)0.25F;
               }
            } else {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
