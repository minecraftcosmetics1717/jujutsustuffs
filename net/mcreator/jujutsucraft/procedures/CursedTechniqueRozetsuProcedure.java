package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueRozetsuProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)4300.0F);
         if (skill == (double)3.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)4.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)5.0F) {
            SkillRozetsuShikigami1Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)6.0F) {
            SkillRozetsuShikigami2Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)7.0F) {
            SkillRozetsuShikigami3Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)20.0F) {
            RozetsuDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)30.0F) {
            TechniqueHanakoHandProcedure.execute(world, entity);
         } else if (skill == (double)31.0F) {
            TechniqueHanakoHand2Procedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Rozetsu"), false);
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
