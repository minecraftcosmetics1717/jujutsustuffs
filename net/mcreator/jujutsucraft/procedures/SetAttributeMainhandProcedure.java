package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

public class SetAttributeMainhandProcedure {
   public static void execute(ItemStack targetitem) {
      String color = "";
      double curse_value = (double)0.0F;
      double NUM2 = (double)0.0F;
      double NUM1 = (double)0.0F;
      if (targetitem.m_41720_() != ItemStack.f_41583_.m_41720_()) {
         if (targetitem.m_41720_() != JujutsucraftModItems.BLAZING_COURAGE.get() && targetitem.m_41720_() != JujutsucraftModItems.MAHITO_HAND_1.get() && targetitem.m_41720_() != JujutsucraftModItems.GAVEL_LONG.get()) {
            if (targetitem.m_41720_() != JujutsucraftModItems.SPLIT_SOUL_KATANA.get() && targetitem.m_41720_() != JujutsucraftModItems.HITEN.get() && targetitem.m_41720_() != JujutsucraftModItems.GARUDA_ITEM.get() && targetitem.m_41720_() != JujutsucraftModItems.NAGINATA.get()) {
               if (targetitem.m_41720_() == JujutsucraftModItems.SLAUGHTER_DEMON.get() || targetitem.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || targetitem.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get() || targetitem.m_41720_() == JujutsucraftModItems.KNIFE.get() || targetitem.m_41720_() == JujutsucraftModItems.SCISSORS.get() || targetitem.m_41720_() == JujutsucraftModItems.CLAWS.get() || targetitem.m_41720_() == JujutsucraftModItems.SICKLE.get() || targetitem.m_41720_() == JujutsucraftModItems.MAHITO_HAND_2.get()) {
                  targetitem.m_41784_().m_128347_("Power", 0.1);
                  targetitem.m_41784_().m_128347_("Reach", (double)-0.125F);
                  targetitem.m_41784_().m_128347_("Knockback", (double)-0.25F);
               }
            } else {
               targetitem.m_41784_().m_128347_("Power", (double)0.25F);
               targetitem.m_41784_().m_128347_("Range", (double)0.25F);
               targetitem.m_41784_().m_128347_("Reach", (double)0.25F);
            }
         } else {
            targetitem.m_41784_().m_128347_("Reach", (double)0.75F);
         }

         if (targetitem.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
            targetitem.m_41784_().m_128347_("Power", (double)0.5F);
            targetitem.m_41784_().m_128347_("Range", (double)0.75F);
            targetitem.m_41784_().m_128347_("Reach", (double)0.75F);
            targetitem.m_41784_().m_128347_("Knockback", (double)0.5F);
         }

         if (targetitem.m_41720_() == JujutsucraftModItems.MEI_MEI_AXE.get()) {
            targetitem.m_41784_().m_128347_("Power", (double)0.375F);
            targetitem.m_41784_().m_128347_("Range", (double)0.25F);
            targetitem.m_41784_().m_128347_("Reach", (double)0.25F);
         }

         if (!(targetitem.m_41720_() instanceof SwordItem) && targetitem.m_41720_() != JujutsucraftModItems.WEAPON_NANAMI.get() && targetitem.m_41720_() != JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
            if (targetitem.m_41720_() instanceof AxeItem) {
               if (targetitem.m_41784_().m_128459_("Power") == (double)0.0F) {
                  targetitem.m_41784_().m_128347_("Power", (double)0.375F);
               }
            } else if ((targetitem.m_41720_() instanceof PickaxeItem || targetitem.m_41720_() instanceof ShovelItem || targetitem.m_41720_() == JujutsucraftModItems.GARUDA_ITEM_BALL.get()) && targetitem.m_41784_().m_128459_("Power") == (double)0.0F) {
               targetitem.m_41784_().m_128347_("Power", (double)0.25F);
            }
         } else if (targetitem.m_41784_().m_128459_("Power") == (double)0.0F) {
            targetitem.m_41784_().m_128347_("Power", (double)0.125F);
         }

         if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) && targetitem.m_41784_().m_128459_("CursePower") == (double)0.0F) {
            if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade0")))) {
               if (targetitem.m_41720_() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get()) {
                  targetitem.m_41784_().m_128347_("CursePower", (double)-10.0F);
               } else {
                  targetitem.m_41784_().m_128347_("CursePower", (double)10.0F);
               }
            } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade1")))) {
               targetitem.m_41784_().m_128347_("CursePower", (double)7.0F);
            } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade2")))) {
               targetitem.m_41784_().m_128347_("CursePower", (double)5.0F);
            } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade3")))) {
               targetitem.m_41784_().m_128347_("CursePower", (double)3.0F);
            } else if (targetitem.m_204117_(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade4")))) {
               targetitem.m_41784_().m_128347_("CursePower", (double)2.0F);
            } else {
               targetitem.m_41784_().m_128347_("CursePower", (double)1.0F);
            }
         }

         if (targetitem.m_41720_() == JujutsucraftModItems.BLAZING_COURAGE.get()) {
            NUM1 = (double)1.0F - Math.random() * 0.2;
            NUM2 = (double)0.5F + Math.random() * 0.2;
            targetitem.m_41784_().m_128359_("color1", NUM2 + " " + NUM2 + " " + NUM1 + " 1");
            targetitem.m_41784_().m_128359_("color2", targetitem.m_41784_().m_128461_("color1"));
            targetitem.m_41784_().m_128359_("color3", "jujutsucraft:particle_curse_power_blue");
            targetitem.m_41784_().m_128359_("slash_color", "slash_flame_blue");
         } else if (targetitem.m_41720_() != JujutsucraftModItems.BLACK_ROPE.get() && targetitem.m_41720_() != JujutsucraftModItems.SICKLE.get() && targetitem.m_41720_() != JujutsucraftModItems.SWORD_BLACK.get()) {
            if (targetitem.m_41720_() == JujutsucraftModItems.NYOI_STAFF.get() || targetitem.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
               targetitem.m_41784_().m_128359_("slash_color", "slash_red");
            }
         } else {
            NUM1 = (double)0.0F + Math.random() * 0.3;
            targetitem.m_41784_().m_128359_("color1", NUM1 + " " + NUM1 + " " + NUM1 + " 1");
            targetitem.m_41784_().m_128359_("color2", targetitem.m_41784_().m_128461_("color1"));
            targetitem.m_41784_().m_128359_("slash_color", "slash_black");
         }

      }
   }
}
