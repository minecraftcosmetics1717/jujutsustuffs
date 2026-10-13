package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WeaponRightClickedWithChargeProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double ticks = (double)0.0F;
         double skill = (double)0.0F;
         double cnt10 = (double)0.0F;
         itemstack.m_41784_().m_128347_("COOLDOWN_TICKS", (double)0.0F);
         if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            if (itemstack.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
               skill = (double)2712.0F;
               ticks = (double)200.0F;
            }

            if (itemstack.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle"))) || itemstack.m_204117_(ItemTags.create(new ResourceLocation("forge:bow")))) {
               if (entity.m_6144_()) {
                  skill = (double)3201.0F;
                  ticks = (double)20.0F;
               } else {
                  skill = (double)3200.0F;
                  ticks = (double)5.0F;
               }

               cnt10 = (double)1.0F;
            }

            if (skill > (double)0.0F) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().m_128347_("skill", skill);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                  }
               }

               CompoundTag var10000;
               double var10002;
               label34: {
                  entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)2.0F);
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
                  entity.getPersistentData().m_128347_("cnt10", cnt10);
                  var10000 = itemstack.m_41784_();
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.m_150110_().f_35937_) {
                        var10002 = (double)20.0F;
                        break label34;
                     }
                  }

                  var10002 = ticks;
               }

               var10000.m_128347_("COOLDOWN_TICKS", var10002);
            }
         }

      }
   }
}
