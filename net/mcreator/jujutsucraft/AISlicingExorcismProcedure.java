package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AISlicingExorcismProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double loop_num = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
               if (LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     if (entity_a.getPersistentData().m_128459_("skill") > (double)0.0F) {
                        entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? (double)0.0F : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
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

                        yaw = Math.toRadians((double)(entity_a.m_146908_() + 90.0F));
                        pitch = Math.toRadians((double)entity_a.m_146909_());
                        entity.m_6021_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.m_20205_()), entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity_a.m_20205_()), entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.m_20205_()));
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.m_20205_()), entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity_a.m_20205_()), entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.m_20205_()), entity.m_146908_(), entity.m_146909_());
                        }

                        entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), entity_a.getPersistentData().m_128459_("cnt6")));
                        entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                     } else {
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

                           Level var75 = ((Entity)var10000).m_9236_();
                           ClipContext var10001 = new ClipContext;
                           LivingEntity var10003;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10003 = _mobEnt.m_5448_();
                           } else {
                              var10003 = null;
                           }

                           Vec3 var82 = ((Entity)var10003).m_20299_(1.0F);
                           LivingEntity var10004;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10004 = _mobEnt.m_5448_();
                           } else {
                              var10004 = null;
                           }

                           Vec3 var87 = ((Entity)var10004).m_20299_(1.0F);
                           LivingEntity var10005;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10005 = _mobEnt.m_5448_();
                           } else {
                              var10005 = null;
                           }

                           var87 = var87.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)0.0F));
                           ClipContext.Block var95 = Block.OUTLINE;
                           ClipContext.Fluid var10006 = Fluid.NONE;
                           LivingEntity var10007;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var10001.<init>(var82, var87, var95, var10006, var10007);
                           x_pos = (double)var75.m_45547_(var10001).m_82425_().m_123341_();
                           LivingEntity var76;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var76 = _mobEnt.m_5448_();
                           } else {
                              var76 = null;
                           }

                           Level var77 = ((Entity)var76).m_9236_();
                           var10001 = new ClipContext;
                           LivingEntity var83;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var83 = _mobEnt.m_5448_();
                           } else {
                              var83 = null;
                           }

                           Vec3 var84 = ((Entity)var83).m_20299_(1.0F);
                           LivingEntity var89;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var89 = _mobEnt.m_5448_();
                           } else {
                              var89 = null;
                           }

                           Vec3 var90 = ((Entity)var89).m_20299_(1.0F);
                           LivingEntity var96;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var96 = _mobEnt.m_5448_();
                           } else {
                              var96 = null;
                           }

                           var90 = var90.m_82549_(((Entity)var96).m_20252_(1.0F).m_82490_((double)0.0F));
                           ClipContext.Block var97 = Block.OUTLINE;
                           var10006 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var10001.<init>(var84, var90, var97, var10006, var10007);
                           y_pos = (double)var77.m_45547_(var10001).m_82425_().m_123342_();
                           LivingEntity var78;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var78 = _mobEnt.m_5448_();
                           } else {
                              var78 = null;
                           }

                           Level var79 = ((Entity)var78).m_9236_();
                           var10001 = new ClipContext;
                           LivingEntity var85;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var85 = _mobEnt.m_5448_();
                           } else {
                              var85 = null;
                           }

                           Vec3 var86 = ((Entity)var85).m_20299_(1.0F);
                           LivingEntity var92;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var92 = _mobEnt.m_5448_();
                           } else {
                              var92 = null;
                           }

                           Vec3 var93 = ((Entity)var92).m_20299_(1.0F);
                           LivingEntity var98;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var98 = _mobEnt.m_5448_();
                           } else {
                              var98 = null;
                           }

                           var93 = var93.m_82549_(((Entity)var98).m_20252_(1.0F).m_82490_((double)0.0F));
                           ClipContext.Block var99 = Block.OUTLINE;
                           var10006 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var10001.<init>(var86, var93, var99, var10006, var10007);
                           z_pos = (double)var79.m_45547_(var10001).m_82425_().m_123343_();
                        } else {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                        }

                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                        entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                        entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
                        entity.getPersistentData().m_128347_("yaw_fix", (double)0.0F);
                        entity.getPersistentData().m_128347_("pitch_fix", (double)0.0F);
                        entity.getPersistentData().m_128347_("old_x", x);
                        entity.getPersistentData().m_128347_("old_y", y);
                        entity.getPersistentData().m_128347_("old_z", z);
                        entity.getPersistentData().m_128347_("cnt1", (double)14.0F);
                        entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                     }
                  } else {
                     entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_286979_)), 9999.0F);
                  }
               } else {
                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_286979_)), 9999.0F);
               }
            } else {
               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_286979_)), 9999.0F);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
            if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt2") > (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("move") == (double)0.0F) {
                     if (entity.getPersistentData().m_128459_("cnt3") % (double)2.0F == (double)1.0F) {
                        entity.getPersistentData().m_128347_("yaw_fix", (double)30.0F + Math.random() * (double)22.5F);
                     } else {
                        entity.getPersistentData().m_128347_("yaw_fix", ((double)30.0F + Math.random() * (double)22.5F) * (double)-1.0F);
                     }

                     if (entity.getPersistentData().m_128459_("cnt3") % (double)6.0F <= (double)2.0F) {
                        entity.getPersistentData().m_128347_("pitch_fix", (double)20.0F + Math.random() * (double)10.0F);
                     } else {
                        entity.getPersistentData().m_128347_("pitch_fix", ((double)20.0F + Math.random() * (double)10.0F) * (double)-1.0F);
                     }
                  }
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = x - x_pos;
               y_power = y - y_pos;
               z_power = z - z_pos;
               loop_num = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_power, (double)2.0F));
               if (loop_num > (double)0.0F) {
                  x_power /= loop_num;
                  y_power /= loop_num;
                  z_power /= loop_num;

                  for(int index0 = 0; index0 < (int)Math.ceil(loop_num * (double)10.0F); ++index0) {
                     if (Math.abs(entity.m_20184_().m_7096_()) > Math.abs(entity.m_20184_().m_7094_())) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.471 0.000 0.000 1 ~ ~ ~ 0.0 0.0 0.2 1 1 force");
                        }
                     } else if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.471 0.000 0.000 1 ~ ~ ~ 0.2 0.0 0.0 1 1 force");
                     }

                     x_pos += x_power * 0.1;
                     y_pos += y_power * 0.1;
                     z_pos += z_power * 0.1;
                  }
               }

               entity.getPersistentData().m_128347_("old_x", x);
               entity.getPersistentData().m_128347_("old_y", y);
               entity.getPersistentData().m_128347_("old_z", z);
               if (!entity.getPersistentData().m_128471_("Stop")) {
                  entity.m_146922_((float)(entity.getPersistentData().m_128459_("yaw") + entity.getPersistentData().m_128459_("yaw_fix")));
                  entity.m_146926_((float)(entity.getPersistentData().m_128459_("pitch") + entity.getPersistentData().m_128459_("pitch_fix")));
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, entity.getPersistentData().m_128459_("y_power") * (double)0.75F, entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
                  BulletDomainHit2Procedure.execute(world, entity);
               } else {
                  entity.getPersistentData().m_128379_("Stop", false);
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)18.0F * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)4.0F);
            entity.getPersistentData().m_128347_("knockback", (double)1.0F);
            entity.getPersistentData().m_128347_("effect", (double)11.0F);
            RangeAttackProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("BlockRange", (double)1.0F);
            entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F * CNT6);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         }

         if (entity.m_20071_()) {
            entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 9999.0F);
         }

         if (!entity.m_6084_() || entity.getPersistentData().m_128459_("cnt1") > (double)45.0F) {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, 10, 0.2, 0.2, 0.2, 0.1);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
