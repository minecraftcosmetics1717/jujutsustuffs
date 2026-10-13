package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueSukunaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill <= (double)120.0F) {
            if (skill == (double)105.0F) {
               DismantleProcedure.execute(world, x, y, z, entity);
            } else if (skill == (double)106.0F) {
               CleaveProcedure.execute(world, entity);
            } else if (skill == (double)107.0F) {
               OpenProcedure.execute(world, entity);
            } else if (skill == (double)111.0F) {
               SkillSukunaCombo1Procedure.execute(world, x, y, z, entity);
            } else if (skill == (double)112.0F) {
               SkillSukunaCombo2Procedure.execute(world, x, y, z, entity);
            } else if (skill == (double)113.0F) {
               SkillSukunaCombo3Procedure.execute(world, x, y, z, entity);
            } else if (skill == (double)120.0F) {
               MalevolentShrineProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= (double)150.0F && skill < (double)200.0F) {
            if (skill < (double)160.0F) {
               if (skill == (double)150.0F) {
                  ZonbaProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)151.0F) {
                  TechniqueSkeleton1Procedure.execute(world, x, y, z, entity);
               } else if (skill == (double)152.0F) {
                  TechniqueSkullProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)153.0F) {
                  TechniqueScissorsProcedure.execute(world, entity);
               } else if (skill == (double)154.0F) {
                  SkillEnergyWave2Procedure.execute(world, x, y, z, entity);
               } else if (skill == (double)155.0F) {
                  TechniqueTamamonoMae1Procedure.execute(world, x, y, z, entity);
               } else if (skill == (double)156.0F) {
                  TechniqueTamamonomae2Procedure.execute(world, x, y, z, entity);
               } else if (skill == (double)157.0F) {
                  TechniqueFoxFireProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)158.0F) {
                  AttackPiecingOxProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)159.0F) {
                  TechniqueMucusProcedure.execute(world, x, y, z, entity);
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (skill < (double)170.0F) {
               if (skill == (double)160.0F) {
                  SkillGaneshaProcedure.execute(world, entity);
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
