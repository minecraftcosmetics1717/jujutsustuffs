package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade13Entity;
import net.mcreator.jujutsucraft.entity.ShikigamiPterosaurEntity;
import net.mcreator.jujutsucraft.entity.ShikigamiRikaDhruvEntity;
import net.mcreator.jujutsucraft.entity.ZeninNaoyaCursedSpiritEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackTackleFlyingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean berserker = false;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         boolean projection_sorcery = false;
         Entity target_entity = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double old_skill = (double)0.0F;
         double dis = (double)0.0F;
         double speed = (double)0.0F;
         double vx = (double)0.0F;
         double vy = (double)0.0F;
         double vz = (double)0.0F;
         double y_fix = (double)0.0F;
         double rnd = (double)0.0F;
         double y_fix_height = (double)0.0F;
         double test_x = (double)0.0F;
         double test_y = (double)0.0F;
         double test_z = (double)0.0F;
         double old_mode = (double)0.0F;
         double distance = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         range = ReturnEntitySizeProcedure.execute(entity);
         dis = GetDistanceProcedure.execute(entity);
         entity.f_19789_ = 0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         targeting = target_entity instanceof LivingEntity;
         if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
            int var122;
            if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
               ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
               var122 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
            } else {
               var122 = 0;
            }

            label215: {
               if (var122 != 0) {
                  if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                     ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
                     var122 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
                  } else {
                     var122 = 0;
                  }

                  if (var122 != 2) {
                     var122 = 0;
                     break label215;
                  }
               }

               var122 = 1;
            }

            projection_sorcery = (boolean)var122;
            if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "fly");
            }
         }

         if (entity instanceof ShikigamiPterosaurEntity) {
            PlayAnimationEntity2Procedure.execute(entity, "fly");
         }

         if (entity instanceof CursedSpiritGrade13Entity) {
            PlayAnimationEntity2Procedure.execute(entity, "fly");
         }

         int var125;
         if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
            ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
            var125 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
         } else {
            var125 = 0;
         }

         if (var125 == 2) {
            speed = (double)3.0F;
         } else {
            speed = projection_sorcery ? (double)2.0F : (double)1.0F;
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F && projection_sorcery) {
            vx = entity.m_20184_().m_7096_();
            vy = entity.m_20184_().m_7098_();
            vz = entity.m_20184_().m_7094_();
            if (vx * vx + vy * vy + vz * vz > (double)9.0F) {
               vx = entity.m_20185_() - entity.getPersistentData().m_128459_("old_x");
               vy = entity.m_20186_() - entity.getPersistentData().m_128459_("old_y");
               vz = entity.m_20189_() - entity.getPersistentData().m_128459_("old_z");
               if (vx * vx + vy * vy + vz * vz > (double)1.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * (double)0.5F, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
                     } else {
                        _level.m_7785_(x, y + (double)entity.m_20206_() * (double)0.5F, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") % (double)2.0F == (double)1.0F) {
                     entity.getPersistentData().m_128347_("BlockRange", (double)8.0F);
                     entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y + (double)entity.m_20206_() * (double)0.5F, z, entity);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
            entity.getPersistentData().m_128347_("cnt4", (double)(Math.random() < (double)0.5F ? 1 : -1));
            if (targeting) {
               if (dis < (double)32.0F) {
                  x_pos = target_entity.m_20185_();
                  y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * 0.9;
                  z_pos = target_entity.m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               } else {
                  entity.getPersistentData().m_128347_("cnt1", (double)10.0F);
               }
            }

            entity.m_146922_(entity.m_146908_());
            entity.m_146926_(45.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128379_("canFly", true);
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)-3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)-3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)-3.0F);
            GetPowerFixProcedure.execute(entity);
            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, entity.getPersistentData().m_128459_("y_power") * speed, entity.getPersistentData().m_128459_("z_power") * speed));
            distance = (double)(-16.0F - entity.m_20205_());
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance);
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance);
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);
         } else if (entity.getPersistentData().m_128459_("cnt1") <= (double)50.0F) {
            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               y_fix = (double)0.0F;

               for(int index0 = 0; index0 < 255 && world.m_46859_(BlockPos.m_274561_(x_pos, y_pos - y_fix, z_pos)); ++index0) {
                  if (y_pos - y_fix < (double)0.0F) {
                     y_fix = (double)255.0F;
                     break;
                  }

                  ++y_fix;
               }

               if (y_fix > (double)24.0F) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (y_fix - (double)24.0F));
               } else if (y_fix < (double)16.0F) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + (double)16.0F - y_fix);
               }

               if (targeting) {
                  entity.getPersistentData().m_128347_("y_pos", Math.max(entity.getPersistentData().m_128459_("y_pos"), target_entity.m_20186_() + (double)target_entity.m_20206_() * 0.9 + (double)8.0F));
               }
            }

            if (!projection_sorcery) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)30.0F));
            }

            if (dis > (double)64.0F) {
               entity.getPersistentData().m_128347_("cnt1", (double)50.0F);
            } else {
               RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
               vx = entity.getPersistentData().m_128459_("old_x") - entity.m_20185_();
               vy = entity.getPersistentData().m_128459_("old_y") - (entity.m_20186_() + (double)entity.m_20206_() * 0.9);
               vz = entity.getPersistentData().m_128459_("old_z") - entity.m_20189_();
               dis = Math.sqrt(vx * vx + vy * vy + vz * vz);
               entity.m_146922_((float)((double)entity.m_146908_() + (double)100.0F * ((double)1.0F - Math.min(Math.max(dis - (double)16.0F, (double)0.0F), (double)16.0F) / (double)16.0F) * entity.getPersistentData().m_128459_("cnt4")));
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

               distance = (double)(64.0F + entity.m_20205_());
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               entity.getPersistentData().m_128379_("canFly", true);
               GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, entity.getPersistentData().m_128459_("y_power") * speed, entity.getPersistentData().m_128459_("z_power") * speed));
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt2") != (double)2.0F) {
               entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
               if (entity instanceof ShikigamiRikaDhruvEntity) {
                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)1.5F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)1.5F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)1.5F);
               } else {
                  if (targeting) {
                     x_pos = target_entity.m_20185_();
                     y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * (double)0.75F;
                     z_pos = target_entity.m_20189_();
                  } else {
                     distance = (double)(64.0F + entity.m_20205_());
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance;
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  }

                  entity.getPersistentData().m_128379_("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, entity.getPersistentData().m_128459_("y_power") * speed, entity.getPersistentData().m_128459_("z_power") * speed));
            RotateEntityProcedure.execute(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * (double)16.0F, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.getPersistentData().m_128459_("y_power") * (double)16.0F, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * (double)16.0F, entity);
            x_pos = entity.getPersistentData().m_128459_("old_x");
            y_pos = entity.getPersistentData().m_128459_("old_y");
            z_pos = entity.getPersistentData().m_128459_("old_z");
            vx = x_pos - x;
            vy = y_pos - y;
            vz = z_pos - z;
            dis = Math.sqrt(vx * vx + vy * vy + vz * vz);

            for(int index1 = 0; index1 < (int)((double)16.0F * range); ++index1) {
               ParticleGeneratorProcedure.execute(world, range * (double)1.0F, (double)1.0F, (double)45.0F, dis * (double)3.0F, x_pos, x_pos - vx, y_pos, y_pos - vy, z_pos, z_pos - vz, "minecraft:crit");
            }

            if (entity instanceof ShikigamiRikaDhruvEntity) {
               if (entity.getPersistentData().m_128459_("cnt1") > (double)80.0F) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else {
               if (dis > (double)0.0F) {
                  vx /= dis;
                  vy /= dis;
                  vz /= dis;
                  entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * speed);
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * speed);

                  for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                     entity.getPersistentData().m_128347_("Damage", (double)16.0F + speed * speed * (double)2.0F);
                     entity.getPersistentData().m_128347_("Range", (double)(4.0F + entity.m_20206_()));
                     entity.getPersistentData().m_128347_("knockback", 0.1 * speed);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
                     x_pos += vx * (double)1.0F;
                     y_pos += vy * (double)1.0F;
                     z_pos += vz * (double)1.0F;
                  }

                  entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               }

               if (dis < (double)24.0F && entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt1"));
               }

               if (projection_sorcery) {
                  if (entity.getPersistentData().m_128459_("cnt1") >= entity.getPersistentData().m_128459_("cnt3") + (double)24.0F / Math.max(speed, (double)1.0F) || entity.getPersistentData().m_128459_("cnt1") > (double)80.0F + (double)24.0F / Math.max(speed, (double)1.0F)) {
                     entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               } else if (entity.getPersistentData().m_128459_("cnt1") >= entity.getPersistentData().m_128459_("cnt3") + (double)10.0F + (double)24.0F / Math.max(speed, (double)1.0F) || entity.getPersistentData().m_128459_("cnt1") > (double)105.0F + (double)24.0F / Math.max(speed, (double)1.0F)) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

         entity.getPersistentData().m_128347_("old_x", x);
         entity.getPersistentData().m_128347_("old_y", y);
         entity.getPersistentData().m_128347_("old_z", z);
      }
   }
}
