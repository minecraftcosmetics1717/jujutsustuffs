package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         double level_jump_set = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double level_speed_set = (double)0.0F;
         double level_speed = (double)0.0F;
         double skill = (double)0.0F;
         double level_jump = (double)0.0F;
         boolean hasCooldown = false;
         boolean logic_run = false;
         boolean simpleDomainning = false;
         boolean simpleDomain = false;
         boolean canFallingBlossomEmotion = false;
         boolean hasFallingBlossom = false;
         boolean canSimpleDomain = false;
         ItemStack item_mainHand = ItemStack.f_41583_;
         ItemStack item_offHand = ItemStack.f_41583_;
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            skill = entity.getPersistentData().m_128459_("skill");
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            Entity var38 = var10000;
            if (skill == (double)0.0F && entity.f_19797_ % 12 == 0) {
               canSimpleDomain = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_simple_domain")));
               canFallingBlossomEmotion = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_falling_blossom_emotion")));
               if (canSimpleDomain || canFallingBlossomEmotion) {
                  hasFallingBlossom = livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
                  int simpleDomainAmp = livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) ? livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_() : -1;
                  simpleDomainning = simpleDomainAmp > 0 || hasFallingBlossom;
                  simpleDomain = false;
                  hasCooldown = livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get());
                  MobEffectInstance neutralEffect = livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get());
                  int neutralAmp = neutralEffect != null ? neutralEffect.m_19564_() : -1;
                  int neutralDur = neutralEffect != null ? neutralEffect.m_19557_() : 0;
                  int unstableAmp = livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) ? livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_() : -1;
                  if (!livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && neutralAmp > 0 && (neutralAmp != 37 || unstableAmp <= 0) && neutralAmp != 39 && neutralDur >= 5) {
                     if (simpleDomainning) {
                        if (hasFallingBlossom && canSimpleDomain && !hasCooldown) {
                           simpleDomain = true;
                        }
                     } else if (canFallingBlossomEmotion || !hasCooldown) {
                        entity.getPersistentData().m_128347_("cnt_simpleDomain_spread", entity.getPersistentData().m_128459_("cnt_simpleDomain_spread") + (double)1.0F);
                        if (entity.getPersistentData().m_128459_("cnt_simpleDomain_spread") > (double)2.0F) {
                           simpleDomain = true;
                        }
                     }
                  } else if (simpleDomainning) {
                     simpleDomain = true;
                  }

                  if (simpleDomain) {
                     KeySimpleDomainOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128347_("cnt_simpleDomain_spread", (double)0.0F);
                  }
               }
            }

            if (var38 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)10.0F) {
               label198: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var65 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label198;
                     }
                  }

                  var65 = 0;
               }

               level = (double)Math.min(var65, 30);
               distance = GetDistanceProcedure.execute(entity);
               logic_run = false;
               if (distance > (double)32.0F) {
                  logic_run = true;
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:combat_type")))) {
                  if (distance > (double)2.0F) {
                     logic_run = true;
                  }
               } else {
                  if (((Entity)var38).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:combat_type")))) {
                     logic_run = false;
                  }

                  if (distance > (double)4.0F) {
                     label188: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                              var66 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                              break label188;
                           }
                        }

                        var66 = 0;
                     }

                     if ((double)var66 > distance * (double)2.0F) {
                        logic_run = true;
                     }
                  }
               }

               if (distance < (double)12.0F) {
                  MobEffectInstance combatCool = livingEntity.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
                  if (combatCool != null && combatCool.m_19564_() > 0 && combatCool.m_19557_() > 15 && ((Entity)var38).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var38).getPersistentData().m_128459_("Damage") > (double)0.0F && ((Entity)var38).getPersistentData().m_128471_("attack")) {
                     logic_run = false;
                  }
               }

               MobEffectInstance speedEffect = livingEntity.m_21124_(MobEffects.f_19596_);
               int speedAmp = speedEffect != null ? speedEffect.m_19564_() : 0;
               if (!logic_run) {
                  entity.m_6858_(false);
               } else {
                  level_speed = (double)Math.round(Math.min(level / (double)4.0F, (double)6.0F));
                  level_speed_set = (double)speedAmp;
                  if (speedEffect != null || entity.m_20096_()) {
                     level_speed = (double)Math.min(Math.round(level / (double)4.0F), 3L);
                     level_speed_set = speedEffect != null ? (double)(speedAmp + 1) : (double)0.0F;
                     int speedDur = speedEffect != null ? speedEffect.m_19557_() : 0;
                     if (speedDur <= 2 && !entity.m_9236_().m_5776_()) {
                        livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 10, (int)Math.min(level_speed_set, level_speed), false, false));
                     }
                  }

                  int slowAmp = livingEntity.m_21023_(MobEffects.f_19597_) ? livingEntity.m_21124_(MobEffects.f_19597_).m_19564_() : -1;
                  if (slowAmp < 6) {
                     if (entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_() > 0.04) {
                        entity.m_6858_(true);
                        if (skill == (double)0.0F) {
                           item_mainHand = livingEntity.m_21205_();
                           item_offHand = livingEntity.m_21206_();
                           PlayAnimationItemProcedure.execute(entity, item_mainHand, "sprint");
                           PlayAnimationItemProcedure.execute(entity, item_offHand, "sprint");
                        }
                     } else {
                        entity.m_6858_(false);
                     }
                  } else {
                     entity.m_6858_(false);
                  }
               }

               if (distance > (double)12.0F || !entity.m_20096_()) {
                  level_jump = (double)Math.round(Math.min(level / (double)4.0F, (double)6.0F));
                  MobEffectInstance jumpEffect = livingEntity.m_21124_(MobEffects.f_19603_);
                  if (!entity.m_20096_()) {
                     level_jump_set = jumpEffect != null ? (double)(jumpEffect.m_19564_() + 1) : (double)0.0F;
                  } else {
                     level_jump_set = (double)Math.round(Math.min(level_speed_set / (double)4.0F, level / (double)4.0F));
                  }

                  int jumpDur = jumpEffect != null ? jumpEffect.m_19557_() : 0;
                  if (jumpDur < 2 && !entity.m_9236_().m_5776_()) {
                     livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 8, (int)Math.min(level_jump, level_jump_set), false, false));
                  }
               }
            } else {
               entity.m_6858_(false);
            }

            AIActive2Procedure.execute(world, x, y, z, entity);
         }
      }
   }
}
