package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.KusakabeAtsuyaEntity;
import net.mcreator.jujutsucraft.entity.MiwaKasumiEntity;
import net.mcreator.jujutsucraft.entity.ZeninOgiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CounterProcedure {
   public static void execute(Entity counter_entity) {
      if (counter_entity != null) {
         Entity entity_a = null;
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         if (counter_entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            pVars = (JujutsucraftModVariables.PlayerVariables)counter_entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            T1 = pVars.PlayerCurseTechnique;
            T2 = pVars.PlayerCurseTechnique2;
         }

         label93: {
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)counter_entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                  if (counter_entity instanceof Player) {
                     if (T1 == (double)26.0F || T2 == (double)26.0F) {
                        break label93;
                     }
                  } else if (counter_entity instanceof ZeninOgiEntity) {
                     break label93;
                  }
               }
            }

            int var10000;
            label75: {
               if (counter_entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)counter_entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                     break label75;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 0) {
               return;
            }

            if (counter_entity instanceof Player) {
               if (T1 != (double)31.0F && T2 != (double)31.0F) {
                  return;
               }
            } else if (!(counter_entity instanceof KusakabeAtsuyaEntity) && !(counter_entity instanceof MiwaKasumiEntity)) {
               return;
            }
         }

         if (counter_entity instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)counter_entity;
            if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get()) && counter_entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)counter_entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
            }
         }

         int var16;
         label61: {
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)counter_entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var16 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                  break label61;
               }
            }

            var16 = 0;
         }

         if (var16 > 0 && counter_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)counter_entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
         }

         if (counter_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)counter_entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 15, 1, false, false));
            }
         }

         if (counter_entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            counter_entity.getPersistentData().m_128347_("skill", (double)101.0F);
            counter_entity.getPersistentData().m_128347_("cnt1", (double)7.0F);
            counter_entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            counter_entity.getPersistentData().m_128347_("cnt3", (double)0.0F);
            counter_entity.getPersistentData().m_128347_("cnt4", (double)0.0F);
            counter_entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
            counter_entity.getPersistentData().m_128347_("cnt6", (double)1.0F);
            counter_entity.getPersistentData().m_128347_("cnt7", (double)0.0F);
            counter_entity.getPersistentData().m_128347_("cnt8", (double)0.0F);
            counter_entity.getPersistentData().m_128347_("cnt9", (double)0.0F);
            counter_entity.getPersistentData().m_128347_("cnt10", (double)0.0F);
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)counter_entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
               }
            }
         }

      }
   }
}
