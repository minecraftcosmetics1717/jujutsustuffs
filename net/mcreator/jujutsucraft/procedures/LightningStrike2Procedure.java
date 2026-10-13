package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class LightningStrike2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         BlockState block_a = Blocks.f_50016_.m_49966_();
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_dis = (double)0.0F;
         double damage = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double z_dis = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double y_dis = (double)0.0F;
         double block_num = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 4, (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)1.5F);
         }

         if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         logic_attack = entity.getPersistentData().m_128459_("cnt2") > (double)180.0F;
         if (entity.getPersistentData().m_128459_("cnt2") % (double)10.0F == (double)1.0F) {
            range = Math.min(Math.max(entity.getPersistentData().m_128459_("cnt2") * (double)0.25F, (double)5.0F), (double)20.0F);
            block_num = (double)0.0F;
            x_pos = (double)Math.round(entity.m_20185_() - range);

            for(int index0 = 0; index0 < (int)Math.round(range * (double)2.0F); ++index0) {
               x_dis = Math.pow(x_pos - entity.m_20185_(), (double)2.0F);
               y_pos = (double)Math.round(entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + range);

               for(int index1 = 0; index1 < (int)Math.round(range * (double)2.0F); ++index1) {
                  y_dis = Math.pow(y_pos - (entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F), (double)2.0F);
                  z_pos = (double)Math.round(entity.m_20189_() - range);

                  for(int index2 = 0; index2 < (int)Math.round(range * (double)2.0F); ++index2) {
                     z_dis = Math.pow(z_pos - entity.m_20189_(), (double)2.0F);
                     distance = Math.sqrt(x_dis + y_dis + z_dis);
                     if (distance < range) {
                        block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                        if (block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) {
                           ++block_num;
                           entity.getPersistentData().m_128347_("Damage", (double)10.0F);
                           entity.getPersistentData().m_128347_("Range", (double)1.0F);
                           entity.getPersistentData().m_128347_("knockback", (double)0.0F);
                           RangeAttackProcedure.execute(world, x_pos + (double)0.5F, y_pos + (double)0.5F, z_pos + (double)0.5F, entity);
                        }

                        if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                           if (Math.random() < 0.05) {
                              block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos));
                              if ((block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) && world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos - (double)1.0F, z_pos, 1, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.0F);
                              }
                           }

                           if (world.m_204166_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_203656_(TagKey.m_203882_(Registries.f_256952_, new ResourceLocation("minecraft:ocean")))) {
                              entity.getPersistentData().m_128347_("Damage", (double)6.0F);
                              entity.getPersistentData().m_128347_("Range", (double)1.0F);
                              entity.getPersistentData().m_128347_("effect", (double)16.0F);
                              entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
                              entity.getPersistentData().m_128347_("knockback", (double)0.0F);
                              entity.getPersistentData().m_128379_("onlyLiving", true);
                              RangeAttackProcedure.execute(world, x_pos + (double)0.5F, y_pos + (double)0.5F, z_pos + (double)0.5F, entity);
                           }
                        }
                     }

                     z_pos = (double)Math.round(z_pos + (double)1.0F);
                  }

                  y_pos = (double)Math.round(y_pos - (double)1.0F);
               }

               x_pos = (double)Math.round(x_pos + (double)1.0F);
            }

            if (Math.sqrt(block_num) > (double)15.0F * (range / (double)20.0F)) {
               entity.getPersistentData().m_128347_("cnt3", Math.sqrt(Math.sqrt(block_num)));
               if (logic_attack) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") * (double)1.5F);
               }
            } else if (!logic_attack) {
               entity.getPersistentData().m_128347_("BlockRange", (double)6.0F);
               entity.getPersistentData().m_128347_("BlockDamage", 0.01);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         if (entity instanceof Player) {
            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - Math.min(Math.max((double)2.0F, entity.getPersistentData().m_128459_("cnt3")), (double)12.0F);
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (!logic_attack && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }

            if (!logic_attack && !entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         if (logic_attack) {
            entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
            block_num = entity.getPersistentData().m_128459_("cnt3");
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            entity.getPersistentData().m_128347_("Damage", (double)36.0F + block_num * (double)1.5F);
            entity.getPersistentData().m_128347_("Range", (double)36.0F + block_num * (double)1.5F);
            entity.getPersistentData().m_128347_("knockback", (double)0.5F);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            range = Math.max(entity.getPersistentData().m_128459_("Range") * 0.2, (double)10.0F);
            if (entity.getPersistentData().m_128459_("cnt4") > (double)5.0F) {
               range = Math.min(range, (double)8.0F);

               for(int index3 = 0; index3 < 64; ++index3) {
                  x_pos += (Math.random() - (double)0.5F) * range * (double)2.0F;
                  y_pos += (Math.random() - (double)0.5F) * range * (double)2.0F;
                  z_pos += (Math.random() - (double)0.5F) * range * (double)2.0F;
                  block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                  if (block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) {
                     break;
                  }
               }

               for(int index4 = 0; index4 < (int)Math.min(entity.getPersistentData().m_128459_("cnt4"), (double)12.0F); ++index4) {
                  block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                  if (!(block_a.m_60734_() instanceof LiquidBlock) && !(block_a.m_60734_() instanceof SimpleWaterloggedBlock) || world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + (double)1.0F, z_pos))) {
                     break;
                  }

                  ++y_pos;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, (double)2.5F), (double)75.0F), (double)40.0F), range, range, range, (double)1.0F);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, (double)2.5F), (double)50.0F), (double)25.0F), range, range, range, (double)0.5F);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, (double)2.5F), (double)150.0F), (double)75.0F), range, range, range, (double)1.0F);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, (double)2.5F), (double)75.0F), (double)40.0F), range, range, range, (double)1.0F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.75F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
               }
            }

            range = Math.min(range, (double)8.0F);
            block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
            if (!(block_a.m_60734_() instanceof LiquidBlock) && !(block_a.m_60734_() instanceof SimpleWaterloggedBlock)) {
               for(int index5 = 0; index5 < 64; ++index5) {
                  x_pos += (Math.random() - (double)0.5F) * range * (double)2.0F;
                  y_pos += (Math.random() - (double)0.5F) * range * (double)2.0F;
                  z_pos += (Math.random() - (double)0.5F) * range * (double)2.0F;
                  block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                  if (block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) {
                     break;
                  }
               }
            }

            entity.getPersistentData().m_128347_("BlockRange", (double)8.0F);
            entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F);
            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)210.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 400, entity instanceof KashimoHajimeEntity ? 1 : 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
