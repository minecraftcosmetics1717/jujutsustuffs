package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOnPotionActivetick2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)1000.0F);
         if (skill >= (double)500.0F) {
            if (skill >= (double)1000.0F) {
               CursedTechniqueOnPotionActiveTick3Procedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)900.0F) {
               CursedTechniqueNaoyaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)800.0F) {
               CursedTechniqueGetoProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)700.0F) {
               CursedTechniqueTakabaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)600.0F) {
               CursedTechniqueMahoragaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)500.0F) {
               CursedTechniqueMahitoProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= (double)400.0F) {
            CursedTechniqueHanamiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)300.0F) {
            CursedTechniqueNanamiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)200.0F) {
            CursedTechniqueIshigoriProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)100.0F) {
            CursedTehcniqueMeiMeiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)0.0F) {
            CursedTechniqueChosoProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
