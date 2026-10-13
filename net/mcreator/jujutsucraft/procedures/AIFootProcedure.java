package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFootProcedure {
   public static void execute(LevelAccessor world, double x, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double move = (double)0.0F;
         double amount = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         entity.f_19789_ = 0.0F;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            if (entity.getPersistentData().m_128459_("cnt2") < (double)10.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (entity.getPersistentData().m_128471_("Stop") && !(entity.getPersistentData().m_128459_("cnt2") > (double)0.0F)) {
                  entity.getPersistentData().m_128379_("Stop", false);
               } else {
                  if (!InsideSolidCalculateProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F, entity.m_20189_(), (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F)) {
                     entity.m_6021_(x, entity.m_20186_() - (double)1.0F, z);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(x, entity.m_20186_() - (double)1.0F, z, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  BulletDomainHit2Procedure.execute(world, entity);
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
                  if (!InsideSolidCalculateProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F, entity.m_20189_(), (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F) && !(entity.getPersistentData().m_128459_("cnt2") > (double)0.0F)) {
                     entity.getPersistentData().m_128347_("Damage", (double)17.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                     entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
                     entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * (double)1.25F);
                     entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * (double)1.25F);
                     entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * (double)1.25F);
                     RangeAttackProcedure.execute(world, x, y_pos, z, entity);
                     entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
                     entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
                     entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
                     if (entity.getPersistentData().m_128459_("cnt1") > (double)50.0F && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  } else {
                     entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, entity.m_20186_(), z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, entity.m_20186_(), z, (int)((double)10.0F * range), (double)2.0F * range, (double)1.0F, (double)2.0F * range, (double)0.5F);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, entity.m_20186_(), z, (int)((double)10.0F * range), (double)2.0F * range, (double)1.0F, (double)2.0F * range, (double)0.5F);
                     }

                     entity.getPersistentData().m_128347_("Damage", (double)20.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                     entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
                     RangeAttackProcedure.execute(world, x, entity.m_20186_(), z, entity);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F * CNT6);
                     entity.getPersistentData().m_128347_("BlockRange", (double)2.0F * range);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y_pos, z, entity);
                     entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  }
               }
            } else {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt2") > (double)20.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
