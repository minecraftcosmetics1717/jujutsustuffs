package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackTackleProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         boolean rotate = false;
         boolean avoidance = false;
         boolean logic_b = false;
         boolean water = false;
         boolean stopHighSpeed = false;
         boolean move_avoid = false;
         boolean move_attack = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double old_skill = (double)0.0F;
         double speed = (double)0.0F;
         double vx = (double)0.0F;
         double vy = (double)0.0F;
         double vz = (double)0.0F;
         double y_fix = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double old_mode = (double)0.0F;
         double y_fix_height = (double)0.0F;
         double num1 = (double)0.0F;
         double cnt8 = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double bbHeight = (double)0.0F;
         double bbWidth = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + (double)1.0F);
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         entity.f_19789_ = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19598_, 5, 2, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         targeting = target_entity instanceof LivingEntity;
         bbHeight = (double)entity.m_20206_();
         bbWidth = (double)entity.m_20205_();
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
            entity.getPersistentData().m_128347_("Damage", (double)8.0F);
            entity.getPersistentData().m_128347_("Range", (double)5.0F * range);
            entity.getPersistentData().m_128347_("knockback", 0.2);
            entity.getPersistentData().m_128347_("effect", (double)5.0F);
            entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
            entity.getPersistentData().m_128379_("swing", true);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
            danger = false;
            Vec3 _center = new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)3.0F), (e) -> true)) {
               if (entity != entityiterator) {
                  if (entityiterator.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().m_128459_("Damage") > entity.getPersistentData().m_128459_("Damage") && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     danger = true;
                     break;
                  }

                  double var149;
                  if (entityiterator instanceof Projectile) {
                     Projectile _projEnt = (Projectile)entityiterator;
                     var149 = _projEnt.m_20184_().m_82553_();
                  } else {
                     var149 = (double)0.0F;
                  }

                  if (var149 > (double)0.0F) {
                     danger = true;
                     break;
                  }
               }
            }

            if (!danger) {
               _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true)) {
                  if (entity != entityiterator) {
                     if (entityiterator.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().m_128459_("Damage") > entity.getPersistentData().m_128459_("Damage") * (double)0.75F && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        avoidance = true;
                        break;
                     }

                     double var150;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var150 = _projEnt.m_20184_().m_82553_();
                     } else {
                        var150 = (double)0.0F;
                     }

                     if (var150 > (double)0.0F) {
                        avoidance = true;
                        break;
                     }
                  }
               }
            }

            if (GetDistanceNearestEnemyProcedure.execute(world, entity) < (double)3.0F) {
               danger = true;
               if (GetDistanceProcedure.execute(entity) < (double)3.0F) {
                  rotate = true;
                  stop = true;
               }
            }

            if (entity instanceof Player && entity.m_6144_()) {
               rotate = true;
               stop = true;
            }

            label565: {
               label520: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt42 = (LivingEntity)entity;
                     if (_livEnt42.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        break label520;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label565;
                  }

                  LivingEntity _livEnt43 = (LivingEntity)entity;
                  if (!_livEnt43.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     break label565;
                  }
               }

               water = !entity.m_20069_() && world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() - 0.1, entity.m_20189_())).m_60734_() == Blocks.f_49990_;
            }

            if (OnGroundProcedure.execute(world, entity) || water) {
               if (targeting) {
                  label451: {
                     x_pos = target_entity.m_20185_();
                     y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * (double)0.75F;
                     z_pos = target_entity.m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     yaw = (double)entity.m_146908_();
                     pitch = (double)entity.m_146909_();
                     num1 = GetDistanceProcedure.execute(entity);
                     if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof FushiguroTojiBugEntity)) {
                        label447: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var151 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label447;
                              }
                           }

                           var151 = 0;
                        }

                        int var10001;
                        label442: {
                           var152 = (double)var151 * (double)0.5F;
                           if (target_entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)target_entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label442;
                              }
                           }

                           var10001 = 0;
                        }

                        if (!(var152 >= (double)var10001) && !(range > (double)1.5F)) {
                           if (entity.getPersistentData().m_128459_("cnt8") > (double)30.0F) {
                              move_attack = true;
                           }

                           if (target_entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                              label525: {
                                 label432: {
                                    if (target_entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)target_entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                          var153 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                          break label432;
                                       }
                                    }

                                    var153 = 0;
                                 }

                                 if (var153 <= 10) {
                                    label425: {
                                       if (target_entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)target_entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                             var154 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                             break label425;
                                          }
                                       }

                                       var154 = 0;
                                    }

                                    if (var154 <= 10) {
                                       break label525;
                                    }
                                 }

                                 move_attack = true;
                              }
                           }

                           if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && target_entity.getPersistentData().m_128459_("skill") != (double)0.0F && entity.getPersistentData().m_128459_("cnt8") < (double)30.0F) {
                              move_attack = false;
                           }
                           break label451;
                        }
                     }

                     move_attack = true;
                  }

                  logic_a = false;
                  if (move_attack) {
                     for(int index0 = 0; index0 < 32; ++index0) {
                        entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)90.0F * (num1 > (double)32.0F ? ((double)32.0F - (Math.min(num1, (double)64.0F) - (double)32.0F)) / (double)32.0F : Math.min(num1, (double)32.0F) / (double)32.0F)));
                        entity.m_146926_((float)pitch);
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        for(int index1 = 0; index1 < 4; ++index1) {
                           if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F * range)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                              logic_a = true;
                              break;
                           }

                           if (entity.m_146909_() >= 90.0F) {
                              break;
                           }

                           entity.m_146922_(entity.m_146908_());
                           entity.m_146926_(Math.max(entity.m_146909_() - 10.0F, 90.0F));
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

                        if (logic_a) {
                           break;
                        }
                     }
                  }

                  if (!logic_a || move_avoid) {
                     for(int index2 = 0; index2 < 32; ++index2) {
                        if (num1 < (double)8.0F) {
                           entity.m_146922_((float)(yaw + (double)180.0F + (Math.random() - (double)0.5F) * (double)180.0F));
                           entity.m_146926_(0.0F);
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }
                        } else {
                           entity.m_146922_((float)(yaw + (double)(entity.getPersistentData().m_128459_("cnt_target") % (double)100.0F < (double)50.0F ? 90 : -90) + (Math.random() - (double)0.5F) * (double)90.0F));
                           entity.m_146926_(0.0F);
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

                        for(int index3 = 0; index3 < 4; ++index3) {
                           if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F * range)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                              logic_a = true;
                              break;
                           }

                           if (entity.m_146909_() >= 90.0F) {
                              break;
                           }

                           entity.m_146922_(entity.m_146908_());
                           entity.m_146926_(Math.max(entity.m_146909_() - 10.0F, 90.0F));
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

                        if (logic_a) {
                           break;
                        }
                     }
                  }
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F * range);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F * range);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F * range);
               GetPowerFixProcedure.execute(entity);
               speed = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
               speed *= (double)2.0F;
               if (targeting) {
                  entity.m_6858_(true);
                  vx = entity.getPersistentData().m_128459_("x_power") / (speed * (double)1.0F);
                  vy = entity.getPersistentData().m_128459_("y_power") / (speed * (double)1.0F);
                  vz = entity.getPersistentData().m_128459_("z_power") / (speed * (double)1.0F);
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  num1 = (double)0.0F;

                  for(int index4 = 0; index4 < (int)Math.round(Math.max(speed, (double)1.0F)); ++index4) {
                     ++num1;
                     logic_a = true;
                     if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy, z_pos + vz, bbHeight, bbWidth)) {
                        x_pos += vx;
                        y_pos += vy;
                        z_pos += vz;
                     } else {
                        y_fix = (double)0.0F;
                        logic_a = false;

                        for(int index5 = 0; index5 < (int)Math.round(num1 * (double)1.0F); ++index5) {
                           ++y_fix;
                           if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy + y_fix, z_pos + vz, bbHeight, bbWidth) && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + vy + y_fix, z_pos, bbHeight, bbWidth)) {
                              logic_a = true;
                              x_pos += vx;
                              y_pos = y_pos + vy + y_fix;
                              z_pos += vz;
                              break;
                           }
                        }

                        if (!logic_a) {
                           break;
                        }
                     }
                  }

                  if (!logic_a && !(num1 >= speed * (double)0.5F)) {
                     logic_a = true;
                  } else {
                     logic_a = false;
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }

                  if (logic_a) {
                     entity.m_146922_((float)((double)(entity.m_146908_() + 180.0F) + Mth.m_216263_(RandomSource.m_216327_(), (double)-90.0F, (double)90.0F)));
                     entity.m_146926_((float)Math.max((double)(-1.0F * entity.m_146909_()), (double)22.5F));
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

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F * range);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F * range);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F * range);
                  GetPowerFixProcedure.execute(entity);
                  speed = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
                  speed *= (double)2.0F;
                  if (speed > (double)0.0F) {
                     vx = entity.getPersistentData().m_128459_("x_power") / (speed * (double)1.0F);
                     vy = entity.getPersistentData().m_128459_("y_power") / (speed * (double)1.0F);
                     vz = entity.getPersistentData().m_128459_("z_power") / (speed * (double)1.0F);

                     for(int index6 = 0; index6 < (int)Math.round(Math.max(speed * (double)1.0F, (double)1.0F)); ++index6) {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                        logic_a = true;
                        y_fix = (double)0.0F;
                        if (InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy, z_pos + vz, bbHeight, bbWidth)) {
                           logic_a = false;

                           for(int index7 = 0; index7 < (int)Math.round(Math.max(speed * (double)1.0F, (double)1.0F)); ++index7) {
                              ++y_fix;
                              if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy + y_fix, z_pos + vz, bbHeight, bbWidth) && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + vy + y_fix, z_pos, bbHeight, bbWidth)) {
                                 logic_a = true;
                                 break;
                              }
                           }
                        }

                        if (!logic_a) {
                           break;
                        }

                        y_pos = y_pos + vy + y_fix;
                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           y_pos -= vy + y_fix;
                           entity.m_6021_(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                           }
                        }

                        z_pos += vz;
                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           z_pos -= vz;
                           entity.m_6021_(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                           }
                        }

                        x_pos += vx;
                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           x_pos -= vx;
                           entity.m_6021_(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                           }
                        }

                        if (GetDistanceNearestEnemyProcedure.execute(world, entity) < (double)3.0F) {
                           danger = true;
                           rotate = true;
                           stop = true;
                           break;
                        }
                     }
                  }
               }

               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), (double)0.0F) + 0.05);
               }

               if (water) {
                  entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), (double)0.0F) + 0.05);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 2.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x, y, z, (int)((double)2.0F * range), 0.1 * range, 0.1, 0.1 * range, (double)0.25F);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)((double)2.0F * range), 0.1 * range, 0.1, 0.1 * range, (double)0.25F);
               }

               vx = entity.getPersistentData().m_128459_("x_power");
               vy = entity.getPersistentData().m_128459_("y_power");
               vz = entity.getPersistentData().m_128459_("z_power");
               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, vx, vy, vz);
               entity.m_20256_(new Vec3(vx, Math.min(vy, (double)1.5F * range), vz));
               entity.f_19789_ = 0.0F;
            }

            if (!(entity.getPersistentData().m_128459_("cnt8") > (double)120.0F) && (entity instanceof Player || targeting)) {
               if (rotate) {
                  PlayAnimationEntity2Procedure.execute(entity, "empty");
                  entity.getPersistentData().m_128347_("cnt1", (double)10.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  if (!(entity.getPersistentData().m_128459_("cnt8") <= (double)60.0F)) {
                     entity.getPersistentData().m_128347_("cnt7", (double)3.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt7", !(entity instanceof FushiguroTojiEntity) && !(entity instanceof FushiguroTojiBugEntity) ? Math.ceil((double)3.0F * Math.random()) : (double)(1L + Math.round(Math.random())));
                  }

                  if (stop) {
                     entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  }
               } else if (danger) {
                  PlayAnimationEntity2Procedure.execute(entity, "empty");
                  entity.getPersistentData().m_128347_("cnt1", (double)10.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt7", (double)2.0F);
               }
            } else {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         } else {
            old_skill = entity.getPersistentData().m_128459_("skill");
            cnt8 = entity.getPersistentData().m_128459_("cnt8");
            if (target_entity instanceof LivingEntity) {
               x_pos = target_entity.m_20185_();
               y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * (double)0.75F;
               z_pos = target_entity.m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity165 = (LivingEntity)entity;
               if (_livingEntity165.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity165.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt7") == (double)1.0F) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("cnt7") == (double)2.0F) {
               AttackContinueProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("cnt7") == (double)3.0F) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().m_128347_("skill", old_skill);
               entity.getPersistentData().m_128347_("cnt8", cnt8);
               if (entity.getPersistentData().m_128459_("cnt8") >= (double)60.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
