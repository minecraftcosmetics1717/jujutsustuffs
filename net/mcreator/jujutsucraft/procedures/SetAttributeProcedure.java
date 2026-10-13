package net.mcreator.jujutsucraft.procedures;

import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SetAttributeProcedure {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void onItemTooltip(ItemTooltipEvent event) {
      execute(event, event.getItemStack(), event.getToolTip());
   }

   public static void execute(ItemStack itemstack, List<Component> tooltip) {
      execute((Event)null, itemstack, tooltip);
   }

   private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
      if (tooltip != null) {
         double curse_value = (double)0.0F;
         double NUM2 = (double)0.0F;
         double NUM1 = (double)0.0F;
         String color = "";
         String STR1 = "";
         if (itemstack.m_41720_() != ItemStack.f_41583_.m_41720_()) {
            SetAttributeMainhandProcedure.execute(itemstack);
            if (itemstack.m_41784_().m_128441_("CursePower") && itemstack.m_41784_().m_128459_("CursePower") != (double)0.0F) {
               curse_value = itemstack.m_41784_().m_128459_("CursePower");
               color = curse_value > (double)0.0F ? "§c" : "§9";
               tooltip.add(Component.m_237113_(color + Component.m_237115_("jujutsu.overlay.curse_power").getString() + " Lv." + Math.round(curse_value)));
            }

            if (itemstack.m_41784_().m_128441_("Power") && itemstack.m_41784_().m_128459_("Power") != (double)0.0F) {
               NUM2 = itemstack.m_41784_().m_128459_("Power") * (double)4.0F;
               if (NUM2 == (double)0.0F) {
                  color = "§f";
               } else {
                  color = NUM2 > (double)0.0F ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = (double)-4.0F;

               for(int index0 = 0; index0 < 9; ++index0) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var10001 = Component.m_237115_("jujutsu.overlay.weight").getString();
               tooltip.add(Component.m_237113_(var10001 + " " + STR1));
            }

            if (itemstack.m_41784_().m_128441_("Reach") && itemstack.m_41784_().m_128459_("Reach") != (double)0.0F) {
               NUM2 = itemstack.m_41784_().m_128459_("Reach") * (double)4.0F;
               if (NUM2 == (double)0.0F) {
                  color = "§f";
               } else {
                  color = NUM2 > (double)0.0F ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = (double)-4.0F;

               for(int index1 = 0; index1 < 9; ++index1) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var33 = Component.m_237115_("jujutsu.overlay.reach").getString();
               tooltip.add(Component.m_237113_(var33 + " " + STR1));
            }

            if (itemstack.m_41784_().m_128441_("Range") && itemstack.m_41784_().m_128459_("Range") != (double)0.0F) {
               NUM2 = itemstack.m_41784_().m_128459_("Range") * (double)4.0F;
               if (NUM2 == (double)0.0F) {
                  color = "§f";
               } else {
                  color = NUM2 > (double)0.0F ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = (double)-4.0F;

               for(int index2 = 0; index2 < 9; ++index2) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var34 = Component.m_237115_("jujutsu.overlay.range").getString();
               tooltip.add(Component.m_237113_(var34 + " " + STR1));
            }

            if (itemstack.m_41784_().m_128441_("Knockback") && itemstack.m_41784_().m_128459_("Knockback") != (double)0.0F) {
               NUM2 = itemstack.m_41784_().m_128459_("Knockback") * (double)4.0F;
               if (NUM2 == (double)0.0F) {
                  color = "§f";
               } else {
                  color = NUM2 > (double)0.0F ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = (double)-4.0F;

               for(int index3 = 0; index3 < 9; ++index3) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var35 = Component.m_237115_("jujutsu.overlay.knockback").getString();
               tooltip.add(Component.m_237113_(var35 + " " + STR1));
            }

            if (itemstack.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
               String var36 = Component.m_237115_("jujutsu.overlay.curse_power").getString();
               tooltip.add(Component.m_237113_("§c" + var36 + ": " + Math.round(Math.ceil(Math.sqrt(itemstack.m_41784_().m_128459_("C_Power"))))));
            }

            if (itemstack.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
               String var37 = itemstack.m_41784_().m_128459_("power_energy") >= (double)5.0F ? "§9" : "§7";
               tooltip.add(Component.m_237113_(var37 + "Energy: " + Math.round(itemstack.m_41784_().m_128459_("power_energy"))));
            }

         }
      }
   }
}
