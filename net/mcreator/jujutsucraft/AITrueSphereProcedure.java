package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AITrueSphereProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean LogicOwner = false;
         double x_target = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch = (double)0.0F;
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 60, 3, false, false));
               }
            }

            LogicOwner = LogicOwnerExistProcedure.execute(world, entity);
            if (LogicOwner) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                  float var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21223_();
                  } else {
                     var10000 = -1.0F;
                  }

                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21233_();
                  } else {
                     var10001 = -1.0F;
                  }

                  if (var10000 < var10001) {
                     label201: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt9 = (LivingEntity)entity;
                           if (_livEnt9.m_21023_(MobEffects.f_19605_)) {
                              break label201;
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
                     LivingEntity _livEnt11 = (LivingEntity)entity_a;
                     if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                     }
                  }

                  if (entity.f_19797_ % 20 == 0 && entity_a instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < (double)1.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               }

               double var60;
               label191: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity16 = (LivingEntity)entity;
                     if (_livingEntity16.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var60 = _livingEntity16.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label191;
                     }
                  }

                  var60 = (double)0.0F;
               }

               if (var60 < (double)15.0F && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity18 = (LivingEntity)entity;
                  if (_livingEntity18.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     double var62;
                     label184: {
                        var61 = _livingEntity18.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity17 = (LivingEntity)entity;
                           if (_livingEntity17.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              var62 = _livingEntity17.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                              break label184;
                           }
                        }

                        var62 = (double)0.0F;
                     }

                     var61.m_22100_(Math.min(var62 + 0.3, (double)15.0F));
                  }
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)(entity.m_20206_() * 0.0F);
               z_pos = entity.m_20189_();
               if (entity.getPersistentData().m_128459_("move") == (double)0.0F) {
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                        entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                        if (entity.getPersistentData().m_128459_("cnt_x") > (double)200.0F) {
                           ResetCounterProcedure.execute(entity);
                           entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                           entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
                           entity.getPersistentData().m_128347_("move", entity.getPersistentData().m_128459_("cnt_x2"));
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:1b}");
                           }
                        }

                        logic_a = true;
                        yaw = (double)entity_a.m_146908_();
                        pitch = (double)entity_a.m_146909_();
                        x_power = entity.m_20185_();
                        y_power = entity.m_20186_();
                        z_power = entity.m_20189_();
                        x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + (double)90.0F + (double)180.0F)) * (double)8.0F;
                        y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F + (double)2.0F;
                        z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + (double)90.0F + (double)180.0F)) * (double)8.0F;
                        if (Math.abs(x_target - x_power) > (double)0.5F) {
                           x_target = x_power + (double)(x_power > x_target ? -1 : 1);
                        }

                        if (Math.abs(y_target - y_power) > (double)0.5F) {
                           y_target = y_power + (double)(y_power > y_target ? -1 : 1);
                        }

                        if (Math.abs(z_target - z_power) > (double)0.5F) {
                           z_target = z_power + (double)(z_power > z_target ? -1 : 1);
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

                  if (!logic_a && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               } else {
                  AITrueSphere1Procedure.execute(world, entity);
                  entity.getPersistentData().m_128347_("Damage", (double)30.0F);
                  entity.getPersistentData().m_128347_("Range", (double)entity.m_20206_() * 1.2);
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  entity.getPersistentData().m_128379_("ignore", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("BlockRange", (double)entity.m_20206_() * 0.8);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)99999.0F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  entity.getPersistentData().m_128379_("noEffect", true);
                  entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         } else {
            world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)(entity.m_20206_() * 0.0F), z), Block.m_49956_(((Block)JujutsucraftModBlocks.JUJUTSU_BARRIER.get()).m_49966_()));
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y + (double)(entity.m_20206_() * 0.0F), z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y + (double)(entity.m_20206_() * 0.0F), z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x, y + (double)(entity.m_20206_() * 0.0F), z, (int)(ReturnEntitySizeProcedure.execute(entity) * (double)18.0F), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)0.25F);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
