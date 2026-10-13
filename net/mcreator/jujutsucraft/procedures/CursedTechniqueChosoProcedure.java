package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueChosoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)1005.0F) {
            TechniqueSlicingExorcismProcedure.execute(world, entity);
         } else if (skill == (double)1006.0F) {
            TechniqueConvergenceProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1007.0F) {
            PiercingBloodProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1008.0F) {
            SupernovaProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1009.0F) {
            TechniqueFlowingRedScaleProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1016.0F) {
            DagonWaterSkillProcedure.execute(world, entity);
         } else if (skill == (double)1018.0F) {
            TechniqueWingKingProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1019.0F) {
            KechizuPoizonProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1020.0F) {
            ChosoDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Choso"), false);
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
