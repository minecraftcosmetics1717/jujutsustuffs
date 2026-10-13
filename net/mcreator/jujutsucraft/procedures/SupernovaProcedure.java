package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BloodBallEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SupernovaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double HP = (double)0.0F;
         boolean logic_a = false;
         boolean pitch = false;
         boolean tick = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         picth = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * (0.6 + (double)entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(picth) * (double)-1.0F * (0.6 + (double)entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * (0.6 + (double)entity.m_20205_());
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity14 = (LivingEntity)entity;
            if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)20.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, 5, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.5F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt4") > (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt4", (double)-6.0F);
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceProcedure.execute(entity) < (double)8.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z") || entity.getPersistentData().m_128459_("cnt5") <= (double)1.0F) {
               logic_a = false;
               if (entity.getPersistentData().m_128459_("NameRanged") != (double)0.0F) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)25.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof BloodBallEntity && entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged")) {
                        entityiterator.getPersistentData().m_128379_("explode", true);
                        logic_a = true;
                        break;
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt5") >= (double)2.0F && (!logic_a || !entity.getPersistentData().m_128471_("PRESS_Z"))) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               if (entity instanceof Player) {
                  boolean _setval = true;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.noChangeTechnique = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }
            }
         }

      }
   }
}
