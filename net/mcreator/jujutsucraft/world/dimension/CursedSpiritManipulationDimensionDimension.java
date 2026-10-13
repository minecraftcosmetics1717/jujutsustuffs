package net.mcreator.jujutsucraft.world.dimension;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.DimensionSpecialEffects.SkyType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber
public class CursedSpiritManipulationDimensionDimension {
   @EventBusSubscriber(
      bus = Bus.MOD
   )
   public static class CursedSpiritManipulationDimensionSpecialEffectsHandler {
      @SubscribeEvent
      @OnlyIn(Dist.CLIENT)
      public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
         DimensionSpecialEffects customEffect = new DimensionSpecialEffects(Float.NaN, true, SkyType.NONE, false, false) {
            {
               super(arg0, arg1, arg2, arg3, arg4);
            }

            public Vec3 m_5927_(Vec3 color, float sunHeight) {
               return new Vec3((double)0.0F, (double)0.0F, (double)0.0F);
            }

            public boolean m_5781_(int x, int y) {
               return true;
            }
         };
         event.register(new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"), customEffect);
      }
   }
}
