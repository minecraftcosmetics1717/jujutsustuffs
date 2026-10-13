package net.mcreator.jujutsucraft.procedures;

import java.util.ArrayList;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class CompletedAdvancementProcedure {
   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity().m_9236_(), event.getEntity().m_20185_(), event.getEntity().m_20186_(), event.getEntity().m_20189_(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double sukunaLevel = (double)0.0F;
         double pLevel = (double)0.0F;
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
         }

         label177: {
            pLevel = pVars.PlayerLevel;
            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr0 = (ServerPlayer)entity;
               if (_plr0.m_9236_() instanceof ServerLevel && _plr0.m_8960_().m_135996_(_plr0.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).m_8193_()) {
                  pVars.PlayerLevel = (double)20.0F;
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s until jujutsucraft:sorcerer_grade_1");
                  }

                  if (entity instanceof Player) {
                     Player _playerHasItem = (Player)entity;
                     if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.ITEM_MASTER_PHYSICAL_GIFTED.get()))) {
                        break label177;
                     }
                  }

                  T1 = pVars.PlayerCurseTechnique;
                  T2 = pVars.PlayerCurseTechnique2;
                  if ((T1 == (double)-1.0F || T2 == (double)-1.0F) && pVars.PlayerCursePower > (double)0.0F && entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.ITEM_MASTER_PHYSICAL_GIFTED.get())).m_41777_();
                     _setstack.m_41764_(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr4 = (ServerPlayer)entity;
               if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).m_8193_()) {
                  pVars.PlayerLevel = (double)13.0F;
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s until jujutsucraft:sorcerer_grade_1_semi");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr6 = (ServerPlayer)entity;
               if (_plr6.m_9236_() instanceof ServerLevel && _plr6.m_8960_().m_135996_(_plr6.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"))).m_8193_()) {
                  pVars.PlayerLevel = (double)11.0F;
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s until jujutsucraft:sorcerer_grade_2");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr8 = (ServerPlayer)entity;
               if (_plr8.m_9236_() instanceof ServerLevel && _plr8.m_8960_().m_135996_(_plr8.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"))).m_8193_()) {
                  pVars.PlayerLevel = (double)9.0F;
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s until jujutsucraft:sorcerer_grade_2_semi");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr10 = (ServerPlayer)entity;
               if (_plr10.m_9236_() instanceof ServerLevel && _plr10.m_8960_().m_135996_(_plr10.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"))).m_8193_()) {
                  pVars.PlayerLevel = (double)7.0F;
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s until jujutsucraft:sorcerer_grade_3");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr12 = (ServerPlayer)entity;
               if (_plr12.m_9236_() instanceof ServerLevel && _plr12.m_8960_().m_135996_(_plr12.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"))).m_8193_()) {
                  pVars.PlayerLevel = (double)4.0F;
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s until jujutsucraft:sorcerer_grade_4");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr14 = (ServerPlayer)entity;
               if (_plr14.m_9236_() instanceof ServerLevel && _plr14.m_8960_().m_135996_(_plr14.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_4"))).m_8193_()) {
                  pVars.PlayerLevel = (double)2.0F;
                  break label177;
               }
            }

            pVars.PlayerLevel = (double)1.0F;
         }

         if (entity.getPersistentData().m_128471_("CursedSpirit")) {
            sukunaLevel = GetSukunaLevelProcedure.execute(entity);
            if (sukunaLevel > (double)0.0F) {
               pVars.PlayerLevel = (double)Math.round(Math.floor(Math.max(pVars.PlayerLevel, (double)10.0F) + sukunaLevel * (double)0.5F));
            }
         }

         JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER = (double)0.0F;
         JujutsucraftModVariables.MapVariables.get(world).syncData(world);

         for(Entity entityiterator : new ArrayList(world.m_6907_())) {
            JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER = Math.max(JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER, pVars.PlayerLevel);
            JujutsucraftModVariables.MapVariables.get(world).syncData(world);
         }

         if (pLevel != pVars.PlayerLevel) {
            WhenRespawnProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
