package net.mcreator.jujutsucraft.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.jujutsucraft.procedures.LogicCooldownCombatProcedure;
import net.mcreator.jujutsucraft.procedures.LogicCooldownMagicOnlyProcedure;
import net.mcreator.jujutsucraft.procedures.LogicCooldownProcedure;
import net.mcreator.jujutsucraft.procedures.LogicDoubleCursedTechniqueProcedure;
import net.mcreator.jujutsucraft.procedures.OChangeProcedure;
import net.mcreator.jujutsucraft.procedures.OCoolTimeCombatProcedure;
import net.mcreator.jujutsucraft.procedures.OCoolTimeProcedure;
import net.mcreator.jujutsucraft.procedures.OCoolTimeSelectingProcedure;
import net.mcreator.jujutsucraft.procedures.OCostProcedure;
import net.mcreator.jujutsucraft.procedures.OCursePowerProcedure;
import net.mcreator.jujutsucraft.procedures.OSwitchProcedure;
import net.mcreator.jujutsucraft.procedures.OTechniqueNameProcedure;
import net.mcreator.jujutsucraft.procedures.OUseProcedure;
import net.mcreator.jujutsucraft.procedures.OverlayCooldown2Procedure;
import net.mcreator.jujutsucraft.procedures.OverlayCooldown2TimerProcedure;
import net.mcreator.jujutsucraft.procedures.OverlayCursedSkillProcedure;
import net.mcreator.jujutsucraft.procedures.OverlayDefaultSkillProcedure;
import net.mcreator.jujutsucraft.procedures.OverlayDomainSkillProcedure;
import net.mcreator.jujutsucraft.procedures.OverlayHaveTechniqueProcedure;
import net.mcreator.jujutsucraft.procedures.OverlayPassiveProcedure;
import net.mcreator.jujutsucraft.procedures.OverlayPhysicalSkillProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class OverlayDefaultOverlay {
   @SubscribeEvent(
      priority = EventPriority.HIGH
   )
   public static void eventHandler(RenderGuiEvent.Pre event) {
      int w = event.getWindow().m_85445_();
      int h = event.getWindow().m_85446_();
      Level world = null;
      double x = (double)0.0F;
      double y = (double)0.0F;
      double z = (double)0.0F;
      Player entity = Minecraft.m_91087_().f_91074_;
      if (entity != null) {
         world = entity.m_9236_();
         x = entity.m_20185_();
         y = entity.m_20186_();
         z = entity.m_20189_();
      }

      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.enableBlend();
      RenderSystem.setShader(GameRenderer::m_172817_);
      RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      if (OverlayHaveTechniqueProcedure.execute(entity)) {
         event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/tex_transblack.png"), -7, h - 43, 0.0F, 0.0F, 128, 48, 128, 48);
         event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_magic.png"), 14, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         if (LogicCooldownProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), 14, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_punch.png"), 2, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         if (LogicCooldownCombatProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), 2, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (OverlayDomainSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_domain_expansion2.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayCursedSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_magic.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayDefaultSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_default.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayPhysicalSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_punch.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayPassiveProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_passive.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayCooldown2Procedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCursePowerProcedure.execute(entity), 33, h - 40, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OTechniqueNameProcedure.execute(entity), 33, h - 31, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCostProcedure.execute(entity), 33, h - 22, -205, false);
         if (OverlayCooldown2TimerProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCoolTimeSelectingProcedure.execute(entity), 13, h - 33, -205, false);
         }

         if (LogicCooldownCombatProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCoolTimeCombatProcedure.execute(entity), 7, h - 19, -205, false);
         }

         if (LogicCooldownMagicOnlyProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCoolTimeProcedure.execute(entity), 20, h - 19, -205, false);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OUseProcedure.execute(entity), 88, h - 10, -6710887, false);
         if (LogicDoubleCursedTechniqueProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OSwitchProcedure.execute(entity), 34, h - 10, -6736897, false);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OChangeProcedure.execute(entity), 88, h - 19, -6710887, false);
      }

      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
