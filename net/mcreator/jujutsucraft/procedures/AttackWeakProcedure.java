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

public class AttackWeakProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         Entity target_entity = null;
         double CT2 = (double)0.0F;
         double CT1 = (double)0.0F;
         double dis = (double)0.0F;
         double energyMAX = (double)0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var20 = var10000;
         if (var20 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var20).m_20185_(), ((Entity)var20).m_20186_() + (double)((Entity)var20).m_20206_() * (double)0.5F, ((Entity)var20).m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt5") == (double)0.0F) {
            if (entity instanceof Player) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               CT1 = playerVars.PlayerCurseTechnique;
               CT2 = playerVars.PlayerCurseTechnique2;
               energyMAX = playerVars.PlayerCursePowerMAX;
            }

            if ((CT1 == (double)19.0F || CT2 == (double)19.0F) && LogicStartPassiveProcedure.execute(entity)) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)1.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)2.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 1, false, false));
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               Entity var19 = var10000;
               if (var19 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  dis = GetDistanceProcedure.execute(entity);
                  if (dis < (double)4.0F && ((Entity)var19).getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  if (energyMAX >= (double)100.0F) {
                     ChangeCurseEnergyProcedure.execute(entity, (double)-2.0F);
                  }

                  label95: {
                     label94: {
                        if (entity instanceof Player) {
                           if (CT1 == (double)12.0F || CT2 == (double)12.0F || CT1 == (double)21.0F || CT2 == (double)21.0F) {
                              break label94;
                           }
                        } else if (entity instanceof IshigoriRyuEntity) {
                           break label94;
                        }

                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)0.125F);
                        break label95;
                     }

                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)0.25F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * (double)0.5F, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ChargeParticleProcedure.execute(world, entity, (double)10.0F);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, (double)0.0F);
                  }
               }
            }
         }

         if (LogicRifleProcedure.execute(world, entity)) {
            AttackRifleProcedure.execute(world, entity);
         } else if (LogicSwordProcedure.execute(entity)) {
            AttackWeakSwordProcedure.execute(world, x, y, z, entity);
         } else {
            AttackWeakPunchProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
