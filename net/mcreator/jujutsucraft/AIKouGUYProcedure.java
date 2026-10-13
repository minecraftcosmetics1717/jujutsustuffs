package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade211Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade212Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade213Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade214Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade215Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade217Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade218Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade21Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade22Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade23Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade24Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade25Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade26Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade28Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade29Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIKouGUYProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double lv_resistance = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double lv_strength = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof CursedSpiritGrade29Entity) {
               AIActiveFlyingProcedure.execute(world, entity);
            }

            if (entity instanceof CursedSpiritGrade22Entity) {
               lv_strength = (double)8.0F;
               lv_resistance = (double)2.0F;
            } else if (!(entity instanceof CursedSpiritGrade26Entity) && !(entity instanceof CursedSpiritGrade213Entity)) {
               if (!(entity instanceof CursedSpiritGrade21Entity) && !(entity instanceof CursedSpiritGrade23Entity) && !(entity instanceof CursedSpiritGrade24Entity) && !(entity instanceof CursedSpiritGrade25Entity) && !(entity instanceof CursedSpiritGrade28Entity) && !(entity instanceof CursedSpiritGrade29Entity) && !(entity instanceof CursedSpiritGrade211Entity) && !(entity instanceof CursedSpiritGrade212Entity) && !(entity instanceof CursedSpiritGrade214Entity) && !(entity instanceof CursedSpiritGrade215Entity) && !(entity instanceof CursedSpiritGrade217Entity) && !(entity instanceof CursedSpiritGrade218Entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 10, false, false));
                     }
                  }

                  label134: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt18 = (LivingEntity)entity;
                        if (_livEnt18.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                           break label134;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19597_);
                     }
                  }

                  lv_strength = (double)5.0F;
                  lv_resistance = (double)1.0F;
               } else {
                  lv_strength = (double)6.0F;
                  lv_resistance = (double)1.0F;
               }
            } else {
               lv_strength = (double)7.0F;
               lv_resistance = (double)1.0F;
            }

            label127: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt20 = (LivingEntity)entity;
                  if (_livEnt20.m_21023_(MobEffects.f_19600_)) {
                     break label127;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)lv_strength, false, false));
                  }
               }
            }

            label122: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt22 = (LivingEntity)entity;
                  if (_livEnt22.m_21023_(MobEffects.f_19606_)) {
                     break label122;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)lv_resistance, false, false));
                  }
               }
            }

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
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof CursedSpiritGrade26Entity) {
                     label168: {
                        distance = GetDistanceProcedure.execute(entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt32 = (LivingEntity)entity;
                           if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label168;
                           }
                        }

                        if (distance < (double)32.0F && Math.random() < (double)0.5F) {
                           entity.getPersistentData().m_128347_("skill", (double)Math.round(1615.0F));
                           level = (double)1.0F;
                           tick = (double)150.0F;
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("skill") != (double)0.0F) {
                     label175: {
                        if (level > (double)0.0F) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt35 = (LivingEntity)entity;
                              if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label175;
                              }
                           }
                        } else if (!LogicStartProcedure.execute(entity)) {
                           break label175;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }

                        if (level > (double)0.0F) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              }

                              return;
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }

                           return;
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
