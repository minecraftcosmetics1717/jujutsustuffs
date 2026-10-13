package net.mcreator.jujutsucraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenItemDroppedProcedure {
   @SubscribeEvent
   public static void onGemDropped(ItemTossEvent event) {
      execute(event, event.getPlayer(), event.getEntity().m_32055_());
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      execute((Event)null, entity, itemstack);
   }

   private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean remove_item;
         int var10000;
         label67: {
            remove_item = false;
            String dd = "";
            String MM = "";
            String pattern = "";
            String yyyy = "";
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                  break label67;
               }
            }

            var10000 = 0;
         }

         if (var10000 >= 1) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

         } else {
            if (itemstack.m_41720_() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get() || itemstack.m_41720_() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get() || itemstack.m_41720_() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()) {
               remove_item = true;
            }

            if (itemstack.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && itemstack.m_41784_().m_128459_("skill") != (double)0.0F) {
               remove_item = true;
            }

            if (itemstack.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get()) {
               remove_item = true;
            }

            if (remove_item) {
               itemstack.m_41764_(0);
               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }

            } else {
               if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && (entity.getPersistentData().m_128461_("crime2").isEmpty() || Math.random() < 0.1)) {
                  String var11 = Component.m_237115_("jujutsu.message.higuruma_date").getString();
                  String var12 = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
                  String var10 = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
                  String var9 = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
                  entity.getPersistentData().m_128359_("crime2", Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.m_237115_("jujutsu.message.higuruma13").getString().replace("[item]", itemstack.m_41611_().getString())).replace("[date]", var11.replace("yyyy", var12).replace("MM", GetMonthProcedure.execute(var10)).replace("dd", var9)));
               }

            }
         }
      }
   }
}
