package net.mcreator.jujutsucraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityWaterEntity;
import net.mcreator.jujutsucraft.entity.MaxElephantEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DagonWaterSkillProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         boolean player = false;
         boolean blood = false;
         boolean logic_b = false;
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double strength = (double)0.0F;
         double HP = (double)0.0F;
         double y_velocity = (double)0.0F;
         double y_power = (double)0.0F;
         double level = (double)0.0F;
         double height = (double)0.0F;
         double distance = (double)0.0F;
         double CNT6 = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         dis = ReturnEntitySizeProcedure.execute(entity);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         blood = entity.getPersistentData().m_128459_("skill") == (double)1016.0F;
         if (!(entity instanceof MaxElephantEntity) && entity.getPersistentData().m_128459_("skill") == (double)805.0F) {
            if (entity.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity97 = (LivingEntity)entity;
                  if (_livingEntity97.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity97.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-3.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity98 = (LivingEntity)entity;
                  if (_livingEntity98.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity98.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (!(entity instanceof Player)) {
               entity.f_19789_ = 0.0F;
               y_velocity = Math.min(Math.max(y_velocity, (double)-0.5F), (double)0.5F);
               if (!entity.m_6144_()) {
                  height = GetHeightFromGroundProcedure.execute(world, entity);
                  if (height < (double)10.0F) {
                     y_velocity = entity.m_20184_().m_7098_() + 0.1;
                  } else if (height > (double)12.0F) {
                     y_velocity = entity.m_20184_().m_7098_() - 0.1;
                  } else {
                     y_velocity = (double)0.0F;
                  }
               }

               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), y_velocity, entity.m_20184_().m_7094_()));
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt5") < (double)100.0F && (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && GetDistanceProcedure.execute(entity) > (double)24.0F)) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)15.0F));
               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  ChargeParticleProcedure.execute(world, entity, (double)1.0F);
               } else {
                  ChargeParticleProcedure.execute(world, entity, (double)0.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }

               for(int index0 = 0; index0 < (int)(8.0F * entity.m_20206_()); ++index0) {
                  yaw = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
                  dis = Math.toRadians((double)0.0F);
                  distance = Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F);
                  x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(dis) * distance * (double)entity.m_20205_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() + (double)1.5F + Math.sin(dis) * (double)-1.0F * distance * (double)entity.m_20205_();
                  z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(dis) * distance * (double)entity.m_20205_();
                  y_pos += (distance - (double)0.5F) * (double)2.0F * (double)entity.m_20206_();
                  ParticleGeneratorProcedure.execute(world, (double)entity.m_20205_() * (double)0.25F, (double)1.0F, (double)0.0F, (double)2.0F, x_pos, x_pos + Math.cos(yaw + Math.toRadians((double)90.0F)) * Math.cos(dis) * distance * (double)entity.m_20205_(), y_pos, y_pos + Math.sin(dis) * (double)-1.0F * distance * (double)entity.m_20205_(), z_pos, z_pos + Math.sin(yaw + Math.toRadians((double)90.0F)) * Math.cos(dis) * distance * (double)entity.m_20205_(), "jujutsucraft:particle_water");
               }
            } else {
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt4") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity149 = (LivingEntity)entity;
                     if (_livingEntity149.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity149.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity150 = (LivingEntity)entity;
                     if (_livingEntity150.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity150.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (!(entity instanceof Player)) {
                     entity.m_146922_(entity.m_146908_());
                     entity.m_146926_(90.0F);
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

                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  dis = Math.toRadians((double)entity.m_146909_());
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(dis) * (0.6 + (double)entity.m_20205_()));
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(dis) * (double)-1.0F * (0.6 + (double)entity.m_20205_()));
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(dis) * (0.6 + (double)entity.m_20205_()));
                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_);
                  entity.getPersistentData().m_128347_("cnt7", entity.getPersistentData().m_128459_("x_pos"));
                  entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("y_pos"));
                  entity.getPersistentData().m_128347_("cnt9", entity.getPersistentData().m_128459_("z_pos"));
               }

               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               x_power = entity.getPersistentData().m_128459_("x_power") * 0.1;
               y_power = entity.getPersistentData().m_128459_("y_power") * 0.1;
               z_power = entity.getPersistentData().m_128459_("z_power") * 0.1;
               dis = (double)0.0F;

               for(int index1 = 0; index1 < 35; ++index1) {
                  ++dis;
                  if (dis > (double)0.0F) {
                     dis = (double)-10.0F;
                     entity.getPersistentData().m_128347_("Damage", (double)12.0F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)2.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F - (entity.getPersistentData().m_128459_("cnt1") - (double)20.0F) * 0.05);
                     entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  logic_a = false;
                  logic_b = false;
                  if ((dis == (double)-10.0F || dis == (double)-5.0F) && !world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), (double)0.5F, (double)0.5F, (double)0.5F), (e) -> true).isEmpty() && entity != (Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), (double)0.5F, (double)0.5F, (double)0.5F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                     }
                  })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((Object)null) && ((Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), (double)0.5F, (double)0.5F, (double)0.5F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                     }
                  })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((Object)null)).m_6084_()) {
                     logic_b = true;
                  }

                  if (world.m_46859_(BlockPos.m_274561_(x_pos + x_power, y_pos, z_pos))) {
                     x_pos += x_power;
                  } else {
                     logic_a = true;
                  }

                  if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + y_power, z_pos))) {
                     y_pos += y_power;
                  } else {
                     logic_a = true;
                  }

                  if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos + z_power))) {
                     z_pos += z_power;
                  } else {
                     logic_a = true;
                  }

                  if (logic_a || logic_b) {
                     entity.getPersistentData().m_128347_("cnt4", Math.max(entity.getPersistentData().m_128459_("cnt4") - (double)1.0F, (double)1.0F));
                     entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
                     entity.getPersistentData().m_128347_("Damage", (double)9.0F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)24.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F - (entity.getPersistentData().m_128459_("cnt1") - (double)20.0F) * 0.05);
                     entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (logic_a) {
                        entity.getPersistentData().m_128347_("BlockRange", (double)4.0F);
                        entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F * CNT6);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                        }
                     }

                     for(int index2 = 0; index2 < 36; ++index2) {
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)4.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)4.0F), x_pos, x_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, z_pos, z_pos, "jujutsucraft:particle_water_2");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos + (double)1.0F, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           entityinstance.m_146922_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
                           entityinstance.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)-22.5F, (double)0.0F));
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           entityinstance.getPersistentData().m_128347_("x_power", entityinstance.m_20154_().f_82479_ * (double)6.0F);
                           entityinstance.getPersistentData().m_128347_("y_power", entityinstance.m_20154_().f_82480_ * (double)6.0F);
                           entityinstance.getPersistentData().m_128347_("z_power", entityinstance.m_20154_().f_82481_ * (double)6.0F);
                           entityinstance.m_20256_(new Vec3(entityinstance.getPersistentData().m_128459_("x_power"), entityinstance.getPersistentData().m_128459_("y_power"), entityinstance.getPersistentData().m_128459_("z_power")));
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                     break;
                  }
               }

               entity.getPersistentData().m_128347_("x_pos", x_pos);
               entity.getPersistentData().m_128347_("y_pos", y_pos);
               entity.getPersistentData().m_128347_("z_pos", z_pos);
               x_pos = entity.getPersistentData().m_128459_("cnt7");
               y_pos = entity.getPersistentData().m_128459_("cnt8");
               z_pos = entity.getPersistentData().m_128459_("cnt9");

               for(int index3 = 0; index3 < 20; ++index3) {
                  ParticleGeneratorProcedure.execute(world, (double)0.5F, (double)1.0F, (double)5.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)5.0F, (double)10.0F), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_water");
               }

               if (entity.getPersistentData().m_128459_("cnt5") > (double)40.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt4") > (double)15.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }

               if (blood) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * dis), 0.1 * dis, 0.1 * dis, 0.1 * dis, (double)0.0F);
                  }
               } else {
                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  dis = Math.toRadians((double)entity.m_146909_());
                  x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(dis) * dis;
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(dis) * (double)-1.0F * dis;
                  z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(dis) * dis;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)((double)4.0F * dis), 0.1 * dis, 0.1 * dis, 0.1 * dis, (double)0.0F);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && GetDistanceProcedure.execute(entity) > (double)24.0F) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)13.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ChargeParticleProcedure.execute(world, entity, (double)10.0F);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, (double)0.0F);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               yaw = (double)(entity.m_146908_() % 360.0F);
               picth = (double)entity.m_146909_();
               entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)90.0F));
               entity.m_146926_((float)picth);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  x_pos = ((Entity)var10000).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  double var125 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var125 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                  LivingEntity var126;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var126 = _mobEnt.m_5448_();
                  } else {
                     var126 = null;
                  }

                  z_pos = ((Entity)var126).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)picth);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               dis = Math.toRadians((double)entity.m_146909_());
               distance = (double)(2.0F + entity.m_20205_()) * dis;
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(dis) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(dis) * (double)-1.0F * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(dis) * distance;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

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

                     entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * (double)0.75F * CNT6);
                     entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * (double)0.75F * CNT6);
                     entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * (double)0.75F * CNT6);
                     entityinstance.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F * CNT6, entity.getPersistentData().m_128459_("y_power") * (double)0.75F * CNT6, entity.getPersistentData().m_128459_("z_power") * (double)0.75F * CNT6));
                     if (blood) {
                        if (entityinstance instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntSetI = (EntityWaterEntity)entityinstance;
                           _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 1);
                        }

                        entityinstance.getPersistentData().m_128379_("death_painting", entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)10.0F || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)10.0F : entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))));
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (blood) {
                  int var10002;
                  label289: {
                     var127 = entity.getPersistentData().m_128459_("cnt2");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label289;
                        }
                     }

                     var10002 = 0;
                  }

                  if (var127 > (double)Math.min(20 + var10002, 35) * CNT6) {
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               } else {
                  int var129;
                  label294: {
                     var128 = entity.getPersistentData().m_128459_("cnt2");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var129 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label294;
                        }
                     }

                     var129 = 0;
                  }

                  if (var128 > (double)Math.min(10 + var129, 25) * CNT6) {
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               }
            }
         }

      }
   }
}
