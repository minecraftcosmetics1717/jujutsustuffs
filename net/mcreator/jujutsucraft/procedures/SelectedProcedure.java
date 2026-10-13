package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class SelectedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerFlag_A = _setval;
            capability.syncPlayerVariables(entity);
         });
         _setval = false;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerFlag_B = _setval;
            capability.syncPlayerVariables(entity);
         });
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_((Item)JujutsucraftModItems.CURSED_TECHNIQUE_CHANGER.get(), 10);
         }

         if (!((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer _serverPlayer) {
                  return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
               } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                  return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "clear @s jujutsucraft:cursed_technique_changer 1");
         }

         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect clear @s");
         }

         double _setval = (double)0.0F;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerProfession = _setval;
            capability.syncPlayerVariables(entity);
         });
         entity.getPersistentData().m_128347_("select", (double)0.0F);
         entity.getPersistentData().m_128347_("skill_domain", (double)0.0F);
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s only jujutsucraft:update");
         }

         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:update"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         String _setval = "";
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.OVERLAY1 = _setval;
            capability.syncPlayerVariables(entity);
         });
         _setval = "";
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.OVERLAY2 = _setval;
            capability.syncPlayerVariables(entity);
         });
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_6915_();
         }

         WhenRespawnProcedure.execute(world, x, y, z, entity);
         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)0.0F && entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:advancement_select_technique"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
         LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
         Objects.requireNonNull(_iitemhandlerref);
         var10000.ifPresent(_iitemhandlerref::set);
         if (_iitemhandlerref.get() != null) {
            for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
               ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
               item_a = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
               if (item_a.m_41784_().m_128441_("DistributionItem") && item_a.m_41784_().m_128471_("DistributionItem") && entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().m_36022_((p) -> item_a.m_41720_() == p.m_41720_(), item_a.m_41613_(), _player.f_36095_.m_39730_());
               }
            }
         }

      }
   }
}
