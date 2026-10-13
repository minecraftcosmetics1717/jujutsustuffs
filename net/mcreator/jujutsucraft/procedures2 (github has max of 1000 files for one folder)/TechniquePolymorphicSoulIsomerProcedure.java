package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class TechniquePolymorphicSoulIsomerProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double size = (double)0.0F;
         double dis = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         yaw = (double)entity.m_146908_();
         pitch = (double)entity.m_146909_();
         entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)120.0F));
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
         y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
         z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.POLYMORPHIC_SOUL_ISOMER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               entityinstance.m_146922_(entity.m_146908_());
               entityinstance.m_146926_(entity.m_146909_());
               entityinstance.m_5618_(entityinstance.m_146908_());
               entityinstance.m_5616_(entityinstance.m_146908_());
               entityinstance.f_19859_ = entityinstance.m_146908_();
               entityinstance.f_19860_ = entityinstance.m_146909_();
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
               entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity29 = (LivingEntity)entityinstance;
                  if (_livingEntity29.m_21204_().m_22171_(Attributes.f_22281_)) {
                     AttributeInstance var10000;
                     double var10001;
                     label72: {
                        var10000 = _livingEntity29.m_21051_(Attributes.f_22281_);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity25 = (LivingEntity)entityinstance;
                           if (_livingEntity25.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var10001 = _livingEntity25.m_21051_(Attributes.f_22281_).m_22115_();
                              break label72;
                           }
                        }

                        var10001 = (double)0.0F;
                     }

                     double var10002;
                     label67: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity26 = (LivingEntity)entity;
                           if (_livingEntity26.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var10002 = _livingEntity26.m_21051_(Attributes.f_22281_).m_22115_();
                              break label67;
                           }
                        }

                        var10002 = (double)0.0F;
                     }

                     int var10003;
                     label62: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label62;
                           }
                        }

                        var10003 = 0;
                     }

                     var10000.m_22100_(var10001 + (var10002 + (double)(var10003 * 3)) * (double)1.0F);
                  }
               }

               entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
               entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
               entityinstance.getPersistentData().m_128379_("Player", entity.getPersistentData().m_128471_("Player") || entity instanceof Player);
               _serverLevel.m_7967_(entityinstance);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)(entity.getPersistentData().m_128459_("COOLDOWN_TICKS") * (double)2.0F), 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
