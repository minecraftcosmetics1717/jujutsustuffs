package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade112Entity;
import net.mcreator.jujutsucraft.entity.EntityCrystalEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class Crystal3Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double cnt6 = (double)0.0F;
         double x_target = (double)0.0F;
         double distance = (double)0.0F;
         double picth = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw = (double)0.0F;
         double speed = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double dis = (double)0.0F;
         Entity target_entity = null;
         String stt1 = "";
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         cnt6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var48 = var10000;
         if (var48 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var48).m_20185_(), ((Entity)var48).m_20186_() + (double)((Entity)var48).m_20206_() * (double)0.5F, ((Entity)var48).m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)0.0F) {
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            picth = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(picth) * (double)-1.0F * ((double)1.5F + (double)entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.2);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, (double)0.5F);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
               }

               if (entity instanceof Player) {
                  ChangeCurseEnergyProcedure.execute(entity, (double)-1.0F);
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }
            }

            if (var48 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)8.0F && (((Entity)var48).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var48).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var48).getPersistentData().m_128471_("attack") || ((Entity)var48).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)0.0F));
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity51 = (LivingEntity)entity;
                  if (_livingEntity51.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity51.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity52 = (LivingEntity)entity;
                  if (_livingEntity52.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity52.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
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

            int var10001;
            label166: {
               entity.getPersistentData().m_128347_("x_pos", x_pos);
               entity.getPersistentData().m_128347_("y_pos", y_pos);
               entity.getPersistentData().m_128347_("z_pos", z_pos);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label166;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(20 + var10001 * 4);
            speed = (double)6.5F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1);

            for(int index1 = 0; index1 < 1; ++index1) {
               x_pos = entity.getPersistentData().m_128459_("x_pos") + Mth.m_216263_(RandomSource.m_216327_(), (double)-8.0F, (double)8.0F);
               y_pos = entity.getPersistentData().m_128459_("y_pos") + (double)16.0F;
               z_pos = entity.getPersistentData().m_128459_("z_pos") + Mth.m_216263_(RandomSource.m_216327_(), (double)-8.0F, (double)8.0F);
               String var72;
               if (entity instanceof CursedSpiritGrade112Entity) {
                  CursedSpiritGrade112Entity animatable = (CursedSpiritGrade112Entity)entity;
                  var72 = animatable.getTexture();
               } else {
                  var72 = "null";
               }

               stt1 = var72;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRYSTAL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
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
                        LivingEntity _livingEntity84 = (LivingEntity)entityinstance;
                        if (_livingEntity84.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity84.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity88 = (LivingEntity)entityinstance;
                        if (_livingEntity88.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity88.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)4.0F);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", (double)5.0F + entity.getPersistentData().m_128459_("cnt6"));
                     entityinstance.getPersistentData().m_128347_("x_power", (double)0.0F * speed);
                     entityinstance.getPersistentData().m_128347_("y_power", (double)-1.0F * speed);
                     entityinstance.getPersistentData().m_128347_("z_power", (double)0.0F * speed);
                     if (entityinstance instanceof EntityCrystalEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "fall");
                     }

                     if (entityinstance instanceof EntityCrystalEntity) {
                        EntityCrystalEntity _datEntSetL = (EntityCrystalEntity)entityinstance;
                        _datEntSetL.m_20088_().m_135381_(EntityCrystalEntity.DATA_fall, true);
                     }

                     if (entity instanceof CursedSpiritGrade112Entity && entityinstance instanceof EntityCrystalEntity) {
                        EntityCrystalEntity animatable = (EntityCrystalEntity)entityinstance;
                        animatable.setTexture(stt1);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
