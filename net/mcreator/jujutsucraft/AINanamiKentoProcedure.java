package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AINanamiKentoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         if (entity.m_6084_()) {
            label131: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("cnt_nanami", entity.getPersistentData().m_128459_("cnt_nanami") + (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label131;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 10, false, false));
                  }
               }
            }

            label138: {
               if (world instanceof Level) {
                  Level _lvl5 = (Level)world;
                  if (_lvl5.m_46461_()) {
                     break label138;
                  }
               }

               int var10000;
               label124: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label124;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 <= 11 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 100, 11, false, false));
                  }
               }
            }

            label116: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                     break label116;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            LivingEntity var33;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var33 = _mobEnt.m_5448_();
            } else {
               var33 = null;
            }

            if (var33 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  if (LogicStartPassiveProcedure.execute(entity) && entity.getPersistentData().m_128459_("cnt_nanami") > (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_nanami", (double)-60.0F);
                     WeaponNanamiRightClickedInAirProcedure.execute(world, entity);
                  }

                  if (LogicStartProcedure.execute(entity) && Math.random() > 0.9 && distance < (double)36.0F && entity.getPersistentData().m_128459_("cnt_target") > (double)600.0F) {
                     float var34;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var34 = _livEnt.m_21223_();
                     } else {
                        var34 = -1.0F;
                     }

                     double var35 = (double)var34;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var35 < (double)var10001 * (double)0.5F) {
                        rnd = (double)10.0F;
                        tick = (double)200.0F;
                        entity.getPersistentData().m_128347_("skill", (double)1300.0F + rnd);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                              return;
                           }
                        }

                        return;
                     }
                  }

                  label98: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt25 = (LivingEntity)entity;
                        if (_livEnt25.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label98;
                        }
                     }

                     if (Math.random() < 0.2 && distance < (double)8.0F) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1307.0F));
                        tick = (double)50.0F;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              return;
                           }
                        }

                        return;
                     }
                  }

                  CalculateAttackProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
