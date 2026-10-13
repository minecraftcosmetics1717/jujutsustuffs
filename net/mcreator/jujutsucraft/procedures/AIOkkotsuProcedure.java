package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.GetoSuguruCurseUserEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIOkkotsuProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack ITEM1 = ItemStack.f_41583_;
         boolean use_copy = false;
         boolean domain = false;
         boolean PureLoveCannon = false;
         boolean canUseCopy = false;
         boolean StrongEnemy = false;
         boolean logicLocateRika = false;
         Entity target_entity = null;
         Entity entity_rika = null;
         double NUM_COPY = (double)0.0F;
         double distance = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double level = (double)0.0F;
         if (entity.m_6084_()) {
            label655: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label655;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, entity instanceof OkkotsuYutaCullingGameEntity ? 20 : 18, false, false));
                  }
               }
            }

            label650: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label650;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
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

            Entity var38 = var10000;
            if (var38 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               entity.getPersistentData().m_128347_("cnt_rika", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  label688: {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     logicLocateRika = LocateRikaProcedure.execute(world, entity);
                     if (!logicLocateRika) {
                        label685: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                                 break label685;
                              }
                           }

                           var89 = false;
                           break label688;
                        }
                     }

                     var89 = true;
                  }

                  canUseCopy = var89;
                  if (entity instanceof OkkotsuYutaCullingGameEntity) {
                     CompoundTag var90 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21223_();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var115 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.m_21233_();
                     } else {
                        var10003 = -1.0F;
                     }

                     label626: {
                        label665: {
                           if (!(var115 < (double)var10003 * (double)0.5F)) {
                              if (!(var38 instanceof SukunaPerfectEntity) && !(var38 instanceof SukunaFushiguroEntity) || !(var38 instanceof LivingEntity)) {
                                 break label665;
                              }

                              LivingEntity _livEnt22 = var38;
                              if (!_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()) || !(entity.getPersistentData().m_128459_("cnt_target") >= (double)100.0F)) {
                                 break label665;
                              }
                           }

                           label613: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var116 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label613;
                                 }
                              }

                              var116 = 0;
                           }

                           label608: {
                              var117 = var116 - 10;
                              if (var38 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var38;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var119 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label608;
                                 }
                              }

                              var119 = 0;
                           }

                           if (var117 <= var119) {
                              var118 = true;
                              break label626;
                           }
                        }

                        var118 = false;
                     }

                     var90.m_128379_("flag_domain", var118);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  }

                  if (entity instanceof OkkotsuYutaEntity && LocateRikaProcedure.execute(world, entity)) {
                     float var91;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var91 = _livEnt.m_21223_();
                     } else {
                        var91 = -1.0F;
                     }

                     double var92 = (double)var91;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     PureLoveCannon = var92 <= (double)var10001 * 0.2 || ((Entity)var38).getPersistentData().m_128459_("skill") % (double)100.0F == (double)15.0F && (((Entity)var38).getPersistentData().m_128459_("skill") != (double)1815.0F || ((Entity)var38).getPersistentData().m_128459_("cnt9") >= (double)20.0F && ((Entity)var38).getPersistentData().m_128459_("cnt9") <= (double)25.0F);
                  }

                  label585: {
                     if (var38 instanceof LivingEntity) {
                        LivingEntity _livEnt = var38;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var93 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label585;
                        }
                     }

                     var93 = 0;
                  }

                  int var113;
                  label580: {
                     var94 = (double)var93;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var113 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label580;
                        }
                     }

                     var113 = 0;
                  }

                  StrongEnemy = var94 >= (double)var113 * (double)0.5F || entity.getPersistentData().m_128459_("cnt_target") > (double)600.0F;
                  ResetCounterProcedure.execute(entity);
                  rnd = (double)0.0F;
                  if (LogicStartProcedure.execute(entity) || domain) {
                     if (domain) {
                        entity.getPersistentData().m_128379_("flag_domain", false);
                        rnd = (double)20.0F;
                        tick = (double)20.0F;
                     } else if ((logicLocateRika || !StrongEnemy) && !PureLoveCannon) {
                        if (Math.random() > (double)0.75F) {
                           rnd = (double)10.0F;
                           tick = (double)75.0F;
                        } else if (!AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() > 0.95 && entity instanceof OkkotsuYutaCullingGameEntity && StrongEnemy) {
                           rnd = (double)20.0F;
                           tick = (double)20.0F;
                        } else {
                           distance = GetDistanceProcedure.execute(entity);
                           if (Math.random() > 0.8) {
                              for(int index0 = 0; index0 < 256; ++index0) {
                                 rnd = (double)Math.round(Math.random() * (double)10.0F);
                                 if (rnd == (double)3.0F) {
                                    tick = (double)20.0F;
                                    if (!(distance < (double)6.0F)) {
                                       break;
                                    }
                                 } else if (rnd == (double)5.0F) {
                                    tick = (double)250.0F;
                                    if (canUseCopy && !(Math.random() < (double)0.5F)) {
                                       break;
                                    }
                                 } else if (rnd == (double)6.0F) {
                                    tick = (double)150.0F;
                                    if (entity instanceof OkkotsuYutaCullingGameEntity && canUseCopy && !(distance < (double)6.0F)) {
                                       break;
                                    }
                                 } else if (rnd == (double)7.0F) {
                                    tick = (double)100.0F;
                                    if (entity instanceof OkkotsuYutaCullingGameEntity && canUseCopy && !(distance > (double)6.0F)) {
                                       break;
                                    }
                                 } else if (rnd == (double)10.0F) {
                                    tick = (double)10.0F;
                                    if (!(Math.random() < (double)0.5F)) {
                                       break;
                                    }
                                 }
                              }
                           } else if (entity instanceof OkkotsuYutaCullingGameEntity && Math.random() > 0.8 && distance < (double)4.0F && canUseCopy) {
                              use_copy = true;
                              rnd = (double)106.0F;
                              tick = (double)50.0F;
                           } else if ((!(entity instanceof OkkotsuYutaEntity) || !(var38 instanceof GetoSuguruCurseUserEntity)) && canUseCopy) {
                              use_copy = false;
                              NUM_COPY = Math.floor(Math.random() * (double)4.0F);

                              for(int index1 = 0; index1 < 4; ++index1) {
                                 ItemStack var95;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var95 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)NUM_COPY));
                                 } else {
                                    var95 = ItemStack.f_41583_;
                                 }

                                 ITEM1 = var95.m_41777_();
                                 if (ITEM1.m_41784_().m_128459_("skill") > (double)0.0F) {
                                    use_copy = true;
                                    rnd = ITEM1.m_41784_().m_128459_("skill");
                                    tick = ITEM1.m_41784_().m_128459_("COOLDOWN_TICKS");
                                    break;
                                 }

                                 ++NUM_COPY;
                                 if (NUM_COPY > (double)3.0F) {
                                    NUM_COPY = (double)0.0F;
                                 }
                              }
                           }
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 19, false, false));
                           }
                        }

                        if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                           entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("RIKA_UUID"));
                           if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity_rika instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity_rika;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 30, 1, false, false));
                              }
                           }
                        }

                        if (PureLoveCannon) {
                           rnd = (double)15.0F;
                           tick = (double)500.0F;
                        } else {
                           rnd = (double)10.0F;
                           tick = (double)75.0F;
                        }
                     }
                  }

                  if (!LogicCooldownCombatProcedure.execute(entity)) {
                     ItemStack var96;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var96 = _livEnt.m_21205_();
                     } else {
                        var96 = ItemStack.f_41583_;
                     }

                     if (var96.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                        if (Math.random() < 0.2 && GetDistanceProcedure.execute(entity) < (double)12.0F) {
                           rnd = (double)504.0F;
                           level = (double)1.0F;
                           tick = (double)100.0F;
                        }

                        float var97;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var97 = _livEnt.m_21223_();
                        } else {
                           var97 = -1.0F;
                        }

                        double var98 = (double)var97;
                        float var114;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var114 = _livEnt.m_21233_();
                        } else {
                           var114 = -1.0F;
                        }

                        if (var98 <= (double)var114 * (double)0.5F) {
                           if (!entity.getPersistentData().m_128471_("flag1")) {
                              entity.getPersistentData().m_128379_("flag1", true);
                              use_copy = false;
                              rnd = (double)3704.0F;
                              level = (double)1.0F;
                              tick = (double)100.0F;
                              ItemStack var99;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var99 = _livEnt.m_21205_();
                              } else {
                                 var99 = ItemStack.f_41583_;
                              }

                              if (var99.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var99 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                 } else {
                                    var99 = ItemStack.f_41583_;
                                 }

                                 if (var99.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                                    if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                       entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with jujutsucraft:sword_okkotsu_yuta");
                                    }

                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entity;
                                       var99 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                    } else {
                                       var99 = ItemStack.f_41583_;
                                    }

                                    CompoundTag _nbtTag = var99.m_41783_();
                                    if (_nbtTag != null) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          var99 = _livEnt.m_21205_();
                                       } else {
                                          var99 = ItemStack.f_41583_;
                                       }

                                       var99.m_41751_(_nbtTag.m_6426_());
                                    }

                                    if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                       entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with air");
                                    }
                                 }
                              }
                           }
                        } else {
                           entity.getPersistentData().m_128379_("flag1", false);
                        }
                     }
                  }

                  if (rnd != (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(use_copy ? rnd : (double)500.0F + rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (level > (double)0.0F) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (rnd == (double)15.0F) {
                        ItemStack var103;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var103 = _livEnt.m_21205_();
                        } else {
                           var103 = ItemStack.f_41583_;
                        }

                        if (var103.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var103 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var103 = ItemStack.f_41583_;
                           }

                           if (var103.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var103 = _livEnt.m_21205_();
                              } else {
                                 var103 = ItemStack.f_41583_;
                              }

                              CompoundTag _nbtTag = var103.m_41783_();
                              if (_nbtTag != null) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var103 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                 } else {
                                    var103 = ItemStack.f_41583_;
                                 }

                                 var103.m_41751_(_nbtTag.m_6426_());
                              }

                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
                              }
                           }
                        }
                     }
                  } else if (PureLoveCannon) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 19, false, false));
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_x", (double)5.0F);
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                     ItemStack var107;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var107 = _livEnt.m_21205_();
                     } else {
                        var107 = ItemStack.f_41583_;
                     }

                     if (var107.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var107 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var107 = ItemStack.f_41583_;
                        }

                        if (var107.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with jujutsucraft:sword_okkotsu_yuta");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var107 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var107 = ItemStack.f_41583_;
                           }

                           CompoundTag _nbtTag = var107.m_41783_();
                           if (_nbtTag != null) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var107 = _livEnt.m_21205_();
                              } else {
                                 var107 = ItemStack.f_41583_;
                              }

                              var107.m_41751_(_nbtTag.m_6426_());
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with air");
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_rika", entity.getPersistentData().m_128459_("cnt_rika") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_rika") % (double)200.0F == (double)190.0F) {
                  if (LocateRikaProcedure.execute(world, entity)) {
                     entity.getPersistentData().m_128347_("cnt1", (double)20.0F);
                     TechniqueRika2Procedure.execute(world, x, y, z, entity);
                  }

                  ItemStack var85;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var85 = _livEnt.m_21205_();
                  } else {
                     var85 = ItemStack.f_41583_;
                  }

                  if (var85.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var85 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var85 = ItemStack.f_41583_;
                     }

                     if (var85.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var85 = _livEnt.m_21205_();
                        } else {
                           var85 = ItemStack.f_41583_;
                        }

                        CompoundTag _nbtTag = var85.m_41783_();
                        if (_nbtTag != null) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var85 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var85 = ItemStack.f_41583_;
                           }

                           var85.m_41751_(_nbtTag.m_6426_());
                        }

                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)4204.0F) {
               entity.getPersistentData().m_128379_("flag_weapon", true);
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               if (entity.getPersistentData().m_128471_("flag_weapon")) {
                  entity.getPersistentData().m_128379_("flag_weapon", false);
                  ItemStack var111;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var111 = _livEnt.m_21205_();
                  } else {
                     var111 = ItemStack.f_41583_;
                  }

                  if (var111.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
                  }
               }

               ItemStack var112;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var112 = _livEnt.m_21205_();
               } else {
                  var112 = ItemStack.f_41583_;
               }

               if (var112.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
               }
            }
         }

      }
   }
}
