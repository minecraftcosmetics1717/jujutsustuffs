package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MeimeiDomainActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
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

            if (var10000 % 90 == 20) {
               if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               for(int index0 = 0; index0 < 8; ++index0) {
                  if (Math.random() < (double)0.5F) {
                     num1 = Math.toRadians(Math.random() * (double)360.0F);
                     x_pos = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                     y_pos = entity.getPersistentData().m_128459_("y_pos_doma") + Math.random() * (double)0.5F;
                     z_pos = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.CROW.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           if (entityinstance instanceof CrowEntity) {
                              CrowEntity _datEntSetL = (CrowEntity)entityinstance;
                              _datEntSetL.m_20088_().m_135381_(CrowEntity.DATA_object, true);
                           }

                           if (entityinstance instanceof TamableAnimal) {
                              TamableAnimal _toTame = (TamableAnimal)entityinstance;
                              if (entity instanceof Player) {
                                 Player _owner = (Player)entity;
                                 _toTame.m_21828_(_owner);
                              }
                           }

                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                           entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
