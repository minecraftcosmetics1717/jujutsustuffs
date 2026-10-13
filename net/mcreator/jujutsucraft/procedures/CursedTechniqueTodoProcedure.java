package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueTodoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)2003.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)2004.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)2005.0F) {
            SkillBoogieWoogieProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else if (skill == (double)2006.0F) {
            LariatProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)2007.0F) {
            Attack4ConsecutiveAttacksProcedure.execute(world, entity);
         } else if (skill == (double)2015.0F) {
            AttackTodoBlackFlashProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)2020.0F) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Todo"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

      }
   }
}
