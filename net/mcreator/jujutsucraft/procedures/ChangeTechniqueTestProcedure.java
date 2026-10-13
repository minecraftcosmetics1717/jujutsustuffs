package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class ChangeTechniqueTestProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity == null) {
         return false;
      } else {
         boolean isCreative = false;
         boolean reChange = false;
         double NUM2 = (double)0.0F;
         double NUM1 = (double)0.0F;
         if (!(entity instanceof ServerPlayer)) {
            return false;
         } else if (playerSelect >= (double)0.0F && playerSelect <= (double)2.0F) {
            return false;
         } else {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _servPlayer = (ServerPlayer)entity;
               isCreative = _servPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
            }

            if (!isCreative) {
               if (playerSelect == (double)20.0F) {
                  label900: {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr1 = (ServerPlayer)entity;
                        if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).m_8193_()) {
                           break label900;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt2 = (LivingEntity)entity;
                        if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label900;
                        }
                     }

                     reChange = true;
                  }
               }

               if (playerCT < (double)10.0F) {
                  if (playerCT == (double)1.0F) {
                     label826: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt3 = (LivingEntity)entity;
                           if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label826;
                           }
                        }

                        if (playerSelect == (double)7.0F) {
                           label821: {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr4 = (ServerPlayer)entity;
                                 if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_open"))).m_8193_()) {
                                    break label821;
                                 }
                              }

                              reChange = true;
                           }
                        }
                     }
                  } else if (playerCT == (double)2.0F) {
                     label815: {
                        label850: {
                           if (playerSelect == (double)5.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label850;
                              }

                              ServerPlayer _plr5 = (ServerPlayer)entity;
                              if (!(_plr5.m_9236_() instanceof ServerLevel) || !_plr5.m_8960_().m_135996_(_plr5.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_infinity"))).m_8193_()) {
                                 break label850;
                              }
                           }

                           if (playerSelect == (double)7.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label850;
                              }

                              ServerPlayer _plr6 = (ServerPlayer)entity;
                              if (!(_plr6.m_9236_() instanceof ServerLevel) || !_plr6.m_8960_().m_135996_(_plr6.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_cursed_technique_reversal_red"))).m_8193_()) {
                                 break label850;
                              }
                           }

                           if (playerSelect != (double)15.0F) {
                              break label815;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr7 = (ServerPlayer)entity;
                              if (_plr7.m_9236_() instanceof ServerLevel && _plr7.m_8960_().m_135996_(_plr7.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_hollow_technique_purple"))).m_8193_()) {
                                 break label815;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == (double)4.0F) {
                     label791: {
                        label853: {
                           if (playerSelect == (double)5.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label853;
                              }

                              ServerPlayer _plr8 = (ServerPlayer)entity;
                              if (!(_plr8.m_9236_() instanceof ServerLevel) || !_plr8.m_8960_().m_135996_(_plr8.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_disaster_flames"))).m_8193_()) {
                                 break label853;
                              }
                           }

                           if (playerSelect == (double)8.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label853;
                              }

                              ServerPlayer _plr9 = (ServerPlayer)entity;
                              if (!(_plr9.m_9236_() instanceof ServerLevel) || !_plr9.m_8960_().m_135996_(_plr9.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_flame_laser"))).m_8193_()) {
                                 break label853;
                              }
                           }

                           if (playerSelect == (double)9.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label853;
                              }

                              ServerPlayer _plr10 = (ServerPlayer)entity;
                              if (!(_plr10.m_9236_() instanceof ServerLevel) || !_plr10.m_8960_().m_135996_(_plr10.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_lava_waves"))).m_8193_()) {
                                 break label853;
                              }
                           }

                           if (playerSelect != (double)15.0F) {
                              break label791;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr11 = (ServerPlayer)entity;
                              if (_plr11.m_9236_() instanceof ServerLevel && _plr11.m_8960_().m_135996_(_plr11.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_maximum_meteor"))).m_8193_()) {
                                 break label791;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == (double)5.0F) {
                     label758: {
                        label858: {
                           if (playerSelect == (double)5.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label858;
                              }

                              ServerPlayer _plr12 = (ServerPlayer)entity;
                              if (!(_plr12.m_9236_() instanceof ServerLevel) || !_plr12.m_8960_().m_135996_(_plr12.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"))).m_8193_()) {
                                 break label858;
                              }

                              if (entity instanceof Player) {
                                 Player _playerHasItem = (Player)entity;
                                 if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.LOUDSPEAKER.get()))) {
                                    break label858;
                                 }
                              }
                           }

                           label860: {
                              if (playerSelect == (double)6.0F) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label860;
                                 }

                                 ServerPlayer _plr14 = (ServerPlayer)entity;
                                 if (!(_plr14.m_9236_() instanceof ServerLevel) || !_plr14.m_8960_().m_135996_(_plr14.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_dhruv_lakdawalla"))).m_8193_()) {
                                    break label860;
                                 }
                              }

                              if (playerSelect != (double)7.0F) {
                                 break label758;
                              }

                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr15 = (ServerPlayer)entity;
                                 if (_plr15.m_9236_() instanceof ServerLevel && _plr15.m_8960_().m_135996_(_plr15.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"))).m_8193_()) {
                                    break label758;
                                 }
                              }

                              reChange = true;
                              break label758;
                           }

                           reChange = true;
                           break label758;
                        }

                        reChange = true;
                     }

                     if (playerSelect == (double)15.0F || playerSelect == (double)19.0F) {
                        label905: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr16 = (ServerPlayer)entity;
                              if (_plr16.m_9236_() instanceof ServerLevel && _plr16.m_8960_().m_135996_(_plr16.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_rika_control"))).m_8193_()) {
                                 break label905;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)6.0F) {
                     if (playerSelect >= (double)5.0F && playerSelect < (double)20.0F) {
                        if (entity.getPersistentData().m_128459_("TenShadowsTechnique" + Math.round(playerSelect - (double)4.0F)) < (double)0.0F) {
                           reChange = true;
                        }

                        if (playerSelect != (double)5.0F && playerSelect != (double)6.0F) {
                           if (playerSelect == (double)7.0F && (entity.getPersistentData().m_128459_("TenShadowsTechnique1") != (double)-2.0F || !(entity.getPersistentData().m_128459_("TenShadowsTechnique2") >= (double)0.0F)) && (!(entity.getPersistentData().m_128459_("TenShadowsTechnique1") >= (double)0.0F) || entity.getPersistentData().m_128459_("TenShadowsTechnique2") != (double)-2.0F)) {
                              reChange = true;
                           }
                        } else if (entity.getPersistentData().m_128459_("TenShadowsTechnique3") < (double)0.0F) {
                           reChange = true;
                        }

                        if (playerSelect != (double)8.0F && playerSelect != (double)9.0F && playerSelect != (double)13.0F && playerSelect != (double)15.0F) {
                           if (playerSelect == (double)17.0F) {
                              label696: {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr24 = (ServerPlayer)entity;
                                    if (_plr24.m_9236_() instanceof ServerLevel && _plr24.m_8960_().m_135996_(_plr24.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_nue"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique4") >= (double)0.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique5") <= (double)-2.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique9") <= (double)-2.0F && entity.getPersistentData().m_128459_("TenShadowsTechnique11") <= (double)-2.0F) {
                                       break label696;
                                    }
                                 }

                                 reChange = true;
                              }
                           }
                        } else if (entity.getPersistentData().m_128459_("TenShadowsTechnique13") < (double)0.0F) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)7.0F) {
                     if (playerSelect == (double)10.0F && entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)8.0F) {
                     label685: {
                        label864: {
                           if (playerSelect == (double)9.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label864;
                              }

                              ServerPlayer _plr30 = (ServerPlayer)entity;
                              if (!(_plr30.m_9236_() instanceof ServerLevel) || !_plr30.m_8960_().m_135996_(_plr30.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_death_swarm"))).m_8193_()) {
                                 break label864;
                              }
                           }

                           if (playerSelect != (double)10.0F) {
                              break label685;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr31 = (ServerPlayer)entity;
                              if (_plr31.m_9236_() instanceof ServerLevel && _plr31.m_8960_().m_135996_(_plr31.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_bathynomus_giganteus"))).m_8193_()) {
                                 break label685;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == (double)9.0F) {
                     label669: {
                        label866: {
                           if (playerSelect == (double)5.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label866;
                              }

                              ServerPlayer _plr32 = (ServerPlayer)entity;
                              if (!(_plr32.m_9236_() instanceof ServerLevel) || !_plr32.m_8960_().m_135996_(_plr32.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_garuda_soccer"))).m_8193_()) {
                                 break label866;
                              }
                           }

                           if (playerSelect != (double)6.0F) {
                              break label669;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr33 = (ServerPlayer)entity;
                              if (_plr33.m_9236_() instanceof ServerLevel && _plr33.m_8960_().m_135996_(_plr33.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_garuda"))).m_8193_()) {
                                 break label669;
                              }
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < (double)20.0F) {
                  if (playerCT == (double)10.0F) {
                     label437: {
                        label868: {
                           if (playerSelect == (double)6.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label868;
                              }

                              ServerPlayer _plr34 = (ServerPlayer)entity;
                              if (!(_plr34.m_9236_() instanceof ServerLevel) || !_plr34.m_8960_().m_135996_(_plr34.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_convergence"))).m_8193_()) {
                                 break label868;
                              }
                           }

                           label870: {
                              if (playerSelect == (double)7.0F) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label870;
                                 }

                                 ServerPlayer _plr35 = (ServerPlayer)entity;
                                 if (!(_plr35.m_9236_() instanceof ServerLevel) || !_plr35.m_8960_().m_135996_(_plr35.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_piercing_blood"))).m_8193_()) {
                                    break label870;
                                 }
                              }

                              label872: {
                                 if (playerSelect == (double)8.0F) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label872;
                                    }

                                    ServerPlayer _plr36 = (ServerPlayer)entity;
                                    if (!(_plr36.m_9236_() instanceof ServerLevel) || !_plr36.m_8960_().m_135996_(_plr36.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_supernova"))).m_8193_()) {
                                       break label872;
                                    }
                                 }

                                 label874: {
                                    if (playerSelect == (double)9.0F) {
                                       if (!(entity instanceof ServerPlayer)) {
                                          break label874;
                                       }

                                       ServerPlayer _plr37 = (ServerPlayer)entity;
                                       if (!(_plr37.m_9236_() instanceof ServerLevel) || !_plr37.m_8960_().m_135996_(_plr37.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_flowing_red_scale"))).m_8193_()) {
                                          break label874;
                                       }
                                    }

                                    label876: {
                                       if (playerSelect == (double)16.0F) {
                                          if (!(entity instanceof ServerPlayer)) {
                                             break label876;
                                          }

                                          ServerPlayer _plr38 = (ServerPlayer)entity;
                                          if (!(_plr38.m_9236_() instanceof ServerLevel) || !_plr38.m_8960_().m_135996_(_plr38.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_blood_wave"))).m_8193_()) {
                                             break label876;
                                          }
                                       }

                                       if (playerSelect != (double)18.0F) {
                                          break label437;
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr39 = (ServerPlayer)entity;
                                          if (_plr39.m_9236_() instanceof ServerLevel && _plr39.m_8960_().m_135996_(_plr39.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_eso"))).m_8193_()) {
                                             break label437;
                                          }
                                       }

                                       reChange = true;
                                       break label437;
                                    }

                                    reChange = true;
                                    break label437;
                                 }

                                 reChange = true;
                                 break label437;
                              }

                              reChange = true;
                              break label437;
                           }

                           reChange = true;
                           break label437;
                        }

                        reChange = true;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt40 = (LivingEntity)entity;
                        if (_livEnt40.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()) && playerSelect != (double)9.0F && playerSelect >= (double)5.0F && playerSelect < (double)20.0F) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)11.0F) {
                     if (playerSelect == (double)5.0F) {
                        label650: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr41 = (ServerPlayer)entity;
                              if (_plr41.m_9236_() instanceof ServerLevel && _plr41.m_8960_().m_135996_(_plr41.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_bird_strike"))).m_8193_()) {
                                 break label650;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)13.0F) {
                     if (playerSelect == (double)10.0F) {
                        label643: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr42 = (ServerPlayer)entity;
                              if (_plr42.m_9236_() instanceof ServerLevel && _plr42.m_8960_().m_135996_(_plr42.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_collapse"))).m_8193_()) {
                                 break label643;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)14.0F) {
                     if (playerSelect == (double)10.0F) {
                        label636: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr43 = (ServerPlayer)entity;
                              if (_plr43.m_9236_() instanceof ServerLevel && _plr43.m_8960_().m_135996_(_plr43.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_huge_roots"))).m_8193_()) {
                                 break label636;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)15.0F) {
                     label878: {
                        label629: {
                           label911: {
                              if (playerSelect == (double)8.0F || playerSelect == (double)9.0F || playerSelect == (double)10.0F) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label911;
                                 }

                                 ServerPlayer _plr44 = (ServerPlayer)entity;
                                 if (!(_plr44.m_9236_() instanceof ServerLevel) || !_plr44.m_8960_().m_135996_(_plr44.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_soul_multiplicity"))).m_8193_()) {
                                    break label911;
                                 }
                              }

                              label881: {
                                 if (playerSelect == (double)10.0F) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label881;
                                    }

                                    ServerPlayer _plr45 = (ServerPlayer)entity;
                                    if (!(_plr45.m_9236_() instanceof ServerLevel) || !_plr45.m_8960_().m_135996_(_plr45.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_polymorphic_soul_isomer"))).m_8193_()) {
                                       break label881;
                                    }
                                 }

                                 if (playerSelect != (double)15.0F) {
                                    break label629;
                                 }

                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr46 = (ServerPlayer)entity;
                                    if (_plr46.m_9236_() instanceof ServerLevel && _plr46.m_8960_().m_135996_(_plr46.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_instant_spirit_bodyof_distorted_killing"))).m_8193_()) {
                                       break label629;
                                    }
                                 }

                                 reChange = true;
                                 break label629;
                              }

                              reChange = true;
                              break label629;
                           }

                           reChange = true;
                        }

                        label883: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt47 = (LivingEntity)entity;
                              if (_livEnt47.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                 if (!(playerSelect >= (double)6.0F) || !(playerSelect <= (double)15.0F)) {
                                    break label878;
                                 }
                                 break label883;
                              }
                           }

                           if ((!(playerSelect >= (double)3.0F) || !(playerSelect <= (double)4.0F)) && (!(playerSelect >= (double)16.0F) || !(playerSelect <= (double)19.0F))) {
                              break label878;
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == (double)17.0F) {
                     if (playerSelect == (double)10.0F) {
                        label901: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt48 = (LivingEntity)entity;
                              if (_livEnt48.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                 break label901;
                              }
                           }

                           reChange = true;
                        }
                     }

                     if (playerSelect == (double)15.0F && entity instanceof LivingEntity) {
                        LivingEntity _livEnt49 = (LivingEntity)entity;
                        if (_livEnt49.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)18.0F) {
                     label581: {
                        label580: {
                           if (playerSelect == (double)5.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label580;
                              }

                              ServerPlayer _plr50 = (ServerPlayer)entity;
                              if (!(_plr50.m_9236_() instanceof ServerLevel) || !_plr50.m_8960_().m_135996_(_plr50.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                                 break label580;
                              }
                           }

                           if (playerSelect == (double)15.0F) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr51 = (ServerPlayer)entity;
                                 if (_plr51.m_9236_() instanceof ServerLevel && _plr51.m_8960_().m_135996_(_plr51.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_maximum_uzumaki"))).m_8193_()) {
                                    break label581;
                                 }
                              }

                              reChange = true;
                           }
                           break label581;
                        }

                        reChange = true;
                     }
                  } else if (playerCT == (double)19.0F && playerSelect == (double)10.0F) {
                     label563: {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr52 = (ServerPlayer)entity;
                           if (_plr52.m_9236_() instanceof ServerLevel && _plr52.m_8960_().m_135996_(_plr52.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_explodethe_air"))).m_8193_()) {
                              break label563;
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < (double)30.0F) {
                  if (playerCT == (double)20.0F) {
                     if (playerSelect == (double)15.0F && entity instanceof LivingEntity) {
                        LivingEntity _livEnt53 = (LivingEntity)entity;
                        if (_livEnt53.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)21.0F) {
                     label555: {
                        label886: {
                           if (playerSelect == (double)5.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label886;
                              }

                              ServerPlayer _plr54 = (ServerPlayer)entity;
                              if (!(_plr54.m_9236_() instanceof ServerLevel) || !_plr54.m_8960_().m_135996_(_plr54.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_divergent_fist"))).m_8193_()) {
                                 break label886;
                              }
                           }

                           label888: {
                              if (playerSelect == (double)8.0F) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label888;
                                 }

                                 ServerPlayer _plr55 = (ServerPlayer)entity;
                                 if (!(_plr55.m_9236_() instanceof ServerLevel) || !_plr55.m_8960_().m_135996_(_plr55.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_itadori"))).m_8193_()) {
                                    break label888;
                                 }
                              }

                              label890: {
                                 if (playerSelect == (double)13.0F) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label890;
                                    }

                                    ServerPlayer _plr56 = (ServerPlayer)entity;
                                    if (!(_plr56.m_9236_() instanceof ServerLevel) || !_plr56.m_8960_().m_135996_(_plr56.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_piercing_blood_itadori"))).m_8193_() || ReturnInsideItemProcedure.execute(entity).m_41720_() != JujutsucraftModItems.DEATH_PAINTING.get()) {
                                       break label890;
                                    }
                                 }

                                 label522: {
                                    if (playerSelect == (double)14.0F) {
                                       if (!(entity instanceof ServerPlayer)) {
                                          break label522;
                                       }

                                       ServerPlayer _plr58 = (ServerPlayer)entity;
                                       if (!(_plr58.m_9236_() instanceof ServerLevel) || !_plr58.m_8960_().m_135996_(_plr58.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_supernova_itadori"))).m_8193_() || ReturnInsideItemProcedure.execute(entity).m_41720_() != JujutsucraftModItems.DEATH_PAINTING.get()) {
                                          break label522;
                                       }
                                    }

                                    if (playerSelect == (double)18.0F) {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr60 = (ServerPlayer)entity;
                                          if (_plr60.m_9236_() instanceof ServerLevel && _plr60.m_8960_().m_135996_(_plr60.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_deep_concentration"))).m_8193_()) {
                                             break label555;
                                          }
                                       }

                                       reChange = true;
                                    }
                                    break label555;
                                 }

                                 reChange = true;
                                 break label555;
                              }

                              reChange = true;
                              break label555;
                           }

                           reChange = true;
                           break label555;
                        }

                        reChange = true;
                     }
                  } else if (playerCT == (double)24.0F) {
                     label504: {
                        label503: {
                           if (playerSelect == (double)8.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label503;
                              }

                              ServerPlayer _plr61 = (ServerPlayer)entity;
                              if (!(_plr61.m_9236_() instanceof ServerLevel) || !_plr61.m_8960_().m_135996_(_plr61.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_frost_calm"))).m_8193_()) {
                                 break label503;
                              }
                           }

                           if (playerSelect == (double)9.0F) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr62 = (ServerPlayer)entity;
                                 if (_plr62.m_9236_() instanceof ServerLevel && _plr62.m_8960_().m_135996_(_plr62.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_icefall"))).m_8193_()) {
                                    break label504;
                                 }
                              }

                              reChange = true;
                           }
                           break label504;
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < (double)40.0F) {
                  if (playerCT == (double)30.0F) {
                     if (playerSelect == (double)5.0F && entity instanceof LivingEntity) {
                        LivingEntity _livEnt63 = (LivingEntity)entity;
                        if (_livEnt63.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)39.0F && (playerSelect == (double)5.0F || playerSelect == (double)6.0F || playerSelect == (double)7.0F)) {
                     label909: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt64 = (LivingEntity)entity;
                           if (_livEnt64.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                              break label909;
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < (double)50.0F) {
                  if (playerCT == (double)40.0F) {
                     label474: {
                        if (playerSelect == (double)6.0F && entity instanceof LivingEntity) {
                           LivingEntity _livEnt65 = (LivingEntity)entity;
                           if (_livEnt65.m_21023_((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get())) {
                              reChange = true;
                              break label474;
                           }
                        }

                        if (playerSelect == (double)7.0F && entity instanceof LivingEntity) {
                           LivingEntity _livEnt66 = (LivingEntity)entity;
                           if (_livEnt66.m_21023_((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                              reChange = true;
                           }
                        }
                     }
                  } else if (playerCT == (double)41.0F) {
                     if (playerSelect == (double)10.0F) {
                        label467: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr67 = (ServerPlayer)entity;
                              if (_plr67.m_9236_() instanceof ServerLevel && _plr67.m_8960_().m_135996_(_plr67.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                                 break label467;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == (double)43.0F && playerSelect == (double)7.0F) {
                     label460: {
                        label459: {
                           label895: {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr68 = (ServerPlayer)entity;
                                 if (_plr68.m_9236_() instanceof ServerLevel && _plr68.m_8960_().m_135996_(_plr68.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_megumi_fushiguro"))).m_8193_()) {
                                    break label895;
                                 }
                              }

                              if (!(entity instanceof ServerPlayer)) {
                                 break label459;
                              }

                              ServerPlayer _plr69 = (ServerPlayer)entity;
                              if (!(_plr69.m_9236_() instanceof ServerLevel) || !_plr69.m_8960_().m_135996_(_plr69.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_megumi_fushiguro_shibuya"))).m_8193_()) {
                                 break label459;
                              }
                           }

                           if (!(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("SHIKIGAMI_ROZETSU_UUID")) instanceof LivingEntity)) {
                              break label460;
                           }
                        }

                        reChange = true;
                     }
                  }
               }
            }

            reChange = reChange || ChangeTechniqueTest2Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
            return reChange;
         }
      }
   }
}
