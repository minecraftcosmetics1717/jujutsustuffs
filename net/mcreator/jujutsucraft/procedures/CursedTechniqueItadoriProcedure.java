package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueItadoriProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double level = (double)0.0F;
         double x_pos = (double)0.0F;
         double power = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)2100.0F);
         if (skill == (double)5.0F) {
            DivergentFistProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)6.0F) {
            Attack4ConsecutiveAttacksProcedure.execute(world, entity);
         } else if (skill == (double)8.0F) {
            CleaveProcedure.execute(world, entity);
         } else if (skill == (double)13.0F) {
            PiercingBloodProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)14.0F) {
            SuperNovaItadoriProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)18.0F) {
            DeepConcentrationItadoriProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)19.0F) {
            TransformToSukunaProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)20.0F) {
            ItadoriDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
