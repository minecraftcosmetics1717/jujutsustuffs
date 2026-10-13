package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class RangeAttackProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logicDamageEffect = false;
         boolean guard = false;
         boolean betrayal = false;
         boolean BlackFlash = false;
         boolean highPower = false;
         boolean logic_knockback = false;
         boolean blackflashable = false;
         boolean logic_swing = false;
         double range = 0.0D;
         double x_pos = 0.0D;
         double knockback = 0.0D;
         double x_knockback = 0.0D;
         double num1 = 0.0D;
         double z_knockback = 0.0D;
         double y_pos = 0.0D;
         double damage_source_player = 0.0D;
         double num2 = 0.0D;
         double old_health = 0.0D;
         double z_pos = 0.0D;
         double damage_sorce = 0.0D;
         double y_knockback = 0.0D;
         double distance = 0.0D;
         double H_original = 0.0D;
         double M_original = 0.0D;
         double Y_limit = 0.0D;
         if (!world.isClientSide()) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            }

            blackflashable = entity.getPersistentData().getDouble("Damage") >= 9.0D;
            highPower = entity.getPersistentData().getDouble("Damage") >= 24.0D;
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, highPower ? 1 : 0, false, false));
               }
            }

            DamageFixProcedure.execute(entity);
            damage_source_player = entity.getPersistentData().getDouble("Damage");
            if (entity.getPersistentData().getDouble("KnockbackFix") != 0.0D && entity.getPersistentData().getBoolean("attack") && entity.getPersistentData().getDouble("knockback") >= 1.0D) {
               entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * (1.0D + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6") * 0.2, entity.getPersistentData().getDouble("cnt5") * 0.005), 1.0D) * entity.getPersistentData().getDouble("KnockbackFix")));
            }

            BlackFlash = false;
            if (blackflashable && entity.getPersistentData().getBoolean("attack")) {
               label515: {
                  if (entity instanceof Player) {
                     if (!(pVars.PlayerCursePowerFormer > 150.0D)) {
                        break label515;
                     }
                  } else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:black_flash_able")))) {
                     break label515;
                  }

                  if (entity.getPersistentData().getDouble("skill") != 2105.0D && entity.getPersistentData().getDouble("cnt6") >= 0.0D) {
                     num1 = 1.0D;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt18 = (LivingEntity)entity;
                        if (_livEnt18.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                           double var10000;
                           int var10001;
                           label505: {
                              var10000 = num1 + 2.0D;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                    var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                                    break label505;
                                 }
                              }

                              var10001 = 0;
                           }

                           num1 = var10000 + (double)var10001;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt20 = (LivingEntity)entity;
                        if (_livEnt20.hasEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                           double var148;
                           int var10002;
                           label494: {
                              var148 = num1 + 75.0D;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                                    var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get()).getAmplifier();
                                    break label494;
                                 }
                              }

                              var10002 = 0;
                           }

                           num1 = var148 + (double)(5 * (var10002 + 1));
                        }
                     }

                     label485: {
                        if (entity instanceof Player) {
                           if (!(entity instanceof ServerPlayer)) {
                              break label485;
                           }

                           ServerPlayer _plr23 = (ServerPlayer)entity;
                           if (!(_plr23.level() instanceof ServerLevel) || !_plr23.getAdvancements().getOrStartProgress(_plr23.server.getAdvancements().get(new ResourceLocation("jujutsucraft:black_flash"))).isDone()) {
                              break label485;
                           }
                        } else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:black_flash_able")))) {
                           break label485;
                        }

                        ++num1;
                     }

                     int var149;
                     label475: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                              var149 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                              break label475;
                           }
                        }

                        var149 = 0;
                     }

                     if (var149 > 0) {
                        num1 += 5.0D;
                     }

                     label469: {
                        if (entity instanceof Player) {
                           if (pVars.PlayerCurseTechnique != 21.0D && pVars.PlayerCurseTechnique2 != 21.0D) {
                              break label469;
                           }
                        } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
                           break label469;
                        }

                        num1 += 3.0D;
                     }

                     float var163;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var163 = _livEnt.getHealth();
                     } else {
                        var163 = -1.0F;
                     }

                     var163 = Math.max(var163, 1.0F);
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.getMaxHealth();
                     } else {
                        var10003 = -1.0F;
                     }

                     num1 += (double)((1.0F - var163 / Math.max(var10003, 1.0F)) * 2.0F);
                     num1 += entity.getPersistentData().getDouble("cnt6") * 2.0D;

                     for(int index0 = 0; index0 < (int)Math.round(num1); ++index0) {
                        if (Math.random() > 0.998) {
                           BlackFlash = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            }

            if (!(entity_a instanceof LivingEntity)) {
               ;
            }

            x_pos = x;
            y_pos = y;
            z_pos = z;
            range = entity.getPersistentData().getDouble("Range");
            Y_limit = 1.5D;

            for(int index1 = 0; index1 < 2; ++index1) {
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0D), (e) -> true)) {
                  guard = false;
                  logic_knockback = false;
                  betrayal = LogicBetrayalProcedure.execute(world, entity, entityiterator);
                  knockback = entity.getPersistentData().getDouble("knockback");
                  if (entity != entityiterator || betrayal) {
                     if (!(entityiterator instanceof LivingEntity) && entity.getPersistentData().getBoolean("ExtinctionBlock")) {
                        if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                           entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                        }
                     } else {
                        if (LogicAttackProcedure.execute(world, entity, entityiterator) || betrayal) {
                           EffectConfirmProcedure.execute(world, x, y, z, entity, entityiterator);
                           damage_sorce = damage_source_player;
                           if (BlackFlash && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                              double var150;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var150 = (double)_livEnt.getHealth();
                              } else {
                                 var150 = -1.0D;
                              }

                              old_health = var150;
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat")))), 0.1F);
                              float var151;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var151 = _livEnt.getHealth();
                              } else {
                                 var151 = -1.0F;
                              }

                              if ((double)var151 < old_health) {
                                 damage_sorce = damage_source_player * 4.0D;
                                 highPower = true;
                              } else {
                                 BlackFlash = false;
                              }
                           }

                           if (LogicGuardSuccessProcedure.execute(entityiterator, entity)) {
                              label561: {
                                 label437: {
                                    guard = true;
                                    num1 = Math.max(damage_sorce - entityiterator.getPersistentData().getDouble("Damage"), 0.0D);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt49 = (LivingEntity)entityiterator;
                                       if (_livEnt49.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                          break label437;
                                       }
                                    }

                                    if (!entityiterator.getPersistentData().getBoolean("guard") && !entityiterator.getPersistentData().getBoolean("attack")) {
                                       break label561;
                                    }
                                 }

                                 knockback *= damage_sorce == 0.0D ? 1.0D : Math.max(num1 / damage_sorce, 0.1);
                              }
                           }

                           damage_sorce *= ChangeDamage1Procedure.execute(world, entity, entityiterator);
                           damage_sorce *= ChangeDamage2Procedure.execute();
                           if (damage_sorce > 0.0D) {
                              double var152;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var152 = (double)_livEnt.getHealth();
                              } else {
                                 var152 = -1.0D;
                              }

                              old_health = var152;
                              entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse"))), entity), (float)damage_sorce);
                              float var153;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var153 = _livEnt.getHealth();
                              } else {
                                 var153 = -1.0F;
                              }

                              if ((double)var153 != old_health) {
                                 logic_knockback = true;
                                 EffectProcedure.execute(world, x, y, z, entity, entityiterator);
                                 if (BlackFlash) {
                                    BlackFlash = false;
                                    if (entity instanceof Player && world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                                       pVars.PlayerFame += 200.0D;
                                       pVars.PlayerExperience += 200.0D;
                                       pVars.PlayerTechniqueUsedNumber += 2500.0D;
                                       pVars.syncPlayerVariables(entity);
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ENTITY_BLACK_FLASH.get()).spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 6000, 0, true, true));
                                       }
                                    }

                                    int var154;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt63 = (LivingEntity)entity;
                                       if (_livEnt63.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                          label418: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                   var154 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier();
                                                   break label418;
                                                }
                                             }

                                             var154 = 0;
                                          }

                                          int var155;
                                          label413: {
                                             num1 = (double)Math.max(var154, 0);
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                   var155 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getDuration();
                                                   break label413;
                                                }
                                             }

                                             var155 = 0;
                                          }

                                          num2 = (double)Math.max(var155 - 2000, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get());
                                          }

                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             if (!_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FATIGUE.get(), (int)num2, (int)num1, false, false));
                                             }
                                          }
                                       }
                                    }

                                    int var156;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt68 = (LivingEntity)entity;
                                       if (_livEnt68.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                          label402: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                   var156 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getAmplifier();
                                                   break label402;
                                                }
                                             }

                                             var156 = 0;
                                          }

                                          int var157;
                                          label397: {
                                             num1 = (double)Math.max(var156, 0);
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                   var157 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getDuration();
                                                   break label397;
                                                }
                                             }

                                             var157 = 0;
                                          }

                                          num2 = (double)Math.max(var157 - 2000, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get());
                                          }

                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             if (!_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), (int)num2, (int)num1, false, false));
                                             }
                                          }
                                       }
                                    }

                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entity;
                                       Advancement _adv = _player.server.getAdvancements().get(new ResourceLocation("jujutsucraft:black_flash"));
                                       AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                       if (!_ap.isDone()) {
                                          for(String criteria : _ap.getRemainingCriteria()) {
                                             _player.getAdvancements().award(_adv, criteria);
                                          }
                                       }
                                    }
                                 }

                                 logic_swing = true;
                              }
                           }

                           if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity.isAlive() && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.isAlive()) {
                              entity.getPersistentData().putBoolean("Stop", true);
                           }
                        }

                        double var158;
                        if (entityiterator instanceof Projectile) {
                           Projectile _projEnt = (Projectile)entityiterator;
                           var158 = _projEnt.getDeltaMovement().length();
                        } else {
                           var158 = 0.0D;
                        }

                        if (var158 > 0.0D && entity.getPersistentData().getDouble("projectile_type") != 0.0D && entityiterator.getPersistentData().getDouble("Damage") < entity.getPersistentData().getDouble("Damage")) {
                           logic_swing = true;
                           logic_knockback = true;
                        }

                        if (entity != entityiterator && logic_knockback && knockback > 0.0D) {
                           x_knockback = entityiterator.getX() - entity.getX();
                           y_knockback = entityiterator.getY() - entity.getY();
                           z_knockback = entityiterator.getZ() - entity.getZ();
                           if (entityiterator.onGround()) {
                              y_knockback = Math.abs(y_knockback);
                           }

                           if (x_knockback == 0.0D && z_knockback == 0.0D) {
                              x_knockback = Mth.nextDouble(RandomSource.create(), y_knockback * -1.0D, y_knockback);
                              z_knockback = Mth.nextDouble(RandomSource.create(), y_knockback * -1.0D, y_knockback);
                           }

                           distance = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                           if (distance != 0.0D) {
                              knockback *= 3.0D;
                              x_knockback = x_knockback / distance * knockback;
                              y_knockback = y_knockback / distance * knockback;
                              z_knockback = z_knockback / distance * knockback;
                              if (y_knockback > Y_limit) {
                                 M_original = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                                 H_original = Math.sqrt(x_knockback * x_knockback + z_knockback * z_knockback);
                                 knockback = Math.sqrt(M_original * M_original - Y_limit * Y_limit);
                                 knockback /= H_original != 0.0D ? H_original : 1.0D;
                                 x_knockback *= knockback;
                                 y_knockback = Y_limit;
                                 z_knockback *= knockback;
                              }

                              int var159;
                              if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
                                 float var165;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var165 = _livEnt.getHealth();
                                 } else {
                                    var165 = -1.0F;
                                 }

                                 var165 = Math.max(var165, 1.0F);
                                 float var167;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var167 = _livEnt.getMaxHealth();
                                 } else {
                                    var167 = -1.0F;
                                 }

                                 label369: {
                                    knockback = (double)(4.0F * (1.0F - var165 / Math.max(var167, 1.0F)));
                                    x_knockback *= knockback;
                                    y_knockback *= knockback;
                                    z_knockback *= knockback;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                          var159 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                          break label369;
                                       }
                                    }

                                    var159 = 0;
                                 }

                                 if (var159 < 1 && x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback > 100.0D) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5D, entityiterator.getZ(), 50, 2.0D, 2.0D, 2.0D, 2.0D);
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5D, entityiterator.getZ(), 50, 2.0D, 2.0D, 2.0D, 2.0D);
                                    }

                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5D, entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                                       } else {
                                          _level.playLocalSound(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5D, entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                                       }
                                    }
                                 }
                              }

                              x_knockback += entity.getPersistentData().getDouble("x_knockback");
                              y_knockback += entity.getPersistentData().getDouble("y_knockback");
                              z_knockback += entity.getPersistentData().getDouble("z_knockback");
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity114 = (LivingEntity)entity;
                                 if (_livingEntity114.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                                    label361: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livingEntity115 = (LivingEntity)entityiterator;
                                          if (_livingEntity115.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                                             var158 = _livingEntity115.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue();
                                             break label361;
                                          }
                                       }

                                       var158 = 0.0D;
                                    }

                                    knockback = Math.sqrt(Math.max(var158, 0.0D) + 1.0D);
                                    x_knockback /= knockback;
                                    y_knockback /= knockback;
                                    z_knockback /= knockback;
                                 }
                              }

                              entityiterator.setDeltaMovement(new Vec3(x_knockback, y_knockback, z_knockback));
                              entityiterator.getPersistentData().putDouble("old_x_position", entityiterator.getPersistentData().getDouble("old_x_position") - x_knockback);
                              entityiterator.getPersistentData().putDouble("old_y_position", entityiterator.getPersistentData().getDouble("old_y_position") - y_knockback);
                              entityiterator.getPersistentData().putDouble("old_z_position", entityiterator.getPersistentData().getDouble("old_z_position") - z_knockback);
                           }
                        }
                     }
                  }
               }

               if (!(entity instanceof LivingEntity)) {
                  break;
               }

               LivingEntity _livEnt124 = (LivingEntity)entity;
               if (!_livEnt124.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().getBoolean("Failed") || entity.getPersistentData().getBoolean("attack") || entity.getPersistentData().getBoolean("DomainAttack")) {
                  break;
               }

               double var161;
               int var162;
               label335: {
                  x_pos = entity.getPersistentData().getDouble("x_pos_doma");
                  y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                  z_pos = entity.getPersistentData().getDouble("z_pos_doma");
                  var161 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var162 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                        break label335;
                     }
                  }

                  var162 = 0;
               }

               range = var161 * (double)(var162 > 0 ? 6 : 2);
               entity.getPersistentData().putBoolean("DomainAttack", true);
            }

            entity.getPersistentData().putDouble("effect", 0.0D);
            entity.getPersistentData().putDouble("effectConfirm", 0.0D);
            entity.getPersistentData().putDouble("projectile_type", 0.0D);
            entity.getPersistentData().putBoolean("attack", false);
            entity.getPersistentData().putBoolean("ignore", false);
            entity.getPersistentData().putBoolean("DomainAttack", false);
         }
      }
   }
}