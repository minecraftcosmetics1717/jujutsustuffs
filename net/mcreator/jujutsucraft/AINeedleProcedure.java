package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.HanakoHandEntity;
import net.mcreator.jujutsucraft.entity.NeedleEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AINeedleProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)4.0F) {
            entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
            BulletDomainHit2Procedure.execute(world, entity);
         }

         if (entity instanceof HanakoHandEntity && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123765_, x, y, z, (int)Math.max(entity.m_20205_() * 2.0F, 1.0F), (double)entity.m_20205_() * (double)0.5F, (double)0.0F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
               if (entity instanceof NeedleEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "attack");
               }

               if (entity instanceof HanakoHandEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "attack");
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)7.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               x_power = (double)0.0F;
               y_power = (double)1.0F;
               z_power = (double)0.0F;

               for(int index0 = 0; index0 < (int)Math.ceil((double)entity.m_20206_()); ++index0) {
                  entity.getPersistentData().m_128347_("Damage", (double)10.0F * CNT6);
                  if (entity instanceof NeedleEntity) {
                     entity.getPersistentData().m_128347_("effect", (double)1.0F);
                     entity.getPersistentData().m_128347_("knockback", 0.01);
                     entity.getPersistentData().m_128347_("Range", (double)2.5F + (double)(entity.m_20205_() * 2.0F));
                  } else if (entity instanceof HanakoHandEntity) {
                     entity.getPersistentData().m_128347_("effect", (double)5.0F);
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("cnt6") < (double)3.0F ? 0.01 : (double)1.25F);
                     entity.getPersistentData().m_128347_("Range", (double)(4.0F + entity.m_20205_() * 2.0F));
                  }

                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)35.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         }

      }
   }
}
