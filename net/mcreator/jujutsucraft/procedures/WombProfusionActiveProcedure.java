package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class WombProfusionActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double var10000;
         label52: {
            double d_bonus = (double)0.0F;
            double old_skill = (double)0.0F;
            double count_A = (double)0.0F;
            double num1 = (double)0.0F;
            double range = (double)0.0F;
            double old_cooldown = (double)0.0F;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double num2 = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label52;
               }
            }

            var10000 = (double)0.0F;
         }

         double var25 = var10000;
         if (var25 % (double)80.0F < (double)15.0F) {
            int var10001;
            label45: {
               var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                     break label45;
                  }
               }

               var10001 = 0;
            }

            double var28 = var10000 * (double)(var10001 > 0 ? 9 : 2);
            double var24 = entity.getPersistentData().m_128459_("skill");
            double var29 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            entity.getPersistentData().m_128347_("y_knockback", (double)-1.0F);
            double var23 = var25 % (double)80.0F + (double)1.0F;
            var25 = (double)0.0F;

            for(int index0 = 0; index0 < 4; ++index0) {
               double var27 = var25 % (double)2.0F == (double)0.0F ? (double)1.0F : (double)-1.0F;
               double var33 = var25 % (double)4.0F <= (double)1.0F ? (double)1.0F : (double)-1.0F;
               double var30 = entity.getPersistentData().m_128459_("x_pos_doma") + var28 * (double)0.25F * var27;
               double var31 = entity.getPersistentData().m_128459_("y_pos_doma") + var28 * (double)0.25F - (double)8.0F;
               double var32 = entity.getPersistentData().m_128459_("z_pos_doma") + var28 * (double)0.25F * var33;
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)100.0F);
               entity.getPersistentData().m_128347_("skill", (double)4110.0F);
               entity.getPersistentData().m_128347_("Damage", (double)15.0F + var23 * (double)0.5F);
               entity.getPersistentData().m_128347_("Range", var28 * (double)0.5F);
               entity.getPersistentData().m_128347_("effect", (double)13.0F);
               entity.getPersistentData().m_128347_("knockback", 0.001);
               entity.getPersistentData().m_128379_("swing", false);
               entity.getPersistentData().m_128379_("attack", false);
               entity.getPersistentData().m_128379_("DomainAttack", true);
               RangeAttackProcedure.execute(world, var30, var31, var32, entity);
               ++var25;
            }

            entity.getPersistentData().m_128347_("skill", var24);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var29);
         }

      }
   }
}
