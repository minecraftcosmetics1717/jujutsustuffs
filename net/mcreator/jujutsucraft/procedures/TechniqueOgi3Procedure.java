package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         double dis = (double)0.0F;
         double rad = (double)0.0F;
         double tsuki7_mode = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double rad_now = (double)0.0F;
         double yaw_now = (double)0.0F;
         double x_center = (double)0.0F;
         double y_center = (double)0.0F;
         double z_center = (double)0.0F;
         double y_fix = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double CNT6 = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + entity.getPersistentData().m_128459_("cnt10"));
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && entity.m_20184_().m_7098_() >= (double)-0.5F && entity.m_20184_().m_7098_() < (double)0.75F) {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), (double)1.25F, entity.m_20184_().m_7094_()));
         }

         if ((entity.getPersistentData().m_128459_("cnt1") > (double)20.0F || entity.m_20184_().m_7098_() <= (double)0.0F) && entity.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
            entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt4") != (double)0.0F) {
            if (entity.getPersistentData().m_128459_("cnt5") == (double)0.0F) {
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

                  double var82 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var82 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                  LivingEntity var83;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var83 = _mobEnt.m_5448_();
                  } else {
                     var83 = null;
                  }

                  z_pos = ((Entity)var83).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("cnt5", (double)1.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)(entity.m_146909_() - 120.0F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)Math.max(pitch, (double)45.0F));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.getPersistentData().m_128379_("canFly", true);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               GetPowerFixProcedure.execute(entity);
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)pitch);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            } else {
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)1.5F, entity.getPersistentData().m_128459_("y_power") * (double)1.5F, entity.getPersistentData().m_128459_("z_power") * (double)1.5F));
            }

            for(int index0 = 0; index0 < 4; ++index0) {
               dis = (double)2.0F;

               for(int index1 = 0; index1 < (int)((double)4.0F * range); ++index1) {
                  for(int index2 = 0; index2 < 4; ++index2) {
                     if (Math.random() < (double)0.5F) {
                        rad = Math.toRadians(entity.getPersistentData().m_128459_("cnt2"));
                        rad_now = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                        x_pos = entity.m_20185_() + Math.cos(rad) * Math.cos(rad_now) * dis;
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(rad) * (double)-1.0F * dis;
                        z_pos = entity.m_20189_() + Math.cos(rad) * Math.sin(rad_now) * dis;
                        ParticleGeneratorProcedure.execute(world, range * 0.1, (double)2.0F * range, (double)10.0F, (double)4.0F, x_pos, x_pos + Math.cos(rad) * Math.cos(rad_now) * dis, y_pos, y_pos + Math.sin(rad) * (double)-1.0F * dis, z_pos, z_pos + Math.cos(rad) * Math.sin(rad_now) * dis, "jujutsucraft:particle_curse_power_blue");
                     }

                     dis += Math.random() * (double)0.5F;
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)16.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)4.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)1.5F);
                  entity.getPersistentData().m_128347_("effect", (double)5.0F);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  entity.getPersistentData().m_128379_("swing", true);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (y_pos < entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F && (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() || entity.getPersistentData().m_128459_("cnt3") > (double)0.0F)) {
                     CompoundTag var84;
                     int var10003;
                     label163: {
                        var84 = entity.getPersistentData();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label163;
                           }
                        }

                        var10003 = 0;
                     }

                     var84.m_128347_("BlockDamage", (double)0.25F + (double)var10003 * (double)0.5F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
                     entity.getPersistentData().m_128379_("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)((double)15.0F * range), 0.3 * range, 0.3, 0.3 * range, (double)0.5F * range);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)4.0F * range), 0.3 * range, 0.3, 0.3 * range, (double)0.5F * range);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
                  }
               }

               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + Math.random() * (double)10.0F);
               if (entity.getPersistentData().m_128459_("cnt2") > (double)(entity.m_146909_() + 45.0F)) {
                  entity.getPersistentData().m_128347_("cnt2", (double)(entity.m_146909_() + 45.0F));
               }
            }

            if (entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity84 = (LivingEntity)entity;
               if (_livingEntity84.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity84.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-8.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity85 = (LivingEntity)entity;
               if (_livingEntity85.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity85.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else {
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (entity.getPersistentData().m_128459_("cnt6") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt6", (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity89 = (LivingEntity)entity;
                  if (_livingEntity89.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity89.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F || entity.getPersistentData().m_128459_("cnt3") > (double)20.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
