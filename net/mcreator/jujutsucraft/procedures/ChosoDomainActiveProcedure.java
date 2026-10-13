package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class ChosoDomainActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double old_skill = (double)0.0F;
         double num1 = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
         if (!entity.getPersistentData().m_128471_("Failed")) {
            int var10000;
            label58: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                     break label58;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 45 == 20) {
               old_skill = entity.getPersistentData().m_128459_("skill");
               entity.getPersistentData().m_128347_("skill", (double)1016.0F);
               if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               for(int index0 = 0; index0 < 4; ++index0) {
                  if (Math.random() < (double)0.5F) {
                     num1 = Math.toRadians(Math.random() * (double)360.0F);
                     x_pos = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                     y_pos = entity.getPersistentData().m_128459_("y_pos_doma") + Math.random() * (double)0.5F;
                     z_pos = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           entityinstance.m_146922_(entity.m_146908_());
                           entityinstance.m_146926_(entity.m_146909_());
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           entityinstance.getPersistentData().m_128379_("death_painting", entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)10.0F || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)10.0F : entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))));
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  }
               }

               entity.getPersistentData().m_128347_("skill", old_skill);
            }
         }

      }
   }
}
