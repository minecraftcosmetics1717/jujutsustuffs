package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.entity.PureLoveCannonEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIPureLoveCannonProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         boolean type = false;
         boolean reChange = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double rad = (double)0.0F;
         double tsuki7_mode = (double)0.0F;
         double range = (double)0.0F;
         double cnt1_local = (double)0.0F;
         double rad_now = (double)0.0F;
         double dis = (double)0.0F;
         double cnt2 = (double)0.0F;
         double NUM1 = (double)0.0F;
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double picth = (double)0.0F;
         double yaw = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), x, y, z, 1, (double)1.0F, (double)1.0F, (double)1.0F, (double)2.0F);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), x, y, z, 6, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
         }

         if (entity instanceof PureLoveCannonEntity) {
            PureLoveCannonEntity _datEntL2 = (PureLoveCannonEntity)entity;
            if ((Boolean)_datEntL2.m_20088_().m_135370_(PureLoveCannonEntity.DATA_move)) {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
                  if (entity.getPersistentData().m_128459_("cnt1") > (double)12.0F) {
                     if (entity.getPersistentData().m_128459_("cnt1") == (double)13.0F) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 20, 0.3, 0.3, 0.3, (double)2.0F);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x, y, z, 40, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, y, z, 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 20, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                     }
                  }

                  if (Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), (double)2.0F) + Math.pow(entity.m_20184_().m_7098_(), (double)2.0F) + Math.pow(entity.m_20184_().m_7094_(), (double)2.0F)) < (double)0.5F && entity.getPersistentData().m_128459_("cnt1") > (double)12.0F || entity.getPersistentData().m_128459_("cnt1") > (double)50.0F || !entity.m_6084_()) {
                     entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
                     entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                     entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                     entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
                     if (!entity.getPersistentData().m_128471_("flag_start")) {
                        entity.getPersistentData().m_128379_("flag_start", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
                     if (!entity.getPersistentData().m_128471_("Stop")) {
                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.5F, entity.getPersistentData().m_128459_("y_power") * (double)0.5F, entity.getPersistentData().m_128459_("z_power") * (double)0.5F));
                        BulletDomainHit2Procedure.execute(world, entity);
                     } else {
                        entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                        entity.getPersistentData().m_128379_("Stop", true);
                     }
                  } else {
                     entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)52.0F);
                  entity.getPersistentData().m_128347_("Range", (double)12.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                  entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
               } else {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos") + (entity.getPersistentData().m_128459_("cnt2") - (double)2.0F) * (double)2.0F;
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_thunder_purprle ~ ~ ~ 8 8 8 2 150 force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:explosion ~ ~ ~ 8 8 8 1 150 force");
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") < (double)15.0F) {
                     entity.getPersistentData().m_128347_("Damage", (double)52.0F);
                     entity.getPersistentData().m_128347_("Range", (double)24.0F * ReturnEntitySizeProcedure.execute(entity));
                     entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                     entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F, false);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") < (double)3.0F) {
                     entity.getPersistentData().m_128347_("BlockRange", (double)24.0F);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)18.0F);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") > (double)30.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               return;
            }
         }

         logic_attack = false;
         entity.getPersistentData().m_128379_("Stop", false);
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") != (double)0.0F && entity_a.getPersistentData().m_128459_("cnt1") < (double)80.0F) {
               logic_attack = true;
               entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
               }

               entity.m_146922_(entity_a.m_146908_());
               entity.m_146926_(0.0F);
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
            }
         }

         if (Math.random() < 0.05 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float)((double)0.5F + Math.random()));
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float)((double)0.5F + Math.random()), false);
            }
         }

         if (Math.random() < (double)0.5F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }
         }

         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         entity.getPersistentData().m_128379_("Stop", false);
         entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
         entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
         NUM1 = (double)-200.0F - Math.random();
         if ((!logic_attack || !entity.m_6084_()) && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CROW.get()).m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), NUM1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }

         reChange = false;
         Vec3 _center = new Vec3(entity.m_20185_(), NUM1, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
            if (entityiterator instanceof CrowEntity && entityiterator.m_6084_()) {
               if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }

               reChange = true;
               break;
            }
         }

         if (reChange && entity instanceof PureLoveCannonEntity) {
            PureLoveCannonEntity _datEntSetL = (PureLoveCannonEntity)entity;
            _datEntSetL.m_20088_().m_135381_(PureLoveCannonEntity.DATA_move, true);
         }

      }
   }
}
