package net.mcreator.jujutsucraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.init.JujutsucraftModScreens;
import net.mcreator.jujutsucraft.network.SelectProfessionButtonMessage;
import net.mcreator.jujutsucraft.procedures.ProfessionLogicProcedure;
import net.mcreator.jujutsucraft.world.inventory.SelectProfessionMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SelectProfessionScreen extends AbstractContainerScreen<SelectProfessionMenu> implements JujutsucraftModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   Button button_curse_user;
   Button button_jujutsu_sorcerer;
   Button button_cursed_spirit;
   private static final ResourceLocation texture;

   public SelectProfessionScreen(SelectProfessionMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 128;
      this.f_97727_ = 100;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      this.m_280072_(guiGraphics, mouseX, mouseY);
   }

   protected void m_7286_(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.m_280163_(texture, this.f_97735_, this.f_97736_, 0.0F, 0.0F, this.f_97726_, this.f_97727_, this.f_97726_, this.f_97727_);
      RenderSystem.disableBlend();
   }

   public HashMap<String, Object> getWidgets() {
      return guistate;
   }

   public boolean m_7933_(int key, int b, int c) {
      if (key == 256) {
         this.f_96541_.f_91074_.m_6915_();
         return true;
      } else {
         return super.m_7933_(key, b, c);
      }
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_profession.label_you_are"), 18, 10, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      this.button_curse_user = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_profession.button_curse_user"), (e) -> {
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectProfessionButtonMessage(0, this.x, this.y, this.z, textstate));
         SelectProfessionButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 18, this.f_97736_ + 46, 90, 20).m_253136_();
      guistate.put("button:button_curse_user", this.button_curse_user);
      this.m_142416_(this.button_curse_user);
      this.button_jujutsu_sorcerer = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_profession.button_jujutsu_sorcerer"), (e) -> {
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectProfessionButtonMessage(1, this.x, this.y, this.z, textstate));
         SelectProfessionButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 18, this.f_97736_ + 24, 90, 20).m_253136_();
      guistate.put("button:button_jujutsu_sorcerer", this.button_jujutsu_sorcerer);
      this.m_142416_(this.button_jujutsu_sorcerer);
      this.button_cursed_spirit = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_profession.button_cursed_spirit"), (e) -> {
         if (ProfessionLogicProcedure.execute(this.entity)) {
            JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectProfessionButtonMessage(2, this.x, this.y, this.z, textstate));
            SelectProfessionButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
         }

      }).m_252987_(this.f_97735_ + 18, this.f_97736_ + 69, 90, 20).build((builder) -> new Button(builder) {
            public void m_88315_(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (ProfessionLogicProcedure.execute(SelectProfessionScreen.this.entity)) {
                  super.m_88315_(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_cursed_spirit", this.button_cursed_spirit);
      this.m_142416_(this.button_cursed_spirit);
   }

   static {
      guistate = SelectProfessionMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraft:textures/screens/select_profession.png");
   }
}
