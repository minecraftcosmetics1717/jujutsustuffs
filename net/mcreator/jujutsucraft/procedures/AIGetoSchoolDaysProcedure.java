package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade03Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade04Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade05Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade06Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade07Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade08Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade11Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade12Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade13Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade14Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade15Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade16Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade18Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade19Entity;
import net.mcreator.jujutsucraft.entity.GetoSuguruCurseUserEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIGetoSchoolDaysProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean domain = false;
         boolean StrongEnemy = false;
         boolean uzumaki = false;
         double num_spirit = (double)0.0F;
         double distance = (double)0.0F;
         double count_spirit = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double lv_st = (double)0.0F;
         double lv_df = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof GetoSuguruCurseUserEntity && !entity.getPersistentData().m_128471_("flag_start")) {
               entity.getPersistentData().m_128379_("flag_start", true);
               entity.getPersistentData().m_128379_("HasWeapon1", true);
            }

            if (!(entity instanceof GetoSuguruCurseUserEntity) && !(entity instanceof KenjakuEntity)) {
               lv_st = (double)13.0F;
               lv_df = (double)3.0F;
            } else {
               lv_st = (double)20.0F;
               lv_df = (double)3.0F;
            }

            label404: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19600_)) {
                     break label404;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)lv_st, false, false));
                  }
               }
            }

            label399: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_(MobEffects.f_19606_)) {
                     break label399;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)lv_df, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            Entity var31 = var10000;
            if (var31 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
               if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  label388: {
                     if (var31 instanceof LivingEntity) {
                        LivingEntity _livEnt = var31;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var67 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label388;
                        }
                     }

                     var67 = 0;
                  }

                  int var10001;
                  label383: {
                     var68 = (double)var67;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label383;
                        }
                     }

                     var10001 = 0;
                  }

                  StrongEnemy = var68 >= (double)var10001 * (double)0.5F || entity.getPersistentData().m_128459_("cnt_target") > (double)600.0F;
                  if ((entity instanceof GetoSuguruCurseUserEntity || entity instanceof KenjakuEntity) && LogicStartProcedure.execute(entity)) {
                     label367: {
                        label366: {
                           if (!entity.getPersistentData().m_128471_("use_uzumaki")) {
                              if (entity instanceof GetoSuguruCurseUserEntity) {
                                 float var69;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var69 = _livEnt.m_21223_();
                                 } else {
                                    var69 = -1.0F;
                                 }

                                 double var70 = (double)var69;
                                 float var75;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var75 = _livEnt.m_21233_();
                                 } else {
                                    var75 = -1.0F;
                                 }

                                 if (var70 <= (double)var75 * 0.2) {
                                    break label366;
                                 }
                              }

                              if (((Entity)var31).getPersistentData().m_128459_("skill") == (double)515.0F) {
                                 break label366;
                              }
                           }

                           var71 = false;
                           break label367;
                        }

                        var71 = true;
                     }

                     uzumaki = var71;
                     if (uzumaki) {
                        entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), (double)20.0F));
                        entity.getPersistentData().m_128379_("uzumaki", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     if (entity instanceof KenjakuEntity) {
                        domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     }

                     ResetCounterProcedure.execute(entity);
                     count_spirit = (double)0.0F;
                     num_spirit = (double)0.0F;
                     if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                        entity.getPersistentData().m_128347_("num_grade3", (double)0.0F);
                        entity.getPersistentData().m_128347_("num_grade2", (double)0.0F);
                        entity.getPersistentData().m_128347_("num_grade1", (double)0.0F);
                        entity.getPersistentData().m_128347_("num_grade0", (double)0.0F);
                        Vec3 _center = new Vec3(x, y, z);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)64.0F), (e) -> true)) {
                           if (entity != entityiterator && !(entityiterator instanceof RikaEntity) && !(entityiterator instanceof Rika2Entity) && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                              label344: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var72 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label344;
                                    }
                                 }

                                 var72 = (double)0.0F;
                              }

                              lv_st = var72;
                              ++num_spirit;
                              count_spirit += lv_st;
                              if (lv_st >= (double)10.0F) {
                                 entity.getPersistentData().m_128347_("num_grade0", entity.getPersistentData().m_128459_("num_grade0") + (double)1.0F);
                              } else if (lv_st >= (double)6.0F) {
                                 entity.getPersistentData().m_128347_("num_grade1", entity.getPersistentData().m_128459_("num_grade1") + (double)1.0F);
                              } else if (lv_st >= (double)3.0F) {
                                 entity.getPersistentData().m_128347_("num_grade2", entity.getPersistentData().m_128459_("num_grade2") + (double)1.0F);
                              } else {
                                 entity.getPersistentData().m_128347_("num_grade3", entity.getPersistentData().m_128459_("num_grade3") + (double)1.0F);
                              }
                           }
                        }
                     }

                     distance = GetDistanceProcedure.execute(entity);
                     if (!(entity instanceof KenjakuEntity) || !domain && (AIDomainLogicProcedure.execute(world, x, y, z, entity) || !(Math.random() < 0.1))) {
                        label443: {
                           if (entity instanceof GetoSuguruCurseUserEntity) {
                              GetoSuguruCurseUserEntity _datEntL58 = (GetoSuguruCurseUserEntity)entity;
                              if ((Boolean)_datEntL58.m_20088_().m_135370_(GetoSuguruCurseUserEntity.DATA_rika) && LogicStartProcedure.execute(entity) && !LocateRikaProcedure.execute(world, entity) && StrongEnemy) {
                                 rnd = (double)-1290.0F;
                                 tick = (double)75.0F;
                                 break label443;
                              }
                           }

                           if (!entity.getPersistentData().m_128471_("use_uzumaki")) {
                              if ((uzumaki || entity instanceof KenjakuEntity && Math.random() < 0.1 && distance < (double)10.0F) && (LogicStartProcedure.execute(entity) || uzumaki)) {
                                 rnd = (double)15.0F;
                                 tick = (double)150.0F;
                                 if (entity instanceof GetoSuguruCurseUserEntity) {
                                    ItemStack var73;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var73 = _livEnt.m_21205_();
                                    } else {
                                       var73 = ItemStack.f_41583_;
                                    }

                                    if (var73.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                                       entity.getPersistentData().m_128379_("HasWeapon1", true);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                                          _setstack.m_41764_(1);
                                          _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                          if (_entity instanceof Player) {
                                             Player _player = (Player)_entity;
                                             _player.m_150109_().m_6596_();
                                          }
                                       }
                                    }
                                 }
                              } else if (distance > (double)6.0F && num_spirit < (double)8.0F && LogicStartPassiveProcedure.execute(entity) && Math.random() < (double)0.5F) {
                                 rnd = (double)11.0F;
                                 tick = (double)5.0F;
                              }
                           }

                           if (entity instanceof KenjakuEntity && LogicStartProcedure.execute(entity) && !uzumaki) {
                              distance = GetDistanceNearestEnemyProcedure.execute(world, entity);
                              if (distance < (double)10.0F && Math.random() < 0.1) {
                                 rnd = (double)2310.0F;
                                 tick = (double)150.0F;
                              }
                           }
                        }
                     } else {
                        rnd = (double)20.0F;
                        tick = (double)20.0F;
                     }

                     if (rnd != (double)0.0F) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round((double)1800.0F + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                        if (entity instanceof GetoSuguruCurseUserEntity) {
                           ItemStack var74;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var74 = _livEnt.m_21205_();
                           } else {
                              var74 = ItemStack.f_41583_;
                           }

                           if (var74.m_41720_() == ItemStack.f_41583_.m_41720_() && entity.getPersistentData().m_128471_("HasWeapon1")) {
                              entity.getPersistentData().m_128379_("HasWeapon1", false);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x2") % (double)200.0F == (double)190.0F && entity instanceof GetoSuguruCurseUserEntity) {
                  GetoSuguruCurseUserEntity _datEntL83 = (GetoSuguruCurseUserEntity)entity;
                  if ((Boolean)_datEntL83.m_20088_().m_135370_(GetoSuguruCurseUserEntity.DATA_rika) && LocateRikaProcedure.execute(world, entity)) {
                     entity.getPersistentData().m_128347_("cnt1", (double)20.0F);
                     TechniqueRika2Procedure.execute(world, x, y, z, entity);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt_x2") % (double)100.0F == (double)80.0F && entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)64.0F), (e) -> true)) {
                     if (entity != entityiterator && !(entityiterator instanceof RikaEntity) && !(entityiterator instanceof Rika2Entity) && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                        if (entityiterator instanceof CursedSpiritGrade03Entity) {
                           entity.getPersistentData().m_128347_("grade03", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade04Entity) {
                           entity.getPersistentData().m_128347_("grade04", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade05Entity) {
                           entity.getPersistentData().m_128347_("grade05", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade06Entity) {
                           entity.getPersistentData().m_128347_("grade06", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade07Entity) {
                           entity.getPersistentData().m_128347_("grade07", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade08Entity) {
                           entity.getPersistentData().m_128347_("grade08", (double)0.0F);
                        }

                        if (entityiterator instanceof CursedSpiritGrade11Entity) {
                           entity.getPersistentData().m_128347_("grade11", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade12Entity) {
                           entity.getPersistentData().m_128347_("grade12", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade13Entity) {
                           entity.getPersistentData().m_128347_("grade13", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade14Entity) {
                           entity.getPersistentData().m_128347_("grade14", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade15Entity) {
                           entity.getPersistentData().m_128347_("grade15", (double)0.0F);
                        }

                        if (entityiterator instanceof CursedSpiritGrade16Entity) {
                           entity.getPersistentData().m_128347_("grade16", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade16Entity) {
                           entity.getPersistentData().m_128347_("grade17", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade18Entity) {
                           entity.getPersistentData().m_128347_("grade18", (double)0.0F);
                        } else if (entityiterator instanceof CursedSpiritGrade19Entity) {
                           entity.getPersistentData().m_128347_("grade19", (double)0.0F);
                        }

                        if (!entityiterator.m_9236_().m_5776_()) {
                           entityiterator.m_146870_();
                        }
                     }
                  }
               }
            }

            if (entity instanceof GetoSuguruCurseUserEntity && var31 instanceof LivingEntity && (var31 instanceof RikaEntity && !(GetEntityFromUUIDProcedure.execute(world, ((Entity)var31).getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) || var31 instanceof OkkotsuYutaEntity && !(GetEntityFromUUIDProcedure.execute(world, ((Entity)var31).getPersistentData().m_128461_("RIKA_UUID")) instanceof LivingEntity)) && !((Entity)var31).m_6084_() && entity instanceof GetoSuguruCurseUserEntity) {
               GetoSuguruCurseUserEntity _datEntSetL = (GetoSuguruCurseUserEntity)entity;
               _datEntSetL.m_20088_().m_135381_(GetoSuguruCurseUserEntity.DATA_rika, true);
            }
         }

      }
   }
}
