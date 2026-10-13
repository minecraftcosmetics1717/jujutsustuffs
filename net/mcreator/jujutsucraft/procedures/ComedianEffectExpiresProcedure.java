package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.entity.TakabaFumihikoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class ComedianEffectExpiresProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double old_cool = (double)0.0F;
         JujutsucraftMod.queueServerWork(1, () -> {
            if (entity instanceof LivingEntity _livEnt0) {
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                  return;
               }
            }

            if (entity instanceof Player) {
               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)17.0F && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)17.0F) {
                  return;
               }
            } else if (!(entity instanceof TakabaFumihikoEntity)) {
               return;
            }

            entity.getPersistentData().m_128347_("COOLDOWN_TICKS_OLD", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            if (entity instanceof LivingEntity _entity) {
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1800, 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS_OLD"));
         });
      }
   }
}
