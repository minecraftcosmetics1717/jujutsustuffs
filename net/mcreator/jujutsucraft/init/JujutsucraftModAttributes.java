package net.mcreator.jujutsucraft.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftModAttributes {
   public static final DeferredRegister<Attribute> REGISTRY;
   public static final RegistryObject<Attribute> SIZE;
   public static final RegistryObject<Attribute> PROFESSION;
   public static final RegistryObject<Attribute> ANIMATION_1;
   public static final RegistryObject<Attribute> ANIMATION_2;

   @SubscribeEvent
   public static void addAttributes(EntityAttributeModificationEvent event) {
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)SIZE.get()));
      event.add(EntityType.f_20532_, (Attribute)PROFESSION.get());
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)ANIMATION_1.get()));
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)ANIMATION_2.get()));
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, "jujutsucraft");
      SIZE = REGISTRY.register("size", () -> (new RangedAttribute("attribute.jujutsucraft.size", (double)1.0F, 0.1, (double)500.0F)).m_22084_(true));
      PROFESSION = REGISTRY.register("profession", () -> (new RangedAttribute("attribute.jujutsucraft.profession", (double)0.0F, (double)0.0F, (double)0.0F)).m_22084_(true));
      ANIMATION_1 = REGISTRY.register("animation_1", () -> (new RangedAttribute("attribute.jujutsucraft.animation_1", (double)0.0F, (double)-1000.0F, (double)1000.0F)).m_22084_(true));
      ANIMATION_2 = REGISTRY.register("animation_2", () -> (new RangedAttribute("attribute.jujutsucraft.animation_2", (double)0.0F, (double)-1000.0F, (double)1000.0F)).m_22084_(true));
   }

   @EventBusSubscriber
   public static class PlayerAttributesSync {
      @SubscribeEvent
      public static void playerClone(PlayerEvent.Clone event) {
         Player oldPlayer = event.getOriginal();
         Player newPlayer = event.getEntity();
         newPlayer.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(oldPlayer.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_());
         newPlayer.m_21051_((Attribute)JujutsucraftModAttributes.PROFESSION.get()).m_22100_(oldPlayer.m_21051_((Attribute)JujutsucraftModAttributes.PROFESSION.get()).m_22115_());
         newPlayer.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(oldPlayer.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_());
         newPlayer.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(oldPlayer.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22115_());
      }
   }
}
