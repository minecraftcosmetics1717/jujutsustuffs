package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TodoAoiRightClickedOnEntityProcedure {
   public static void execute(Entity sourceentity) {
      if (sourceentity != null) {
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)sourceentity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               return;
            }
         }

         if ((((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)21.0F || ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)21.0F) && sourceentity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)sourceentity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_deep_concentration"));
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
