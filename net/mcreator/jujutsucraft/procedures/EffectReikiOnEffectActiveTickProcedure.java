package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class EffectReikiOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean kashimo = false;
         ItemStack item_a = ItemStack.f_41583_;
         double amount = (double)0.0F;
         double x_pos = (double)0.0F;
         double tick = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double yaw_fix = (double)0.0F;
         double loop_num = (double)0.0F;
         double width = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double height = (double)0.0F;
         if (entity.m_6084_()) {
            label54: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label54;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     break label54;
                  }
               }

               label34: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label34;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 2, 2, false, false));
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123772_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(entity.m_20206_() + entity.m_20205_()), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * 0.05, (double)entity.m_20205_() * (double)0.25F, (double)0.0F);
               }

               return;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get());
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get());
         }

      }
   }
}
