package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
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

public class AttackTodoBlackFlashProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos;
         double y_pos;
         double z_pos;
         int var10000;
         label172: {
            boolean logic_a = false;
            boolean player = false;
            x_pos = (double)0.0F;
            y_pos = (double)0.0F;
            z_pos = (double)0.0F;
            double HP = (double)0.0F;
            double yaw = (double)0.0F;
            double pitch = (double)0.0F;
            double dis = (double)0.0F;
            double strength = (double)0.0F;
            double range = (double)0.0F;
            double loop_num = (double)0.0F;
            double CNT6 = (double)0.0F;
            double entity_size = (double)0.0F;
            double distance = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            double x_power = (double)0.0F;
            player = entity instanceof Player;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label172;
               }
            }

            var10000 = 0;
         }

         double var61 = (double)Math.min(var10000, 50);
         double var64 = ReturnEntitySizeProcedure.execute(entity);
         double var62 = var64 * ((double)1.0F + var61 * 0.025);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt6", (double)99999.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            LivingEntity var91;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var91 = _mobEnt.m_5448_();
            } else {
               var91 = null;
            }

            if (var91 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.m_5448_();
               } else {
                  var91 = null;
               }

               x_pos = ((Entity)var91).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.m_5448_();
               } else {
                  var91 = null;
               }

               double var94 = ((Entity)var91).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var94 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var95;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var95 = _mobEnt.m_5448_();
               } else {
                  var95 = null;
               }

               z_pos = ((Entity)var95).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               double var59 = GetDistanceProcedure.execute(entity);
               if (var59 > (double)4.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") >= (double)200.0F) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)9.0F));
               entity.getPersistentData().m_128379_("free", true);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               GetPowerFixProcedure.execute(entity);
               if (entity.m_6144_()) {
                  entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * 0.1);
                  entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * 0.1);
                  entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * 0.1);
               } else {
                  entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * 0.2);
                  entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * 0.2);
                  entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * 0.2);
               }

               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power"), entity.m_20184_().m_7098_(), entity.getPersistentData().m_128459_("z_power")));
            }

            PlayAnimationProcedure.execute(world, entity);
            double var55 = (double)entity.m_146908_();
            double var57 = (double)entity.m_146909_();
            entity.m_146922_((float)var55);
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

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            double var69 = entity.m_20154_().f_82479_;
            double var65 = entity.m_20154_().f_82480_;
            double var67 = entity.m_20154_().f_82481_;
            ParticleGeneratorCircleProcedure.execute(world, (double)16.0F * var62, (double)entity.m_146909_(), (double)1.0F * var62, (double)1.5F * var62, (double)4.0F, x_pos, x_pos - var69 * var62, y_pos, y_pos - var65 * var62, (double)entity.m_146908_(), z_pos, z_pos - var67 * var62, "minecraft:enchanted_hit");
            ParticleGeneratorProcedure.execute(world, var62 * (double)1.0F, (double)8.0F * var62, (double)22.5F, (double)4.0F, x_pos, x_pos - var69, y_pos, y_pos - var65, z_pos, z_pos - var67, "minecraft:enchanted_hit");
            entity.m_146922_((float)var55);
            entity.m_146926_((float)var57);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }
         } else {
            LivingEntity var96;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var96 = _mobEnt.m_5448_();
            } else {
               var96 = null;
            }

            if (var96 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.m_5448_();
               } else {
                  var96 = null;
               }

               x_pos = ((Entity)var96).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.m_5448_();
               } else {
                  var96 = null;
               }

               double var99 = ((Entity)var96).m_20186_();
               LivingEntity var101;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var101 = _mobEnt.m_5448_();
               } else {
                  var101 = null;
               }

               y_pos = var99 + (double)((Entity)var101).m_20206_() * (double)0.5F;
               LivingEntity var100;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var100 = _mobEnt.m_5448_();
               } else {
                  var100 = null;
               }

               z_pos = ((Entity)var100).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (entity.getPersistentData().m_128459_("cnt3") <= (double)1.0F) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * (double)0.5F), 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * (double)0.5F), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var62 * (double)0.5F), 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(var62 * (double)0.5F), 0.5F, false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt3") <= (double)1.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity82 = (LivingEntity)entity;
                     if (_livingEntity82.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity82.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-6.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity83 = (LivingEntity)entity;
                     if (_livingEntity83.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity83.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            double var63 = (double)Math.round((double)6.0F * var64);
            double var56 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            double var58 = Math.toRadians((double)entity.m_146909_());
            double var60 = (double)0.0F;

            for(int index0 = 0; index0 < (int)var63; ++index0) {
               x_pos = entity.m_20185_() + Math.cos(var56) * Math.cos(var58) * var60;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(var58) * (double)-1.0F * var60;
               z_pos = entity.m_20189_() + Math.sin(var56) * Math.cos(var58) * var60;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)((double)2.0F * var62), 0.05 * var62, 0.05 * var62, 0.05 * var62, 0.1);
               }

               if (Math.random() < 0.2 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)1.0F * var62), 0.1 * var62, 0.1 * var62, 0.1 * var62, 0.15);
               }

               entity.getPersistentData().m_128347_("Damage", (double)16.0F);
               entity.getPersistentData().m_128347_("knockback", (double)2.0F);
               entity.getPersistentData().m_128347_("Range", (double)4.0F * var64);
               entity.getPersistentData().m_128347_("effect", (double)5.0F);
               entity.getPersistentData().m_128347_("projectile_type", (double)5.0F);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("BlockDamage", 0.2 + var61 / (double)16.0F);
               entity.getPersistentData().m_128347_("BlockRange", (double)0.75F * var62);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               var60 += (double)0.5F * var64;
            }

            double var70 = entity.m_20154_().f_82479_;
            double var66 = entity.m_20154_().f_82480_;
            double var68 = entity.m_20154_().f_82481_;
            ParticleGeneratorCircleProcedure.execute(world, (double)36.0F * var62, (double)entity.m_146909_(), (double)0.0F * var62, 0.1 * var62, (double)8.0F, x_pos, x_pos - var70 * var62, y_pos, y_pos - var66 * var62, (double)entity.m_146908_(), z_pos, z_pos - var68 * var62, "minecraft:enchanted_hit");
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();

            for(int index1 = 0; index1 < (int)((double)12.0F * var62); ++index1) {
               ParticleGeneratorProcedure.execute(world, var62 * (double)0.5F, (double)1.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)4.0F, (double)8.0F), x_pos, x_pos + var70, y_pos, y_pos + var66, z_pos, z_pos + var68, "minecraft:enchanted_hit");
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
