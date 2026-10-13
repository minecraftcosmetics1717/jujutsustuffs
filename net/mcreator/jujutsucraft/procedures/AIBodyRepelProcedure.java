package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBodyRepelProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double num1 = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double num4 = (double)0.0F;
         double num3 = (double)0.0F;
         double num2 = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.m_6084_()) {
            double var10000;
            label239: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity2.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                     break label239;
                  }
               }

               var10000 = (double)0.0F;
            }

            if (var10000 < entity.getPersistentData().m_128459_("size") && entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  label232: {
                     var81 = _livingEntity6.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity4 = (LivingEntity)entity;
                        if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity4.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label232;
                        }
                     }

                     var10001 = (double)0.0F;
                  }

                  var81.m_22100_(Math.min(var10001 + 0.2, entity.getPersistentData().m_128459_("size")));
               }
            }

            if (entity.getPersistentData().m_128459_("move") == (double)1.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") < (double)35.0F * CNT6) {
                  AIFistProcedure.execute(world, entity);
               } else {
                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
                  entity.m_146922_(entity.m_146908_());
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

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:0b}");
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") >= (double)140.0F && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               if (entity.getPersistentData().m_128459_("cnt1") <= (double)40.0F) {
                  num1 = (double)(entity.m_146908_() % 360.0F);
                  num3 = (double)entity.m_146909_();
                  RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * (double)999.0F, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * (double)999.0F, entity.m_20189_() + entity.m_20184_().m_7094_() * (double)999.0F, entity);
                  num2 = num1 - (double)entity.m_146908_();
                  num4 = num3 - (double)entity.m_146909_();
                  entity.m_146922_((float)(num1 + Math.min((double)8.0F, Math.abs(num2)) * (double)((!(Math.abs(num2) > (double)180.0F) || !(num2 < (double)0.0F)) && (!(Math.abs(num2) <= (double)180.0F) || !(num2 > (double)0.0F)) ? 1 : -1)));
                  entity.m_146926_((float)(num3 + Math.min((double)8.0F, Math.abs(num4)) * (double)(num4 < (double)0.0F ? -1 : 1)));
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  BulletDomainHit2Procedure.execute(world, entity);
                  x_power = entity.getPersistentData().m_128459_("x_power");
                  y_power = entity.getPersistentData().m_128459_("y_power");
                  z_power = entity.getPersistentData().m_128459_("z_power");
                  if (!(entity.getPersistentData().m_128459_("cnt1") <= (double)12.0F)) {
                     x_power = entity.getPersistentData().m_128459_("x_pos") * (double)1.0F;
                     y_power = entity.getPersistentData().m_128459_("y_pos") * (double)1.0F;
                     z_power = entity.getPersistentData().m_128459_("z_pos") * (double)1.0F;
                  } else {
                     if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                           LivingEntity var82;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var82 = _mobEnt.m_5448_();
                           } else {
                              var82 = null;
                           }

                           if (var82 instanceof LivingEntity) {
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var82 = _mobEnt.m_5448_();
                              } else {
                                 var82 = null;
                              }

                              x_pos = ((Entity)var82).m_20185_();
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var82 = _mobEnt.m_5448_();
                              } else {
                                 var82 = null;
                              }

                              double var85 = ((Entity)var82).m_20186_();
                              LivingEntity var87;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var87 = _mobEnt.m_5448_();
                              } else {
                                 var87 = null;
                              }

                              y_pos = var85 + (double)((Entity)var87).m_20206_() * (double)0.75F;
                              LivingEntity var86;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var86 = _mobEnt.m_5448_();
                              } else {
                                 var86 = null;
                              }

                              z_pos = ((Entity)var86).m_20189_();
                           } else {
                              x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                              y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                              z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                           }
                        }
                     }

                     distance = (double)8.0F * ReturnEntitySizeProcedure.execute(entity);
                     Vec3 _center = new Vec3(entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + Math.sin(pitch) * (double)-1.0F * distance, entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)2.0F * distance / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           x_pos = entityiterator.m_20185_();
                           y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                           z_pos = entityiterator.m_20189_();
                           break;
                        }
                     }

                     num1 = (double)(entity.m_146908_() % 360.0F);
                     num3 = (double)entity.m_146909_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
                     entity.m_146922_((float)num1);
                     entity.m_146926_((float)num3);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * 0.8) {
                        x_power = entity.m_20184_().m_7096_() - 0.175;
                     } else {
                        x_power = entity.m_20184_().m_7096_() + 0.175;
                     }

                     if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * 0.8) {
                        y_power = entity.m_20184_().m_7098_() - 0.175;
                     } else {
                        y_power = entity.m_20184_().m_7098_() + 0.175;
                     }

                     if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * 0.8) {
                        z_power = entity.m_20184_().m_7094_() - 0.175;
                     } else {
                        z_power = entity.m_20184_().m_7094_() + 0.175;
                     }

                     entity.getPersistentData().m_128347_("x_pos", x_power);
                     entity.getPersistentData().m_128347_("y_pos", y_power);
                     entity.getPersistentData().m_128347_("z_pos", z_power);
                  }

                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  if (dis > (double)0.0F && dis < 0.8) {
                     x_power *= 0.8 / dis;
                     y_power *= 0.8 / dis;
                     z_power *= 0.8 / dis;
                  }

                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();

                  for(int index0 = 0; index0 < 1; ++index0) {
                     entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                     entity.getPersistentData().m_128347_("Range", (double)(1.0F + entity.m_20205_()));
                     entity.getPersistentData().m_128347_("effect", (double)1.0F);
                     if (!entity.getPersistentData().m_128471_("Stop")) {
                        yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                        pitch = Math.toRadians((double)entity.m_146909_());
                        distance = (double)entity.m_20205_() * (double)0.5F;
                        RangeAttackProcedure.execute(world, entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * (double)-1.0F * distance, entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance, entity);
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                     if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos))) {
                        entity.getPersistentData().m_128379_("Stop", false);
                     } else {
                        entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)8.0F);
                        if (!entity.getPersistentData().m_128471_("Stop")) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                              }
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 8, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 8, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                           }

                           entity.getPersistentData().m_128347_("BlockRange", (double)1.5F * ReturnEntitySizeProcedure.execute(entity));
                           entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * CNT6);
                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos, entity);
                           if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos))) {
                              entity.getPersistentData().m_128379_("Stop", true);
                              break;
                           }
                        }
                     }
                  }
               } else {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:0b}");
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") >= (double)140.0F && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(4.0F * entity.m_20206_() * entity.m_20205_() * entity.m_20205_()), 0.2 * (double)entity.m_20205_(), 0.2 * (double)entity.m_20206_(), 0.2 * (double)entity.m_20205_(), (double)1.0F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)((double)0.5F + Math.random()));
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)((double)0.5F + Math.random()), false);
               }
            }

            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         }

      }
   }
}
