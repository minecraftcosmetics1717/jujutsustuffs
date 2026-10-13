package net.mcreator.jujutsucraft.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraft.procedures.InfinityActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class EffectInfinityMobEffect extends MobEffect {
   public EffectInfinityMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      InfinityActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
