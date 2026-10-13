package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TransformToSukunaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double level = (double)0.0F;
         double x_pos = (double)0.0F;
         double power = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (((Entity)var10000).m_6084_()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 20, false, false));
                  }
               }

               entity.getPersistentData().m_128379_("PRESS_Z", true);
            }
         }

         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            power = (double)Math.round(((double)20.0F - entity.getPersistentData().m_128459_("cnt1")) * (double)0.25F);
            STR1 = Component.m_237115_("jujutsu.message.long_press").getString();

            for(int index0 = 0; index0 < (int)power; ++index0) {
               STR1 = "■" + STR1 + "■";
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(STR1), true);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(""), true);
                  }
               }

               level = GetSukunaLevelProcedure.execute(entity);
               if (level > (double)0.0F) {
                  level = Math.min(Math.max(level, (double)1.0F), (double)20.0F) - (double)1.0F;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), 6000, (int)Math.round(level), false, false));
                     }
                  }
               }

               KeyResetTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get());
               }
            }
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(""), true);
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
