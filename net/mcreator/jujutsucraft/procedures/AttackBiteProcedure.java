package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackBiteProcedure {
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
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            if (OnGroundProcedure.execute(world, entity)) {
               world.m_46796_(2001, BlockPos.m_274561_(x, y - (double)1.0F, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y - (double)1.0F, z))));
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
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

                  double var66 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var66 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                  LivingEntity var67;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var67 = _mobEnt.m_5448_();
                  } else {
                     var67 = null;
                  }

                  z_pos = ((Entity)var67).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               GetPowerFixProcedure.execute(entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 10, 0.2, (double)0.0F, 0.2, (double)0.5F);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity26 = (LivingEntity)entity;
                  if (_livingEntity26.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity26.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-10.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity27 = (LivingEntity)entity;
                  if (_livingEntity27.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity27.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            } else if (entity.getPersistentData().m_128459_("cnt1") > (double)200.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         } else {
            entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
            entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
                  if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 20, 0.2, (double)0.0F, 0.2, (double)0.5F);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity42 = (LivingEntity)entity;
                        if (_livingEntity42.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity42.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)100.0F);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity43 = (LivingEntity)entity;
                        if (_livingEntity43.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity43.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  if (entity.m_20096_()) {
                     entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, Math.min(Math.max(entity.getPersistentData().m_128459_("y_power") * (double)0.75F, (double)0.5F), (double)1.5F), entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
                  } else {
                     entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, Math.min(entity.getPersistentData().m_128459_("y_power") * (double)0.75F, (double)1.5F), entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
                  }
               } else if (entity.m_20096_()) {
                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.5F, entity.m_20184_().m_7098_(), entity.getPersistentData().m_128459_("z_power") * (double)0.5F));
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > (double)0.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
                  entity.getPersistentData().m_128347_("cnt_target", (double)10.0F);

                  for(int index0 = 0; index0 < (int)Math.round(dis); ++index0) {
                     entity.getPersistentData().m_128347_("Damage", (double)14.0F);
                     entity.getPersistentData().m_128347_("Range", (double)(3.0F + entity.m_20206_()));
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
                     x_pos += x_power * (double)1.0F;
                     y_pos += y_power * (double)1.0F;
                     z_pos += z_power * (double)1.0F;
                  }

                  entity.getPersistentData().m_128347_("cnt_target", (double)1.0F);
               }

               entity.getPersistentData().m_128347_("old_x", x);
               entity.getPersistentData().m_128347_("old_y", y);
               entity.getPersistentData().m_128347_("old_z", z);
               if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F || entity.getPersistentData().m_128459_("cnt1") > (double)25.0F && entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
