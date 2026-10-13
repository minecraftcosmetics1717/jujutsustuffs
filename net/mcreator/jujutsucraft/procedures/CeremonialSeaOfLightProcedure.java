package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class CeremonialSeaOfLightProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_center = (double)0.0F;
         double z_center = (double)0.0F;
         double num1 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_center = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double num3 = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double num2 = (double)0.0F;
         entity.getPersistentData().m_128347_("select", (double)14.0F);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
            dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            x_center = entity.getPersistentData().m_128459_("x_pos_doma");
            y_center = entity.getPersistentData().m_128459_("y_pos_doma");
            z_center = entity.getPersistentData().m_128459_("z_pos_doma");
            y_pos = y_center;
            if (entity.getPersistentData().m_128459_("cnt1") <= JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
               num1 = Math.toRadians(Math.random() * (double)720.0F);
               num2 = entity.getPersistentData().m_128459_("cnt1") / (double)2.0F;
               num3 = Math.toRadians((double)8.0F);

               for(int index0 = 0; index0 < 90; ++index0) {
                  x_pos = x_center + Math.sin(num1) * num2;
                  z_pos = z_center + Math.cos(num1) * num2;
                  if (Math.random() < (double)0.25F && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get(), x_pos, y_pos, z_pos, 1, (double)0.25F, Math.max(num2 / (double)10.0F, (double)0.25F), (double)0.25F, 0.05);
                  }

                  num1 += Math.random() * num3;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)34.0F) {
               for(int index1 = 0; index1 < 8; ++index1) {
                  x_pos = x_center + Math.cos(Math.toRadians(yaw)) * (dis - (double)6.0F);
                  z_pos = z_center + Math.sin(Math.toRadians(yaw)) * (dis - (double)6.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TREE_HANAMI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                        }

                        entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                        entityinstance.m_146926_(0.0F);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  yaw += (double)45.0F;
               }
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
