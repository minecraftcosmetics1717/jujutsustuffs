package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SummonGreatSerpentProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         double dis = (double)0.0F;
         double HP = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var59 = ((Entity)var10000).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var59 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var60;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var60 = _mobEnt.m_5448_();
               } else {
                  var60 = null;
               }

               z_pos = ((Entity)var60).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            dis = (double)6.0F;

            for(int index0 = 0; index0 < 8; ++index0) {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                     SUCCESS = true;
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                     z_pos = entityiterator.m_20189_();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += (double)6.0F;
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);

            for(int index1 = 0; index1 < 255; ++index1) {
               if (world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() || entity.getPersistentData().m_128459_("y_pos") < (double)0.0F) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (double)12.0F);
                  break;
               }

               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (double)1.0F);
            }
         }

         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 60, (double)0.75F, (double)0.0F, (double)0.75F, (double)0.0F);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity42 = (LivingEntity)entity;
               if (_livingEntity42.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity42.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)20.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 60, (double)0.5F, (double)1.0F, (double)0.5F, (double)0.0F);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 60, (double)0.5F, (double)1.0F, (double)0.5F, (double)0.25F);
            }

            if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.GREAT_SERPENT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  label178: {
                     label245: {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.getPersistentData().m_128347_("skill", (double)1.0F);
                        entityinstance.getPersistentData().m_128347_("mode", (double)1.0F);
                        entityinstance.getPersistentData().m_128347_("cnt1", (double)3.0F);
                        entityinstance.getPersistentData().m_128347_("cnt2", (double)1.0F);
                        entityinstance.getPersistentData().m_128347_("friend_num2", entity.getPersistentData().m_128459_("friend_num"));
                        entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                        if (entity.getPersistentData().m_128459_("TenShadowsTechnique5") != (double)1.0F) {
                           if (!(entity instanceof ServerPlayer)) {
                              break label245;
                           }

                           ServerPlayer _plr67 = (ServerPlayer)entity;
                           if (!(_plr67.m_9236_() instanceof ServerLevel) || !_plr67.m_8960_().m_135996_(_plr67.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_great_serpent"))).m_8193_()) {
                              break label245;
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                        entityinstance.getPersistentData().m_128379_("Ambush", true);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity78 = (LivingEntity)entityinstance;
                           if (_livingEntity78.m_21204_().m_22171_(Attributes.f_22281_)) {
                              AttributeInstance var61;
                              double var62;
                              label165: {
                                 var61 = _livingEntity78.m_21051_(Attributes.f_22281_);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity74 = (LivingEntity)entityinstance;
                                    if (_livingEntity74.m_21204_().m_22171_(Attributes.f_22281_)) {
                                       var62 = _livingEntity74.m_21051_(Attributes.f_22281_).m_22115_();
                                       break label165;
                                    }
                                 }

                                 var62 = (double)0.0F;
                              }

                              double var10002;
                              label160: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livingEntity75 = (LivingEntity)entity;
                                    if (_livingEntity75.m_21204_().m_22171_(Attributes.f_22281_)) {
                                       var10002 = _livingEntity75.m_21051_(Attributes.f_22281_).m_22115_();
                                       break label160;
                                    }
                                 }

                                 var10002 = (double)0.0F;
                              }

                              int var10003;
                              label155: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label155;
                                    }
                                 }

                                 var10003 = 0;
                              }

                              var61.m_22100_(var62 + (var10002 + (double)(var10003 * 3)) * (double)0.5F);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var63;
                              MobEffect var64;
                              int var10005;
                              label144: {
                                 var63 = new MobEffectInstance;
                                 var64 = MobEffects.f_19606_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                       var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                       break label144;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var63.<init>(var64, Integer.MAX_VALUE, Math.max(var10005, 1), false, false);
                              _entity.m_7292_(var63);
                           }
                        }

                        entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                        entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                        entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                        break label178;
                     }

                     entityinstance.getPersistentData().m_128359_("TARGET_UUID", entity.m_20149_());
                  }

                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().m_128347_("BaseCursePower", entity.getPersistentData().m_128459_("cnt10"));
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            entity.getPersistentData().m_128347_("TenShadowsTechnique5", (double)-1.0F);
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
