package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.NanamiKentoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class Attack4ConsecutiveAttacksProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         double strength = (double)0.0F;
         double d = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double weapon_size = (double)0.0F;
         double attack_reach = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double old_cnt1 = (double)0.0F;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         boolean sword = false;
         boolean attack = false;
         boolean keep = false;
         boolean attack_last = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         range = ReturnEntitySizeProcedure.execute(entity);
         sword = LogicSwordProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.m_20256_(new Vec3(entity.m_20184_().m_7096_() * (double)0.5F, Math.min(entity.m_20184_().m_7098_() * (double)0.5F, Math.min(entity.m_20184_().m_7098_(), 0.1)), entity.m_20184_().m_7094_() * (double)0.5F));
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
         old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
         old_skill = entity.getPersistentData().m_128459_("skill");
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(0.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().m_128459_("cnt5") <= (double)100.0F) {
            attack_last = entity.getPersistentData().m_128459_("cnt5") == (double)20.0F;
            attack = entity.getPersistentData().m_128459_("cnt5") == (double)1.0F || entity.getPersistentData().m_128459_("cnt5") == (double)5.0F || entity.getPersistentData().m_128459_("cnt5") == (double)9.0F || attack_last;
            if (attack || attack_last) {
               if (attack_last) {
                  entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), (double)100.0F));
                  entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)4.0F));
               } else {
                  entity.getPersistentData().m_128347_("cnt6", (double)2.0F + entity.getPersistentData().m_128459_("cnt5") * 0.05);
               }

               if (!attack_last) {
                  AttackWeakProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               } else {
                  if (LogicStartPassiveProcedure.execute(entity)) {
                     label57: {
                        if (entity instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)13.0F && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)13.0F) {
                              break label57;
                           }
                        } else if (!(entity instanceof NanamiKentoEntity)) {
                           break label57;
                        }

                        WeaponNanamiRightClickedInAirProcedure.execute(world, entity);
                     }
                  }

                  AttackStrongProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            entity.getPersistentData().m_128347_("cnt1", old_cnt1);
            entity.getPersistentData().m_128347_("skill", old_skill);
         } else if (entity.getPersistentData().m_128459_("cnt5") > (double)110.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
