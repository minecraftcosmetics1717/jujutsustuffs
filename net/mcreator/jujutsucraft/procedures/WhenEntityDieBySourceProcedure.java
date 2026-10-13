package net.mcreator.jujutsucraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenEntityDieBySourceProcedure {
   @SubscribeEvent
   public static void onEntityDeath(LivingDeathEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getEntity(), event.getSource().m_7639_());
      }

   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      execute((Event)null, world, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         String pattern = "";
         String yyyy = "";
         String dd = "";
         String MM = "";
         JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
         if (sourceentity instanceof Player && (playerVars.PlayerCurseTechnique == (double)15.0F || playerVars.PlayerCurseTechnique2 == (double)15.0F)) {
            MahitoThisEntityKillsAnotherOneProcedure.execute(world, entity, sourceentity);
         }

         if (entity instanceof LivingEntity) {
            if (entity instanceof WaterAnimal || entity instanceof Guardian || entity instanceof Axolotl || entity instanceof Turtle || !(entity instanceof AbstractGolem) && (entity instanceof Animal || entity instanceof Bat || entity instanceof Axolotl) || entity instanceof Spider || entity instanceof TamableAnimal) {
               return;
            }

            if (entity instanceof AmbientCreature || entity instanceof Animal) {
               return;
            }

            if (entity.getPersistentData().m_128471_("CursedSpirit")) {
               return;
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
               return;
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:transfigured_human"))) || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) {
               return;
            }

            if (GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) {
               return;
            }

            yyyy = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
            MM = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
            dd = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
            pattern = Component.m_237115_("jujutsu.message.higuruma_date").getString();
            pattern = pattern.replace("yyyy", yyyy).replace("MM", GetMonthProcedure.execute(MM)).replace("dd", dd);
            sourceentity.getPersistentData().m_128347_("kill_count", sourceentity.getPersistentData().m_128459_("kill_count") + (double)1.0F);
            if (sourceentity.getPersistentData().m_128459_("kill_count") >= (double)3.0F) {
               sourceentity.getPersistentData().m_128359_("crime1", Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.m_237115_("jujutsu.message.higuruma15").getString()).replace("[date]", pattern));
            } else {
               sourceentity.getPersistentData().m_128359_("crime1", Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.m_237115_("jujutsu.message.higuruma14").getString().replace("[entity]", entity.m_5446_().getString())).replace("[date]", pattern));
            }
         }

      }
   }
}
