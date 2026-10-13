package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.GarudaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AIRika1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean garuda = false;
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double dis = (double)0.0F;
         double yaw_cal = (double)0.0F;
         double pitch_cal = (double)0.0F;
         double distance = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         garuda = entity instanceof GarudaEntity;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (garuda) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            } else if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         entity.f_19789_ = 0.0F;
         logic_a = false;
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(64.0F + entity.m_20205_());
         if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                  x_pos = entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
                  z_pos = entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity && entity_a.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
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

                     double var86 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var86 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                     LivingEntity var87;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var87 = _mobEnt.m_5448_();
                     } else {
                        var87 = null;
                     }

                     z_pos = ((Entity)var87).m_20189_();
                  }
               }
            }

            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true)) {
               if (entity != entityiterator) {
                  LivingEntity var88;
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var88 = _mobEnt.m_5448_();
                  } else {
                     var88 = null;
                  }

                  if (var88 instanceof LivingEntity && entityiterator.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
                     if (entityiterator instanceof Mob) {
                        Mob _mobEnt = (Mob)entityiterator;
                        var88 = _mobEnt.m_5448_();
                     } else {
                        var88 = null;
                     }

                     if (((Entity)var88).getPersistentData().m_128459_("friend_num") == entity.getPersistentData().m_128459_("friend_num")) {
                        x_pos = entityiterator.m_20185_();
                        y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                        z_pos = entityiterator.m_20189_();
                        break;
                     }
                  }
               }
            }
         } else {
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            LivingEntity var90;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var90 = _mobEnt.m_5448_();
            } else {
               var90 = null;
            }

            if (var90 instanceof LivingEntity && (GetDistanceProcedure.execute(entity) > (double)16.0F || entity.getPersistentData().m_128459_("cnt1") > (double)20.0F)) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.m_5448_();
               } else {
                  var90 = null;
               }

               x_pos = ((Entity)var90).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.m_5448_();
               } else {
                  var90 = null;
               }

               double var93 = ((Entity)var90).m_20186_();
               LivingEntity var96;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.m_5448_();
               } else {
                  var96 = null;
               }

               y_pos = var93 + (double)((Entity)var96).m_20206_() * (double)0.5F;
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               z_pos = ((Entity)var94).m_20189_();
            }
         }

         entity.getPersistentData().m_128379_("canFly", true);
         GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (garuda) {
               x_power = entity.getPersistentData().m_128459_("x_power") * (double)1.0F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)1.0F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)1.0F;
            } else {
               x_power = entity.getPersistentData().m_128459_("x_power") * (double)0.5F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)0.5F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)0.5F;
            }
         } else {
            if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * (double)0.5F) {
               x_power = entity.m_20184_().m_7096_() - (double)0.125F;
            } else {
               x_power = entity.m_20184_().m_7096_() + (double)0.125F;
            }

            if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * (double)0.5F) {
               y_power = entity.m_20184_().m_7098_() - (double)0.125F;
            } else {
               y_power = entity.m_20184_().m_7098_() + (double)0.125F;
            }

            if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * (double)0.5F) {
               z_power = entity.m_20184_().m_7094_() - (double)0.125F;
            } else {
               z_power = entity.m_20184_().m_7094_() + (double)0.125F;
            }
         }

         entity.m_20256_(new Vec3(x_power, y_power, z_power));
         yaw = (double)(entity.m_146908_() % 360.0F);
         pitch = (double)entity.m_146909_();
         RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * (double)32.0F, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * (double)32.0F, entity.m_20189_() + entity.m_20184_().m_7094_() * (double)32.0F, entity);
         entity.m_146922_(entity.m_146908_() % 360.0F);
         entity.m_146926_(entity.m_146909_());
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         yaw_cal = (double)entity.m_146908_() - yaw;
         if ((!(yaw_cal >= (double)180.0F) || !(yaw_cal < (double)360.0F)) && (!(yaw_cal >= (double)-180.0F) || !(yaw_cal < (double)0.0F))) {
            yaw += Math.min((double)360.0F - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)5.0F;
         } else {
            yaw -= Math.min((double)360.0F - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)5.0F;
         }

         pitch_cal = Math.abs((double)entity.m_146909_() - pitch);
         if (pitch > (double)entity.m_146909_()) {
            pitch -= pitch_cal / (double)5.0F;
         } else {
            pitch += pitch_cal / (double)5.0F;
         }

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

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (!garuda) {
            if (entity.getPersistentData().m_128459_("cnt1") < (double)25.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)12.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.75F);
            } else {
               entity.getPersistentData().m_128347_("Damage", (double)13.0F);
               entity.getPersistentData().m_128347_("knockback", (double)1.5F);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            entity.getPersistentData().m_128347_("Damage", (double)6.5F);
            entity.getPersistentData().m_128347_("knockback", (double)0.75F);
         } else {
            entity.getPersistentData().m_128347_("Damage", (double)9.0F);
            entity.getPersistentData().m_128347_("knockback", (double)1.5F);
         }

         CompoundTag var95;
         int var10004;
         label222: {
            entity.getPersistentData().m_128347_("Range", (double)(entity.m_20206_() + entity.m_20205_()));
            entity.getPersistentData().m_128347_("effect", (double)5.0F);
            entity.getPersistentData().m_128379_("swing", true);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            var95 = entity.getPersistentData();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10004 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label222;
               }
            }

            var10004 = 0;
         }

         var95.m_128347_("BlockDamage", (double)2.5F + (double)0.25F * (double)var10004);
         entity.getPersistentData().m_128347_("BlockRange", (double)((entity.m_20206_() + entity.m_20205_()) / 2.0F));
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)(garuda ? 5 : 20) && entity.getPersistentData().m_128459_("cnt1") % (double)5.0F == (double)1.0F && (entity instanceof GeoEntity || entity instanceof Player)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity123 = (LivingEntity)entity;
               if (_livingEntity123.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity123.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)1.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)(garuda ? 15 : 30)) {
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                  if (!garuda) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 50, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                     }

                     entity.m_6021_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
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

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 50, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                     }
                  } else {
                     entity.m_6021_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-1.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-1.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-1.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-1.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-1.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-1.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
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
                  }
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
