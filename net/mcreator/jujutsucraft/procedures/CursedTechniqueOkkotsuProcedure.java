package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOkkotsuProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)503.0F) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)504.0F) {
            AttackStrongOkkotsuProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)505.0F) {
            TechniqueImitation1Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)506.0F) {
            SkillDhruv3Procedure.execute(world, entity);
         } else if (skill == (double)507.0F) {
            ThinIceBreakerProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)510.0F) {
            TechniqueRika1Procedure.execute(world, entity);
         } else if (skill == (double)515.0F) {
            TechniquePureLoveProcedure.execute(world, entity);
         } else if (skill == (double)520.0F) {
            AuthenticMutualLoveProcedure.execute(world, x, y, z, entity);
         } else {
            TechniqueRika2Procedure.execute(world, x, y, z, entity);
         }

      }
   }
}
