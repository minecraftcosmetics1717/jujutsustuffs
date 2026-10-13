package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IdleTransfigurationProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var18 = var10000;
         if (var18 instanceof LivingEntity) {
            entity.m_7618_(Anchor.EYES, new Vec3(((Entity)var18).m_20185_(), ((Entity)var18).m_20186_() + (double)((Entity)var18).m_20206_() * (double)0.75F, ((Entity)var18).m_20189_()));
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(2.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_PURPLE.get(), x_pos, y_pos, z_pos, (int)((double)1.0F * range), 0.1 * range, 0.1 * range, 0.1 * range, 0.1);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity20 = (LivingEntity)entity;
            if (_livingEntity20.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity20.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)618.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.2F);
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)6.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 1, 1, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)21.0F);
            entity.getPersistentData().m_128347_("Range", distance * (double)2.5F);
            entity.getPersistentData().m_128347_("effect", (double)2.0F);
            entity.getPersistentData().m_128347_("knockback", 0.1);
            entity.getPersistentData().m_128347_("effect", (double)12.0F);
            entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
            entity.getPersistentData().m_128379_("onlyLiving", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 15, 0.1, 0.1, 0.1, (double)4.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)12.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)(entity.getPersistentData().m_128459_("COOLDOWN_TICKS") * (double)2.0F), 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
