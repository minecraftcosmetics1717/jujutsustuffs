package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityWaterEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWaterProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_b = false;
         boolean logic_a = false;
         Entity entity_a = null;
         double range = (double)0.0F;
         double rnd = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         double yaw = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double size = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double pitch = (double)0.0F;
         if (entity.getPersistentData().m_128459_("skill") == (double)1016.0F) {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
               _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 1);
            }
         } else if (entity.getPersistentData().m_128459_("skill") == (double)409.0F) {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
               _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 2);
            }
         } else if (entity instanceof EntityWaterEntity) {
            EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
            _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 0);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)(entity.m_20206_() * 0.0F);
         z_pos = entity.m_20189_();
         x_power = entity.m_20184_().m_7096_();
         y_power = entity.m_20184_().m_7098_();
         z_power = entity.m_20184_().m_7094_();
         speed = Math.max(Math.min(Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power), (double)2.0F), (double)-2.0F);
         int var10000;
         if (entity instanceof EntityWaterEntity) {
            EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
            var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
         } else {
            var10000 = 0;
         }

         if (var10000 == 2) {
            ParticleGeneratorProcedure.execute(world, range * (double)2.0F, (double)1.0F * range, (double)25.0F, (double)2.0F * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_magma");
         } else {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               ParticleGeneratorProcedure.execute(world, range * (double)2.0F, (double)2.0F * range, (double)25.0F, (double)0.5F * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_blood_2");
               if (entity.m_20071_() && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            } else {
               ParticleGeneratorProcedure.execute(world, range * (double)2.0F, (double)2.0F * range, (double)25.0F, (double)0.5F * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_water_2");
               ParticleGeneratorProcedure.execute(world, range * (double)2.0F, (double)2.0F * range, (double)25.0F, (double)0.5F * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_water");
            }
         }

         if (entity.m_6084_()) {
            size = ReturnEntitySizeProcedure.execute(entity);
            entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 2) {
               entity.getPersistentData().m_128347_("Damage", (double)9.0F);
               entity.getPersistentData().m_128347_("Range", (double)5.0F + size);
               entity.getPersistentData().m_128347_("effect", (double)10.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.5F);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)(entity.m_20206_() / 2.0F), entity.m_20189_(), entity);
            } else {
               entity.getPersistentData().m_128347_("Damage", (double)7.0F);
               entity.getPersistentData().m_128347_("Range", (double)5.0F + size);
               CompoundTag var77 = entity.getPersistentData();
               int var10002;
               if (entity instanceof EntityWaterEntity) {
                  EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                  var10002 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
               } else {
                  var10002 = 0;
               }

               var77.m_128347_("effect", (double)(var10002 == 1 ? 11 : 0));
               entity.getPersistentData().m_128347_("knockback", (double)0.5F);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)(entity.m_20206_() / 2.0F), entity.m_20189_(), entity);
            }

            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && entity.m_20096_()) {
               x_power = entity.m_20185_() + entity.m_20184_().m_7096_() * (double)16.0F;
               y_power = entity.m_20186_() + (double)(entity.m_20206_() / 2.0F) + entity.m_20184_().m_7098_() * (double)16.0F;
               z_power = entity.m_20189_() + entity.m_20184_().m_7094_() * (double)16.0F;
               RotateEntityProcedure.execute(x_power, y_power, z_power, entity);
               logic_b = false;
               if (entity.getPersistentData().m_128459_("cnt_x2") > (double)10.0F) {
                  entity.getPersistentData().m_128347_("cnt_x2", Math.random() * (double)5.0F);
                  if (entity instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                     var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 == 2) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (Math.random() < 0.1) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
                        entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        if (entity instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                           var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                        } else {
                           var10000 = 0;
                        }

                        if (var10000 == 2) {
                           entity.getPersistentData().m_128347_("effect", (double)3.0F);
                        }

                        BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.water.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.water.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (entity instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                     var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 != 0 && entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                        logic_b = true;
                        entity.getPersistentData().m_128347_("x_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_());
                        entity.getPersistentData().m_128347_("y_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_());
                        entity.getPersistentData().m_128347_("z_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                        GetPowerForwardProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                        RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.5F, entity.getPersistentData().m_128459_("y_power") * (double)0.75F + (double)0.25F, entity.getPersistentData().m_128459_("z_power") * (double)0.5F));
                     }
                  }
               }

               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)2.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                  yaw = (double)entity.m_146908_();
                  pitch = (double)0.0F;
                  rnd = (double)10.0F;
                  logic_a = false;

                  for(int index0 = 0; index0 < 8; ++index0) {
                     for(int index1 = 0; index1 < 32; ++index1) {
                        entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * rnd));
                        entity.m_146926_((float)(pitch + (Math.random() - (double)0.5F) * rnd));
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)2.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                           logic_a = true;
                           break;
                        }
                     }

                     if (logic_a) {
                        break;
                     }

                     rnd += (double)10.0F;
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               }

               if (logic_a || !logic_b) {
                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, entity.getPersistentData().m_128459_("y_power") * (double)0.75F, entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
               }
            }

            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 != 0) {
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt_x") > (double)80.0F) {
               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 9999.0F);
            }
         } else {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 2) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x, y, z, 5, 0.2, 0.2, 0.2, 0.05);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 5, 0.2, 0.2, 0.2, 0.05);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
