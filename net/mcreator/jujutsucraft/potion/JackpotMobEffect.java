package net.mcreator.jujutsucraft.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraft.procedures.JackpotEffectStartedappliedProcedure;
import net.mcreator.jujutsucraft.procedures.JackpotOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.ItemStack;

public class JackpotMobEffect extends MobEffect {
   public JackpotMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -6684775);
      this.m_19472_(Attributes.f_22284_, "88d6ac80-6225-397c-bd52-95f8ba78e5ea", (double)10.0F, Operation.ADDITION);
      this.m_19472_(Attributes.f_22285_, "7f8b1b7a-8610-3427-8703-4101ead8a02b", (double)5.0F, Operation.ADDITION);
      this.m_19472_(Attributes.f_22278_, "a60c03e9-c5f5-30f0-8ef9-69d8099ed034", (double)1.0F, Operation.ADDITION);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      JackpotEffectStartedappliedProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      JackpotOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
