package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CrystalSelfExplosionProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double cnt6 = (double)0.0F;
         double x_target = (double)0.0F;
         double distance = (double)0.0F;
         double picth = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw = (double)0.0F;
         double speed = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double range = (double)0.0F;
         double pitch = (double)0.0F;
         double power = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, 0, false, false));
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         range = ReturnEntitySizeProcedure.execute(entity);
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

            if (((Entity)var10000).m_6084_()) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)20.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)((double)1.0F * range), 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)((double)1.0F * range), 0.5F, false);
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)6.0F);
            DamageFixProcedure.execute(entity);
            if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(""), true);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
               }

               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + entity.getPersistentData().m_128459_("used_technique_cost");
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            } else {
               power = (double)Math.round(((double)20.0F - entity.getPersistentData().m_128459_("cnt1")) * (double)0.25F);
               STR1 = Component.m_237115_("jujutsu.message.long_press").getString();

               for(int index0 = 0; index0 < (int)power; ++index0) {
                  STR1 = "■" + STR1 + "■";
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
                  z_pos = entity.m_20189_();
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(STR1), true);
                  }
               }
            }

            distance = (double)(3.0F + entity.m_20205_());

            for(int index1 = 0; index1 < (int)((double)8.0F * range); ++index1) {
               yaw = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               pitch = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, distance, x_pos + Math.cos(yaw) * Math.cos(pitch) * distance, x_pos, y_pos + Math.sin(pitch) * (double)-1.0F * distance, y_pos, z_pos + Math.sin(yaw) * Math.cos(pitch) * distance, z_pos, "minecraft:crit");
            }
         } else {
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            cnt6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            range = ((double)1.0F + ReturnEntitySizeProcedure.execute(entity)) * cnt6;
            HP = (double)40.0F;
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)35.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") <= (double)21.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(""), true);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)2.0F * cnt6), 0.8F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)2.0F * cnt6), 0.8F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)2.0F * cnt6), 0.8F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)2.0F * cnt6), 0.8F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_IMPACT_WAVE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(entity.m_146909_());
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity45 = (LivingEntity)entityinstance;
                           if (_livingEntity45.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity45.m_21051_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        entityinstance.getPersistentData().m_128347_("cnt6", (double)10.0F + entity.getPersistentData().m_128459_("cnt6"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity52 = (LivingEntity)entityinstance;
                           if (_livingEntity52.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity52.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                           }
                        }

                        if (entityinstance instanceof EntityImpactWaveEntity) {
                           EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entityinstance;
                           animatable.setTexture("flame_tiger");
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  DamageSource var10001 = new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_));
                  float var10002;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.m_21223_();
                  } else {
                     var10002 = -1.0F;
                  }

                  double var10003;
                  label156: {
                     var81 = (double)var10002 * 0.99;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt57 = (LivingEntity)entity;
                        if (_livEnt57.m_21023_(MobEffects.f_19606_)) {
                           int var10006;
                           label152: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var10006 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label152;
                                 }
                              }

                              var10006 = 0;
                           }

                           var10003 = (double)5.0F / Math.max((double)(5 - (1 + var10006)), 0.1);
                           break label156;
                        }
                     }

                     var10003 = (double)1.0F;
                  }

                  entity.m_6469_(var10001, (float)(var81 * var10003));
               }

               if (entity.getPersistentData().m_128459_("cnt1") % (double)4.0F == (double)1.0F) {
                  entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F * cnt6);
                  entity.getPersistentData().m_128347_("BlockRange", (double)12.0F * range);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("Damage", (double)50.0F * cnt6);
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F * cnt6);
                  entity.getPersistentData().m_128347_("Range", (double)24.0F * range);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               cnt6 = (double)2.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:explosion ~ ~ ~ " + range * (double)2.0F + " " + range * (double)2.0F + " " + range * (double)2.0F + " " + (double)1.0F * cnt6 + " " + Math.round((double)10.0F * cnt6 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_big_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + (double)1.0F * cnt6 + " " + Math.round((double)4.0F * cnt6 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:cloud ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + (double)1.0F * cnt6 + " " + Math.round((double)10.0F * cnt6 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:large_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + (double)1.0F * cnt6 + " " + Math.round((double)10.0F * cnt6 * range) + " force");
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)45.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
