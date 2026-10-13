package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.entity.ThrowingItemEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

public class GetGavelProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double set = (double)0.0F;
         boolean successed = false;
         ItemStack item_gavel = ItemStack.f_41583_;
         ItemStack item_a = ItemStack.f_41583_;
         ItemStack old_item = ItemStack.f_41583_;
         ItemStack handItem = ItemStack.f_41583_;
         Entity entity_owner = null;
         item_gavel = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).m_41777_();
         set = (double)1.0F;
         if (!successed) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            handItem = var10000.m_41777_();
            if (handItem.m_41720_() == JujutsucraftModItems.GAVEL.get() || handItem.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get() || handItem.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get() || handItem.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
               successed = true;
               set = (double)0.0F;
            }
         }

         if (!successed) {
            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
            LazyOptional var46 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
            Objects.requireNonNull(_iitemhandlerref);
            var46.ifPresent(_iitemhandlerref::set);
            if (_iitemhandlerref.get() != null) {
               for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                  ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                  if (itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     successed = true;
                     item_gavel = itemstackiterator.m_41777_().m_41777_();
                     ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                     _setstack.m_41764_(1);
                     entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                           _modHandlerEntSetSlot.setStackInSlot(_idx, _setstack);
                        }

                     });
                     break;
                  }
               }
            }
         }

         if (!successed) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)128.0F), (e) -> true)) {
               if (entity != entityiterator) {
                  item_a = ItemStack.f_41583_.m_41777_();
                  if (entityiterator instanceof ItemEntity) {
                     ItemStack var47;
                     if (entityiterator instanceof ItemEntity) {
                        ItemEntity _itemEnt = (ItemEntity)entityiterator;
                        var47 = _itemEnt.m_32055_();
                     } else {
                        var47 = ItemStack.f_41583_;
                     }

                     item_a = var47.m_41777_().m_41777_();
                  }

                  if (entityiterator instanceof ThrowingItemEntity) {
                     entity_owner = GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().m_128461_("OWNER_UUID"));
                     if (!(entity_owner instanceof LivingEntity) || entity_owner == entity) {
                        ItemStack var48;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           var48 = _livEnt.m_21205_();
                        } else {
                           var48 = ItemStack.f_41583_;
                        }

                        item_a = var48.m_41777_().m_41777_();
                     }
                  }

                  if (item_a.m_41720_() == JujutsucraftModItems.GAVEL.get() || item_a.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get() || item_a.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get() || item_a.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     if (entityiterator instanceof ThrowingItemEntity && entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }

                     successed = true;
                     item_gavel = item_a.m_41777_();
                     if (!entityiterator.m_9236_().m_5776_()) {
                        entityiterator.m_146870_();
                     }
                     break;
                  }
               }
            }
         }

         if (set != (double)0.0F) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound minecraft:entity.item.pickup player @s");
            }

            if (set == (double)1.0F) {
               ItemStack var49;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var49 = _livEnt.m_21205_();
               } else {
                  var49 = ItemStack.f_41583_;
               }

               old_item = var49.m_41777_().m_41777_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_gavel.m_41777_();
                  _setstack.m_41764_(item_gavel.m_41613_());
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (old_item.m_41720_() != ItemStack.f_41583_.m_41720_() && entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = old_item.m_41777_();
                  _setstack.m_41764_(old_item.m_41613_());
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            } else if (set == (double)2.0F && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = item_gavel.m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
