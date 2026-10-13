package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOgiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)2600.0F);
         if (skill != (double)20.0F) {
            CompoundTag var10000 = entity.getPersistentData();
            float var10004;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10004 = _livEnt.m_21223_();
            } else {
               var10004 = -1.0F;
            }

            float var10005;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10005 = _livEnt.m_21233_();
            } else {
               var10005 = -1.0F;
            }

            var10000.m_128347_("cnt10", (double)1.5F * (double)(1.0F - var10004 / var10005));
         }

         if (skill == (double)5.0F) {
            TechniqueBlazingCourageProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)11.0F) {
            TechniqueOgi1Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)12.0F) {
            TechniqueOgi2Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)13.0F) {
            TechniqueOgi3Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)14.0F) {
            TechniqueOgi4Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)15.0F) {
            TechniqueOgi5Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)19.0F) {
            TechniqueOgi9Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)20.0F) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
