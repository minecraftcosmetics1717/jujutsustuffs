package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AIRainbowDragonProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double rnd = (double)0.0F;
         double level_strength = (double)0.0F;
         double form = (double)0.0F;
         double tick = (double)0.0F;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            label101: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               level_strength = (double)9.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label101;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)level_strength, false, false));
                  }
               }
            }

            label96: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label96;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)1.0F) {
               AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  if (entity.getPersistentData().m_128459_("continue") > (double)0.0F) {
                     entity.getPersistentData().m_128347_("continue", entity.getPersistentData().m_128459_("continue") - (double)1.0F);
                     entity.getPersistentData().m_128347_("skill", (double)1.0F);
                  }

                  ResetCounterProcedure.execute(entity);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y + (double)entity.m_20206_() * (double)0.5F, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle firework ~ ~ ~ 1 1 1 0 10 force");
               }
            } else if (entity.getPersistentData().m_128459_("skill") == (double)2.0F) {
               AttackBiteProcedure.execute(world, x, y, z, entity);
            } else {
               if (!entity.m_20160_()) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                        ResetCounterProcedure.execute(entity);
                        if (!LogicCooldownCombatProcedure.execute(entity) && Math.random() < (double)0.25F) {
                           if (!(Math.random() < (double)0.5F) && !(GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)10.0F)) {
                              tick = (double)50.0F;
                              entity.getPersistentData().m_128347_("skill", (double)2.0F);
                           } else {
                              tick = (double)140.0F;
                              entity.getPersistentData().m_128347_("skill", (double)1.0F);
                              entity.getPersistentData().m_128347_("continue", (double)(Math.random() < (double)0.75F ? 1 : 0));
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                              }
                           }
                        } else {
                           CalculateAttackProcedure.execute(world, entity);
                        }
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  }
               }

               AIRideableControlProcedure.execute(entity);
            }
         }

      }
   }
}
