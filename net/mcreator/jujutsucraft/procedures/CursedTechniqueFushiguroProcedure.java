package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class CursedTechniqueFushiguroProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)604.0F) {
            ReturnShadowProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player && entity.getPersistentData().m_128459_("cnt10") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt10", Math.max(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost, (double)1.0F));
            }

            if (skill != (double)605.0F && skill != (double)606.0F) {
               if (skill == (double)607.0F) {
                  SummonDivineDogTotalityProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)608.0F) {
                  SummonNueProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)609.0F) {
                  SummonGreatSerpentProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)610.0F) {
                  SummonToadProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)611.0F) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName.equals(Component.m_237115_("jujutsu.technique.choso3").getString())) {
                     entity.getPersistentData().m_128347_("skill", (double)1007.0F);
                  } else {
                     SummonMaxElephantProcedure.execute(world, x, y, z, entity);
                  }
               } else if (skill == (double)612.0F) {
                  SummonRabbitEscapeProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)613.0F) {
                  SummonRoundDeerProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)614.0F) {
                  SummonPiercingOxProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)615.0F) {
                  SummonTigerFuneralProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)617.0F) {
                  SummonMergedBeastAgitoProcedure.execute(world, x, y, z, entity);
               } else if (skill == (double)618.0F) {
                  if (entity.getPersistentData().m_128459_("cnt9") == (double)0.0F) {
                     if (entity instanceof Player) {
                        entity.getPersistentData().m_128347_("cnt9", (double)(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName.equals(Component.m_237115_("item.jujutsucraft.mahoraga_wheel_helmet").getString()) ? 2 : 1));
                     } else {
                        entity.getPersistentData().m_128347_("cnt9", (double)1.0F);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt9") == (double)1.0F) {
                     SummonMahoragaProcedure.execute(world, x, y, z, entity);
                  } else {
                     ItemStack var10000;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           ItemStack _setstack = var10000.m_41777_();
                           _setstack.m_41764_(1);
                           ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }
                  }
               } else if (skill == (double)620.0F) {
                  ChimeraShadowGardenProcedure.execute(world, x, y, z, entity);
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else {
               SummonDivineDogProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
