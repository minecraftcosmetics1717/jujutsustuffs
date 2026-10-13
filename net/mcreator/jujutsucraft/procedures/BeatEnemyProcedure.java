package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.DagonEntity;
import net.mcreator.jujutsucraft.entity.HanamiEntity;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.RozetsuEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.entity.UraumeEntity;
import net.mcreator.jujutsucraft.entity.ZeninNaoyaCursedSpiritEntity;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class BeatEnemyProcedure {
   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         if (entity instanceof HanamiEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hanami"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof DagonEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_dagon"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof JogoEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_jogo"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof MahitoEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_mahito"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof KenjakuEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_kenjaku"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (entity instanceof RozetsuEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_rozetsu"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (entity instanceof UraumeEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_uraume"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof SukunaEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_sukuna"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof SukunaFushiguroEntity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_sukuna_2"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }

            if (entity instanceof SukunaFushiguroEntity) {
               SukunaFushiguroEntity _datEntL18 = (SukunaFushiguroEntity)entity;
               if ((Boolean)_datEntL18.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode) && entityiterator instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entityiterator;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_sukuna_3"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }
            }
         } else if (entity instanceof SukunaPerfectEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_sukuna_3"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (entity instanceof ZeninNaoyaCursedSpiritEntity && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_naoya_zenin_cursed_spirit"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         BeatSpecialGradeProcedure.execute(entity, entityiterator);
      }
   }
}
