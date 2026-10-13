package net.mcreator.jujutsucraft.item;

import java.util.List;
import net.mcreator.jujutsucraft.procedures.DragonBoneRightclickedProcedure;
import net.mcreator.jujutsucraft.procedures.DragonBoneToolInHandTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class DragonBoneItem extends SwordItem {
   public DragonBoneItem() {
      super(new Tier() {
         public int m_6609_() {
            return 660;
         }

         public float m_6624_() {
            return 4.0F;
         }

         public float m_6631_() {
            return 1.0F;
         }

         public int m_6604_() {
            return 1;
         }

         public int m_6601_() {
            return 2;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_151265_();
         }
      }, 3, -2.6F, new Item.Properties());
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      DragonBoneRightclickedProcedure.execute(world, entity);
      return ar;
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraft.dragon_bone.description_0"));
      list.add(Component.m_237115_("item.jujutsucraft.dragon_bone.description_1"));
      list.add(Component.m_237115_("item.jujutsucraft.dragon_bone.description_2"));
   }

   public void m_6883_(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.m_6883_(itemstack, world, entity, slot, selected);
      if (selected) {
         DragonBoneToolInHandTickProcedure.execute(world, entity, itemstack);
      }

   }
}
