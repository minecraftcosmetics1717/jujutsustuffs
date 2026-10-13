package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.DagonEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GuardEffectStartedappliedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         double speed = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double num3 = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double dis = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double old_skill = (double)0.0F;
         if (entity.m_6084_()) {
            if (!(entity instanceof Player)) {
               entity.m_20260_(true);
            }

            if (LogicStartPassiveProcedure.execute(entity)) {
               label93: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label93;
                     }
                  }

                  num1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                  num2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                  old_skill = entity.getPersistentData().m_128459_("skill");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entity;
                     if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        CompoundTag var10000;
                        int var10003;
                        label76: {
                           entity.getPersistentData().m_128347_("skill", (double)105.0F);
                           var10000 = entity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                 var10003 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                 break label76;
                              }
                           }

                           var10003 = 0;
                        }

                        var10000.m_128347_("Damage", (double)(15 + var10003 * 3));
                        entity.getPersistentData().m_128347_("Range", (double)(entity.m_20205_() + 32.0F));
                        entity.getPersistentData().m_128347_("effect", (double)2.0F);
                        entity.getPersistentData().m_128347_("knockback", (double)0.25F);
                        entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                        entity.getPersistentData().m_128379_("onlyRanged", true);
                        RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                        entity.getPersistentData().m_128379_("onlyRanged", false);
                     }
                  }

                  if (entity instanceof DagonEntity) {
                     int var46;
                     if (entity instanceof DagonEntity) {
                        DagonEntity _datEntI = (DagonEntity)entity;
                        var46 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
                     } else {
                        var46 = 0;
                     }

                     if (var46 > 0) {
                        int var48;
                        label67: {
                           entity.getPersistentData().m_128347_("skill", (double)805.0F);
                           var47 = entity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                 var48 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                 break label67;
                              }
                           }

                           var48 = 0;
                        }

                        var47.m_128347_("Damage", (double)(6 + var48 * 3) * (double)0.25F);
                        num1 = Math.toRadians(Math.random() * (double)360.0F);
                        num2 = (double)entity.m_20205_() + (double)1.5F;

                        for(int index0 = 0; index0 < 72; ++index0) {
                           if (Math.random() < (double)0.5F) {
                              x_pos = entity.m_20185_() + Math.sin(num1) * num2;
                              y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
                              z_pos = entity.m_20189_() + Math.cos(num1) * num2;
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_water_no_gravity ~ ~ ~ 0.1 0.1 0.1 0 1 force");
                              }
                           }

                           num1 += Math.toRadians(Math.random() * (double)10.0F);
                        }

                        entity.getPersistentData().m_128347_("Range", ((double)entity.m_20205_() + (double)1.5F) * (double)2.0F + (double)3.0F);
                        entity.getPersistentData().m_128347_("knockback", (double)0.25F);
                        entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                        entity.getPersistentData().m_128379_("onlyRanged", true);
                        RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                        entity.getPersistentData().m_128379_("onlyRanged", false);
                        entity.getPersistentData().m_128347_("knockback", (double)0.25F);
                        entity.getPersistentData().m_128347_("effect", (double)1.0F);
                        KnockbackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                        entity.getPersistentData().m_128347_("knockback", (double)0.0F);
                        entity.getPersistentData().m_128347_("effect", (double)0.0F);
                     }
                  }

                  entity.getPersistentData().m_128347_("skill", old_skill);
                  if (num1 == (double)38.0F || num2 == (double)38.0F || entity instanceof UroTakakoEntity) {
                     UroCounterProcedure.execute(world, entity);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               GuardSetDamageProcedure.execute(entity);
            }
         }

      }
   }
}
