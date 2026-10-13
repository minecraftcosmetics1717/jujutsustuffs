package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityDoorsEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SkillDoorsProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         Entity entity_a = null;
         boolean SUCCESS = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double rnd = (double)0.0F;
         double dis = (double)0.0F;
         double old_rnd = (double)0.0F;
         double NUM1 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var62 = ((Entity)var10000).m_20185_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               double var65 = ((Entity)var10001).m_20186_();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               var65 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var62, var65, ((Entity)var10002).m_20189_(), entity);
            }

            dis = (double)6.0F;

            for(int index0 = 0; index0 < 4; ++index0) {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                     SUCCESS = true;
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.75F;
                     z_pos = entityiterator.m_20189_();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += (double)6.0F;
            }

            int var67;
            label214: {
               entity.getPersistentData().m_128347_("x_pos", x_pos);
               entity.getPersistentData().m_128347_("y_pos", y_pos);
               entity.getPersistentData().m_128347_("z_pos", z_pos);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var67 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label214;
                  }
               }

               var67 = 0;
            }

            label209: {
               HP = (double)(50 + var67 * 5);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt29 = (LivingEntity)entity;
                  if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                     label204: {
                        rnd = (double)0.0F;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt31 = (LivingEntity)entity;
                           if (_livEnt31.m_21023_(MobEffects.f_19621_)) {
                              label199: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19621_)) {
                                       var64 = _livEnt.m_21124_(MobEffects.f_19621_).m_19564_();
                                       break label199;
                                    }
                                 }

                                 var64 = 0;
                              }

                              var63 = var64 + 2;
                              break label204;
                           }
                        }

                        var63 = 1;
                     }

                     NUM1 = (double)var63;
                     NUM1 += (double)(entity.getPersistentData().m_128459_("mode_hakari") != (double)1.0F && entity.getPersistentData().m_128459_("mode_hakari") != (double)2.0F ? 0 : 5);

                     for(int index1 = 0; index1 < (int)NUM1; ++index1) {
                        old_rnd = rnd;
                        rnd = Math.random();
                        if (rnd < 0.8) {
                           rnd = (double)1.0F;
                        } else if (rnd < 0.9) {
                           rnd = (double)2.0F;
                        } else if (rnd < 0.95) {
                           rnd = (double)3.0F;
                        } else {
                           if (!(rnd < 0.99)) {
                              rnd = (double)5.0F;
                              break;
                           }

                           rnd = (double)4.0F;
                        }

                        if (old_rnd > rnd) {
                           rnd = old_rnd;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt35 = (LivingEntity)entity;
                        if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity.getPersistentData().m_128459_("Reserve") == (double)0.0F) {
                           entity.getPersistentData().m_128347_("Reserve", (double)Math.round(rnd));
                        }
                     }
                     break label209;
                  }
               }

               rnd = (double)1.0F;
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOORS.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                  }

                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity46 = (LivingEntity)entityinstance;
                     if (_livingEntity46.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity46.m_21051_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  if (rnd == (double)1.0F) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_white");
                     }
                  } else if (rnd == (double)2.0F) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_green");
                     }
                  } else if (rnd == (double)3.0F) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_red");
                     }
                  } else if (rnd == (double)4.0F) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_gold");
                     }
                  } else if (rnd == (double)5.0F && entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_rainbow");
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity61 = (LivingEntity)entity;
               if (_livingEntity61.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity61.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-4.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
