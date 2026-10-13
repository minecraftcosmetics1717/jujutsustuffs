package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityCrystalEntity;
import net.mcreator.jujutsucraft.entity.Gravestone3Entity;
import net.mcreator.jujutsucraft.entity.RockFragmentEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIRockFragmentProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double loop_num = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double speed = (double)0.0F;
         double entity_size = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         int var10000;
         if (entity instanceof EntityCrystalEntity) {
            EntityCrystalEntity _datEntI = (EntityCrystalEntity)entity;
            var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityCrystalEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 == 1) {
            AICrystalExplodeProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
         } else {
            entity_size = ReturnEntitySizeProcedure.execute(entity);
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity instanceof EntityCrystalEntity) {
               if (entity instanceof EntityCrystalEntity) {
                  EntityCrystalEntity _datEntL7 = (EntityCrystalEntity)entity;
                  if ((Boolean)_datEntL7.m_20088_().m_135370_(EntityCrystalEntity.DATA_fall) && entity instanceof EntityCrystalEntity) {
                     PlayAnimationEntity2Procedure.execute(entity, "fall");
                  }
               }

               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_life") < (double)6.0F) {
                  entity.f_19789_ = 0.0F;
                  entity.m_5997_((double)0.0F, (double)0.0F, (double)0.0F);
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               }

               if (entity.getPersistentData().m_128459_("cnt_life") == (double)6.0F) {
                  entity.m_5997_(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power"));
                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power")));
               }

               if (entity.getPersistentData().m_128459_("cnt_life") > (double)30.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_life", Math.max(entity.getPersistentData().m_128459_("cnt_life"), (double)20.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt_life") >= (double)6.0F && entity.getPersistentData().m_128459_("skill") != (double)1706.0F) {
               if (entity instanceof Gravestone3Entity && !entity.m_20096_()) {
                  entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), Math.min(entity.m_20184_().m_7098_(), (double)-0.25F), entity.m_20184_().m_7094_()));
               }

               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("yaw_fix", (Math.random() - (double)0.5F) * (double)2.0F);
                  entity.getPersistentData().m_128347_("pitch_fix", (Math.random() - (double)0.5F) * (double)2.0F);
                  entity.getPersistentData().m_128347_("cnt3", (double)5.0F);
                  if (entity.getPersistentData().m_128459_("skill") >= (double)400.0F && entity.getPersistentData().m_128459_("skill") < (double)500.0F) {
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntSetL = (RockFragmentEntity)entity;
                        _datEntSetL.m_20088_().m_135381_(RockFragmentEntity.DATA_Magma, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19607_, Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     entity.m_20254_(30);
                  }
               }

               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") > (double)0.0F ? entity.getPersistentData().m_128459_("cnt3") - (double)1.0F : (double)0.0F);
                  if (entity instanceof Gravestone3Entity) {
                     entity.getPersistentData().m_128347_("cnt_rock", entity.getPersistentData().m_128459_("cnt_rock") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_rock") > (double)4.0F) {
                        entity.getPersistentData().m_128347_("cnt_rock", (double)0.0F);
                        entity.getPersistentData().m_128347_("BlockRange", (double)3.0F * entity_size);
                        entity.getPersistentData().m_128347_("BlockDamage", (double)(entity.m_20206_() * entity.m_20205_()) * 0.1 * CNT6);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") > (double)8.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)((double)4.0F * entity_size * entity_size), (double)0.25F * entity_size, 0.1 * entity_size, (double)0.25F * entity_size, 0.1 * entity_size);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)((double)4.0F * entity_size * entity_size), (double)0.25F * entity_size, 0.1 * entity_size, (double)0.25F * entity_size, 0.1 * entity_size);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x, y, z, (int)((double)4.0F * entity_size * entity_size), (double)0.25F * entity_size, 0.1 * entity_size, (double)0.25F * entity_size, 0.1 * entity_size);
                     }

                     entity.getPersistentData().m_128347_("Damage", (double)10.0F * entity_size * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)3.0F * entity_size);
                     entity.getPersistentData().m_128347_("knockback", 0.2);
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntL69 = (RockFragmentEntity)entity;
                        if ((Boolean)_datEntL69.m_20088_().m_135370_(RockFragmentEntity.DATA_Magma)) {
                           entity.getPersistentData().m_128347_("effect", (double)10.0F);
                        }
                     }

                     RangeAttackProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128347_("BlockRange", (double)3.0F * entity_size);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F * entity_size * CNT6);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128347_("yaw_fix", (Math.random() - (double)0.5F) * (double)2.0F);
                     entity.getPersistentData().m_128347_("pitch_fix", (Math.random() - (double)0.5F) * (double)2.0F);
                  } else {
                     entity.getPersistentData().m_128347_("Damage", (double)0.0F);
                  }

                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  speed = Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_() + entity.m_20184_().m_7098_() * entity.m_20184_().m_7098_());
                  if (!(entity.getPersistentData().m_128459_("cnt2") > (double)8.0F) && !(speed > (double)1.0F)) {
                     entity.getPersistentData().m_128347_("Damage", (double)0.0F);
                  } else {
                     entity.getPersistentData().m_128347_("Damage", (double)10.0F * entity_size * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)3.0F * entity_size);
                     entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntL90 = (RockFragmentEntity)entity;
                        if ((Boolean)_datEntL90.m_20088_().m_135370_(RockFragmentEntity.DATA_Magma)) {
                           entity.getPersistentData().m_128347_("effect", (double)10.0F);
                        }
                     }

                     RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                     if (speed > (double)1.0F) {
                        x_power = entity.m_20184_().m_7096_() / speed;
                        y_power = entity.m_20184_().m_7098_() / speed;
                        z_power = entity.m_20184_().m_7094_() / speed;
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
                        z_pos = entity.m_20189_();

                        for(int index0 = 0; index0 < (int)speed; ++index0) {
                           entity.getPersistentData().m_128347_("Damage", Math.min((double)10.0F * entity_size * ((double)1.0F + speed * 0.2), (double)18.0F) * CNT6);
                           entity.getPersistentData().m_128347_("Range", (double)3.0F);
                           entity.getPersistentData().m_128347_("knockback", Math.min(0.6 + speed * 0.2, (double)1.5F));
                           RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           x_pos += x_power;
                           y_pos += y_power;
                           z_pos += z_power;
                        }
                     }

                     speed = Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_());
                     if (entity instanceof RockFragmentEntity) {
                        if (!(speed > (double)0.5F) && !(entity.getPersistentData().m_128459_("cnt3") > (double)0.0F)) {
                           BulletDomainHit2Procedure.execute(world, entity);
                        } else if (!entity.getPersistentData().m_128471_("Stop")) {
                           for(int index1 = 0; index1 < 25; ++index1) {
                              entity.m_146922_((float)((double)entity.m_146908_() + entity.getPersistentData().m_128459_("yaw_fix")));
                              entity.m_146926_((float)((double)entity.m_146909_() + entity.getPersistentData().m_128459_("pitch_fix")));
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
                        } else {
                           entity.getPersistentData().m_128379_("Stop", false);
                        }
                     }
                  }
               }
            }

            if (!entity.m_6084_() || entity.getPersistentData().m_128459_("cnt1") > (double)200.0F || entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               z_pos = entity.m_20189_();
               if (!entity.m_6084_()) {
                  label163: {
                     if (entity instanceof RockFragmentEntity) {
                        RockFragmentEntity _datEntL128 = (RockFragmentEntity)entity;
                        if ((Boolean)_datEntL128.m_20088_().m_135370_(RockFragmentEntity.DATA_Magma)) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, (int)((double)2.0F * entity_size * entity_size), (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size);
                           }
                           break label163;
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)5.0F * entity_size * entity_size), (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)((double)2.0F * entity_size * entity_size), (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size);
                  }
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
