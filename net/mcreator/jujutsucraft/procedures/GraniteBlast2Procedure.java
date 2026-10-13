package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class GraniteBlast2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean rotate = false;
         boolean SUCCESS = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double CNT6 = (double)0.0F;
         double damage = (double)0.0F;
         double picth = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double dis = (double)0.0F;
         double x_center = (double)0.0F;
         double y_center = (double)0.0F;
         double z_center = (double)0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var50 = var10000;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         picth = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 1.1 + Math.sin(picth) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, (float)range, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)((double)1.0F + CNT6), 0.05, 0.05, 0.05, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)((double)1.0F + CNT6), 0.05, 0.05, 0.05, 0.05);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)8.0F) {
               if (var50 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > (double)8.0F && (((Entity)var50).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var50).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var50).getPersistentData().m_128471_("attack") || ((Entity)var50).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)8.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  } else if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                     }

                     ChangeCurseEnergyProcedure.execute(entity, (double)-2.0F);
                  }
               }
            }

            if (var50 instanceof LivingEntity && (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F || entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt6") < (double)4.0F)) {
               RotateEntityProcedure.execute(((Entity)var50).m_20185_(), ((Entity)var50).m_20186_() + (double)((Entity)var50).m_20206_() * (double)0.5F, ((Entity)var50).m_20189_(), entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }
         } else {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (var50 instanceof LivingEntity) {
               entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
               entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") > (double)0.0F) {
               if (var50 instanceof LivingEntity) {
                  RotateEntityProcedure.execute(((Entity)var50).m_20185_(), ((Entity)var50).m_20186_() + (double)((Entity)var50).m_20206_() * (double)0.5F, ((Entity)var50).m_20189_(), entity);
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               }

               dis = (double)6.0F;

               for(int index0 = 0; index0 < 8; ++index0) {
                  x_center = entity.m_20185_() + entity.m_20154_().f_82479_ * dis;
                  y_center = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_ * dis;
                  z_center = entity.m_20189_() + entity.m_20154_().f_82481_ * dis;
                  Vec3 _center = new Vec3(x_center, y_center, z_center);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                     if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                        SUCCESS = true;
                        x_center = entityiterator.m_20185_();
                        y_center = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                        z_center = entityiterator.m_20189_();
                        break;
                     }
                  }

                  if (SUCCESS || entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                     break;
                  }

                  dis += (double)6.0F;
               }

               entity.getPersistentData().m_128347_("cnt3", (double)-2.0F);
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt4") == (double)1.0F && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:beam")), SoundSource.NEUTRAL, (float)(range * CNT6), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:beam")), SoundSource.NEUTRAL, (float)(range * CNT6), 1.0F, false);
                  }
               }

               int var10001;
               label185: {
                  damage = entity.getPersistentData().m_128459_("cnt6");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label185;
                     }
                  }

                  var10001 = 0;
               }

               HP = (double)(100 + var10001 * 10);
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               entity.m_146922_((float)(yaw + Mth.m_216263_(RandomSource.m_216327_(), (double)-67.5F, (double)67.5F)));
               entity.m_146926_((float)Math.max(Math.min(pitch + Mth.m_216263_(RandomSource.m_216327_(), (double)-67.5F, (double)0.0F), (double)90.0F), (double)-90.0F));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENERGY_BALL_WHITE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

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

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity108 = (LivingEntity)entityinstance;
                        if (_livingEntity108.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity108.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     double var10002;
                     double var10003;
                     label170: {
                        entityinstance.getPersistentData().m_128347_("cnt3", (double)1.0F);
                        var83 = entityinstance.getPersistentData();
                        var10002 = entity.getPersistentData().m_128459_("cnt6");
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt114 = (LivingEntity)entity;
                           if (_livEnt114.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                              var10003 = (double)-2.5F;
                              break label170;
                           }
                        }

                        var10003 = (double)0.0F;
                     }

                     var83.m_128347_("cnt6", var10002 + var10003);
                     entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.75F);
                     entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.75F);
                     entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.75F);
                     entityinstance.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)3.75F, entity.m_20154_().f_82480_ * (double)3.75F, entity.m_20154_().f_82481_ * (double)3.75F));
                     entityinstance.getPersistentData().m_128347_("target_x", x_center);
                     entityinstance.getPersistentData().m_128347_("target_y", y_center);
                     entityinstance.getPersistentData().m_128347_("target_z", z_center);
                     _serverLevel.m_7967_(entityinstance);
                  }
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

               byte var85;
               label164: {
                  var84 = entity.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt139 = (LivingEntity)entity;
                     if (_livEnt139.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        var85 = 13;
                        break label164;
                     }
                  }

                  var85 = 18;
               }

               var84.m_128347_("Damage", (double)var85 * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
               entity.getPersistentData().m_128347_("Range", (double)4.0F);
               entity.getPersistentData().m_128347_("knockback", (double)2.0F);
               DamageFixProcedure.execute(entity);

               for(int index1 = 0; index1 < (int)((double)18.0F * range); ++index1) {
                  ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)8.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "minecraft:crit");
                  ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)2.0F, (double)4.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "minecraft:cloud");
               }

               ParticleGeneratorCircleProcedure.execute(world, (double)36.0F * range, (double)entity.m_146909_(), (double)0.0F, (double)2.0F, (double)8.0F, x_pos, x_pos, y_pos, y_pos, (double)entity.m_146908_(), z_pos, z_pos, "minecraft:crit");
            }

            if (entity.getPersistentData().m_128459_("cnt4") > (double)6.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
