package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class CoffinoftheIronMountainActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label100: {
            double old_skill = (double)0.0F;
            double z_center = (double)0.0F;
            range = (double)0.0F;
            double old_cooldown = (double)0.0F;
            double x_pos = (double)0.0F;
            double tick = (double)0.0F;
            double y_center = (double)0.0F;
            double z_pos = (double)0.0F;
            double x_center = (double)0.0F;
            double num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            double num3 = (double)0.0F;
            double num2 = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label100;
               }
            }

            var10000 = (double)0.0F;
         }

         double var38 = var10000;
         double var43 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var39 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var32 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (var38 % (double)10.0F == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, var43, var39, var32, 15, range * (double)0.25F, range * (double)0.25F, range * (double)0.25F, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123784_, var43, var39, var32, 40, range * (double)0.25F, range * (double)0.25F, range * (double)0.25F, 0.1);
            }

            if (Math.random() < (double)0.5F) {
               double var44 = Math.toRadians(Math.random() * (double)360.0F);
               double var49 = Math.random() * range - range / (double)2.0F;
               double var35 = var43 + Math.sin(var44) * var49;
               double var40 = var32 + Math.cos(var44) * var49;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var35, var39, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                  } else {
                     _level.m_7785_(var35, var39, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                  }
               }

               if (Math.random() < 0.3 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123756_, var35, var39, var40, 30, (double)0.25F, (double)4.0F, (double)0.25F, (double)0.0F);
               }
            }

            if (var38 % (double)20.0F == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
               entity.getPersistentData().m_128379_("StartDomainAttack", false);
               double var31 = entity.getPersistentData().m_128459_("skill");
               double var34 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)60.0F);
               entity.getPersistentData().m_128347_("skill", (double)406.0F);
               entity.getPersistentData().m_128347_("Damage", (double)9.0F);
               entity.getPersistentData().m_128347_("Range", range);
               entity.getPersistentData().m_128347_("effect", (double)6.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.0F);
               entity.getPersistentData().m_128379_("swing", false);
               entity.getPersistentData().m_128379_("attack", false);
               entity.getPersistentData().m_128379_("DomainAttack", true);
               RangeAttackProcedure.execute(world, var43, var39, var32, entity);
               entity.getPersistentData().m_128347_("skill", var31);
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var34);
            }
         }

         if (var38 % (double)5.0F == (double)0.0F && var38 % (double)10.0F == (double)0.0F) {
            double var45 = Math.toRadians(Math.random() * (double)720.0F);
            double var36 = var43 + Math.sin(var45) * (range / (double)2.0F - (double)5.0F);
            double var41 = var32 + Math.cos(var45) * (range / (double)2.0F - (double)5.0F);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123756_, var36, var39, var41, 20, 0.1, (double)4.0F, 0.1, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), var36, var39, var41, 40, 0.1, (double)4.0F, 0.1, (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2_forDomain") > (double)20.0F) {
            entity.getPersistentData().m_128347_("cnt2_forDomain", (double)0.0F);
         }

         double var46 = entity.getPersistentData().m_128459_("cnt1_forDomain");
         double var50 = entity.getPersistentData().m_128459_("cnt2_forDomain");

         for(int index0 = 0; index0 < 40; ++index0) {
            double var48 = var46;

            for(int index1 = 0; index1 < 4; ++index1) {
               double var37 = var43 + Math.sin(var46) * var50;
               double var47 = var39 + (double)0.0F;
               double var42 = var32 + Math.cos(var46) * var50;
               if (Math.random() < (double)0.25F + var50 / (range * (double)0.5F) && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, var37, var47, var42, 1, (double)0.0F, 0.05, (double)0.0F, (double)0.0F);
               }

               if (var50 + 0.1 > range * (double)0.5F && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, var37, var47, var42, 20, 0.1, (double)4.0F, 0.1, 0.1);
               }

               var46 += Math.toRadians((double)90.0F);
            }

            var46 = var48 + Math.toRadians((Math.random() - (double)0.5F) * (double)10.0F);
            var50 += 0.1;
            if (var50 > range * (double)0.5F - (double)4.0F) {
               var46 = Math.toRadians(Math.random() * (double)720.0F);
               var50 = (double)0.0F;
            }
         }

         entity.getPersistentData().m_128347_("cnt1_forDomain", var46);
         entity.getPersistentData().m_128347_("cnt2_forDomain", var50);
      }
   }
}
