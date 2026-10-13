package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SkillRantaEyeProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         String target_uuid = "";
         double x_center = (double)0.0F;
         double size = (double)0.0F;
         double z_center = (double)0.0F;
         double HP = (double)0.0F;
         double y_center = (double)0.0F;
         double dis = (double)0.0F;
         size = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity.getPersistentData().m_128459_("cnt2") % (double)10.0F == (double)1.0F) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var53 = ((Entity)var10000).m_20185_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               double var58 = ((Entity)var10001).m_20186_();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               var58 += (double)((Entity)var10002).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var53, var58, ((Entity)var10002).m_20189_(), entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }

            entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
            entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
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

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity25 = (LivingEntity)entity;
            if (_livingEntity25.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity25.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-4.0F);
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity26 = (LivingEntity)entity;
            if (_livingEntity26.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
               _livingEntity26.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            dis = (double)6.0F;

            for(int index0 = 0; index0 < 8; ++index0) {
               x_center = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_center = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_center = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
               Vec3 _center = new Vec3(x_center, y_center, z_center);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                     SUCCESS = true;
                     x_center = entityiterator.m_20185_();
                     y_center = entityiterator.m_20186_();
                     z_center = entityiterator.m_20189_();
                     target_uuid = entityiterator.m_20149_();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += (double)6.0F;
            }

            double var54;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var54 = (double)_livEnt.m_21233_();
            } else {
               var54 = (double)-1.0F;
            }

            HP = var54;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_EYE_RANTA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_center, y_center, z_center), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.getPersistentData().m_128359_("TARGET", target_uuid);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(0.0F);
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
                     LivingEntity _livingEntity47 = (LivingEntity)entityinstance;
                     if (_livingEntity47.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity47.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)1.5F);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity50 = (LivingEntity)entityinstance;
                     if (_livingEntity50.m_21204_().m_22171_(Attributes.f_22284_)) {
                        double var60;
                        label201: {
                           var55 = _livingEntity50.m_21051_(Attributes.f_22284_);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity48 = (LivingEntity)entity;
                              if (_livingEntity48.m_21204_().m_22171_(Attributes.f_22284_)) {
                                 var60 = _livingEntity48.m_21051_(Attributes.f_22284_).m_22135_();
                                 break label201;
                              }
                           }

                           var60 = (double)0.0F;
                        }

                        var55.m_22100_(var60);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity53 = (LivingEntity)entityinstance;
                     if (_livingEntity53.m_21204_().m_22171_(Attributes.f_22285_)) {
                        double var61;
                        label190: {
                           var56 = _livingEntity53.m_21051_(Attributes.f_22285_);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity51 = (LivingEntity)entity;
                              if (_livingEntity51.m_21204_().m_22171_(Attributes.f_22285_)) {
                                 var61 = _livingEntity51.m_21051_(Attributes.f_22285_).m_22135_();
                                 break label190;
                              }
                           }

                           var61 = (double)0.0F;
                        }

                        var56.m_22100_(var61);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity56 = (LivingEntity)entityinstance;
                     if (_livingEntity56.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity56.m_21051_(Attributes.f_22276_).m_22100_(HP * (double)(entity instanceof Player ? 5 : 1));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     float var62;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var62 = _livEnt.m_21223_();
                     } else {
                        var62 = -1.0F;
                     }

                     _entity.m_21153_(var62 * (float)(entity instanceof Player ? 5 : 1));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt61 = (LivingEntity)entity;
                     if (_livEnt61.m_21023_(MobEffects.f_19606_) && entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var63;
                           MobEffect var10003;
                           int var10005;
                           label176: {
                              var63 = new MobEffectInstance;
                              var10003 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label176;
                                 }
                              }

                              var10005 = 0;
                           }

                           var63.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                           _entity.m_7292_(var63);
                        }
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 10, 9, false, false));
                     }
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            entity.getPersistentData().m_128379_("PRESS_Z", true);
         } else if (!(entity instanceof Player)) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
         }

         if (entity.getPersistentData().m_128459_("cnt2") >= (double)200.0F) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
         }

         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt3", Math.min(entity.getPersistentData().m_128459_("cnt3"), (double)20.0F));
         }

         ChargeParticleProcedure.execute(world, entity, (double)0.0F);
         if (entity.getPersistentData().m_128459_("cnt3") > (double)20.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
