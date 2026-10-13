package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BulletBallCanUseRangedItemProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         label32: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  break label32;
               }
            }

            if (!(entity instanceof LivingEntity)) {
               return;
            }

            LivingEntity _livEnt1 = (LivingEntity)entity;
            if (!_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || !entity.getPersistentData().m_128471_("Failed") && entity.getPersistentData().m_128459_("Reserve") == (double)0.0F) {
               return;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_(itemstack.m_41720_(), 5);
         }

      }
   }
}
