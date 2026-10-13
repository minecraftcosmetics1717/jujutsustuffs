package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class TechniquePureLoveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double HP = (double)0.0F;
         boolean logic_a = false;
         boolean noControl = false;
         boolean summon = false;
         Entity entity_rika = null;
         Entity target_entity = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 100, 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
               entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("RIKA_UUID"));
               if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().m_128459_("friend_num") == entity_rika.getPersistentData().m_128459_("friend_num")) {
                  entity_rika.m_146922_(entity.m_146908_());
                  entity_rika.m_146926_(entity.m_146909_());
                  entity_rika.m_5618_(entity_rika.m_146908_());
                  entity_rika.m_5616_(entity_rika.m_146908_());
                  entity_rika.f_19859_ = entity_rika.m_146908_();
                  entity_rika.f_19860_ = entity_rika.m_146909_();
                  if (entity_rika instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_rika;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity_rika.m_6021_((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                  if (entity_rika instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_rika;
                     _serverPlayer.f_8906_.m_9774_((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-5.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_(), entity_rika.m_146908_(), entity_rika.m_146909_());
                  }

                  entity_rika.getPersistentData().m_128347_("skill", (double)0.0F);
                  entity_rika.getPersistentData().m_128347_("skill_num", (double)10.0F);
                  entity_rika.getPersistentData().m_128379_("flag_attack", true);
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var24 = var10000;
         if (entity.getPersistentData().m_128459_("cnt1") < (double)80.0F) {
            if (var24 instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 20, false, false));
                  }
               }

               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (((Entity)var24).getPersistentData().m_128459_("skill") == (double)1815.0F) {
                  if (((Entity)var24).getPersistentData().m_128459_("cnt1") < (double)80.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               } else {
                  if (((Entity)var24).getPersistentData().m_128459_("skill") == (double)0.0F) {
                     if (GetDistanceProcedure.execute(entity) >= (double)10.0F) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     } else {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  }

                  if (((Entity)var24).getPersistentData().m_128459_("skill") > (double)0.0F) {
                     if (((Entity)var24).getPersistentData().m_128471_("PRESS_Z")) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     } else {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") >= (double)180.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)78.0F));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)90.0F && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
