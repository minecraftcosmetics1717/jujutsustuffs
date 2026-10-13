package net.mcreator.jujutsucraft.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AIResonanceProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double range_fix = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double NUM1 = (double)0.0F;
         Entity entity_a = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("TARGET"));
         if (entity_a instanceof LivingEntity) {
            entity.m_6021_(entity_a.m_20185_() + entity.getPersistentData().m_128459_("x_pos"), entity_a.m_20186_() + entity.getPersistentData().m_128459_("y_pos"), entity_a.m_20189_() + entity.getPersistentData().m_128459_("z_pos"));
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + entity.getPersistentData().m_128459_("x_pos"), entity_a.m_20186_() + entity.getPersistentData().m_128459_("y_pos"), entity_a.m_20189_() + entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
            }

            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 9, false, false));
               }
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            entity.getPersistentData().m_128347_("Damage", (double)20.0F * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)1.0F * range_fix);
            entity.getPersistentData().m_128347_("knockback", (double)0.5F);
            entity.getPersistentData().m_128347_("effect", (double)1.0F);
            entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
            entity.getPersistentData().m_128379_("ignore", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
