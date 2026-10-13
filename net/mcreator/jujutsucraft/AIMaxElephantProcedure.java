package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIMaxElephantProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double rnd = (double)0.0F;
         double NUM1 = (double)0.0F;
         if (entity.m_6084_()) {
            double var10001;
            label77: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               MaxElephantFallProcedure.execute(world, x, y, z, entity);
               NUM1 = (double)(7L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.5F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity2.m_21051_(Attributes.f_22281_).m_22115_();
                     break label77;
                  }
               }

               var10001 = (double)0.0F;
            }

            label72: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * (double)3.0F) / (double)4.0F, (double)3.0F)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label72;
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
            label67: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label67;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)NUM2, false, false));
               }
            }

            LivingEntity var25;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var25 = _mobEnt.m_5448_();
            } else {
               var25 = null;
            }

            if (var25 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  if (LogicStartProcedure.execute(entity)) {
                     if (entity.getPersistentData().m_128471_("domain_entity")) {
                        if (entity.m_20096_()) {
                           entity.getPersistentData().m_128379_("flag_despawn", true);
                        }
                     } else {
                        entity.getPersistentData().m_128347_("cnt_x", (double)-60.0F);
                        ResetCounterProcedure.execute(entity);
                        rnd = (double)5.0F;
                        entity.getPersistentData().m_128347_("skill", (double)Math.round((double)800.0F + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
