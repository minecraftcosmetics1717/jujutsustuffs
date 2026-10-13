package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ChosoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIChosoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean choso = false;
         boolean blood_ball = false;
         double rnd = (double)0.0F;
         double lv_st = (double)0.0F;
         double lv_df = (double)0.0F;
         double tick = (double)0.0F;
         double NUM1 = (double)0.0F;
         double distance = (double)0.0F;
         double old_cool = (double)0.0F;
         choso = entity instanceof ChosoEntity;
         if (entity.m_6084_()) {
            if (entity.m_20071_()) {
               old_cool = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            if (choso) {
               lv_st = (double)11.0F;
               lv_df = (double)3.0F;
            } else {
               lv_st = (double)8.0F;
               lv_df = (double)2.0F;
            }

            label156: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                     break label156;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)lv_st, false, false));
                  }
               }
            }

            label151: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                     break label151;
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
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  NUM1 = (double)0.0F;
                  distance = GetDistanceProcedure.execute(entity);
                  blood_ball = LocateBloodBallProcedure.execute(world, x, y, z, entity);

                  for(int index0 = 0; index0 < 128; ++index0) {
                     rnd = (double)(4L + Math.round(Math.random() * (double)15.0F));
                     ++NUM1;
                     if (rnd == (double)5.0F) {
                        tick = (double)60.0F;
                        if (!(distance < (double)8.0F)) {
                           break;
                        }
                     } else if (rnd == (double)6.0F) {
                        tick = (double)10.0F;
                        if (choso && !(distance < (double)5.0F) && !blood_ball) {
                           break;
                        }
                     } else if (rnd == (double)7.0F) {
                        tick = (double)100.0F;
                        if (!(distance < (double)5.0F)) {
                           break;
                        }
                     } else if (rnd == (double)8.0F) {
                        tick = (double)50.0F;
                        if (choso && !(distance > (double)8.0F) && blood_ball) {
                           break;
                        }
                     } else if (rnd == (double)16.0F) {
                        tick = (double)200.0F;
                        if (choso && !(Math.random() > (double)0.25F)) {
                           float var44;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var44 = _livEnt.m_21223_();
                           } else {
                              var44 = -1.0F;
                           }

                           double var45 = (double)var44;
                           float var10001;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21233_();
                           } else {
                              var10001 = -1.0F;
                           }

                           if (!(var45 > (double)var10001 * (double)0.5F)) {
                              break;
                           }
                        }
                     } else if (rnd == (double)18.0F) {
                        tick = (double)75.0F;
                        if (choso) {
                           float var46;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var46 = _livEnt.m_21223_();
                           } else {
                              var46 = -1.0F;
                           }

                           double var47 = (double)var46;
                           float var48;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var48 = _livEnt.m_21233_();
                           } else {
                              var48 = -1.0F;
                           }

                           if (!(var47 > (double)var48 * (double)0.5F)) {
                              break;
                           }
                        }
                     }
                  }

                  if (LogicStartProcedure.execute(entity) && Math.random() < (double)0.5F && NUM1 < (double)50.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)1000.0F + rnd);
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

      }
   }
}
