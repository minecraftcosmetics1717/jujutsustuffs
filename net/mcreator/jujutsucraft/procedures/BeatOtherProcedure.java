package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.AwasakaJiroEntity;
import net.mcreator.jujutsucraft.entity.CharlesBernardEntity;
import net.mcreator.jujutsucraft.entity.ChosoEntity;
import net.mcreator.jujutsucraft.entity.DaidoHaganeEntity;
import net.mcreator.jujutsucraft.entity.DhruvLakdawallaEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.EsoEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.entity.HazenokiEntity;
import net.mcreator.jujutsucraft.entity.HigurumaHiromiEntity;
import net.mcreator.jujutsucraft.entity.IshigoriRyuEntity;
import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.entity.KechizuEntity;
import net.mcreator.jujutsucraft.entity.KumiyaJuzoEntity;
import net.mcreator.jujutsucraft.entity.KurusuHanaEntity;
import net.mcreator.jujutsucraft.entity.LarueEntity;
import net.mcreator.jujutsucraft.entity.MiguelDancerEntity;
import net.mcreator.jujutsucraft.entity.MiguelEntity;
import net.mcreator.jujutsucraft.entity.MimikoEntity;
import net.mcreator.jujutsucraft.entity.MiyoRokujushiEntity;
import net.mcreator.jujutsucraft.entity.NanakoEntity;
import net.mcreator.jujutsucraft.entity.NegiToshihisaEntity;
import net.mcreator.jujutsucraft.entity.OgamiEntity;
import net.mcreator.jujutsucraft.entity.ReggieStarEntity;
import net.mcreator.jujutsucraft.entity.ShigemoHarutaEntity;
import net.mcreator.jujutsucraft.entity.TakabaFumihikoEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.entity.YorozuEntity;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class BeatOtherProcedure {
   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         if (entity instanceof ChosoEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_choso"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof EsoEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_eso"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof KechizuEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_kechizu"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (!(entity instanceof MimikoEntity) && !(entity instanceof NanakoEntity)) {
            if (entity instanceof NegiToshihisaEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entityiterator;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_toshihisa_negi"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }
            } else if (entity instanceof LarueEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entityiterator;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_larue"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }
            } else if (entity instanceof MiguelEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entityiterator;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_miguel_1"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }
            } else if (entity instanceof MiguelDancerEntity && entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_miguel_2"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_mimiko_nanako"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (entity instanceof ShigemoHarutaEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_haruta_shigemo"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof KumiyaJuzoEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_juzo_kumiya"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof OgamiEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_ogami"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof AwasakaJiroEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_jiro_awasaka"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (entity instanceof TakabaFumihikoEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_fumihiko_takaba"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof KurusuHanaEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hana_kurusu"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof HazenokiEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_iori_hazenoki"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof ReggieStarEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_reggie_star"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof DaidoHaganeEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hagane_daido"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof MiyoRokujushiEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_rokujushi_miyo"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (entity instanceof HigurumaHiromiEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hiromi_higuruma"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof DhruvLakdawallaEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_dhruv_lakdawalla"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof UroTakakoEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_takako_uro"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof IshigoriRyuEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_ryu_ishigori"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CharlesBernardEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_charles_bernard"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof KashimoHajimeEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hajime_kashimo"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof YorozuEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_yorozu"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if ((entity instanceof FushiguroTojiEntity || entity instanceof FushiguroTojiBugEntity) && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_toji_fushiguro"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_mahoraga"));
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
