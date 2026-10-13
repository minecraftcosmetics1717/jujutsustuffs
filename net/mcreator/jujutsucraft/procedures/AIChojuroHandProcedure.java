package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityHandEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIChojuroHandProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         double HP = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double rad = (double)0.0F;
         double x_power = (double)0.0F;
         double entity_size = (double)0.0F;
         double y_pos = (double)0.0F;
         entity.f_19789_ = 0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && entity.getPersistentData().m_128459_("skill") >= (double)400.0F && entity.getPersistentData().m_128459_("skill") < (double)500.0F) {
            if (entity instanceof EntityHandEntity) {
               EntityHandEntity animatable = (EntityHandEntity)entity;
               animatable.setTexture("ball_maximum");
            }

            if (entity instanceof EntityHandEntity) {
               EntityHandEntity _datEntSetL = (EntityHandEntity)entity;
               _datEntSetL.m_20088_().m_135381_(EntityHandEntity.DATA_Magma, true);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         attack = false;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = (double)(2.0F + (entity.m_20206_() + entity.m_20205_()) * 1.0F);
         speed = Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("y_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("z_power"), (double)2.0F));
         entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
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
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
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
            if (range > (double)18.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

               for(int index1 = 0; index1 < (int)((double)4.0F + range * (double)0.5F); ++index1) {
                  if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos - x_power, y_pos - y_power, z_pos - z_power)).m_60815_()) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)range, range, range, range, (double)1.0F);
                     }

                     label329: {
                        if (entity instanceof EntityHandEntity) {
                           EntityHandEntity _datEntL35 = (EntityHandEntity)entity;
                           if ((Boolean)_datEntL35.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, (int)range, range, range, range, (double)1.0F);
                              }
                              break label329;
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)range, range, range, range, (double)1.0F);
                        }
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

            for(int index2 = 0; index2 < (int)(speed * (double)3.0F); ++index2) {
               CompoundTag var10000;
               byte var10002;
               label316: {
                  entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
                  entity.getPersistentData().m_128347_("knockback", (double)0.25F * Math.pow(CNT6, (double)2.0F));
                  entity.getPersistentData().m_128347_("Range", range);
                  var10000 = entity.getPersistentData();
                  if (entity instanceof EntityHandEntity) {
                     EntityHandEntity _datEntL42 = (EntityHandEntity)entity;
                     if ((Boolean)_datEntL42.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                        var10002 = 10;
                        break label316;
                     }
                  }

                  var10002 = 1;
               }

               var10000.m_128347_("effect", (double)var10002);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
               entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
               }

               entity.getPersistentData().m_128347_("movement_amount", entity.getPersistentData().m_128459_("movement_amount") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("movement_amount") >= (double)1.0F * range && !world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())).m_60815_()) {
                  label306: {
                     logic_a = true;
                     entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
                     BulletDomainHit2Procedure.execute(world, entity);
                     entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)0.25F * Math.pow(CNT6, (double)2.0F));
                     entity.getPersistentData().m_128347_("Range", range);
                     var10000 = entity.getPersistentData();
                     if (entity instanceof EntityHandEntity) {
                        EntityHandEntity _datEntL63 = (EntityHandEntity)entity;
                        if ((Boolean)_datEntL63.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                           var10002 = 10;
                           break label306;
                        }
                     }

                     var10002 = 1;
                  }

                  var10000.m_128347_("effect", (double)var10002);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                  break;
               }
            }

            if (logic_a) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

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

                     label287: {
                        if (entity instanceof EntityHandEntity) {
                           EntityHandEntity _datEntL76 = (EntityHandEntity)entity;
                           if ((Boolean)_datEntL76.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 8, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                              }
                              break label287;
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 8, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                        }
                     }

                     world.m_46796_(2001, BlockPos.m_274561_(x_pos, y_pos, z_pos), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                     break;
                  }
               }

               entity.getPersistentData().m_128347_("x_pos", x_pos);
               entity.getPersistentData().m_128347_("y_pos", y_pos);
               entity.getPersistentData().m_128347_("z_pos", z_pos);

               for(int index4 = 0; index4 < 10; ++index4) {
                  int var10001;
                  label263: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label263;
                        }
                     }

                     var10001 = 0;
                  }

                  HP = (double)(40 + var10001 * 8);
                  rad = Math.toRadians(Math.random() * (double)720.0F);
                  dis = range * 0.3;
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad) * dis;
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad) * dis;

                  for(int index5 = 0; index5 < (int)(range * (double)0.5F); ++index5) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        ++y_pos;
                     } else {
                        if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos)).m_60815_()) {
                           break;
                        }

                        --y_pos;
                     }
                  }

                  if (entity instanceof EntityHandEntity) {
                     EntityHandEntity _datEntL90 = (EntityHandEntity)entity;
                     if ((Boolean)_datEntL90.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                        continue;
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROCK_FRAGMENT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity93 = (LivingEntity)entityinstance;
                           if (_livingEntity93.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity93.m_21051_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        if (GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) {
                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                           entity.getPersistentData().m_128347_("NameRanged", (double)0.0F);
                           entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged_ranged"));
                        }

                        entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                        entityinstance.m_20256_(new Vec3((Math.random() - (double)0.5F) * (double)3.0F, Math.random() * (double)1.5F + (double)0.75F, (Math.random() - (double)0.5F) * (double)3.0F));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity112 = (LivingEntity)entityinstance;
                           if (_livingEntity112.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity112.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)1.0F + Math.random());
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            }

            attack = true;
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") > (double)120.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }

            if (entity instanceof EntityHandEntity) {
               EntityHandEntity _datEntL121 = (EntityHandEntity)entity;
               if ((Boolean)_datEntL121.m_20088_().m_135370_(EntityHandEntity.DATA_Magma) && entity.getPersistentData().m_128459_("cnt3") > (double)20.0F) {
                  entity.m_6021_(entity.m_20185_() + (double)0.0F, entity.m_20186_() - (double)0.5F, entity.m_20189_() + (double)0.0F);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + (double)0.0F, entity.m_20186_() - (double)0.5F, entity.m_20189_() + (double)0.0F, entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.getPersistentData().m_128459_("cnt3") > (double)60.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("move") == (double)0.0F && attack) {
            CompoundTag var103;
            byte var105;
            label251: {
               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               var103 = entity.getPersistentData();
               if (entity instanceof EntityHandEntity) {
                  EntityHandEntity _datEntL132 = (EntityHandEntity)entity;
                  if ((Boolean)_datEntL132.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                     var105 = 10;
                     break label251;
                  }
               }

               var105 = 1;
            }

            var103.m_128347_("effect", (double)var105);
            entity.getPersistentData().m_128347_("knockback", 0.01);
            entity.getPersistentData().m_128347_("Range", range);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F * CNT6);
            entity.getPersistentData().m_128347_("BlockRange", (double)0.5F * range);
            if (entity instanceof EntityHandEntity) {
               EntityHandEntity _datEntL142 = (EntityHandEntity)entity;
               if ((Boolean)_datEntL142.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                  entity.getPersistentData().m_128347_("effect", (double)3.0F);
               }
            }

            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
         }

         if (!entity.m_6084_()) {
            BlockPos var106;
            BlockState var10003;
            label244: {
               entity_size = ReturnEntitySizeProcedure.execute(entity);
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               z_pos = entity.m_20189_();
               var106 = BlockPos.m_274561_(x_pos, y_pos, z_pos);
               if (entity instanceof EntityHandEntity) {
                  EntityHandEntity _datEntL154 = (EntityHandEntity)entity;
                  if ((Boolean)_datEntL154.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                     var10003 = Blocks.f_50450_.m_49966_();
                     break label244;
                  }
               }

               var10003 = Blocks.f_50652_.m_49966_();
            }

            world.m_46796_(2001, var106, Block.m_49956_(var10003));
            if (!entity.m_6084_()) {
               label237: {
                  if (entity instanceof EntityHandEntity) {
                     EntityHandEntity _datEntL157 = (EntityHandEntity)entity;
                     if ((Boolean)_datEntL157.m_20088_().m_135370_(EntityHandEntity.DATA_Magma)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, (int)((double)10.0F * entity_size * entity_size), (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size);
                        }
                        break label237;
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)20.0F * entity_size * entity_size), (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)((double)20.0F * entity_size * entity_size), (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size, (double)0.25F * entity_size);
               }
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
