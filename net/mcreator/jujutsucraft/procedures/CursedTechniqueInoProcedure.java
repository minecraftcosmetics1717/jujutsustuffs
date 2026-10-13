package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueInoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         ItemStack item_a = ItemStack.f_41583_;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)4000.0F);
         if (skill == (double)5.0F) {
            SkillKaichiProcedure.execute(world, entity);
         } else if (skill == (double)6.0F) {
            SkillReikiProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)7.0F) {
            SkillKirinProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)8.0F) {
            SkillRyuProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)20.0F) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftModItems.CLOTHES_INO_TAKUMA_1_HELMET.get()) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_INO_TAKUMA_2_HELMET.get())).m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            CompoundTag _nbtTag = var10000.m_41783_();
            if (_nbtTag != null) {
               item_a.m_41751_(_nbtTag.m_6426_());
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

      }
   }
}
