package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DebuggerJrRightClickedInAirProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("skill", (double)2020.0F);
         entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt3", (double)0.0F);
         entity.getPersistentData().m_128347_("Damage", (double)0.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
            }
         }

      }
   }
}
