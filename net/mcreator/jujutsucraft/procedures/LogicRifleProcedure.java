package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class LogicRifleProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         boolean logic_have_bullet = false;
         double distance = (double)0.0F;
         ItemStack item_a = ItemStack.f_41583_;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         item_a = var10000.m_41777_();
         if (item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle"))) || item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:bow")))) {
            if (!(entity instanceof Player)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt13 = (LivingEntity)entity;
                  if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                     return false;
                  }
               }

               distance = GetDistanceProcedure.execute(entity);
               if (distance < (double)8.0F) {
                  return false;
               }

               if (distance > (double)24.0F) {
                  return false;
               }

               return true;
            }

            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.m_150110_().f_35937_) {
                  return true;
               }
            }

            if (item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle")))) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var18 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var18.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     if (itemstackiterator.m_41720_() == JujutsucraftModItems.ITEM_BULLET.get()) {
                        logic_have_bullet = true;
                        break;
                     }
                  }
               }

               if (logic_have_bullet) {
                  return true;
               }
            }

            if (item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:bow")))) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var19 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var19.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     if (itemstackiterator.m_41720_() == Items.f_42412_) {
                        logic_have_bullet = true;
                        break;
                     }
                  }
               }

               if (logic_have_bullet) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
