package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

public class SelectedArmorEquipProcedure {
   public static void execute(Entity entity, ItemStack armor_chest, ItemStack armor_feet, ItemStack armor_head, ItemStack armor_legs, ItemStack other_item1, ItemStack other_item2, ItemStack weapon_mainhand, ItemStack weapon_offhand) {
      if (entity != null) {
         ItemStack item5_old = ItemStack.f_41583_;
         ItemStack item6_old = ItemStack.f_41583_;
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(weapon_mainhand).m_41777_();
            _setstack.m_41764_(Math.max(weapon_mainhand.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(weapon_offhand).m_41777_();
            _setstack.m_41764_(Math.max(weapon_offhand.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_head).m_41777_();
            _setstack.m_41764_(Math.max(armor_head.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_chest).m_41777_();
            _setstack.m_41764_(Math.max(armor_chest.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_legs).m_41777_();
            _setstack.m_41764_(Math.max(armor_legs.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_feet).m_41777_();
            _setstack.m_41764_(Math.max(armor_feet.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(other_item1).m_41777_();
            _setstack.m_41764_(Math.max(other_item1.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(other_item2).m_41777_();
            _setstack.m_41764_(Math.max(other_item2.m_41613_(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

      }
   }

   // $FF: synthetic method
   private static void lambda$execute$1(ItemStack _setstack, IItemHandler capability) {
      if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
         _modHandlerEntSetSlot.setStackInSlot(40, _setstack);
      }

   }

   // $FF: synthetic method
   private static void lambda$execute$0(ItemStack _setstack, IItemHandler capability) {
      if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
         _modHandlerEntSetSlot.setStackInSlot(0, _setstack);
      }

   }
}
