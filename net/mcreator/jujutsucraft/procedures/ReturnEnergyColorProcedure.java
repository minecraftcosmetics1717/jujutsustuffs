package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade01Entity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.entity.ZeninMakiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ReturnEnergyColorProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               return (double)2.0F;
            }
         }

         if (!(entity instanceof CursedSpiritGrade01Entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  return (double)4.0F;
               }
            }

            if (entity instanceof Player) {
               JujutsucraftModVariables.PlayerVariables pVars = null;
               if (entity instanceof Player) {
                  pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
               }

               T1 = pVars.PlayerCurseTechnique;
               T2 = pVars.PlayerCurseTechnique2;
               if (pVars.PlayerCursePowerMAX <= (double)150.0F) {
                  return (double)0.0F;
               }

               if (T1 == (double)5.0F || T2 == (double)5.0F) {
                  return (double)3.0F;
               }
            } else {
               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power"))) || entity instanceof ZeninMakiEntity) {
                  return (double)0.0F;
               }

               if (entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof RikaEntity || entity instanceof Rika2Entity) {
                  return (double)3.0F;
               }
            }

            if (entity.getPersistentData().m_128471_("CursedSpirit")) {
               return (double)5.0F;
            } else {
               return (double)1.0F;
            }
         } else {
            return (double)2.0F;
         }
      }
   }
}
