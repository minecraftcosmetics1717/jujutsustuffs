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
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double knockback = (double)0.0F;
         double x_knockback = (double)0.0F;
         double num1 = (double)0.0F;
         double z_knockback = (double)0.0F;
         double y_pos = (double)0.0F;
         double damage_source_player = (double)0.0F;
         double num2 = (double)0.0F;
         double old_health = (double)0.0F;
         double z_pos = (double)0.0F;
         double damage_sorce = (double)0.0F;
         double y_knockback = (double)0.0F;
         double distance = (double)0.0F;
         double H_original = (double)0.0F;
         double M_original = (double)0.0F;
         double Y_limit = (double)0.0F;
         if (!world.m_5776_()) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            }

            blackflashable = entity.getPersistentData().m_128459_("Damage") >= (double)9.0F;
            highPower = entity.getPersistentData().m_128459_("Damage") >= (double)24.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, highPower ? 1 : 0, false, false));
               }
            }

            DamageFixProcedure.execute(entity);
            damage_source_player = entity.getPersistentData().m_128459_("Damage");
            if (entity.getPersistentData().m_128459_("KnockbackFix") != (double)0.0F && entity.getPersistentData().m_128471_("attack") && entity.getPersistentData().m_128459_("knockback") >= (double)1.0F) {
               entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * ((double)1.0F + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6") * 0.2, entity.getPersistentData().m_128459_("cnt5") * 0.005), (double)1.0F) * entity.getPersistentData().m_128459_("KnockbackFix")));
            }

            BlackFlash = false;
            if (blackflashable && entity.getPersistentData().m_128471_("attack")) {
               label515: {
                  if (entity instanceof Player) {
                     if (!(pVars.PlayerCursePowerFormer > (double)150.0F)) {
                        break label515;
                     }
                  } else if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:black_flash_able")))) {
                     break label515;
                  }

                  if (entity.getPersistentData().m_128459_("skill") != (double)2105.0F && entity.getPersistentData().m_128459_("cnt6") >= (double)0.0F) {
                     num1 = (double)1.0F;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt18 = (LivingEntity)entity;
                        if (_livEnt18.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                           double var10000;
                           int var10001;
                           label505: {
                              var10000 = num1 + (double)2.0F;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                    var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
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
                        if (_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                           double var148;
                           int var10002;
                           label494: {
                              var148 = num1 + (double)75.0F;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                                    var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get()).m_19564_();
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
                           if (!(_plr23.m_9236_() instanceof ServerLevel) || !_plr23.m_8960_().m_135996_(_plr23.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:black_flash"))).m_8193_()) {
                              break label485;
                           }
                        } else if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:black_flash_able")))) {
                           break label485;
                        }

                        ++num1;
                     }

                     int var149;
                     label475: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                              var149 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).m_19564_();
                              break label475;
                           }
                        }

                        var149 = 0;
                     }

                     if (var149 > 0) {
                        num1 += (double)5.0F;
                     }

                     label469: {
                        if (entity instanceof Player) {
                           if (pVars.PlayerCurseTechnique != (double)21.0F && pVars.PlayerCurseTechnique2 != (double)21.0F) {
                              break label469;
                           }
                        } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity)) {
                           break label469;
                        }

                        num1 += (double)3.0F;
                     }

                     float var163;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var163 = _livEnt.m_21223_();
                     } else {
                        var163 = -1.0F;
                     }

                     var163 = Math.max(var163, 1.0F);
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.m_21233_();
                     } else {
                        var10003 = -1.0F;
                     }

                     num1 += (double)((1.0F - var163 / Math.max(var10003, 1.0F)) * 2.0F);
                     num1 += entity.getPersistentData().m_128459_("cnt6") * (double)2.0F;

                     for(int index0 = 0; index0 < (int)Math.round(num1); ++index0) {
                        if (Math.random() > 0.998) {
                           BlackFlash = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            }

            if (!(entity_a instanceof LivingEntity)) {
               ;
            }

            x_pos = x;
            y_pos = y;
            z_pos = z;
            range = entity.getPersistentData().m_128459_("Range");
            Y_limit = (double)1.5F;

            for(int index1 = 0; index1 < 2; ++index1) {
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                  guard = false;
                  logic_knockback = false;
                  betrayal = LogicBetrayalProcedure.execute(world, entity, entityiterator);
                  knockback = entity.getPersistentData().m_128459_("knockback");
                  if (entity != entityiterator || betrayal) {
                     if (!(entityiterator instanceof LivingEntity) && entity.getPersistentData().m_128471_("ExtinctionBlock")) {
                        if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                           entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                        }
                     } else {
                        if (LogicAttackProcedure.execute(world, entity, entityiterator) || betrayal) {
                           EffectConfirmProcedure.execute(world, x, y, z, entity, entityiterator);
                           damage_sorce = damage_source_player;
                           if (BlackFlash && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                              double var150;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var150 = (double)_livEnt.m_21223_();
                              } else {
                                 var150 = (double)-1.0F;
                              }

                              old_health = var150;
                              entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), 0.1F);
                              float var151;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var151 = _livEnt.m_21223_();
                              } else {
                                 var151 = -1.0F;
                              }

                              if ((double)var151 < old_health) {
                                 damage_sorce = damage_source_player * (double)4.0F;
                                 highPower = true;
                              } else {
                                 BlackFlash = false;
                              }
                           }

                           if (LogicGuardSuccessProcedure.execute(entityiterator, entity)) {
                              label561: {
                                 label437: {
                                    guard = true;
                                    num1 = Math.max(damage_sorce - entityiterator.getPersistentData().m_128459_("Damage"), (double)0.0F);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt49 = (LivingEntity)entityiterator;
                                       if (_livEnt49.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                          break label437;
                                       }
                                    }

                                    if (!entityiterator.getPersistentData().m_128471_("guard") && !entityiterator.getPersistentData().m_128471_("attack")) {
                                       break label561;
                                    }
                                 }

                                 knockback *= damage_sorce == (double)0.0F ? (double)1.0F : Math.max(num1 / damage_sorce, 0.1);
                              }
                           }

                           damage_sorce *= ChangeDamage1Procedure.execute(world, entity, entityiterator);
                           damage_sorce *= ChangeDamage2Procedure.execute();
                           if (damage_sorce > (double)0.0F) {
                              double var152;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var152 = (double)_livEnt.m_21223_();
                              } else {
                                 var152 = (double)-1.0F;
                              }

                              old_health = var152;
                              entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse"))), entity), (float)damage_sorce);
                              float var153;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var153 = _livEnt.m_21223_();
                              } else {
                                 var153 = -1.0F;
                              }

                              if ((double)var153 != old_health) {
                                 logic_knockback = true;
                                 EffectProcedure.execute(world, x, y, z, entity, entityiterator);
                                 if (BlackFlash) {
                                    BlackFlash = false;
                                    if (entity instanceof Player && world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                                       pVars.PlayerFame += (double)200.0F;
                                       pVars.PlayerExperience += (double)200.0F;
                                       pVars.PlayerTechniqueUsedNumber += (double)2500.0F;
                                       pVars.syncPlayerVariables(entity);
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ENTITY_BLACK_FLASH.get()).m_262496_(_level, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), MobSpawnType.MOB_SUMMONED);
                                       if (entityToSpawn != null) {
                                          entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 6000, 0, true, true));
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt63 = (LivingEntity)entity;
                                       if (_livEnt63.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                          label418: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                   var154 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19564_();
                                                   break label418;
                                                }
                                             }

                                             var154 = 0;
                                          }

                                          label413: {
                                             num1 = (double)Math.max(var154, 0);
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                                   var155 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).m_19557_();
                                                   break label413;
                                                }
                                             }

                                             var155 = 0;
                                          }

                                          num2 = (double)Math.max(var155 - 2000, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FATIGUE.get());
                                          }

                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             if (!_entity.m_9236_().m_5776_()) {
                                                _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FATIGUE.get(), (int)num2, (int)num1, false, false));
                                             }
                                          }
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt68 = (LivingEntity)entity;
                                       if (_livEnt68.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                          label402: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                   var156 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                                                   break label402;
                                                }
                                             }

                                             var156 = 0;
                                          }

                                          label397: {
                                             num1 = (double)Math.max(var156, 0);
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                   var157 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19557_();
                                                   break label397;
                                                }
                                             }

                                             var157 = 0;
                                          }

                                          num2 = (double)Math.max(var157 - 2000, 0);
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get());
                                          }

                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             if (!_entity.m_9236_().m_5776_()) {
                                                _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), (int)num2, (int)num1, false, false));
                                             }
                                          }
                                       }
                                    }

                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entity;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:black_flash"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 }

                                 logic_swing = true;
                              }
                           }

                           if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entity.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.m_6084_()) {
                              entity.getPersistentData().m_128379_("Stop", true);
                           }
                        }

                        double var158;
                        if (entityiterator instanceof Projectile) {
                           Projectile _projEnt = (Projectile)entityiterator;
                           var158 = _projEnt.m_20184_().m_82553_();
                        } else {
                           var158 = (double)0.0F;
                        }

                        if (var158 > (double)0.0F && entity.getPersistentData().m_128459_("projectile_type") != (double)0.0F && entityiterator.getPersistentData().m_128459_("Damage") < entity.getPersistentData().m_128459_("Damage")) {
                           logic_swing = true;
                           logic_knockback = true;
                        }

                        if (entity != entityiterator && logic_knockback && knockback > (double)0.0F) {
                           x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                           y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                           z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                           if (entityiterator.m_20096_()) {
                              y_knockback = Math.abs(y_knockback);
                           }

                           if (x_knockback == (double)0.0F && z_knockback == (double)0.0F) {
                              x_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * (double)-1.0F, y_knockback);
                              z_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * (double)-1.0F, y_knockback);
                           }

                           distance = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                           if (distance != (double)0.0F) {
                              knockback *= (double)3.0F;
                              x_knockback = x_knockback / distance * knockback;
                              y_knockback = y_knockback / distance * knockback;
                              z_knockback = z_knockback / distance * knockback;
                              if (y_knockback > Y_limit) {
                                 M_original = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                                 H_original = Math.sqrt(x_knockback * x_knockback + z_knockback * z_knockback);
                                 knockback = Math.sqrt(M_original * M_original - Y_limit * Y_limit);
                                 knockback /= H_original != (double)0.0F ? H_original : (double)1.0F;
                                 x_knockback *= knockback;
                                 y_knockback = Y_limit;
                                 z_knockback *= knockback;
                              }

                              if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
                                 float var165;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var165 = _livEnt.m_21223_();
                                 } else {
                                    var165 = -1.0F;
                                 }

                                 var165 = Math.max(var165, 1.0F);
                                 float var167;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var167 = _livEnt.m_21233_();
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
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                          var159 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                          break label369;
                                       }
                                    }

                                    var159 = 0;
                                 }

                                 if (var159 < 1 && x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback > (double)100.0F) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F, entityiterator.m_20189_(), 50, (double)2.0F, (double)2.0F, (double)2.0F, (double)2.0F);
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F, entityiterator.m_20189_(), 50, (double)2.0F, (double)2.0F, (double)2.0F, (double)2.0F);
                                    }

                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.m_5776_()) {
                                          _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F, entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                                       } else {
                                          _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F, entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                                       }
                                    }
                                 }
                              }

                              x_knockback += entity.getPersistentData().m_128459_("x_knockback");
                              y_knockback += entity.getPersistentData().m_128459_("y_knockback");
                              z_knockback += entity.getPersistentData().m_128459_("z_knockback");
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity114 = (LivingEntity)entity;
                                 if (_livingEntity114.m_21204_().m_22171_(Attributes.f_22278_)) {
                                    label361: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livingEntity115 = (LivingEntity)entityiterator;
                                          if (_livingEntity115.m_21204_().m_22171_(Attributes.f_22278_)) {
                                             var158 = _livingEntity115.m_21051_(Attributes.f_22278_).m_22115_();
                                             break label361;
                                          }
                                       }

                                       var158 = (double)0.0F;
                                    }

                                    knockback = Math.sqrt(Math.max(var158, (double)0.0F) + (double)1.0F);
                                    x_knockback /= knockback;
                                    y_knockback /= knockback;
                                    z_knockback /= knockback;
                                 }
                              }

                              entityiterator.m_20256_(new Vec3(x_knockback, y_knockback, z_knockback));
                              entityiterator.getPersistentData().m_128347_("old_x_position", entityiterator.getPersistentData().m_128459_("old_x_position") - x_knockback);
                              entityiterator.getPersistentData().m_128347_("old_y_position", entityiterator.getPersistentData().m_128459_("old_y_position") - y_knockback);
                              entityiterator.getPersistentData().m_128347_("old_z_position", entityiterator.getPersistentData().m_128459_("old_z_position") - z_knockback);
                           }
                        }
                     }
                  }
               }

               if (!(entity instanceof LivingEntity)) {
                  break;
               }

               LivingEntity _livEnt124 = (LivingEntity)entity;
               if (!_livEnt124.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().m_128471_("Failed") || entity.getPersistentData().m_128471_("attack") || entity.getPersistentData().m_128471_("DomainAttack")) {
                  break;
               }

               double var161;
               int var162;
               label335: {
                  x_pos = entity.getPersistentData().m_128459_("x_pos_doma");
                  y_pos = entity.getPersistentData().m_128459_("y_pos_doma");
                  z_pos = entity.getPersistentData().m_128459_("z_pos_doma");
                  var161 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var162 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                        break label335;
                     }
                  }

                  var162 = 0;
               }

               range = var161 * (double)(var162 > 0 ? 6 : 2);
               entity.getPersistentData().m_128379_("DomainAttack", true);
            }

            entity.getPersistentData().m_128347_("effect", (double)0.0F);
            entity.getPersistentData().m_128347_("effectConfirm", (double)0.0F);
            entity.getPersistentData().m_128347_("projectile_type", (double)0.0F);
            entity.getPersistentData().m_128379_("attack", false);
            entity.getPersistentData().m_128379_("ignore", false);
            entity.getPersistentData().m_128379_("DomainAttack", false);
         }
      }
   }
}
