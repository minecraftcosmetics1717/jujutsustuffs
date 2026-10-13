package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityCrackEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ThinIceBreakerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6;
         int var10000;
         label257: {
            boolean logic_a = false;
            boolean player = false;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double HP = (double)0.0F;
            double yaw = (double)0.0F;
            double pitch = (double)0.0F;
            double dis = (double)0.0F;
            double strength = (double)0.0F;
            double range = (double)0.0F;
            double loop_num = (double)0.0F;
            CNT6 = (double)0.0F;
            double rad_now = (double)0.0F;
            double num1 = (double)0.0F;
            double num3 = (double)0.0F;
            double soundPitch = (double)0.0F;
            double num2 = (double)0.0F;
            double x_center = (double)0.0F;
            double y_center = (double)0.0F;
            double z_center = (double)0.0F;
            player = entity instanceof Player;
            CNT6 = (double)1.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label257;
               }
            }

            var10000 = 0;
         }

         double var62 = (double)Math.min(var10000, 50);
         double var63 = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + var62 * 0.025);
         entity.getPersistentData().m_128347_("cnt1", (double)Math.round(entity.getPersistentData().m_128459_("cnt1") + (double)1.0F));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         LivingEntity var88;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var88 = _mobEnt.m_5448_();
         } else {
            var88 = null;
         }

         if (var88 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var88 = _mobEnt.m_5448_();
            } else {
               var88 = null;
            }

            double var53 = ((Entity)var88).m_20185_();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var88 = _mobEnt.m_5448_();
            } else {
               var88 = null;
            }

            double var91 = ((Entity)var88).m_20186_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var55 = var91 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
            LivingEntity var92;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var92 = _mobEnt.m_5448_();
            } else {
               var92 = null;
            }

            double var57 = ((Entity)var92).m_20189_();
            RotateEntityProcedure.execute(var53, var55, var57, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
            double var61 = GetDistanceProcedure.execute(entity);
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var88 = _mobEnt.m_5448_();
            } else {
               var88 = null;
            }

            if (var88 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (var61 < (double)3.0F) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var88 = _mobEnt.m_5448_();
                  } else {
                     var88 = null;
                  }

                  if (((Entity)var88).getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               } else {
                  label243: {
                     if (!(entity instanceof UroTakakoEntity)) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var88 = _mobEnt.m_5448_();
                        } else {
                           var88 = null;
                        }

                        if (((Entity)var88).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var88 = _mobEnt.m_5448_();
                           } else {
                              var88 = null;
                           }

                           if (((Entity)var88).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              entity.getPersistentData().m_128379_("PRESS_Z", false);
                              break label243;
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

            if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
            } else if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * (double)0.5F, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  ChargeParticleProcedure.execute(world, entity, (double)1.0F);
               } else {
                  ChargeParticleProcedure.execute(world, entity, (double)0.0F);
               }

               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)9.0F));
            }

            label264: {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)38.0F && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)38.0F) {
                     break label264;
                  }
               } else if (!(entity instanceof UroTakakoEntity)) {
                  break label264;
               }

               label230: {
                  label229: {
                     if (entity instanceof Player) {
                        if (entity.m_6144_()) {
                           break label229;
                        }
                     } else if (var61 < (double)3.0F) {
                        break label229;
                     }

                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)0.75F);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)0.75F);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)0.75F);
                     break label230;
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)0.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)0.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)0.0F);
               }

               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power")));
               if (entity instanceof Player) {
                  label271: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt66 = (LivingEntity)entity;
                        if (_livEnt66.m_21023_(MobEffects.f_19591_)) {
                           break label271;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity67 = (LivingEntity)entity;
                        if (_livingEntity67.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity67.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-18.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 5, 0, false, false));
               }
            }

            UroCounterProcedure.execute(world, entity);
         } else {
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") <= (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity74 = (LivingEntity)entity;
                  if (_livingEntity74.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity74.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-7.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double var59 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var60 = Math.toRadians((double)entity.m_146909_());
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var59) * Math.cos(var60) * (double)(2.0F + entity.m_20205_()));
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(var60) * (double)-1.0F * (double)(2.0F + entity.m_20205_()));
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var59) * Math.cos(var60) * (double)(2.0F + entity.m_20205_()));
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRACK.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos")), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
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
                        LivingEntity _livingEntity100 = (LivingEntity)entityinstance;
                        if (_livingEntity100.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity100.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)((entity.m_20206_() + entity.m_20205_()) * 4.0F));
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)2.5F && entityinstance instanceof EntityCrackEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "attack");
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            double var54 = entity.getPersistentData().m_128459_("x_pos");
            double var56 = entity.getPersistentData().m_128459_("y_pos");
            double var58 = entity.getPersistentData().m_128459_("z_pos");
            if (entity.getPersistentData().m_128459_("cnt3") <= (double)0.5F + entity.getPersistentData().m_128459_("cnt6") * (double)0.5F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), var54, var56, var58, (int)(var63 * (double)10.0F), var63 * (double)2.0F, var63 * (double)2.0F, var63 * (double)2.0F, (double)0.25F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), var54, var56, var58, (int)(var63 * (double)30.0F), var63 * (double)2.0F, var63 * (double)2.0F, var63 * (double)2.0F, (double)0.25F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var56, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var63 * (double)1.0F), 1.0F);
                  } else {
                     _level.m_7785_(var54, var56, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var63 * (double)1.0F), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var56, var58), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, (float)(var63 * (double)1.0F), 2.0F);
                  } else {
                     _level.m_7785_(var54, var56, var58, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, (float)(var63 * (double)1.0F), 2.0F, false);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", (double)18.0F * CNT6);
               entity.getPersistentData().m_128347_("knockback", (double)3.0F);
               entity.getPersistentData().m_128347_("Range", (double)8.0F * var63);
               entity.getPersistentData().m_128347_("projectile_type", (double)5.0F);
               entity.getPersistentData().m_128379_("ignore", true);
               RangeAttackProcedure.execute(world, var54, var56, var58, entity);
               entity.getPersistentData().m_128347_("BlockDamage", ((double)2.0F + var62 / (double)16.0F) * CNT6);
               entity.getPersistentData().m_128347_("BlockRange", (double)4.0F * var63 * CNT6);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, var54, var56, var58, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)20.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)CNT6, 1.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)CNT6, 1.25F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)CNT6, 1.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)CNT6, 1.25F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
