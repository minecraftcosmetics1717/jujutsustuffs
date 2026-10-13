package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class GuardSetDamageProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         CompoundTag var10000;
         int var10003;
         label15: {
            var10000 = entity.getPersistentData();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                  var10003 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                  break label15;
               }
            }

            var10003 = 0;
         }

         var10000.m_128347_("Damage", (double)(9 + var10003 * 6));
         entity.getPersistentData().m_128379_("attack", false);
         entity.getPersistentData().m_128379_("swing", true);
         DamageFixProcedure.execute(entity);
         entity.getPersistentData().m_128379_("guard", true);
      }
   }
}
