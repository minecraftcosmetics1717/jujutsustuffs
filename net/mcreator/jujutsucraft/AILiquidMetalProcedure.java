package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AILiquidMetalProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean LogicOwner = false;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_target = (double)0.0F;
         double x_power = (double)0.0F;
         double pitch = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double degree = (double)0.0F;
         double height = (double)0.0F;
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 60, 3, false, false));
               }
            }

            LogicOwner = LogicOwnerExistProcedure.execute(world, entity);
            if (!LogicOwner) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                  int var10000;
                  label209: {
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity_a;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label209;
                        }
                     }

                     var10000 = 0;
                  }

                  int var10001;
                  label204: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label204;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var10000 > var10001 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffect var10003;
                        int var10005;
                        label197: {
                           var67 = new MobEffectInstance;
                           var10003 = MobEffects.f_19600_;
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity_a;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label197;
                              }
                           }

                           var10005 = 0;
                        }

                        var67.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                        _entity.m_7292_(var67);
                     }
                  }

                  float var66;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var66 = _livEnt.m_21223_();
                  } else {
                     var66 = -1.0F;
                  }

                  float var68;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var68 = _livEnt.m_21233_();
                  } else {
                     var68 = -1.0F;
                  }

                  if (var66 < var68) {
                     label233: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt13 = (LivingEntity)entity;
                           if (_livEnt13.m_21023_(MobEffects.f_19605_)) {
                              break label233;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 51, 0, false, false));
                           }
                        }
                     }
                  }

                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt15 = (LivingEntity)entity_a;
                     if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                     }
                  }

                  if (entity_a instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < (double)1.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)(entity.m_20206_() * 0.0F);
               z_pos = entity.m_20189_();
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     logic_a = true;
                     yaw = (double)entity_a.m_146908_();
                     pitch = (double)entity_a.m_146909_();
                     x_power = entity.m_20185_();
                     y_power = entity.m_20186_();
                     z_power = entity.m_20189_();
                     if (entity.getPersistentData().m_128459_("move") == (double)0.0F) {
                        dis = (double)3.0F;
                        degree = (double)60.0F;
                        height = (double)0.0F;
                     } else if (entity.getPersistentData().m_128459_("move") == (double)1.0F) {
                        dis = (double)5.0F;
                        degree = (double)0.0F;
                        height = (double)1.0F;
                     }

                     if (entity.getPersistentData().m_128459_("move") != (double)1.0F) {
                        x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + (double)90.0F + degree)) * dis;
                        y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.25F + height;
                        z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + (double)90.0F + degree)) * dis;
                        if (Math.abs(x_target - x_power) > (double)0.5F) {
                           x_target = x_power + (x_power > x_target ? (double)-0.5F : (double)0.5F);
                        }

                        if (Math.abs(y_target - y_power) > (double)0.5F) {
                           y_target = y_power + (y_power > y_target ? (double)-0.5F : (double)0.5F);
                        }

                        if (Math.abs(z_target - z_power) > (double)0.5F) {
                           z_target = z_power + (z_power > z_target ? (double)-0.5F : (double)0.5F);
                        }

                        entity.m_6021_(x_target, y_target, z_target);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_target, y_target, z_target, entity.m_146908_(), entity.m_146909_());
                        }

                        entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? (double)0.0F : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
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

               if (!logic_a && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }

            if (entity.getPersistentData().m_128459_("move") == (double)1.0F) {
               AILiquidArrowProcedure.execute(world, x, y, z, entity);
            } else {
               logic_a = true;
               if (entity_a instanceof LivingEntity && entity_a.getPersistentData().m_128459_("skill") == (double)3910.0F) {
                  logic_a = false;
               }

               if (logic_a && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(ReturnEntitySizeProcedure.execute(entity) * (double)5.0F), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
               }

               ResetCounterProcedure.execute(entity);
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(ReturnEntitySizeProcedure.execute(entity) * (double)25.0F), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)1.0F);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
