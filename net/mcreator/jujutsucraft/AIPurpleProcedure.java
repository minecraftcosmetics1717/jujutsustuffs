package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIPurpleProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean big = false;
         boolean logic_attack = false;
         double damage = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double power = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         big = entity.getPersistentData().m_128471_("explode");
         power = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (big) {
            range *= (double)3.0F;
            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               logic_attack = false;
               if (LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     logic_attack = true;
                     entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                     entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                     entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                     entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
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

               if (!logic_attack || !entity.m_6084_()) {
                  entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") != (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
                  double var10000;
                  label185: {
                     entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity25 = (LivingEntity)entity;
                        if (_livingEntity25.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity25.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label185;
                        }
                     }

                     var10000 = (double)0.0F;
                  }

                  if (var10000 < entity.getPersistentData().m_128459_("size") && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity30 = (LivingEntity)entity;
                     if (_livingEntity30.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        double var10001;
                        label178: {
                           var74 = _livingEntity30.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity27 = (LivingEntity)entity;
                              if (_livingEntity27.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity27.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                 break label178;
                              }
                           }

                           var10001 = (double)0.0F;
                        }

                        var74.m_22100_(Math.min(var10001 + (entity.getPersistentData().m_128459_("size") - (double)5.0F) * 0.2, entity.getPersistentData().m_128459_("size")));
                     }
                  }

                  if (big) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123747_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)1.0F * range), range, range, range, range);
                     }
                  } else if (LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                        yaw = Math.toRadians((double)(entity_a.m_146908_() + 90.0F));
                        pitch = Math.toRadians((double)entity_a.m_146909_());
                        dis = ((double)(2.0F + entity_a.m_20205_()) + Math.max(entity.getPersistentData().m_128459_("size"), (double)5.0F) * 0.2) * (double)0.75F;
                        entity.m_6021_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F + Math.sin(pitch) * (double)-1.0F * dis, entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F + Math.sin(pitch) * (double)-1.0F * dis, entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis, entity.m_146908_(), entity.m_146909_());
                        }

                        entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                        entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                        entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                     }
                  }
               } else {
                  BulletDomainHit2Procedure.execute(world, entity);
                  if (!big) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)5.0F * range), range, range, range, range);
                     }
                  } else {
                     double var75;
                     label234: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity58 = (LivingEntity)entity;
                           if (_livingEntity58.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              var75 = _livingEntity58.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                              break label234;
                           }
                        }

                        var75 = (double)0.0F;
                     }

                     if (var75 < (double)100.0F && entity instanceof LivingEntity) {
                        LivingEntity _livingEntity60 = (LivingEntity)entity;
                        if (_livingEntity60.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           double var77;
                           label225: {
                              var76 = _livingEntity60.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity59 = (LivingEntity)entity;
                                 if (_livingEntity59.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    var77 = _livingEntity59.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                    break label225;
                                 }
                              }

                              var77 = (double)0.0F;
                           }

                           var76.m_22100_(Math.min(var77 + (double)10.0F, (double)100.0F));
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F, false);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") % (double)4.0F == (double)1.0F && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float)((double)0.5F + Math.random()));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float)((double)0.5F + Math.random()), false);
                        }
                     }

                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();

                     for(int index0 = 0; index0 < (int)((double)36.0F * range); ++index0) {
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)-45.0F, (double)45.0F) * Math.random() * Math.random() * Math.random(), (double)0.0F, (double)1.0F, (double)12.0F, x_pos, x_pos, y_pos, y_pos, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), z_pos, z_pos, "jujutsucraft:particle_thunder_purple");
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)-45.0F, (double)45.0F) * Math.random() * Math.random() * Math.random(), (double)0.0F, (double)1.0F, (double)12.0F, x_pos, x_pos, y_pos, y_pos, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), z_pos, z_pos, "cloud");
                     }
                  }

                  x_power = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
                  y_power = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
                  z_power = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  if (dis > (double)0.0F) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                  }

                  damage = Math.max((double)80.0F * Math.pow(0.99, entity.getPersistentData().m_128459_("cnt_life")), (double)55.0F) * power;

                  for(int index1 = 0; index1 < (int)Math.round(Math.max(dis, (double)1.0F)); ++index1) {
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();
                     if (!big && entity.getPersistentData().m_128459_("cnt1") >= (double)12.0F) {
                        if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_) && world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP)) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, (float)((double)2.0F * range), ExplosionInteraction.MOB);
                              }
                           }
                        } else if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }

                     if (!big || entity.getPersistentData().m_128459_("cnt1") <= (double)30.0F) {
                        entity.getPersistentData().m_128347_("Damage", damage);
                        entity.getPersistentData().m_128347_("Range", (double)8.0F * range);
                        if (big) {
                           entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                        } else {
                           entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("cnt6") >= (double)2.0F ? (double)1.0F : 0.1);
                        }

                        entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
                        if (big) {
                           entity.getPersistentData().m_128379_("betrayal", true);
                        }

                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!big || entity.getPersistentData().m_128459_("cnt1") % (double)4.0F == (double)1.0F) {
                        entity.getPersistentData().m_128347_("BlockRange", (double)3.0F * range);
                        entity.getPersistentData().m_128347_("BlockDamage", (double)18.0F * power);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        entity.getPersistentData().m_128379_("noEffect", true);
                        entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (big) {
                        break;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), x_pos, y_pos, z_pos, (int)((double)5.0F * range), range, range, range, range);
                     }

                     if (entity.getPersistentData().m_128471_("Stop")) {
                        entity.getPersistentData().m_128379_("Stop", false);
                        break;
                     }

                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  if (big) {
                     entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  } else {
                     entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)1.0F, entity.getPersistentData().m_128459_("y_power") * (double)1.0F, entity.getPersistentData().m_128459_("z_power") * (double)1.0F));
                  }

                  entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt1") >= (double)(big ? 80 : 30) && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         }

      }
   }
}
