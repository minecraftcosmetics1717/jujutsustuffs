package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class UroCounterProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         Entity target_entity = null;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         double speed = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double num3 = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double dis = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double counter_radius = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
               return;
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var43 = var10000;
         if (var43 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var43).m_20185_(), ((Entity)var43).m_20186_() + (double)((Entity)var43).m_20206_() * (double)0.5F, ((Entity)var43).m_20189_(), entity);
         }

         yaw = (double)entity.m_146908_();
         pitch = (double)entity.m_146909_();
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

         logic_a = false;
         counter_radius = (double)(12.0F + Math.max(entity.m_20205_() * 2.0F, entity.m_20206_() * 2.0F) * 2.0F);
         Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(counter_radius / (double)2.0F), (e) -> true)) {
            if ((entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entityiterator instanceof Projectile) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move"))) && !(entityiterator.m_20205_() * entityiterator.m_20205_() + entityiterator.m_20206_() > (entity.m_20205_() * entity.m_20205_() + entity.m_20206_()) * 8.0F)) {
               logic_a = true;
               entityiterator.getPersistentData().m_128379_("betrayal", true);
               if (entityiterator instanceof Projectile && entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  if (entity instanceof LivingEntity) {
                     _projEnt.m_5602_((LivingEntity)entity);
                  }
               }

               if (entity instanceof Player) {
                  logic_b = entity.m_6144_();
               } else {
                  label169: {
                     logic_b = entity.getPersistentData().m_128459_("cnt_uro") < (double)15.0F;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var72 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19557_();
                           break label169;
                        }
                     }

                     var72 = 0;
                  }

                  int var10001;
                  label164: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19557_();
                           break label164;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var72 < (var10001 > 10 ? 18 : 8)) {
                     logic_b = false;
                  }
               }

               speed = (double)3.0F;
               num1 = (double)(entity.m_146908_() % 360.0F);
               num2 = (double)(entityiterator.m_146908_() % 360.0F);
               num3 = Math.abs(num1 - num2);
               entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               if (logic_b || num3 > (double)135.0F && num3 < (double)315.0F) {
                  RotateEntityProcedure.execute(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.9, entity.m_20189_(), entityiterator);
                  entityiterator.m_146922_(entityiterator.m_146908_() + (float)(GetDistanceIteratorProcedure.execute(entity, entityiterator) > (double)5.0F ? 45 : 90));
                  entityiterator.m_146926_(entityiterator.m_146909_());
                  entityiterator.m_5618_(entityiterator.m_146908_());
                  entityiterator.m_5616_(entityiterator.m_146908_());
                  entityiterator.f_19859_ = entityiterator.m_146908_();
                  entityiterator.f_19860_ = entityiterator.m_146909_();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 20, 0, false, false));
                     }
                  }
               } else {
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entityiterator);
               }

               x_power = entityiterator.m_20154_().f_82479_ * speed;
               y_power = entityiterator.m_20154_().f_82480_ * speed;
               z_power = entityiterator.m_20154_().f_82481_ * speed;
               entityiterator.m_20256_(new Vec3(x_power, y_power, z_power));
               entityiterator.getPersistentData().m_128347_("x_power", x_power);
               entityiterator.getPersistentData().m_128347_("y_power", y_power);
               entityiterator.getPersistentData().m_128347_("z_power", z_power);
            }
         }

         if (entity instanceof Player) {
            entity.getPersistentData().m_128347_("cnt_uro", entity.getPersistentData().m_128459_("cnt_uro") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_uro") > (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt_uro", (double)-5.0F);
            } else {
               logic_a = false;
            }
         } else {
            if (logic_a) {
               entity.getPersistentData().m_128347_("cnt_uro", Math.max(entity.getPersistentData().m_128459_("cnt_uro"), (double)1.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 0));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 5, 9));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_uro") > (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt_uro", entity.getPersistentData().m_128459_("cnt_uro") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_uro") > (double)100.0F) {
                  entity.getPersistentData().m_128347_("cnt_uro", (double)0.0F);
               }
            }
         }

         if (logic_a) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 9));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity78 = (LivingEntity)entity;
               if (_livingEntity78.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity78.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-8.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity79 = (LivingEntity)entity;
               if (_livingEntity79.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity79.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)1.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
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
   }
}
