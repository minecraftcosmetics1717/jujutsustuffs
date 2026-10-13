package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CursedTechniquePotionExpiresProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack item_a = ItemStack.f_41583_;
         double num1 = (double)0.0F;
         double skill = (double)0.0F;
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)0.0F && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity3 = (LivingEntity)entity;
               if (_livingEntity3.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity3.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-49.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity4.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            AnimationResetProcedure.execute(entity);
         }

         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
         }

         if (entity instanceof Player) {
            if (entity.getPersistentData().m_128471_("attack") && pVars != null) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               item_a = var10000.m_41777_();
               if (pVars.PlayerCursePowerFormer >= (double)100.0F && item_a.m_41792_()) {
                  num1 = Math.sqrt(pVars.PlayerCursePowerFormer * pVars.PlayerLevel) * 0.1;
                  if (item_a.m_41784_().m_128459_("CursePower") >= (double)0.0F && item_a.m_41784_().m_128459_("CursePower") < num1) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     item_a = var10000;
                     item_a.m_41784_().m_128347_("CursePower", Math.min(item_a.m_41784_().m_128459_("CursePower") + num1 * 0.01 * Math.min((double)1.0F + (entity.getPersistentData().m_128459_("cnt6") + (double)1.0F) * 0.2, 2.2), num1));
                  }
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _livEnt14 = (LivingEntity)entity;
            if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()) && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
               KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
            }
         }

         ResetCounterProcedure.execute(entity);
         entity.getPersistentData().m_128347_("skill", (double)0.0F);
         entity.getPersistentData().m_128379_("attack", false);
         ItemStack var37;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var37 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var37 = ItemStack.f_41583_;
         }

         item_a = var37.m_41777_();
         if (item_a.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_a.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
            if (entity instanceof Player) {
               Player _plrCldCheck21 = (Player)entity;
               if (_plrCldCheck21.m_36335_().m_41519_(item_a.m_41720_())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt22 = (LivingEntity)entity;
               if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  if (entity instanceof Player) {
                     if (pVars.PlayerCurseTechnique != (double)16.0F && pVars.PlayerCurseTechnique2 != (double)16.0F) {
                        return;
                     }
                  } else if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity)) {
                     return;
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F / (double)2.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt26 = (LivingEntity)entityiterator;
                        if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           CompoundTag var38 = item_a.m_41784_();
                           CompoundTag var10001 = entityiterator.getPersistentData();
                           if (var38.m_128459_("domain" + Math.round(var10001.m_128459_("skill_domain"))) >= (double)100.0F) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
