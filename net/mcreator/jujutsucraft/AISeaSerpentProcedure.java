package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BathynomusGiganteusEntity;
import net.mcreator.jujutsucraft.entity.SeaSerpentMiniEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AISeaSerpentProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_power = (double)0.0F;
         double x_power = (double)0.0F;
         double dis = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw_cal = (double)0.0F;
         double pitch_cal = (double)0.0F;
         double z_power = (double)0.0F;
         double CNT6 = (double)0.0F;
         double entity_size = (double)0.0F;
         double strength = (double)0.0F;
         double speed = (double)0.0F;
         double size = (double)0.0F;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean logic_c = false;
         boolean SUCCESS = false;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (entity.m_6084_()) {
            BulletDomainHit2Procedure.execute(world, entity);
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("movement") == (double)1.0F) {
               AISeaSerpent2Procedure.execute(world, x, y, z, entity);
            } else {
               if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
                  x_power = entity.getPersistentData().m_128459_("x_power");
                  y_power = entity.getPersistentData().m_128459_("y_power");
                  z_power = entity.getPersistentData().m_128459_("z_power");

                  for(int index0 = 0; index0 < 2; ++index0) {
                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") >= (double)8.0F && (!entity.m_5830_() || entity.getPersistentData().m_128459_("cnt1") >= (double)16.0F)) {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, (float)CNT6);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, (float)CNT6, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, (float)CNT6);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, (float)CNT6, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)((double)(20.0F * entity.m_20205_()) * CNT6), (double)1.0F, (double)1.0F, (double)1.0F, (double)2.0F);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), x_pos, y_pos, z_pos, (int)((double)(20.0F * entity.m_20205_()) * CNT6), (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
                        }

                        entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                        if (entity instanceof BathynomusGiganteusEntity) {
                           entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
                        } else {
                           entity.getPersistentData().m_128347_("cnt2", (double)(Math.random() < 0.3 ? 2 : 1));
                        }
                        break;
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") != (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
                  size = ReturnEntitySizeProcedure.execute(entity);
                  if (entity.getPersistentData().m_128471_("Stop")) {
                     entity.getPersistentData().m_128379_("Stop", true);
                  } else {
                     if (!(entity instanceof BathynomusGiganteusEntity) || entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
                        dis = (double)32.0F;
                        x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * dis;
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_ * dis;
                        z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * dis;
                        if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                           entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                           if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                              LivingEntity var10000;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity) {
                                 if (entity_a instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity_a;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 entity_a = var10000;
                                 x_pos = entity_a.m_20185_();
                                 y_pos = entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F;
                                 z_pos = entity_a.m_20189_();
                              } else {
                                 dis = (double)8.0F;
                                 logic_a = false;

                                 for(int index1 = 0; index1 < 2; ++index1) {
                                    x_pos = entity_a.m_20185_() + entity_a.m_20154_().f_82479_ * dis;
                                    y_pos = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.9 + entity_a.m_20154_().f_82480_ * dis;
                                    z_pos = entity_a.m_20189_() + entity_a.m_20154_().f_82481_ * dis;
                                    Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                                    for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)12.0F), (e) -> true)) {
                                       if (entity != entityiterator && LogicAttackProcedure.execute(world, entity_a, entityiterator)) {
                                          logic_a = true;
                                          x_pos = entityiterator.m_20185_();
                                          y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                                          z_pos = entityiterator.m_20189_();
                                          break;
                                       }
                                    }

                                    if (logic_a || entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity_a)).m_6662_() == Type.BLOCK) {
                                       break;
                                    }

                                    dis += (double)16.0F;
                                 }
                              }
                           }
                        }

                        yaw = (double)(entity.m_146908_() % 360.0F);
                        pitch = (double)entity.m_146909_();
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                        dis = Math.sqrt((entity.m_20185_() - x_pos) * (entity.m_20185_() - x_pos) + (entity.m_20186_() - y_pos) * (entity.m_20186_() - y_pos) + (entity.m_20189_() - z_pos) * (entity.m_20189_() - z_pos));
                        if (dis < (double)0.0F || dis > (double)14.0F) {
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
                           yaw += Math.min((double)360.0F - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)((!(yaw_cal >= (double)180.0F) || !(yaw_cal < (double)360.0F)) && (!(yaw_cal >= (double)-180.0F) || !(yaw_cal < (double)0.0F)) ? 6 : -6);
                           pitch = (double)entity.m_146909_();
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
                        }
                     }

                     speed = entity.getPersistentData().m_128459_("cnt_life") == (double)1.0F ? (double)1.0F : Math.min((double)1.0F, Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7098_() * entity.m_20184_().m_7098_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_()) + 0.2);
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * speed);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * speed);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * speed);
                     x_power = entity.getPersistentData().m_128459_("x_power");
                     y_power = entity.getPersistentData().m_128459_("y_power");
                     z_power = entity.getPersistentData().m_128459_("z_power");
                     entity.m_20256_(new Vec3(x_power, y_power, z_power));
                     dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                     if (dis > (double)1.0F) {
                        x_power /= dis;
                        y_power /= dis;
                        z_power /= dis;
                     } else {
                        dis = (double)1.0F;
                     }

                     speed = Math.min(Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7098_() * entity.m_20184_().m_7098_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_()), (double)3.0F);
                     entity.getPersistentData().m_128347_("cnt_attack", entity.getPersistentData().m_128459_("cnt_attack") + (double)1.0F);

                     for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                        logic_c = false;
                        if (entity.getPersistentData().m_128459_("cnt_attack") > (double)0.0F) {
                           if (entity instanceof BathynomusGiganteusEntity) {
                              entity.getPersistentData().m_128347_("Damage", (double)18.0F * CNT6);
                           } else if (entity instanceof SeaSerpentMiniEntity) {
                              entity.getPersistentData().m_128347_("Damage", (double)9.0F * CNT6);
                           } else {
                              entity.getPersistentData().m_128347_("Damage", (double)13.5F * CNT6);
                           }

                           entity.getPersistentData().m_128347_("knockback", (double)0.25F);
                           entity.getPersistentData().m_128347_("Range", (double)Math.max(1.0F + entity.m_20205_(), 2.0F));
                           entity.getPersistentData().m_128347_("effect", (double)1.0F);
                           entity.getPersistentData().m_128379_("swing", true);
                           RangeAttackProcedure.execute(world, entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * (double)0.25F, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * (double)0.25F, entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * (double)0.25F, entity);
                           if (entity.getPersistentData().m_128459_("cnt_attack") < (double)0.0F) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                              }

                              logic_c = true;
                           }
                        }

                        if (entity.getPersistentData().m_128471_("Stop")) {
                           entity.getPersistentData().m_128379_("Stop", false);
                           logic_a = false;
                           break;
                        }

                        logic_b = false;
                        entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_());
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           entity.m_6021_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                           }

                           logic_b = true;
                        }

                        entity.m_6021_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_());
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           entity.m_6021_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                           }

                           logic_b = true;
                        }

                        entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power, entity.m_146908_(), entity.m_146909_());
                           }

                           logic_b = true;
                        }

                        if ((entity.m_5830_() || logic_b) && (entity.getPersistentData().m_128459_("cnt1") % (double)20.0F == (double)10.0F || logic_c)) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                           }

                           entity.getPersistentData().m_128347_("BlockRange", (double)(1.0F * entity.m_20205_()));
                           entity.getPersistentData().m_128347_("BlockDamage", Math.max((double)entity.m_20205_() * (double)0.5F * CNT6, (double)0.5F));
                           BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * (double)0.25F, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * (double)0.25F, entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * (double)0.25F, entity);
                        }
                     }

                     entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
                     entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
                     entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
                  }
               }

               if (entity instanceof BathynomusGiganteusEntity) {
                  if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               } else if (entity instanceof SeaSerpentMiniEntity) {
                  if (entity.getPersistentData().m_128459_("cnt1") > (double)80.0F && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               } else if (entity.getPersistentData().m_128459_("cnt1") > (double)80.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(2.0F * (entity.m_20206_() + entity.m_20205_())), (double)entity.m_20205_() * 0.1, (double)entity.m_20206_() * 0.1, (double)entity.m_20205_() * 0.1, (double)1.0F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)((double)0.5F + Math.random()));
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)((double)0.5F + Math.random()), false);
               }
            }
         }

      }
   }
}
