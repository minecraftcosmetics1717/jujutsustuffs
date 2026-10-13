package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TechniqueMahitoHand3Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double CNT6 = (double)0.0F;
         double distance = (double)0.0F;
         double rad1 = (double)0.0F;
         double width = (double)0.0F;
         double picth = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") % (double)6.0F == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity8 = (LivingEntity)entity;
               if (_livingEntity8.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity8.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-8.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            int var10001;
            label100: {
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)(entity.m_20206_() * 0.0F);
               z_pos = entity.m_20189_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label100;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(50 + var10001 * 10);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_MAHITO_HAND_3.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entityinstance;
                     if (_livingEntity20.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity20.m_21051_(Attributes.f_22276_).m_22100_((double)Math.round(HP));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)Math.round(HP));
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entityinstance;
                     if (_livingEntity24.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity24.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(ReturnEntitySizeProcedure.execute(entity));
                     }
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
            if (entity.getPersistentData().m_128459_("cnt2") < (double)50.0F) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
            } else if (entity.getPersistentData().m_128459_("cnt2") < (double)80.0F && GetDistanceNearestEnemyProcedure.execute(world, entity) < (double)8.0F) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
            }
         } else if (!(entity instanceof Player)) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
         }

         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)30.0F));
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F) {
            if (entity instanceof Player) {
               label116: {
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.m_150110_().f_35937_) {
                        break label116;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 80, 0, false, false));
                     }
                  }
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
