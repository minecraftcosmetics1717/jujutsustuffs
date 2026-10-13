package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.TruckEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackPiecingOxProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double level_jump = (double)0.0F;
         double level = (double)0.0F;
         double level_speed = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double dis = (double)0.0F;
         double speed = (double)0.0F;
         Entity entity_a = null;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            if (OnGroundProcedure.execute(world, entity)) {
               world.m_46796_(2001, BlockPos.m_274561_(x, y - (double)1.0F, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y - (double)1.0F, z))));
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 20, 0.1, (double)0.0F, 0.1, (double)0.5F);
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") > (double)200.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 20, 0.1, (double)0.0F, 0.1, (double)0.5F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x, y, z, 20, (double)1.0F, (double)0.0F, (double)1.0F, (double)0.5F);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                     }
                  }

                  entity_a = entity;
                  if (entity.m_20160_() && entity.m_146895_() instanceof LivingEntity) {
                     entity_a = entity.m_146895_();
                  }

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

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     double var69 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var69 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                     LivingEntity var70;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var70 = _mobEnt.m_5448_();
                     } else {
                        var70 = null;
                     }

                     z_pos = ((Entity)var70).m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity_a.m_146922_(entity.m_146908_());
                     entity_a.m_146926_(entity.m_146909_());
                     entity_a.m_5618_(entity_a.m_146908_());
                     entity_a.m_5616_(entity_a.m_146908_());
                     entity_a.f_19859_ = entity_a.m_146908_();
                     entity_a.f_19860_ = entity_a.m_146909_();
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_a;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  }

                  entity.getPersistentData().m_128347_("x_power", entity_a.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity_a.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity_a.m_20154_().f_82481_ * (double)3.0F);
                  if (entity instanceof TruckEntity) {
                     entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * (double)1.5F);
                     entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * (double)1.5F);
                     entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * (double)1.5F);
                  }
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               dis = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_power, (double)2.0F));
               if (dis > (double)0.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
                  entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * (double)1.0F);
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * (double)1.0F);

                  for(int index0 = 0; index0 < (int)Math.round(dis); ++index0) {
                     entity.getPersistentData().m_128347_("Damage", (double)15.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                     entity.getPersistentData().m_128347_("Range", (double)(3.0F + entity.m_20206_()));
                     entity.getPersistentData().m_128347_("knockback", 0.1);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
                     entity.getPersistentData().m_128347_("Range", (double)(3.0F + entity.m_20206_()));
                     entity.getPersistentData().m_128347_("effect", (double)-1.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)(entity.getPersistentData().m_128459_("cnt1") <= (double)13.0F ? 1 : 2));
                     KnockbackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
                     x_pos += x_power * (double)1.0F;
                     y_pos += y_power * (double)1.0F;
                     z_pos += z_power * (double)1.0F;
                  }

                  entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
                  entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               }

               entity.getPersistentData().m_128347_("old_x", x);
               entity.getPersistentData().m_128347_("old_y", y);
               entity.getPersistentData().m_128347_("old_z", z);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)1.5F, Math.min(entity.getPersistentData().m_128459_("y_power") * (double)1.5F, (double)1.5F), entity.getPersistentData().m_128459_("z_power") * (double)1.5F));
               if (entity.m_20160_() && entity.m_146895_() instanceof LivingEntity) {
                  entity.m_146895_().m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)1.5F, Math.min(entity.getPersistentData().m_128459_("y_power") * (double)1.5F, (double)1.5F), entity.getPersistentData().m_128459_("z_power") * (double)1.5F));
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)13.0F) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               }
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
