package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AINueProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double NUM1 = (double)0.0F;
         if (entity.m_6084_()) {
            double var10001;
            label134: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               NUM1 = (double)Math.round((double)(entity.getPersistentData().m_128471_("Giant") ? 9 : 5) + entity.getPersistentData().m_128459_("Strength") * (double)0.5F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity3 = (LivingEntity)entity;
                  if (_livingEntity3.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity3.m_21051_(Attributes.f_22281_).m_22115_();
                     break label134;
                  }
               }

               var10001 = (double)0.0F;
            }

            label129: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * (double)3.0F) / (double)4.0F, (double)3.0F)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label129;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label124: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label124;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)NUM2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)1.0F) {
               AttackNueProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("skill") == (double)2.0F) {
               AttackNue2Procedure.execute(world, entity);
            } else {
               LivingEntity var32;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var32 = _mobEnt.m_5448_();
               } else {
                  var32 = null;
               }

               if (var32 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     label151: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt18 = (LivingEntity)entity;
                           if (_livEnt18.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                              break label151;
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_x", (double)-60.0F);
                        ResetCounterProcedure.execute(entity);
                        if (entity.getPersistentData().m_128471_("Giant")) {
                           rnd = (double)2.0F;
                           tick = (double)150.0F;
                        } else {
                           rnd = (double)1.0F;
                           tick = (double)(50L + Math.round(Math.random() * (double)20.0F));
                        }

                        entity.getPersistentData().m_128347_("skill", rnd);
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
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
                  if (entity.getPersistentData().m_128471_("Giant") && entity.getPersistentData().m_128459_("cnt_x2") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     label150: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt31 = (LivingEntity)entity;
                           if (_livEnt31.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
                              break label150;
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_x", (double)-60.0F);
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", (double)2.0F);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 150, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }
                     }
                  }
               }

               if (GetHeightFromGroundProcedure.execute(world, entity) > (double)8.0F) {
                  if (entity.m_20184_().m_7098_() > (double)-0.5F) {
                     entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() - 0.05, entity.m_20184_().m_7094_()));
                  }
               } else if (GetHeightFromGroundProcedure.execute(world, entity) < (double)4.0F && entity.m_20184_().m_7098_() < (double)0.25F) {
                  entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() + 0.025, entity.m_20184_().m_7094_()));
               }
            }
         }

      }
   }
}
