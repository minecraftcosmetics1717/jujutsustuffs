package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueUraumeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)2400.0F);
         if (skill == (double)5.0F) {
            IceSpearSkillProcedure.execute(world, entity);
         } else if (skill == (double)6.0F) {
            UraumeSkill1Procedure.execute(world, entity);
         } else if (skill == (double)8.0F) {
            FrostCalmProcedure.execute(world, entity);
         } else if (skill == (double)9.0F) {
            IcefallProcedure.execute(world, entity);
         } else if (skill == (double)20.0F) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
