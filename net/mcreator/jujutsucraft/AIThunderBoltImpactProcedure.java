package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIThunderBoltImpactProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_attack = false;
         boolean type = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double rad = (double)0.0F;
         double tsuki7_mode = (double)0.0F;
         double range = (double)0.0F;
         double cnt1_local = (double)0.0F;
         double rad_now = (double)0.0F;
         double dis = (double)0.0F;
         double cnt2 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") < (double)3.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123747_, x, y, z, 50, (double)5.0F, (double)5.0F, (double)5.0F, (double)1.0F);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") < (double)15.0F) {
               entity.getPersistentData().m_128347_("skill", (double)705.0F);
               entity.getPersistentData().m_128347_("Damage", (double)15.0F);
               entity.getPersistentData().m_128347_("Range", (double)8.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.25F);
               entity.getPersistentData().m_128347_("effect", (double)9.0F);
               RangeAttackProcedure.execute(world, x, y, z, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_thunder_purple ~ ~ ~ 0 0 0 2 50 force");
               }

               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("BlockRange", (double)10.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)0.25F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") > (double)30.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
