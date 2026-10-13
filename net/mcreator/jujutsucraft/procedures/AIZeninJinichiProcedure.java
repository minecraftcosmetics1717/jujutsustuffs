package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityEyeRantaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIZeninJinichiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double level = (double)0.0F;
         double distance = (double)0.0F;
         Entity entity_target = null;
         if (entity.m_6084_()) {
            label114: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label114;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 11, false, false));
                  }
               }
            }

            label109: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label109;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
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

            Entity var20 = var10000;
            if (var20 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  if (LogicStartProcedure.execute(entity) && Math.random() < (double)0.75F) {
                     label96: {
                        distance = GetDistanceProcedure.execute(entity);
                        if (var20 instanceof LivingEntity) {
                           LivingEntity _livEnt = var20;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              var29 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                              break label96;
                           }
                        }

                        var29 = 0;
                     }

                     label91: {
                        if (var29 < 1) {
                           if (!(var20 instanceof LivingEntity)) {
                              break label91;
                           }

                           LivingEntity _livEnt13 = var20;
                           if (!_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                              break label91;
                           }
                        }

                        if (!world.m_6443_(EntityEyeRantaEntity.class, AABB.m_165882_(new Vec3(((Entity)var20).m_20185_(), ((Entity)var20).m_20186_(), ((Entity)var20).m_20189_()), (double)2.0F, (double)2.0F, (double)2.0F), (e) -> true).isEmpty()) {
                           rnd = (double)7.0F;
                           tick = (double)250.0F;
                        }
                     }

                     if (rnd == (double)0.0F) {
                        for(int index0 = 0; index0 < 256; ++index0) {
                           rnd = (double)Math.round((double)4.0F + Math.ceil(Math.random() * (double)7.0F));
                           level = (double)0.0F;
                           if (rnd == (double)5.0F) {
                              tick = (double)50.0F;
                              break;
                           }

                           if (rnd == (double)6.0F) {
                              tick = (double)50.0F;
                              break;
                           }

                           if (rnd == (double)7.0F) {
                              tick = (double)250.0F;
                              if (!(distance > (double)32.0F)) {
                                 break;
                              }
                           } else if (rnd == (double)8.0F) {
                              tick = (double)100.0F;
                              if (!(distance > (double)12.0F)) {
                                 break;
                              }
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", (double)Math.round((double)2200.0F + rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, (int)level, false, false));
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
