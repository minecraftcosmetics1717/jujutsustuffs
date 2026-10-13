package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletNailWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == (double)1.0F) {
            immediatesourceentity.getPersistentData().m_128347_("Nail", (double)1.0F);
            immediatesourceentity.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
            immediatesourceentity.getPersistentData().m_128347_("Damage", (double)6.0F * ((double)1.0F + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1));
         }

         if (Math.random() < (double)0.25F && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, 0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > (double)600.0F && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
