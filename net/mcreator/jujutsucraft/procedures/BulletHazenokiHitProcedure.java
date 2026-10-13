package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.BulletEyeEntity;
import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletHazenokiHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double old_skill = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         double HP = (double)0.0F;
         CNT6 = (double)1.0F + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ((double)1.0F + ReturnEntitySizeProcedure.execute(immediatesourceentity)) * CNT6;
         old_skill = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
         if (immediatesourceentity instanceof BulletEyeEntity) {
            HP = (double)40.0F;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_IMPACT_WAVE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity7 = (LivingEntity)entityinstance;
                     if (_livingEntity7.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity7.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  entityinstance.getPersistentData().m_128347_("cnt6", immediatesourceentity.getPersistentData().m_128459_("cnt6"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entityinstance;
                     if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                     }
                  }

                  if (entityinstance instanceof EntityImpactWaveEntity) {
                     EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entityinstance;
                     animatable.setTexture("clear");
                  }

                  if (entityinstance instanceof EntityImpactWaveEntity) {
                     EntityImpactWaveEntity _datEntSetI = (EntityImpactWaveEntity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(EntityImpactWaveEntity.DATA_mode, 1);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         } else {
            entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F * CNT6);
            entity.getPersistentData().m_128347_("BlockRange", (double)6.0F * range);
            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("Damage", immediatesourceentity.getPersistentData().m_128459_("Damage"));
            entity.getPersistentData().m_128347_("knockback", (double)0.5F * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)12.0F * range);
            entity.getPersistentData().m_128379_("attack", false);
            RangeAttackProcedure.execute(world, x, y, z, entity);
         }

         entity.getPersistentData().m_128347_("skill", old_skill);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)2.0F * CNT6), 0.8F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)2.0F * CNT6), 0.8F, false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)2.0F * CNT6), 0.8F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)2.0F * CNT6), 0.8F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:explosion ~ ~ ~ " + range * (double)2.0F + " " + range * (double)2.0F + " " + range * (double)2.0F + " " + (double)0.5F * CNT6 + " " + Math.round((double)20.0F * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_big_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + (double)0.5F * CNT6 + " " + Math.round((double)20.0F * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:cloud ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + (double)1.0F * CNT6 + " " + Math.round((double)10.0F * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:large_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + (double)1.0F * CNT6 + " " + Math.round((double)10.0F * CNT6 * range) + " force");
         }

         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
