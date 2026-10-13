package net.mcreator.jujutsucraft.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.item.ItemStack;

public class LogicIronBodyProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         double skill = (double)0.0F;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;

         for(int index0 = 0; index0 < 4; ++index0) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)num1));
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:metallic")))) {
               if (num1 != (double)0.0F && num1 != (double)3.0F) {
                  if (num1 == (double)2.0F) {
                     num2 += (double)0.5F;
                  } else if (num1 == (double)1.0F) {
                     num2 += 0.3;
                  }
               } else {
                  num2 += 0.15;
               }
            }

            ++num1;
         }

         if (num2 > Math.random()) {
            return true;
         } else {
            return false;
         }
      }
   }
}
