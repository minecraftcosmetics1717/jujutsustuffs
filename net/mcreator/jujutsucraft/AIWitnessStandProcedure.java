package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class AIWitnessStandProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_target = null;
         Entity entity_owner = null;
         boolean flag_kill = false;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         entity_owner = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         entity_target = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("TARGET"));
         flag_kill = true;
         if (entity.m_6084_()) {
            if (entity_target instanceof LivingEntity) {
               flag_kill = false;
               if (entity_owner instanceof LivingEntity && entity_owner instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity_owner;
                  if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity_owner.getPersistentData().m_128471_("Failed")) {
                     flag_kill = false;
                     if (!(entity_target instanceof Player)) {
                        entity_target.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                           }
                        }

                        entity_target.m_146922_(entity.m_146908_());
                        entity_target.m_146926_(entity.m_146909_());
                        entity_target.m_5618_(entity_target.m_146908_());
                        entity_target.m_5616_(entity_target.m_146908_());
                        entity_target.f_19859_ = entity_target.m_146908_();
                        entity_target.f_19860_ = entity_target.m_146909_();
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entity_target.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
                        if (entity_target instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity_target.m_146908_(), entity_target.m_146909_());
                        }
                     } else {
                        x_power = entity.m_20185_() - entity_target.m_20185_();
                        y_power = entity.m_20186_() - entity_target.m_20186_();
                        z_power = entity.m_20189_() - entity_target.m_20189_();
                        if (x_power * x_power + z_power * z_power > (double)((entity_target.m_20205_() + 0.0F) * (entity_target.m_20205_() + 0.0F)) || y_power * y_power > (double)(entity_target.m_20205_() * 8.0F * entity_target.m_20205_() * 8.0F)) {
                           entity_target.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
                           if (entity_target instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity_target.m_146908_(), entity_target.m_146909_());
                           }
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 20, 0, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20, 1, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 20, 1, false, false));
                        }
                     }

                     if (entity_target.getPersistentData().m_128459_("skill") > (double)0.0F && entity_target.getPersistentData().m_128459_("skill") != (double)2719.0F && entity_target.getPersistentData().m_128459_("skill") != (double)2721.0F) {
                        entity_target.getPersistentData().m_128347_("skill", (double)0.0F);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity43 = (LivingEntity)entity;
                        if (_livingEntity43.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity43.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(((double)entity_target.m_20205_() + (double)1.5F) * (double)0.5F);
                        }
                     }
                  }
               }
            }

            if (entity_owner instanceof LivingEntity) {
               label91: {
                  if (entity_owner instanceof LivingEntity) {
                     LivingEntity _livEnt45 = (LivingEntity)entity_owner;
                     if (_livEnt45.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label91;
                     }
                  }

                  flag_kill = true;
               }
            } else {
               flag_kill = true;
            }
         }

         if (flag_kill && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
