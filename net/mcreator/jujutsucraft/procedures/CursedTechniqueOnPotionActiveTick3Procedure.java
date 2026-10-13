package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOnPotionActiveTick3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)2000.0F);
         if (skill >= (double)2500.0F) {
            if (skill >= (double)2900.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (skill >= (double)2800.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (skill >= (double)2700.0F) {
               CursedTechniqueCrystalProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)2600.0F) {
               CursedTechniqueRantaZeninProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)2500.0F) {
               CursedTechniqueHazenokiProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= (double)2000.0F) {
            if (skill >= (double)2400.0F) {
               CursedTechniqueReggieStarProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)2300.0F) {
               CursedTechniqueRozetsuProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)2200.0F) {
               CursedTechniqueCombatProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)2100.0F) {
               CursedTechniqueKaoriProcedure.execute(world, entity);
            } else if (skill >= (double)2000.0F) {
               CursedTechniqueInoProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= (double)1500.0F) {
            if (skill >= (double)1900.0F) {
               CursedTechniqueYorozuProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1800.0F) {
               CursedTechniqueTakakoUroProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1700.0F) {
               CursedTechniqueDhruvProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1600.0F) {
               CursedTechniqueNishimiyaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1500.0F) {
               CursedTechniqueJunpeProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= (double)1000.0F) {
            if (skill >= (double)1400.0F) {
               CursedTechniqueKugisakiProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1300.0F) {
               CursedTechniqueYagaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1200.0F) {
               CursedTechniqueChojuroProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1100.0F) {
               CursedTechniqueKusakabeProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)1000.0F) {
               CursedTechniqueMiguelProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= (double)500.0F) {
            if (skill >= (double)900.0F) {
               CursedTechniqueHakariProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)800.0F) {
               CursedTechniqueAngelProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)700.0F) {
               CursedTechniqueHigurumaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)600.0F) {
               CursedTechniqueOgiProcedure.execute(world, x, y, z, entity);
            } else if (skill >= (double)500.0F) {
               CursedTechniqueSmallpoxDeityProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= (double)400.0F) {
            CursedTechniqueUraumeProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)300.0F) {
            CursedTechniqueKurourushiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)200.0F) {
            CursedTechniqueJjnichiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)100.0F) {
            CursedTechniqueItadoriProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)0.0F) {
            CursedTechniqueTodoProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
