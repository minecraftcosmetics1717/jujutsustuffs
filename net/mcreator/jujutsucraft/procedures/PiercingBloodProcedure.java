package net.mcreator.jujutsucraft.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.entity.BloodBallEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PiercingBloodProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         boolean water = false;
         boolean logic_b = false;
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double CNT6 = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         water = entity instanceof SukunaFushiguroEntity || !((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)6.0F || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)6.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            double var105 = ((Entity)var10000).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var111 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var111 += (double)((Entity)var10002).m_20206_() * 0.8;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var105, var111, ((Entity)var10002).m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)20.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity19 = (LivingEntity)entity;
               if (_livingEntity19.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity19.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-4.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (0.6 + (double)entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (0.6 + (double)entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (0.6 + (double)entity.m_20205_());
            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity.getPersistentData().m_128459_("NameRanged") != (double)0.0F) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)25.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof BloodBallEntity && entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged")) {
                        entityiterator.getPersistentData().m_128379_("despawn", true);
                        entityiterator.m_6021_(x_pos, y_pos, z_pos);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityiterator.m_146908_(), entityiterator.m_146909_());
                        }

                        entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)15.0F));
                        entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)5.0F));
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                        break;
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)((double)1.0F * CNT6), (double)0.0F, (double)0.0F, (double)0.0F, 0.1 * CNT6);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)((double)1.0F * CNT6), (double)0.0F, (double)0.0F, (double)0.0F, 0.1 * CNT6);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)19.0F) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > (double)6.0F) {
                     label379: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label380: {
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
                                    break label380;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label379;
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
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)19.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  } else if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                     }

                     ChangeCurseEnergyProcedure.execute(entity, (double)-1.0F);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (0.6 + (double)entity.m_20205_()));
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (0.6 + (double)entity.m_20205_()));
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (0.6 + (double)entity.m_20205_()));
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_);
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("x_pos"));
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("y_pos"));
               entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("z_pos"));
            }

            if (entity.getPersistentData().m_128459_("cnt2") <= (double)15.0F + entity.getPersistentData().m_128459_("cnt6")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity114 = (LivingEntity)entity;
                  if (_livingEntity114.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity114.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-4.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt2") <= (double)5.0F + entity.getPersistentData().m_128459_("cnt6")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 8, 9, false, false));
                  }
               }

               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (0.6 + (double)entity.m_20205_());
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (0.6 + (double)entity.m_20205_());
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (0.6 + (double)entity.m_20205_());
               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.2F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.2F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.0F, false);
                     }
                  }

                  ParticleGeneratorCircleProcedure.execute(world, (double)36.0F * range, (double)entity.m_146909_(), 0.1 * range, (double)1.5F * range, (double)1.0F, x_pos, x_pos, y_pos, y_pos, (double)entity.m_146908_(), z_pos, z_pos, "minecraft:cloud");
               }
            }

            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            x_power = entity.getPersistentData().m_128459_("x_power") * 0.1;
            y_power = entity.getPersistentData().m_128459_("y_power") * 0.1;
            z_power = entity.getPersistentData().m_128459_("z_power") * 0.1;

            for(int index0 = 0; index0 < 50; ++index0) {
               ++dis;
               if (dis > (double)0.0F) {
                  dis = (double)-10.0F;
                  entity.getPersistentData().m_128347_("Damage", (double)20.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)2.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)1.0F - (entity.getPersistentData().m_128459_("cnt1") - (double)20.0F) * 0.05);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  if (!water) {
                     entity.getPersistentData().m_128347_("effect", (double)11.0F);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               logic_a = false;
               logic_b = false;
               if ((dis == (double)-10.0F || dis == (double)-5.0F) && !world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), (double)0.5F, (double)0.5F, (double)0.5F), (e) -> true).isEmpty() && entity != (Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), (double)0.5F, (double)0.5F, (double)0.5F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                  }
               })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((Object)null) && ((Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), (double)0.5F, (double)0.5F, (double)0.5F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                  }
               })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((Object)null)).m_6084_()) {
                  logic_b = true;
               }

               if (world.m_46859_(BlockPos.m_274561_(x_pos + x_power, y_pos, z_pos))) {
                  x_pos += x_power;
               } else {
                  logic_a = true;
               }

               if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + y_power, z_pos))) {
                  y_pos += y_power;
               } else {
                  logic_a = true;
               }

               if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos + z_power))) {
                  z_pos += z_power;
               } else {
                  logic_a = true;
               }

               if (logic_a || logic_b) {
                  entity.getPersistentData().m_128347_("Damage", (double)20.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)2.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)1.0F - (entity.getPersistentData().m_128459_("cnt1") - (double)20.0F) * 0.05);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  if (!water) {
                     entity.getPersistentData().m_128347_("effect", (double)11.0F);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (logic_a) {
                     entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.25F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.25F, false);
                     }
                  }

                  if (water) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, (double)1.0F);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, (double)1.0F);
                  }
                  break;
               }
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            x_pos = entity.getPersistentData().m_128459_("cnt3");
            y_pos = entity.getPersistentData().m_128459_("cnt4");
            z_pos = entity.getPersistentData().m_128459_("cnt5");

            for(int index1 = 0; index1 < 40; ++index1) {
               if (water) {
                  ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)10.0F), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_blue");
               } else {
                  ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)10.0F), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_red");
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
