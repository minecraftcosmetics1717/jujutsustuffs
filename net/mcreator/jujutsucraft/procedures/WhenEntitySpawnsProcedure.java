package net.mcreator.jujutsucraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenEntitySpawnsProcedure {
   @SubscribeEvent
   public static void onEntitySpawned(EntityJoinLevelEvent event) {
      execute(event, event.getLevel(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         String dd = "";
         String MM = "";
         String pattern = "";
         String yyyy = "";
         if (!JujutsucraftModVariables.MapVariables.get(world).config_doVanillaMobSpawning && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:vanilla_mob")))) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

         } else {
            if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && (entity.getPersistentData().m_128461_("crime3").isEmpty() || Math.random() < 0.1)) {
               pattern = Component.m_237115_("jujutsu.message.higuruma_date").getString();
               yyyy = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
               MM = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
               dd = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
               entity.getPersistentData().m_128359_("crime3", Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.m_237115_("jujutsu.message.higuruma11").getString()).replace("[date]", pattern.replace("yyyy", yyyy).replace("MM", GetMonthProcedure.execute(MM)).replace("dd", dd)));
            }

         }
      }
   }
}
