package net.mcreator.jujutsucraft.procedures;

import java.util.Locale;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ConfiscationRightclickedProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         ItemStack item_replace = ItemStack.f_41583_;
         item_replace = (new ItemStack((ItemLike)ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemstack.m_41784_().m_128461_("confiscation_item").toLowerCase(Locale.ENGLISH))))).m_41777_().m_41777_();
         CompoundTag _nbtTag = itemstack.m_41783_();
         if (_nbtTag != null) {
            item_replace.m_41751_(_nbtTag.m_6426_());
         }

         item_replace.m_41784_().m_128347_("CursePower", itemstack.m_41784_().m_128459_("CursePower_"));
         item_replace.m_41784_().m_128347_("Power", itemstack.m_41784_().m_128459_("Power_"));
         item_replace.m_41784_().m_128347_("Reach", itemstack.m_41784_().m_128459_("Reach_"));
         item_replace.m_41784_().m_128347_("Range", itemstack.m_41784_().m_128459_("Range_"));
         item_replace.m_41784_().m_128347_("Knockback", itemstack.m_41784_().m_128459_("Knockback_"));
         item_replace.m_41784_().m_128473_("confiscation_item");
         item_replace.m_41784_().m_128473_("CursePower_");
         item_replace.m_41784_().m_128473_("Power_");
         item_replace.m_41784_().m_128473_("Reach_");
         item_replace.m_41784_().m_128473_("Range_");
         item_replace.m_41784_().m_128473_("Knockback_");
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == itemstack.m_41720_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_replace.m_41777_();
               _setstack.m_41764_(item_replace.m_41613_());
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == itemstack.m_41720_()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_replace.m_41777_();
                  _setstack.m_41764_(item_replace.m_41613_());
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            } else {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = item_replace.m_41777_();
                  _setstack.m_41764_(item_replace.m_41613_());
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               itemstack.m_41764_(0);
            }
         }

      }
   }
}
