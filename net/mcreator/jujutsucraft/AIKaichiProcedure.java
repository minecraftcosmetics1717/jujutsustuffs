package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.KaichiEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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

public class AIKaichiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         boolean skull = false;
         boolean logic_a = false;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double loop_num = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double speed = (double)0.0F;
         double size = (double)0.0F;
         double pitch = (double)0.0F;
         double pitch_cal = (double)0.0F;
         double yaw = (double)0.0F;
         double yaw_cal = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt_life") > (double)10.0F) {
            if (entity instanceof KaichiEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "spin");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 2.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 2.0F, false);
               }
            }
         }

         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
            logic_attack = false;
            entity.getPersistentData().m_128379_("Stop", false);
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") > (double)0.0F) {
                  logic_attack = true;
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.m_146922_(entity_a.m_146908_());
                  entity.m_146926_(entity_a.m_146909_());
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }

                  if (!entity.m_6084_()) {
                     entity_a.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               }
            }

            if (!logic_attack || !entity.m_6084_()) {
               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 10, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_life") > (double)10.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)6.0F);
               entity.getPersistentData().m_128347_("Range", (double)2.0F * size);
               entity.getPersistentData().m_128347_("knockback", (double)0.25F);
               entity.getPersistentData().m_128347_("effect", (double)1.0F);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128471_("Stop")) {
               entity.getPersistentData().m_128379_("Stop", true);
            } else {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
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

                        Level var103 = ((Entity)var10000).m_9236_();
                        ClipContext var10001 = new ClipContext;
                        LivingEntity var10003;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10003 = _mobEnt.m_5448_();
                        } else {
                           var10003 = null;
                        }

                        Vec3 var110 = ((Entity)var10003).m_20299_(1.0F);
                        LivingEntity var10004;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10004 = _mobEnt.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        Vec3 var115 = ((Entity)var10004).m_20299_(1.0F);
                        LivingEntity var10005;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10005 = _mobEnt.m_5448_();
                        } else {
                           var10005 = null;
                        }

                        var115 = var115.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)0.0F));
                        ClipContext.Block var123 = Block.OUTLINE;
                        ClipContext.Fluid var10006 = Fluid.NONE;
                        LivingEntity var10007;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var110, var115, var123, var10006, var10007);
                        x_pos = (double)var103.m_45547_(var10001).m_82425_().m_123341_();
                        LivingEntity var104;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var104 = _mobEnt.m_5448_();
                        } else {
                           var104 = null;
                        }

                        Level var105 = ((Entity)var104).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var111;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var111 = _mobEnt.m_5448_();
                        } else {
                           var111 = null;
                        }

                        Vec3 var112 = ((Entity)var111).m_20299_(1.0F);
                        LivingEntity var117;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var117 = _mobEnt.m_5448_();
                        } else {
                           var117 = null;
                        }

                        Vec3 var118 = ((Entity)var117).m_20299_(1.0F);
                        LivingEntity var124;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var124 = _mobEnt.m_5448_();
                        } else {
                           var124 = null;
                        }

                        var118 = var118.m_82549_(((Entity)var124).m_20252_(1.0F).m_82490_((double)0.0F));
                        ClipContext.Block var125 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var112, var118, var125, var10006, var10007);
                        y_pos = (double)var105.m_45547_(var10001).m_82425_().m_123342_();
                        LivingEntity var106;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var106 = _mobEnt.m_5448_();
                        } else {
                           var106 = null;
                        }

                        Level var107 = ((Entity)var106).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var113;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var113 = _mobEnt.m_5448_();
                        } else {
                           var113 = null;
                        }

                        Vec3 var114 = ((Entity)var113).m_20299_(1.0F);
                        LivingEntity var120;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var120 = _mobEnt.m_5448_();
                        } else {
                           var120 = null;
                        }

                        Vec3 var121 = ((Entity)var120).m_20299_(1.0F);
                        LivingEntity var126;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var126 = _mobEnt.m_5448_();
                        } else {
                           var126 = null;
                        }

                        var121 = var121.m_82549_(((Entity)var126).m_20252_(1.0F).m_82490_((double)0.0F));
                        ClipContext.Block var127 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var114, var121, var127, var10006, var10007);
                        z_pos = (double)var107.m_45547_(var10001).m_82425_().m_123343_();
                     } else {
                        dis = (double)8.0F;
                        logic_a = false;

                        for(int index0 = 0; index0 < 8; ++index0) {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)8.0F), (e) -> true)) {
                              if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 logic_a = true;
                                 x_pos = entityiterator.m_20185_();
                                 y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                                 z_pos = entityiterator.m_20189_();
                                 break;
                              }
                           }

                           dis += (double)8.0F;
                           if (logic_a) {
                              break;
                           }
                        }
                     }
                  }
               }

               x_power = entity.m_20185_() - x_pos;
               y_power = entity.m_20186_() - y_pos;
               z_power = entity.m_20189_() - z_pos;
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > (double)10.0F && (entity.getPersistentData().m_128459_("cnt1") % (double)3.0F == (double)1.0F || dis > (double)32.0F)) {
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)(entity.m_146908_() % 360.0F);
                  pitch = (double)entity.m_146909_();
                  if (entity.getPersistentData().m_128459_("cnt1") % (double)9.0F != (double)1.0F && dis <= (double)32.0F) {
                     for(int index1 = 0; index1 < 32; ++index1) {
                        entity.m_146922_((float)((yaw + (Math.random() - (double)0.5F) * (double)90.0F) % (double)360.0F));
                        entity.m_146926_((float)(pitch + (Math.random() - (double)0.5F) * (double)45.0F));
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                           break;
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 4, (double)0.25F, (double)0.25F, (double)0.25F, 0.2);
                  }
               }

               speed = (double)6.0F;
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

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               z_pos = entity.m_20189_();

               for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                  entity.getPersistentData().m_128347_("Damage", (double)15.0F);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F * size);
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("effect", (double)1.0F);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                  entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.m_5830_()) {
                     entity.m_6021_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.m_5830_()) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.m_5830_()) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power, entity.m_146908_(), entity.m_146909_());
                     }
                  }
               }

               entity.getPersistentData().m_128347_("BlockRange", (double)1.0F * size);
               entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.15));
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)50.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
