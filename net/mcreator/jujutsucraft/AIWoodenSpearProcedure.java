package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.IceSpear2Entity;
import net.mcreator.jujutsucraft.entity.IceSpearEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWoodenSpearProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean attack = false;
         boolean logic_a = false;
         boolean ice = false;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         entity.f_19789_ = 0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            WoodenSpear2OnInitialEntitySpawnProcedure.execute(entity);
         }

         ice = entity instanceof IceSpearEntity || entity instanceof IceSpear2Entity;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = (double)(2.0F + (entity.m_20206_() + entity.m_20205_()) * 1.0F);
         attack = false;
         speed = Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("y_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("z_power"), (double)2.0F));
         if (speed > (double)0.0F) {
            x_power = entity.getPersistentData().m_128459_("x_power") / speed;
            y_power = entity.getPersistentData().m_128459_("y_power") / speed;
            z_power = entity.getPersistentData().m_128459_("z_power") / speed;
         } else {
            speed = (double)1.0F;
            x_power = (double)0.0F;
            y_power = (double)1.0F;
            z_power = (double)0.0F;
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)8.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && !ice) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

               for(int index0 = 0; index0 < (int)((double)4.0F + range * (double)0.5F); ++index0) {
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x_pos + x_power, y_pos + y_power, z_pos + z_power)).m_60815_()) {
                     world.m_46796_(2001, BlockPos.m_274561_(x_pos + x_power, y_pos + y_power, z_pos + z_power), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            logic_a = false;
            if (!ice && range > (double)18.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

               for(int index1 = 0; index1 < (int)((double)4.0F + range * (double)0.5F); ++index1) {
                  if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos - x_power, y_pos - y_power, z_pos - z_power)).m_60815_()) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)range, range, range, range, (double)1.0F);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)range, range, range, range, (double)1.0F);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            }

            for(int index2 = 0; index2 < (int)Math.max(speed * (double)3.0F, (double)1.0F); ++index2) {
               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               entity.getPersistentData().m_128347_("knockback", ice ? 0.01 : (double)0.25F * Math.pow(CNT6, (double)2.0F));
               entity.getPersistentData().m_128347_("Range", range);
               entity.getPersistentData().m_128347_("effect", (double)(ice ? 14 : 1));
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
               if (!ice) {
                  entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                  }
               }

               entity.getPersistentData().m_128347_("movement_amount", entity.getPersistentData().m_128459_("movement_amount") + (double)1.0F);
               if ((entity.getPersistentData().m_128459_("movement_amount") >= 0.4 * range || ice) && (!world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())).m_60815_() || ice)) {
                  double var10000;
                  label225: {
                     logic_a = true;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity52 = (LivingEntity)entity;
                        if (_livingEntity52.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity52.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label225;
                        }
                     }

                     var10000 = (double)0.0F;
                  }

                  if (var10000 < (double)1.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2) && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity55 = (LivingEntity)entity;
                     if (_livingEntity55.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity55.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)1.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2));
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
                  BulletDomainHit2Procedure.execute(world, entity);
                  entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
                  entity.getPersistentData().m_128347_("knockback", ice ? 0.01 : (double)0.25F * Math.pow(CNT6, (double)2.0F));
                  entity.getPersistentData().m_128347_("Range", range);
                  entity.getPersistentData().m_128347_("effect", (double)(ice ? 14 : 1));
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                  break;
               }
            }

            if (logic_a) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               if (ice) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.4F, 1.1F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.4F, 1.1F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 8, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                  }
               } else {
                  for(int index3 = 0; index3 < (int)(range * (double)0.5F); ++index3) {
                     x_pos -= x_power;
                     y_pos -= y_power;
                     z_pos -= z_power;
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 8, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 8, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                        }

                        world.m_46796_(2001, BlockPos.m_274561_(x_pos, y_pos, z_pos), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                        break;
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            }

            attack = true;
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("move") == (double)0.0F) {
               if (ice) {
                  if (entity.getPersistentData().m_128459_("cnt3") > (double)20.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               } else if (entity.getPersistentData().m_128459_("cnt3") > (double)60.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else {
               AIWoodenSpear2Procedure.execute(world, x, y, z, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("move") == (double)0.0F) {
            if (attack) {
               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               entity.getPersistentData().m_128347_("effect", (double)(ice ? 14 : 1));
               entity.getPersistentData().m_128347_("knockback", ice ? (double)1.0F : 0.01);
               entity.getPersistentData().m_128347_("Range", range);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
            }

            if (ice && entity.getPersistentData().m_128459_("cnt1") % (double)20.0F == (double)10.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)1.0F * CNT6);
               entity.getPersistentData().m_128347_("Range", range);
               entity.getPersistentData().m_128347_("knockback", 0.01);
               entity.getPersistentData().m_128347_("effect", (double)14.0F);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
            }
         }

         if (!ice) {
            if (!entity.m_6084_()) {
               world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * (double)0.5F, z), Block.m_49956_(WoodenSpear1DisplayConditionProcedure.execute(entity) ? Blocks.f_50652_.m_49966_() : Blocks.f_50011_.m_49966_()));
               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         } else {
            if (Math.random() < (double)0.5F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x, y, z, 1, (double)1.5F, (double)0.25F, (double)1.5F, (double)0.0F);
            }

            if (Math.random() < 0.1 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123815_, x, y, z, 1, (double)1.5F, (double)1.0F, (double)1.5F, (double)0.0F);
            }
         }

      }
   }
}
