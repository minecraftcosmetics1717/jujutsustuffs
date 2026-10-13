package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CursedToolsAbility2Procedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack mainHandItem = ItemStack.f_41583_;
         double power = (double)0.0F;
         double old_reach = (double)0.0F;
         if (entity.getPersistentData().m_128471_("attack")) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            }

            if (mainHandItem.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               mainHandItem = var10000.m_41777_();
               if (mainHandItem.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
                  old_reach = mainHandItem.m_41784_().m_128459_("Reach");
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               SetAttributeMainhandProcedure.execute(var10000);
               if (mainHandItem.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("Reach", old_reach);
               }

               if (mainHandItem.m_41784_().m_128459_("Power") != (double)0.0F) {
                  if (mainHandItem.m_41784_().m_128459_("Power") > (double)0.0F) {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * ((double)1.0F + mainHandItem.m_41784_().m_128459_("Power") * Math.max(Math.min(entity.getPersistentData().m_128459_("cnt6") * 0.2, (double)1.0F), (double)0.0F)));
                  } else {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * ((double)1.0F + mainHandItem.m_41784_().m_128459_("Power")));
                  }
               }

               if (mainHandItem.m_41784_().m_128459_("Knockback") != (double)0.0F) {
                  if (mainHandItem.m_41784_().m_128459_("Knockback") > (double)0.0F) {
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * ((double)1.0F + mainHandItem.m_41784_().m_128459_("Knockback") * Math.max(Math.min(entity.getPersistentData().m_128459_("cnt6") * 0.2, (double)1.0F), (double)0.0F)));
                  } else {
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * ((double)1.0F + mainHandItem.m_41784_().m_128459_("Knockback")));
                  }
               }

               if (mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                  if (mainHandItem.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * (double)1.25F);
                     if (entity.getPersistentData().m_128459_("knockback") >= (double)1.0F) {
                        entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (double)1.25F);
                     }
                  }

                  if (mainHandItem.m_41720_() == JujutsucraftModItems.SPLIT_SOUL_KATANA.get()) {
                     label129: {
                        if (entity instanceof Player) {
                           Player _plrCldCheck36 = (Player)entity;
                           if (_plrCldCheck36.m_36335_().m_41519_(mainHandItem.m_41720_())) {
                              break label129;
                           }
                        }

                        entity.getPersistentData().m_128379_("ignore", true);
                     }
                  }

                  if (mainHandItem.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     entity.getPersistentData().m_128347_("Damage", (double)1.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)0.0F);
                  }
               }
            }

            label118: {
               if (entity instanceof Player) {
                  if (pVars.PlayerCurseTechnique != (double)7.0F && pVars.PlayerCurseTechnique2 != (double)7.0F) {
                     break label118;
                  }
               } else if (!(entity instanceof KashimoHajimeEntity)) {
                  break label118;
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 1.05);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt45 = (LivingEntity)entity;
               if (_livEnt45.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                  int var20;
                  label109: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                           var20 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                           break label109;
                        }
                     }

                     var20 = 0;
                  }

                  power = (double)(var20 + 1) * 0.1;
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * ((double)1.5F + power));
                  if (entity.getPersistentData().m_128459_("knockback") >= (double)0.5F) {
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * ((double)1.5F + power));
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt52 = (LivingEntity)entity;
               if (_livEnt52.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 1.2);
                  entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (double)1.5F);
               }
            }

            if (LogicStartPassiveProcedure.execute(entity)) {
               if (entity instanceof Player) {
                  if (!(entity instanceof ServerPlayer)) {
                     return;
                  }

                  ServerPlayer _plr58 = (ServerPlayer)entity;
                  if (!(_plr58.m_9236_() instanceof ServerLevel) || !_plr58.m_8960_().m_135996_(_plr58.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_strike_strengthening"))).m_8193_() || pVars.PlayerCurseTechnique != (double)2.0F && pVars.PlayerCurseTechnique2 != (double)2.0F) {
                     return;
                  }
               } else if (!(entity instanceof GojoSatoruEntity)) {
                  return;
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * (double)1.25F);
               if (entity.getPersistentData().m_128459_("knockback") >= (double)0.5F) {
                  entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (double)1.25F);
               }
            }
         }

      }
   }
}
