package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade011Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade012Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade013Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade02Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade03Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade04Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade05Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade06Entity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class BeatSpecialGradeProcedure {
   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         if (entity instanceof CursedSpiritGrade010Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_2"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade04Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_3"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade011Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_6"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade02Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_7"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade012Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_9"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade05Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_10"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade013Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_11"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade06Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_13"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade03Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_15"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         } else if ((entity instanceof RikaEntity || entity instanceof Rika2Entity) && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_cursed_spirit_grade_special_16"));
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
