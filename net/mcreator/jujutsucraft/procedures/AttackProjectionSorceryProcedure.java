package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.FrameEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AttackProjectionSorceryProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean berserker = false;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double old_skill = (double)0.0F;
         double dis = (double)0.0F;
         double speed = (double)0.0F;
         double vx = (double)0.0F;
         double vy = (double)0.0F;
         double vz = (double)0.0F;
         double y_fix = (double)0.0F;
         double rnd = (double)0.0F;
         double y_fix_height = (double)0.0F;
         double old_mode = (double)0.0F;
         double cnt8 = (double)0.0F;
         double cnt9 = (double)0.0F;
         double dis2 = (double)0.0F;
         double distance = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 5, 0, false, false));
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

         targeting = var10000 instanceof LivingEntity;
         if (entity.getPersistentData().m_128459_("cnt7") <= (double)10.0F) {
            if (!targeting) {
               if (!(entity instanceof Player)) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               y_pos = ((Entity)var10000).m_20186_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               z_pos = ((Entity)var10000).m_20189_();
               dis = (double)0.0F;

               for(int index0 = 0; index0 < 255 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - dis, z_pos)).m_60815_(); ++index0) {
                  if (y_pos - dis < (double)0.0F) {
                     dis = (double)255.0F;
                     break;
                  }

                  ++dis;
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)9.0F), (e) -> true)) {
                  if (entity != entityiterator) {
                     if (entityiterator.getPersistentData().m_128459_("Damage") > (double)0.0F && entityiterator.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        danger = true;
                        break;
                     }

                     double var146;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var146 = _projEnt.m_20184_().m_82553_();
                     } else {
                        var146 = (double)0.0F;
                     }

                     if (var146 > (double)0.0F) {
                        danger = true;
                        break;
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt7") <= (double)0.0F && OnGroundProcedure.execute(world, entity)) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  x_pos = ((Entity)var10000).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  double var149 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var149 + (double)((Entity)var10001).m_20206_() * (double)0.75F;
                  LivingEntity var150;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var150 = _mobEnt.m_5448_();
                  } else {
                     var150 = null;
                  }

                  z_pos = ((Entity)var150).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  dis2 = GetDistanceProcedure.execute(entity);
                  berserker = false;
                  if (entity.getPersistentData().m_128459_("cnt7") >= (double)0.0F) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var150 = _mobEnt.m_5448_();
                     } else {
                        var150 = null;
                     }

                     label551: {
                        if (((Entity)var150).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var150 = _mobEnt.m_5448_();
                           } else {
                              var150 = null;
                           }

                           if (((Entity)var150).getPersistentData().m_128459_("skill") == (double)0.0F) {
                              break label551;
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var150 = _mobEnt.m_5448_();
                           } else {
                              var150 = null;
                           }

                           if (((Entity)var150).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label551;
                           }
                        }

                        berserker = true;
                     }

                     label542: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var154 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label542;
                           }
                        }

                        var154 = 0;
                     }

                     double var155 = (double)var154 * (double)0.75F;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     label536: {
                        LivingEntity _mobEnt = var10001;
                        if (_mobEnt instanceof LivingEntity) {
                           LivingEntity _livEnt = _mobEnt;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var170 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label536;
                           }
                        }

                        var170 = 0;
                     }

                     if (var155 > (double)var170) {
                        berserker = true;
                     }
                  }

                  if ((berserker || dis2 > (double)32.0F) && !danger) {
                     entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)90.0F * (Math.min(dis2, (double)32.0F) / (double)32.0F)));
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

                     entity.getPersistentData().m_128347_("cnt7", (double)(dis > (double)2.0F && dis < (double)16.0F ? 2 : 1));
                  } else {
                     label651: {
                        if (!(entity.getPersistentData().m_128459_("cnt7") < (double)0.0F)) {
                           label623: {
                              label523: {
                                 if (!(entity.getPersistentData().m_128459_("cnt8") < (double)10.0F)) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var150 = _mobEnt.m_5448_();
                                    } else {
                                       var150 = null;
                                    }

                                    if (((Entity)var150).getPersistentData().m_128459_("skill") == (double)0.0F) {
                                       break label523;
                                    }

                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var150 = _mobEnt.m_5448_();
                                    } else {
                                       var150 = null;
                                    }

                                    if (!(((Entity)var150).getPersistentData().m_128459_("Damage") > (double)0.0F)) {
                                       break label523;
                                    }
                                 }

                                 if (dis2 < (double)6.0F) {
                                    break label623;
                                 }
                              }

                              if (!(entity.getPersistentData().m_128459_("cnt8") < (double)5.0F) || !(dis2 < (double)3.0F)) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var150 = _mobEnt.m_5448_();
                                 } else {
                                    var150 = null;
                                 }

                                 label487: {
                                    if (((Entity)var150).getPersistentData().m_128459_("skill") != (double)0.0F) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var150 = _mobEnt.m_5448_();
                                       } else {
                                          var150 = null;
                                       }

                                       if (((Entity)var150).getPersistentData().m_128459_("Damage") > (double)0.0F) {
                                          if (entity instanceof Mob) {
                                             Mob _mobEnt = (Mob)entity;
                                             var150 = _mobEnt.m_5448_();
                                          } else {
                                             var150 = null;
                                          }

                                          if (!((Entity)var150).getPersistentData().m_128471_("attack")) {
                                             break label487;
                                          }
                                       }
                                    }

                                    if (!(entity.getPersistentData().m_128459_("cnt8") < (double)10.0F)) {
                                       entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)90.0F * (Math.min(dis2, (double)32.0F) / (double)32.0F)));
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

                                       entity.getPersistentData().m_128347_("cnt7", (double)(dis > (double)2.0F && dis < (double)16.0F ? 2 : 1));
                                       break label651;
                                    }
                                 }

                                 entity.m_146922_((float)(yaw + (double)(Math.random() < (double)0.5F ? 90 : -90) + (Math.random() - (double)0.5F) * (double)90.0F));
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

                                 entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                                 break label651;
                              }
                           }
                        }

                        logic_a = false;

                        for(int index1 = 0; index1 < 64; ++index1) {
                           entity.m_146922_((float)(yaw + (double)180.0F + (Math.random() - (double)0.5F) * (double)270.0F));
                           entity.m_146926_(-45.0F);
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)2.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                              entity.m_146922_(entity.m_146908_());
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

                              logic_a = true;
                              break;
                           }
                        }

                        if (!logic_a) {
                           entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)90.0F * (Math.min(dis2, (double)32.0F) / (double)32.0F)));
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

                           entity.getPersistentData().m_128347_("cnt7", (double)(dis > (double)2.0F && dis < (double)16.0F ? 2 : 1));
                        } else {
                           entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_(MobEffects.f_19597_);
            }

            entity.f_19789_ = 0.0F;
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
            GetPowerFixProcedure.execute(entity);
            if (targeting && entity.getPersistentData().m_128459_("cnt7") == (double)2.0F && dis > (double)2.0F && dis < (double)16.0F && entity.m_20184_().m_7098_() >= -0.05) {
               entity.getPersistentData().m_128379_("canFly", true);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var162 = ((Entity)var10000).m_20185_();
               LivingEntity var171;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var171 = _mobEnt.m_5448_();
               } else {
                  var171 = null;
               }

               double var172 = ((Entity)var171).m_20186_();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               var172 += (double)(((Entity)var10002).m_20206_() * 1.0F);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               GetPowerForwardProcedure.execute(var162, var172, ((Entity)var10002).m_20189_(), entity);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)1.0F, entity.getPersistentData().m_128459_("y_power") * (double)1.0F, entity.getPersistentData().m_128459_("z_power") * (double)1.0F));
            } else if (entity.getPersistentData().m_128459_("cnt8") > (double)100.0F) {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            } else if (OnGroundProcedure.execute(world, entity)) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 2, 0.1, 0.1, 0.1, (double)0.5F);
               }

               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)1.0F, entity.getPersistentData().m_128459_("y_power") * (double)1.0F, entity.getPersistentData().m_128459_("z_power") * (double)1.0F));
               entity.getPersistentData().m_128347_("cnt7", (double)0.0F);
            }

            speed = Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), (double)2.0F) + Math.pow(entity.m_20184_().m_7098_(), (double)2.0F) + Math.pow(entity.m_20184_().m_7094_(), (double)2.0F));
            speed *= (double)2.0F;
            if (speed != (double)0.0F) {
               vx = entity.m_20184_().m_7096_() / speed;
               vy = entity.m_20184_().m_7098_() / speed;
               vz = entity.m_20184_().m_7094_() / speed;

               for(int index2 = 0; index2 < (int)Math.round(Math.max(speed, (double)1.0F)); ++index2) {
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) < (double)3.0F) {
                     rotate = true;
                     if (GetDistanceProcedure.execute(entity) < (double)3.0F) {
                        stop = true;
                        if (entity.getPersistentData().m_128459_("cnt_special") > (double)0.0F) {
                           entity.getPersistentData().m_128347_("cnt_special", (double)-60.0F);
                           EntityUseProjectionSorceryProcedure.execute(entity);
                        }
                     }

                     if (targeting && entity.getPersistentData().m_128459_("cnt7") == (double)2.0F) {
                        double var163 = entity.m_20186_();
                        LivingEntity var174;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var174 = _mobEnt.m_5448_();
                        } else {
                           var174 = null;
                        }

                        if (var163 <= ((Entity)var174).m_20186_() + (double)1.0F) {
                           stop = false;
                           rotate = false;
                        }
                     }

                     if (rotate) {
                        break;
                     }
                  }

                  if (speed == (double)0.0F) {
                     break;
                  }

                  logic_a = true;
                  y_fix_height = (double)0.0F;

                  for(int index3 = 0; index3 < (int)Math.ceil((double)(entity.m_20206_() + 0.0F)); ++index3) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix_height, z_pos)).m_60815_()) {
                        logic_a = false;
                        break;
                     }

                     ++y_fix_height;
                  }

                  if (logic_a) {
                     x_pos += vx;
                     y_pos += vy;
                     z_pos += vz;
                  } else {
                     logic_a = false;
                     y_fix = (double)0.0F;

                     for(int index4 = 0; index4 < (int)Math.round(Math.max(speed * (double)2.0F, (double)1.0F)); ++index4) {
                        if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix, z_pos + vz)).m_60815_()) {
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, Math.max(y_pos + vy, y_pos) + y_fix, z_pos)).m_60815_()) {
                              logic_a = false;
                              break;
                           }

                           y_fix += (double)0.5F;
                        } else {
                           logic_a = true;
                           y_fix_height = (double)0.0F;

                           for(int index5 = 0; index5 < (int)Math.ceil((double)entity.m_20206_()); ++index5) {
                              if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_()) {
                                 logic_a = false;
                                 break;
                              }

                              ++y_fix_height;
                           }

                           if (logic_a) {
                              break;
                           }

                           ++y_fix;
                        }
                     }

                     if (!logic_a) {
                        entity.getPersistentData().m_128347_("cnt7", (double)-1.0F);
                        break;
                     }

                     x_pos += vx;
                     y_pos = y_pos + vy + y_fix;
                     z_pos += vz;
                  }

                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }
               }
            }

            if (rotate) {
               entity.getPersistentData().m_128347_("cnt1", (double)10.0F);
               if (world.m_6443_(FrameEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)6.0F, (double)6.0F, (double)6.0F), (e) -> true).isEmpty() && (!stop || !(entity.getPersistentData().m_128459_("cnt9") > (double)4.0F) && entity.getPersistentData().m_128459_("cnt7") != (double)2.0F)) {
                  entity.getPersistentData().m_128347_("cnt7", (double)(!stop ? 11L : Math.round((double)10.0F + Math.ceil(Math.random() * (double)2.0F))));
               } else {
                  entity.getPersistentData().m_128347_("cnt7", (double)12.0F);
               }

               if (stop) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") > (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19598_, 2, 2, false, false));
               }
            }

            old_skill = entity.getPersistentData().m_128459_("skill");
            old_mode = entity.getPersistentData().m_128459_("mode");
            cnt8 = entity.getPersistentData().m_128459_("cnt8");
            cnt9 = entity.getPersistentData().m_128459_("cnt9");
            if (targeting) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var166 = ((Entity)var10000).m_20186_();
               LivingEntity var175;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var175 = _mobEnt.m_5448_();
               } else {
                  var175 = null;
               }

               y_pos = var166 + (double)((Entity)var175).m_20206_() * (double)0.75F;
               LivingEntity var167;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var167 = _mobEnt.m_5448_();
               } else {
                  var167 = null;
               }

               z_pos = ((Entity)var167).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            label372: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     var168 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                     break label372;
                  }
               }

               var168 = (double)0.0F;
            }

            distance = var168;
            if (entity.getPersistentData().m_128459_("cnt7") == (double)11.0F) {
               AttackContinueProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("cnt7") == (double)12.0F) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            } else {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
            }

            if (distance > (double)0.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)distance, 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().m_128347_("skill", old_skill);
               entity.getPersistentData().m_128347_("mode", old_mode);
               entity.getPersistentData().m_128347_("cnt8", cnt8);
               entity.getPersistentData().m_128347_("cnt9", cnt9);
               if (entity.getPersistentData().m_128459_("cnt9") > (double)4.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }

               entity.getPersistentData().m_128347_("cnt8", Math.min(entity.getPersistentData().m_128459_("cnt8"), (double)20.0F));
               entity.getPersistentData().m_128347_("cnt9", entity.getPersistentData().m_128459_("cnt9") + (double)1.0F);
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
