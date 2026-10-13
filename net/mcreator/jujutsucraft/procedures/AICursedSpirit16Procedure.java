package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit16Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_noSkill = false;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double skill_num = (double)0.0F;
         double distance = (double)0.0F;
         if (entity.m_6084_()) {
            label108: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                     break label108;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_(MobEffects.f_19596_);
            }

            label102: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label102;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            label97: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label97;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               if (entity.getPersistentData().m_128459_("cnt_target") % (double)5.0F == (double)4.0F) {
                  label85: {
                     label84: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt12 = (LivingEntity)entity;
                           if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                              break label84;
                           }
                        }

                        if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                           var29 = true;
                           break label85;
                        }
                     }

                     var29 = false;
                  }

                  logic_noSkill = var29;
                  if (logic_noSkill) {
                     distance = GetDistanceProcedure.execute(entity);
                     if (distance > (double)24.0F) {
                        if (Math.random() < (double)0.75F) {
                           entity.getPersistentData().m_128379_("PRESS_W", true);
                           entity.getPersistentData().m_128379_("PRESS_S", false);
                           skill_num = (double)1930.0F;
                        }
                     } else if (distance > (double)5.0F && Math.random() < (double)0.25F) {
                        entity.getPersistentData().m_128379_("PRESS_W", true);
                        entity.getPersistentData().m_128379_("PRESS_S", false);
                        skill_num = (double)1930.0F;
                     }

                     if (entity.getPersistentData().m_128459_("cnt_backstep") > (double)10.0F && Math.random() < (double)0.75F) {
                        entity.getPersistentData().m_128379_("PRESS_W", false);
                        entity.getPersistentData().m_128379_("PRESS_S", true);
                        skill_num = (double)1930.0F;
                     }
                  }

                  if (skill_num != (double)0.0F) {
                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("skill", skill_num);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
