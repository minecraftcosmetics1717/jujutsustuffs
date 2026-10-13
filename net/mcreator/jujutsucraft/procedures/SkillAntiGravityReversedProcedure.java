package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillAntiGravityReversedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         int var10000;
         label133: {
            boolean logic_a = false;
            double CNT6 = (double)0.0F;
            double strength = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            double dis = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label133;
               }
            }

            var10000 = 0;
         }

         double var23 = (double)Math.min(var10000, 50);
         double var24 = ReturnEntitySizeProcedure.execute(entity);
         double var22 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         double var29 = (double)entity.m_20205_() + (double)3.0F * var24;
         double var25 = entity.m_20185_();
         double var26 = entity.m_20186_();
         double var28 = entity.m_20189_();
         LivingEntity var45;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var45 = _mobEnt.m_5448_();
         } else {
            var45 = null;
         }

         if (var45 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var45 = _mobEnt.m_5448_();
            } else {
               var45 = null;
            }

            double var47 = ((Entity)var45).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var49 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var49 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var47, var49, ((Entity)var10002).m_20189_(), entity);
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.m_20256_(new Vec3((double)0.0F, Math.min(entity.m_20184_().m_7098_(), (double)0.0F), (double)0.0F));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var25, var26, var28), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gravity")), SoundSource.NEUTRAL, 1.0F, 0.5F);
               } else {
                  _level.m_7785_(var25, var26, var28, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gravity")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, var25, var26, var28, (int)((double)20.0F * var22), var24 * (double)2.5F, 0.1, var24 * (double)2.5F, 0.6);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var25, var26, var28), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)2.0F * var22), 1.0F);
               } else {
                  _level.m_7785_(var25, var26, var28, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)2.0F * var22), 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var25, var26, var28), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)2.0F * var22), 1.25F);
               } else {
                  _level.m_7785_(var25, var26, var28, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)2.0F * var22), 1.25F, false);
               }
            }
         }

         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var45 = _mobEnt.m_5448_();
         } else {
            var45 = null;
         }

         if (var45 instanceof LivingEntity) {
            entity.getPersistentData().m_128379_("PRESS_Z", true);
            var29 = GetDistanceNearestEnemyProcedure.execute(world, entity);
            if (var29 > (double)10.0F) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)20.0F));
         }

         if (entity instanceof Player) {
            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
         entity.getPersistentData().m_128347_("y_knockback", (double)-0.75F);
         entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
         var26 += (double)(6.0F + entity.m_20205_()) * var24 * (double)1.5F;

         for(int index0 = 0; index0 < 6; ++index0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var25, var26 + (double)6.0F * var24, var28), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_gravity ~ ~ ~ " + var24 * (double)2.5F + " " + var24 * (double)2.5F + " " + var24 * (double)2.5F + " 1 " + Math.round((double)4.0F * var24) + " force");
            }

            entity.getPersistentData().m_128347_("Damage", ((double)3.0F + entity.getPersistentData().m_128459_("cnt2") * 0.01) * var22);
            entity.getPersistentData().m_128347_("knockback", 0.001);
            entity.getPersistentData().m_128347_("Range", (double)(6.0F + entity.m_20205_()) * var24);
            entity.getPersistentData().m_128347_("effect", (double)17.0F);
            RangeAttackProcedure.execute(world, var25, var26, var28, entity);
            entity.getPersistentData().m_128347_("effect", (double)-1.0F);
            KnockbackProcedure.execute(world, var25, var26, var28, entity);
            if (Math.random() < 0.1) {
               entity.getPersistentData().m_128347_("BlockDamage", ((double)2.0F + var23 / (double)16.0F) * var22);
               entity.getPersistentData().m_128347_("BlockRange", (double)(6.0F + entity.m_20205_()) * var24);
               BlockDestroyAllDirectionProcedure.execute(world, var25, var26, var28, entity);
            }

            var26 -= (double)(6.0F + entity.m_20205_()) * var24 * (double)0.5F;
         }

         if (world.m_8055_(BlockPos.m_274561_(var25, var26, var28)).m_60815_() && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123796_, var25, var26, var28, (int)((double)12.0F * var22), var24 * (double)2.5F, var24 * (double)0.0F, var24 * (double)2.5F, 0.2 * var22);
         }

         entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
         entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
         entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
         entity.getPersistentData().m_128347_("Damage", (double)18.0F * var22);
         DamageFixProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt2") > (double)120.0F || entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
