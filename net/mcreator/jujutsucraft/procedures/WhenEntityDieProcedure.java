package net.mcreator.jujutsucraft.procedures;

import java.util.Iterator;
import java.util.List;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WhenEntityDieProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double fame = (double)0.0F;
         double fame_base = (double)0.0F;
         double EntityType = (double)0.0F;
         double level_strength = (double)0.0F;
         double FameGrade = (double)0.0F;
         double difficulty = (double)0.0F;
         double NUM1 = (double)0.0F;
         String target_jp = "";
         String message = "";
         String MVP_Message = "";
         String str1 = "";
         Entity target_entity = null;
         boolean killCurse = false;
         boolean logic_a = false;
         boolean isValidGamemode = false;
         PlayAnimationEntity2Procedure.execute(entity, "empty");
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var51 = var10000;
         if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.getPersistentData().m_128471_("Shikigami")) {
            if (entity instanceof Player) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)40.0F), (e) -> true)) {
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 == entity) {
                     NUM1 = (double)1.0F;

                     for(int index0 = 0; index0 < 128; ++index0) {
                        str1 = "pName" + Math.round(NUM1);
                        if (entityiterator.getPersistentData().m_128461_(str1).equals("")) {
                           entityiterator.getPersistentData().m_128359_(str1, entity.m_5446_().getString());
                           break;
                        }

                        ++NUM1;
                     }
                  }
               }
            }

            if (var51 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)3.0F) {
               label423: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var127 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label423;
                     }
                  }

                  var127 = (double)0.0F;
               }

               level_strength = var127;
               fame_base = (level_strength + (double)1.0F) * (level_strength + (double)1.0F) + (double)1.0F;
               if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                  target_jp = Component.m_237115_("jujutsu.message.kill1_1").getString();
                  killCurse = true;
               } else if (entity.getPersistentData().m_128471_("CurseUser")) {
                  target_jp = Component.m_237115_("jujutsu.message.kill1_2").getString();
               } else if (entity.getPersistentData().m_128471_("JujutsuSorcerer")) {
                  target_jp = Component.m_237115_("jujutsu.message.kill1_3").getString();
               } else if (entity.getPersistentData().m_128471_("jjkChara")) {
                  target_jp = " ";
               } else {
                  target_jp = "";
               }

               if (!target_jp.equals("")) {
                  JujutsucraftModVariables.PlayerVariables playerVars = null;
                  Vec3 _center = new Vec3(x, y, z);
                  List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)32.0F), (e) -> true);
                  Iterator var60 = _entfound.iterator();

                  while(true) {
                     Entity entityiterator;
                     while(true) {
                        if (!var60.hasNext()) {
                           return;
                        }

                        entityiterator = (Entity)var60.next();
                        if (entityiterator instanceof Player) {
                           playerVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
                           isValidGamemode = true;
                           if (entityiterator instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                              isValidGamemode = _serverPlayer.f_8941_.m_9290_() == GameType.SURVIVAL || _serverPlayer.f_8941_.m_9290_() == GameType.ADVENTURE;
                           }

                           if (isValidGamemode) {
                              if (!(entityiterator instanceof LivingEntity)) {
                                 break;
                              }

                              LivingEntity _livEnt21 = (LivingEntity)entityiterator;
                              if (!_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break;
                              }
                           }
                        }
                     }

                     if ((entityiterator.getPersistentData().m_128471_("JujutsuSorcerer") && ((Entity)var51).getPersistentData().m_128471_("JujutsuSorcerer") || entityiterator.getPersistentData().m_128471_("CurseUser") && ((Entity)var51).getPersistentData().m_128471_("CurseUser") || entityiterator.getPersistentData().m_128471_("CursedSpirit") && ((Entity)var51).getPersistentData().m_128471_("CursedSpirit") || var51 instanceof Player || ((Entity)var51).getPersistentData().m_128471_("Player")) && (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F || entity.getPersistentData().m_128459_("friend_num") != entityiterator.getPersistentData().m_128459_("friend_num"))) {
                        logic_a = false;
                        NUM1 = (double)1.0F;

                        for(int index1 = 0; index1 < 128; ++index1) {
                           str1 = entity.getPersistentData().m_128461_("pName" + Math.round(NUM1));
                           if (str1.equals("")) {
                              break;
                           }

                           if (str1.equals(entityiterator.m_5446_().getString())) {
                              logic_a = true;
                              break;
                           }

                           ++NUM1;
                        }

                        if (!logic_a) {
                           if (var51 == entityiterator || var51 instanceof Player || ((Entity)var51).getPersistentData().m_128471_("Player") || ((Entity)var51).getPersistentData().m_128459_("friend_num") != (double)0.0F && ((Entity)var51).getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                              MVP_Message = "[MVP]";
                              fame = fame_base;
                              playerVars.PlayerExperience = Math.max(playerVars.PlayerExperience, level_strength);
                              if (killCurse) {
                                 if (level_strength >= (double)10.0F) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_special"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= (double)8.0F) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_1"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= (double)5.0F) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_2"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= (double)1.0F) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_3"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_4"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              }

                              BeatJujutsuSorcererProcedure.execute(entity, entityiterator);
                              BeatEnemyProcedure.execute(entity, entityiterator);
                              BeatOtherProcedure.execute(entity, entityiterator);
                           } else {
                              MVP_Message = "";
                              fame = (double)Math.round(fame_base / (double)10.0F);
                           }

                           if (world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                              playerVars.PlayerFame += fame;
                              if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                                 message = target_jp + Component.m_237115_("jujutsu.message.kill4").getString().replace("[point]", "§l" + Math.round(fame) + "§r");
                              } else {
                                 message = target_jp + Component.m_237115_("jujutsu.message.kill3").getString().replace("[point]", "§l" + Math.round(fame) + "§r");
                              }

                              if (entityiterator instanceof Player) {
                                 Player _player = (Player)entityiterator;
                                 if (!_player.m_9236_().m_5776_()) {
                                    _player.m_5661_(Component.m_237113_(MVP_Message + message), false);
                                 }
                              }

                              label469: {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr51 = (ServerPlayer)entityiterator;
                                    if (_plr51.m_9236_() instanceof ServerLevel && _plr51.m_8960_().m_135996_(_plr51.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_special"))).m_8193_()) {
                                       FameGrade = (double)10.0F;
                                       break label469;
                                    }
                                 }

                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr52 = (ServerPlayer)entityiterator;
                                    if (_plr52.m_9236_() instanceof ServerLevel && _plr52.m_8960_().m_135996_(_plr52.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_1"))).m_8193_()) {
                                       FameGrade = (double)8.0F;
                                       break label469;
                                    }
                                 }

                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr53 = (ServerPlayer)entityiterator;
                                    if (_plr53.m_9236_() instanceof ServerLevel && _plr53.m_8960_().m_135996_(_plr53.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_2"))).m_8193_()) {
                                       FameGrade = (double)6.0F;
                                       break label469;
                                    }
                                 }

                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr54 = (ServerPlayer)entityiterator;
                                    if (_plr54.m_9236_() instanceof ServerLevel && _plr54.m_8960_().m_135996_(_plr54.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_3"))).m_8193_()) {
                                       FameGrade = (double)4.0F;
                                    }
                                 }
                              }

                              difficulty = (double)world.m_6106_().m_5470_().m_46215_(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY);
                              if (playerVars.PlayerFame >= (double)4000.0F * difficulty && FameGrade >= (double)10.0F) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_special"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= (double)2750.0F * difficulty && FameGrade >= (double)8.0F) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= (double)1750.0F * difficulty) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= (double)1000.0F * difficulty && FameGrade >= (double)6.0F) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= (double)500.0F * difficulty) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= (double)200.0F * difficulty && FameGrade >= (double)4.0F) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= (double)50.0F * difficulty && entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_4"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                           }

                           playerVars.syncPlayerVariables(entityiterator);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
