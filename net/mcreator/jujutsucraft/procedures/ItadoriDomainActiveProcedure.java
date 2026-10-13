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
import net.minecraft.world.level.LevelAccessor;

public class ItadoriDomainActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label61: {
            double old_skill = (double)0.0F;
            double ticks = (double)0.0F;
            range = (double)0.0F;
            double old_cooldown = (double)0.0F;
            double num1 = (double)0.0F;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label61;
               }
            }

            var10000 = (double)0.0F;
         }

         double var24 = var10000;
         if (var24 % (double)20.0F <= (double)5.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
            entity.getPersistentData().m_128379_("StartDomainAttack", false);
            double var23 = entity.getPersistentData().m_128459_("skill");
            double var26 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)60.0F);
            entity.getPersistentData().m_128347_("skill", (double)2108.0F);
            entity.getPersistentData().m_128347_("Damage", (double)15.0F + var24 % (double)20.0F);
            entity.getPersistentData().m_128347_("Range", range);
            entity.getPersistentData().m_128347_("effect", (double)4.0F);
            entity.getPersistentData().m_128379_("swing", false);
            entity.getPersistentData().m_128379_("attack", false);
            entity.getPersistentData().m_128379_("DomainAttack", true);
            RangeAttackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
            entity.getPersistentData().m_128347_("skill", var23);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var26);
         }

         if (!entity.getPersistentData().m_128471_("Failed")) {
            label49: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var32 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                     break label49;
                  }
               }

               var32 = 0;
            }

            if (var32 % 90 == 20) {
               if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               for(int index0 = 0; index0 < 8; ++index0) {
                  if (Math.random() < (double)0.5F) {
                     double var27 = Math.toRadians(Math.random() * (double)360.0F);
                     double var28 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(var27) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                     double var29 = entity.getPersistentData().m_128459_("y_pos_doma") + Math.random() * (double)0.5F;
                     double var30 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(var27) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.CROW.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var28, var29, var30), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           if (entityinstance instanceof CrowEntity) {
                              CrowEntity _datEntSetL = (CrowEntity)entityinstance;
                              _datEntSetL.m_20088_().m_135381_(CrowEntity.DATA_object, true);
                           }

                           entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
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
