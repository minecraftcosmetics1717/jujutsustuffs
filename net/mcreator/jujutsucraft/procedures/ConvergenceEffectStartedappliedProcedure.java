package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.BloodBallEntity;
import net.mcreator.jujutsucraft.entity.ChosoEntity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade015Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ConvergenceEffectStartedappliedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label90: {
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double pitch = (double)0.0F;
            double num1 = (double)0.0F;
            double num2 = (double)0.0F;
            double num_blood = (double)0.0F;
            num1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            num2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            if (entity instanceof Player) {
               if (num1 != (double)10.0F && num2 != (double)10.0F && num1 != (double)803.0F && num2 != (double)803.0F) {
                  break label90;
               }
            } else if (!(entity instanceof ChosoEntity) && !(entity instanceof CursedSpiritGrade015Entity)) {
               break label90;
            }

            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            x_pos = entity.m_20185_() + Math.cos(Math.toRadians(yaw + (double)90.0F)) * Math.cos(Math.toRadians(pitch)) * (double)(1.0F + entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(Math.toRadians(pitch)) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(Math.toRadians(yaw + (double)90.0F)) * Math.cos(Math.toRadians(pitch)) * (double)(1.0F + entity.m_20205_());
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)32.0F), (e) -> true)) {
               if (entityiterator instanceof BloodBallEntity && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                  ++num_blood;
                  if (num_blood > (double)3.0F && !entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLOOD_BALL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                     }
                  }

                  entityinstance.getPersistentData().m_128379_("death_painting", num1 == (double)10.0F || num2 == (double)10.0F || num1 == (double)803.0F || num2 == (double)803.0F || entity.getPersistentData().m_128471_("CursedSpirit") || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))));
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            entity.m_146922_((float)yaw);
            entity.m_146926_((float)pitch);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }
         }

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
