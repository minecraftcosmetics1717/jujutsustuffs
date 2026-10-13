package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class Effect17Procedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 1, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 5, 9, false, false));
            }
         }

         label57: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entityiterator;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                  break label57;
               }
            }

            if (entityiterator instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entityiterator;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 5, 0, false, false));
               }
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
         }

         if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
            entityiterator.getPersistentData().m_128379_("Stop", true);
         }

         if (entity.getPersistentData().m_128459_("y_knockback") < (double)0.0F) {
            if (world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)1.0F, entityiterator.m_20189_())).m_60815_()) {
               world.m_46796_(2001, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)1.0F, entityiterator.m_20189_()))));
            }
         } else if (entity.getPersistentData().m_128459_("y_knockback") > (double)0.0F && entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19620_, 20, 19, false, false));
            }
         }

      }
   }
}
