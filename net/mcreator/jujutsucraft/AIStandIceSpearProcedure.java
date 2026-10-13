package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIStandIceSpearProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         if (entity.getPersistentData().m_128459_("move") == (double)1.0F) {
            AIStandIceSpear2Procedure.execute(world, x, y, z, entity);
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
               entity.getPersistentData().m_128347_("cnt4", (double)0.0F);
               if (entity.getPersistentData().m_128459_("cnt3") > (double)20.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }

               entity.m_20256_(new Vec3((double)0.0F, entity.m_20184_().m_7098_(), (double)0.0F));
               if (entity.getPersistentData().m_128459_("cnt2") > (double)10.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123815_, x, y, z, 8, 0.2, 0.2, 0.2, 0.2);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x, y, z, 4, 0.2, 0.2, 0.2, 0.2);
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)20.0F);
                  entity.getPersistentData().m_128347_("Range", (double)5.0F * ReturnEntitySizeProcedure.execute(entity));
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("effect", (double)14.0F);
                  RangeAttackProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F);
                  BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               }

               entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               entity.getPersistentData().m_128347_("cnt3", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt4") > (double)100.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }

               if (entity.getPersistentData().m_128459_("cnt2") > (double)10.0F) {
                  BulletDomainHit2Procedure.execute(world, entity);
                  entity.getPersistentData().m_128347_("Damage", (double)20.0F);
                  entity.getPersistentData().m_128347_("Range", (double)5.0F * ReturnEntitySizeProcedure.execute(entity));
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("effect", (double)14.0F);
                  RangeAttackProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, z, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)200.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         }

      }
   }
}
