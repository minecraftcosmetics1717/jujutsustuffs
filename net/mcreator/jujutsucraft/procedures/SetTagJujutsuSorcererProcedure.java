package net.mcreator.jujutsucraft.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.MeiMeiEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.entity.TodoAoiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SetTagJujutsuSorcererProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         SetTagProcedure.execute(world, entity);
         entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
         if (entity instanceof TodoAoiEntity) {
            entity.getPersistentData().m_128347_("IQ", (double)530000.0F);
         }

         if (entity instanceof MeiMeiEntity) {
            SummonCrowProcedure.execute(world, x, y, z, entity);
         }

         if (entity instanceof GojoSatoruEntity) {
            if (world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)64.0F, (double)64.0F, (double)64.0F), (e) -> true).isEmpty() && world.m_6443_(SukunaPerfectEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)64.0F, (double)64.0F, (double)64.0F), (e) -> true).isEmpty()) {
               if (!world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)256.0F, (double)256.0F, (double)256.0F), (e) -> true).isEmpty()) {
                  entity.getPersistentData().m_128379_("GojoNoUseInfinity", true);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_HELMET.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (Math.random() < 0.33) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                  }
               } else if (Math.random() < (double)0.5F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get()));
                  }
               } else if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
               }
            } else {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with air");
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, new ItemStack(Blocks.f_50016_));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, new ItemStack(Blocks.f_50016_));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
               }

               if (world.m_6443_(SukunaPerfectEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)48.0F, (double)48.0F, (double)48.0F), (e) -> true).isEmpty()) {
                  if (world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)48.0F, (double)48.0F, (double)48.0F), (e) -> true).isEmpty()) {
                     return;
                  }

                  Entity _datEntSetL = (Entity)world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)48.0F, (double)48.0F, (double)48.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                     }
                  })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
                  if (!(_datEntSetL instanceof SukunaFushiguroEntity)) {
                     return;
                  }

                  SukunaFushiguroEntity _datEntL17 = (SukunaFushiguroEntity)_datEntSetL;
                  if (!(Boolean)_datEntL17.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                     return;
                  }
               }

               if (entity instanceof GojoSatoruEntity) {
                  GojoSatoruEntity _datEntSetL = (GojoSatoruEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(GojoSatoruEntity.DATA_ghost, true);
               }

               if (entity instanceof GojoSatoruEntity) {
                  GojoSatoruEntity animatable = (GojoSatoruEntity)entity;
                  animatable.setTexture("gojo_satoru_ghost");
               }

               entity.getPersistentData().m_128347_("cnt_learn_domain", (double)1.0F);
            }
         }

      }
   }
}
