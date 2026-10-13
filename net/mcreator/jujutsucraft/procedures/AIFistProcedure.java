package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFistProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double move = (double)0.0F;
         double amount = (double)0.0F;
         double CNT6 = (double)0.0F;
         double entity_size = (double)0.0F;
         double speed = (double)0.0F;
         double distance = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double size = (double)0.0F;
         double x_power = (double)0.0F;
         double dis = (double)0.0F;
         double damage = (double)0.0F;
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            move = entity.getPersistentData().m_128459_("move");
            entity_size = ReturnEntitySizeProcedure.execute(entity) * 1.2;
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)10.0F) {
               entity_size *= (double)1.5F;
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)10.0F);
               }

               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
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

                        Level var87 = ((Entity)var10000).m_9236_();
                        ClipContext var10001 = new ClipContext;
                        LivingEntity var10003;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10003 = _mobEnt.m_5448_();
                        } else {
                           var10003 = null;
                        }

                        Vec3 var97 = ((Entity)var10003).m_20299_(1.0F);
                        LivingEntity var10004;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10004 = _mobEnt.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        Vec3 var102 = ((Entity)var10004).m_20299_(1.0F);
                        LivingEntity var10005;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10005 = _mobEnt.m_5448_();
                        } else {
                           var10005 = null;
                        }

                        var102 = var102.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)0.0F));
                        ClipContext.Block var110 = Block.OUTLINE;
                        ClipContext.Fluid var10006 = Fluid.NONE;
                        LivingEntity var10007;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var97, var102, var110, var10006, var10007);
                        x_pos = (double)var87.m_45547_(var10001).m_82425_().m_123341_();
                        LivingEntity var88;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var88 = _mobEnt.m_5448_();
                        } else {
                           var88 = null;
                        }

                        Level var89 = ((Entity)var88).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var98;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var98 = _mobEnt.m_5448_();
                        } else {
                           var98 = null;
                        }

                        Vec3 var99 = ((Entity)var98).m_20299_(1.0F);
                        LivingEntity var104;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var104 = _mobEnt.m_5448_();
                        } else {
                           var104 = null;
                        }

                        Vec3 var105 = ((Entity)var104).m_20299_(1.0F);
                        LivingEntity var111;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var111 = _mobEnt.m_5448_();
                        } else {
                           var111 = null;
                        }

                        var105 = var105.m_82549_(((Entity)var111).m_20252_(1.0F).m_82490_((double)0.0F));
                        ClipContext.Block var112 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var99, var105, var112, var10006, var10007);
                        y_pos = (double)var89.m_45547_(var10001).m_82425_().m_123342_();
                        LivingEntity var90;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var90 = _mobEnt.m_5448_();
                        } else {
                           var90 = null;
                        }

                        Level var91 = ((Entity)var90).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var100;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var100 = _mobEnt.m_5448_();
                        } else {
                           var100 = null;
                        }

                        Vec3 var101 = ((Entity)var100).m_20299_(1.0F);
                        LivingEntity var107;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var107 = _mobEnt.m_5448_();
                        } else {
                           var107 = null;
                        }

                        Vec3 var108 = ((Entity)var107).m_20299_(1.0F);
                        LivingEntity var113;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var113 = _mobEnt.m_5448_();
                        } else {
                           var113 = null;
                        }

                        var108 = var108.m_82549_(((Entity)var113).m_20252_(1.0F).m_82490_((double)0.0F));
                        ClipContext.Block var114 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var101, var108, var114, var10006, var10007);
                        z_pos = (double)var91.m_45547_(var10001).m_82425_().m_123343_();
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     } else {
                        x_pos = entity.m_20185_() + entity_a.m_20154_().f_82479_ * (double)64.0F;
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity_a.m_20154_().f_82480_ * (double)64.0F;
                        z_pos = entity.m_20189_() + entity_a.m_20154_().f_82481_ * (double)64.0F;
                     }

                     double var92 = x_pos + entity.getPersistentData().m_128459_("x_pos");
                     var92 = y_pos + entity.getPersistentData().m_128459_("y_pos");
                     var92 = z_pos + entity.getPersistentData().m_128459_("z_pos");
                  }
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)10.0F) {
               amount = move == (double)2.0F ? (double)1.0F : (double)5.0F;
               distance = (double)entity.m_20205_() * (double)0.5F;
               speed = 0.7 + entity.getPersistentData().m_128459_("speed");
               x_power = entity.getPersistentData().m_128459_("x_power") * speed;
               y_power = entity.getPersistentData().m_128459_("y_power") * speed;
               z_power = entity.getPersistentData().m_128459_("z_power") * speed;
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               z_pos = entity.m_20189_();
               if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)((double)0.5F * Math.pow(CNT6, (double)2.0F)), 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)((double)0.5F * Math.pow(CNT6, (double)2.0F)), 0.75F, false);
                  }
               }

               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               if (!entity.getPersistentData().m_128471_("Stop")) {
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
                  if (move == (double)0.0F) {
                     entity.getPersistentData().m_128347_("Damage", (double)18.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)0.5F * CNT6);
                     if (entity.getPersistentData().m_128459_("cnt_life") > (double)0.0F) {
                        for(int index0 = 0; index0 < (int)Math.round(entity.getPersistentData().m_128459_("cnt_life")); ++index0) {
                           entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
                           if (entity.getPersistentData().m_128459_("Damage") < (double)14.0F) {
                              entity.getPersistentData().m_128347_("Damage", (double)14.0F);
                              break;
                           }
                        }
                     }
                  } else if (move == (double)1.0F) {
                     entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
                     if (entity.getPersistentData().m_128459_("cnt_life") > (double)0.0F) {
                        for(int index1 = 0; index1 < (int)Math.round(entity.getPersistentData().m_128459_("cnt_life")); ++index1) {
                           entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
                           if (entity.getPersistentData().m_128459_("Damage") < (double)11.0F) {
                              entity.getPersistentData().m_128347_("Damage", (double)11.0F);
                              break;
                           }
                        }
                     }
                  } else if (move == (double)2.0F) {
                     entity.getPersistentData().m_128347_("Damage", (double)10.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)0.25F * CNT6);
                  }

                  damage = entity.getPersistentData().m_128459_("Damage");

                  for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                     entity.getPersistentData().m_128347_("Damage", damage);
                     entity.getPersistentData().m_128347_("Range", (double)3.0F * entity_size);
                     entity.getPersistentData().m_128379_("attack", false);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (move == (double)1.0F) {
                        entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                        KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!entity.m_5830_() && !InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                        entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                        }
                     } else if (!InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_() + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                        entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_() + z_power);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                        }
                     } else {
                        entity.getPersistentData().m_128347_("BlockRange", (double)2.0F * entity_size);
                        entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * CNT6);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        entity.getPersistentData().m_128379_("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity);
                        if (InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + (double)entity.m_20206_() * (double)0.25F + y_power, entity.m_20189_() + z_power, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F)) {
                           break;
                        }
                     }
                  }

                  BulletDomainHit2Procedure.execute(world, entity);
                  if (entity.m_5830_() || InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, (double)entity.m_20206_(), (double)entity.m_20205_()) || !entity.m_6084_()) {
                     distance = (double)entity.m_20205_() * (double)0.5F;
                     x_pos = entity.m_20185_() + x_power * distance;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + y_power * distance;
                     z_pos = entity.m_20189_() + z_power * distance;
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)4.0F * CNT6 * entity_size), (double)1.0F * entity_size, (double)1.0F * entity_size, (double)1.0F * entity_size, (double)0.25F * CNT6);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)2.0F * CNT6 * entity_size), (double)1.0F * entity_size, (double)1.0F * entity_size, (double)1.0F * entity_size, (double)0.5F * CNT6);
                     }

                     entity.getPersistentData().m_128347_("BlockRange", (double)2.0F * entity_size);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * CNT6);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F && entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)((double)25.0F * CNT6 * entity_size), (double)1.0F * entity_size, (double)1.0F * entity_size, (double)1.0F * entity_size, (double)1.0F * CNT6);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
                        entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
                        entity.getPersistentData().m_128347_("Range", (double)6.0F * entity_size);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)2.0F);
                  }
               } else {
                  entity.getPersistentData().m_128379_("Stop", false);
               }

               entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F + entity.getPersistentData().m_128459_("cnt6") && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
