package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SelfEmbodimentOfPerfectionActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         int var10000;
         label23: {
            double old_skill = (double)0.0F;
            range = (double)0.0F;
            double old_cooldown = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label23;
               }
            }

            var10000 = 0;
         }

         if (var10000 % 40 == 20 || entity.getPersistentData().m_128471_("StartDomainAttack")) {
            entity.getPersistentData().m_128379_("StartDomainAttack", false);
            double var9 = entity.getPersistentData().m_128459_("skill");
            double var11 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)50.0F);
            entity.getPersistentData().m_128347_("skill", (double)1505.0F);
            entity.getPersistentData().m_128347_("Damage", (double)24.0F);
            entity.getPersistentData().m_128347_("Range", range);
            entity.getPersistentData().m_128347_("effect", (double)12.0F);
            entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
            entity.getPersistentData().m_128347_("knockback", (double)0.0F);
            entity.getPersistentData().m_128379_("swing", false);
            entity.getPersistentData().m_128379_("attack", false);
            entity.getPersistentData().m_128379_("onlyLiving", true);
            entity.getPersistentData().m_128379_("DomainAttack", true);
            RangeAttackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
            entity.getPersistentData().m_128347_("skill", var9);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var11);
            entity.getPersistentData().m_128379_("onlyLiving", false);
         }

      }
   }
}
