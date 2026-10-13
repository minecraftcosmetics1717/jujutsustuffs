package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIJogoHeadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_knockback = (double)0.0F;
         double y_knockback = (double)0.0F;
         double z_knockback = (double)0.0F;
         double dis = (double)0.0F;
         double Power = (double)0.0F;
         double speed = (double)0.0F;
         double y_power = (double)0.0F;
         if (entity.m_20096_()) {
            entity.getPersistentData().m_128347_("yaw", (Math.random() - (double)0.5F) * (double)2.0F);
            entity.getPersistentData().m_128347_("pitch", (Math.random() - (double)0.5F) * (double)2.0F);
         } else if (!entity.getPersistentData().m_128471_("Stop")) {
            speed = Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), (double)2.0F) + Math.pow(entity.m_20184_().m_7094_(), (double)2.0F));

            for(int index0 = 0; index0 < 45; ++index0) {
               entity.m_146922_((float)((double)entity.m_146908_() + entity.getPersistentData().m_128459_("yaw") * speed));
               entity.m_146926_((float)((double)entity.m_146909_() + entity.getPersistentData().m_128459_("pitch") * speed));
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

         entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt_x") >= (double)5.0F) {
            Vec3 _center = new Vec3(x, y + (double)entity.m_20206_() * (double)0.5F, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)(entity.m_20205_() * 2.0F) / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && entityiterator.m_6084_()) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  Power = Math.sqrt(Math.pow(entityiterator.m_20184_().m_7096_(), (double)2.0F) + Math.pow(entityiterator.m_20184_().m_7094_(), (double)2.0F)) * (double)2.0F;
                  if (Power > 0.2 || entityiterator instanceof Player) {
                     if (entityiterator instanceof Player) {
                        Power = Math.max(Power, 0.1);
                     }

                     Power = Math.max(Power * (double)2.0F, (double)0.5F);
                     logic_a = true;
                     if (!entityiterator.m_20096_()) {
                        Power *= (double)2.0F;
                        y_power = 0.6;
                     } else {
                        y_power = 0.3;
                     }

                     x_knockback = entity.m_20185_() - entityiterator.m_20185_();
                     y_knockback = entity.m_20186_() - entityiterator.m_20186_();
                     z_knockback = entity.m_20189_() - entityiterator.m_20189_();
                     dis = Math.abs(x_knockback) + Math.abs(y_knockback) + Math.abs(z_knockback);
                     if (dis != (double)0.0F) {
                        x_knockback = x_knockback / dis * (double)3.0F;
                        y_knockback = y_knockback / dis * (double)3.0F;
                        z_knockback = z_knockback / dis * (double)3.0F;
                     } else {
                        x_knockback = (double)0.0F;
                        y_knockback = (double)0.0F;
                        z_knockback = (double)0.0F;
                     }

                     x_knockback = x_knockback * Power + entityiterator.m_20184_().m_7096_() * (double)2.0F;
                     y_knockback = Math.min((y_knockback + y_power) * Power, (double)2.0F);
                     z_knockback = z_knockback * Power + entityiterator.m_20184_().m_7094_() * (double)2.0F;
                     entity.m_20256_(new Vec3(x_knockback, y_knockback, z_knockback));
                     if (Power > (double)1.0F) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:punch")), SoundSource.NEUTRAL, 0.25F, 0.5F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:punch")), SoundSource.NEUTRAL, 0.25F, 0.5F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), x, y, z, 0, 0.1, 0.1, 0.1, (double)0.0F);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), x, y + (double)0.25F, z, (int)Math.round(Math.min(Power * (double)2.0F, (double)10.0F)), 0.1, 0.1, 0.1, 0.1 + Power * (double)0.25F);
                     }
                  }
                  break;
               }
            }
         }

      }
   }
}
