package net.mcreator.jujutsucraft.procedures;

import java.util.ArrayList;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIRoundDeerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double NUM3 = (double)0.0F;
         double NUM1 = (double)0.0F;
         if (entity.m_6084_()) {
            double var10001;
            label96: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               NUM1 = (double)(4L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.5F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity2.m_21051_(Attributes.f_22281_).m_22115_();
                     break label96;
                  }
               }

               var10001 = (double)0.0F;
            }

            label91: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * (double)3.0F) / (double)4.0F, (double)3.0F)));
               NUM3 = (double)-60.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label91;
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
            label86: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label86;
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

            LivingEntity var29;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var29 = _mobEnt.m_5448_();
            } else {
               var29 = null;
            }

            if (var29 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var29 = _mobEnt.m_5448_();
               } else {
                  var29 = null;
               }

               if (!((Entity)var29).getPersistentData().m_128471_("CursedSpirit")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                     }
                  }
               } else if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                  for(Entity entityiterator : new ArrayList(world.m_6907_())) {
                     if (entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                        if (entityiterator.m_6144_() && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
                           }
                        }
                        break;
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt21 = (LivingEntity)entity;
               if (_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                  entity.getPersistentData().m_128347_("BaseCursePower", Math.max(entity.getPersistentData().m_128459_("BaseCursePower") - (double)1.0F, (double)0.0F));
               }
            }
         }

      }
   }
}
