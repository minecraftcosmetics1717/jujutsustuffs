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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackNue2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack item_a = ItemStack.f_41583_;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double dis = (double)0.0F;
         double picth = (double)0.0F;
         double yaw = (double)0.0F;
         double HP = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") % (double)3.0F == (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            dis = (double)0.0F;

            for(int index0 = 0; index0 < 32; ++index0) {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               logic_a = false;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(Math.min((double)4.0F + dis, (double)16.0F) / (double)2.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     x_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123341_();
                     y_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123342_();
                     z_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123343_();
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }

               dis += (double)2.0F;
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
         } else if (entity.getPersistentData().m_128459_("cnt1") <= (double)3.0F) {
            x_pos = entity.getPersistentData().m_128459_("x_pos") + (Math.random() - (double)0.5F) * (double)48.0F;
            y_pos = entity.getPersistentData().m_128459_("y_pos") + (Math.random() - (double)0.5F) * (double)48.0F;
            z_pos = entity.getPersistentData().m_128459_("z_pos") + (Math.random() - (double)0.5F) * (double)48.0F;
         } else if (entity.getPersistentData().m_128459_("cnt1") <= (double)6.0F) {
            x_pos = entity.m_20185_() + (Math.random() - (double)0.5F) * (double)64.0F;
            y_pos = entity.m_20186_() + (Math.random() - (double)0.5F) * (double)64.0F;
            z_pos = entity.m_20189_() + (Math.random() - (double)0.5F) * (double)64.0F;
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)6.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") > (double)3.0F && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
               for(int index1 = 0; index1 < 16 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_(); ++index1) {
                  --y_pos;
               }
            }

            if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
               for(int index2 = 0; index2 < 16 && world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_(); ++index2) {
                  ++y_pos;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THUNDER_IMPACT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
