package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
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
import net.minecraft.world.entity.player.Player;

public class ZoneEffectStartedappliedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double var10000;
         label55: {
            double level = (double)0.0F;
            double tick = (double)0.0F;
            double cursed_technique2 = (double)0.0F;
            double cursed_technique = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
                  break label55;
               }
            }

            var10000 = (double)0.0F;
         }

         double var14;
         label50: {
            var14 = var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19557_();
                  break label50;
               }
            }

            var10000 = (double)0.0F;
         }

         double var15 = var10000;
         if (var15 >= (double)20.0F) {
            entity.getPersistentData().m_128347_("Life", (double)1.0F);
            if (entity instanceof Player) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + (double)250.0F + var14 * (double)50.0F;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }
         }

         if (entity instanceof Player && Math.random() < 0.2) {
            double var17 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            double var16 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            if ((var17 == (double)21.0F || var16 == (double)21.0F) && ReturnInsideItemProcedure.execute(entity).m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get() && entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_itadori"));
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
