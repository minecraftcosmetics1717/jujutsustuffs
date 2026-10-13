package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.DivineDogTotalityEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIDivinDogProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double NUM3 = (double)0.0F;
         double rnd = (double)0.0F;
         double level_resistance = (double)0.0F;
         double NUM1 = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            FollowEntityProcedure.execute(world, entity);
            if (entity instanceof DivineDogTotalityEntity) {
               NUM1 = (double)(6L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.5F));
               NUM2 = (double)2.0F;
               NUM3 = (double)-60.0F;
            } else {
               NUM1 = (double)(3L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.5F));
               NUM2 = (double)1.0F;
               NUM3 = (double)-60.0F;
               if (entity.getPersistentData().m_128459_("cnt_howl") < (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_howl", entity.getPersistentData().m_128459_("cnt_howl") + (double)1.0F);
               }
            }

            double var10001;
            label79: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity7 = (LivingEntity)entity;
                  if (_livingEntity7.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity7.m_21051_(Attributes.f_22281_).m_22115_();
                     break label79;
                  }
               }

               var10001 = (double)0.0F;
            }

            label74: {
               level_resistance = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * (double)3.0F) / (double)4.0F, (double)3.0F)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19600_)) {
                     break label74;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label69: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label69;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < level_resistance && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)level_resistance, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)1.0F) {
               AttackBeastProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var30;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var30 = _mobEnt.m_5448_();
               } else {
                  var30 = null;
               }

               if (!(var30 instanceof LivingEntity) && !(entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F)) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     ResetCounterProcedure.execute(entity);
                     if (entity instanceof DivineDogTotalityEntity) {
                        entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                        CalculateAttackProcedure.execute(world, entity);
                     } else {
                        entity.getPersistentData().m_128347_("cnt_x", NUM3 + (double)Math.round(NUM3 / (double)2.0F * Math.random()));
                        entity.getPersistentData().m_128347_("skill", (double)1.0F);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
