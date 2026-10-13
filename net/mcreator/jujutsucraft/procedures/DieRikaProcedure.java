package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.GarudaBallEntity;
import net.mcreator.jujutsucraft.entity.GarudaEntity;
import net.mcreator.jujutsucraft.entity.MoonDregsEntity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.entity.ShikigamiHeterocephalusGlaberEntity;
import net.mcreator.jujutsucraft.entity.ShikigamiPterosaurEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DieRikaProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double timer = (double)0.0F;
         double dis = (double)0.0F;
         double old_cool = (double)0.0F;
         if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
               if (entity instanceof MoonDregsEntity) {
                  timer = (double)600.0F;
               } else if (entity instanceof ShikigamiHeterocephalusGlaberEntity) {
                  timer = (double)600.0F;
               } else if (entity instanceof ShikigamiPterosaurEntity) {
                  timer = (double)400.0F;
               } else if (!(entity instanceof GarudaEntity) && !(entity instanceof GarudaBallEntity)) {
                  timer = entity.getPersistentData().m_128459_("despawn_flag") == (double)2.0F ? Math.max((double)200.0F, Math.min(entity.getPersistentData().m_128459_("cnt_connect") * (double)1.0F, (double)3600.0F)) : (double)3600.0F;
               } else {
                  timer = entity.getPersistentData().m_128459_("despawn_flag") == (double)2.0F ? (double)200.0F : (double)400.0F;
               }

               if (entity_a instanceof Player) {
                  Player _plr = (Player)entity_a;
                  if (_plr.m_150110_().f_35937_) {
                     timer = (double)20.0F;
                  }
               }

               old_cool = entity_a.getPersistentData().m_128459_("COOLDOWN_TICKS");
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(timer), 0, false, false));
                  }
               }

               entity_a.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
               if (entity instanceof RikaEntity && entity.getPersistentData().m_128459_("despawn_flag") == (double)1.0F && entity_a instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity_a;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_curseis_lifted"));
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
