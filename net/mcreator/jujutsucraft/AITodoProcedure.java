package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.TodoAoiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AITodoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double lv_st = (double)0.0F;
         double lv_df = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof TodoAoiEntity) {
               AIBoogieWoogieActiveProcedure.execute(world, x, y, z, entity);
            }

            label133: {
               lv_st = (double)11.0F;
               lv_df = (double)3.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label133;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)lv_st, false, false));
                  }
               }
            }

            label128: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label128;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)lv_df, false, false));
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
                  label156: {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof TodoAoiEntity) {
                        label145: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt14 = (LivingEntity)entity;
                              if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label145;
                              }
                           }

                           if (Math.random() < 0.05) {
                              if (!(entity instanceof LivingEntity)) {
                                 break label156;
                              }

                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (!_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 break label156;
                              }
                           }
                        }
                     }

                     if (entity instanceof TodoAoiEntity) {
                        label104: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt20 = (LivingEntity)entity;
                              if (_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label104;
                              }
                           }

                           if (Math.random() < 0.2 && distance > (double)8.0F && distance < (double)24.0F) {
                              entity.getPersistentData().m_128347_("skill", (double)Math.round(2006.0F));
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
                     }

                     if (entity instanceof TodoAoiEntity) {
                        label94: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt25 = (LivingEntity)entity;
                              if (_livEnt25.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label94;
                              }
                           }

                           if (Math.random() < 0.2 && distance < (double)8.0F) {
                              entity.getPersistentData().m_128347_("skill", (double)Math.round(2007.0F));
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
                     }

                     CalculateAttackProcedure.execute(world, entity);
                     return;
                  }

                  entity.getPersistentData().m_128347_("skill", (double)Math.round(2015.0F));
                  tick = (double)300.0F;
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
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
