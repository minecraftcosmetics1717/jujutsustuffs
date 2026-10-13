package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;

public class PlayerSetProfessionProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double profession = (double)0.0F;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
         }

         profession = pVars.PlayerProfession;
         entity.getPersistentData().m_128379_("JujutsuSorcerer", false);
         entity.getPersistentData().m_128379_("CurseUser", false);
         entity.getPersistentData().m_128379_("CursedSpirit", false);
         if (profession == (double)-2.0F) {
            entity.getPersistentData().m_128379_("CursedSpirit", true);
            entity.getPersistentData().m_128379_("CurseUser", true);
         } else if (profession == (double)-1.0F) {
            entity.getPersistentData().m_128379_("CursedSpirit", true);
         } else if (profession == (double)1.0F) {
            entity.getPersistentData().m_128379_("CurseUser", true);
         } else {
            entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
         }

         if (profession == (double)0.0F) {
            entity.getPersistentData().m_128379_("NonSorcerer", true);
         } else {
            entity.getPersistentData().m_128379_("NonSorcerer", false);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity10 = (LivingEntity)entity;
            if (_livingEntity10.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.PROFESSION.get())) {
               _livingEntity10.m_21051_((Attribute)JujutsucraftModAttributes.PROFESSION.get()).m_22100_(profession);
            }
         }

      }
   }
}
