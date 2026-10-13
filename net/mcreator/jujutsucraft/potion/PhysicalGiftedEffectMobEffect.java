package net.mcreator.jujutsucraft.potion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.PhysicalGiftedEffectOnEffectActiveTickProcedure;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;
import net.minecraftforge.common.ForgeMod;

public class PhysicalGiftedEffectMobEffect extends MobEffect {
   public PhysicalGiftedEffectMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
      this.m_19472_((Attribute)ForgeMod.STEP_HEIGHT_ADDITION.get(), "d34e81b1-9f9a-3b12-b688-a8fa20ee3502", (double)0.25F, Operation.ADDITION);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      PhysicalGiftedEffectOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }

   public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
      consumer.accept(new IClientMobEffectExtensions() {
         public boolean isVisibleInInventory(MobEffectInstance effect) {
            return false;
         }

         public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
            return false;
         }

         public boolean isVisibleInGui(MobEffectInstance effect) {
            return false;
         }
      });
   }
}
