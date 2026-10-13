package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class GuardEffectExpiresProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            entity.getPersistentData().m_128347_("Damage", (double)0.0F);
         }

         entity.getPersistentData().m_128379_("swing", false);
         entity.getPersistentData().m_128379_("guard", false);
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt4 = (LivingEntity)entity;
            if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
               return;
            }
         }

         if (!(entity instanceof Player)) {
            entity.m_20260_(false);
         }

      }
   }
}
