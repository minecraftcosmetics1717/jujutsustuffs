package net.mcreator.jujutsucraft.item;

import java.util.List;
import net.mcreator.jujutsucraft.procedures.ConfiscationRightclickedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ConfiscationItem extends Item {
   public ConfiscationItem() {
      super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.COMMON));
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraft.confiscation.description_0"));
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      ConfiscationRightclickedProcedure.execute(entity, (ItemStack)ar.m_19095_());
      return ar;
   }
}
