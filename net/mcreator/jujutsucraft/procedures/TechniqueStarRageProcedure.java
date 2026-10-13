package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.TsukumoYukiEntity;
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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

public class TechniqueStarRageProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean actived = false;
         double timer = (double)0.0F;
         double strength = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double dis = (double)0.0F;
         if (entity.getPersistentData().m_128459_("skill") == (double)915.0F && entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", (double)61.0F);
            entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            entity.getPersistentData().m_128347_("cnt3", (double)-2.0F);
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt3") <= (double)0.0F) {
            double var10000;
            label304: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                     break label304;
                  }
               }

               var10000 = (double)0.0F;
            }

            strength = var10000;
            actived = true;
            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               label297: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                        if (strength < (double)5.0F) {
                           strength = (double)5.0F;
                        } else if (strength < (double)9.0F) {
                           strength = (double)9.0F;
                        } else {
                           strength = (double)-1.0F;
                        }
                        break label297;
                     }
                  }

                  strength = (double)2.0F;
               }
            } else if (entity.getPersistentData().m_128459_("cnt3") == (double)-1.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") % (double)4.0F == (double)1.0F) {
                  if (strength < (double)9.0F) {
                     strength = Math.min(strength + (double)1.0F, (double)9.0F);
                  } else {
                     actived = false;
                  }
               } else {
                  actived = false;
               }
            } else if (entity.getPersistentData().m_128459_("cnt3") == (double)-2.0F) {
               if (strength >= (double)255.0F) {
                  entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
                  strength = (double)255.0F + Math.pow(entity.getPersistentData().m_128459_("cnt4") + (double)1.0F, (double)3.0F);
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)80.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               } else {
                  strength = Math.min(Math.max(strength, (double)9.0F) + (double)20.0F, (double)255.0F);
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)40.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            } else {
               actived = false;
            }

            if (actived) {
               if (strength >= (double)0.0F) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:star_rage infinite " + Math.round(strength) + " true");
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        String var10001 = Component.m_237115_("effect.star_rage").getString();
                        _player.m_5661_(Component.m_237113_(var10001 + ": " + Math.round((strength + (double)1.0F) * (double)10.0F) + "%"), false);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("effect.star_rage").getString() + ": OFF"), false);
                     }
                  }
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound ui.button.click master @s");
               }
            }
         }

         if (!(entity instanceof Player)) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
            LivingEntity var72;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var72 = _mobEnt.m_5448_();
            } else {
               var72 = null;
            }

            if (var72 instanceof LivingEntity && entity instanceof TsukumoYukiEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (!entity.getPersistentData().m_128471_("PRESS_Z") && !(entity.getPersistentData().m_128459_("cnt2") > (double)0.0F)) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)230.0F) {
            label238: {
               if (entity instanceof Player && entity instanceof Player) {
                  Player _plr = (Player)entity;
                  if (_plr.m_150110_().f_35937_) {
                     break label238;
                  }
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F) {
            if (entity.getPersistentData().m_128459_("skill") == (double)915.0F) {
               int var73;
               label282: {
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt3", (double)-2.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                        var73 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                        break label282;
                     }
                  }

                  var73 = 0;
               }

               label277: {
                  strength = (double)Math.round((double)var73 * 0.1);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                        var73 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                        break label277;
                     }
                  }

                  var73 = 0;
               }

               timer = (double)Math.round((float)(var73 * 2));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)timer, 1, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)Math.min(timer, (double)200.0F), (int)Math.min(strength, (double)3.0F), false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)61.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
                  if (entity.getPersistentData().m_128459_("cnt1") == (double)101.0F) {
                     int var75;
                     label264: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var75 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label264;
                           }
                        }

                        var75 = 0;
                     }

                     HP = (double)(500 + var75 * 50);
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLACK_HOLE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                              entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                           }

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
                              LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                              if (_livingEntity64.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 _livingEntity64.m_21051_(Attributes.f_22276_).m_22100_(HP);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.m_21153_((float)HP);
                           }

                           entityinstance.getPersistentData().m_128347_("cnt6", (double)30.0F);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity70 = (LivingEntity)entityinstance;
                              if (_livingEntity70.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 _livingEntity70.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)8.0F);
                              }
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }

                     entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                     entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                     entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
                  }

                  DamageSource var76 = new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_));
                  float var10002;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.m_21223_();
                  } else {
                     var10002 = -1.0F;
                  }

                  entity.m_6469_(var76, (float)((double)var10002 * (double)0.5F));
                  if (entity.getPersistentData().m_128459_("cnt1") > (double)140.0F) {
                     entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)35.0F);
               } else {
                  entity.getPersistentData().m_128347_("Damage", (double)20.0F);
               }

               DamageFixProcedure.execute(entity);
               range = ReturnEntitySizeProcedure.execute(entity);

               for(int index0 = 0; index0 < 8; ++index0) {
                  x_pos = entity.m_20185_() + (Math.random() - (double)0.5F) * (double)25.0F * range;
                  y_pos = entity.m_20186_() + (Math.random() - (double)0.5F) * (double)25.0F * range;
                  z_pos = entity.m_20189_() + (Math.random() - (double)0.5F) * (double)25.0F * range;
                  x_power = entity.m_20185_() - x_pos;
                  y_power = entity.m_20186_() - y_pos;
                  z_power = entity.m_20189_() - z_pos;
                  dis = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_power, (double)2.0F));
                  if (dis != (double)0.0F) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:squid_ink ~ ~ ~ " + x_power * (double)10000.0F + " " + y_power * (double)10000.0F + " " + z_power * (double)10000.0F + " 0.001 0 force");
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") != (double)915.0F) {
               label337: {
                  if (entity instanceof Player) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr94 = (ServerPlayer)entity;
                        if (_plr94.m_9236_() instanceof ServerLevel && _plr94.m_8960_().m_135996_(_plr94.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_black_hole"))).m_8193_()) {
                           break label337;
                        }
                     }

                     if (entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           break label337;
                        }
                     }
                  } else if (entity instanceof TsukumoYukiEntity) {
                     break label337;
                  }

                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  return;
               }

               entity.getPersistentData().m_128347_("skill", (double)915.0F);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("cnt3", (double)-1.0F);
         } else {
            entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
         }

      }
   }
}
