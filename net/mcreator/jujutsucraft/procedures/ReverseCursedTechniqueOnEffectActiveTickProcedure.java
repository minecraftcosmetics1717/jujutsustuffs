package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ReverseCursedTechniqueOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean using = false;
         boolean heal = false;
         double effectLevel = (double)0.0F;
         double fatigue = (double)0.0F;
         double old_level = (double)0.0F;
         double distance = (double)0.0F;
         double Amount = (double)0.0F;
         double old_tick = (double)0.0F;
         double NUM1 = (double)0.0F;
         if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
            }
         } else {
            int var10001;
            label270: {
               Player = entity instanceof Player;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                     var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                     break label270;
                  }
               }

               var10001 = 0;
            }

            fatigue = (double)1.0F + (double)Math.min(Math.max(var10001, 0) / 600, 10) * 0.4;
            if (entity.m_6084_()) {
               double var10000;
               label264: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).m_19564_();
                        break label264;
                     }
                  }

                  var10000 = (double)0.0F;
               }

               effectLevel = var10000;
               Amount = (double)12.5F + Math.abs(effectLevel) * (double)7.5F;
               using = false;
               heal = entity.getPersistentData().m_128471_("CursedSpirit") ? effectLevel < (double)0.0F : true;
               if (heal) {
                  float var71;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var71 = _livEnt.m_21223_();
                  } else {
                     var71 = -1.0F;
                  }

                  float var79;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var79 = _livEnt.m_21233_();
                  } else {
                     var79 = -1.0F;
                  }

                  if (var71 < var79) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var71 = _livEnt.m_21233_();
                     } else {
                        var71 = -1.0F;
                     }

                     NUM1 = (double)(var71 / 160.0F) * Amount * 0.1;
                     if (entity.getPersistentData().m_128471_("PRESS_M")) {
                        NUM1 /= fatigue;
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        Commands var73 = entity.m_20194_().m_129892_();
                        CommandSourceStack var80 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        double var10002 = Math.abs(NUM1);
                        var73.m_230957_(var80, "jjc_heal " + var10002 + " " + entity.m_20149_());
                     }

                     using = true;
                  }
               } else {
                  float var74;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var74 = _livEnt.m_21233_();
                  } else {
                     var74 = -1.0F;
                  }

                  NUM1 = (double)var74 * (double)0.25F;
                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), (float)NUM1);
                  using = true;
                  if (!entity.m_6084_()) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * (double)0.5F, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (!Player && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               }

               if (using) {
                  if (effectLevel >= (double)0.0F && Math.random() < (double)1.0F / fatigue && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_WHITE.get(), x, y + (double)entity.m_20206_() * (double)0.5F, z, 1, (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, 0.025);
                  }

                  label256: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                           break label256;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt30 = (LivingEntity)entity;
                        if (_livEnt30.m_21023_(MobEffects.f_19597_)) {
                           label249: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                    var10000 = (double)_livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                                    break label249;
                                 }
                              }

                              var10000 = (double)0.0F;
                           }

                           label244: {
                              old_level = var10000;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                    var10000 = (double)_livEnt.m_21124_(MobEffects.f_19597_).m_19557_();
                                    break label244;
                                 }
                              }

                              var10000 = (double)0.0F;
                           }

                           old_tick = var10000;
                           if (old_tick > (double)4.0F * Amount * 0.1) {
                              old_tick -= (double)4.0F * Amount * 0.1;
                           } else {
                              --old_level;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21195_(MobEffects.f_19597_);
                           }

                           if (Math.ceil(old_tick) > (double)0.0F && old_level >= (double)0.0F && entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)Math.ceil(old_tick), (int)Math.round(old_level), false, false));
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt35 = (LivingEntity)entity;
                     if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                        label236: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STUN.get()).m_19564_();
                                 break label236;
                              }
                           }

                           var10000 = (double)0.0F;
                        }

                        label231: {
                           old_level = var10000;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STUN.get()).m_19557_();
                                 break label231;
                              }
                           }

                           var10000 = (double)0.0F;
                        }

                        old_tick = var10000;
                        if (old_tick > (double)4.0F * Amount * 0.1) {
                           old_tick -= (double)4.0F * Amount * 0.1;
                        } else {
                           --old_level;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STUN.get());
                        }

                        if (Math.ceil(old_tick) > (double)0.0F && old_level >= (double)0.0F && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), (int)Math.ceil(old_tick), (int)Math.round(old_level), false, false));
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128471_("PRESS_M")) {
                     if (Player) {
                        Amount = entity.getPersistentData().m_128471_("CursedSpirit") ? (double)5.0F : (double)10.0F;
                        Amount /= fatigue;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> capability.PlayerCursePowerChange -= Amount);
                     }

                     if (!ActiveTickConditionProcedure.execute(entity) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffect var10003;
                           int var10004;
                           label222: {
                              var81 = new MobEffectInstance;
                              var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                    var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                                    break label222;
                                 }
                              }

                              var10004 = 0;
                           }

                           var81.<init>(var10003, Math.min(var10004 + 20, 6000), 0, false, false);
                           _entity.m_7292_(var81);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_M") && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique_output")))) {
                  distance = (double)(entity.m_20205_() * 1.0F);
                  Vec3 _center = new Vec3(entity.m_20185_() + entity.m_20154_().f_82479_ * distance, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_ * distance, entity.m_20189_() + entity.m_20154_().f_82481_ * distance);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(distance * (double)3.0F / (double)2.0F), (e) -> true)) {
                     if (entityiterator instanceof LivingEntity && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && entity != entityiterator) {
                        using = false;
                        if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                              using = true;
                           }
                        } else if (!entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                           using = true;
                        }

                        if (using && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2, 0));
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
