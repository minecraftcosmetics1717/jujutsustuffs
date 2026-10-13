package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class LogicAttackDomainProcedure {
   public static boolean execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (world.m_5776_()) {
         return false;
      } else if (entity != null && entityiterator != null) {
         if (!(entityiterator instanceof LivingEntity)) {
            return false;
         } else {
            LivingEntity target = (LivingEntity)entityiterator;
            if (target instanceof Player) {
               Player p = (Player)target;
               if (p.m_150110_().f_35937_ || p.m_5833_()) {
                  return false;
               }
            }

            if (target instanceof DomainExpansionEntityEntity) {
               return false;
            } else {
               boolean isZeroCursePower = false;
               if (target instanceof Player) {
                  Player pTarget = (Player)target;
                  isZeroCursePower = ((JujutsucraftModVariables.PlayerVariables)pTarget.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == (double)0.0F;
               } else {
                  isZeroCursePower = target.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")));
               }

               if (isZeroCursePower) {
                  MobEffectInstance var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)entity;
                     var10000 = le.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  } else {
                     var10000 = null;
                  }

                  MobEffectInstance domainEffect = var10000;
                  if (domainEffect == null || domainEffect.m_19564_() == 0) {
                     return false;
                  }
               }

               if (!target.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && target.getPersistentData().m_128459_("select") == (double)0.0F) {
                  MobEffectInstance var29;
                  if (entity instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)entity;
                     var29 = le.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  } else {
                     var29 = null;
                  }

                  MobEffectInstance attackerDomain = var29;
                  if (target.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) && LogicSimpleDomainProcedure.execute() && attackerDomain != null && attackerDomain.m_19564_() >= 0) {
                     return false;
                  } else if (!target.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     return false;
                  } else if (!entity.getPersistentData().m_128471_("Failed") && !entity.getPersistentData().m_128471_("Cover")) {
                     if (entity.getPersistentData().m_128471_("onlyLiving") && target.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                        return false;
                     } else {
                        double friendNum = entity.getPersistentData().m_128459_("friend_num");
                        if (friendNum != (double)0.0F && friendNum == target.getPersistentData().m_128459_("friend_num")) {
                           return false;
                        } else {
                           double myRanged = entity.getPersistentData().m_128459_("NameRanged_ranged");
                           double myName = entity.getPersistentData().m_128459_("NameRanged");
                           double targetName = target.getPersistentData().m_128459_("NameRanged");
                           double targetRanged = target.getPersistentData().m_128459_("NameRanged_ranged");
                           if (myRanged == (double)0.0F || myRanged != targetName && myRanged != targetRanged) {
                              if (myName == (double)0.0F || myName != targetName && myName != targetRanged) {
                                 ItemStack helmet = target.m_6844_(EquipmentSlot.HEAD);
                                 if (helmet.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || helmet.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                                    boolean isMahoraga = false;
                                    if (!(target instanceof Player)) {
                                       isMahoraga = target instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
                                    } else {
                                       Player pTarget = (Player)target;
                                       JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)pTarget.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                                       isMahoraga = pVars.PlayerCurseTechnique == (double)16.0F || pVars.PlayerCurseTechnique2 == (double)16.0F;
                                    }

                                    if (isMahoraga) {
                                       CompoundTag var30 = helmet.m_41784_();
                                       CompoundTag var10001 = entity.getPersistentData();
                                       if (var30.m_128459_("domain" + Math.round(var10001.m_128459_("skill_domain"))) >= (double)100.0F) {
                                          return false;
                                       }
                                    }
                                 }

                                 if (entity instanceof OkkotsuYutaCullingGameEntity) {
                                    boolean old_domainAttack = entity.getPersistentData().m_128471_("DomainAttack");
                                    entity.getPersistentData().m_128379_("DomainAttack", false);
                                    boolean canAttack = LogicAttackProcedure.execute(world, entity, entityiterator);
                                    entity.getPersistentData().m_128379_("DomainAttack", old_domainAttack);
                                    if (!canAttack) {
                                       return false;
                                    }
                                 }

                                 return true;
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        }
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }
}
