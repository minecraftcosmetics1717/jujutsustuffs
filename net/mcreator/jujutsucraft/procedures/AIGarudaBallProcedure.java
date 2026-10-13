package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIGarudaBallProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_attack = false;
         boolean big = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double rad = (double)0.0F;
         double rad_now = (double)0.0F;
         double dis = (double)0.0F;
         double z_power = (double)0.0F;
         double y_power = (double)0.0F;
         double x_power = (double)0.0F;
         double power = (double)0.0F;
         double entity_size = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F;
         z_pos = entity.m_20189_();
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get(), 5, 9, false, false));
            }
         }

         power = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt6") > (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)3.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 4.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 4.0F, 1.5F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)25.0F * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, (double)1.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)25.0F * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, (double)1.0F);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().m_128471_("Stop")) {
               entity.getPersistentData().m_128379_("Stop", true);
            } else {
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)2.0F, entity.getPersistentData().m_128459_("y_power") * (double)2.0F, entity.getPersistentData().m_128459_("z_power") * (double)2.0F));
               entity.getPersistentData().m_128347_("BlockRange", (double)4.0F * power * entity_size);
               entity.getPersistentData().m_128347_("BlockDamage", (double)18.0F * power);
               entity.getPersistentData().m_128347_("knockback", (double)1.5F);
               entity.getPersistentData().m_128379_("noParticle", true);
               entity.getPersistentData().m_128379_("ExtinctionBlock", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               dis = ReturnEntitySizeProcedure.execute(entity);
               entity.getPersistentData().m_128347_("Damage", (double)30.0F);
               if (entity.getPersistentData().m_128459_("cnt_life") > (double)0.0F) {
                  for(int index0 = 0; index0 < (int)Math.round(entity.getPersistentData().m_128459_("cnt_life")); ++index0) {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
                     if (entity.getPersistentData().m_128459_("Damage") < (double)24.0F) {
                        entity.getPersistentData().m_128347_("Damage", (double)24.0F);
                        break;
                     }
                  }
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * power);
               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
               entity.getPersistentData().m_128347_("Range", (double)8.0F * entity_size);
               entity.getPersistentData().m_128347_("knockback", (double)0.5F);
               entity.getPersistentData().m_128347_("effect", (double)1.0F);
               entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               ParticleGeneratorProcedure.execute(world, entity_size * (double)1.0F, (double)16.0F * entity_size, (double)45.0F, (double)16.0F, x_pos, x_pos - entity.getPersistentData().m_128459_("x_power"), y_pos, y_pos - entity.getPersistentData().m_128459_("y_power"), z_pos, z_pos - entity.getPersistentData().m_128459_("z_power"), "minecraft:crit");
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               entity.getPersistentData().m_128347_("despawn_flag", (double)1.0F);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
