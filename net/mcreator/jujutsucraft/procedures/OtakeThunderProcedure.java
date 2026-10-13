package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraftforge.registries.ForgeRegistries;

public class OtakeThunderProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double cnt6 = (double)0.0F;
         double x_target = (double)0.0F;
         double distance = (double)0.0F;
         double picth = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double num1 = (double)0.0F;
         double y_pos = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         cnt6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)0.0F) {
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            picth = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(picth) * (double)-1.0F * ((double)1.5F + (double)entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.2);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, (double)0.5F);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
               }

               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)8.0F) {
                  label264: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label265: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                 break label265;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label264;
                           }
                        }
                     }

                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)0.0F));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)-3.0F);
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity55 = (LivingEntity)entity;
                  if (_livingEntity55.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity55.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity56 = (LivingEntity)entity;
                  if (_livingEntity56.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity56.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            LivingEntity var84;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var84 = _mobEnt.m_5448_();
            } else {
               var84 = null;
            }

            if (var84 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.m_5448_();
               } else {
                  var84 = null;
               }

               x_target = ((Entity)var84).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.m_5448_();
               } else {
                  var84 = null;
               }

               double var87 = ((Entity)var84).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_target = var87 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var88;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var88 = _mobEnt.m_5448_();
               } else {
                  var88 = null;
               }

               z_target = ((Entity)var88).m_20189_();
            } else {
               x_target = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_target = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_target = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            }

            x_power = x_target - entity.getPersistentData().m_128459_("x_pos");
            y_power = y_target - entity.getPersistentData().m_128459_("y_pos");
            z_power = z_target - entity.getPersistentData().m_128459_("z_pos");
            distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (distance > (double)0.0F) {
               x_power /= distance;
               y_power /= distance;
               z_power /= distance;
            }

            for(int index0 = 0; index0 < (int)((double)5.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2)); ++index0) {
               entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + x_power);
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + y_power);
               entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + z_power);
            }

            if (world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() || world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
               for(int index1 = 0; index1 < 255 && (world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() || world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))); ++index1) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + (double)1.0F);
               }
            }

            for(int index2 = 0; index2 < 255 && !world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() && !world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))); ++index2) {
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (double)1.0F);
            }

            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos") + (double)16.0F;
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            num1 = (double)0.0F;

            for(int index3 = 0; index3 < 160; ++index3) {
               ++num1;
               if (num1 > (double)0.0F) {
                  num1 = (double)-9.0F;
                  entity.getPersistentData().m_128347_("Damage", (double)16.0F);
                  entity.getPersistentData().m_128347_("Range", (double)5.0F);
                  entity.getPersistentData().m_128347_("knockback", 0.1);
                  entity.getPersistentData().m_128347_("effect", (double)1.0F);
                  entity.getPersistentData().m_128379_("ignore", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (Math.random() < (double)0.25F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                  }
               }

               x_pos += Mth.m_216263_(RandomSource.m_216327_(), -0.1, 0.1);
               y_pos -= 0.1;
               z_pos += Mth.m_216263_(RandomSource.m_216327_(), -0.1, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), x_pos, y_pos, z_pos, (int)((double)20.0F * cnt6), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F * cnt6);
            }

            entity.getPersistentData().m_128347_("BlockRange", (double)1.0F * cnt6);
            entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * cnt6);
            entity.getPersistentData().m_128379_("noEffect", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)18.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)1.0F, x_pos, x_pos, y_pos, y_pos + (double)0.5F, (double)0.0F, z_pos, z_pos, "jujutsucraft:particle_thunder_purple");
            if (entity.getPersistentData().m_128459_("cnt1") > (double)4.0F + entity.getPersistentData().m_128459_("cnt6")) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
