package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.ThrowingItemEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.registries.ForgeRegistries;

public class GavelThrowingProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         ItemStack ITEM_A = ItemStack.f_41583_;
         ItemStack item_offHand = ItemStack.f_41583_;
         ItemStack item_mainHand = ItemStack.f_41583_;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            label197: {
               label196: {
                  if (entity instanceof Player) {
                     if (entity.m_6144_()) {
                        break label196;
                     }
                  } else if (Math.random() < (double)0.5F) {
                     break label196;
                  }

                  entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
                  break label197;
               }

               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            Entity var38 = var10000;
            if (var38 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var38).m_20185_(), ((Entity)var38).m_20186_() + (double)((Entity)var38).m_20206_() * (double)0.5F, ((Entity)var38).m_20189_(), entity);
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               if (var38 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt20 = (LivingEntity)entity;
                     if (_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  }
               }

               if ((entity.getPersistentData().m_128471_("PRESS_Z") || entity.getPersistentData().m_128459_("cnt5") < (double)15.0F) && entity.getPersistentData().m_128459_("cnt5") < (double)40.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)-5.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity26 = (LivingEntity)entity;
               if (_livingEntity26.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity26.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity28 = (LivingEntity)entity;
               if (_livingEntity28.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity28.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            range = ReturnEntitySizeProcedure.execute(entity);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)0.5F + (double)entity.m_20205_();
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            x_power = entity.m_20154_().f_82479_ * (double)9.0F;
            y_power = entity.m_20154_().f_82480_ * (double)9.0F;
            z_power = entity.m_20154_().f_82481_ * (double)9.0F;
            ItemStack var80;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var80 = _livEnt.m_21205_();
            } else {
               var80 = ItemStack.f_41583_;
            }

            item_mainHand = var80.m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var80 = _livEnt.m_21206_();
            } else {
               var80 = ItemStack.f_41583_;
            }

            item_offHand = var80.m_41777_();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THROWING_ITEM.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.m_6021_(x_pos, y_pos, z_pos);
                  if (entityinstance instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityinstance.m_146908_(), entityinstance.m_146909_());
                  }

                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entityinstance.m_20256_(new Vec3(x_power, y_power, z_power));
                  entityinstance.getPersistentData().m_128347_("x_power", x_power);
                  entityinstance.getPersistentData().m_128347_("y_power", y_power);
                  entityinstance.getPersistentData().m_128347_("z_power", z_power);
                  if (entityinstance instanceof ThrowingItemEntity) {
                     PlayAnimationEntity2Procedure.execute(entityinstance, "rotation1");
                  }

                  if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        ItemStack _setstack = item_mainHand.m_41777_().m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }
                  } else if (item_offHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        ItemStack _setstack = item_offHand.m_41777_().m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }
                  } else {
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }

                     AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                     LazyOptional var82 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                     Objects.requireNonNull(_iitemhandlerref);
                     var82.ifPresent(_iitemhandlerref::set);
                     if (_iitemhandlerref.get() != null) {
                        for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                           ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                           ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                           if (itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 ItemStack _setstack = itemstackiterator.m_41777_().m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                              break;
                           }
                        }
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("cnt6", (double)(entity.getPersistentData().m_128459_("cnt2") == (double)1.0F ? -1 : 1));
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            } else if (item_offHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            } else {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var83 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var83.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     ItemStack _entity = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                     if (_entity.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().m_36022_((p) -> _entity.m_41720_() == p.m_41720_(), _entity.m_41613_(), _player.f_36095_.m_39730_());
                        }
                        break;
                     }
                  }
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)18.0F + CNT6 * (double)3.0F, (double)entity.m_146909_(), (double)0.0F, (double)30.0F, (double)8.0F, x_pos, x_pos - x_power, y_pos, y_pos - y_power, (double)entity.m_146908_(), z_pos, z_pos - z_power, "crit");
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
