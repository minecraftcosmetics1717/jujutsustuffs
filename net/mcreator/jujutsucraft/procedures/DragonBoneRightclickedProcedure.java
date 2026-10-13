package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.ThrowingItemEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DragonBoneRightclickedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double entity_size = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double range = (double)0.0F;
         Entity target_entity = null;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            CNT6 = var10000.m_41784_().m_128459_("power_energy");
            if (CNT6 >= (double)5.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("power_energy", (double)0.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               item_a = var10000.m_41777_().m_41777_();
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

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               CNT6 = var10000.m_41784_().m_128459_("power_energy");
               if (CNT6 >= (double)5.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("power_energy", (double)0.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  item_a = var10000.m_41777_().m_41777_();
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

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.OFF_HAND, true);
                  }
               }
            }
         }

         if (item_a.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
            LivingEntity var81;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var81 = _mobEnt.m_5448_();
            } else {
               var81 = null;
            }

            Entity var48 = var81;
            if (var48 instanceof LivingEntity) {
               RotateEntityProcedure.execute(((Entity)var48).m_20185_(), ((Entity)var48).m_20186_() + (double)((Entity)var48).m_20206_() * (double)0.5F, ((Entity)var48).m_20189_(), entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity29 = (LivingEntity)entity;
               if (_livingEntity29.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity29.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity31 = (LivingEntity)entity;
               if (_livingEntity31.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity31.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (entity instanceof Player) {
               Item var10001;
               byte var10002;
               label151: {
                  Player _player = (Player)entity;
                  var82 = _player.m_36335_();
                  var10001 = (Item)JujutsucraftModItems.DRAGON_BONE.get();
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.m_150110_().f_35937_) {
                        var10002 = 20;
                        break label151;
                     }
                  }

                  var10002 = 20;
               }

               var82.m_41524_(var10001, var10002);
            }

            old_skill = entity.getPersistentData().m_128459_("skill");
            entity.getPersistentData().m_128347_("skill", (double)1.0F);
            range = ReturnEntitySizeProcedure.execute(entity);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(1.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            x_power = entity.m_20154_().f_82479_ * (double)5.0F;
            y_power = entity.m_20154_().f_82480_ * (double)5.0F;
            z_power = entity.m_20154_().f_82481_ * (double)5.0F;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THROWING_ITEM.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
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

                  if (entityinstance instanceof ThrowingItemEntity) {
                     PlayAnimationEntity2Procedure.execute(entityinstance, "rotation1");
                  }

                  entityinstance.m_20256_(new Vec3(x_power, y_power, z_power));
                  entityinstance.getPersistentData().m_128347_("x_power", x_power);
                  entityinstance.getPersistentData().m_128347_("y_power", y_power);
                  entityinstance.getPersistentData().m_128347_("z_power", z_power);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     ItemStack _setstack = item_a.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("cnt6", (double)2.5F + (double)0.25F * CNT6);
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)18.0F + CNT6 * (double)3.0F, (double)entity.m_146909_(), (double)0.0F, (double)30.0F, (double)8.0F, x_pos, x_pos - x_power, y_pos, y_pos - y_power, (double)entity.m_146908_(), z_pos, z_pos - z_power, "crit");
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (CNT6 >= (double)7.5F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               if (CNT6 >= (double)10.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  ParticleGeneratorCircleProcedure.execute(world, (double)18.0F, (double)entity.m_146909_(), (double)0.0F, (double)10.0F, (double)4.0F, x_pos, x_pos - x_power, y_pos, y_pos - y_power, (double)entity.m_146908_(), z_pos, z_pos - z_power, "cloud");
               }
            }

            entity.getPersistentData().m_128347_("skill", old_skill);
         }

      }
   }
}
