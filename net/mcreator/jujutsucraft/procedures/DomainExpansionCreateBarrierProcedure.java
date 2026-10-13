package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.FushiguroMegumiEntity;
import net.mcreator.jujutsucraft.entity.FushiguroMegumiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DomainExpansionCreateBarrierProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         Entity target_entity = null;
         double x_dis = (double)0.0F;
         double distance = (double)0.0F;
         double z_dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double domainRadius = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double loop_num = (double)0.0F;
         double power = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double y_dis = (double)0.0F;
         boolean old_failed = false;
         boolean reStart = false;
         boolean update_pos = false;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var49 = var10000;
         if (entity.getPersistentData().m_128459_("cnt3") < (double)20.0F) {
            entity.getPersistentData().m_128347_("select", (double)0.0F);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               ChangeCurseEnergyProcedure.execute(entity, entity.getPersistentData().m_128459_("used_technique_cost"));
            }

            int var133;
            double var10002;
            label278: {
               label463: {
                  var128 = entity.getPersistentData();
                  var10002 = entity.getPersistentData().m_128459_("cnt3");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        break label463;
                     }
                  }

                  label272: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           var133 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                           break label272;
                        }
                     }

                     var133 = 0;
                  }

                  if (var133 <= 0) {
                     var133 = 1;
                     break label278;
                  }
               }

               var133 = 2;
            }

            var128.m_128347_("cnt3", var10002 + (double)var133);
            if (entity instanceof Player) {
               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  power = (double)Math.round(((double)20.0F - entity.getPersistentData().m_128459_("cnt3")) * (double)0.25F);
                  STR1 = Component.m_237115_("jujutsu.message.long_press").getString();

                  for(int index0 = 0; index0 < (int)power; ++index0) {
                     STR1 = "■" + STR1 + "■";
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(STR1), true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt3") >= (double)20.0F && entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(""), true);
                     }
                  }
               } else {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(""), true);
                     }
                  }

                  entity.getPersistentData().m_128347_("select", (double)0.0F);
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
               }
            }
         } else {
            domainRadius = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            entity.m_20256_(new Vec3((double)0.0F, Math.min(entity.m_20184_().m_7098_(), (double)0.0F), (double)0.0F));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
               ChangeCurseEnergyProcedure.execute(entity, entity.getPersistentData().m_128459_("used_technique_cost") * (double)-1.0F);
               if (entity instanceof Player && Math.random() < 0.01 && entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_open_barrier_type_domain"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }

               if (var49 instanceof LivingEntity) {
                  RotateEntityProcedure.execute(((Entity)var49).m_20185_(), ((Entity)var49).m_20186_() + (double)((Entity)var49).m_20206_() * (double)0.5F, ((Entity)var49).m_20189_(), entity);
               }

               label467: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt36 = (LivingEntity)entity;
                     if (_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label467;
                     }
                  }

                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
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

                  entity.getPersistentData().m_128347_("x_pos_doma", (double)Math.round(entity.m_20185_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)0.0F)) * domainRadius * (double)0.5F));
                  entity.getPersistentData().m_128347_("y_pos_doma", (double)Math.round(var49 instanceof LivingEntity ? Math.min(entity.m_20186_(), ((Entity)var49).m_20186_()) : entity.m_20186_()));
                  entity.getPersistentData().m_128347_("z_pos_doma", (double)Math.round(entity.m_20189_() + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)0.0F)) * domainRadius * (double)0.5F));
                  entity.m_146922_((float)yaw);
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
               }

               label433: {
                  label497: {
                     if (entity.getPersistentData().m_128459_("select") == (double)1.0F || entity.getPersistentData().m_128459_("select") == (double)18.0F) {
                        if (!(entity instanceof Player)) {
                           if (entity instanceof KenjakuEntity) {
                              break label497;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt60 = (LivingEntity)entity;
                              if (_livEnt60.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label497;
                              }
                           }
                        } else {
                           label483: {
                              label470: {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr56 = (ServerPlayer)entity;
                                    if (_plr56.m_9236_() instanceof ServerLevel && _plr56.m_8960_().m_135996_(_plr56.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_open_barrier_type_domain"))).m_8193_()) {
                                       break label470;
                                    }
                                 }

                                 if (!(entity instanceof LivingEntity)) {
                                    break label483;
                                 }

                                 LivingEntity _livEnt57 = (LivingEntity)entity;
                                 if (!_livEnt57.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label483;
                                 }
                              }

                              if (!entity.m_6144_()) {
                                 break label497;
                              }
                           }
                        }
                     }

                     if (!(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
                        entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                        break label433;
                     }

                     entity.getPersistentData().m_128347_("cnt2", (double)-1.0F);
                     break label433;
                  }

                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               }

               reStart = false;
               update_pos = false;
               entity.getPersistentData().m_128379_("Failed", false);
               entity.getPersistentData().m_128379_("Cover", false);

               for(int index1 = 0; index1 < 2; ++index1) {
                  entity.getPersistentData().m_128347_("x_pos_doma2", (double)Math.round(entity.m_20185_()));
                  entity.getPersistentData().m_128347_("y_pos_doma2", (double)Math.round(entity.m_20186_()));
                  entity.getPersistentData().m_128347_("z_pos_doma2", (double)Math.round(entity.m_20189_()));
                  Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(domainRadius * (double)2.0F * (double)2.0F / (double)2.0F), (e) -> true)) {
                     x_dis = entity.m_20185_() - entityiterator.m_20185_();
                     y_dis = entity.m_20186_() - entityiterator.m_20186_();
                     z_dis = entity.m_20189_() - entityiterator.m_20189_();
                     dis = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (dis < domainRadius * domainRadius) {
                        label474: {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)(domainRadius * (double)2.0F + (double)1.0F), 9, false, false));
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt85 = (LivingEntity)entityiterator;
                              if (_livEnt85.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break label474;
                              }
                           }

                           if (entityiterator.getPersistentData().m_128459_("select") == (double)0.0F && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), (int)(domainRadius * (double)2.0F + (double)20.0F), (int)(entity.getPersistentData().m_128459_("select") + (double)10.0F), false, false));
                              }
                           }
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt89 = (LivingEntity)entity;
                        if (_livEnt89.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                           continue;
                        }
                     }

                     label389: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt90 = (LivingEntity)entityiterator;
                           if (_livEnt90.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              break label389;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") == (double)0.0F) {
                           continue;
                        }
                     }

                     x_dis = entity.m_20185_() - entityiterator.getPersistentData().m_128459_("x_pos_doma");
                     y_dis = entity.m_20186_() - entityiterator.getPersistentData().m_128459_("y_pos_doma");
                     z_dis = entity.m_20189_() - entityiterator.getPersistentData().m_128459_("z_pos_doma");
                     dis = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (dis < (domainRadius - (double)1.0F) * (domainRadius - (double)1.0F)) {
                        if (entity != entityiterator) {
                           label370: {
                              label369: {
                                 label476: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt99 = (LivingEntity)entityiterator;
                                       if (_livEnt99.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          label363: {
                                             if (entityiterator instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   var130 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                                   break label363;
                                                }
                                             }

                                             var130 = 0;
                                          }

                                          if (var130 <= 0) {
                                             break label369;
                                          }
                                          break label476;
                                       }
                                    }

                                    if (entityiterator.getPersistentData().m_128459_("select") == (double)0.0F || !(entityiterator.getPersistentData().m_128459_("cnt2") > (double)0.0F)) {
                                       break label369;
                                    }
                                 }

                                 if (!update_pos) {
                                    entityiterator.getPersistentData().m_128347_("x_pos_doma", entity.getPersistentData().m_128459_("x_pos_doma"));
                                    entityiterator.getPersistentData().m_128347_("y_pos_doma", entity.getPersistentData().m_128459_("y_pos_doma"));
                                    entityiterator.getPersistentData().m_128347_("z_pos_doma", entity.getPersistentData().m_128459_("z_pos_doma"));
                                    update_pos = true;
                                    break label370;
                                 }
                              }

                              entity.getPersistentData().m_128347_("x_pos_doma", entityiterator.getPersistentData().m_128459_("x_pos_doma"));
                              entity.getPersistentData().m_128347_("y_pos_doma", entityiterator.getPersistentData().m_128459_("y_pos_doma"));
                              entity.getPersistentData().m_128347_("z_pos_doma", entityiterator.getPersistentData().m_128459_("z_pos_doma"));
                              update_pos = true;
                           }
                        }

                        if (entity != entityiterator) {
                           entity.getPersistentData().m_128379_("Failed", true);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt117 = (LivingEntity)entityiterator;
                              if (_livEnt117.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label347: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var131 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label347;
                                       }
                                    }

                                    var131 = 0;
                                 }

                                 if (var131 == 0) {
                                    entity.getPersistentData().m_128347_("cnt5", (double)1.0F);
                                 }
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt120 = (LivingEntity)entityiterator;
                              if (_livEnt120.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entityiterator.getPersistentData().m_128471_("Cover")) {
                                 entityiterator.getPersistentData().m_128379_("Failed", true);
                              }
                           }
                        }
                     } else if (dis < domainRadius * (double)2.0F * domainRadius * (double)2.0F && !reStart && entity != entityiterator) {
                        label477: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt124 = (LivingEntity)entityiterator;
                              if (_livEnt124.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label376: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var129 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label376;
                                       }
                                    }

                                    var129 = 0;
                                 }

                                 if (var129 != 0) {
                                    continue;
                                 }
                                 break label477;
                              }
                           }

                           if (entityiterator.getPersistentData().m_128459_("select") == (double)0.0F || !(entityiterator.getPersistentData().m_128459_("cnt2") <= (double)0.0F)) {
                              continue;
                           }
                        }

                        reStart = true;
                        x_pos = entityiterator.getPersistentData().m_128459_("x_pos_doma");
                        y_pos = entityiterator.getPersistentData().m_128459_("y_pos_doma");
                        z_pos = entityiterator.getPersistentData().m_128459_("z_pos_doma");
                     }
                  }

                  if (!reStart || entity.getPersistentData().m_128471_("Failed") || update_pos) {
                     break;
                  }

                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }

                  entity.getPersistentData().m_128347_("x_pos_doma", x_pos);
                  entity.getPersistentData().m_128347_("y_pos_doma", y_pos);
                  entity.getPersistentData().m_128347_("z_pos_doma", z_pos);
                  update_pos = true;
               }

               Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)10.0F), (e) -> true)) {
                  if (entity != entityiterator && !entityiterator.m_20147_()) {
                     x_dis = entityiterator.m_20185_() - entity.m_20185_();
                     y_dis = entityiterator.m_20186_() - entity.m_20186_();
                     z_dis = entityiterator.m_20189_() - entity.m_20189_();
                     dis = x_dis * x_dis + z_dis * z_dis;
                     if (dis > (double)0.0F && dis < (double)100.0F) {
                        x_dis /= dis;
                        double var132 = y_dis / dis;
                        z_dis /= dis;
                        x_pos = entityiterator.m_20185_();
                        y_pos = entityiterator.m_20186_();
                        z_pos = entityiterator.m_20189_();
                        loop_num = Math.ceil((double)10.0F - dis);

                        for(int index2 = 0; index2 < (int)Math.round(loop_num); ++index2) {
                           dis = (x_pos - entity.getPersistentData().m_128459_("x_pos_doma")) * (x_pos - entity.getPersistentData().m_128459_("x_pos_doma")) + (y_pos - entity.getPersistentData().m_128459_("y_pos_doma")) * (y_pos - entity.getPersistentData().m_128459_("y_pos_doma")) + (z_pos - entity.getPersistentData().m_128459_("z_pos_doma")) * (z_pos - entity.getPersistentData().m_128459_("z_pos_doma"));
                           if (dis > (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - (double)3.0F) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - (double)3.0F)) {
                              break;
                           }

                           x_pos += x_dis;
                           z_pos += z_dis;
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              ++y_pos;
                           }
                        }

                        entityiterator.m_6021_(x_pos, y_pos, z_pos);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityiterator.m_146908_(), entityiterator.m_146909_());
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt160 = (LivingEntity)entity;
               if (_livEnt160.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                  if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());
                     distance = (double)0.5F * (double)entity.m_20205_();
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)((double)2.0F + distance), 0.1 * distance, 0.1 * distance, 0.1 * distance, 0.1);
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, (float)((double)0.5F * ((double)1.0F + distance)), 1.1F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, (float)((double)0.5F * ((double)1.0F + distance)), 1.1F, false);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 2, false, false));
                           }
                        }

                        entity.getPersistentData().m_128347_("select", (double)0.0F);
                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                        return;
                     }
                  }

                  return;
               }
            }

            if (entity.getPersistentData().m_128471_("Failed") && entity.getPersistentData().m_128459_("cnt5") > (double)0.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") > (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") < (double)34.0F ? (double)34.0F : Math.max((double)50.0F, domainRadius * (double)2.0F) + (double)5.0F);
               }
            } else {
               old_failed = entity.getPersistentData().m_128471_("Failed");
               entity.getPersistentData().m_128379_("Failed", false);
               x_pos = entity.getPersistentData().m_128459_("x_pos_doma");
               y_pos = entity.getPersistentData().m_128459_("y_pos_doma");
               z_pos = entity.getPersistentData().m_128459_("z_pos_doma");
               entity.getPersistentData().m_128347_("cnt_cover", entity.getPersistentData().m_128459_("cnt1"));
               DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128379_("Failed", old_failed);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= Math.max((double)34.0F, domainRadius * (double)2.0F + (double)1.0F)) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + (double)200.0F;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               entity.getPersistentData().m_128379_("StartDomainAttack", true);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), entity.getPersistentData().m_128459_("select") == (double)29.0F ? 3600 : 1200, (int)entity.getPersistentData().m_128459_("cnt2"), true, false));
                  }
               }

               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
