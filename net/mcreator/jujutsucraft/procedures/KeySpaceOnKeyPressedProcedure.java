package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class KeySpaceOnKeyPressedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double NUM1 = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double speed = (double)0.0F;
         entity.getPersistentData().m_128379_("PRESS_SPACE", true);
         if (!entity.m_20096_() && entity instanceof LivingEntity) {
            LivingEntity _livEnt2 = (LivingEntity)entity;
            if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()) && (!(entity instanceof Player) || !((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity) && !((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity))) {
               double var10000;
               label102: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
                        var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()).m_19564_();
                        break label102;
                     }
                  }

                  var10000 = (double)0.0F;
               }

               label97: {
                  NUM1 = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
                        var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()).m_19557_();
                        break label97;
                     }
                  }

                  var10000 = (double)0.0F;
               }

               NUM2 = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
               }

               if (NUM1 >= (double)1.0F && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), (int)NUM2, (int)(NUM1 - (double)1.0F), false, false));
                  }
               }

               label117: {
                  speed = (double)1.0F;
                  if (!entity.getPersistentData().m_128471_("PRESS_W") && !entity.getPersistentData().m_128471_("PRESS_S")) {
                     LivingEntity var39;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var39 = _mobEnt.m_5448_();
                     } else {
                        var39 = null;
                     }

                     if (!(var39 instanceof LivingEntity)) {
                        x_power = entity.m_20184_().m_7096_();
                        y_power = entity.m_20184_().m_7098_() + (double)1.0F * speed;
                        z_power = entity.m_20184_().m_7094_();
                        break label117;
                     }
                  }

                  x_power = entity.m_20184_().m_7096_() + entity.m_20154_().f_82479_ * speed * (double)(entity.getPersistentData().m_128471_("PRESS_S") ? -1 : 1);
                  y_power = entity.m_20184_().m_7098_() + entity.m_20154_().f_82480_ * speed;
                  z_power = entity.m_20184_().m_7094_() + entity.m_20154_().f_82481_ * speed * (double)(entity.getPersistentData().m_128471_("PRESS_S") ? -1 : 1);
               }

               x_power = x_power < (double)0.0F ? Math.min(entity.m_20184_().m_7096_(), Math.max(x_power, speed * (double)-1.0F)) : Math.max(entity.m_20184_().m_7096_(), Math.min(x_power, speed * (double)1.0F));
               y_power = y_power < (double)0.0F ? Math.min(entity.m_20184_().m_7098_(), Math.max(y_power, speed * (double)-1.0F)) : Math.max(entity.m_20184_().m_7098_(), Math.min(y_power, speed * (double)1.0F));
               z_power = z_power < (double)0.0F ? Math.min(entity.m_20184_().m_7094_(), Math.max(z_power, speed * (double)-1.0F)) : Math.max(entity.m_20184_().m_7094_(), Math.min(z_power, speed * (double)1.0F));
               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               entity.f_19789_ = 0.0F;

               for(int index0 = 0; index0 < 3; ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), x, y, z, 0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
               }
            }
         }

      }
   }
}
