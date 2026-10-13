package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class HighSpeedOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, double amplifier) {
      if (entity != null) {
         Entity target_entity = null;
         boolean stopHighSpeed = false;
         boolean logic_a = false;
         boolean move_avoid = false;
         boolean move_attack = false;
         double vx = (double)0.0F;
         double vy = (double)0.0F;
         double vz = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double speed = (double)0.0F;
         double bbHeight = (double)0.0F;
         double num1 = (double)0.0F;
         double y_fix = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double bbWidth = (double)0.0F;
         if (amplifier > (double)0.0F) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            target_entity = var10000;
            if (target_entity instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                     return;
                  }
               }

               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  _entity.m_21573_().m_26573_();
               }

               bbHeight = (double)entity.m_20206_();
               bbWidth = (double)entity.m_20205_();
               range = ReturnEntitySizeProcedure.execute(entity);
               if (OnGroundProcedure.execute(world, entity)) {
                  x_pos = target_entity.m_20185_();
                  y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * (double)0.75F;
                  z_pos = target_entity.m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  num1 = GetDistanceProcedure.execute(entity);
                  if (!(entity instanceof FushiguroTojiBugEntity) && !(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(range > (double)1.5F)) {
                     if (target_entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                        label364: {
                           label315: {
                              if (target_entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)target_entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var106 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                    break label315;
                                 }
                              }

                              var106 = 0;
                           }

                           if (var106 <= 10) {
                              label308: {
                                 if (target_entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)target_entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var107 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                       break label308;
                                    }
                                 }

                                 var107 = 0;
                              }

                              if (var107 <= 10) {
                                 break label364;
                              }
                           }

                           move_attack = true;
                        }
                     }

                     if (num1 > (double)32.0F) {
                        move_attack = true;
                     }

                     label299: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var108 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label299;
                           }
                        }

                        var108 = 0;
                     }

                     int var10001;
                     label294: {
                        var109 = (double)var108 * (double)0.5F;
                        if (target_entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)target_entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label294;
                           }
                        }

                        var10001 = 0;
                     }

                     if (var109 >= (double)var10001) {
                        move_attack = true;
                     }

                     if (entity.getPersistentData().m_128459_("cnt_backstep") > (double)10.0F) {
                        move_avoid = true;
                     }
                  } else {
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

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F * range);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F * range);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F * range);
                  GetPowerFixProcedure.execute(entity);
                  speed = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
                  speed *= (double)2.0F;
                  if (speed > (double)0.0F) {
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
                           stopHighSpeed = true;
                           break;
                        }
                     }
                  }

                  if (entity.m_20096_()) {
                     entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), (double)0.0F) + 0.05);
                  }

                  vx = entity.getPersistentData().m_128459_("x_power");
                  vy = entity.getPersistentData().m_128459_("y_power");
                  vz = entity.getPersistentData().m_128459_("z_power");
                  StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, vx, vy, vz);
                  entity.m_20256_(new Vec3(vx, Math.min(vy, (double)1.5F * range), vz));
                  entity.f_19789_ = 0.0F;
               }

               if (stopHighSpeed) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get());
                  }

                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               }
            }
         }

      }
   }
}
