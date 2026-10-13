package net.mcreator.jujutsucraft.procedures;

import java.util.Iterator;
import java.util.List;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.HigurumaHiromiEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DomainExpansionOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean failed = false;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean noClosing = false;
         boolean update1 = false;
         boolean old_failed = false;
         boolean use_old = false;
         double range = (double)0.0F;
         double level = (double)0.0F;
         double tick = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double tick_1 = (double)0.0F;
         double tick_2 = (double)0.0F;
         double distance = (double)0.0F;
         double old_skill = (double)0.0F;
         double domainPower1 = (double)0.0F;
         double domainPower2 = (double)0.0F;
         double str_lv = (double)0.0F;
         double x_dis = (double)0.0F;
         double y_dis = (double)0.0F;
         double z_dis = (double)0.0F;
         if (entity.m_6084_()) {
            double var10000;
            label591: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                     break label591;
                  }
               }

               var10000 = (double)0.0F;
            }

            label586: {
               tick_1 = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var136 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label586;
                  }
               }

               var136 = 0;
            }

            label581: {
               str_lv = (double)(var136 + 10);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var137 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                     break label581;
                  }
               }

               var137 = 0;
            }

            if (var137 > 0) {
               str_lv *= 1.15;
            }

            if (entity.getPersistentData().m_128459_("select") != (double)27.0F && entity.getPersistentData().m_128459_("skill_domain") != (double)27.0F) {
               if (entity.getPersistentData().m_128459_("select") == (double)29.0F || entity.getPersistentData().m_128459_("skill_domain") == (double)29.0F) {
                  str_lv *= (double)2.0F;
               }
            } else {
               str_lv *= (double)1.5F;
            }

            if (entity.getPersistentData().m_128459_("skill_domain") == (double)0.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               entity.getPersistentData().m_128347_("skill_domain", entity.getPersistentData().m_128459_("select"));
               entity.getPersistentData().m_128347_("select", (double)0.0F);
               update1 = true;
            }

            if (entity.getPersistentData().m_128459_("skill_domain") > (double)0.0F) {
               if (!update1) {
                  DomainActiveProcedure.execute(world, x, y, z, entity);
               }

               int var10001;
               label564: {
                  var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                        break label564;
                     }
                  }

                  var10001 = 0;
               }

               range = var10000 * (double)(var10001 > 0 ? 18 : 2);
            }

            old_skill = entity.getPersistentData().m_128459_("skill");
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            if (tick_1 % (double)10.0F == (double)0.0F || update1) {
               logic_a = false;
               Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                  x_dis = entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                  y_dis = entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                  z_dis = entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                  distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                  if (distance < range * (double)0.5F * range * (double)0.5F) {
                     if (entity == entityiterator) {
                        logic_a = true;
                     } else {
                        label550: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt28 = (LivingEntity)entityiterator;
                              if (_livEnt28.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 label545: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                          var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                                          break label545;
                                       }
                                    }

                                    var10000 = (double)0.0F;
                                 }

                                 label540: {
                                    level = var10000;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                          var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                                          break label540;
                                       }
                                    }

                                    var10000 = (double)0.0F;
                                 }

                                 tick = var10000;
                                 tick -= (double)Math.round(Math.sqrt(str_lv + (double)1.0F) * (double)10.0F);
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                                 }

                                 if (level >= (double)0.0F && entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)tick, (int)level, true, true));
                                    }
                                 }
                                 break label550;
                              }
                           }

                           if (tick_1 % (double)20.0F == (double)0.0F) {
                              EffectCharactorProcedure.execute(world, entity, entityiterator);
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt33 = (LivingEntity)entityiterator;
                           if (_livEnt33.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              continue;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") == (double)0.0F && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 20, (int)(entity.getPersistentData().m_128459_("skill_domain") + (double)10.0F), false, false));
                           }
                        }
                     }
                  }
               }

               if (!logic_a && entity.getPersistentData().m_128459_("skill_domain") > (double)0.0F) {
                  label528: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           var141 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                           break label528;
                        }
                     }

                     var141 = 0;
                  }

                  if (var141 == 0 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }
               }
            }

            var10000 = entity.getPersistentData().m_128459_("oldHealth");
            float var157;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var157 = _livEnt.m_21223_();
            } else {
               var157 = -1.0F;
            }

            if (var10000 != (double)var157) {
               var10000 = entity.getPersistentData().m_128459_("oldHealth");
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var157 = _livEnt.m_21223_();
               } else {
                  var157 = -1.0F;
               }

               if (var10000 > (double)var157) {
                  CompoundTag var144 = entity.getPersistentData();
                  double var10002 = entity.getPersistentData().m_128459_("totalDamage") + entity.getPersistentData().m_128459_("oldHealth");
                  float var10003;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.m_21223_();
                  } else {
                     var10003 = -1.0F;
                  }

                  var144.m_128347_("totalDamage", var10002 - (double)var10003);
               } else {
                  CompoundTag var145 = entity.getPersistentData();
                  double var165 = entity.getPersistentData().m_128459_("totalDamage");
                  double var169 = entity.getPersistentData().m_128459_("oldHealth");
                  float var10004;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10004 = _livEnt.m_21223_();
                  } else {
                     var10004 = -1.0F;
                  }

                  var145.m_128347_("totalDamage", var165 + (var169 - (double)var10004) * (double)0.5F);
               }
            }

            CompoundTag var146 = entity.getPersistentData();
            double var166;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var166 = (double)_livEnt.m_21223_();
            } else {
               var166 = (double)-1.0F;
            }

            var146.m_128347_("oldHealth", var166);
            if ((tick_1 % (double)20.0F == (double)0.0F || update1) && entity.getPersistentData().m_128459_("select") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var157 = _livEnt.m_21233_();
               } else {
                  var157 = -1.0F;
               }

               double var160 = Math.max((double)Math.max(var157, 1.0F) - Math.max(entity.getPersistentData().m_128459_("totalDamage"), (double)0.0F) * (double)2.0F, (double)0.0F);
               float var167;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var167 = _livEnt.m_21233_();
               } else {
                  var167 = -1.0F;
               }

               domainPower1 = str_lv * (var160 / (double)Math.max(var167, 1.0F)) * Math.min(Math.min(tick_1, (double)1200.0F) / (double)2400.0F + (double)0.5F, (double)1.0F);
               failed = false;
               logic_a = false;
               logic_b = false;

               for(int index0 = 0; index0 < 2; ++index0) {
                  Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));
                  List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true);
                  Iterator var118 = _entfound.iterator();

                  label502:
                  while(true) {
                     Entity entityiterator;
                     while(true) {
                        if (!var118.hasNext()) {
                           break label502;
                        }

                        label384: {
                           entityiterator = (Entity)var118.next();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var147 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                 break label384;
                              }
                           }

                           var147 = 0;
                        }

                        label394: {
                           if (var147 > 0) {
                              label391: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var148 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                       break label391;
                                    }
                                 }

                                 var148 = 0;
                              }

                              if (var148 == 0) {
                                 var149 = true;
                                 break label394;
                              }
                           }

                           var149 = false;
                        }

                        noClosing = var149;
                        if (entity != entityiterator) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt65 = (LivingEntity)entityiterator;
                              if (_livEnt65.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break;
                              }
                           }

                           if (entityiterator.getPersistentData().m_128459_("select") != (double)0.0F) {
                              break;
                           }
                        }
                     }

                     x_dis = entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                     y_dis = entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                     z_dis = entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                     distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (distance < range * (double)0.5F * range * (double)0.5F) {
                        label414: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var150 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label414;
                              }
                           }

                           var150 = 0;
                        }

                        label419: {
                           domainPower2 = (double)(var150 + 10);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var151 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                 break label419;
                              }
                           }

                           var151 = 0;
                        }

                        if (var151 > 0) {
                           domainPower2 *= 1.15;
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") != (double)27.0F && entityiterator.getPersistentData().m_128459_("skill_domain") != (double)27.0F) {
                           if (entityiterator.getPersistentData().m_128459_("select") == (double)29.0F || entityiterator.getPersistentData().m_128459_("skill_domain") == (double)29.0F) {
                              domainPower2 *= (double)2.0F;
                           }
                        } else {
                           domainPower2 *= (double)1.5F;
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") != (double)0.0F) {
                           tick_2 = (double)1200.0F;
                        } else {
                           label436: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var152 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                    break label436;
                                 }
                              }

                              var152 = (double)0.0F;
                           }

                           tick_2 = var152;
                           float var161;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var161 = _livEnt.m_21233_();
                           } else {
                              var161 = -1.0F;
                           }

                           double var162 = Math.max((double)Math.max(var161, 1.0F) - Math.max(entityiterator.getPersistentData().m_128459_("totalDamage"), (double)0.0F) * (double)2.0F, (double)0.0F);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var167 = _livEnt.m_21233_();
                           } else {
                              var167 = -1.0F;
                           }

                           domainPower2 = domainPower2 * (var162 / (double)Math.max(var167, 1.0F)) * Math.min(Math.min(tick_2, (double)1200.0F) / (double)2400.0F + (double)0.5F, (double)1.0F);
                        }

                        label490: {
                           if (!(domainPower1 - domainPower2 >= (double)10.0F)) {
                              if (!logic_a) {
                                 break label490;
                              }

                              label486: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var153 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                       break label486;
                                    }
                                 }

                                 var153 = 0;
                              }

                              if (var153 > 0) {
                                 break label490;
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt86 = (LivingEntity)entityiterator;
                              if (_livEnt86.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label499: {
                                    failed = false;
                                    logic_b = true;
                                    entityiterator.getPersistentData().m_128379_("Failed", false);
                                    entityiterator.getPersistentData().m_128379_("DomainDefeated", !noClosing);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt89 = (LivingEntity)entityiterator;
                                       if (_livEnt89.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label499;
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 5, 0, false, false));
                                       }
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                 }
                                 continue;
                              }
                           }
                        }

                        if (noClosing) {
                           label477: {
                              if (tick_1 <= tick_2) {
                                 if (!(tick_2 < (double)1000.0F)) {
                                    break label477;
                                 }
                              } else if (!(tick_1 < (double)1000.0F)) {
                                 break label477;
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt92 = (LivingEntity)entityiterator;
                                 if (_livEnt92.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    label469: {
                                       label611: {
                                          logic_a = true;
                                          if (entityiterator instanceof Player) {
                                             if (entityiterator instanceof ServerPlayer) {
                                                ServerPlayer _plr94 = (ServerPlayer)entityiterator;
                                                if (_plr94.m_9236_() instanceof ServerLevel && _plr94.m_8960_().m_135996_(_plr94.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:anti_open_barrier_type_domain"))).m_8193_()) {
                                                   break label611;
                                                }
                                             }
                                          } else if (entityiterator.getPersistentData().m_128459_("cnt_learn_domain") > (double)0.0F) {
                                             break label611;
                                          }

                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livEnt96 = (LivingEntity)entityiterator;
                                             if (_livEnt96.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                break label611;
                                             }
                                          }

                                          if (!(entityiterator instanceof GojoSatoruEntity) && !(entityiterator instanceof HigurumaHiromiEntity) && !(entityiterator instanceof OkkotsuYutaEntity) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity) && !(entityiterator instanceof KenjakuEntity)) {
                                             if (!(entityiterator instanceof Player) || !(entityiterator instanceof ServerPlayer)) {
                                                break label469;
                                             }

                                             ServerPlayer _player = (ServerPlayer)entityiterator;
                                             Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:anti_open_barrier_type_domain"));
                                             AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                             if (_ap.m_8193_()) {
                                                break label469;
                                             }

                                             Iterator var61 = _ap.m_8219_().iterator();

                                             while(true) {
                                                if (!var61.hasNext()) {
                                                   break label469;
                                                }

                                                String criteria = (String)var61.next();
                                                _player.m_8960_().m_135988_(_adv, criteria);
                                             }
                                          }

                                          entityiterator.getPersistentData().m_128347_("cnt_learn_domain", (double)1.0F);
                                          break label469;
                                       }

                                       logic_a = false;
                                    }

                                    if (logic_a) {
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        if (!logic_b) {
                           if (distance < JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
                              entity.getPersistentData().m_128379_("Failed", true);
                           } else {
                              use_old = true;
                              old_failed = entity.getPersistentData().m_128471_("Failed");
                              entity.getPersistentData().m_128379_("Failed", true);
                           }

                           failed = true;
                        }
                     }
                  }

                  if (!logic_a) {
                     break;
                  }
               }
            } else {
               failed = true;
            }

            entity.getPersistentData().m_128347_("skill", old_skill);
            if (!entity.getPersistentData().m_128471_("Failed") && !entity.getPersistentData().m_128471_("Cover")) {
               label344: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        var155 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19557_();
                        break label344;
                     }
                  }

                  var155 = 0;
               }

               if (var155 < 10 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 10, 0, false, false));
                  }
               }
            } else {
               if (!failed && !entity.getPersistentData().m_128471_("Cover")) {
                  label628: {
                     x_dis = entity.getPersistentData().m_128459_("x_pos_doma") - entity.m_20185_();
                     y_dis = entity.getPersistentData().m_128459_("y_pos_doma") - (entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F);
                     z_dis = entity.getPersistentData().m_128459_("z_pos_doma") - entity.m_20189_();
                     distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (!(distance < JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius)) {
                        label364: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var154 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                 break label364;
                              }
                           }

                           var154 = 0;
                        }

                        if (var154 == 0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                           }
                           break label628;
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_cover", (double)1.0F);
                     old_failed = false;
                     entity.getPersistentData().m_128379_("Failed", false);
                     entity.getPersistentData().m_128379_("Cover", true);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffect var170;
                           int var171;
                           int var10005;
                           label355: {
                              var163 = new MobEffectInstance;
                              var170 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                              var171 = (int)(tick_1 + (double)100.0F);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                    break label355;
                                 }
                              }

                              var10005 = 0;
                           }

                           var163.<init>(var170, var171, var10005, true, false);
                           _entity.m_7292_(var163);
                        }
                     }

                     entity.getPersistentData().m_128347_("x_pos_doma2", (double)Math.round(entity.m_20185_()));
                     entity.getPersistentData().m_128347_("y_pos_doma2", (double)Math.round(entity.m_20186_()));
                     entity.getPersistentData().m_128347_("z_pos_doma2", (double)Math.round(entity.m_20189_()));
                  }
               }

               if (entity.getPersistentData().m_128471_("Cover")) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos_doma");
                  y_pos = entity.getPersistentData().m_128459_("y_pos_doma");
                  z_pos = entity.getPersistentData().m_128459_("z_pos_doma");
               } else {
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
               }

               old_skill = entity.getPersistentData().m_128459_("cnt1");
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("cnt1", old_skill);
               if (use_old) {
                  entity.getPersistentData().m_128379_("Failed", old_failed);
               }

               if (entity.getPersistentData().m_128471_("Cover")) {
                  entity.getPersistentData().m_128347_("cnt_cover", entity.getPersistentData().m_128459_("cnt_cover") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_cover") > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F + (double)1.0F) {
                     entity.getPersistentData().m_128379_("Cover", false);
                  }
               }
            }

            if (!entity.getPersistentData().m_128471_("Cover")) {
               if (entity instanceof Player) {
                  if (tick_1 % (double)20.0F == (double)0.0F) {
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange -= (double)20.0F;
                        if (capability.PlayerCursePower + capability.PlayerCursePowerChange <= (double)0.0F && entity instanceof LivingEntity _entity) {
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                        }

                     });
                  }
               } else if (entity.getPersistentData().m_128459_("cnt_target") > (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt_domain_cancel", (double)0.0F);
               } else {
                  label335: {
                     entity.getPersistentData().m_128347_("cnt_domain_cancel", entity.getPersistentData().m_128459_("cnt_domain_cancel") + (double)1.0F);
                     var156 = entity.getPersistentData().m_128459_("cnt_domain_cancel");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt158 = (LivingEntity)entity;
                        if (_livEnt158.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           var164 = 600;
                           break label335;
                        }
                     }

                     var164 = 100;
                  }

                  if (var156 > (double)var164 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
         }

      }
   }
}
