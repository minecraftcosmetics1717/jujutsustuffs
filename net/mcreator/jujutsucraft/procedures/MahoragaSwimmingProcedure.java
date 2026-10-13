package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MahoragaSwimmingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean garuda = false;
         double distance = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double yaw_cal = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch_cal = (double)0.0F;
         double old_cnt1 = (double)0.0F;
         double old_skill = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         double dis = (double)0.0F;
         if (entity.getPersistentData().m_128459_("cnt10") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            entity.f_19789_ = 0.0F;
            range = ReturnEntitySizeProcedure.execute(entity);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(64.0F + entity.m_20205_());
            double var10000 = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            var10000 = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
            var10000 = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            LivingEntity var81;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var81 = _mobEnt.m_5448_();
            } else {
               var81 = null;
            }

            if (var81 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var81 = _mobEnt.m_5448_();
               } else {
                  var81 = null;
               }

               double var83 = ((Entity)var81).m_20185_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               double var86 = ((Entity)var10001).m_20186_();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               var86 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var83, var86, ((Entity)var10002).m_20189_(), entity);
            }

            yaw = (double)(entity.m_146908_() % 360.0F);
            pitch = (double)entity.m_146909_();
            RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * (double)32.0F, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * (double)32.0F, entity.m_20189_() + entity.m_20184_().m_7094_() * (double)32.0F, entity);
            entity.m_146922_(entity.m_146908_() % 360.0F);
            entity.m_146926_(entity.m_146909_());
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            yaw_cal = (double)entity.m_146908_() - yaw;
            if ((!(yaw_cal >= (double)180.0F) || !(yaw_cal < (double)360.0F)) && (!(yaw_cal >= (double)-180.0F) || !(yaw_cal < (double)0.0F))) {
               yaw += Math.min((double)360.0F - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)8.0F;
            } else {
               yaw -= Math.min((double)360.0F - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)8.0F;
            }

            pitch_cal = Math.abs((double)entity.m_146909_() - pitch);
            if (pitch > (double)entity.m_146909_()) {
               pitch -= pitch_cal / (double)8.0F;
            } else {
               pitch += pitch_cal / (double)8.0F;
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

            yaw = (double)(entity.m_146908_() % 360.0F);
            pitch = (double)entity.m_146909_();
            entity.m_146922_((float)yaw);
            entity.m_146926_(0.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)1.5F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)1.5F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)1.5F);

            for(int index0 = 0; index0 < (int)((double)36.0F * range); ++index0) {
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)entity.m_146909_(), Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F) * range, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)2.0F) * range, Mth.m_216263_(RandomSource.m_216327_(), (double)8.0F, (double)12.0F), entity.m_20185_(), entity.m_20185_() - entity.getPersistentData().m_128459_("x_power") * range, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F - entity.getPersistentData().m_128459_("y_power") * range, (double)entity.m_146908_(), entity.m_20189_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power") * range, "minecraft:crit");
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

            x_power = entity.getPersistentData().m_128459_("x_power") * (double)1.0F;
            y_power = entity.getPersistentData().m_128459_("y_power") * (double)1.0F;
            z_power = entity.getPersistentData().m_128459_("z_power") * (double)1.0F;
            entity.m_20256_(new Vec3(x_power, entity.m_20184_().m_7098_(), z_power));
            StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis != (double)0.0F) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var81 = _mobEnt.m_5448_();
            } else {
               var81 = null;
            }

            if (var81 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
               if (GetDistanceProcedure.execute(entity) < (double)10.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)30.0F && !entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", (double)60.0F);
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_();

            for(int index1 = 0; index1 < (int)Math.max(dis, (double)1.0F); ++index1) {
               entity.getPersistentData().m_128347_("Damage", (double)6.0F);
               entity.getPersistentData().m_128347_("Range", (double)3.0F * range);
               entity.getPersistentData().m_128347_("knockback", (double)1.5F);
               entity.getPersistentData().m_128347_("effect", (double)5.0F);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
            }

            entity.getPersistentData().m_128379_("attack", true);
            if (entity.getPersistentData().m_128459_("cnt1") % (double)4.0F == (double)1.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F, false);
                  }
               }

               int var10004;
               label137: {
                  var85 = entity.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10004 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label137;
                     }
                  }

                  var10004 = 0;
               }

               var85.m_128347_("BlockDamage", (double)2.5F + (double)0.25F * (double)var10004);
               entity.getPersistentData().m_128347_("BlockRange", (double)(entity.m_20206_() + entity.m_20205_()) * (double)0.5F);
               entity.getPersistentData().m_128347_("knockback", (double)1.0F);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") % (double)14.0F == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity99 = (LivingEntity)entity;
                  if (_livingEntity99.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity99.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-22.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity100 = (LivingEntity)entity;
                  if (_livingEntity100.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity100.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "swim_butterfly");
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)60.0F) {
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt5", (double)9.0F);
               entity.getPersistentData().m_128347_("cnt10", (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt10") != (double)0.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
