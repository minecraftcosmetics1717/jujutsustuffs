package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AvoidanceProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double distance = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double CNT6 = (double)0.0F;
         double degree = (double)0.0F;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else {
            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F && entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt1", (double)3.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity11 = (LivingEntity)entity;
                  if (_livingEntity11.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity11.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-20.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity12 = (LivingEntity)entity;
                  if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity12.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entity;
                     if (_livingEntity15.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity15.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                     }
                  }
               } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D") && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity18 = (LivingEntity)entity;
                  if (_livingEntity18.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity18.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_W")) {
                  degree = Math.toRadians((double)0.0F);
                  if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree += Math.toRadians((double)45.0F);
                  } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree -= Math.toRadians((double)45.0F);
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entity;
                     if (_livingEntity24.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity24.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)3.0F);
                     }
                  }
               } else if (entity.getPersistentData().m_128471_("PRESS_S")) {
                  degree = Math.toRadians((double)180.0F);
                  if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree -= Math.toRadians((double)45.0F);
                  } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D")) {
                     degree += Math.toRadians((double)45.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity31 = (LivingEntity)entity;
                        if (_livingEntity31.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity31.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                        }
                     }
                  }
               } else if (!entity.getPersistentData().m_128471_("PRESS_A") && entity.getPersistentData().m_128471_("PRESS_D")) {
                  degree += Math.toRadians((double)90.0F);
               } else if (entity.getPersistentData().m_128471_("PRESS_A") && !entity.getPersistentData().m_128471_("PRESS_D")) {
                  degree -= Math.toRadians((double)90.0F);
               } else {
                  degree = Math.toRadians((double)180.0F);
               }

               yaw += degree;
               PlayAnimationProcedure.execute(world, entity);
               pitch = Math.toRadians((double)0.0F);
               distance = (double)999.0F;
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)10.0F * range), range * (double)0.25F, 0.1, range * (double)0.25F, (double)0.5F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.6F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.6F, false);
                     }
                  }
               } else if (entity.getPersistentData().m_128459_("cnt2") >= (double)7.0F) {
                  if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 0.6F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 0.6F, false);
                        }
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)1.0F * range), range * 0.1, 0.1, range * 0.1, 0.2);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
                  }
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * (double)0.75F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)0.75F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)0.75F;
               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != (double)0.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);

               for(int index0 = 0; index0 < (int)Math.max(dis, (double)1.0F); ++index0) {
                  entity.getPersistentData().m_128347_("Damage", (double)9.0F);
                  entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
                  entity.getPersistentData().m_128347_("knockback", (double)0.75F);
                  entity.getPersistentData().m_128347_("effect", (double)5.0F);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().m_128379_("attack", true);
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            }
         }

      }
   }
}
