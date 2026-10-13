package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class JunpeiDomainExpansionActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label50: {
            double distance = (double)0.0F;
            double old_skill = (double)0.0F;
            double ticks = (double)0.0F;
            range = (double)0.0F;
            double rad1 = (double)0.0F;
            double old_cooldown = (double)0.0F;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double x_center = (double)0.0F;
            double z_center = (double)0.0F;
            double y_center = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label50;
               }
            }

            var10000 = (double)0.0F;
         }

         double var31 = var10000;
         double var38 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var40 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var39 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (!entity.getPersistentData().m_128471_("Failed")) {
            double var33 = Math.toRadians((double)90.0F * (var31 % (double)4.0F));
            double var29 = (double)4.0F * var31 % (range * (double)0.5F - (double)5.0F);

            for(int index0 = 0; index0 < 4; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.8)) {
                     var33 += Math.toRadians((double)10.0F * Math.random());
                     double var35 = var38 + Math.cos(var33) * var29;
                     double var36 = var40 + 0.1;
                     double var37 = var39 + Math.sin(var33) * var29;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123771_, var35, var36, var37, 1, (double)0.5F, (double)1.0F, (double)0.5F, 0.05);
                     }
                  }
               }

               ++var29;
            }

            if (var31 % (double)40.0F == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
               entity.getPersistentData().m_128379_("StartDomainAttack", false);
               double var30 = entity.getPersistentData().m_128459_("skill");
               double var34 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)100.0F);
               entity.getPersistentData().m_128347_("skill", (double)3505.0F);
               entity.getPersistentData().m_128347_("Damage", (double)3.0F);
               entity.getPersistentData().m_128347_("Range", range);
               entity.getPersistentData().m_128347_("effect", (double)16.0F);
               entity.getPersistentData().m_128379_("swing", false);
               entity.getPersistentData().m_128379_("attack", false);
               entity.getPersistentData().m_128379_("onlyLiving", true);
               entity.getPersistentData().m_128379_("DomainAttack", true);
               RangeAttackProcedure.execute(world, var38, var40, var39, entity);
               entity.getPersistentData().m_128347_("skill", var30);
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var34);
            }
         }

      }
   }
}
