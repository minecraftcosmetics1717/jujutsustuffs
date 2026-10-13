package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.PandaNormalEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIPandaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double strength = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            int var10000;
            if (entity instanceof PandaNormalEntity) {
               PandaNormalEntity _datEntI = (PandaNormalEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(PandaNormalEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               strength = (double)8.0F;
            } else {
               strength = (double)6.0F;
            }

            label134: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label134;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)strength, false, false));
                  }
               }
            }

            label129: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label129;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                  }
               }
            }

            LivingEntity var38;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var38 = _mobEnt.m_5448_();
            } else {
               var38 = null;
            }

            if (var38 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  int var39;
                  if (entity instanceof PandaNormalEntity) {
                     PandaNormalEntity _datEntI = (PandaNormalEntity)entity;
                     var39 = (Integer)_datEntI.m_20088_().m_135370_(PandaNormalEntity.DATA_form);
                  } else {
                     var39 = 0;
                  }

                  if (var39 == 0) {
                     float var40;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var40 = _livEnt.m_21223_();
                     } else {
                        var40 = -1.0F;
                     }

                     double var41 = (double)var40;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var41 < (double)var10001 * (double)0.5F) {
                        if (entity instanceof PandaNormalEntity) {
                           PandaNormalEntity _datEntSetI = (PandaNormalEntity)entity;
                           _datEntSetI.m_20088_().m_135381_(PandaNormalEntity.DATA_form, 1);
                        }

                        if (entity instanceof PandaNormalEntity) {
                           PandaNormalEntity animatable = (PandaNormalEntity)entity;
                           animatable.setTexture("panda_gorilla");
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21233_();
                           } else {
                              var10001 = -1.0F;
                           }

                           _entity.m_21153_(var10001);
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19600_);
                        }
                     }
                  }

                  label145: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt21 = (LivingEntity)entity;
                        if (_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label145;
                        }
                     }

                     if (entity instanceof PandaNormalEntity) {
                        PandaNormalEntity _datEntI = (PandaNormalEntity)entity;
                        var39 = (Integer)_datEntI.m_20088_().m_135370_(PandaNormalEntity.DATA_form);
                     } else {
                        var39 = 0;
                     }

                     if (var39 > 0 && distance < (double)6.0F && Math.random() < 0.15) {
                        rnd = (double)1606.0F;
                        level = (double)1.0F;
                        tick = (double)50.0F;
                     }
                  }

                  if (rnd > (double)0.0F) {
                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("skill", rnd);
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
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
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
