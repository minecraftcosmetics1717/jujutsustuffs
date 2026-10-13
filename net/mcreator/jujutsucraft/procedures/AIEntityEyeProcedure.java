package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityEyeRantaEntity;
import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEntityEyeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_entity = null;
         Entity target_entity = null;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double height = (double)0.0F;
         double cnt_life = (double)0.0F;
         double power = (double)0.0F;
         double distance = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double magnification = (double)0.0F;
         double old1 = (double)0.0F;
         double old2 = (double)0.0F;
         range = ReturnEntitySizeProcedure.execute(entity);
         height = (double)entity.m_20206_() * (double)0.75F;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         }

         if (!(owner_entity instanceof LivingEntity)) {
            owner_entity = entity;
         }

         target_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("TARGET"));
         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         cnt_life = entity.getPersistentData().m_128459_("cnt_life");
         entity.f_19789_ = 0.0F;
         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         entity.m_5997_((double)0.0F, (double)0.0F, (double)0.0F);
         if (Math.random() < (double)0.25F) {
            ParticleGeneratorCircleProcedure.execute(world, (double)36.0F * range, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), (double)0.0F, (double)1.0F, (double)4.0F, x_pos, x_pos, y_pos + height, y_pos + height, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), z_pos, z_pos, Math.random() < (double)0.5F ? "enchanted_hit" : "crit");
         }

         if (cnt_life < (double)10.0F) {
            if (cnt_life == (double)1.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)range, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)range, 0.5F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_IMPACT_WAVE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                     if (entityinstance instanceof EntityImpactWaveEntity) {
                        EntityImpactWaveEntity _datEntSetI = (EntityImpactWaveEntity)entityinstance;
                        _datEntSetI.m_20088_().m_135381_(EntityImpactWaveEntity.DATA_mode, 2);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity22 = (LivingEntity)entityinstance;
                        if (_livingEntity22.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity22.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                        }
                     }

                     if (entityinstance instanceof EntityImpactWaveEntity) {
                        EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entityinstance;
                        animatable.setTexture("hanako_hand");
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") - (double)0.0F);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            for(int index0 = 0; index0 < 8; ++index0) {
               ParticleGeneratorCircleProcedure.execute(world, (double)4.0F * range, (double)90.0F, (double)0.0F, (double)1.0F, (double)4.0F, x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, z_pos, z_pos, "jujutsucraft:particle_curse_power_red");
            }
         }

         if (target_entity instanceof LivingEntity) {
            target_entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
            if (target_entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)target_entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), target_entity.m_146908_(), target_entity.m_146909_());
            }

            if (cnt_life % (double)5.0F == (double)1.0F) {
               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 1, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COLOR.get(), 10, 1, false, false));
                  }
               }
            }

            if (cnt_life % (double)20.0F == (double)1.0F && LogicOwnerExistProcedure.execute(world, entity) && owner_entity instanceof LivingEntity) {
               int var10000;
               label324: {
                  if (target_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)target_entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label324;
                     }
                  }

                  var10000 = 0;
               }

               int var10001;
               label319: {
                  var89 = (double)Math.max(var10000 - 4, 0) * 1.2;
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)owner_entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label319;
                     }
                  }

                  var10001 = 0;
               }

               power = var89 - (double)Math.max(var10001 - 4, 0);
               if (power >= (double)0.0F) {
                  label313: {
                     if (owner_entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)owner_entity;
                        if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                           var90 = (double)_livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                           break label313;
                        }
                     }

                     var90 = (double)0.0F;
                  }

                  label308: {
                     old1 = var90;
                     if (owner_entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)owner_entity;
                        if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                           var91 = (double)_livEnt.m_21124_(MobEffects.f_19606_).m_19557_();
                           break label308;
                        }
                     }

                     var91 = (double)0.0F;
                  }

                  old2 = var91;
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_entity;
                     _entity.m_21195_(MobEffects.f_19606_);
                  }

                  owner_entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse")))), (float)((double)2.5F + power * (double)0.625F));
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, (int)old2, (int)old1, false, false));
                     }
                  }

                  if (owner_entity instanceof Player) {
                     magnification = (double)5.0F;
                  } else {
                     magnification = (double)1.0F;
                  }

                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse")))), (float)(((double)2.5F + power * (double)0.625F) * magnification));
                  float var92;
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)owner_entity;
                     var92 = _livEnt.m_21223_();
                  } else {
                     var92 = -1.0F;
                  }

                  double var93 = (double)var92 * range;
                  float var98;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var98 = _livEnt.m_21223_();
                  } else {
                     var98 = -1.0F;
                  }

                  if (var93 < (double)var98) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (owner_entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)owner_entity;
                           var98 = _livEnt.m_21223_();
                        } else {
                           var98 = -1.0F;
                        }

                        _entity.m_21153_((float)((double)var98 * range));
                     }

                     if (!owner_entity.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                     }
                  }

                  for(int index1 = 0; index1 < (int)Math.min(power + (double)1.0F, (double)10.0F); ++index1) {
                     Effect1Procedure.execute(world, entity, owner_entity);
                     if (!entity.m_6084_()) {
                        break;
                     }
                  }
               }
            }
         }

         if (cnt_life % (double)10.0F == (double)1.0F) {
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true)) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COLOR.get(), 15, 1, false, false));
                  }
               }
            }
         }

         for(int index2 = 0; index2 < (int)((double)4.0F * range); ++index2) {
            if (Math.random() < 0.2) {
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)1.0F, (double)0.5F + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, z_pos, z_pos, "cloud");
            } else {
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)1.0F, (double)1.5F + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.75F), x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, z_pos, z_pos, "jujutsucraft:particle_curse_power_red");
            }
         }

         if (cnt_life % (double)20.0F == (double)1.0F) {
            entity.getPersistentData().m_128347_("Damage", (double)9.0F);
            entity.getPersistentData().m_128347_("Range", (double)8.0F * range);
            entity.getPersistentData().m_128347_("knockback", (double)0.5F);
            entity.getPersistentData().m_128347_("effect", (double)0.0F);
            RangeAttackProcedure.execute(world, x_pos, y_pos + height, z_pos, entity);
            entity.getPersistentData().m_128347_("BlockRange", (double)2.0F * range);
            entity.getPersistentData().m_128347_("BlockDamage", (double)8.0F);
            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + height, z_pos, entity);
         }

         if (LogicOwnerExistProcedure.execute(world, entity)) {
            if (owner_entity instanceof LivingEntity) {
               if (owner_entity.getPersistentData().m_128459_("skill") <= (double)0.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }

               if (!entity.m_6084_() && owner_entity.getPersistentData().m_128459_("skill") > (double)0.0F) {
                  owner_entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }

               if (!(target_entity instanceof LivingEntity) && !(owner_entity instanceof Player)) {
                  owner_entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

         label357: {
            if (entity instanceof EntityEyeRantaEntity) {
               EntityEyeRantaEntity _datEntL84 = (EntityEyeRantaEntity)entity;
               if ((Boolean)_datEntL84.m_20088_().m_135370_(EntityEyeRantaEntity.DATA_damage1)) {
                  break label357;
               }
            }

            float var94;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var94 = _livEnt.m_21223_();
            } else {
               var94 = -1.0F;
            }

            double var95 = (double)var94;
            float var100;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var100 = _livEnt.m_21233_();
            } else {
               var100 = -1.0F;
            }

            if (var95 < (double)var100 * 0.6) {
               if (entity instanceof EntityEyeRantaEntity) {
                  EntityEyeRantaEntity _datEntSetL = (EntityEyeRantaEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(EntityEyeRantaEntity.DATA_damage1, true);
               }

               if (entity instanceof EntityEyeRantaEntity) {
                  EntityEyeRantaEntity animatable = (EntityEyeRantaEntity)entity;
                  animatable.setTexture("eye_ranta2");
               }
            }
         }

         if (entity instanceof EntityEyeRantaEntity) {
            EntityEyeRantaEntity _datEntL89 = (EntityEyeRantaEntity)entity;
            if ((Boolean)_datEntL89.m_20088_().m_135370_(EntityEyeRantaEntity.DATA_damage2)) {
               return;
            }
         }

         float var96;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var96 = _livEnt.m_21223_();
         } else {
            var96 = -1.0F;
         }

         double var97 = (double)var96;
         float var101;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var101 = _livEnt.m_21233_();
         } else {
            var101 = -1.0F;
         }

         if (var97 < (double)var101 * 0.3) {
            if (entity instanceof EntityEyeRantaEntity) {
               EntityEyeRantaEntity _datEntSetL = (EntityEyeRantaEntity)entity;
               _datEntSetL.m_20088_().m_135381_(EntityEyeRantaEntity.DATA_damage2, true);
            }

            if (entity instanceof EntityEyeRantaEntity) {
               EntityEyeRantaEntity animatable = (EntityEyeRantaEntity)entity;
               animatable.setTexture("eye_ranta3");
            }
         }

      }
   }
}
