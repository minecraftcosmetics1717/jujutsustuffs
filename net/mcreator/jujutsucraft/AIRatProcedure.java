package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CockroachesEntity;
import net.mcreator.jujutsucraft.entity.EntityTsuchigumoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AIRatProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         boolean logic_a = false;
         double rnd = (double)0.0F;
         double speed = (double)0.0F;
         double lv_df = (double)0.0F;
         double lv_st = (double)0.0F;
         double entity_size = (double)0.0F;
         if (entity instanceof EntityTsuchigumoEntity) {
            AIShikigamiProcedure.execute(world, x, y, z, entity);
         } else {
            entity_size = ReturnEntitySizeProcedure.execute(entity);
            speed = (double)0.5F;
            if (entity.m_6084_()) {
               label121: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt2 = (LivingEntity)entity;
                     if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                        break label121;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), Integer.MAX_VALUE, 9, false, false));
                     }
                  }
               }

               label116: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label116;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19597_);
                  }
               }

               label111: {
                  AIActiveProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                        break label111;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 1, false, false));
                     }
                  }
               }

               label106: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                        break label106;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 0, false, false));
                     }
                  }
               }

               if (LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
                  owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (owner_uuid instanceof LivingEntity) {
                     if (entity.getPersistentData().m_128459_("skill") > (double)-900.0F) {
                        entity.getPersistentData().m_128347_("skill", (double)2306.0F);
                        entity.getPersistentData().m_128347_("Damage", (double)6.0F);
                        entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20205_()));
                        entity.getPersistentData().m_128347_("knockback", 0.1);
                        entity.getPersistentData().m_128347_("effect", (double)1.0F);
                        RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), entity);
                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                        entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
                        if (entity.getPersistentData().m_128459_("cnt_life") > (double)120.0F && !entity.m_9236_().m_5776_()) {
                           entity.m_146870_();
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("skill") > (double)-900.0F && entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.m_20096_()) {
                        entity.getPersistentData().m_128347_("cnt_x", Math.random() * (double)5.0F);
                        if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                           if (entity.getPersistentData().m_128459_("friend_num") == owner_uuid.getPersistentData().m_128459_("friend_num")) {
                              logic_a = true;
                              LivingEntity var10000;
                              if (owner_uuid instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_uuid;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity && owner_uuid.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
                                 CompoundTag var35 = entity.getPersistentData();
                                 LivingEntity var10002;
                                 if (owner_uuid instanceof Mob) {
                                    Mob _mobEnt = (Mob)owner_uuid;
                                    var10002 = _mobEnt.m_5448_();
                                 } else {
                                    var10002 = null;
                                 }

                                 var35.m_128347_("x_pos", ((Entity)var10002).m_20185_());
                                 var35 = entity.getPersistentData();
                                 if (owner_uuid instanceof Mob) {
                                    Mob _mobEnt = (Mob)owner_uuid;
                                    var10002 = _mobEnt.m_5448_();
                                 } else {
                                    var10002 = null;
                                 }

                                 var35.m_128347_("y_pos", ((Entity)var10002).m_20186_());
                                 var35 = entity.getPersistentData();
                                 if (owner_uuid instanceof Mob) {
                                    Mob _mobEnt = (Mob)owner_uuid;
                                    var10002 = _mobEnt.m_5448_();
                                 } else {
                                    var10002 = null;
                                 }

                                 var35.m_128347_("z_pos", ((Entity)var10002).m_20189_());
                              } else {
                                 entity.getPersistentData().m_128347_("x_pos", (double)owner_uuid.m_9236_().m_45547_(new ClipContext(owner_uuid.m_20299_(1.0F), owner_uuid.m_20299_(1.0F).m_82549_(owner_uuid.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, owner_uuid)).m_82425_().m_123341_());
                                 entity.getPersistentData().m_128347_("y_pos", (double)owner_uuid.m_9236_().m_45547_(new ClipContext(owner_uuid.m_20299_(1.0F), owner_uuid.m_20299_(1.0F).m_82549_(owner_uuid.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, owner_uuid)).m_82425_().m_123342_());
                                 entity.getPersistentData().m_128347_("z_pos", (double)owner_uuid.m_9236_().m_45547_(new ClipContext(owner_uuid.m_20299_(1.0F), owner_uuid.m_20299_(1.0F).m_82549_(owner_uuid.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, owner_uuid)).m_82425_().m_123343_());
                              }
                           }

                           if (logic_a) {
                              RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                              GetPowerForwardProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                              if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)4.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                                 entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), (double)0.5F * ((double)1.0F / speed)));
                              }

                              entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, Math.max(entity.getPersistentData().m_128459_("y_power") * speed, entity instanceof CockroachesEntity ? 0.1 : (double)0.25F), entity.getPersistentData().m_128459_("z_power") * speed));
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
