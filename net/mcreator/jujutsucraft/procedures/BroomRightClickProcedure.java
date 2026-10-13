package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BroomRightClickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double size = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double NUM1 = (double)0.0F;
         if (itemstack.m_41720_() == JujutsucraftModItems.BROOM.get()) {
            SummonBroomProcedure.execute(world, x, y, z, entity);
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_36335_().m_41524_(itemstack.m_41720_(), 3);
            }

            itemstack.m_41774_(1);
         }

      }
   }
}
