package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ZeninRantaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIZeninRantaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            label108: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label108;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 10, false, false));
                  }
               }
            }

            label103: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label103;
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

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  if (LogicStartProcedure.execute(entity) && distance < (double)32.0F) {
                     rnd = (double)4610.0F;
                     tick = (double)125.0F;
                     entity.getPersistentData().m_128347_("skill", rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
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

         if (entity instanceof ZeninRantaEntity) {
            ZeninRantaEntity _datEntL16 = (ZeninRantaEntity)entity;
            if ((Boolean)_datEntL16.m_20088_().m_135370_(ZeninRantaEntity.DATA_damaged)) {
               float var37;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var37 = _livEnt.m_21223_();
               } else {
                  var37 = -1.0F;
               }

               double var38 = (double)var37;
               float var39;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var39 = _livEnt.m_21233_();
               } else {
                  var39 = -1.0F;
               }

               if (var38 > (double)var39 * 0.6) {
                  if (entity instanceof ZeninRantaEntity) {
                     ZeninRantaEntity _datEntSetL = (ZeninRantaEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(ZeninRantaEntity.DATA_damaged, false);
                  }

                  if (entity instanceof ZeninRantaEntity) {
                     ZeninRantaEntity animatable = (ZeninRantaEntity)entity;
                     animatable.setTexture("zenin_ranta");
                     return;
                  }
               }

               return;
            }
         }

         float var35;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var35 = _livEnt.m_21223_();
         } else {
            var35 = -1.0F;
         }

         double var36 = (double)var35;
         float var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21233_();
         } else {
            var10001 = -1.0F;
         }

         if (var36 < (double)var10001 * 0.3) {
            if (entity instanceof ZeninRantaEntity) {
               ZeninRantaEntity _datEntSetL = (ZeninRantaEntity)entity;
               _datEntSetL.m_20088_().m_135381_(ZeninRantaEntity.DATA_damaged, true);
            }

            if (entity instanceof ZeninRantaEntity) {
               ZeninRantaEntity animatable = (ZeninRantaEntity)entity;
               animatable.setTexture("zenin_ranta2");
            }
         }

      }
   }
}
