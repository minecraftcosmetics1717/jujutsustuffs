package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.IshigoriRyuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class AttackStrongProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         Entity target_entity = null;
         double CT2 = 0.0D;
         double CT1 = 0.0D;
         double dis = 0.0D;
         double energyMAX = 0.0D;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var20 = var10000;
         if (var20 instanceof LivingEntity) {
            RotateEntityProcedure.execute(var20.getX(), var20.getY() + (double)var20.getBbHeight() * 0.5D, var20.getZ(), entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 7.0D) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 1, false, false));
               }
            }

            if (entity instanceof Player) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               CT1 = playerVars.PlayerCurseTechnique;
               CT2 = playerVars.PlayerCurseTechnique2;
               energyMAX = playerVars.PlayerCursePowerMAX;
            }

            if ((CT1 == 19.0D || CT2 == 19.0D) && LogicStartPassiveProcedure.execute(entity)) {
               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 7.0D));
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 6.0D) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               Entity var19 = var10000;
               if (var19 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  dis = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  if (dis < 4.0D && var19.getPersistentData().getDouble("skill") == 0.0D) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0D) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 6.0D));
               }

               if (entity.getPersistentData().getDouble("cnt6") < 5.0D) {
                  if (energyMAX >= 100.0D) {
                     ChangeCurseEnergyProcedure.execute(entity, -2.0D);
                  }

                  label95: {
                     label94: {
                        if (entity instanceof Player) {
                           if (CT1 == 12.0D || CT2 == 12.0D || CT1 == 21.0D || CT2 == 21.0D) {
                              break label94;
                           }
                        } else if (entity instanceof IshigoriRyuEntity) {
                           break label94;
                        }

                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.125D);
                        break label95;
                     }

                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.25D);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0D) {
                     entity.getPersistentData().putDouble("cnt6", 5.0D);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x, y + (double)entity.getBbHeight() * 0.5D, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0D) {
                     ChargeParticleProcedure.execute(world, entity, 10.0D);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0D);
                  }
               }
            }
         }

         if (LogicRifleProcedure.execute(world, entity)) {
            AttackRifleProcedure.execute(world, entity);
         } else if (LogicSwordProcedure.execute(entity)) {
            AttackStrongSwordProcedure.execute(world, x, y, z, entity);
         } else {
            AttackStrongPunchProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}