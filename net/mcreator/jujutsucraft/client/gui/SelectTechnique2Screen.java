package net.mcreator.jujutsucraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.init.JujutsucraftModScreens;
import net.mcreator.jujutsucraft.network.SelectTechnique2ButtonMessage;
import net.mcreator.jujutsucraft.world.inventory.SelectTechnique2Menu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SelectTechnique2Screen extends AbstractContainerScreen<SelectTechnique2Menu> implements JujutsucraftModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   Button button_smallpox00;
   Button button_rozetsu;
   Button button_empty;
   Button button_crystal_curse;
   private static final ResourceLocation texture;

   public SelectTechnique2Screen(SelectTechnique2Menu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 419;
      this.f_97727_ = 246;
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
   }

   public void m_7856_() {
      super.m_7856_();
      this.button_smallpox00 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique_2.button_smallpox00"), (e) -> {
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(0, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 20, 77, 20).m_253136_();
      guistate.put("button:button_smallpox00", this.button_smallpox00);
      this.m_142416_(this.button_smallpox00);
      this.button_rozetsu = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique_2.button_rozetsu"), (e) -> {
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(1, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 200, 77, 20).m_253136_();
      guistate.put("button:button_rozetsu", this.button_rozetsu);
      this.m_142416_(this.button_rozetsu);
      this.button_empty = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique_2.button_empty"), (e) -> {
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(2, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 11, this.f_97736_ + 223, 18, 20).m_253136_();
      guistate.put("button:button_empty", this.button_empty);
      this.m_142416_(this.button_empty);
      this.button_crystal_curse = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique_2.button_crystal_curse"), (e) -> {
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(3, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 178, 77, 20).m_253136_();
      guistate.put("button:button_crystal_curse", this.button_crystal_curse);
      this.m_142416_(this.button_crystal_curse);
   }

   static {
      guistate = SelectTechnique2Menu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraft:textures/screens/select_technique_2.png");
   }
}
