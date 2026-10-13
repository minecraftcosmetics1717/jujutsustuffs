package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ShikigamiHeterocephalusGlaberEntity;
import net.mcreator.jujutsucraft.entity.ShikigamiPterosaurEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIDhruvrakdawalaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         Entity entity_b = null;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double old_tick = (double)0.0F;
         double old_level = (double)0.0F;
         if (entity.m_6084_()) {
            double var10000;
            label128: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                     var10000 = (double)_livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                     break label128;
                  }
               }

               var10000 = (double)0.0F;
            }

            label123: {
               old_level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                     var10000 = (double)_livEnt.m_21124_(MobEffects.f_19597_).m_19557_();
                     break label123;
                  }
               }

               var10000 = (double)0.0F;
            }

            old_tick = var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_(MobEffects.f_19597_);
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            if (old_tick > (double)0.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)old_tick, (int)old_level, false, false));
               }
            }

            label115: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19600_)) {
                     break label115;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 14, false, false));
                  }
               }
            }

            label110: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19606_)) {
                     break label110;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            LivingEntity var40;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var40 = _mobEnt.m_5448_();
            } else {
               var40 = null;
            }

            if (var40 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               label100: {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt14 = (LivingEntity)entity;
                     if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label100;
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt_target") % (double)10.0F == (double)7.0F) {
                     distance = GetDistanceProcedure.execute(entity);
                     if (distance > (double)6.0F && distance < (double)48.0F && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 12, 9, false, false));
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  if (LogicStartProcedure.execute(entity)) {
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("SHIKIGAMI_DHRUV2_1"));
                     entity_b = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("SHIKIGAMI_DHRUV1_1"));
                     if ((!(distance < (double)8.0F) || entity_b instanceof ShikigamiHeterocephalusGlaberEntity) && entity_a instanceof ShikigamiPterosaurEntity) {
                        if (!(entity_b instanceof ShikigamiHeterocephalusGlaberEntity)) {
                           rnd = (double)3705.0F;
                           tick = (double)250.0F;
                        }
                     } else {
                        rnd = (double)3706.0F;
                        tick = (double)150.0F;
                     }
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", rnd);
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
