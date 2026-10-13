package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class OgiDomainActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label56: {
            double distance = (double)0.0F;
            double old_skill = (double)0.0F;
            range = (double)0.0F;
            double rad1 = (double)0.0F;
            double old_cooldown = (double)0.0F;
            double x_pos = (double)0.0F;
            double tick = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label56;
               }
            }

            var10000 = (double)0.0F;
         }

         double var35 = var10000;
         if (entity.getPersistentData().m_128471_("Failed")) {
            if (entity.m_20096_() && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, 20, (double)1.0F, (double)0.0F, (double)1.0F, 0.05);
            }
         } else {
            double var32 = Math.toRadians((double)90.0F * (var35 % (double)4.0F));
            double var29 = (double)4.0F * var35 % (range * (double)0.5F - (double)5.0F);

            for(int index0 = 0; index0 < 5; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.9)) {
                     var32 += Math.toRadians((double)10.0F * Math.random());
                     double var34 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.cos(var32) * var29;
                     double var36 = entity.getPersistentData().m_128459_("y_pos_doma") + 0.1;
                     double var37 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.sin(var32) * var29;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), var34, var36, var37, 1, 0.2, 0.1, 0.2, 0.05);
                     }
                  }
               }

               ++var29;
            }

            if (var35 % (double)20.0F == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
               entity.getPersistentData().m_128379_("StartDomainAttack", false);
               double var30 = entity.getPersistentData().m_128459_("skill");
               double var33 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)60.0F);
               entity.getPersistentData().m_128347_("skill", (double)406.0F);
               entity.getPersistentData().m_128347_("Damage", (double)9.0F);
               entity.getPersistentData().m_128347_("Range", range);
               entity.getPersistentData().m_128347_("effect", (double)6.0F);
               entity.getPersistentData().m_128379_("swing", false);
               entity.getPersistentData().m_128379_("attack", false);
               entity.getPersistentData().m_128379_("DomainAttack", true);
               RangeAttackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
               entity.getPersistentData().m_128347_("skill", var30);
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var33);
            }
         }

      }
   }
}
