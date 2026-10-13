package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class MaxElephantFallProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean dis = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double level_jump = (double)0.0F;
         double level = (double)0.0F;
         double level_speed = (double)0.0F;
         if (entity.m_20096_() && entity.getPersistentData().m_128471_("flag_fall")) {
            HP = entity.getPersistentData().m_128459_("skill");
            entity.getPersistentData().m_128347_("skill", (double)1.0F);
            entity.getPersistentData().m_128379_("flag_fall", false);
            entity.getPersistentData().m_128347_("Damage", (double)14.0F);
            entity.getPersistentData().m_128347_("Range", (double)(3.0F + entity.m_20205_()));
            entity.getPersistentData().m_128347_("knockback", (double)2.0F);
            entity.getPersistentData().m_128379_("swing", true);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("skill", HP);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)((double)25.0F * ReturnEntitySizeProcedure.execute(entity)), (double)0.5F * (double)entity.m_20205_(), (double)0.0F, (double)0.5F * (double)entity.m_20205_(), (double)0.0F);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)((double)25.0F * ReturnEntitySizeProcedure.execute(entity)), (double)0.5F * (double)entity.m_20205_(), (double)0.0F, (double)0.5F * (double)entity.m_20205_(), (double)0.25F);
            }
         }

         if (entity.m_20184_().m_7098_() < (double)-0.25F) {
            entity.getPersistentData().m_128379_("flag_fall", true);
         } else {
            entity.getPersistentData().m_128379_("flag_fall", false);
         }

      }
   }
}
