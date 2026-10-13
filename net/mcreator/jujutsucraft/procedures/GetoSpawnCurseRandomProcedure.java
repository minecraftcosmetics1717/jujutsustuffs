package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade13Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade23Entity;
import net.mcreator.jujutsucraft.entity.GetoSuguruEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GetoSpawnCurseRandomProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean haveGrade0 = false;
         boolean haveGrade1 = false;
         boolean target = false;
         boolean strong_enemy = false;
         boolean schoolDays = false;
         boolean Kenjaku = false;
         boolean player = false;
         double amount = (double)0.0F;
         double strength = (double)0.0F;
         double kind = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double spawnType = (double)0.0F;
         double grade = (double)0.0F;
         double loop_num = (double)0.0F;
         double num1 = (double)0.0F;
         double level_strength = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double level_strength2 = (double)0.0F;
         double count_spirit = (double)0.0F;
         double speed = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         double var10000;
         label721: {
            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label721;
               }
            }

            var10000 = (double)0.0F;
         }

         strength = var10000;
         player = entity instanceof Player;
         schoolDays = entity instanceof GetoSuguruEntity;
         Kenjaku = entity instanceof KenjakuEntity;
         LivingEntity var123;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var123 = _mobEnt.m_5448_();
         } else {
            var123 = null;
         }

         target = var123 instanceof LivingEntity;
         if (target) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var123 = _mobEnt.m_5448_();
            } else {
               var123 = null;
            }

            label712: {
               LivingEntity var49 = var123;
               if (var49 instanceof LivingEntity) {
                  LivingEntity _livEnt = var49;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var125 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label712;
                  }
               }

               var125 = 0;
            }

            strong_enemy = (double)var125 >= strength * (double)0.5F || entity.getPersistentData().m_128459_("cnt_target") > (double)400.0F;
         }

         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            if (entity.getPersistentData().m_128459_("skill") == (double)1815.0F) {
               if (entity.getPersistentData().m_128459_("grade03") >= (double)0.0F) {
                  entity.getPersistentData().m_128347_("grade03", (double)-1.0F);
                  grade = (double)0.0F;
                  kind = (double)3.0F;
                  amount = (double)1.0F;
                  spawnType = (double)1.0F;
                  loop_num = (double)0.0F;
               }
            } else {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)64.0F), (e) -> true)) {
                  if (entity != entityiterator && !(entityiterator instanceof RikaEntity) && !(entityiterator instanceof Rika2Entity) && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                     int var10001;
                     label689: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label689;
                           }
                        }

                        var10001 = 0;
                     }

                     count_spirit += (double)var10001;
                  }
               }

               loop_num = (double)1.0F;
               haveGrade0 = false;
               haveGrade1 = false;
               num1 = (double)0.0F;
               int index0 = 0;

               label680: {
                  while(true) {
                     if (index0 >= 10) {
                        break label680;
                     }

                     ++num1;
                     if (!(num1 <= (double)9.0F)) {
                        break label680;
                     }

                     if (entity.getPersistentData().m_128459_("grade1" + Math.round(num1)) >= (double)0.0F) {
                        if (schoolDays) {
                           if (num1 != (double)6.0F) {
                              break;
                           }
                        } else if (num1 != (double)3.0F && num1 != (double)9.0F && (!Kenjaku || num1 != (double)1.0F)) {
                           break;
                        }
                     }

                     ++index0;
                  }

                  haveGrade1 = true;
               }

               if (!schoolDays) {
                  label750: {
                     num1 = (double)2.0F;
                     index0 = 0;

                     while(true) {
                        if (index0 >= 10) {
                           break label750;
                        }

                        ++num1;
                        if (!(num1 <= (double)8.0F)) {
                           break label750;
                        }

                        if (entity.getPersistentData().m_128459_("grade0" + Math.round(num1)) >= (double)0.0F) {
                           if (Kenjaku) {
                              if (num1 != (double)3.0F && num1 != (double)8.0F) {
                                 break;
                              }
                           } else if (num1 != (double)4.0F && num1 != (double)5.0F && num1 != (double)6.0F && num1 != (double)7.0F) {
                              break;
                           }
                        }

                        ++index0;
                     }

                     haveGrade0 = true;
                  }
               }

               label758: {
                  if ((Math.random() < 0.2 || strong_enemy) && haveGrade1 && (entity.getPersistentData().m_128459_("num_grade1") == (double)0.0F || Math.random() > (double)0.5F + entity.getPersistentData().m_128459_("num_grade1") * 0.2)) {
                     LivingEntity var138;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var138 = _mobEnt.m_5448_();
                     } else {
                        var138 = null;
                     }

                     label629: {
                        LivingEntity _mobEnt = var138;
                        if (_mobEnt instanceof LivingEntity) {
                           LivingEntity _livEnt = _mobEnt;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var139 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label629;
                           }
                        }

                        var139 = 0;
                     }

                     if (count_spirit < (double)(var139 * 1)) {
                        grade = (double)1.0F;
                        break label758;
                     }
                  }

                  if ((Math.random() < 0.1 || strong_enemy) && haveGrade0 && (entity.getPersistentData().m_128459_("num_grade0") == (double)0.0F || Math.random() > (double)0.5F + entity.getPersistentData().m_128459_("num_grade0") * 0.2)) {
                     LivingEntity var140;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var140 = _mobEnt.m_5448_();
                     } else {
                        var140 = null;
                     }

                     label613: {
                        LivingEntity _mobEnt = var140;
                        if (_mobEnt instanceof LivingEntity) {
                           LivingEntity _livEnt = _mobEnt;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var141 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label613;
                           }
                        }

                        var141 = 0;
                     }

                     if (count_spirit < (double)(var141 * 1)) {
                        grade = (double)0.0F;
                        break label758;
                     }
                  }

                  if (Math.random() < 0.3) {
                     grade = (double)2.0F;
                  } else {
                     grade = (double)3.0F;
                  }
               }

               if (grade != (double)3.0F) {
                  if (grade == (double)2.0F) {
                     for(int index3 = 0; index3 < 256; ++index3) {
                        kind = Math.ceil(Math.random() * (double)17.0F);
                        if (kind == (double)1.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)0.0F;
                           break;
                        }

                        if (kind != (double)2.0F) {
                           if (kind == (double)3.0F) {
                              amount = (double)1.0F;
                              spawnType = (double)0.0F;
                              break;
                           }

                           if (kind == (double)4.0F && Kenjaku) {
                              amount = (double)2.0F;
                              spawnType = (double)0.0F;
                              break;
                           }

                           if (kind == (double)5.0F) {
                              amount = (double)1.0F;
                              spawnType = (double)0.0F;
                              break;
                           }

                           if (kind == (double)6.0F) {
                              amount = (double)1.0F;
                              spawnType = (double)0.0F;
                              break;
                           }

                           if (kind != (double)7.0F) {
                              if (kind == (double)8.0F) {
                                 amount = (double)1.0F;
                                 spawnType = (double)0.0F;
                                 break;
                              }

                              if (kind == (double)9.0F) {
                                 amount = (double)1.0F;
                                 spawnType = (double)0.0F;
                                 break;
                              }

                              if (kind == (double)10.0F) {
                                 amount = (double)2.0F;
                                 spawnType = (double)0.0F;
                                 break;
                              }

                              if (kind == (double)11.0F) {
                                 amount = (double)1.0F;
                                 spawnType = (double)0.0F;
                                 break;
                              }

                              if (kind == (double)12.0F) {
                                 amount = (double)1.0F;
                                 spawnType = (double)0.0F;
                                 break;
                              }

                              if (kind == (double)13.0F) {
                                 amount = (double)1.0F;
                                 spawnType = (double)0.0F;
                                 break;
                              }

                              if (kind == (double)14.0F) {
                                 amount = (double)1.0F;
                                 spawnType = (double)0.0F;
                                 break;
                              }

                              if (kind != (double)15.0F) {
                                 if (kind == (double)16.0F) {
                                    amount = (double)1.0F;
                                    spawnType = (double)0.0F;
                                    break;
                                 }

                                 if (kind == (double)17.0F) {
                                    amount = (double)1.0F;
                                    spawnType = (double)0.0F;
                                    break;
                                 }
                              }
                           }
                        }
                     }
                  } else if (grade == (double)1.0F) {
                     for(int index4 = 0; index4 < 256; ++index4) {
                        kind = (double)Math.round(Math.ceil(Math.random() * (double)9.0F));
                        if (kind == (double)1.0F && entity.getPersistentData().m_128459_("grade11") >= (double)0.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)0.0F;
                           entity.getPersistentData().m_128347_("grade11", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)2.0F && entity.getPersistentData().m_128459_("grade12") >= (double)0.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade12", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)3.0F && entity.getPersistentData().m_128459_("grade13") >= (double)0.0F && schoolDays) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade13", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)4.0F && entity.getPersistentData().m_128459_("grade14") >= (double)0.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade14", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)5.0F && entity.getPersistentData().m_128459_("grade15") >= (double)0.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade15", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)6.0F && entity.getPersistentData().m_128459_("grade16") >= (double)0.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade16", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)7.0F && entity.getPersistentData().m_128459_("grade17") >= (double)0.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade17", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)8.0F && entity.getPersistentData().m_128459_("grade18") >= (double)0.0F) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade18", (double)-1.0F);
                           break;
                        }

                        if (kind == (double)9.0F && entity.getPersistentData().m_128459_("grade19") >= (double)0.0F && schoolDays) {
                           amount = (double)1.0F;
                           spawnType = (double)1.0F;
                           entity.getPersistentData().m_128347_("grade19", (double)-1.0F);
                           break;
                        }
                     }
                  } else if (grade == (double)0.0F) {
                     for(int index5 = 0; index5 < 256; ++index5) {
                        kind = (double)Math.round(Math.ceil(Math.random() * (double)9.0F));
                        if (kind != (double)1.0F && kind != (double)2.0F && kind != (double)9.0F) {
                           if (kind == (double)3.0F && entity.getPersistentData().m_128459_("grade03") >= (double)0.0F && !Kenjaku) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var123 = _mobEnt.m_5448_();
                              } else {
                                 var123 = null;
                              }

                              if (!(var123 instanceof OkkotsuYutaEntity)) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var123 = _mobEnt.m_5448_();
                                 } else {
                                    var123 = null;
                                 }

                                 if (!(var123 instanceof OkkotsuYutaCullingGameEntity)) {
                                    amount = (double)1.0F;
                                    spawnType = (double)1.0F;
                                    entity.getPersistentData().m_128347_("grade03", (double)-1.0F);
                                    break;
                                 }
                              }
                           }

                           if (kind == (double)4.0F && entity.getPersistentData().m_128459_("grade04") >= (double)0.0F && Kenjaku) {
                              amount = (double)1.0F;
                              spawnType = (double)1.0F;
                              entity.getPersistentData().m_128347_("grade04", (double)-1.0F);
                              break;
                           }

                           if (kind == (double)5.0F && entity.getPersistentData().m_128459_("grade05") >= (double)0.0F && Kenjaku) {
                              amount = (double)1.0F;
                              spawnType = (double)1.0F;
                              entity.getPersistentData().m_128347_("grade05", (double)-1.0F);
                              break;
                           }

                           if (kind == (double)6.0F && entity.getPersistentData().m_128459_("grade06") >= (double)0.0F && Kenjaku) {
                              amount = (double)1.0F;
                              spawnType = (double)1.0F;
                              entity.getPersistentData().m_128347_("grade06", (double)-1.0F);
                              break;
                           }

                           if (kind == (double)7.0F && entity.getPersistentData().m_128459_("grade07") >= (double)0.0F && Kenjaku) {
                              amount = (double)1.0F;
                              spawnType = (double)1.0F;
                              entity.getPersistentData().m_128347_("grade07", (double)-1.0F);
                              break;
                           }

                           if (kind == (double)8.0F && entity.getPersistentData().m_128459_("grade08") >= (double)0.0F && !Kenjaku) {
                              amount = (double)1.0F;
                              spawnType = (double)1.0F;
                              entity.getPersistentData().m_128347_("grade08", (double)-1.0F);
                              break;
                           }
                        }
                     }
                  }
               } else {
                  index0 = 0;

                  while(index0 < 256) {
                     kind = Math.ceil(Math.random() * (double)22.0F);
                     if (kind == (double)4.0F) {
                        amount = (double)6.0F;
                        spawnType = (double)2.0F;
                        break;
                     }

                     if (kind != (double)6.0F && kind != (double)14.0F && kind != (double)15.0F && kind != (double)17.0F) {
                        if (kind != (double)8.0F && kind != (double)10.0F && kind != (double)13.0F && kind != (double)22.0F) {
                           if (kind != (double)11.0F && kind != (double)12.0F) {
                              if (kind != (double)9.0F && kind != (double)13.0F && kind != (double)18.0F) {
                                 ++index0;
                                 continue;
                              }

                              amount = (double)8.0F;
                              spawnType = (double)0.0F;
                              break;
                           }

                           amount = (double)1.0F;
                           spawnType = (double)0.0F;
                           break;
                        }

                        amount = (double)2.0F;
                        spawnType = (double)0.0F;
                        break;
                     }

                     amount = (double)2.0F;
                     spawnType = (double)0.0F;
                     loop_num = (double)8.0F;
                     break;
                  }
               }

               entity.getPersistentData().m_128347_("cnt3", grade);
               entity.getPersistentData().m_128347_("cnt4", kind);
               entity.getPersistentData().m_128347_("cnt5", amount);
               entity.getPersistentData().m_128347_("cnt7", spawnType);
               entity.getPersistentData().m_128347_("cnt8", loop_num);
            }
         } else {
            grade = entity.getPersistentData().m_128459_("cnt3");
            kind = entity.getPersistentData().m_128459_("cnt4");
            amount = entity.getPersistentData().m_128459_("cnt5");
            spawnType = entity.getPersistentData().m_128459_("cnt7");
            loop_num = entity.getPersistentData().m_128459_("cnt8");
         }

         speed = (double)6.5F;

         for(int index6 = 0; index6 < (int)Math.round(amount); ++index6) {
            if (spawnType == (double)1.0F) {
               entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)90.0F));
               entity.m_146926_((float)Math.min(pitch, (double)0.0F));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-4.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-4.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            } else if (spawnType == (double)2.0F) {
               if (target) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var123 = _mobEnt.m_5448_();
                  } else {
                     var123 = null;
                  }

                  Level var129 = ((Entity)var123).m_9236_();
                  ClipContext var142 = new ClipContext;
                  LivingEntity var10003;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10003 = _mobEnt.m_5448_();
                  } else {
                     var10003 = null;
                  }

                  Vec3 var147 = ((Entity)var10003).m_20299_(1.0F);
                  LivingEntity var10004;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10004 = _mobEnt.m_5448_();
                  } else {
                     var10004 = null;
                  }

                  Vec3 var152 = ((Entity)var10004).m_20299_(1.0F);
                  LivingEntity var10005;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10005 = _mobEnt.m_5448_();
                  } else {
                     var10005 = null;
                  }

                  var152 = var152.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)0.0F));
                  ClipContext.Block var160 = Block.OUTLINE;
                  ClipContext.Fluid var10006 = Fluid.NONE;
                  LivingEntity var10007;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var142.<init>(var147, var152, var160, var10006, var10007);
                  x_pos = (double)var129.m_45547_(var142).m_82425_().m_123341_() + (Math.random() - (double)0.5F) * (double)12.0F;
                  LivingEntity var130;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var130 = _mobEnt.m_5448_();
                  } else {
                     var130 = null;
                  }

                  Level var131 = ((Entity)var130).m_9236_();
                  var142 = new ClipContext;
                  LivingEntity var148;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var148 = _mobEnt.m_5448_();
                  } else {
                     var148 = null;
                  }

                  Vec3 var149 = ((Entity)var148).m_20299_(1.0F);
                  LivingEntity var154;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var154 = _mobEnt.m_5448_();
                  } else {
                     var154 = null;
                  }

                  Vec3 var155 = ((Entity)var154).m_20299_(1.0F);
                  LivingEntity var161;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var161 = _mobEnt.m_5448_();
                  } else {
                     var161 = null;
                  }

                  var155 = var155.m_82549_(((Entity)var161).m_20252_(1.0F).m_82490_((double)0.0F));
                  ClipContext.Block var162 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var142.<init>(var149, var155, var162, var10006, var10007);
                  y_pos = (double)var131.m_45547_(var142).m_82425_().m_123342_();
                  LivingEntity var132;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var132 = _mobEnt.m_5448_();
                  } else {
                     var132 = null;
                  }

                  Level var133 = ((Entity)var132).m_9236_();
                  var142 = new ClipContext;
                  LivingEntity var150;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var150 = _mobEnt.m_5448_();
                  } else {
                     var150 = null;
                  }

                  Vec3 var151 = ((Entity)var150).m_20299_(1.0F);
                  LivingEntity var157;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var157 = _mobEnt.m_5448_();
                  } else {
                     var157 = null;
                  }

                  Vec3 var158 = ((Entity)var157).m_20299_(1.0F);
                  LivingEntity var163;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var163 = _mobEnt.m_5448_();
                  } else {
                     var163 = null;
                  }

                  var158 = var158.m_82549_(((Entity)var163).m_20252_(1.0F).m_82490_((double)0.0F));
                  ClipContext.Block var164 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var142.<init>(var151, var158, var164, var10006, var10007);
                  z_pos = (double)var133.m_45547_(var142).m_82425_().m_123343_() + (Math.random() - (double)0.5F) * (double)12.0F;
               } else {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + (Math.random() - (double)0.5F) * (double)12.0F;
                  y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + (Math.random() - (double)0.5F) * (double)12.0F;
               }
            } else {
               entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)180.0F));
               entity.m_146926_((float)Math.min(pitch, (double)0.0F));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)4.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)4.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            }

            y_pos += Math.random() * 0.1;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var134 = _level.m_7654_().m_129892_();
               CommandSourceStack var145 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
               long var10002 = Math.round(grade);
               var134.m_230957_(var145, "summon jujutsucraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
            }

            if (entity.m_6084_()) {
               label463: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt103 = (LivingEntity)entity;
                     if (_livEnt103.m_21023_(MobEffects.f_19600_)) {
                        label458: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var136 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label458;
                              }
                           }

                           var136 = 0;
                        }

                        ++var136;
                        break label463;
                     }
                  }

                  var136 = 0;
               }

               level_strength = (double)var136;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
                  if (entityiterator.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                     entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityiterator.m_146922_((float)yaw);
                     entityiterator.m_146926_((float)pitch);
                     entityiterator.m_5618_(entityiterator.m_146908_());
                     entityiterator.m_5616_(entityiterator.m_146908_());
                     entityiterator.f_19859_ = entityiterator.m_146908_();
                     entityiterator.f_19860_ = entityiterator.m_146909_();
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 1, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity114 = (LivingEntity)entity;
                        if (_livingEntity114.m_21204_().m_22171_(Attributes.f_22281_)) {
                           if (grade == (double)0.0F) {
                              level_strength2 = (double)13.0F;
                           } else if (grade == (double)1.0F) {
                              level_strength2 = (double)10.0F;
                           } else if (grade == (double)2.0F) {
                              level_strength2 = (double)6.0F;
                           } else if (grade == (double)3.0F) {
                              level_strength2 = (double)2.0F;
                           } else {
                              level_strength2 = (double)0.0F;
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity116 = (LivingEntity)entityiterator;
                              if (_livingEntity116.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 double var146;
                                 label440: {
                                    var137 = _livingEntity116.m_21051_(Attributes.f_22281_);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livingEntity115 = (LivingEntity)entityiterator;
                                       if (_livingEntity115.m_21204_().m_22171_(Attributes.f_22281_)) {
                                          var146 = _livingEntity115.m_21051_(Attributes.f_22281_).m_22115_();
                                          break label440;
                                       }
                                    }

                                    var146 = (double)0.0F;
                                 }

                                 var137.m_22100_(Math.max(var146, level_strength * (double)3.0F * (double)0.5F * ((Math.max(level_strength * (double)3.0F, (double)1.0F) - Math.max(level_strength2 * (double)3.0F, (double)1.0F)) / Math.max(level_strength * (double)3.0F, (double)1.0F))));
                              }
                           }
                        }
                     }

                     entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityiterator.getPersistentData().m_128379_("Player", player);
                     if (!(entityiterator instanceof CursedSpiritGrade13Entity) && !(entityiterator instanceof CursedSpiritGrade23Entity)) {
                        break;
                     }

                     entityiterator.m_5997_(entityiterator.m_20154_().f_82479_ * speed, entityiterator.m_20154_().f_82480_ * speed, entityiterator.m_20154_().f_82481_ * speed);
                     entityiterator.m_20256_(new Vec3(entityiterator.m_20154_().f_82479_ * speed, entityiterator.m_20154_().f_82480_ * speed, entityiterator.m_20154_().f_82481_ * speed));
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     entityiterator.getPersistentData().m_128347_("skill", (double)1706.0F);
                     entityiterator.getPersistentData().m_128347_("cnt1", (double)6.0F);
                     entityiterator.getPersistentData().m_128347_("cnt6", (double)-2.5F);
                     entityiterator.getPersistentData().m_128347_("yaw", (double)entityiterator.m_146908_());
                     entityiterator.getPersistentData().m_128347_("pitch", (double)entityiterator.m_146909_());
                     entityiterator.getPersistentData().m_128347_("x_power", entityiterator.m_20154_().f_82479_ * speed * (double)0.5F);
                     entityiterator.getPersistentData().m_128347_("y_power", entityiterator.m_20154_().f_82480_ * speed * (double)0.5F);
                     entityiterator.getPersistentData().m_128347_("z_power", entityiterator.m_20154_().f_82481_ * speed * (double)0.5F);
                     break;
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.0F);
            }
         }

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

         if (entity.getPersistentData().m_128459_("cnt1") >= loop_num) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
