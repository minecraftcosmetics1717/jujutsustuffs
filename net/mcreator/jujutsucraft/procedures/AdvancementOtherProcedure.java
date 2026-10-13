package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AdvancementOtherProcedure {
   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double t1 = (double)0.0F;
         double t2 = (double)0.0F;
         t1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         t2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
         if (t1 == (double)1.0F || t2 == (double)1.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_sukuna"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr1 = (ServerPlayer)entity;
               if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_sukuna"))).m_8193_()) {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_cleave"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr4 = (ServerPlayer)entity;
                     if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"))).m_8193_() && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_open"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  }
               }
            }
         }

         if (t1 == (double)8.0F || t2 == (double)8.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dagon"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr7 = (ServerPlayer)entity;
               if (_plr7.m_9236_() instanceof ServerLevel && _plr7.m_8960_().m_135996_(_plr7.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dagon"))).m_8193_() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr8 = (ServerPlayer)entity;
                  if (_plr8.m_9236_() instanceof ServerLevel && _plr8.m_8960_().m_135996_(_plr8.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"))).m_8193_()) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_bathynomus_giganteus"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr10 = (ServerPlayer)entity;
                        if (_plr10.m_9236_() instanceof ServerLevel && _plr10.m_8960_().m_135996_(_plr10.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"))).m_8193_() && entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_death_swarm"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (t1 == (double)11.0F || t2 == (double)11.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_black_bird_manipulation"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr13 = (ServerPlayer)entity;
               if (_plr13.m_9236_() instanceof ServerLevel && _plr13.m_8960_().m_135996_(_plr13.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_black_bird_manipulation"))).m_8193_() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr14 = (ServerPlayer)entity;
                  if (_plr14.m_9236_() instanceof ServerLevel && _plr14.m_8960_().m_135996_(_plr14.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"))).m_8193_() && entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_bird_strike"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
               }
            }
         }

         if (t1 == (double)13.0F || t2 == (double)13.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_nanami"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr17 = (ServerPlayer)entity;
               if (_plr17.m_9236_() instanceof ServerLevel && _plr17.m_8960_().m_135996_(_plr17.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_nanami"))).m_8193_() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr18 = (ServerPlayer)entity;
                  if (_plr18.m_9236_() instanceof ServerLevel && _plr18.m_8960_().m_135996_(_plr18.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"))).m_8193_() && entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_collapse"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
               }
            }
         }

         if (t1 == (double)14.0F || t2 == (double)14.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_hanami"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr21 = (ServerPlayer)entity;
               if (_plr21.m_9236_() instanceof ServerLevel && _plr21.m_8960_().m_135996_(_plr21.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_hanami"))).m_8193_() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr22 = (ServerPlayer)entity;
                  if (_plr22.m_9236_() instanceof ServerLevel && _plr22.m_8960_().m_135996_(_plr22.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"))).m_8193_() && entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_huge_roots"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
               }
            }
         }

         if (t1 == (double)18.0F || t2 == (double)18.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_geto"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr25 = (ServerPlayer)entity;
               if (_plr25.m_9236_() instanceof ServerLevel && _plr25.m_8960_().m_135996_(_plr25.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_geto"))).m_8193_() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr26 = (ServerPlayer)entity;
                  if (_plr26.m_9236_() instanceof ServerLevel && _plr26.m_8960_().m_135996_(_plr26.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).m_8193_() && entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_maximum_uzumaki"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
               }
            }
         }

         if (t1 == (double)19.0F || t2 == (double)19.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_naoya"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr29 = (ServerPlayer)entity;
               if (_plr29.m_9236_() instanceof ServerLevel && _plr29.m_8960_().m_135996_(_plr29.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_naoya"))).m_8193_() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr30 = (ServerPlayer)entity;
                  if (_plr30.m_9236_() instanceof ServerLevel && _plr30.m_8960_().m_135996_(_plr30.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"))).m_8193_() && entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_explodethe_air"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
               }
            }
         }

         if (t1 == (double)24.0F || t2 == (double)24.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_uraume"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr33 = (ServerPlayer)entity;
               if (_plr33.m_9236_() instanceof ServerLevel && _plr33.m_8960_().m_135996_(_plr33.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_uraume"))).m_8193_() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr34 = (ServerPlayer)entity;
                  if (_plr34.m_9236_() instanceof ServerLevel && _plr34.m_8960_().m_135996_(_plr34.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"))).m_8193_()) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_frost_calm"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr36 = (ServerPlayer)entity;
                        if (_plr36.m_9236_() instanceof ServerLevel && _plr36.m_8960_().m_135996_(_plr36.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"))).m_8193_() && entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_icefall"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
