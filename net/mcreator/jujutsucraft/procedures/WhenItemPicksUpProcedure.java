package net.mcreator.jujutsucraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenItemPicksUpProcedure {
   @SubscribeEvent
   public static void onPickup(EntityItemPickupEvent event) {
      execute(event, event.getEntity(), event.getItem().m_32055_());
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      execute((Event)null, entity, itemstack);
   }

   private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double mode = (double)0.0F;
         String dd = "";
         String MM = "";
         String pattern = "";
         String yyyy = "";
         String str1 = "";
         if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
            if (!(itemstack.m_41720_() instanceof SwordItem) && !(itemstack.m_41720_() instanceof TridentItem) && !(itemstack.m_41720_() instanceof BowItem) && !itemstack.m_204117_(ItemTags.create(new ResourceLocation("forge:sword"))) && !itemstack.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle"))) && !itemstack.m_204117_(ItemTags.create(new ResourceLocation("forge:bow"))) && itemstack.m_41720_() != Blocks.f_50272_.m_5456_() && itemstack.m_41720_() != Blocks.f_50447_.m_5456_() && itemstack.m_41720_() != Blocks.f_50448_.m_5456_() && itemstack.m_41720_() != Items.f_42657_ && itemstack.m_41720_() != Items.f_42448_ && itemstack.m_41720_() != Blocks.f_50085_.m_5456_() && itemstack.m_41720_() != Blocks.f_50312_.m_5456_() && itemstack.m_41720_() != Blocks.f_50070_.m_5456_()) {
               if (itemstack.m_41720_() == Items.f_42403_ || itemstack.m_41720_() == Items.f_42613_ || itemstack.m_41720_() == Items.f_42729_ || itemstack.m_41720_() == Blocks.f_50724_.m_5456_() || itemstack.m_41720_() == Items.f_42555_ || itemstack.m_41720_() == Blocks.f_50077_.m_5456_() || itemstack.m_41720_() == Items.f_42693_ || itemstack.m_204117_(ItemTags.create(new ResourceLocation("minecraft:beds")))) {
                  str1 = "jujutsu.message.higuruma12_2";
                  mode = (double)1.0F;
               }
            } else {
               str1 = "jujutsu.message.higuruma12";
               mode = (double)2.0F;
            }

            if (mode != (double)0.0F && (entity.getPersistentData().m_128461_("crime4").isEmpty() || Math.random() < 0.1)) {
               pattern = Component.m_237115_("jujutsu.message.higuruma_date").getString();
               yyyy = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
               MM = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
               dd = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
               entity.getPersistentData().m_128359_("crime4", Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.m_237115_(str1).getString().replace("[item]", (mode == (double)1.0F ? "§4" : "") + itemstack.m_41611_().getString())).replace("[date]", pattern.replace("yyyy", yyyy).replace("MM", GetMonthProcedure.execute(MM)).replace("dd", dd)));
            }

            if (entity.getPersistentData().m_128461_("crime2").contains(itemstack.m_41611_().getString())) {
               entity.getPersistentData().m_128359_("crime2", "");
            }
         }

      }
   }
}
