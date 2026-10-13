package net.mcreator.jujutsucraft.procedures;

import java.util.ArrayList;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MalevolentShrineActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double count_A;
         double var10000;
         int var10001;
         label186: {
            String STR1 = "";
            double old_skill = (double)0.0F;
            count_A = (double)0.0F;
            double z_center = (double)0.0F;
            double range = (double)0.0F;
            double old_cooldown = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double y_center = (double)0.0F;
            double dis = (double)0.0F;
            double dust_amount = (double)0.0F;
            double x_center = (double)0.0F;
            double num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            double num2 = (double)0.0F;
            var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                  break label186;
               }
            }

            var10001 = 0;
         }

         double var39 = var10000 * (double)(var10001 > 0 ? 18 : 2);
         double var36 = entity.getPersistentData().m_128459_("skill");
         double var40 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
         entity.getPersistentData().m_128347_("y_knockback", -0.1);

         for(int index0 = 0; index0 < 4; ++index0) {
            double var41;
            double var44;
            double var54;
            label177: {
               double var51 = count_A % (double)2.0F == (double)0.0F ? (double)1.0F : (double)-1.0F;
               double var57 = count_A % (double)4.0F <= (double)1.0F ? (double)1.0F : (double)-1.0F;
               var41 = entity.getPersistentData().m_128459_("x_pos_doma") + var39 * (double)0.25F * var51;
               var54 = entity.getPersistentData().m_128459_("y_pos_doma") + var39 * (double)0.25F - (double)15.0F;
               var44 = entity.getPersistentData().m_128459_("z_pos_doma") + var39 * (double)0.25F * var57;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var73 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                     break label177;
                  }
               }

               var73 = 0;
            }

            if (var73 % 2 == 1) {
               entity.getPersistentData().m_128347_("skill", (double)105.0F);
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)50.0F);
            } else {
               entity.getPersistentData().m_128347_("skill", (double)106.0F);
               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)100.0F);
            }

            int var10003;
            label171: {
               var74 = entity.getPersistentData();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10003 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                     break label171;
                  }
               }

               var10003 = 0;
            }

            var74.m_128347_("Damage", (double)10.5F + (double)(var10003 % 10) * 0.1);
            entity.getPersistentData().m_128347_("Range", var39 * (double)0.5F);
            entity.getPersistentData().m_128347_("effect", (double)1.0F);
            entity.getPersistentData().m_128347_("effectConfirm", (double)1.0F);
            entity.getPersistentData().m_128347_("knockback", 0.001);
            entity.getPersistentData().m_128379_("swing", false);
            entity.getPersistentData().m_128379_("attack", false);
            entity.getPersistentData().m_128379_("DomainAttack", true);
            entity.getPersistentData().m_128379_("ExtinctionBlock", true);
            RangeAttackProcedure.execute(world, var41, var54, var44, entity);
            ++count_A;
         }

         label163: {
            entity.getPersistentData().m_128379_("ExtinctionBlock", false);
            entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", var36);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var40);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var75 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                  break label163;
               }
            }

            var75 = 0;
         }

         if (var75 > 0) {
            if (entity.getPersistentData().m_128459_("dust_amount") <= (double)0.0F) {
               entity.getPersistentData().m_128347_("dust_amount", (double)1.0F);
            }

            double var50 = entity.getPersistentData().m_128459_("x_pos_doma");
            double var47 = entity.getPersistentData().m_128459_("y_pos_doma");
            double var38 = entity.getPersistentData().m_128459_("z_pos_doma");
            double var52 = (double)0.0F;

            for(int index1 = 0; index1 < 512; ++index1) {
               count_A = Math.toRadians(Math.random() * (double)360.0F);
               double var48 = var39 * (double)0.5F * (Math.random() * (double)2.0F - (double)1.0F);
               double var42 = var50 + Math.sin(count_A) * var48;
               double var55 = var47 + Math.random() * var39 * 0.2;
               double var45 = var38 + Math.cos(count_A) * var48;
               if (!world.m_46859_(BlockPos.m_274561_(var42, var55, var45))) {
                  entity.getPersistentData().m_128347_("dust_amount", Math.min(entity.getPersistentData().m_128459_("dust_amount") + (double)1.0F, (double)200.0F));
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, var42, var55, var45, 2, (double)1.5F, (double)1.5F, (double)1.5F, (double)0.0F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, var42, var55, var45, 2, (double)1.5F, (double)1.5F, (double)1.5F, (double)0.5F);
                  }

                  entity.getPersistentData().m_128379_("noParticle", true);
                  entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                  entity.getPersistentData().m_128347_("BlockRange", (double)16.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)99.0F);
                  BlockDestroyAllDirectionProcedure.execute(world, var42, Math.max(var55, var47 + (double)8.0F), var45, entity);
                  if (var52 < (double)32.0F || var52 / (double)512.0F < Math.random()) {
                     break;
                  }
               }

               ++var52;
            }

            double var49 = (double)Math.round(entity.getPersistentData().m_128459_("dust_amount") / (double)200.0F * (double)10.0F);
            if (entity instanceof Player) {
               label140: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var76 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                        break label140;
                     }
                  }

                  var76 = 0;
               }

               if (var76 % 10 == 0) {
                  String _setval = "DUST";
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY1 = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  _setval = "";
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY2 = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  String _setval = "§l§4";
                  var52 = (double)0.0F;

                  for(int index2 = 0; index2 < 10; ++index2) {
                     if (var52 == var49) {
                        _setval = _setval + "§r§7";
                     }

                     ++var52;
                     _setval = _setval + "■";
                  }

                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY2 = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            double var43 = entity.getPersistentData().m_128459_("x_pos_doma");
            double var56 = entity.getPersistentData().m_128459_("y_pos_doma");
            double var46 = entity.getPersistentData().m_128459_("z_pos_doma");
            if (entity.getPersistentData().m_128459_("skill") == (double)107.0F) {
               for(int index3 = 0; index3 < (int)(var49 + (double)1.0F); ++index3) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123790_, var43, var56, var46, 50, var39 * (double)0.25F, var39 * (double)0.25F, var39 * (double)0.25F, 0.1);
                  }
               }
            } else {
               for(int index4 = 0; index4 < (int)(var49 + (double)1.0F); ++index4) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123783_, var43, var56, var46, 50, var39 * (double)0.25F, var39 * (double)0.25F, var39 * (double)0.25F, 0.1);
                  }
               }
            }

            if (!entity.getPersistentData().m_128471_("Failed")) {
               for(Entity entityiterator : new ArrayList(world.m_6907_())) {
                  if (CanSeeSukunaSlashProcedure.execute(world, entity, entityiterator) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "particle jujutsucraft:particle_slash_large " + var50 + " " + var47 + " " + var38 + " " + var39 * (double)0.25F + " " + var39 * (double)0.25F + " " + var39 * (double)0.25F + " 0.01 " + Math.round((double)4.0F * var39) + " normal");
                  }
               }
            }
         }

      }
   }
}
