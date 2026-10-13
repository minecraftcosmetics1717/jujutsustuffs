package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.RabbitEscapeEntity;
import net.mcreator.jujutsucraft.entity.UraumeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class LogicAttackTargetStartProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
      if (world.m_5776_()) {
         return false;
      } else if (!(entity instanceof Mob)) {
         return false;
      } else {
         Mob mob = (Mob)entity;
         Entity target = mob.m_5448_();
         if (!(target instanceof LivingEntity)) {
            return true;
         } else {
            LivingEntity livingTarget = (LivingEntity)target;
            CompoundTag entityData = entity.getPersistentData();
            CompoundTag targetData = target.getPersistentData();
            double friendNum = entityData.m_128459_("friend_num");
            if (friendNum != (double)0.0F && friendNum == targetData.m_128459_("friend_num")) {
               return false;
            } else if (entityData.m_128461_("TARGET_UUID").equals(target.m_20149_())) {
               return true;
            } else {
               Entity event_owner = entity;
               Entity target_owner = target;
               int safeCounter = 0;

               for(String ownerUUID = entity.getPersistentData().m_128461_("OWNER_UUID"); !ownerUUID.isEmpty() && safeCounter < 5; ++safeCounter) {
                  Entity found = GetEntityFromUUIDProcedure.execute(world, ownerUUID);
                  if (!(found instanceof LivingEntity)) {
                     break;
                  }

                  event_owner = found;
                  ownerUUID = found.getPersistentData().m_128461_("OWNER_UUID");
               }

               safeCounter = 0;

               for(String t_ownerUUID = target.getPersistentData().m_128461_("OWNER_UUID"); !t_ownerUUID.isEmpty() && safeCounter < 5; ++safeCounter) {
                  Entity found = GetEntityFromUUIDProcedure.execute(world, t_ownerUUID);
                  if (!(found instanceof LivingEntity)) {
                     break;
                  }

                  target_owner = found;
                  t_ownerUUID = found.getPersistentData().m_128461_("OWNER_UUID");
               }

               boolean logic_a = true;
               boolean eOwnerIsPlayer = event_owner instanceof Player || event_owner.getPersistentData().m_128471_("Player");
               boolean tOwnerIsPlayer = target_owner instanceof Player || target_owner.getPersistentData().m_128471_("Player");
               if (eOwnerIsPlayer && tOwnerIsPlayer) {
                  if (!world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP)) {
                     logic_a = false;
                  }
               } else if (!event_owner.getPersistentData().m_128471_("JujutsuSorcerer") && !entityData.m_128471_("JujutsuSorcerer") || !target_owner.getPersistentData().m_128471_("JujutsuSorcerer") && !targetData.m_128471_("JujutsuSorcerer")) {
                  if (!event_owner.getPersistentData().m_128471_("CursedSpirit") && !event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:transfigured_human"))) || !target_owner.getPersistentData().m_128471_("CursedSpirit") && !target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:transfigured_human")))) {
                     if ((event_owner.getPersistentData().m_128471_("CurseUser") || entityData.m_128471_("CurseUser")) && !target_owner.getPersistentData().m_128471_("JujutsuSorcerer") && !target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("curseuser"))) && !target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("cursedspirit")))) {
                        logic_a = false;
                     }
                  } else {
                     logic_a = false;
                  }
               } else {
                  logic_a = false;
               }

               label243: {
                  label314: {
                     if (event_owner instanceof LivingEntity) {
                        LivingEntity le = (LivingEntity)event_owner;
                        if (le.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label314;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity le2 = (LivingEntity)entity;
                        if (le2.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label314;
                        }
                     }

                     if (target_owner instanceof LivingEntity) {
                        LivingEntity le3 = (LivingEntity)target_owner;
                        if (le3.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label314;
                        }
                     }

                     if (!livingTarget.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label243;
                     }
                  }

                  logic_a = true;
               }

               if (event_owner instanceof UraumeEntity) {
                  label226: {
                     if (ReturnInsideItemProcedure.execute(target_owner).m_41720_() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                        if (!(target_owner instanceof LivingEntity)) {
                           break label226;
                        }

                        LivingEntity le = (LivingEntity)target_owner;
                        if (!le.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label226;
                        }
                     }

                     logic_a = false;
                  }
               }

               if (event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) {
                  boolean targetIsItadori = false;
                  if (!(target_owner instanceof Player)) {
                     targetIsItadori = target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")));
                  } else {
                     Player pTarget = (Player)target_owner;
                     JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)pTarget.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                     targetIsItadori = pVars.PlayerCurseTechnique == (double)21.0F || pVars.PlayerCurseTechnique2 == (double)21.0F;
                  }

                  if (targetIsItadori) {
                     logic_a = false;
                  }
               }

               boolean var10000;
               label208: {
                  if (event_owner instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)event_owner;
                     if (le.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        var10000 = true;
                        break label208;
                     }
                  }

                  var10000 = false;
               }

               boolean eSukuna;
               label203: {
                  eSukuna = var10000;
                  if (target_owner instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)target_owner;
                     if (le.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        var10000 = true;
                        break label203;
                     }
                  }

                  var10000 = false;
               }

               boolean tSukuna = var10000;
               if ((event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_1"))) || event_owner instanceof Player && event_owner.getPersistentData().m_128471_("CurseUser") && !eSukuna) && (target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_1"))) || target_owner instanceof Player && target_owner.getPersistentData().m_128471_("CurseUser") && !tSukuna) || event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_2"))) && target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_2"))) || event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_3"))) && target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_3"))) || event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_4"))) && target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_4"))) || event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_5"))) && target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_5"))) || event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:zenin"))) && target_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:zenin")))) {
                  logic_a = false;
               }

               LivingEntity var35;
               if (target instanceof Mob) {
                  Mob m = (Mob)target;
                  var35 = m.m_5448_();
               } else {
                  var35 = null;
               }

               Entity targetsTarget = var35;
               if (targetsTarget instanceof LivingEntity && targetData.m_128459_("cnt_target") > (double)6.0F) {
                  if (friendNum != (double)0.0F && friendNum == targetsTarget.getPersistentData().m_128459_("friend_num")) {
                     logic_a = true;
                  }

                  if (event_owner.m_7307_(targetsTarget)) {
                     logic_a = true;
                  }

                  if (targetsTarget == entity) {
                     logic_a = true;
                  }
               }

               if (event_owner == target_owner) {
                  logic_a = false;
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entityData.m_128471_("Ambush")) {
                  if (!target.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) {
                     logic_a = true;
                  }

                  if (entity instanceof RabbitEscapeEntity && target instanceof RabbitEscapeEntity) {
                     logic_a = false;
                  }
               }

               return logic_a;
            }
         }
      }
   }
}
