package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.MeteorEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIMeteorProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double distance = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double num_a = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double x_knockback = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double entity_size = (double)0.0F;
         double z_knockback = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double y_knockback = (double)0.0F;
         entity_size = ReturnEntitySizeProcedure.execute(entity) * (double)2.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         entity.f_19789_ = 0.0F;
         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         int var10000;
         if (entity instanceof MeteorEntity) {
            MeteorEntity _datEntI = (MeteorEntity)entity;
            var10000 = (Integer)_datEntI.m_20088_().m_135370_(MeteorEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 == 0) {
            entity.m_146922_((float)((double)entity.m_146908_() + (double)22.5F));
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

            label326: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity9 = (LivingEntity)entity;
                  if (_livingEntity9.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var119 = _livingEntity9.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                     break label326;
                  }
               }

               var119 = (double)0.0F;
            }

            if (var119 < (double)1.0F && entity instanceof LivingEntity) {
               LivingEntity _livingEntity11 = (LivingEntity)entity;
               if (_livingEntity11.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  label319: {
                     var120 = _livingEntity11.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity10 = (LivingEntity)entity;
                        if (_livingEntity10.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity10.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label319;
                        }
                     }

                     var10001 = (double)0.0F;
                  }

                  var120.m_22100_(Math.min(var10001 + 0.01, (double)1.0F));
               }
            }

            logic_a = true;
            entity.getPersistentData().m_128347_("x_power", (double)0.0F);
            entity.getPersistentData().m_128347_("y_power", (double)-1.5F);
            entity.getPersistentData().m_128347_("z_power", (double)0.0F);
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (entity_a instanceof LivingEntity) {
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && entity_a.getPersistentData().m_128459_("NameRanged") == entity.getPersistentData().m_128459_("NameRanged_ranged")) {
                  if (entity_a.getPersistentData().m_128459_("skill") == (double)415.0F) {
                     entity.m_6021_(entity_a.m_20185_() + (double)0.0F, entity_a.m_20186_() + (double)(entity_a.m_20206_() * 1.0F) + (double)(entity.m_20206_() * 1.0F) + (double)3.0F, entity_a.m_20189_() + (double)0.0F);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + (double)0.0F, entity_a.m_20186_() + (double)(entity_a.m_20206_() * 1.0F) + (double)(entity.m_20206_() * 1.0F) + (double)3.0F, entity_a.m_20189_() + (double)0.0F, entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_146922_(entity_a.m_146908_());
                     entity.m_146926_(entity_a.m_146909_());
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entity_a.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
                        logic_a = false;
                        LivingEntity var121;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var121 = _mobEnt.m_5448_();
                        } else {
                           var121 = null;
                        }

                        if (var121 instanceof LivingEntity) {
                           EntityAnchorArgument.Anchor var123 = Anchor.EYES;
                           Vec3 var10002 = new Vec3;
                           LivingEntity var10004;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10004 = _mobEnt.m_5448_();
                           } else {
                              var10004 = null;
                           }

                           double var124 = ((Entity)var10004).m_20185_();
                           LivingEntity var10005;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10005 = _mobEnt.m_5448_();
                           } else {
                              var10005 = null;
                           }

                           double var125 = ((Entity)var10005).m_20186_();
                           LivingEntity var10006;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10006 = _mobEnt.m_5448_();
                           } else {
                              var10006 = null;
                           }

                           var10002.<init>(var124, var125, ((Entity)var10006).m_20189_());
                           entity_a.m_7618_(var123, var10002);
                        }

                        yaw = (double)entity_a.m_146908_();
                        pitch = (double)entity_a.m_146909_();
                        entity_a.m_146922_((float)yaw);
                        entity_a.m_146926_((float)Math.max(pitch, (double)67.5F));
                        entity_a.m_5618_(entity_a.m_146908_());
                        entity_a.m_5616_(entity_a.m_146908_());
                        entity_a.f_19859_ = entity_a.m_146908_();
                        entity_a.f_19860_ = entity_a.m_146909_();
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entity.getPersistentData().m_128347_("x_power", entity_a.m_20154_().f_82479_ * (double)1.5F);
                        entity.getPersistentData().m_128347_("y_power", entity_a.m_20154_().f_82480_ * (double)1.5F);
                        entity.getPersistentData().m_128347_("z_power", entity_a.m_20154_().f_82481_ * (double)1.5F);
                        entity_a.m_146922_((float)yaw);
                        entity_a.m_146926_((float)pitch);
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
                  } else {
                     logic_a = false;
                  }
               } else {
                  logic_a = false;
               }
            } else {
               logic_a = false;
            }

            if (!logic_a && entity.getPersistentData().m_128459_("cnt_life") > (double)60.0F) {
               entity.getPersistentData().m_128347_("cnt_life", (double)100.0F);
               if (entity instanceof MeteorEntity) {
                  MeteorEntity _datEntSetI = (MeteorEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(MeteorEntity.DATA_mode, 1);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_life") % (double)5.0F == (double)1.0F) {
               entity.getPersistentData().m_128347_("BlockRange", (double)24.0F);
               entity.getPersistentData().m_128347_("BlockDamage", (double)15.0F);
               entity.getPersistentData().m_128347_("knockback", (double)-1.0F);
               entity.getPersistentData().m_128347_("effect", (double)3.0F);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            }

            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)24.0F), (e) -> true)) {
               if (entity != entityiterator && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_living")))) {
                  x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                  y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                  z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                  dis = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                  if (dis != (double)0.0F) {
                     x_knockback = x_knockback / dis * (double)3.0F;
                     y_knockback = y_knockback / dis * (double)3.0F;
                     z_knockback = z_knockback / dis * (double)3.0F;
                  }

                  entityiterator.m_20256_(new Vec3(x_knockback, y_knockback, z_knockback));
               }
            }

            for(int index0 = 0; index0 < (int)(4.0F * entity.m_20206_()); ++index0) {
               yaw = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               distance = Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F);
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               y_pos = entity.m_20186_() + (double)0.5F * (double)entity.m_20206_() + Math.sin(pitch) * (double)-1.0F * distance * (double)entity.m_20205_();
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               y_pos -= (distance - (double)0.5F) * (double)2.0F * (double)entity.m_20206_();
               ParticleGeneratorProcedure.execute(world, (double)entity.m_20205_() * (double)0.25F, (double)1.0F, (double)0.0F, (double)1.0F, x_pos, x_pos + Math.cos(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance * (double)entity.m_20205_(), y_pos, y_pos + Math.sin(pitch) * (double)-1.0F * distance * (double)entity.m_20205_(), z_pos, z_pos + Math.sin(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance * (double)entity.m_20205_(), "minecraft:flame");
            }

            for(int index1 = 0; index1 < (int)(4.0F * entity.m_20206_()); ++index1) {
               yaw = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               distance = Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F);
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               y_pos = entity.m_20186_() - (double)0.5F * (double)entity.m_20206_() + Math.sin(pitch) * (double)-1.0F * distance * (double)entity.m_20205_();
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               y_pos += (distance - (double)0.5F) * (double)2.0F * (double)entity.m_20206_();
               ParticleGeneratorProcedure.execute(world, (double)entity.m_20205_() * (double)0.25F, (double)1.0F, (double)0.0F, (double)1.0F, x_pos, x_pos + Math.cos(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance * (double)entity.m_20205_(), y_pos, y_pos + Math.sin(pitch) * (double)-1.0F * distance * (double)entity.m_20205_(), z_pos, z_pos + Math.sin(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance * (double)entity.m_20205_(), "minecraft:flame");
            }
         }

         if (entity instanceof MeteorEntity) {
            MeteorEntity _datEntI = (MeteorEntity)entity;
            var10000 = (Integer)_datEntI.m_20088_().m_135370_(MeteorEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 != 0) {
            if ((double)22.5F - (entity.getPersistentData().m_128459_("cnt_life") - (double)100.0F) > (double)0.0F) {
               entity.m_146922_((float)((double)entity.m_146908_() + Math.max((double)0.0F, (double)22.5F - (entity.getPersistentData().m_128459_("cnt_life") - (double)100.0F))));
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
            }

            x_power = entity.getPersistentData().m_128459_("x_power");
            y_power = entity.getPersistentData().m_128459_("y_power");
            z_power = entity.getPersistentData().m_128459_("z_power");
            if (entity.getPersistentData().m_128459_("cnt_life") < (double)200.0F) {
               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > (double)1.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               } else {
                  dis = (double)1.0F;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

               for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                  ++num_a;
                  if (num_a > (double)0.0F) {
                     num_a = (double)3.0F * entity_size * (double)-0.5F;
                     entity.getPersistentData().m_128347_("Damage", (double)50.0F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)3.0F * entity_size);
                     entity.getPersistentData().m_128347_("knockback", (double)2.0F);
                     entity.getPersistentData().m_128347_("effect", (double)3.0F);
                     entity.getPersistentData().m_128379_("attack", false);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (!entity.m_5830_() && !InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }
                  } else {
                     entity.getPersistentData().m_128347_("BlockRange", Math.min((double)2.0F * entity_size, (double)24.0F));
                     entity.getPersistentData().m_128347_("BlockDamage", (double)15.0F * CNT6);
                     entity.getPersistentData().m_128347_("effect", (double)3.0F);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity);
                     if (InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F)) {
                        break;
                     }
                  }
               }

               entity.getPersistentData().m_128347_("Damage", (double)50.0F * CNT6);
               entity.getPersistentData().m_128347_("Range", (double)3.0F * entity_size);
               entity.getPersistentData().m_128347_("knockback", (double)2.0F);
               entity.getPersistentData().m_128347_("effect", (double)3.0F);
               entity.getPersistentData().m_128379_("attack", false);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);

               for(int index3 = 0; index3 < 36; ++index3) {
                  ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)4.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)4.0F, (double)4.0F), x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, z_pos, z_pos, "flame");
                  ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)4.0F), x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), 0.05, (double)0.25F), (double)0.0F, z_pos, z_pos, "jujutsucraft:particle_flame");
               }
            }

            if (entity.m_5830_() || InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, (double)entity.m_20206_(), (double)entity.m_20205_()) || !entity.m_6084_() || entity.getPersistentData().m_128459_("cnt_life") >= (double)200.0F) {
               entity.getPersistentData().m_128347_("cnt_life", Math.max(entity.getPersistentData().m_128459_("cnt_life"), (double)200.0F));
               distance = (double)entity.m_20205_() * (double)0.5F;
               x_pos = entity.m_20185_() + x_power * distance;
               y_pos = entity.m_20186_() + y_power * distance;
               z_pos = entity.m_20189_() + z_power * distance;
               if (entity.getPersistentData().m_128459_("cnt_life") < (double)240.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, (int)((double)8.0F * CNT6 * entity_size), (double)1.0F * entity_size, (double)1.0F * entity_size, (double)1.0F * entity_size, (double)2.0F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME.get(), x_pos, y_pos, z_pos, (int)((double)8.0F * CNT6 * entity_size), (double)1.0F * entity_size, (double)1.0F * entity_size, (double)1.0F * entity_size, (double)2.0F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_life") % (double)10.0F == (double)0.0F) {
                     entity.getPersistentData().m_128347_("BlockRange", Math.min((double)3.0F * entity_size, (double)32.0F));
                     entity.getPersistentData().m_128347_("BlockDamage", (double)20.0F * CNT6);
                     entity.getPersistentData().m_128347_("effect", (double)3.0F);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  } else if (entity.getPersistentData().m_128459_("cnt_life") <= (double)208.0F) {
                     entity.getPersistentData().m_128347_("BlockRange", Math.min((double)2.0F * entity_size, (double)24.0F));
                     entity.getPersistentData().m_128347_("BlockDamage", (double)20.0F * CNT6);
                     entity.getPersistentData().m_128347_("effect", (double)3.0F);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos + Math.sin(Math.toRadians(entity.getPersistentData().m_128459_("cnt_life") * (double)45.0F)) * (double)1.0F * Math.min((double)3.0F * entity_size, (double)32.0F), y_pos, z_pos + Math.cos(Math.toRadians(entity.getPersistentData().m_128459_("cnt_life") * (double)45.0F)) * (double)1.0F * Math.min((double)3.0F * entity_size, (double)32.0F), entity);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_life") % (double)10.0F == (double)0.0F) {
                     if (entity.getPersistentData().m_128459_("cnt_life") == (double)200.0F) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, (int)((double)20.0F * CNT6 * entity_size), (double)2.0F * entity_size, (double)2.0F * entity_size, (double)2.0F * entity_size, (double)2.0F);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME.get(), x_pos, y_pos, z_pos, (int)((double)40.0F * CNT6 * entity_size), (double)1.0F * entity_size, (double)1.0F * entity_size, (double)1.0F * entity_size, (double)4.0F);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.8F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.8F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.9F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.9F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.9F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.9F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.8F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.8F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.9F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.9F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.8F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.8F, false);
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("Damage", (double)70.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)2.0F * CNT6);
                     entity.getPersistentData().m_128347_("Range", (double)6.0F * entity_size);
                     entity.getPersistentData().m_128347_("effect", (double)3.0F);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_life") <= (double)208.0F) {
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();

                     for(int index4 = 0; index4 < 36; ++index4) {
                        ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)4.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)8.0F, (double)16.0F), x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, z_pos, z_pos, "jujutsucraft:particle_flame");
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt_life") > (double)260.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
