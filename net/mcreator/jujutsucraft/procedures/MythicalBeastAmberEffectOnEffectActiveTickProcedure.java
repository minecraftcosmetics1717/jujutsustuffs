package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class MythicalBeastAmberEffectOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean kashimo = false;
         ItemStack item_a = ItemStack.f_41583_;
         double range = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            double var10000;
            label196: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()).m_19557_();
                     break label196;
                  }
               }

               var10000 = (double)0.0F;
            }

            tick = var10000;
            kashimo = entity instanceof KashimoHajimeEntity;
            Player = entity instanceof Player;
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 5, 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 219, 1, false, false));
               }
            }

            label188: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                     var47 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()).m_19564_();
                     break label188;
                  }
               }

               var47 = 0;
            }

            int var10001;
            label183: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label183;
                  }
               }

               var10001 = 0;
            }

            if (var47 < var10001) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffect var10003;
                     int var10004;
                     int var10005;
                     label176: {
                        var54 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get();
                        var10004 = (int)tick;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label176;
                           }
                        }

                        var10005 = 0;
                     }

                     var54.<init>(var10003, var10004, var10005, true, true);
                     _entity.m_7292_(var54);
                  }
               }
            }

            if (Player) {
               if (entity.f_19797_ % 10 == 0) {
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange -= (double)10.0F;
                     if (capability.PlayerCursePower + capability.PlayerCursePowerChange <= (double)0.0F && entity instanceof LivingEntity _entity) {
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
                     }

                  });
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 2, 2, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 2, 1, false, false));
                  }
               }
            }

            if (Player) {
               ItemStack var51;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var51 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var51 = ItemStack.f_41583_;
               }

               if (var51.m_41720_() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()) {
                  item_a = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).m_41777_();
                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var52 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var52.ifPresent(_iitemhandlerref::set);
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                        ItemStack _player = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                        if (_player.m_41720_() == JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get() && (!_player.m_41784_().m_128441_("hand") || !_player.m_41784_().m_128471_("hand")) && _player.m_41784_().m_128441_("effect_item") && _player.m_41784_().m_128471_("effect_item")) {
                           item_a = _player.m_41777_();
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.m_150109_().m_36022_((p) -> _player.m_41720_() == p.m_41720_(), _player.m_41613_(), _player.f_36095_.m_39730_());
                           }
                           break;
                        }
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack var53;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var53 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var53 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var53.m_41777_().m_41777_();
                     _setstack.m_41764_(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, item_a);
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, item_a);
                  }
               }
            } else {
               ItemStack var48;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var48 = _livEnt.m_21205_();
               } else {
                  var48 = ItemStack.f_41583_;
               }

               if (var48.m_41720_() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get() && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var48 = _livEnt.m_21206_();
               } else {
                  var48 = ItemStack.f_41583_;
               }

               if (var48.m_41720_() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get() && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var48 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var48 = ItemStack.f_41583_;
               }

               if (var48.m_41720_() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               range = ReturnEntitySizeProcedure.execute(entity);
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F * range, (double)90.0F, (double)0.5F * range, (double)0.75F * range, (double)0.75F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), Math.random() < (double)0.75F ? "jujutsucraft:particle_flame_purple" : "jujutsucraft:particle_thunder_purple");
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
         }

      }
   }
}
